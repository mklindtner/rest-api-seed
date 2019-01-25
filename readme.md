# Quick startup of a backend for a fullstack application. 
*Uses SPA called rest-frontend-seed*
# Concepts and dist.

## Generics
* Generic CRUDS using composite repository pattern *data/repositories/genericRepositories*
* Generic Producer-Consumer solution *logic/producerConsumer*
* Generic DTO Mapper *rest/DTO*
* Generic Exception Mapper *rest/exceptions*
* Generic Rest-endpoints w/o relations *rest/genericRest*

## Examples
*anyObject is created automatically with Id's 1,2 and 3*
* User has BCrypt but is commented out for simplicity *data/entities/user*
* many-many example *data/entities/user*
  - One-many, One-One can be provided upon request
  - Inheritance(single table,table per class, joined or mapped superclass) using JPA can be provided upon request
* Producer/Consumer *logic/producerConsumer/fetchDataMultiThread*

# EndPoints
*example of an id would be to write "1" instead of id*
### Fetch object generated in database 
* https://fluffysnail.com/rest-api-seed/api/anyObject2 (GET, all)
* https://fluffysnail.com/rest-api-seed/api/anyObject2/id (GET)
* https://fluffysnail.com/rest-api-seed/api/anyObject2/id (DELETE)
* https://fluffysnail.com/rest-api-seed/id (PUT)
  Body Json
   - "nameString": "changedName"
### Fetch data from web with Producer/Consumer
*both get 5 json objects, first from startId, second is for pagination in backend* <br />
* https://fluffysnail.com/rest-api-seed/api/webdata/swapi/idStart (GET) 
* https://fluffysnail.com/rest-api-seed/api/webdata/swapi/pageNumber/type (GET) *ex. pageNumber=2, type=planets*
  

## Auth Through endpoints
1. https://fluffysnail.com/rest-api-seed/api/login (POST)
   Body Json <br />
    - "username" : "admin" or "user"
    - "password" : "test" or "test" <br /><br />
 *output:* username & token
 
2. https://fluffysnail.com/rest-api-seed/api/info/admin (GET) <br />
   In Header add
   - key: x-access-token
   - value: output token value
   
# Tools
*For versions see build.gradle*
## General
* JPA Hibernate / Java / Gradle / CORS
* MySQL 

## Testing
* Derby 
* JUnit 
 
## Security
* BCrypt
* numse-jose (JWT)

