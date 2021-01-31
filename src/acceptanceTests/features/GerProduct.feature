@GetProduct
  Feature: Get Product

    Scenario Outline: Get Product By name
      Given I set the host with "http://localhost:8081"
      When I perform a GET request to the endpoint "/api/v1/products/product/<product>"
      Then I search the response and expect the "$.data.length()" has the value "2"
      Then I search the response and expect the "$.data[0].price" has the value "1.5"
      Examples:
      |product|
      |Ketchup|
      |Maionese|