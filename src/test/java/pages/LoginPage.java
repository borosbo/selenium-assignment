package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By loginIcon     = By.cssSelector("a[data-modal-open*='belepes']");
    private final By emailField    = By.name("email");
    private final By passwordField = By.name("pass");
    private final By submitButton = By.xpath("//button[contains(text(),'Belépés')]");
    private final By loggedInIndicator = By.cssSelector("a[href='/privatok/listaz.php']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo() {
        driver.get("https://hardverapro.hu");
        dismissCookiePopup();
    }

    public void openLoginModal() {
        waitForClickable(loginIcon).click();
    }

    public void enterEmail(String email) {
        waitForVisible(emailField).click();
        waitForVisible(emailField).sendKeys(email);
        waitForVisible(emailField).sendKeys(Keys.TAB);
    }

    public void enterPassword(String password) {
        waitForVisible(passwordField).click();
        waitForVisible(passwordField).sendKeys(password);
        waitForVisible(passwordField).sendKeys(Keys.TAB);
    }

    public void clickSubmit() {
        waitForClickable(submitButton).click();
    }

    public boolean isLoginModalOpen() {
        try {
            waitForVisible(emailField);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoggedIn() {
    try {
            waitForVisible(loggedInIndicator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void login(String email, String password) {
        navigateTo();
        openLoginModal();
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
    }
}