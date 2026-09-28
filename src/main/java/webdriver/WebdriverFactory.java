package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Locale;

public class WebdriverFactory {

    public static WebDriver getWebdriverForBrowser(String browser) {
        WebDriver webDriver = null;
        switch (browser.toUpperCase(Locale.ROOT)){
            case "EDGE":
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
        }
        return webDriver;
    }
}
