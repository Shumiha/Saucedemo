package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");
    public static final By PRODUCT_LABEL= By.cssSelector(".product_label");
    public static final By SHOPPING_CARD = By.id("shopping_cart_container");
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,15);
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public void openShoppingCart() {
        driver.findElement(SHOPPING_CARD).click();
    }
}
