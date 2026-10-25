package webdriver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WebdriverManager {

    @Autowired
    private WebdriverFactory webdriverFactory;
    private RobustWebdriver webdriver;

    public RobustWebdriver getWebdriver() {
        if (webdriver == null) webdriver = webdriverFactory.create();
        return webdriver;
    }

    public void openUrl(String url) {
        getWebdriver().get(url);
    }

    public void quitDriver() {
        if (webdriver != null) {
            webdriver.quit();
            webdriver = null;
        }
    }
}