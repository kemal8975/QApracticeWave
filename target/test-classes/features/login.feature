Feature: Login Functionality

  Scenario: User logs in with valid credentials
    Given I am on the login page
    When I enter valid email and password
    And I click the login button
    Then I should be redirected to the homepage
