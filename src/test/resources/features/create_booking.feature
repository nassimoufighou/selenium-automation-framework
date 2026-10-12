Feature: Create booking

  Scenario: Successfully create a new booking
    Given I am on the Restful booker platform page
    When I select a stay of 3 nights starting 2 days from today
    And I select an available room
    And I land in the room page
    And I click the button to start the reservation process
    And I enter booking information:
      | FIRST_NAME | LAST_NAME  | EMAIL                        | PHONE           |
      | Oliver     | Hargreaves | oliver.hargreaves@mail.com   | +44 7700 900123 |
    And I click the button to finish the reservation process
    Then I get the booking confirmation with the booking dates