package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By loginIcon     = By.cssSelector("a[data-modal-open*='belepes']");
    private final By emailField    = By.name("email");
    private final By passwordField = By.name("pass");
    private final By submitButton  = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo() {
        driver.get("https://hardverapro.hu");
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
        return isPresent(emailField);
    }
}