# recruitment-system

1. open cmd
2. cd c:/project (go to your project root folder) 
3. mvn clean install
4. mvn spring-boot:run 

The server will start on port 8080.

6. Swagger link:  http://localhost:8080/documentation/swagger-ui.html#/

Projekt zawiera: 
Klasy główne: Employee, Application, Candidate, Application - funkcje CRUD jak i podstawowe funkcje użytkowe:
- listowanie użytkowników,
- listownie pracowników, 
- funkcja dodania dokumnetow przez kandydata do swojego konta, 
- funkcja dodania zasilenia salda kandydata, 
- funkcja dodanie aplikacji do swojego konta (tylko gdy został złożony komplet dokumentów 
oraz saldo konta posiada wystarczająca ilość środków),
- funkcja zmiany statusu złożonej aplikacji przez pracownika.

Kandydat chcąć brać udział w rekrutacji zakłada konto, aby spełnić wszyskite wymagania, 
musi dołączyć do swojego konta komplet dokumentów, jak i zasilić swoje konto (opłata za aplikacje, 
czy za studia niestacjonarne). Aplikując ma do wyboru kierunki studiów na które może się zapisać.
Aplikacje złożyć może wylko w chwili spełnienia wszystkich warunków : dostarczenie wszystkich wymaganych 
dokumentów oraz wystarczająca ilość środków na koncie. Po dostarczeniu aplikacji, w przypadku pozytywnego 
rozpatrzenia, pracownik ma możliwość zmiany statusu aplikacji.

