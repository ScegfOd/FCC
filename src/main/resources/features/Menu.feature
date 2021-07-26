Feature: Menu Feature
		
  Scenario: A user wishes to place an order
    Given That I am on the menu page
    When I enter click on an add to cart button
    And I click the cart button
    And I enter valid credit card information
    And I click checkout
    Then I verify that I get to the status page

