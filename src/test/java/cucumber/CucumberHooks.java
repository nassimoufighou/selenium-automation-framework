package cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CucumberHooks {

    private WebDriver webDriver;

    @Before
    public void before() {
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
        webDriver.get("https://automationintesting.online/");
    }

    @After
    public void after() {
        webDriver.close();
    }
}
