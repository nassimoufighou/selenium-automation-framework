package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class LoginPageSteps {

    @And("I enter {string} in \"Username\"")
    public void enterUser(String user) {
        System.out.println(String.format("ENTER %s USER", user));
    }

    @And("I enter {string} in \"Password\"")
    public void enterPassword(String password) {
        System.out.println(String.format("ENTER %s PASSWORD", password));
    }

    @And("I click on the login button")
    public void clickLoginButton() {
        System.out.println("CLICK LOGIN BUTTON");
    }

    @Then("I should be redirected to my dashboard")
    public void redirectToDashboard() {
        System.out.println("REDIRECT TO DASHBOARD");
    }

    @Then("an error message should appear")
    public void errorMessageShouldAppear() {
        System.out.println("ERROR MESSAGE APPEARS");
    }
}
