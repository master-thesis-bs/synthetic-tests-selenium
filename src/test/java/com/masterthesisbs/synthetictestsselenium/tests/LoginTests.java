package com.masterthesisbs.synthetictestsselenium.tests;

import com.masterthesisbs.synthetictestsselenium.pages.HomePage;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTests extends AbstractTest {

    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage(driver);
    }

    @Test
    @Description("Login test positive scenario")
    public void loginTestPositive() {
        final var emailText = "admin@gmail.com";
        final var passwordText = "Zaq12wsx";

        buttonsForGuestUserAreDisplayed();

        var loginPage = homePage.clickLoginButton();

        loginPage.enterEmail(emailText);

        assertThat(loginPage.getEmailTextFromInput())
                .describedAs("Email has been entered")
                .isEqualTo(emailText);

        loginPage.enterPassword(passwordText);

        assertThat(loginPage.getPasswordTextFromInput())
                .describedAs("Password has been entered")
                .isEqualTo(passwordText);

        homePage = loginPage.clickSubmitLoginFormButton();

        buttonsForLoggedInUserAreDisplayed();

        homePage = homePage.clickLogoutButton();

        buttonsForGuestUserAreDisplayed();
    }

    private void buttonsForLoggedInUserAreDisplayed() {
        assertThat(homePage.isLogoutButtonPresent())
                .describedAs("Logout button is displayed")
                .isTrue();
        assertThat(homePage.isProfileButtonPresent())
                .describedAs("Profile button is displayed")
                .isTrue();
    }

    private void buttonsForGuestUserAreDisplayed() {
        assertThat(homePage.isLoginButtonPresent())
                .describedAs("Login button is displayed")
                .isTrue();
        assertThat(homePage.isRegisterButtonPresent())
                .describedAs("Register button is displayed")
                .isTrue();
    }
}
