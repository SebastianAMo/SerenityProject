Feature: Song Search on YouTube

  @youtube
  Scenario: The user searches for the song "Locked out of heaven" and validates the search result
    Given the user is on the YouTube homepage
    When the user searches for "Locked out of heaven"
    And the user selects the first result
    Then the user should see the video title as "Bruno Mars - Locked Out Of Heaven (Official Music Video)"
