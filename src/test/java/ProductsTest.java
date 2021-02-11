import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test
    public void productsShouldBeAvailableInCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.buyProduct("Sauce Labs Fleece Jacket");
    }

    @Test
    public void checkingTheItemInTheCart() {
        int button = driver.findElements(By.xpath("//button[text()='REMOVE']")).size();
        assertEquals(button, 2, "Ошибка в количестве товара");
    }
}
