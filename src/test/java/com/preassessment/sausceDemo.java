package com.preassessment;

import com.preassessment.utils.DataReader;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.Test;


public class sausceDemo extends Base {
	WebDriverWait wait;
	@Test
	public void login(ITestContext context) throws InterruptedException {
		String[] loginCred = DataReader.readTestData(context);
		loginPage.loginApplication(loginCred);
		loginPage.waitForElementDis();
		loginPage.verifyLogin();

	}	

	 
}
