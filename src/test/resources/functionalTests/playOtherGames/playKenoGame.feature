Feature: Launch and play a Keno game Test

  Scenario Outline: A user login MP brand successfully then play a Keno game
    Given MP brand is launched
    When User login with valid "<account>"
    And Launch "Captain Keno" Keno game
    Then User can play Keno game successfully

  Examples:
    |account|
    |day@hn.com|