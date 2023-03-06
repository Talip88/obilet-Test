Feature: Search Flight Functionality
  @Regression
  Scenario: Search Flight
    Given Navigate to OBILET Homepage
    When Click flight button
    When Select a departure and arrival place and date of flight
    And  Click search flight button
    Then Choose one of flights and Control Ecofly, Click if it is exist
    And  Select a departure flight
    And  Select a return flight
    Then User should see payment page and check flights whether true or not


