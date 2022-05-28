Feature: Add Search and Delete book

  Scenario: Add book to your collection
    Given register new account
    And the user logs into application
    And the user is on Book Store page
    When the user selects a book "Git Pocket Guide"
#    And the user clicks on Add To Your Collection
#    Then an alert “Book added to your collection.” is shown
#    And book is shown in your profile
    And delete account
#
#  Scenario: Search book with multiple results
#    Given there are books named "Learning JavaScript Design Patterns" and "Designing Evolvable Web APIs with ASP.NET"
#    And the user is on Book Store page
#    When the user input book name “Design” or "design"
#    Then all books match with input criteria will be displayed.
#
#  Scenario: Delete book successfully
#    Given there is book named “Learning JavaScript Design Patterns”
#    And the user logs into application
#    And the user is on Profile page
#    When the user search book “Learning JavaScript Design Patterns”
#    And the user clicks on Delete icon
#    And the user clicks on OK button
#    And the user clicks on OK button of alert “Book deleted.”
#    And the book is not show


