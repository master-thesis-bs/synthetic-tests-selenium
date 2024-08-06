package com.masterthesisbs.synthetictestsselenium.tests;

import com.masterthesisbs.synthetictestsselenium.pages.HomePage;
import com.masterthesisbs.synthetictestsselenium.pages.LoginPage;
import com.masterthesisbs.synthetictestsselenium.pages.ProtectedPage;
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

        assertThatHomePageIsDisplayedCorrectly(homePage);

        var loginPage = homePage.clickLoginPageButton();

        assertThatLoginPageIsDisplayedCorrectly(loginPage);

        loginPage.enterEmail(emailText);
        loginPage.enterPassword(passwordText);
        final var protectedPage = loginPage.clickSubmitLoginFormButton();

        assertThatProtectedPageIsDisplayedCorrectly(protectedPage, emailText);

        loginPage = protectedPage.clickSignOutButton();

        assertThatLoginPageIsDisplayedCorrectly(loginPage);
    }

    private void assertThatLoginPageIsDisplayedCorrectly(LoginPage loginPage) {
        assertThat(loginPage.isLoginPageTitleDisplayed())
                .describedAs("Login page title is displayed")
                .isTrue();
        assertThat(loginPage.isLoginPageSubtitleDisplayed())
                .describedAs("Login page subtitle is displayed")
                .isTrue();
        assertThat(loginPage.isEmailInputDisplayed())
                .describedAs("Login page email input is displayed")
                .isTrue();
        assertThat(loginPage.isPasswordInputDisplayed())
                .describedAs("Login page password input is displayed")
                .isTrue();
        assertThat(loginPage.isSubmitLoginFormButtonDisplayed())
                .describedAs("Submit login form is displayed")
                .isTrue();
        assertThat(loginPage.isHomePageLinkDisplayed())
                .describedAs("Home page link is displayed")
                .isTrue();
        assertThat(loginPage.isRegistrationPageLinkDisplayed())
                .describedAs("Registration page link is displayed")
                .isTrue();
    }

    private void assertThatProtectedPageIsDisplayedCorrectly(ProtectedPage protectedPage, String emailText) {
        assertThat(protectedPage.isTitleDisplayed())
                .describedAs("Protected page title is displayed")
                .isTrue();
        assertThat(protectedPage.isSubtitleDisplayed())
                .describedAs("Protected page subtitle is displayed")
                .isTrue();
        assertThat(protectedPage.isDeleteAccountButtonDisplayed())
                .describedAs("Delete account button is displayed")
                .isTrue();
        assertThat(protectedPage.isSignOutButtonDisplayed())
                .describedAs("Sign out button is displayed")
                .isTrue();
        assertThat(protectedPage.getProtectedPageTitle())
                .describedAs("Protected page title is correct")
                .isEqualTo("Welcome");
        assertThat(protectedPage.getProtectedPageSubtitle())
                .describedAs("Protected page subtitle is correct")
                .isEqualTo("You are logged in as " + emailText);
    }

    private void assertThatHomePageIsDisplayedCorrectly(HomePage homePage) {
        assertThat(homePage.isHomePageTitleDisplayed())
                .describedAs("Home page title is displayed")
                .isTrue();

        assertThat(homePage.getHomePageTitleText())
                .describedAs("Home page title is displayed")
                .isEqualTo("Login or sign up to proceed");

        assertThat(homePage.isLoginButtonDisplayed())
                .describedAs("Login button is displayed")
                .isTrue();
    }
}
