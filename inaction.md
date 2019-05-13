# SpringBoot Workshop - In Action

1. Spring Initializr
    - Gradle
    - JDK 11
    - Web
    - JPA
    - H2
    - Lombok
    
2. Find user by email
    - User
        - Non-final attributes
        - Lombok
    - UserService
        - Tony Stark
        - Steve Rogers
        - Bruce Banner
        - Thor Odinson
        - Clinton Barton
        - Natasha Romanoff
    - UserServiceTest

3. Endpoint to find user by email
    - UserController
    - Query param
    - Run main
    - Run with Gradle wrapper
    - Postman
    - Runtime exception
   
4. Error handling
    - HttpStatusException
    - ErrorMessage
    - ErrorHandler (RestControllerAdvice, ExceptionHandler)
   
5. Add more users
    - Collection on UserService
    - for
    - Run test
    - Java Stream API (filter, findFirst, Optional)

6. List users by last name
    - Add functionality to service
    - Test new functionality
    
7. List user emails by birthday month
    - Add birth date to users base
        - Stark: 1970-05-29
        - Rogers: 1018-07-04
        - Banner: 1969-12-18
        - Odinson: 1000-01-01
        - Barton: 1971-01-07
        - Romanoff: 1984-11-22
    - Add functionality to service
    - Test new functionality

8. Extract repository
    - Return User object only
    - Return Stream instead of Collection

9. Apply Spring DI
    - Turn service into a component
    - Inject service into controller
    - Turn repository into a component
    - Inject repository into service
    - Change test to use Mockito runner
    
10. Use Spring Data JPA
    - Add schema definition on data.sql
    - Annotated User entity
    - Transform repository to interface
        - Remove streams to simplify
        - Query by month not supported by query language
        - Fix test
    - Enable Spring repositories
    
11. Add basic CRUD to controller
    - Update does not override id or email
    - Introduce method reference
    - Return appropriate status code
    - POSTMAN
    - User id generate type as IDENTITY
    
12. Integration Tests
    - Add REST-assured to build.gradle
    - 
    