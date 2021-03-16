package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void wrongPassword() {
        loginPage.open();
        loginPage.login("standard_user", "123");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Error message is not correct");
    }

    @Test(retryAnalyzer = Retry.class)
    public void emptyUserName() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Error message is not correct");
    }

    @Test(retryAnalyzer = Retry.class)
    public void emptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Error message is not correct");
    }

    @Test(retryAnalyzer = Retry.class)
    public void correctDataFilling() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        loginPage.loginCheck();
    }
}
