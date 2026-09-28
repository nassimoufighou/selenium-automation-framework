package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

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
            String browser = ConfigReader.get("browser", "config.properties");
            webDriver = WebdriverFactory.getWebdriverForBrowser(browser);
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
