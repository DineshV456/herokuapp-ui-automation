package com.herokuapp.tests;

import com.herokuapp.tests.pages.LoginPage;
import com.herokuapp.tests.pages.SecurePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void validLogin() {
        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("tomsmith","SuperSecretPassword!");
        SecurePage secure = new SecurePage(driver);
        Assert.assertTrue(secure.isSecureArea());
    }
}
