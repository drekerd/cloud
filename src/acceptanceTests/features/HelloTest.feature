@HelloTest
Feature: HelloTest

  Scenario: Run Hello Controller
    Given I set the host with "http://localhost:8080"
    When I perform a GET request to the endpoint "/hello/helloWorld"
    Then I search the response and expect the "$.data" has the value "His"
    And I search the response and expect the "status" has the value "200"
