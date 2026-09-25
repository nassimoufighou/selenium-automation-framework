package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomePageSteps {

    @Given("I am on the Restful booker platform page")
    public void homePage(){
        System.out.println("HOME PAGE");
    }

    @When("I navigate to the Admin page")
    public void navigateToAdminPage() {
        System.out.println("NAVIGATE TO ADMIN PAGE");
    }
}
