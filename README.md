# RecruitmentSystemApp

1. open cmd
2. cd c:/project (go to your project root folder) 
3. mvn clean install
4. mvn spring-boot:run 

The server will start on port 8080.

6. Swagger link:  http://localhost:8080/documentation/swagger-ui.html#/

Project included:
Main classes like Employee, Application, Candidate - CRUD and also additoionals usefull functions:

- user listings
- employee listing
- posibility of adding documents by the candidate to his account
 - posibility of adding savings to the candidate's balance,
- the function of adding an application to your account (only if a set of documents has been submitted and the account balance has sufficient funds),
- function of changing the status of the application submitted by the employee.

Kandydat chcąć brać udział w rekrutacji zakłada konto, aby spełnić wszyskite wymagania, 
musi dołączyć do swojego konta komplet dokumentów, jak i zasilić swoje konto (opłata za aplikacje, 
czy za studia niestacjonarne). Aplikując ma do wyboru kierunki studiów na które może się zapisać.
Aplikacje złożyć może wylko w chwili spełnienia wszystkich warunków : dostarczenie wszystkich wymaganych 
dokumentów oraz wystarczająca ilość środków na koncie. Po dostarczeniu aplikacji, w przypadku pozytywnego 
rozpatrzenia, pracownik ma możliwość zmiany statusu aplikacji.

