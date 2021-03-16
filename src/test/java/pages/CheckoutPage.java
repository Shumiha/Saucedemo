package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CheckoutPage extends BasePage {

    public static final By FIRST_NAME = By.id("first-name");
    public static final By LAST_NAME = By.id("last-name");
    public static final By POSTAL_CODE = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.cssSelector(".btn_primary");
    public static final By INFO = By.cssSelector(".summary_info");
    public static final By CHECKOUT_INFO = By.cssSelector(".checkout_info");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void purchase(String firstName, String lastName, String zipCode) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(POSTAL_CODE).sendKeys(zipCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }


    public boolean getElement() {
        return driver.findElement(INFO).isDisplayed();
    }

    public void checkPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_INFO));
        } catch (TimeoutException ex) {
            Assert.fail("Страница продуктов не была загружена");
        }
    }
}
