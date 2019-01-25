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
* Repository Pattern w. many-many example (data/entities/user)


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
## General
* JPA Hibernate
* Java v.8
* Gradle
* MySQL 
* CORS

## Testing
* Derby  
* JUnit

## Security
* BCrypt
* numse-jose (JWT)

