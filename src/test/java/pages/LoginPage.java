package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LoginPage extends ShadyMeadowsBasePage {

    public void waitForPageToBeLoaded() {
        By headerLocator = By.xpath("//h2[contains(text(), \"Login\")]");
        wait.until(presenceOfElementLocated(headerLocator));
    }

    public void enterUser(String user) {
        By userLocator = By.id("username");
        WebElement userInput = wait.until(presenceOfElementLocated(userLocator));
        userInput.sendKeys(user);
    }

    public void enterPassword(String password) {
        By passwordLocator = By.id("password");
        WebElement passwordInput = wait.until(presenceOfElementLocated(passwordLocator));
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        By loginButtonLocator = By.id("doLogin");
        WebElement loginButton = wait.until(presenceOfElementLocated(loginButtonLocator));
        loginButton.click();
    }

    public boolean isInvalidCredentialsMessageIsShown() {
        boolean isInvalidCredentialsMessageIsShown = true;
        try {
            By errorMessageLocator = By.xpath("//div[contains(@role, \"alert\")]");
            wait.until(presenceOfElementLocated(errorMessageLocator));
        }
        catch (TimeoutException timeoutException) {
            isInvalidCredentialsMessageIsShown = false;
        }
        return isInvalidCredentialsMessageIsShown;
    }
}
