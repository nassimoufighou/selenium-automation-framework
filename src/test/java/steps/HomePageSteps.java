package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import pages.ShadyMeadows;
import pages.HomePage;
import utils.LoggerUtils;

public class HomePageSteps {

    private Logger logger = LoggerUtils.getLogger(HomePageSteps.class);
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
        homePage.selectStayDates(nights, fromOffset);
    }

    @When("I select an available room")
    public void iSelectA() {
        homePage.selectAvailableRoom();
    }
}
