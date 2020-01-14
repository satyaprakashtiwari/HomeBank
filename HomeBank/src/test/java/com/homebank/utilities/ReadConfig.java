package com.homebank.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig() {
		
		File file= new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis= new FileInputStream(file);
			
			pro= new Properties();
			pro.load(fis);
		} catch (IOException e) {
			
			System.out.println("Exception is: "+e.getMessage());
				
		}
		
	}
	
	public String getApplicationURL() {
		return pro.getProperty("baseURL");
	}
	
	public String getUsername() {
		return pro.getProperty("username");
	}
	
	public String getPassword() {
		return pro.getProperty("password");
	}
	
	public String getChromePath() {
		return pro.getProperty("chromePath");
	}
	
	public String getIEPath() {
		return pro.getProperty("iePath");
	}
	
	public String getFirefoxPath() {
		return pro.getProperty("firefoxPath");
	}
	
}
