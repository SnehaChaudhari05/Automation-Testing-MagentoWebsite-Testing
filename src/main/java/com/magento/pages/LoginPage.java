package com.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Element Locators
    private WebElement getEmailField() {
        return driver.findElement(By.id("email"));
    }
    private WebElement getPasswordField() {
        return driver.findElement(By.id("pass"));
    }
    private WebElement getSignInButton() {
        return driver.findElement(By.id("send2"));
    }

    // Reusable Login Method
    public void login(String email, String password) {
        getEmailField().clear();
        getEmailField().sendKeys(email);
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
        getSignInButton().click();
    }
}
