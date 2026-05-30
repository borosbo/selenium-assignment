package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private final By userMenuToggle   = By.cssSelector("a.nav-btn.dropdown-toggle");
    private final By logoutLink       = By.xpath("//a[contains(@href,'kilepes')]");
    private final By loginIcon        = By.cssSelector("a[data-modal-open*='belepes']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void openUserMenu() {
        waitForClickable(userMenuToggle).click();
    }

    public void clickLogout() {
        waitForClickable(logoutLink).click();
    }

    public void logout() {
        openUserMenu();
        clickLogout();
    }

    public boolean isLoggedOut() {
        return isPresent(loginIcon);
    }
}