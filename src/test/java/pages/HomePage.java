package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DateUtils;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class HomePage extends ShadyMeadowsBasePage {

    public void waitForPageToBeLoaded() {
        By headerLocator = By.xpath("//a[contains(text(), \"Book Now\")]");
        wait.until(presenceOfElementLocated(headerLocator));
    }

    public void gotoAdmin() {
        By adminPageLocator = By.xpath("//a[@href=\"/admin\"]");
        WebElement adminPageLink = webDriver.findElement(adminPageLocator);
        adminPageLink.click();
    }

    public void selectStayDates(int nights, int fromOffest) {
        String checkinDate = DateUtils.dateInDays(fromOffest, DateUtils.DD_MM_YYYY);
        String checkoutDate = DateUtils.dateInDays(fromOffest + nights, DateUtils.DD_MM_YYYY);

        By checkinLocator = By.xpath("//label[@for=\"checkin\"]//..//input");
        WebElement checkin = wait.until(presenceOfElementLocated(checkinLocator));
        clearInput(checkin);
        checkin.sendKeys(checkinDate);

        By checkoutLocator = By.xpath("//label[@for=\"checkout\"]//..//input");
        WebElement checkout = wait.until(presenceOfElementLocated(checkoutLocator));
        clearInput(checkout);
        checkout.sendKeys(checkoutDate);

        By checkAvailabilityButtonLocator = By.xpath("//button[contains(text(), \"Check Availability\")]");
        WebElement checkAvailabilityButton = wait.until(elementToBeClickable(checkAvailabilityButtonLocator));
        checkAvailabilityButton.click();
    }

    public void selectAvailableRoom(){
        By accomodationsLocator = By.id("rooms");
        WebElement accomodationsSection = wait.until(presenceOfElementLocated(accomodationsLocator));
        scrollToCenter(accomodationsSection);

        By availableRoomsLocator = By.xpath("//section[@id=\"rooms\"]//div[contains(@class, \"card-footer\")]//a");
        List<WebElement> availableRooms = webDriver.findElements(availableRoomsLocator);
        availableRooms.get(0).click();
    }
}
