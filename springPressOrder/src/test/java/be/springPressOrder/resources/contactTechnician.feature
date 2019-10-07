Feature: contact a technician

  I should be able to send a contact message to a technician and see the details after finalising

  Scenario: contact a technician
    Given I am on the page with a list of technicians
    When I click on contact next to an technician
    And I enter "Please help" on the next page
    And I press send
    Then I should see my message
    And The Technician should receive the message
    And I close my browser