package pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

@Component
public class AdminDashboardPage extends ShadyMeadowsBasePage {

    public void waitForPageToBeLoaded() {
        waitUntil(urlContains("/admin/rooms"));

        By listingTableHeadersLocator = By.xpath("//div[contains(@class, \"rowHeader\")]");
        waitUntil(numberOfElementsToBe(listingTableHeadersLocator, 5));

        By createButtonLocator = By.id("createRoom");
        waitUntil(presenceOfElementLocated(createButtonLocator));

    }

}
