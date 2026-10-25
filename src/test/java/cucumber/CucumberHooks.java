package cucumber;

import io.cucumber.java.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import webdriver.WebdriverManager;

public class CucumberHooks {

    @Value("${base.url}")
    private String baseUrl;

    @Autowired
    private WebdriverManager webdriverManager;

    @Before
    public void before() {
        webdriverManager.openUrl(baseUrl);
    }

    @After
    public void after(Scenario scenario) {
        webdriverManager.quitDriver();
    }
}
