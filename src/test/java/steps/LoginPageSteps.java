package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import utils.LoggerUtils;

public class LoginPageSteps {
    
    private Logger logger = LoggerUtils.getLogger(LoginPageSteps.class);
    
    @And("I enter {string} in \"Username\"")
    public void enterUser(String user) {
        logger.info(String.format("ENTER %s USER", user));
    }

    @And("I enter {string} in \"Password\"")
    public void enterPassword(String password) {
        logger.info(String.format("ENTER %s PASSWORD", password));
    }

    @And("I click on the login button")
    public void clickLoginButton() {
        logger.info("CLICK LOGIN BUTTON");
    }

    @Then("I should be redirected to my dashboard")
    public void redirectToDashboard() {
        logger.info("REDIRECT TO DASHBOARD");
    }

    @Then("an error message should appear")
    public void errorMessageShouldAppear() {
        logger.info("ERROR MESSAGE APPEARS");
    }
}
