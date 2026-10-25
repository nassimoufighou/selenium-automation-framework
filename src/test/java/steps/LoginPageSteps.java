package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.testng.Assert;
import pages.LoginPage;
import pages.ShadyMeadows;
import utils.LoggerUtils;

public class LoginPageSteps extends BaseStep {
    
    private Logger logger = LoggerUtils.getLogger(LoginPageSteps.class);

    @And("I am on the Login page")
    public void loginPage() {
        shadyMeadows.loginPage().waitForPageToBeLoaded();
    }

    @And("I enter {string} in \"Username\"")
    public void enterUser(String user) {
        shadyMeadows.loginPage().enterUser(user);
    }

    @And("I enter {string} in \"Password\"")
    public void enterPassword(String password) {
        shadyMeadows.loginPage().enterPassword(password);
    }

    @And("I click on the login button")
    public void clickLoginButton() {
        shadyMeadows.loginPage().clickLoginButton();
    }

    @Then("an \"Invalid credentials\" error message should appear")
    public void errorMessageShouldAppear() {
        boolean invalidCredentialsMessageIsShown = shadyMeadows.loginPage().isInvalidCredentialsMessageIsShown();
        Assert.assertTrue(invalidCredentialsMessageIsShown);
    }
}
