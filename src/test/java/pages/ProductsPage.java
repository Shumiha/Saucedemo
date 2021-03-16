package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductsPage extends BasePage {
    public static final String ADD_TO_CARD = "//*[text()='%s']/ancestor::div[contains(@class,'inventory_item')]//button";
    public static final By INVENTORY_ITEM_NAME = By.cssSelector(".inventory_item_name");
    public static final By SECONDARY_BUTTON = By.xpath("//button[text()='REMOVE']");
    private int checkNumberOfButtons = 0;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public int getCheckNumberOfButtons() {
        return checkNumberOfButtons;
    }

    public void buyProduct(String productName) {
        driver.findElement(By.xpath(String.format(ADD_TO_CARD, productName))).click();
        checkNumberOfButtons++;
    }

    public void checkPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(INVENTORY_ITEM_NAME));
        } catch (TimeoutException ex) {
            Assert.fail("Страница продуктов не была загружена");
        }
    }

    public int numberOfButtonsToCheck() {
        return driver.findElements(SECONDARY_BUTTON).size();
    }

}
