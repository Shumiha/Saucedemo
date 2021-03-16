package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void emptyFirstName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.buyProduct("Sauce Labs Fleece Jacket");
        productsPage.openShoppingCart();
        cartPage.openCheckout();
        checkoutPage.checkPageOpened();
        checkoutPage.purchase("", "Anderson", "11111");
        assertEquals(loginPage.getErrorMessage(),
                "Error: First Name is required",
                "Error message is not correct");
    }

    @Test(retryAnalyzer = Retry.class)
    public void emptyLastName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.buyProduct("Sauce Labs Fleece Jacket");
        productsPage.openShoppingCart();
        cartPage.openCheckout();
        checkoutPage.checkPageOpened();
        checkoutPage.purchase("Jon", "", "11111");
        assertEquals(loginPage.getErrorMessage(),
                "Error: Last Name is required",
                "Error message is not correct");
    }

    @Test(retryAnalyzer = Retry.class)
    public void emptyZipCode() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.buyProduct("Sauce Labs Fleece Jacket");
        productsPage.openShoppingCart();
        cartPage.openCheckout();
        checkoutPage.checkPageOpened();
        checkoutPage.purchase("Jon", "Anderson", "");
        assertEquals(loginPage.getErrorMessage(),
                "Error: Postal Code is required",
                "Error message is not correct");
    }

    @Test(retryAnalyzer = Retry.class)
    public void correctFillingOfTheFieldsTransitionToPayment() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.buyProduct("Sauce Labs Fleece Jacket");
        productsPage.openShoppingCart();
        cartPage.openCheckout();
        checkoutPage.checkPageOpened();
        checkoutPage.purchase("Jon", "Anderson", "11111");
        assertTrue(checkoutPage.getElement(),
                "Data entered incorrectly");
    }
}
