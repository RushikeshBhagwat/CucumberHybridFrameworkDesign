package parallelonlyforTestNG;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features= "src/test/resources/parallelforTestNG",glue= "parallelonlyforTestNG",plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","timeline:test-output-thread/"
		,"rerun:target/rerun.txt"})

public class ParallelRun extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		
		return super.scenarios();
	}

}
