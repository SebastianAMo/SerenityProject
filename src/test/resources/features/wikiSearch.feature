Feature: Search and Validate Title on Wikipedia

  @wiki
  Scenario: The user searches for the word "Sistema" and validates "CEEM Analysis"
    Given the user "Sebas" is on the page "https://es.wikipedia.org/wiki/Wikipedia:Portada"
    When the user performs a search for the term "Sistema"
    And the user scrolls down to locate the section "Análisis CEEM"
    Then the title displayed should be "Análisis CEEM"
