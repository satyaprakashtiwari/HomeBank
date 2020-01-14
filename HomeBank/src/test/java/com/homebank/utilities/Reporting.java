package com.homebank.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.homebank.testCases.BaseClass;
//implements ITestListener     extends TestListenerAdapter
public class Reporting implements ITestListener {

	public WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	public void onTestSuccess(ITestResult result) {
		
		test= extent.createTest(result.getName());
		test.log(Status.PASS, "Test case passed is: " + result.getName());
		
	}

	
	
	public void onTestFailure(ITestResult result) {
		
        test= extent.createTest(result.getName());
		
		test.log(Status.FAIL, "Test case failed is: " + result.getName());// to add name in extent report
		test.log(Status.FAIL, "Test case failed due to: " + result.getThrowable());// to add exception in extent
																					// report

		/*ITestContext context = result.getTestContext();
	    WebDriver driver = (WebDriver)context.getAttribute("driver");*/
		try {
			//((BaseClass)result.getInstance()).driver, 
			String screenshot = BaseClass.getScreenshot(result.getName());
			test.addScreenCaptureFromPath(screenshot);// adding screenshot
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	public void onTestSkipped(ITestResult result) {
		
		test= extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case skipped is: " + result.getName());
		
	}

	
	
	public void onTestFailedWithTimeout(ITestResult tr) {
		
	}

	
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
		
	}

	
	
	public void onStart(ITestContext testContext) {
		
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/Test-Report-"+timeStamp+".html");
		htmlReporter.config().setDocumentTitle("Automation Report"); // sets title
		htmlReporter.config().setReportName("Functional Report"); // sets name of report
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "Execution Server");
		extent.setSystemInfo("OS", "Windows-10");
		extent.setSystemInfo("Browser", "Chrome");
		
	}

	
	
	public void onFinish(ITestContext testContext) {
		
		extent.flush();
	}

	
	
	public void onTestStart(ITestResult result) {
		
	}

	
	public void onConfigurationFailure(ITestResult itr) {
		
	}

	
	public void onConfigurationSkip(ITestResult itr) {
		
	}

	
	public void onConfigurationSuccess(ITestResult itr) {
		
	}

}
