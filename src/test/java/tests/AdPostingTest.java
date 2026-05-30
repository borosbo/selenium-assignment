package tests;

import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import pages.AdPostingPage;
import pages.LoginPage;
import util.Config;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdPostingTest extends BaseTest {

    private AdPostingPage adPage;

    @BeforeEach
    public void loginAndNavigate() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Config.EMAIL, Config.PASSWORD);

        adPage = new AdPostingPage(driver);
        adPage.navigateTo();
    }
    
    @Test
    public void adFormIsAccessibleToLoggedInUser() {
        assertTrue(adPage.isSubmitButtonPresent());
    }

    @Test
    public void userCanFillAdTitle() {
        adPage.fillTitle("Test GPU - Selenium teszt");

        assertTrue(adPage.isFieldFilled("title"));
    }

    @Test
    public void userCanFillAdDescription() {
        adPage.fillDescription("Ez egy teszt hirdetés leírása.");
        
        assertTrue(adPage.getDescriptionText().contains("teszt"));
    }

    @Test
    public void userCanFillPriceField() {
        adPage.fillPrice("50000");
        assertTrue(adPage.isFieldFilled("price"));
    }
    
    @Test
    public void userCanSelectNewCondition() {
        adPage.selectConditionNew();

        assertTrue(adPage.isConditionNewSelected());
    }
    
    @Test
    public void userCanSelectIncludeShipping() {
        adPage.checkShipping();

        assertTrue(adPage.isShippingChecked());
    }

    @Test
    public void userCanSelectAdCategory() {
        adPage.selectCategory("Hardver");

        assertTrue(adPage.isCategorySelected("Hardver"));
    }

    @Test
    public void userCanFillCompleteAdForm() {
        adPage.fillTitle("Teszt Videókártya RTX 3080");
        adPage.fillDescription("Kiváló állapotú videókártya, csak teszteléshez használt.");
        adPage.fillPrice("150000");
        adPage.selectConditionNew();
        adPage.checkShipping();
        adPage.selectCategory("Hardver");

        assertTrue(adPage.isFieldFilled("title"));
        assertTrue(adPage.isFieldFilled("price"));
        assertTrue(adPage.isConditionNewSelected());
        assertTrue(adPage.isShippingChecked());
        assertTrue(adPage.isCategorySelected("Hardver"));

    }
}
