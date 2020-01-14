package com.homebank.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.homebank.pages.LoginPage;
import com.homebank.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider="LoginData")
	public void loginDDT(String username, String password) throws InterruptedException {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("entered username");
		lp.setPassword(password);
		logger.info("entered password");
		lp.clickLogin();
		logger.info("clicked Login button");
		Thread.sleep(3000);
		
		if(isAlertPresent()) {
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
			logger.error("login failed");
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("clicked on logout link");
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("login passed");
		}
	
	}
	
	//method to check alert present or not
	public boolean isAlertPresent() {
		
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		
		String path="./TestData/LoginData.xlsx";
		
		int rowNum= XLUtils.getRowCount(path,"Sheet1"); //3
		logger.info("number of rows are: "+rowNum);
		
		int colCount= XLUtils.getCellCount(path, "Sheet1", 1); //2
		logger.info("number of columns are: "+colCount);
		
		String[][] loginData= new String[rowNum][colCount];
		
		for(int i=1;i<=rowNum;i++) {
			
			for(int j=0;j<colCount;j++) {
				
				loginData[i-1][j]= XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}
	
}
