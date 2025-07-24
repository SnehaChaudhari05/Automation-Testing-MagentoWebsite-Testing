package com.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChangePasswordPage {

    WebDriver driver;
    WebDriverWait wait;

    public ChangePasswordPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToChangePassword() {
        WebElement userDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".customer-name")));
        userDropdown.click();

        WebElement myAccount = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("My Account")));
        myAccount.click();

        // Wait for page to load - can wait for a unique element on account page
        wait.until(ExpectedConditions.urlContains("/customer/account"));
    }

    public void changePassword(String currentPassword, String newPassword) {
        WebElement changePasswordLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Change Password")));
        changePasswordLink.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("current-password")));

        WebElement currentPwd = driver.findElement(By.id("current-password"));
        WebElement newPwd = driver.findElement(By.id("password"));
        WebElement confirmPwd = driver.findElement(By.id("password-confirmation"));
        WebElement saveBtn = driver.findElement(By.cssSelector("button[title='Save']"));

        currentPwd.clear();
        currentPwd.sendKeys(currentPassword);
        newPwd.clear();
        newPwd.sendKeys(newPassword);
        confirmPwd.clear();
        confirmPwd.sendKeys(newPassword);
        saveBtn.click();

        // Wait for success message or account page reload
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-success")));
    }
}
