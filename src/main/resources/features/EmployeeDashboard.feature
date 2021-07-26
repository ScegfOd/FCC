Feature: Employee Dashboard Feature
	Background:
    Given That I have logged in as an employee
		
  Scenario: An employee wishes to mark an order complete
    When I enter click on the topmost complete button
    Then I verify that there is one fewer order listed
    
  Scenario: An employee wishes to mark an order ready
    When I enter click on the topmost ready button
    Then I verify that there is one more order marked ready for pickup

