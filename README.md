### Tech stack 
Bootify, Spring boot, hibernate, 


### reference: 
https://www.freecodecamp.org/news/spring-boot-tutorial-build-fast-modern-java-app/


-> Model classes present our data model 
-> Controllers will handle the requests that are passed to this controller by the request handler and return the corresponding views, in this case.
-> Services will hold the logic of our application. The best practice is to keep controllers thin by keeping the business logic in a separate place
-> Controllers should not interact with the repositories directly, but instead call the service which will interact with the repository.

## dev tips 
how to insert some data when there is no database integration yet?
CommandLineRunner bean to run the initial code. Whenever Spring Container finds a bean of type CommandLineRunner it will run the code inside it

Thymeleaf fragments allow us to create reusable component-like structures similar to React/Vue components 

We are updating our reservations controller to move the user object to the session because we want that to be accessible from another controller method 
