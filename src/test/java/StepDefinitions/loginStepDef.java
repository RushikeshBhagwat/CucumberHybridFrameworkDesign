package StepDefinitions;

import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;

import java.util.Properties;

import org.junit.Assert;

import com.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStepDef {
	
	private LoginPage lp=new LoginPage(DriverFactory.getDriver());
	private String extractedTitle;
	ConfigReader cfr;
	Properties p;

	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
	  
		cfr=new ConfigReader();
		p=cfr.ini_prop();
	  DriverFactory.getDriver().get(p.getProperty("loginurl"));
	}

	@When("user get the title of the page")
	public void user_get_the_title_of_the_page() {
	    
		extractedTitle=lp.getLoginPageTitle();
		System.out.println("Extracted title from the login page is:"+extractedTitle);
	   
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
	  
		Assert.assertTrue(extractedTitle.equals(expectedTitle));
	}

	@Then("Forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
	   
		Assert.assertTrue(lp.isForgotPwdLinkDisplayed());
	}

	@When("user enters username {string}")
	public void user_enters_username(String email) {
	   
		lp.enteremailid(email);
	}

	@When("user enters password {string}")
	public void user_enters_password(String pass) {
	    
	    lp.enterpwd(pass);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	   
	   lp.clickLogin();
	}

	
}
