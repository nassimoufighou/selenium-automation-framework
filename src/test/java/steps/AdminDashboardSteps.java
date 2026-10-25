package steps;

import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import pages.AdminDashboardPage;
import pages.ShadyMeadows;
import utils.LoggerUtils;

public class AdminDashboardSteps extends BaseStep {

    private Logger logger = LoggerUtils.getLogger(HomePageSteps.class);

    @Then("I should be redirected to my dashboard")
    public void adminDashboardPage() {
        shadyMeadows.adminDashboardPage().waitForPageToBeLoaded();
    }
}
