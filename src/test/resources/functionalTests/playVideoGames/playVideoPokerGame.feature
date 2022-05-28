Feature: Launch and play a Video Poker game Tests

  Scenario Outline: A user login MP brand successfully then play a Video Poker game
    Given MP brand is launched
    When User login with valid "<account>"
    And Launch "Bonus Deuces Wild Poker" Video Poker game
    Then User can play Video Poker game successfully

  Examples:
    |account|
    |day2@hn.com|