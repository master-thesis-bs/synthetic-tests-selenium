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

        homePage.assertThatPageIsDisplayedCorrectly();

        var loginPage = homePage.clickLoginPageButton();

        loginPage.assertThatPageIsDisplayedCorrectly();

        loginPage.enterEmail(emailText);
        loginPage.enterPassword(passwordText);
        final var protectedPage = loginPage.clickSubmitLoginFormButton();

        protectedPage.assertThatPageIsDisplayedCorrectly(emailText);

        loginPage = protectedPage.clickSignOutButton();

        loginPage.assertThatPageIsDisplayedCorrectly();
    }
}
