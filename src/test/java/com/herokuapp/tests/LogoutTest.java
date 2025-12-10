package com.herokuapp.tests;

import com.herokuapp.tests.pages.LoginPage;
import com.herokuapp.tests.pages.SecurePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LogoutTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void logoutFlow() {
        LoginPage login = new LoginPage(driver);

        // Step 1: Open login page
        login.open();

        // Step 2: Login with valid credentials
        login.login("tomsmith", "SuperSecretPassword!");

        SecurePage secure = new SecurePage(driver);

        // Step 3: Verify user entered secure area
        Assert.assertTrue(secure.isSecureArea(), 
                "User should be inside secure area after login.");

        // Step 4: Click logout
        secure.logout();

        // Step 5: Verify redirected back to login page
        Assert.assertTrue(login.isLoginButtonVisible(),
                "Login button should be visible after logout — user must be redirected to login page.");
    }
}
