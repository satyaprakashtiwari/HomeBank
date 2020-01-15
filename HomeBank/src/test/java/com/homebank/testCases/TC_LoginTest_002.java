package com.homebank.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.homebank.pages.LoginPage;

public class TC_LoginTest_002 extends BaseClass {
	
	@Test
	public void loginTest3() {
		
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
	
	@Test
	public void loginTest4() {
		
		//test= extent.createTest("loginTest1");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("entered username");
		lp.setPassword(password);
		logger.info("entered password");
		lp.clickLogin();
		logger.info("clicked Login button");
		
		//Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
		Assert.assertEquals(driver.getTitle(), "OrangeHR");
		
	}
	


}