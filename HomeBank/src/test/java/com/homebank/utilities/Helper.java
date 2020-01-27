package com.homebank.utilities;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;


public class Helper {
	
	WebDriver driver;
	
	public WebElement waitsss(WebDriver driver, final WebElement elementIdentifier){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(100)) 
				.pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
				
		

		return wait.until(new Function<WebDriver, WebElement>()
		{
			public WebElement apply(WebDriver driver) {
				return elementIdentifier;
			}
		});
	}
	
	/*// First - set the wait parameters
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			    .withTimeout(Duration.ofSeconds(100)) // set the timeout
			    .pollingEvery(Duration.ofMillis(600)) // set the interval between every 2 tries     
			    .ignoring(NoSuchElementException.class); // don't throw this exception
	
	public void waitThenClick(final WebElement ele) {
		
		// First - set the wait parameters
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		    .withTimeout(Duration.ofSeconds(100)) // set the timeout
		    .pollingEvery(Duration.ofMillis(600)) // set the interval between every 2 tries     
		    .ignoring(NoSuchElementException.class); // don't throw this exception
		// Then - declare the webElement and use a function to find it
		 WebElement waitingElement = wait.until(new Function<WebDriver, WebElement>() {
		                 public WebElement apply(WebDriver driver) {
		                     //return driver.findElement(By.id("Start"));
		                	 return ele;
		                   }
		                 });
		             waitingElement.click();
	}*/
		
	
		
		/*// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(30, SECONDS).pollingEvery(5, SECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id("foo"));
			}
		});*/

		
	

}
