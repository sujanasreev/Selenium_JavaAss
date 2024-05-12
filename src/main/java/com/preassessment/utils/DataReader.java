package com.preassessment.utils;

import org.testng.ITestContext;
import org.testng.annotations.Parameters;

public  class  DataReader {
	

	    public static String[] readTestData(ITestContext context) {
		        // Read parameter values from testng.xml
		        String username = context.getCurrentXmlTest().getParameter("userName");
		        String pwd = context.getCurrentXmlTest().getParameter("password");		 
		 	        
		 return new String[]{username,pwd};
	    }
	
	
}
