### Description
This project was created to show how to implement a readable e2e test for a project with microservices

This project contains two simple microservices created using Spring and one e2e test.

The e2e test was created using the following libraries: JUnit 5.9.0, Cucumber 7.10.0, Wiremock 2.35.0 and Awaitility 4.2.0

### Requirements
Java 17, Maven 3


### How to run the e2e test
1. Run UserService with 'e2e' Spring profile
2. Run PostService with 'e2e' Spring profile
3. Run the feature file e2e-tests/src/test/resources/features/e2e-test.feature

### How to run the e2e test from command line
1. Run UserService with 'e2e' Spring profile
2. Run PostService with 'e2e' Spring profile
3. Go to the e2e-tests module and run this:
> mvn clean install