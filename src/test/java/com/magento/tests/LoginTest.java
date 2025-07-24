package com.magento.tests;

import com.magento.pages.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest{

    @Test
    public void testLoginWithValidData() {
        // Wait for Sign In link and click it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign In"))).click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser@gmail.com", "Test@1234");

        // Wait for page to load and check login success (e.g., look for My Account dashboard)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'My Account')]")));
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("My Account"), "Login validation failed! Title: " + actualTitle);
    }
}
