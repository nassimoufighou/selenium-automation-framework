Feature: Create booking

  Scenario Outline: Successfully create a new booking
    Given I am on the Restful booker platform page
    When I select a <ROOM_TYPE> room
    And I land in the room page
    And I select a date 2 days in the future for the booking
    And I click the "Reserve now" button
    And I enter booking information:
      | FIRST_NAME | LAST_NAME  | EMAIL                        | PHONE           |
      | Oliver     | Hargreaves | oliver.hargreaves@mail.com   | +44 7700 900123 |
    And I click the "Reserve now" button
    Then I get the booking confirmation with the booking dates

    Examples:
      | ROOM_TYPE |
      | Single    |
      | Double    |
      | Suite     |