package webdriver;

import exceptions.BrowserNotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Locale;

public class WebdriverFactory {

    public static WebDriver getWebdriverForBrowser(String browser) {
        switch (browser.toUpperCase(Locale.ROOT)){
            case "EDGE":
                String os = System.getProperty("os.name");
                if (!os.toLowerCase(Locale.ROOT).contains("windows")) throw new BrowserNotSupportedException(browser, os);
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default: throw new BrowserNotSupportedException(browser);
        }
    }
}
