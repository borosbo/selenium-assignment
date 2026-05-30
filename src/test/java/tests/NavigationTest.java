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
}
