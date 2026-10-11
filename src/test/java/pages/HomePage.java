package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends ShadyMeadowsBasePage {

    public void waitForPageToBeLoaded() {
        By headerLocator = By.xpath("//a[contains(text(), \"Book Now\")]");
        wait.until(ExpectedConditions.presenceOfElementLocated(headerLocator));
    }

    public void gotoAdmin() {
        By adminPageLocator = By.xpath("//a[@href=\"/admin\"]");
        WebElement adminPageLink = webDriver.findElement(adminPageLocator);
        adminPageLink.click();
    }
}
