Feature schedule press order

  It should be possible to schedule a press oder after scheduling a press order the details should be shown

  Scenario: schedule one pressorder
    Given I am on the page where I can select an unplanned order
    When I click on Schedule next to an pressoder
    And I select a machine in the next screen
    And I enter 01-01-2019 14:00 in the begin field
    And I enter 02-01-2019 14:00 in the end field
    And I enter 50 in de amount of fruit field
    And I press submit
    Then the pressorder should have the status plannend
    And I close the browser