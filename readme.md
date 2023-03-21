### Description
This project was created to show how to implement a readable e2e test for a project with microservices

This project contains two simple microservices created using Spring and one e2e test (created using Cucumber, Wiremock and Awaitility)


### Requirements
Java 17


### How to run the e2e test
1. Run UserService with 'e2e' Spring profile
2. Run PostService with 'e2e' Spring profile
3. Run the feature file e2e-tests/src/test/resources/features/e2e-test.feature