package com.masterthesisbs.synthetictestsselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.masterthesisbs.synthetictestsselenium.tools.WebElementHelpers.isElementPresent;
import static org.openqa.selenium.By.xpath;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//body/div/div/h1")
    public WebElement title;

    private final By loginButtonLocator = xpath("//a[@href='/login']");
    private final By registerButtonLocator = xpath("//a[@href='/register']");
    private final By logoutButtonLocator = xpath("//div[@data-aid='logout']");
    private final By profileButtonLocator = xpath("//div[@data-aid='profile']");

    public String getTitleText() {
        return title.getText();
    }

    public LoginPage clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
        return new LoginPage(driver);
    }

    public RegistrationPage clickRegisterButton() {
        driver.findElement(registerButtonLocator).click();
        return new RegistrationPage(driver);
    }

    public HomePage clickLogoutButton() {
        driver.findElement(logoutButtonLocator).click();
        return new HomePage(driver);
    }

    public boolean isLogoutButtonPresent() {
        return isElementPresent(driver, logoutButtonLocator);
    }

    public boolean isProfileButtonPresent() {
        return isElementPresent(driver, profileButtonLocator);
    }

    public boolean isLoginButtonPresent() {
        return isElementPresent(driver, loginButtonLocator);
    }

    public boolean isRegisterButtonPresent() {
        return isElementPresent(driver, registerButtonLocator);
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
