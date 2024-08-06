package com.masterthesisbs.synthetictestsselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

//todo rename to ProtectedPage
public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//*[@data-aid='login-page-title']")
    private WebElement loginPageTitle;

    @FindBy(xpath = "//*[@data-aid='login-page-subtitle']")
    private WebElement loginPageSubtitle;

    @FindBy(xpath = "//*[@data-aid='email-input']")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@data-aid='password-input']")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@data-aid='submit-form']")
    private WebElement submitLoginFormButton;

    @FindBy(xpath = "//*[@data-aid='home-page-link']")
    private WebElement homePageLink;

    @FindBy(xpath = "//*[@data-aid='registration-page-link']")
    private WebElement registrationPageLink;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public ProtectedPage clickSubmitLoginFormButton() {
        submitLoginFormButton.click();
        return new ProtectedPage(driver);
    }

    public RegistrationPage clickHomePageLink() {
        homePageLink.click();
        return new RegistrationPage(driver);
    }

    public RegistrationPage clickRegistrationPageLink() {
        registrationPageLink.click();
        return new RegistrationPage(driver);
    }

    public boolean isLoginPageTitleDisplayed() {
        return loginPageTitle.isDisplayed();
    }

    public boolean isLoginPageSubtitleDisplayed() {
        return loginPageSubtitle.isDisplayed();
    }

    public boolean isEmailInputDisplayed() {
        return emailInput.isDisplayed();
    }

    public boolean isPasswordInputDisplayed() {
        return passwordInput.isDisplayed();
    }

    public boolean isSubmitLoginFormButtonDisplayed() {
        return submitLoginFormButton.isDisplayed();
    }

    public boolean isHomePageLinkDisplayed() {
        return homePageLink.isDisplayed();
    }

    public boolean isRegistrationPageLinkDisplayed() {
        return registrationPageLink.isDisplayed();
    }

    public void assertThatPageIsDisplayedCorrectly() {
        assertThat(this.isLoginPageTitleDisplayed())
                .describedAs("Login page title is displayed")
                .isTrue();
        assertThat(this.isLoginPageSubtitleDisplayed())
                .describedAs("Login page subtitle is displayed")
                .isTrue();
        assertThat(this.isEmailInputDisplayed())
                .describedAs("Login page email input is displayed")
                .isTrue();
        assertThat(this.isPasswordInputDisplayed())
                .describedAs("Login page password input is displayed")
                .isTrue();
        assertThat(this.isSubmitLoginFormButtonDisplayed())
                .describedAs("Submit login form is displayed")
                .isTrue();
        assertThat(this.isHomePageLinkDisplayed())
                .describedAs("Home page link is displayed")
                .isTrue();
        assertThat(this.isRegistrationPageLinkDisplayed())
                .describedAs("Registration page link is displayed")
                .isTrue();
    }
}
