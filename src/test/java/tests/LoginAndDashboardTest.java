package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;

import pages.DashboardPage;
import pages.LoginPage;
import util.Config;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginAndDashboardTest extends BaseTest {

    @Test
    public void userCanOpenLoginModal() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        loginPage.openLoginModal();

        assertTrue(loginPage.isLoginModalOpen());
    }

    @Test
    public void userCanLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Config.EMAIL,Config.PASSWORD);
        assertTrue(loginPage.isLoggedIn());
    }

    @Test
    public void userCanLogOut() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Config.EMAIL,Config.PASSWORD);

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.logout();

        assertTrue(dashboard.isLoggedOut());
    }

    @Test
    public void userCanSearchForListings() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Config.EMAIL, Config.PASSWORD);

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.searchFor("cpu");

        assertTrue(dashboard.searchResultInputHasTerm("cpu"));
    }

    @Test
    public void hoveringOverCategoryRevealsCategoryDescription() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Config.EMAIL, Config.PASSWORD);

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.navigateTo();
        dashboard.hoverOverHardverCategory();

        assertTrue(dashboard.isTooltipVisible(),
            "Hovering over category should show tooltip description");
    }
}