package parallelonlyforTestNG;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverfactory;
	private ConfigReader cfreader;
	private WebDriver driver;
	Properties prop;
	
	//Below method we are adding to skip the scenarios
	@Before(value="@skip_scenario",order=0)
	public void skipScenario(Scenario sc) {
		System.out.println("Skipped scenario is:"+sc.getName());
		Assume.assumeTrue(false);
	}
	
	@Before(order=1)
	public void getProperty() {
		
		cfreader=new ConfigReader();
		prop=cfreader.ini_prop();
	}
	
	@Before(order=2)
	public void launchBrowser() {
		
		String browserName=prop.getProperty("browser");
		driverfactory=new DriverFactory();
		driver=driverfactory.initializeDriver(browserName);
	}
	
	@After(order=0)
	public void quitBrowser() {
		
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario) {
		
		if(scenario.isFailed()) {
			
			//Take screenshot
			String screenshotName=scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}

}
