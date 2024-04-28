package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	
	//Below step is created coz  we will be running in parallel mode
	public static ThreadLocal<WebDriver> tldriver=new ThreadLocal<>();
	
	/**Below method is used to initialize the threadlocal driver on the basis of given browser
	 * 
	 * @param browser
	 * @return this will return tldriver
	 */
	
	public WebDriver initializeDriver(String browser) {
		
		System.out.println("Browser defined in properties file is:"+browser);
		if(browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rushi\\Downloads\\chromedriver-win64latest\\chromedriver-win64\\chromedriver.exe");
			tldriver.set(new ChromeDriver());
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		}
        else if(browser.equalsIgnoreCase("safari")) {
			
			tldriver.set(new SafariDriver());
		}
        else {
        	System.out.println("Please pass correct browser value:"+browser);
        }
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	/**
	 * Below method is used to get the driver with ThreadLocal
	 * @return
	 */
	
	public static synchronized WebDriver getDriver() {
		
		return tldriver.get();
	}
}
