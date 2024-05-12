package com.preassessment;

import com.preassessment.utils.DataReader;
import org.testng.ITestContext;
import org.testng.annotations.Test;


public class sausceDemo extends Base {

	@Test
	public void login(ITestContext context) throws InterruptedException {
		String[] loginCred = DataReader.readTestData(context);
		loginPage.loginApplication(loginCred);
		loginPage.verifyLogin();
		Thread.sleep(20000);
		
	}	

	 
}
