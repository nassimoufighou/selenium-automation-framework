package pages;

import org.openqa.selenium.By;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class AdminDashboardPage extends ShadyMeadowsBasePage {

    public void waitForPageToBeLoaded() {
        wait.until(urlContains("/admin/rooms"));

        By listingTableHeadersLocator = By.xpath("//div[contains(@class, \"rowHeader\")]");
        wait.until(numberOfElementsToBe(listingTableHeadersLocator, 5));

        By createButtonLocator = By.id("createRoom");
        wait.until(presenceOfElementLocated(createButtonLocator));

    }

}
