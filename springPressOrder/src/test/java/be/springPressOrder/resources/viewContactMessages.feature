Feature: View all contact message

  A technician should be able to see al his contact messages with details


  Scenario: A techicians wants to see more info about a message
    Given I am on the page where I can view all my messages
    When I click on view more next to a message
    Then I should see the following on the screen
      | Date         | x           |
      | message:      | please help            |

    And I close my browser



