# Project Setup

- install mongodb, java 1.8
- decided to use Thymeleaf for frontend

# Good Tutorial for Thymeleaf

https://springframework.guru/spring-boot-web-application-part-4-spring-mvc/

# Structure

- RestController returns JSON Object
- Controller redirects to a view and uses models

# Project Launch

- sudo service mongod start
- launch server using maven

# Security

- Decided to strip out jwt business and use spring security default - passwords are still sha256 encrypted for new registered users

- https://medium.com/@nydiarra/secure-a-spring-boot-rest-api-with-json-web-token-reference-to-angular-integration-e57a25806c50
- Sha256 Password Encoding
- Set up an authorization server for JWT tokens
- curl client:signingkey@localhost:3000/oauth/token -d grant_type=password -d username=user -d password=pwd returns a token
- having trouble using the auth token - issue is described in this stack overflow response

https://stackoverflow.com/questions/42822875/springboot-1-5-x-security-oauth2

- appears to work, but oauth is overriding web security config so can't reach permitall endpoints - the tokens work though

# Current State

- security works fine for horse shoes and hand grenades
- redirect to login page except for home page
- need to make pages look much nicer...Bootstrap5