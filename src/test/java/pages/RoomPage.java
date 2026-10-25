package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import utils.DateUtils;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

@Component
public class RoomPage extends ShadyMeadowsBasePage {

    public void waitForPageToBeLoaded() {
        By headerLocator = By.xpath("//h2[contains(text(), \"Book This Room\")]");
        waitUntil(presenceOfElementLocated(headerLocator));
    }

    public void startReservation() {
        By reservationButtonLocator = By.id("doReservation");
        WebElement reservationButton = waitUntil(elementToBeClickable(reservationButtonLocator));
        reservationButton.click();
    }

    public void confirmReservation() {
        By reservationButtonLocator = By.xpath("//button[contains(text(), \"Reserve Now\")]");
        WebElement reservationButton = waitUntil(elementToBeClickable(reservationButtonLocator));
        reservationButton.click();
    }

    public void enterFirstName(String firstName) {
        By firstNameInputLocator = By.name("firstname");
        WebElement firstNameInput = waitUntil(presenceOfElementLocated(firstNameInputLocator));
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        By lastNameInputLocator = By.name("lastname");
        WebElement lastNameInput = waitUntil(presenceOfElementLocated(lastNameInputLocator));
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        By emailLocator = By.name("email");
        WebElement emailInput = waitUntil(presenceOfElementLocated(emailLocator));
        emailInput.sendKeys(email);
    }

    public void enterPhone(String phone) {
        By phoneLocator = By.name("phone");
        WebElement phoneInput = waitUntil(presenceOfElementLocated(phoneLocator));
        phoneInput.sendKeys(phone);
    }

    public void selectDate(int days) {
        String bookingDate = DateUtils.dateInDays(days, DateUtils.MMMM_D_YYYY);

        String month = bookingDate.split(" ")[0];
        String day = bookingDate.split(" ")[1];
        String year = bookingDate.split(" ")[2];

        navigateToDate(year);
        navigateToDate(month);

        By calendarDayButtonLocator = By.xpath(String.format("//button[text()=\"%s\"]", day));
        WebElement calendarDayButton = waitUntil(presenceOfElementLocated(calendarDayButtonLocator));
        calendarDayButton.click();

        By calendarDay = By.xpath(String.format("//button[text()=\"%s\"]//..", day));
        waitUntil(attributeContains(calendarDay, "class", "current"));
    }

    public boolean isErrorMessageShown() {
        boolean isErrorMessageShown = false;
        try {
            By errorMessageLocator = By.xpath("//div[@class=\"card-body\"]//div[@role=\"alert\"]");
            waitUntil(visibilityOfElementLocated(errorMessageLocator));
            isErrorMessageShown = true;
        }
        catch (TimeoutException te) {}
        return isErrorMessageShown;
    }

    public String[] getBookingDates() {
        By bookingDatesLocator = By.xpath("//h2[contains(text(), \"Booking Confirmed\")]//ancestor::div[@class=\"card-body\"]//strong");
        WebElement bookingDates = waitUntil(presenceOfElementLocated(bookingDatesLocator));
        return bookingDates.getText().split(" - ");
    }

    private void navigateToDate(String date) {
        boolean dateFound;
        By dateLocator = By.xpath(String.format("//span[contains(text(), \"%s\")]", date));
        List<WebElement> currentDate = webdriver().findElements(dateLocator);
        dateFound = !currentDate.isEmpty();

        while (!dateFound) {
            By nextButtonLocator = By.xpath("//button[contains(text(), \"Next\")]");
            WebElement nextButton = waitUntil(presenceOfElementLocated(nextButtonLocator));
            nextButton.click();
            currentDate = webdriver().findElements(dateLocator);
            dateFound = !currentDate.isEmpty();
        }

    }
}
