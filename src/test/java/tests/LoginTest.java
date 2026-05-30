package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import util.Config;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void userCanOpenLoginModal() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        loginPage.openLoginModal();

        assertTrue(loginPage.isLoginModalOpen(),
            "Login modal should be visible after clicking the login icon");
    }

    @Test
    public void userCanLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        loginPage.openLoginModal();
        loginPage.enterEmail(Config.EMAIL);
        loginPage.enterPassword(Config.PASSWORD);
        loginPage.clickSubmit();

        assertFalse(driver.getCurrentUrl().contains("belepes"),
            "After login, URL should no longer show the login page");
    }
}