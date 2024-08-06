package com.masterthesisbs.synthetictestsselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
}
