# Quick startup of a backendfor a fullstack application. 

## Concepts and dist.
* uses Hibernate, a JPA implementation
* User has BCrypt but is commented out for simplicity (data/entities/user)
* Repository Pattern w. many-many example (data/entities/user)
* Generic CRUDS using composite repository pattern (data/repositories/genericRepositories)
* Generic Producer-Consumer solution (logic/producerConsumer)
* Generic DTO Mapper (rest/DTO)
* Generic Exception Mapper (rest/exceptions)
* Generic Rest-endpoints w/o relations (rest/genericRest)
* CORS (rest/cors)
* JWT-tokens (rest/security)
* Uses SPA called rest-frontend-seed


## EndPoints
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
