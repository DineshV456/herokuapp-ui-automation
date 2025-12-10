package com.herokuapp.tests;

import com.herokuapp.tests.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class InvalidLoginTest {
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
    public void invalidLogin() {
        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("wrong","wrongpass");
        String msg = login.getFlashMessage();
        Assert.assertTrue(msg.contains("Your username is invalid!"));
    }
}
