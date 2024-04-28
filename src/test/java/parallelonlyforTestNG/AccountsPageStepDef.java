package parallelonlyforTestNG;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageStepDef {
	
	private LoginPage lp=new LoginPage(DriverFactory.getDriver());
	private AccountsPage accpg;
	ConfigReader cfr;
	Properties p;
	
	@Given("User has already logged into application")
	public void user_has_already_logged_into_application(DataTable credTable) {
	    
		List<Map<String,String>> credList=credTable.asMaps();
		String userNm=credList.get(0).get("username");
		String passwd=credList.get(0).get("password");
		
		cfr=new ConfigReader();
		p=cfr.ini_prop();
		
		DriverFactory.getDriver().get(p.getProperty("loginurl"));
		accpg=lp.doLogin(userNm, passwd);
	}

	@Given("User is on the accounts page")
	public void user_is_on_the_accounts_page() {
	   
		String pgTitle=accpg.getAccountPageTitle();
		System.out.println("Accounts Page Title is:"+pgTitle);
	}

	@Then("User gets account section")
	public void user_gets_account_section(DataTable sectionsTable) {
	
		List<String> expAccountSectionList=sectionsTable.asList();
		System.out.println("Expected Account Section list:"+expAccountSectionList);
		
		List<String> actAccountSectionList=accpg.getAccountSectionList();
		System.out.println("Actual account Section list:"+actAccountSectionList);
		
		if(expAccountSectionList.containsAll(actAccountSectionList)) {
			
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(false);
		}
		
	}

	@Then("Accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedCount) {
		
		int actCount=accpg.getMyAccountSectionCount();
	    
		System.out.println(actCount);
		if(expectedCount==actCount) {
			Assert.assertTrue(true);
			
		}
		else {
			Assert.assertFalse(false);
		}
	}


}
