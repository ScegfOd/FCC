Feature: Manager Dashboard Feature
		
  Scenario: A manager wishes to mark an order cancelled
    Given That I have logged in as a manager
    When I enter click on the topmost cancel button
    Then I verify that there is fewer cancel button

