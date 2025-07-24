package com.magento.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.magento.pages.ChangePasswordPage;
import com.magento.pages.LoginPage;

public class ChangePasswordTest extends BaseTest {

    @Test
    public void testChangePassword() {
        String email = "your_email@example.com";
        String oldPassword = "your_current_password";
        String newPassword = "your_new_password123";

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, oldPassword);

        // Step 2: Change Password
        ChangePasswordPage changePwdPage = new ChangePasswordPage(driver);
        changePwdPage.navigateToChangePassword();
        changePwdPage.changePassword(oldPassword, newPassword);

        // Step 3: Logout and login with new password to verify
        // You can add logout method here or navigate to logout URL if page object present

        // Perform logout (implement logout page object or do simple driver.navigate)
        driver.get("https://magento.softwaretestingboard.com/customer/account/logout/");

        // Login with new password to verify
        loginPage.login(email, newPassword);

        // Verify successful login
        Assert.assertTrue(driver.getPageSource().contains("My Account"), "Login with new password failed!");

        // Optional: revert password change after test for cleanup
    }
}
