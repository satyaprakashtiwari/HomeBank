package com.homebank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	//WebDriver ldriver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		//ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUsername;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText="Log out")
	WebElement lnkLogout;
	
	public void setUsername(String usr) {
		txtUsername.clear();
		txtUsername.sendKeys(usr);
	}
	
	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
	
	
	/*@FindBy(name="txtUsername")
	@CacheLookup
	WebElement txtUsername;
	
	@FindBy(name="txtPassword")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(id="btnLogin")
	@CacheLookup
	WebElement btnLogin;*/
	
	
	
	
}
