package steps;

import cucumber.utils.DataTableHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.RoomPage;
import pages.ShadyMeadows;
import utils.DateUtils;

public class RoomPageSteps extends BaseStep {

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
            if (firstName != null) roomPage.enterFirstName(firstName);

            String lastName = DataTableHelper.getColumnFromRow(bookingInformation, "LAST_NAME", row);
            if (lastName != null) roomPage.enterLastName(lastName);

            String email = DataTableHelper.getColumnFromRow(bookingInformation, "EMAIL", row);
            if (email != null) roomPage.enterEmail(email);

            String phone = DataTableHelper.getColumnFromRow(bookingInformation, "PHONE", row);
            if (phone != null) roomPage.enterPhone(phone);
        }
    }

    @Then("I get an error message because of the missing fields")
    public void isErrorMessageShown() throws InterruptedException {
        boolean isErrorMessageShown = roomPage.isErrorMessageShown();
        Thread.sleep(2000);
        Assert.assertTrue(isErrorMessageShown);
    }

    @Then("I get the booking confirmation with the booking dates")
    public void bookingConfirmation() {
        String[] bookingDates = roomPage.getBookingDates();
        String checkin = bookingDates[0];
        String checkout = bookingDates[1];

        String checkinFromTestData = DateUtils.formatDate(String.valueOf(getTestData(CHECKIN)), DateUtils.DD_MM_YYYY, DateUtils.YYYY_MM_DD);
        String checkoutFromTestData = DateUtils.formatDate(String.valueOf(getTestData(CHECKOUT)), DateUtils.DD_MM_YYYY, DateUtils.YYYY_MM_DD);

        Assert.assertNotNull(bookingDates);
        Assert.assertEquals(checkin, checkinFromTestData);
        Assert.assertEquals(checkout, checkoutFromTestData);
    }
}
