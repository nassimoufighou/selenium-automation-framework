package steps;

import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import pages.AdminDashboardPage;
import pages.ShadyMeadows;
import utils.LoggerUtils;

public class AdminDashboardSteps {

    private Logger logger = LoggerUtils.getLogger(HomePageSteps.class);
    private AdminDashboardPage adminDashboardPage = ShadyMeadows.getInstance().adminDashboardPage();

    @Then("I should be redirected to my dashboard")
    public void adminDashboardPage() {
        adminDashboardPage.waitForPageToBeLoaded();
    }
}
