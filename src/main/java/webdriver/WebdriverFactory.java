package webdriver;

import exceptions.BrowserNotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Locale;

public class WebdriverFactory {

    private static WebDriver webDriver;

    public static WebDriver getWebdriverForBrowser(String browser) {
        switch (browser.toUpperCase(Locale.ROOT)) {
            case "EDGE":
                if (isBrowserSupportedByOs(browser)) {
                    webDriver = new EdgeDriver();
                    maximizeWebdriverWindow();
                    return webDriver;
                }
            case "FIREFOX":
                if (isBrowserSupportedByOs(browser)) {
                    webDriver = new FirefoxDriver();
                    maximizeWebdriverWindow();
                    return webDriver;
                }
            default:
                throw new BrowserNotSupportedException(browser);
        }
    }

    private static void maximizeWebdriverWindow() {
        webDriver.manage().window().maximize();
    }

    private static boolean isBrowserSupportedByOs(String browser) {
        String os = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        String browserName = browser.toUpperCase(Locale.ROOT);

        if (os.contains("win")) return !browserName.contains("SAFARI");
        if (os.contains("mac")) return !browserName.contains("EDGE");
        return true;
    }
}
