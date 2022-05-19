# Spring secure JWM application

> Created for testing purpose

## How to use

1. Set up Postgres or MySQL database (Postgres db by default), all needed dependency already added, need only to
   uncomment/comment appropriate properties in src/main/resources/application.properties
2. Run spring service 
```bash
./gradlew :service:bootRun
```
```bash
./mvnw spring-boot:run -pl service
```
3. Run vue js UI:
```bash
./gradlew :frontend:clean build serve
```
```bash
./mvnw clean install npm:start -pl frontend
```

[//]: # (TOOD) add maven commands
4. Go to http://localhost:8081/ for UI or http://localhost:8080 for REST API


## References

[Spring Boot Token based Authentication with Spring Security & JWT](https://www.bezkoder.com/spring-boot-jwt-authentication/)

[Spring Boot + Vue.js: Authentication with JWT & Spring Security Example](https://www.bezkoder.com/spring-boot-vue-js-authentication-jwt-spring-security/)

[GitHub repository](https://github.com/bezkoder/spring-boot-spring-security-jwt-authentication)
