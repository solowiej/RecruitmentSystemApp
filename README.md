# RecruitmentSystemApp

1. open cmd
2. cd c:/project (go to your project root folder) 
3. mvn clean install
4. mvn spring-boot:run 

The server will start on port 8080.
Swagger link:  http://localhost:8080/documentation/swagger-ui.html#/

Project included:
Main classes like Employee, Application, Candidate - CRUD and also additoionals usefull functions:

- user listings
- employee listing
- posibility of adding documents by the candidate to his account
 - posibility of adding savings to the candidate's balance,
- the function of adding an application to your account (only if a set of documents has been submitted and the account balance has sufficient funds),
- function of changing the status of the application submitted by the employee.

Candidates who want to participate in recruitment must set up a personal account and meet all procedural requirements such as assurance necessary documents or making payments (application fee, extramural studies, etc.). When applying for admission, a candidate may choose the fields of study to which he can enroll. Applications can be submitted only when all conditions are met. After delivery of the application, in the case of positive consideration, the employee can change the application status.


