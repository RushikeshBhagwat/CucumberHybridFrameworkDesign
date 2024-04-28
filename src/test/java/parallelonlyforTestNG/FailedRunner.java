package parallelonlyforTestNG;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//This class is created for rerunning the failed cases and the rerun path is given


@CucumberOptions(features= "@target/rerun.txt",glue= "parallelonlyforTestNG",plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","timeline:test-output-thread/"
		,"rerun:target/rerun.txt"})

public class FailedRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		
		return super.scenarios();
	}
}
