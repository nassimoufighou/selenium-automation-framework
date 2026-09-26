package cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;

public class CucumberHooks {

    private WebDriver webDriver;

    @Before
    public void before() {

        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
        webDriver.get(ConfigReader.get("base.url", "config.properties"));
    }

    @After
    public void after() {
        webDriver.close();
    }
}
