package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage {

    public static final By SECONDARY_BUTTON = By.xpath("//button[text()='REMOVE']");
    public static final By CONTINUE_SHOPPING_BUTTON = By.cssSelector(".btn_secondary");
    public static final By NUMBER_OF_ITEMS_IN_THE_CART= By.cssSelector(".cart_quantity");
    public static final By CHECKOUT_BUTTON = By.cssSelector(".btn_action");
    public static final By CHECKOUT_LABEL = By.cssSelector(".header_secondary_container");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void deleteItem () {
        driver.findElement(SECONDARY_BUTTON).click();
    }

    public void verificationOfDeletedGoods (int numberItems) {
        Assert.assertEquals(driver.findElements(NUMBER_OF_ITEMS_IN_THE_CART).size(), numberItems,
                "Товар не удалился");
    }

    public void continueShopping() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }
    public void verificationOfContinueShopping () {
        Assert.assertEquals(driver.findElement(PRODUCT_LABEL).getText(), "Products",
                "Не удалось вернуться");
    }

    public void openCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void verificationCheckout () {
        Assert.assertEquals(driver.findElement(CHECKOUT_LABEL).getText(), "CHECKOUT: YOUR INFORMATION",
                "Не удалось перейти к оплате");
    }
}
