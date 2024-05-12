package com.preassessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
		
	//WebElement userEmails = driver.findElement(By.id("userEmail"));
	//PageFactory
	
	@FindBy(id="user-name")
	WebElement userEmail;
	
	@FindBy(id="password")
	WebElement userPassword;	
	
	@FindBy(id = "login-button")
	WebElement login;
	
	
	
	public void goTo(String url){
		driver.get(url);
		
	}
	public void loginApplication(String[] loginCred)
	{
		userEmail.sendKeys(loginCred[0]);
		userPassword.sendKeys(loginCred[1]);
		login.click();
		
	}
	public void verifyLogin() {
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.htm");

	}



}
	
	
