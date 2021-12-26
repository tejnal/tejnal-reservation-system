### Tech stack 
Bootify, Spring boot, hibernate, 


-> Model classes present our data model 
-> Controllers will handle the requests that are passed to this controller by the request handler and return the corresponding views, in this case.
-> Services will hold the logic of our application. The best practice is to keep controllers thin by keeping the business logic in a separate place
-> Controllers should not interact with the repositories directly, but instead call the service which will interact with the repository.
