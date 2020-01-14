package com.homebank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.LINK_TEXT, using="New Customer")
	@CacheLookup
	WebElement lnkNewCustomer;
	
	public void clickNewCustomer() {
		lnkNewCustomer.click();
	}
	
	@FindBy(how=How.NAME, using="name")
	@CacheLookup
	WebElement txtCustomerName;
	
	public void setCustomerName(String name) {
		txtCustomerName.sendKeys(name);
	}
	
	
	@FindBy(how=How.NAME, using="//input[@name='rad1' and @value='m']")
	@CacheLookup
	WebElement rdGenderMale;
	
	public void setGenderMale() {
		rdGenderMale.click();
	}
	
	@FindBy(how=How.NAME, using="//input[@name='rad1' and @value='f']")
	@CacheLookup
	WebElement rdGenderFemale;
	
	public void setGenderFemale() {
		rdGenderFemale.click();
	}
	
	@FindBy(how=How.ID_OR_NAME, using="dob")
	@CacheLookup
	WebElement txtDOB;
	
	public void setDOB(String dd, String mm, String yyyy) {
		txtDOB.sendKeys(dd);
		txtDOB.sendKeys(mm);
		txtDOB.sendKeys(yyyy);
	}
	
	@FindBy(how=How.XPATH, using="//textarea[@name='addr']")
	@CacheLookup
	WebElement txtAddress;
	
	public void setAddress(String adr) {
		txtAddress.sendKeys(adr);
	}
	
	@FindBy(how=How.NAME, using="city")
	@CacheLookup
	WebElement txtCity;
	
	public void setCity(String city) {
		txtCity.sendKeys(city);
	}
	
	@FindBy(how=How.NAME, using="state")
	@CacheLookup
	WebElement txtState;
	
	public void setState(String state) {
		txtState.sendKeys(state);
	}
	
	@FindBy(how=How.NAME, using="pinno")
	@CacheLookup
	WebElement txtPin;
	
	public void setPin(String pin) {
		txtPin.sendKeys(pin);
	}

	@FindBy(how=How.NAME, using="telephoneno")
	WebElement txtMobile;
	
	public void setMobile(String mobile) {
		txtMobile.sendKeys(mobile);
	}
	
	@FindBy(how=How.NAME, using="emailid")
	WebElement txtEmail;
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	@FindBy(how=How.NAME, using="password")
	WebElement txtPassword;
	
	public void setPassowrd(String pw) {
		txtPassword.sendKeys(pw);
	}
	
	@FindBy(how=How.NAME, using="sub")
	WebElement btnSubmit;
	
	public void clickSumbit() {
		btnSubmit.click();
	} 
	
	
	
	
	
}
