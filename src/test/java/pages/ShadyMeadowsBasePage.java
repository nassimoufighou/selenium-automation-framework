package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.WebdriverManager;

import java.time.Duration;

public class ShadyMeadowsBasePage {

    protected WebDriver webDriver = WebdriverManager.getInstance().getWebDriver();
    protected WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
}
