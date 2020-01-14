package com.homebank.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.homebank.pages.AddCustomerPage;
import com.homebank.pages.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException {
		
		LoginPage lp= new LoginPage(driver);
		lp.setUsername(username);
		logger.info("entered username");
		lp.setPassword(password);
		logger.info("entered password");
		lp.clickLogin();
		logger.info("clicked Login button");
			
		
		AddCustomerPage addCust= new AddCustomerPage(driver);
		addCust.clickNewCustomer();
		logger.info("going to add new customer");
		
		String name="Ranbir";
		logger.info("going to add customer name");
		addCust.setCustomerName(name);
		
		logger.info("going to select male as gender");
		//addCust.setGenderMale();
		
		logger.info("going to add DOB as 13/01/2020");
		addCust.setDOB("13", "01", "2020");
		
		String adres="Kormangla";
		logger.info("going to add address "+adres);
		addCust.setAddress(adres);
		
		String cty="Bangalore";
		logger.info("going to add city "+cty);
		addCust.setCity(cty);
		
		String state="Karnataka";
		logger.info("going to add state "+state);
		addCust.setState(state);
		
		String pin="560096";
		logger.info("going to add pin "+pin);
		addCust.setPin(pin);
		
		String mob="1234567890";
		logger.info("going to add mobile "+mob);
		addCust.setMobile(mob);
		
		
		String email= randomString()+"@gmail.com";
		logger.info("going to add email "+email);
		addCust.setEmail(email);
		
		String pass= "ranbir123";
		logger.info("going to add password "+pass);
		addCust.setPassowrd(pass);
		
		logger.info("going to click submit");
		addCust.clickSumbit();
		
		Thread.sleep(3000);
		logger.info("going to validate the customer created");
		Assert.assertTrue(driver.getPageSource().contains("Customer Registered Successfully"));
		
		
	}
	
	

}
