Feature: Employee Login Feature

  Scenario Outline: A user wishes to log in to via the employee portal
    Given That I am on the login page
    When I enter <id> for my username and <password> as my password and press enter
    Then I verify that the url of the page contains <expected_url>

    Examples: 
      | id                | password  | expected_url |
      | admin22           | password1 | fccm.html    |
      | admin87           | password1 | fccm.html    |
      | admin22           | oops      | fcc.html     |
      | empl13            | password1 | fcce.html    |
      | empl44            | password1 | fcce.html    |
      | empl13            | oops      | fcc.html     |
      | dknight84@att.net | password  | fcc.html     |
      | dknight84@att.net | oops      | fcc.html     |
