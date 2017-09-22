# Project Setup

- install mongodb, java 1.8
- decided to use Thymeleaf for frontend

# Structure

- RestController returns JSON Object
- Controller redirects to a view and uses models

# Project Launch

- sudo service mongod start
- launch server using maven

# Security

- Decided to strip out jwt business and just authenticate in a more normal way

- https://medium.com/@nydiarra/secure-a-spring-boot-rest-api-with-json-web-token-reference-to-angular-integration-e57a25806c50
- Sha256 Password Encoding
- Set up an authorization server for JWT tokens
- curl client:signingkey@localhost:3000/oauth/token -d grant_type=password -d username=user -d password=pwd returns a token
- having trouble using the auth token - issue is described in this stack overflow response

https://stackoverflow.com/questions/42822875/springboot-1-5-x-security-oauth2

- appears to work, but oauth is overriding web security config so can't reach permitall endpoints - the tokens work though

# Current State

- working on security integration for JWT
- you can access /photo
- need token for /api/**
- trying to figure out how to use mongo for generating the token