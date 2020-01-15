package com.homebank.testCases;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.homebank.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();

	/*
	 * public String baseURL = "http://demo.guru99.com/v4/index.php"; public String
	 * username = "mgr123"; public String password = "mgr!23";
	 */

	public String baseURL = readConfig.getApplicationURL();
	public String username = readConfig.getUsername();
	public String password = readConfig.getPassword();

	public static WebDriver driver;

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	public static Logger logger;
	
	public File dir;
	public File[] listFiles;

	@BeforeSuite
	public void setExtent() throws IOException {
		Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe /T");
		File dir=new File("Logs");
		File[] listFiles = dir.listFiles();
		for(File file : listFiles){
			System.out.println("Deleting "+file.getName());
			file.delete();
		}
		
		dir=new File("Reports");
		listFiles = dir.listFiles();
		for(File file : listFiles){
			System.out.println("Deleting "+file.getName());
			file.delete();
		}
		
		dir=new File("Screenshots");
		listFiles = dir.listFiles();
		for(File file : listFiles){
			System.out.println("Deleting "+file.getName());
			file.delete();
		}
		
		/*String timeStamp= new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
	

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/Test-Report-"+timeStamp+".html");
		htmlReporter.config().setDocumentTitle("Automation Report"); // sets title
		htmlReporter.config().setReportName("Functional Report"); // sets name of report
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "Execution Server");
		extent.setSystemInfo("OS", "Windows-10");
		extent.setSystemInfo("Browser", "Chrome");*/

		logger = Logger.getLogger("HomeBank");
		PropertyConfigurator.configure("log4j.properties");

	}

	@AfterSuite
	public void endReport() {

		//extent.flush();

	}

	@Parameters({"browser","node"})
	@BeforeMethod
	public void setup(@Optional("chrome") String br, @Optional("192.168.0.111") String node) throws MalformedURLException {

		if (br.equalsIgnoreCase("chrome")) {
			
			/*System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();*/
			String nodeURL="http://"+node+":4444/wd/hub";
			DesiredCapabilities cap= new DesiredCapabilities();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WIN10);
			driver =new RemoteWebDriver(new URL(nodeURL), cap);
			
			//For NODE- run the command-> java -jar selenium-server-standalone-3.141.59.jar -role hub
			//For HUB- run the command-> java -Dwebdriver.chrome.driver="C:\Users\satyatiw\Downloads\myJars\chromedriver.exe" -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.0.110:4444/grid/register/ -port 5555
			//check URL for info : http://192.168.0.111:4444/grid/console

		} else if (br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
			driver = new FirefoxDriver();

		} else if (br.equalsIgnoreCase("ie")) {
			//System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		}

		driver.manage().window().maximize();
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void testdown(ITestResult result) throws IOException {

		/*if (result.getStatus() == ITestResult.FAILURE) {

			test.log(Status.FAIL, "Test case failed is: " + result.getName());// to add name in extent report
			test.log(Status.FAIL, "Test case failed due to: " + result.getThrowable());// to add exception in extent
																						// report

			String screenshot = BaseClass.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshot);// adding screenshot
		}

		else if (result.getStatus() == ITestResult.SKIP) {

			test.log(Status.SKIP, "Test case skipped is: " + result.getName());
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(Status.PASS, "Test case passed is: " + result.getName());
		}*/

		driver.close();;

	}
    //WebDriver driver, 
	public static String getScreenshot(String testName) throws IOException {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/Screenshots/" + testName + "-" + dateName + ".png";
		File dest = new File(destination);
		FileUtils.copyFile(src, dest);

		return destination;
	}
	
    public String randomString() {
		
		return RandomStringUtils.randomAlphanumeric(8);
	}

}
