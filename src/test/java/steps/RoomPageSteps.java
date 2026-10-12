package steps;

import cucumber.utils.DataTableHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.RoomPage;
import pages.ShadyMeadows;

public class RoomPageSteps {

    private RoomPage roomPage = ShadyMeadows.getInstance().roomPage();

    @And("I land in the room page")
    public void roomPage(){
        roomPage.waitForPageToBeLoaded();
    }

    @And("I select a date {int} days in the future for the booking")
    public void iSelectADate(int daysAhead) {
        roomPage.selectDate(daysAhead);
    }

    @And("I click the button to {word} the reservation process")
    public void clickReserveNow(String action) {
        if (action.equalsIgnoreCase("start")) roomPage.startReservation();
        else if (action.equalsIgnoreCase("finish")) roomPage.confirmReservation();
        else throw new IllegalArgumentException(String.format("%s action not recognized", action));
    }

    @And("I enter booking information:")
    public void enterBookingInformation(DataTable bookingInformation){
        int rowCount = DataTableHelper.rowCount(bookingInformation);
        for (int row = 0; row < rowCount; ++row) {
            String firstName = DataTableHelper.getColumnFromRow(bookingInformation, "FIRST_NAME", row);
            roomPage.enterFirstName(firstName);

            String lastName = DataTableHelper.getColumnFromRow(bookingInformation, "LAST_NAME", row);
            roomPage.enterLastName(lastName);

            String email = DataTableHelper.getColumnFromRow(bookingInformation, "EMAIL", row);
            roomPage.enterEmail(email);

            String phone = DataTableHelper.getColumnFromRow(bookingInformation, "PHONE", row);
            roomPage.enterPhone(phone);
        }
    }

    @Then("I get the booking confirmation with the booking dates")
    public void bookingConfirmation() {}
}
