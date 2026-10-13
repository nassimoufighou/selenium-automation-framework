package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DateUtils;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class RoomPage extends ShadyMeadowsBasePage {

    public void waitForPageToBeLoaded() {
        By headerLocator = By.xpath("//h2[contains(text(), \"Book This Room\")]");
        wait.until(presenceOfElementLocated(headerLocator));
    }

    public void startReservation() {
        By reservationButtonLocator = By.id("doReservation");
        WebElement reservationButton = wait.until(elementToBeClickable(reservationButtonLocator));
        reservationButton.click();
    }

    public void confirmReservation() {
        By reservationButtonLocator = By.xpath("//button[contains(text(), \"Reserve Now\")]");
        WebElement reservationButton = wait.until(elementToBeClickable(reservationButtonLocator));
        reservationButton.click();
    }

    public void enterFirstName(String firstName) {
        By firstNameInputLocator = By.name("firstname");
        WebElement firstNameInput = wait.until(presenceOfElementLocated(firstNameInputLocator));
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        By lastNameInputLocator = By.name("lastname");
        WebElement lastNameInput = wait.until(presenceOfElementLocated(lastNameInputLocator));
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        By emailLocator = By.name("email");
        WebElement emailInput = wait.until(presenceOfElementLocated(emailLocator));
        emailInput.sendKeys(email);
    }

    public void enterPhone(String phone) {
        By phoneLocator = By.name("phone");
        WebElement phoneInput = wait.until(presenceOfElementLocated(phoneLocator));
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
        WebElement calendarDayButton = wait.until(presenceOfElementLocated(calendarDayButtonLocator));
        calendarDayButton.click();

        By calendarDay = By.xpath(String.format("//button[text()=\"%s\"]//..", day));
        wait.until(attributeContains(calendarDay, "class", "current"));
    }

    public boolean isErrorMessageShown() {
        By errorMessageLocator = By.xpath("//div[@class=\"card-body\"]//div[@role=\"alert\"]");
        return !webDriver.findElements(errorMessageLocator).isEmpty();
    }

    public String[] getBookingDates() {
        By bookingDatesLocator = By.xpath("//h2[contains(text(), \"Booking Confirmed\")]//ancestor::div[@class=\"card-body\"]//strong");
        WebElement bookingDates = wait.until(presenceOfElementLocated(bookingDatesLocator));
        return bookingDates.getText().split(" - ");
    }

    private void navigateToDate(String date) {
        boolean dateFound;
        By dateLocator = By.xpath(String.format("//span[contains(text(), \"%s\")]", date));
        List<WebElement> currentDate = webDriver.findElements(dateLocator);
        dateFound = !currentDate.isEmpty();

        while (!dateFound) {
            By nextButtonLocator = By.xpath("//button[contains(text(), \"Next\")]");
            WebElement nextButton = wait.until(presenceOfElementLocated(nextButtonLocator));
            nextButton.click();
            currentDate = webDriver.findElements(dateLocator);
            dateFound = !currentDate.isEmpty();
        }

    }
}
