package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.WebdriverManager;

import java.time.Duration;

public class HomePage {

    private WebDriver webDriver = WebdriverManager.getInstance().getWebDriver();
    private WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

    public void waitForPageToBeLoaded() {
        By headerLocator = By.xpath("//a[contains(text(), \"Book Now\")]");
        wait.until(ExpectedConditions.presenceOfElementLocated(headerLocator));
    }

    public void gotoAdmin() {
        By adminPageLocator = By.xpath("//a[@href=\"/admin\"]");
        WebElement adminPageLink = webDriver.findElement(adminPageLocator);
        adminPageLink.click();
    }
}
