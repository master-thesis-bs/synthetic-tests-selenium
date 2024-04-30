package com.masterthesisbs.synthetictestsselenium.synthetictestsselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(xpath = "//p[contains(@class, 'jb-middle-hero')]")
    public WebElement title;

    public String getTitleText() {
        return title.getText();
    }

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
