# CorrectionWebServiceJPA

This project expose JPA classes with a Rest web service.
Data are stored in a H2 SQL database. 

## Compatibility

Java 11

## The web service

https://github.com/charroux/CorrectionWebServiceJPA/blob/master/src/main/java/com/univ/CarRentalController.java

## The JPA class

https://github.com/charroux/CorrectionWebServiceJPA/blob/master/src/main/java/com/univ/Car.java

## Cross origin security

https://en.wikipedia.org/wiki/Cross-origin_resource_sharing

@CrossOrigin(origins = "http://localhost:4200") in https://github.com/charroux/CorrectionWebServiceJPA/blob/master/src/main/java/com/univ/CarRentalController.java

## Launching

Open the project inside Intellij or Import as Gradle project inside Eclipse

Run the main program: https://github.com/charroux/CorrectionWebServiceJPA/blob/master/src/main/java/com/univ/CorrectionWebServiceJpaApplication.java

## Test

http://localhost:8080/cars

