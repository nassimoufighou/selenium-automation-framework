package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import pages.ShadyMeadows;
import pages.HomePage;
import utils.DateUtils;
import utils.LoggerUtils;

public class HomePageSteps extends BaseStep {

    private HomePage homePage = ShadyMeadows.getInstance().welcomePage();

    @Given("I am on the Restful booker platform page")
    public void homePage() {
        homePage.waitForPageToBeLoaded();
    }

    @When("I navigate to the Admin page")
    public void navigateToAdminPage() {
        homePage.gotoAdmin();
    }

    @When("I select a stay of {int} night starting {int} days from today")
    @When("I select a stay of {int} nights starting {int} days from today")
    public void selectDates(int nights, int fromOffset) {
        String checkinDate = DateUtils.dateInDays(fromOffset, DateUtils.DD_MM_YYYY);
        String checkoutDate = DateUtils.dateInDays(fromOffset + nights, DateUtils.DD_MM_YYYY);

        saveTestData(CHECKIN, checkinDate);
        saveTestData(CHECKOUT, checkoutDate);
        homePage.selectStayDates(checkinDate, checkoutDate);
    }

    @When("I select an available room")
    public void iSelectA() {
        homePage.selectAvailableRoom();
    }
}
