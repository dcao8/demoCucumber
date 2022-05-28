Feature: Launch and play a Video Slot game Tests

  Scenario Outline: A user login MP brand successfully then play a VideoSlot game
    Given MP brand is launched
    When User login with valid "<account>"
    And Launch "Arcadia" Video Slot game
    Then User can play Video Slot game successfully

  Examples:
    |account|
    |day1@hn.com|