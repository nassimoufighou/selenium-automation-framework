package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.WebdriverManager;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class AdminDashboardPage {

    private WebDriver webDriver = WebdriverManager.getInstance().getWebDriver();
    private WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

    public void waitForPageToBeLoaded() {
        wait.until(urlContains("/admin/rooms"));

        By listingTableHeadersLocator = By.xpath("//div[contains(@class, \"rowHeader\")]");
        wait.until(numberOfElementsToBe(listingTableHeadersLocator, 5));

        By createButtonLocator = By.id("createRoom");
        wait.until(presenceOfElementLocated(createButtonLocator));

    }

}
