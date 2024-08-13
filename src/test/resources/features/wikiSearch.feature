Feature: Search and Validate Title on Wikipedia

  Scenario: The user searches for the word "System" and validates "CEEM Analysis"
    Given the user is on the Wikipedia homepage
    When the user searches for "System"
    And the user scrolls to find "CEEM Analysis"
    Then the user should see the title "CEEM Analysis"
