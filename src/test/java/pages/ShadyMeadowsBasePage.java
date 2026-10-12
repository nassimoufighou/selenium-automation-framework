package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.WebdriverManager;
import java.time.Duration;

public class ShadyMeadowsBasePage {

    protected WebDriver webDriver = WebdriverManager.getInstance().getWebDriver();
    protected WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

    protected void clearInput(WebElement input) {
        String value = input.getDomProperty("value");
        int length = value == null ? 0 : value.length();

        scrollToCenter(input);
        input.sendKeys(Keys.END);
        for (int i = 0; i < length; i++) {
            input.sendKeys(Keys.BACK_SPACE);
        }
    }

    protected void scrollToCenter(WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);
    }
}
