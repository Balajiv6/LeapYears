# LeapYears
This is an Full Stack Spring Boot Application which determine whether the given year is Leap Year or not

User Story:
  As a user, I want to know if a year is a leap year, So that I can plan for an extra day on February 29th during those years.

Acceptance Criteria:
- All years divisible by 400 ARE leap years (so, for example, 2000 was indeed a leap year),
- All years divisible by 100 but not by 400 are NOT leap years (so, for example, 1700, 1800, and 1900 were NOT leap years, NOR will 2100 be a leap year),
- All years divisible by 4 but not by 100 ARE leap years (e.g., 2008, 2012, 2016),
- All years not divisible by 4 are NOT leap years (e.g. 2017, 2018, 2019).

# Goal:
 Need to determine whether the given year is leap year or not.

# Maven Commands to clean the project:
```bash
mvn clean
```
# Maven Commands to install the project:
```bash
mvn install
```

# Maven Commands to run the test:
```bash
mvn test
```

The Jacoco reports can be found in target folder as below.

```bash
target\site\jacoco\index.html
```

# Maven Commands to start the SpringBoot:
```bash
mvn spring-boot:run
```

# Swagger Url to view the Rest API Documentation
  This url will be available only after we start the Spring boot application using above command.
```bash
http://localhost:9080/bnppfortis/swagger-ui.html
```

Use the below creds to view the Swagger documentation

```bash
UserName: user
Password: password
```

# My solution
- Create a Spring boot Microservice Application.
- Add the Swagger documentation for the API created.
- Perform the Test Driven Develpoment to create a API.
- Test the API using the Swagger docs.
- Create a simple html5 with jquery which invokes the api and shows the result in ui.