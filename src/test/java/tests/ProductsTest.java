package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void productsShouldBeAvailableInCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.checkPageOpened();
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.buyProduct("Sauce Labs Fleece Jacket");
        Assert.assertEquals(productsPage.numberOfButtonsToCheck(), productsPage.getCheckNumberOfButtons(),
                "количество товара не совпадает");
    }

    @Test(retryAnalyzer = Retry.class)
    public void checkingTheItemInTheCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.checkPageOpened();
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.buyProduct("Sauce Labs Fleece Jacket");
        productsPage.openShoppingCart();
        Assert.assertEquals(productsPage.numberOfButtonsToCheck(), productsPage.getCheckNumberOfButtons()
                , "Ошибка в количестве товара");
    }
}
