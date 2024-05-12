package com.preassessment;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.preassessment.utils.ExtentReportNG;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class listener extends Base implements ITestListener {
	ExtentTest test;
	ExtentReports extent = ExtentReportNG.getReportObject();
	WebDriver driver;
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String filePath = null;
		try {
			System.out.println("Within Try block");
			filePath = captureScreenshot(driver,result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Before attaching report");

     test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
		//Screenshot, Attach to report


	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();

	}


}



