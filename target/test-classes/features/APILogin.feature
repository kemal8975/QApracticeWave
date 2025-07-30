Feature: Login to ENSEK API

  Scenario: Successful login returns access token
    Given I have valid login credentials
    When I send a POST request to the login endpoint
    Then the response should contain an access token
