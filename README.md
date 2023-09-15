# Login Registration Backend 

Complete login registration backend system using Spring Boot.


- [x] Spring Boot
- [x] Spring Security
- [x] Java Mail
- [x] Email verification with expiry
- [x] Spring Boot

## Diagram
![Screenshot 2021-01-13 at 23 38 08](https://user-images.githubusercontent.com/40702606/104789980-15581a00-578e-11eb-998d-30f2e6a9f461.png)

## Email verification link with expiry
![Capture](https://github.com/HosamUsf/login-and-registration-tutorial/assets/57178026/1a12163b-625d-4bf4-8230-e48f473cb303)

## Example requests
### Postman
![Capture1](https://github.com/HosamUsf/login-and-registration-tutorial/assets/57178026/db30caec-c37b-4ce0-952b-bd8f32ff4c8e)

### CURL
```
curl --location --request POST 'localhost:8080/api/v1/registration' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName":"hosam",
    "lastName":"youssef",
    "email":"hosamyousse303f@gmail.com",
    "password":"P@SSWORD"
}'
```
