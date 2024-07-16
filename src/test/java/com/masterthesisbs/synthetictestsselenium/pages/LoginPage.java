package com.masterthesisbs.synthetictestsselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button")
    private WebElement submitLoginFormButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public String getEmailTextFromInput() {
        return emailInput.getAttribute("value");
    }

    public String getPasswordTextFromInput() {
        return passwordInput.getAttribute("value");
    }

    public HomePage clickSubmitLoginFormButton() {
        submitLoginFormButton.click();
        return new HomePage(driver);
    }
}
