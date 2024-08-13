Feature: Account Creation on Wikipedia

  Scenario: The user attempts to create an account without filling in the CAPTCHA
    Given the user is on the Wikipedia homepage
    When the user clicks on "Create an account"
    And the user fills in the form without filling in the CAPTCHA
    And the user clicks on "Create your account"
    Then the user should see the message "Please fill out this field" in the CAPTCHA field
