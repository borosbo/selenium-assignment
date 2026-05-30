package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage extends BasePage {

    private final By siteLogoLink   = By.cssSelector("a.navbar-brand");
    private final By categoryNavLinks = By.cssSelector("ul.navbar-nav a.nav-link");

    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo(String url) {
        driver.get(url);
        dismissCookiePopup();
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void goForward() {
        driver.navigate().forward();
    }

    public boolean hasCategoryNav() {
        return isPresent(categoryNavLinks);
    }

    public boolean hasSiteLogo() {
        return isPresent(siteLogoLink);
    }
}