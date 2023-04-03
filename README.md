
This assignment is created using Rest-assured with Java 17 to verify APIs provided by SaltoKS.  

## GOAL
The goal is to create test suites concerning end-user flow to ensure proper functionality.

[![Demo](http://img.youtube.com/vi/Y_Mwt5sDkvQ/0.jpg)](https://youtu.be/Y_Mwt5sDkvQ)

## System Design

The project uses the following software design patterns:
- Feature-based testing
- Builder pattern
- Base Test
- Request and Response Specification
- Test Data Factory

## Framework Overview

The project structure includes the following packages:

| Folder/File      | Description |
| ------ | ---------------- |
| `main`      | Includes *configs*, *util*, *features*, and *resources*.|
| `config`   | The class `ConfigManager` is the connection between the property files *url.properties* and *authorization.properties* located in `src/main/resources/`. <br> <br> The `@Config.Sources` load the properties file and matches the attributes with the *@Key*, so you automatically have the value.<br> <br> This strategy uses *Owner library*.  |
| `utils`   | Contains the commonSpecification and Rest-assured crud.   |
| `Features`   | Contains packages per feature that include *Authentication*, *Sites*, and *Access Group*. <br>Each feature has: <br><br>- `client`: The entry point to process CRUD request <br> <br> - `spec`: `requestSpecifications` extending `CommonSpec` <br> <br>- `dataFactory`: Test Data Factory classes use *java-faker* to generate fake data. <br>*Lombok* to create the objects using the Builder pattern. <br>It contains static data used across different tests. |
| `resources/api`   | Contains *swagger_spec.yaml* generated from provided swagger file (https://editor.swagger.io/).<br> <br> Models are generated using *open API generator* that helps throughout the project in creating request specs and response parsing.   |
| `test`  | Contains *project-specific-tests* and *BaseTest* class.   |
| `BaseTest`   | handles *authorization* and other common things as a pre-requisite for all the test classes.   |
| `resources`   | src/test/resources contains *suite.xml* to group test classes.   |


## Covered Test Scenarios

The project covers the following test scenarios:
- Verify the GET/sites.
- Verify the GET/sites/{{siteId}}.
- Verify the PATCH/sites/{{siteId}}.
- Verify the POST/sites/{{siteId}}/access_groups.

## Test Execution

1. Install java17 and set path in environment variable. IDE also uses Java17.
2. Add authentication parameters at src/main/resources/authorization.properties
3. Generate models from cmd using:  
  `./gradlew openApiGenerate`  
  Or by running Gradle task “openApiGenerate” inside build.gradle  
4. Tests can be run in the following ways:
- Run tests from the suite.xml. src/test/resources/suite.xml
- Run all E2E tests with the following command:  
`./gradlew test`
- Run individually from inside the class.

## Test Reports

Test results are generated using Allure Reports. 
After running tests:
1. The following command can be executed from cmd. It will open the report in the browser.  
`allure serve build/allure-results`  
(requires allure installation and environment variable setup)
2. It will generate the HTML report at build/reports/tests/test/index.html.  
`./gradlew allureReport`
3. Test artifacts are generated after each pipeline's success.

![allure](https://user-images.githubusercontent.com/25913495/229451787-b74f1b5b-34bb-43e5-bb7a-ee39b2450aa8.png)

## Continuous Integration Pipelines

The following steps are performed in CI pipelines:
- Run environment.
- Checkout Repo: Checks out the repository in the environment.
- Set up authentication secrets.
- Setup Java: Installs and configures Java 17.
- Cache the Gradle packages so that they don't need to be downloaded every time the workflow runs
- Generate swagger models.
- Build and run tests.
- Generate allure reports.
- Upload Test Results:
-  Upload the test results to the artifact store.

Tests are triggered in the following ways:
-   All tests: On commit to master branch

## Tools Used

The project was built using the following tools:
- Rest-Assured 
- TestNG
- Java 17
- Gradle
- Lombok
- Owner
- Java Faker
- Allure Report
- Open Api Generator
- Git for versioning control
- GitHub for CI/CD
- Supporting dependencies to consume swagger models.

## Future Enhancements

- Improved reporting and CI/CD
- Using tags to annotate/group test cases/classes/packages
- Cucumber
- Logs
