package pages;

import base.BasePage;
import util.Config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private final By userMenuToggle   = By.cssSelector("a.nav-btn.dropdown-toggle");
    private final By logoutLink       = By.xpath("//a[contains(@href,'kilepes')]");
    private final By loginIcon        = By.cssSelector("a[data-modal-open*='belepes']");
    private final By searchInput  = By.xpath("//input[@name='stext' and @type='text']");
    private final By searchButton = By.xpath("//button[@type='submit' and contains(.,'Keresés')]");
    private final By hardverLink = By.xpath("//a[@href='/aprok/hardver/index.html' and @data-toggle='tooltip']");
    private final By tooltip     = By.xpath("//div[contains(@class,'tooltip') and contains(.,'PC alkatrészek')]");


    public void navigateTo() {
        driver.get(Config.BASE_URL);
        dismissCookiePopup();
    }

    public void searchFor(String text) {
        waitForVisible(searchInput).click();
        waitForVisible(searchInput).sendKeys(text);
        waitForClickable(searchButton).click();
    }

    public boolean searchResultInputHasTerm(String text) {
        return waitForVisible(searchInput).getAttribute("value").equals(text);
    }

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

    public void hoverOverHardverCategory() {
        hoverOver(hardverLink);
    }

    public boolean isTooltipVisible() {
        return isPresent(tooltip);
    }
}