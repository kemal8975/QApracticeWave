Feature: User Registration with invalid input

  Scenario: Display appropriate error messages for invalid registration attempts
    Given I am on the registration page
    When I enter an invalid email and a valid password
    Then I should see an email error message

    When I enter a valid email and leave the password blank
    Then I should see an password required error message

    When I enter a valid email and a password less than six characters
    Then I should see an password must be six char long error message

    When I enter a valid email and a password with only numbers
    Then I should see error messages


    When I enter a valid email and a password with only letters
    Then I should see error messages

