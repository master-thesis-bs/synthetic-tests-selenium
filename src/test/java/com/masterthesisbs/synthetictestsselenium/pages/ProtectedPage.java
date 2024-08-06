package com.masterthesisbs.synthetictestsselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProtectedPage extends AbstractPage {

    @FindBy(xpath = "//*[@data-aid='protected-page-title']")
    private WebElement protectedPageTitle;

    @FindBy(xpath = "//*[@data-aid='protected-page-subtitle']")
    private WebElement protectedPageSubtitle;

    @FindBy(xpath = "//*[@data-aid='delete-account-button']")
    private WebElement deleteAccountButton;

    @FindBy(xpath = "//*[@data-aid='sign-out-button']")
    private WebElement signOutButton;

    public ProtectedPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickDeleteAccountButton() {
        deleteAccountButton.click();
        return new LoginPage(driver);
    }

    public String getProtectedPageTitle() {
        return protectedPageTitle.getText();
    }

    public String getProtectedPageSubtitle() {
        return protectedPageSubtitle.getText();
    }

    public boolean isTitleDisplayed() {
        return protectedPageTitle.isDisplayed();
    }

    public boolean isSubtitleDisplayed() {
        return protectedPageSubtitle.isDisplayed();
    }

    public boolean isDeleteAccountButtonDisplayed() {
        return deleteAccountButton.isDisplayed();
    }

    public boolean isSignOutButtonDisplayed() {
        return signOutButton.isDisplayed();
    }

    public LoginPage clickSignOutButton() {
        signOutButton.click();
        return new LoginPage(driver);
    }

    //todo check if email in welcome message is displayed as expected (value from login)
}
