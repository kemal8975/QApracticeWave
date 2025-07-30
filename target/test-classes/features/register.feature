Feature: User Registration with valid credentials

    Scenario: Successful registration using valid email and password
        Given I am on the registration page
        When I enter a valid email and password
        And I submit the registration form
        Then I should see a confirmation message
        And I should be redirected to the login page