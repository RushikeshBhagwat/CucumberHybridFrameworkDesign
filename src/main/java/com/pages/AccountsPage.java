package com.pages;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	By accountSection=By.xpath("(//div[@id='content']/child::ul[@class='list-unstyled'])[1]");
	
	public AccountsPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public String getAccountPageTitle() {
		
		return driver.getTitle();
	}
	
	public int getMyAccountSectionCount() {
		
		return driver.findElements(accountSection).size();
	}
	
	public List<String> getAccountSectionList() {
		
		//Creating one arraylist for storing the texts of webelement
		ArrayList<String> accsectionTextList=new ArrayList<>();
		
		List<WebElement> accsectionHeaders=driver.findElements(accountSection);
		
		for(WebElement e: accsectionHeaders) {
			
			String text=e.getText();
			System.out.println(text);
			
			//Now add it in a arryalist for storing
			accsectionTextList.add(text);
		}
		
		return accsectionTextList;
	}
}
