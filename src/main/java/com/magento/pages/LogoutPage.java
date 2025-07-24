package com.magento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage {
	
	WebDriver driver;
	
	public LogoutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void logout() throws InterruptedException
	{
		WebElement userDropDown = driver.findElement(By.cssSelector(".customer-name"));
		userDropDown.click();
		Thread.sleep(2000);
		
		WebElement signOutLink = driver.findElement(By.linkText("Sign Out"));
		signOutLink.click();
		Thread.sleep(2000);
			
	}
}