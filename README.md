# apiHomework
 
## Installation / running

    - Run tests: 
        - `mvn test –PallApiTests`
        
[API docs](https://www.javadoc.io/doc/io.rest-assured/rest-assured/3.2.0/io/restassured/RestAssured.html)
        
## CI/CD API tests integration

    - API tests deployed to a repository
    - New code changes pushed to the repository
    - New build process triggered
    - Backend deployed
    - API services deployed
    - API tests initiated
    - API tests
        -- successfully passed
            -- build successful/promoted
        -- unsuccessfully passed
            -- build failed
