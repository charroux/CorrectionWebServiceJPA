# CorrectionWebServiceJPA

This project expose JPA classes with a Rest web service.
Data are stored in a H2 SQL database. 

## Compatibility

Java 11

## The web service

https://github.com/charroux/CorrectionWebServiceJPA/blob/master/src/main/java/com/univ/CarRentalController.java

## The JPA class

https://github.com/charroux/CorrectionWebServiceJPA/blob/master/src/main/java/com/univ/Car.java

## The Database access

https://github.com/charroux/CorrectionWebServiceJPA/blob/master/src/main/java/com/univ/CarRepository.java

## Cross origin security

https://en.wikipedia.org/wiki/Cross-origin_resource_sharing

@CrossOrigin(origins = "http://localhost:4200") in https://github.com/charroux/CorrectionWebServiceJPA/blob/master/src/main/java/com/univ/CarRentalController.java

## Launching

Open the project inside Intellij or Import as Gradle project inside Eclipse

Run the main program: https://github.com/charroux/CorrectionWebServiceJPA/blob/master/src/main/java/com/univ/CorrectionWebServiceJpaApplication.java

## Check the database

Verify the database content using the H2 web console: http://localhost:8080/h2-console

Then modify the JDBC URL with the good one provided into the Eclipse or Intellij console. Here is an example: 

H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:dca7f3e9-95e2-425d-9ccf-c0aa71824aa1'

## Test

http://localhost:8080/cars

