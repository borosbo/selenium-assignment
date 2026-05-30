package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.NavigationPage;
import util.Config;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigationTest extends BaseTest {

    @Test
    public void homepageDisplaysSiteLogo() {
        NavigationPage nav = new NavigationPage(driver);
        nav.navigateTo(Config.BASE_URL);

        assertTrue(nav.hasSiteLogo());
    }

    @Test
    public void homepageTitleContainsSiteName() {
        NavigationPage nav = new NavigationPage(driver);
        nav.navigateTo(Config.BASE_URL);

        assertTrue(nav.getTitle().toLowerCase().contains("hardver"),
            "Page title should contain 'hardver'");
    }

    @Test
    public void allCategoryPagesLoadSuccessfully() {
        NavigationPage nav = new NavigationPage(driver);

        for (String url : Config.CATEGORY_URLS) {
            nav.navigateTo(url);
            assertTrue(nav.getTitle().toLowerCase().contains("hardver"));
        }
    }


    @Test
    public void browserBackButtonReturnsToHomepage() {
        NavigationPage nav = new NavigationPage(driver);
        nav.navigateTo(Config.BASE_URL);
        nav.navigateTo(Config.CATEGORY_URLS[0]);

        nav.goBack();

        assertTrue(driver.getCurrentUrl().equals(Config.BASE_URL + "/index.html"));
    }

    @Test
    public void browserForwardButtonReturnsToCategory() {
        NavigationPage nav = new NavigationPage(driver);
        nav.navigateTo(Config.BASE_URL);
        nav.navigateTo(Config.CATEGORY_URLS[0]);
        nav.goBack();
        nav.goForward();

        assertTrue(driver.getCurrentUrl().contains("/aprok/"));
    }
}
