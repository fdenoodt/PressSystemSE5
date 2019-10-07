Feature: Add Order

  It should be possible to add an order. Just after adding an order the details should be shown


  Scenario: Add one order
    Given I am on the page where I can add one Order
    When I enter 100 in the amount field
    And I enter "AppleJuice" in the juice field
    And I enter 2 in the client id field
    And I press submit
    Then I should see the following on the screen
      | label        | data           |
      | Amount:      | 100            |
      | Juice:       | AppleJuice     |
      | Status       | NotPlannend    |
      | ClientId:    | 2              |
    When I go to the page with a list of orders
    Then I should see a list cointaining "AppleJuice"
    And I close the browser
