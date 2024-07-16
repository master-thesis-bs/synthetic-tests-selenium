package com.masterthesisbs.synthetictestsselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends AbstractPage {

    @FindBy(xpath = "")
    private WebElement nameInput;

    @FindBy(xpath = "")
    private WebElement emailInput;

    @FindBy(xpath = "")
    private WebElement passwordInput;

    @FindBy(xpath = "")
    private WebElement passwordConfirmationInput;

    @FindBy(xpath = "")
    private WebElement submitRegistrationFormButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void enterName(String name) {
        nameInput.sendKeys(name);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void enterPasswordConfirmation(String passwordConfirmation) {
        passwordConfirmationInput.sendKeys(passwordConfirmation);
    }

    public void clickSubmitRegistrationFormButton() {
        submitRegistrationFormButton.click();
    }
}
