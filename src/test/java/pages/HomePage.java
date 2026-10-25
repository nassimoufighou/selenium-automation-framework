package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import utils.DateUtils;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

@Component
public class HomePage extends ShadyMeadowsBasePage {

    public void waitForPageToBeLoaded() {
        By headerLocator = By.xpath("//a[contains(text(), \"Book Now\")]");
        waitUntil(presenceOfElementLocated(headerLocator));
    }

    public void gotoAdmin() {
        By adminPageLocator = By.xpath("//a[@href=\"/admin\"]");
        WebElement adminPageLink = webdriver().findElement(adminPageLocator);
        adminPageLink.click();
    }

    public void selectStayDates(String checkinDate, String checkoutDate) {
        By checkinLocator = By.xpath("//label[@for=\"checkin\"]//..//input");
        WebElement checkin = waitUntil(presenceOfElementLocated(checkinLocator));
        clearInput(checkin);
        checkin.sendKeys(checkinDate);

        By checkoutLocator = By.xpath("//label[@for=\"checkout\"]//..//input");
        WebElement checkout = waitUntil(presenceOfElementLocated(checkoutLocator));
        clearInput(checkout);
        checkout.sendKeys(checkoutDate);

        By checkAvailabilityButtonLocator = By.xpath("//button[contains(text(), \"Check Availability\")]");
        WebElement checkAvailabilityButton = waitUntil(elementToBeClickable(checkAvailabilityButtonLocator));
        checkAvailabilityButton.click();
    }

    public void selectAvailableRoom(){
        By accomodationsLocator = By.id("rooms");
        WebElement accomodationsSection = waitUntil(presenceOfElementLocated(accomodationsLocator));
        scrollToCenter(accomodationsSection);

        By availableRoomsLocator = By.xpath("//section[@id=\"rooms\"]//div[contains(@class, \"card-footer\")]//a");
        List<WebElement> availableRooms = webdriver().findElements(availableRoomsLocator);
        availableRooms.get(0).click();
    }
}
