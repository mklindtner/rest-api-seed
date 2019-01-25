# Quick startup of a backendfor a fullstack application. 

## Concepts
* using JPA - hibernate
* Generic CRUDS using composite repository pattern (DATA)
* Generic DTO Mapper (REST)
* Generic Rest-endpoints (REST)
* Generic Producer-Consumer solution (logic)*

Uses SPA called rest-frontend-seed

## in logic:
generic implementation of consumer-producer problem with examples included.


## EndPoints
https://fluffysnail.com/rest-api-seed/api/anyObject2 (GET)

## Auth Through endpoints

1. https://fluffysnail.com/rest-api-seed/api/login (POST)
* Body JSON
  "username" : "admin" or "user"
  "password" : "test" or "test"
 output: username & token
 
2.https://fluffysnail.com/rest-api-seed/api/info/admin (GET)
2.B) In Header add
   key: x-access-token
   value: output token value
