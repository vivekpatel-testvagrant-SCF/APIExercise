Exchange Rate API Test Automation Using Cucumber

This project aims to test Exchange Rate API using Java and RestAssured library.

Features:

BDD Approach: Tests are written in Gherkin syntax, making them readable and understandable by non-technical stakeholders.
Reusable Components: Framework is designed with reusable components like FrameworkConstants, ConfigProperties, and PropertyUtils.
Schema Validation: API response schema validation is implemented to ensure the response structure is as expected.
Easy Maintenance: The project structure is organized, making it easier to maintain and extend.
Test Descriptions:

testExchangeRateAPI: Fetches exchange rate data from the API and asserts various aspects of the response including success, status code, currency rates, response time, and currency pairs count.

Set Up Environment:

Ensure you have Java JDK installed on your system.
Install Apache Maven for managing dependencies.
IDE: IntelliJ IDEA or Eclipse (recommended).
Dependencies:

Cucumber for writing BDD style tests.
RestAssured for REST API testing.
TestNG for running tests.
Jackson for JSON serialization and deserialization.

Ensure Java and Maven are installed on your system.
Navigate to the project directory in the terminal.
Run mvn clean test command to execute the test cases.