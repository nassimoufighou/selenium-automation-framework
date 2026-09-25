Feature: Login Feature

  Scenario Outline: Successful Login
    Given I am on the Restful booker platform page
    When I navigate to the Admin page
    And I enter "<USER>" in "Username"
    And I enter "<PASSWORD>" in "Password"
    And I click on the login button
    Then I should be redirected to my dashboard

    Examples:
      | USER  | PASSWORD |
      | admin | password |

  Scenario Outline: Unsuccessful Login
    Given I am on the Restful booker platform page
    And I enter "<USER>" in "Username"
    And I enter "<PASSWORD>" in "Password"
    And I click on the login button
    Then an error message should appear

    Examples:
      | USER  | PASSWORD |
      | admin | pass     |
