package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void removalOfGoods() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.buyProduct("Sauce Labs Fleece Jacket");
        productsPage.buyProduct("Sauce Labs Backpack");
        productsPage.openShoppingCart();
        cartPage.deleteItem();
        cartPage.verificationOfDeletedGoods(2);
    }

    @Test(retryAnalyzer = Retry.class)
    public void returnToShoppingPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openShoppingCart();
        cartPage.continueShopping();
        productsPage.checkPageOpened();
        cartPage.verificationOfContinueShopping();
    }

    @Test(retryAnalyzer = Retry.class)
    public void goToThePaymentPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openShoppingCart();
        cartPage.openCheckout();
        cartPage.verificationCheckout();
    }
}
