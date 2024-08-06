package com.masterthesisbs.synthetictestsselenium.tests;

import com.masterthesisbs.synthetictestsselenium.pages.HomePage;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends AbstractTest {

    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage(driver);
    }

//    @Test
//    @Description("Check title")
//    public void checkHomePage() {
//    }
}
