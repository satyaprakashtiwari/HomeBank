package com.homebank.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.homebank.pages.LoginPage;
import com.homebank.utilities.ScreenRecorderUtil;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest1() throws Exception {
		ScreenRecorderUtil.startRecord("loginTest1");
		//test= extent.createTest("loginTest1");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("entered username");
		lp.setPassword(password);
		logger.info("entered password");
		lp.clickLogin();
		logger.info("clicked Login button");
		
		//Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
		//Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		ScreenRecorderUtil.stopRecord();
		
	}
	
	//@Test
	public void loginTest2() {
		
		//test= extent.createTest("loginTest1");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("entered username");
		lp.setPassword(password);
		logger.info("entered password");
		lp.clickLogin();
		logger.info("clicked Login button");
		
		//Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
	}
	


}
