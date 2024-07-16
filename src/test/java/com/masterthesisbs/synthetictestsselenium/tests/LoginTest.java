package com.masterthesisbs.synthetictestsselenium.tests;

import com.masterthesisbs.synthetictestsselenium.pages.HomePage;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends AbstractTest {

    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage(driver);
    }

    @Test
    @Description("Check login")
    public void loginTest() {
        final var emailText = "user1@gmail.com";
        final var passwordText = "Zaq12wsx";
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

        assertThat(homePage.getTitleText())
                .describedAs("Home page is displayed")
                .isEqualTo("Home");

//        assertThat(homePage.getLoginButtonText())
//                .describedAs("User can log out")
//                .isEqualTo("Logout");
        //todo assert that profile is displayed (different locator)
        //todo assert that logout is displayed (different locator)
    }
}
