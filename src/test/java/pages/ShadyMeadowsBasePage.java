package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import webdriver.RobustWebdriver;
import webdriver.WebdriverManager;
import java.time.Duration;

public class ShadyMeadowsBasePage {

    @Value("${webdriver.wait.timeout}")
    private long timeout;

    @Autowired
    private WebdriverManager webdriverManager;

    protected RobustWebdriver webdriver() {
        return webdriverManager.getWebdriver();
    }

    protected <T> T waitUntil(ExpectedCondition<T> condition) {
        return new WebDriverWait(webdriver(), Duration.ofSeconds(timeout)).until(condition);
    }

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
        ((JavascriptExecutor) webdriver()).executeScript(
                "arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);
    }
}
