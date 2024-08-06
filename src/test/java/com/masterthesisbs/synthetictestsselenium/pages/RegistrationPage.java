package com.masterthesisbs.synthetictestsselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationPage extends AbstractPage {

    @FindBy(xpath = "//*[@data-aid='registration-page-title']")
    private WebElement registrationPageTitle;

    @FindBy(xpath = "//*[@data-aid='registration-page-subtitle']")
    private WebElement registrationPageSubtitle;

    @FindBy(xpath = "//*[@data-aid='email-input']")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@data-aid='password-input']")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@data-aid='submit-form']")
    private WebElement submitRegistrationFormButton;

    @FindBy(xpath = "//*[@data-aid='home-page-link']")
    private WebElement homePageLink;

    @FindBy(xpath = "//*[@data-aid='login-page-link']")
    private WebElement loginPageLink;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public LoginPage clickSubmitRegistrationFormButton() {
        submitRegistrationFormButton.click();
        return new LoginPage(driver);
    }

    public RegistrationPage clickHomePageLink() {
        homePageLink.click();
        return new RegistrationPage(driver);
    }

    public RegistrationPage clickLoginPageLink() {
        loginPageLink.click();
        return new RegistrationPage(driver);
    }

    public boolean isRegistrationPageTitleDisplayed() {
        return registrationPageTitle.isDisplayed();
    }

    public boolean isRegistrationPageSubtitleDisplayed() {
        return registrationPageSubtitle.isDisplayed();
    }

    public boolean isEmailInputDisplayed() {
        return emailInput.isDisplayed();
    }

    public boolean isPasswordInputDisplayed() {
        return passwordInput.isDisplayed();
    }

    public boolean isSubmitRegistrationFormButtonDisplayed() {
        return submitRegistrationFormButton.isDisplayed();
    }

    public boolean isHomePageLinkDisplayed() {
        return homePageLink.isDisplayed();
    }

    public boolean isLoginPageLinkDisplayed() {
        return loginPageLink.isDisplayed();
    }

    public void assertThatPageIsDisplayedCorrectly() {
        assertThat(this.isRegistrationPageTitleDisplayed())
                .describedAs("Registration page title is displayed")
                .isTrue();
        assertThat(this.isRegistrationPageSubtitleDisplayed())
                .describedAs("Registration page subtitle is displayed")
                .isTrue();
        assertThat(this.isEmailInputDisplayed())
                .describedAs("Registration page email input is displayed")
                .isTrue();
        assertThat(this.isPasswordInputDisplayed())
                .describedAs("Registration page password input is displayed")
                .isTrue();
        assertThat(this.isSubmitRegistrationFormButtonDisplayed())
                .describedAs("Submit login form is displayed")
                .isTrue();
        assertThat(this.isHomePageLinkDisplayed())
                .describedAs("Home page link is displayed")
                .isTrue();
        assertThat(this.isLoginPageLinkDisplayed())
                .describedAs("Login page link is displayed")
                .isTrue();
    }
}
