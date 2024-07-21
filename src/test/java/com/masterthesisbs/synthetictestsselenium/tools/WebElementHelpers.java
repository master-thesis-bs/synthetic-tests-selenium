package com.masterthesisbs.synthetictestsselenium.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebElementHelpers {
    public static boolean isElementPresent(WebDriver driver, By locatorKey) {
        return !driver.findElements(locatorKey).isEmpty();
    }
}
