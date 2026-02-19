package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void loginSuccessTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assertions.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    public void loginInvalidTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "wrong_password");

        Assertions.assertTrue(loginPage.getErrorMessage().contains("Epic sadface"));
    }

    @Test
    public void logoutTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assertions.assertTrue(driver.getCurrentUrl().contains("inventory"));
        loginPage.clickOnMenuBTn();
        loginPage.ValidateBtnlogOutIsDisplayed();
        loginPage.clickOnLogoutBTn();
        loginPage.ValideteLoginBtnIsDisplayed();
    }

}
