# Quick startup of a backend for a fullstack application. 
*Uses SPA called rest-frontend-seed*
# Concepts and dist.

## Generics
* Generic CRUDS using composite repository pattern (data/repositories/genericRepositories)
* Generic Producer-Consumer solution (logic/producerConsumer)
* Generic DTO Mapper (rest/DTO)
* Generic Exception Mapper (rest/exceptions)
* Generic Rest-endpoints w/o relations (rest/genericRest)

## Examples
* User has BCrypt but is commented out for simplicity (data/entities/user)
* many-many example (data/entities/user)
* Producer/Consumer (logic/producerConsumer/fetchDataMultiThread) 


# EndPoints
https://fluffysnail.com/rest-api-seed/api/anyObject2 (GET)

## Auth Through endpoints
1. https://fluffysnail.com/rest-api-seed/api/login (POST)
* Body JSON <br />
  "username" : "admin" or "user"
  "password" : "test" or "test" <br />
 output: username & token
 
2. https://fluffysnail.com/rest-api-seed/api/info/admin (GET) <br />
   In Header add
   - key: x-access-token
   - value: output token value
   
# Tools
*For versions see build.gradle*
## General
* JPA Hibernate
* Java 
* Gradle
* MySQL 
* CORS

## Testing
* Derby 
* JUnit 
 
## Security
* BCrypt
* numse-jose (JWT)

