Feature: Login Feature

  Scenario Outline: Successful Login
    Given I am on the Restful booker platform login page
    When I enter <USER> as USER
    And I enter <PASSWORD> as password
    And I click on the login button
    Then I should be redirected to my dashboard

    Examples:
      | USER  | PASSWORD |
      | admin | password |

  Scenario Outline: Unsuccessful Login
    Given I am on the Restful booker platform login page
    When I enter <USER> as user
    And I enter <PASSWORD> as password
    And I click on the login button
    Then I should stay on the login page and see an error message

    Examples:
      | USER  | PASSWORD |
      | admin | pass     |
