package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.WebdriverManager;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LoginPage {

    private WebDriver webDriver = WebdriverManager.getInstance().getWebDriver();
    private WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

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
}
