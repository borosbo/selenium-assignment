package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;

import pages.DashboardPage;
import pages.LoginPage;
import util.Config;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void userCanOpenLoginModal() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        loginPage.openLoginModal();

        assertTrue(loginPage.isLoginModalOpen());
    }

    @Test
    public void userCanLoginWithValidCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        loginPage.openLoginModal();
        loginPage.enterEmail(Config.EMAIL);
        loginPage.enterPassword(Config.PASSWORD);
        loginPage.clickSubmit();
        assertTrue(loginPage.isLoggedIn());
    }

    @Test
    public void userCanLogOut() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        loginPage.openLoginModal();
        loginPage.enterEmail(Config.EMAIL);
        loginPage.enterPassword(Config.PASSWORD);
        loginPage.clickSubmit();

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.logout();

        assertTrue(dashboard.isLoggedOut());
    }
}