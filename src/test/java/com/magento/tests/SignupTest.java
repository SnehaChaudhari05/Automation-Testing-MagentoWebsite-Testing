package com.magento.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.magento.pages.SignupPage;

import java.time.Duration;

public class SignupTest extends BaseTest {

    @Test
    public void testSignupData() throws InterruptedException {
        SignupPage signup = new SignupPage(driver);

        signup.registerUser("Sneha", "Chaudhari", "testuser+" + System.currentTimeMillis() + "@gmail.com", "Test@1234", "Test@1234");

        // Use explicit wait to wait for registration success message or redirect
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isAccountCreated = wait.until(ExpectedConditions.urlContains("/customer/account/"));

        // Assert user is on account dashboard page after successful registration
        Assert.assertTrue(isAccountCreated, "Account creation failed or did not navigate to account page.");
    }
}
