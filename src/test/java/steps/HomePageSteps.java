package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import utils.LoggerUtils;

public class HomePageSteps {

    private Logger logger = LoggerUtils.getLogger(HomePageSteps.class);
    
    @Given("I am on the Restful booker platform page")
    public void homePage(){
        logger.info("HOME PAGE");
    }

    @When("I navigate to the Admin page")
    public void navigateToAdminPage() {
        logger.info("NAVIGATE TO ADMIN PAGE");
    }
}
