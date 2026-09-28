package cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;
import webdriver.WebdriverManager;

public class CucumberHooks {

    @Before
    public void before() {
        WebdriverManager.getInstance().open(ConfigReader.get("base.url", "config.properties"));
    }

    @After
    public void after() {
        WebdriverManager.getInstance().quit();
    }
}
