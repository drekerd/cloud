@GetProduct
Feature: Get Product

  Scenario Outline: Get Product By name
    Given I set the host with "http://localhost:8081"
    When I perform a GET request to the endpoint "/api/v1/products/product/<product>"
    Then I search the response and expect the "$.data.length()" has the value "<length>"
    Then I search the response and expect the "$..[?(@.name=='<product>')].price" has the value "[<price>]"
    Examples:
      | product  | price   | length |
      | Ketchup  | 1.5,1.6 | 2      |
      | Maionese | 1.3     | 1      |
      | Barbacue | 1.0     | 1      |