MeLogin Platform is a spring boot project with Maven Dependency management.

Technology Used:
JDK: 17
Spring boot version: 3.0.8
Dependency management: Maven
Database : MySQL



Project Consists of :
User Registration with Email verification, 
Login and Logout,  
Validation in Registration Form 


How to start the project?
- Open or Import project on your favorite IDE (Please make sure it can run spring boot application)
- Check Spring Boot configuration file ( application.properties) for:
      - Database connection properties
      - Server Config, e.g. context path and port number
- Create an empty database name as test_db and import the. sql file
       -Mysql credential has been set as follow:
               Username:root
                Password:
(If your username and password is different than default, you can change the user name and password in application.properties file present in src/main/resource.)
- Build the project (If Build Automatically Not Set)
- Find a main class that is annotated with @SpringBootApplication
- Run as Java Application
- Open the browser and type “localhost:8080”  in url


An Important Note: 
To make the registration process a bit more authentic and secure, I have used my own Gmail account and created an App Password to implement the idea.
Since the project is locally run, make sure to open Gmail in the browser in order to verify your registration so, that you can go ahead with the login process.
 

