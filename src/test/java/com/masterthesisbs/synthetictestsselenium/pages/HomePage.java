package com.masterthesisbs.synthetictestsselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//body/div/div/h1")
    public WebElement title;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@href='/register']")
    private WebElement registerButton;

    public String getTitleText() {
        return title.getText();
    }

    public String getLoginButtonText() {
        return loginButton.getText();
    }

    public String getRegisterButtonText() {
        return registerButton.getText();
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(driver);
    }

    public RegistrationPage clickRegisterButton() {
        registerButton.click();
        return new RegistrationPage(driver);
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
