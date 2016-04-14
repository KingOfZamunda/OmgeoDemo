/**
* Author:  Yawo Amegadje
* Function: This class is designed to be the Browser selector
* It takes the browser type as string ( Ex: Firefox, Chrome, IE) then get the appropriate driver
* Once complete it returns the selected driver to the calling class.
*/
package com.omgeo.automationdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserSelector {
	
	String browserType = null;
	
	public BrowserSelector(String browserType) {
		this.browserType = browserType;
	}
	
	public WebDriver getDriver()
	{
		WebDriver selectedDriver = null;
		
		switch (browserType)
		{
		case "Firefox":
			 selectedDriver = new FirefoxDriver();
			 break;
			 
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "browser_drivers/chromedriver.exe"); 
			selectedDriver = new ChromeDriver();
			 break;
			 	 
		case "IE":
			System.setProperty("webdriver.chrome.driver", "browser_drivers/IEDriverServer.exe");
			selectedDriver = new InternetExplorerDriver();
		
		default:
			selectedDriver = new ChromeDriver();
			 break;
		}
		return selectedDriver;
	}

}
