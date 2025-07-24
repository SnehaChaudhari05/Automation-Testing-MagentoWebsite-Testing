package com.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage {

    WebDriver driver;

    // Constructor
    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    // Lazy element getters to ensure driver finds elements only when needed
    private WebElement getCreateAccountLink() {
        return driver.findElement(By.linkText("Create an Account"));
    }

    private WebElement getFirstNameField() {
        return driver.findElement(By.id("firstname"));
    }

    private WebElement getLastNameField() {
        return driver.findElement(By.id("lastname"));
    }

    private WebElement getEmailField() {
        return driver.findElement(By.id("email_address"));
    }

    private WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    private WebElement getConfirmPasswordField() {
        return driver.findElement(By.id("password-confirmation"));
    }

    private WebElement getCreateAccountButton() {
        return driver.findElement(By.cssSelector("button[title='Create an Account']"));
    }

    // Method to perform the registration
    public void registerUser(String fname, String lname, String email, String pwd, String cpwd) throws InterruptedException {
        // Click on Create Account link to open the registration page
        getCreateAccountLink().click();

        // Sometimes page can take time to load, so a short wait or explicit wait might be needed here
        Thread.sleep(2000);  // Replace this with explicit wait in real code

        getFirstNameField().sendKeys(fname);
        getLastNameField().sendKeys(lname);
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(pwd);
        getConfirmPasswordField().sendKeys(cpwd);
        getCreateAccountButton().click();
    }
}
