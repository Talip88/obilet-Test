Feature: Register Functionality
  @Regression
  Scenario: Register with email and password
    Given Navigate to OBILET Homepage
    Then User should navigate Homepage successfully
    And  Click to Member Login Button
    When Enter email and password and click Register button
    Then User should register successfully