package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdPostingPage extends BasePage {

    private final By titleField       = By.xpath("//input[@name='title' and @type='text']");
    private final By descriptionEditor = By.xpath("//div[@data-rtml-editor and @contenteditable='true']");
    private final By priceField       = By.xpath("//input[@name='price' and @type='number']");
    private final By shippingCheckbox = By.xpath("//input[@name='shipping' and @type='checkbox']");
    private final By conditionNewLabel = By.xpath("//label[contains(.,'Új')]");
    private final By conditionNew      = By.xpath("//input[@name='brandnew' and @value='1']");
    private final By submitButton     = By.id("uad-create-and-pay-later");

    public AdPostingPage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo() {
        driver.get("https://hardverapro.hu/hirdetesfeladas/uj.php");
        dismissCookiePopup();
    }

    public void fillTitle(String title) {
        waitForVisible(titleField).click();
        waitForVisible(titleField).sendKeys(title);
    }

    public void fillDescription(String text) {
        WebElement editor = waitForVisible(descriptionEditor);
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].innerHTML = arguments[1];", editor, text);
    }

    public String getDescriptionText() {
        return waitForVisible(descriptionEditor).getText();
    }

    public void fillPrice(String price) {
        waitForVisible(priceField).sendKeys(price);
    }

    public void selectConditionNew() {
        waitForClickable(conditionNewLabel).click();
    }

    public void checkShipping() {
        jsClickHidden(shippingCheckbox);
    }

    public void selectCategory(String categoryName) {
        By categoryButton = By.xpath("//button[contains(text(),'" + categoryName + "')]");
        dismissCookiePopup();
        waitForClickable(categoryButton).click();
    }

    public boolean isFieldFilled(String text) {
        return !waitForVisible(By.name(text)).getAttribute("value").isEmpty();
    }

    public boolean isConditionNewSelected() {
        WebElement el = driver.findElement(conditionNew);
        return (Boolean) ((JavascriptExecutor) driver)
            .executeScript("return arguments[0].checked;", el);
    }

    public boolean isShippingChecked() {
        WebElement el = driver.findElement(shippingCheckbox);
        return (Boolean) ((JavascriptExecutor) driver)
            .executeScript("return arguments[0].checked;", el);
    }

    public boolean isSubmitButtonPresent() {
        return isPresent(submitButton);
    }

    public boolean isCategorySelected(String categoryName) {
        By button = By.xpath("//button[contains(text(),'" + categoryName + "')]");
        return driver.findElement(button)
            .getAttribute("class").contains("selected");
    }

}