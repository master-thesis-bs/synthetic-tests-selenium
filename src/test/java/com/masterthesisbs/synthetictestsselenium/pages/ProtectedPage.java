package com.masterthesisbs.synthetictestsselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

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

    public void assertThatPageIsDisplayedCorrectly(String emailText) {
        assertThat(this.isTitleDisplayed())
                .describedAs("Protected page title is displayed")
                .isTrue();
        assertThat(this.isSubtitleDisplayed())
                .describedAs("Protected page subtitle is displayed")
                .isTrue();
        assertThat(this.isDeleteAccountButtonDisplayed())
                .describedAs("Delete account button is displayed")
                .isTrue();
        assertThat(this.isSignOutButtonDisplayed())
                .describedAs("Sign out button is displayed")
                .isTrue();
        assertThat(this.getProtectedPageTitle())
                .describedAs("Protected page title is correct")
                .isEqualTo("Welcome");
        assertThat(this.getProtectedPageSubtitle())
                .describedAs("Protected page subtitle is correct")
                .isEqualTo("You are logged in as " + emailText);
    }
}
