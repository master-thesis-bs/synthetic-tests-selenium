package com.masterthesisbs.synthetictestsselenium.tests;

import com.masterthesisbs.synthetictestsselenium.pages.HomePage;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationTest extends AbstractTest {

    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Description("Check registration")
    public void checkRegistration() {
        var userName = "temp.user";
        var email = "temp.user@gmail.com";
        var password = "Zaq12wsx";

        var registrationPage = homePage.clickRegisterButton();

        registrationPage.enterName(userName);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        registrationPage.enterPasswordConfirmation(password);
        homePage = registrationPage.clickSubmitRegistrationFormButton();

        var profilePage = homePage.clickProfileButton();

        var userNameOnPage = profilePage.getUserName();
        var emailOnPage = profilePage.getEmail();

        assertThat(userNameOnPage)
                .isEqualTo(userName);
        assertThat(emailOnPage)
                .isEqualTo(email);

        profilePage.enterPasswordForDeletingAccount(password);
        homePage = profilePage.clickDeleteAccountButton();

        assertThat(homePage.getTitleText())
                .describedAs("Home page is open")
                .isEqualTo("Home");
    }
}
