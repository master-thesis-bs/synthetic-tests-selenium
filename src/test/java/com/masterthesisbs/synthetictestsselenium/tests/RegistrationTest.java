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
    }
}
