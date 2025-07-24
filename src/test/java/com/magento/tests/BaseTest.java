package com.magento.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager; // Add this for ChromeDriver auto-management

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.out.println("Launching the Browser..........");
        WebDriverManager.chromedriver().setup(); // Automatically downloads the correct driver version
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Closing Browser...............");
        if (driver != null) {
            driver.quit();
        }
    }
}
