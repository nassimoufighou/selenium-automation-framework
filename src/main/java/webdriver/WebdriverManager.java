package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverManager {

    private static WebdriverManager instance;
    private static WebDriver webDriver;

    private WebdriverManager() {}

    public static WebdriverManager getInstance() {
        if (instance == null) instance = new WebdriverManager();
        return instance;
    }

    public void open(String  url) {
        if (webDriver == null) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }
        webDriver.get(url);
    }

    public void quit() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

    public WebDriver getWebdriver() {
        return webDriver;
    }
}
