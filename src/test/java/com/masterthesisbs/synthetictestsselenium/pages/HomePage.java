package com.masterthesisbs.synthetictestsselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//*[@data-aid='home-page-title']/h3")
    public WebElement title;

    @FindBy(xpath = "//button[@data-aid='auth-page-button']")
    public WebElement loginPageButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginButtonDisplayed() {
        return loginPageButton.isDisplayed();
    }

    public boolean isHomePageTitleDisplayed() {
        return title.isDisplayed();
    }

    public String getHomePageTitleText() {
        return title.getText();
    }

    public LoginPage clickLoginPageButton() {
        loginPageButton.click();
        return new LoginPage(driver);
    }

    public void assertThatPageIsDisplayedCorrectly() {
        assertThat(this.isHomePageTitleDisplayed())
                .describedAs("Home page title is displayed")
                .isTrue();
        assertThat(this.getHomePageTitleText())
                .describedAs("Home page title is displayed")
                .isEqualTo("Login or sign up to proceed");
        assertThat(this.isLoginButtonDisplayed())
                .describedAs("Login button is displayed")
                .isTrue();
    }
}
