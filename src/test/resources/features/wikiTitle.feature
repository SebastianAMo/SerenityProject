Feature: Title Validation on Wikipedia

  Scenario: The user validates the title "Welcome to Wikipedia" on the homepage
    Given the user is on the Wikipedia homepage
    Then the user should see the title "Welcome to Wikipedia"
