package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
 
	//1. By locators  OR  Object Repository
	private By emailid=By.xpath("//input[@name='email']");
	private By passwd=By.xpath("//input[@id='input-password']");
	private By lognbtn=By.xpath("//input[@value='Login']");
	private By forgotpasslink=By.linkText("Forgotten Password");
	
	//2. Constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//3. page actions: features(behaviors) of the page in the form of methods
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPwdLinkDisplayed() {
		return driver.findElement(forgotpasslink).isDisplayed();
	}
	
	public void enteremailid(String emailId) {
		driver.findElement(emailid).sendKeys(emailId);
	}
	
	public void enterpwd(String pwd) {
		driver.findElement(passwd).sendKeys(pwd);
	}
    
	public void clickLogin() {
		driver.findElement(lognbtn).click();
	}
	
	public AccountsPage doLogin(String un, String pd) {
		
		driver.findElement(emailid).sendKeys(un);
		driver.findElement(passwd).sendKeys(pd);
		driver.findElement(lognbtn).click();
		return new AccountsPage(driver);
	}
}
