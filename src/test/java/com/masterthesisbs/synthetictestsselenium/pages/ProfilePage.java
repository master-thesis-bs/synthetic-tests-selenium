package com.masterthesisbs.synthetictestsselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends AbstractPage {

    @FindBy(xpath = "//input[@data-aid='delete-account-password']")
    private WebElement deleteAccountPasswordInput;

    @FindBy(xpath = "//button[@data-aid='delete-account']")
    private WebElement deleteAccountButton;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement userNameInput;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getUserName() {
        return userNameInput.getAttribute("value");
    }

    public String getEmail() {
        return emailInput.getAttribute("value");
    }

    public void enterPasswordForDeletingAccount(String password) {
        deleteAccountPasswordInput.sendKeys(password);
    }

    public HomePage clickDeleteAccountButton() {
        deleteAccountButton.click();
        return new HomePage(driver);
    }
}
