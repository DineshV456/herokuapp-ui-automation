package com.herokuapp.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SecurePage {
    WebDriver driver;

    By secureAreaHeader = By.tagName("h2");
    By logoutButton = By.cssSelector("a.button");

    public SecurePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSecureArea() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(secureAreaHeader));
        String heading = driver.findElement(secureAreaHeader).getText();
        return heading.contains("Secure Area");
    }

    public void logout() {
        driver.findElement(logoutButton).click();
    }
}
