package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

@Component
public class LoginPage extends ShadyMeadowsBasePage {

    public void waitForPageToBeLoaded() {
        By headerLocator = By.xpath("//h2[contains(text(), \"Login\")]");
        waitUntil(presenceOfElementLocated(headerLocator));
    }

    public void enterUser(String user) {
        By userLocator = By.id("username");
        WebElement userInput = waitUntil(presenceOfElementLocated(userLocator));
        userInput.sendKeys(user);
    }

    public void enterPassword(String password) {
        By passwordLocator = By.id("password");
        WebElement passwordInput = waitUntil(presenceOfElementLocated(passwordLocator));
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        By loginButtonLocator = By.id("doLogin");
        WebElement loginButton = waitUntil(presenceOfElementLocated(loginButtonLocator));
        loginButton.click();
    }

    public boolean isInvalidCredentialsMessageIsShown() {
        boolean isInvalidCredentialsMessageIsShown = true;
        try {
            By errorMessageLocator = By.xpath("//div[contains(@role, \"alert\")]");
            waitUntil(presenceOfElementLocated(errorMessageLocator));
        }
        catch (TimeoutException timeoutException) {
            isInvalidCredentialsMessageIsShown = false;
        }
        return isInvalidCredentialsMessageIsShown;
    }
}
