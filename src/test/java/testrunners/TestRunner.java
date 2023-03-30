package testrunners;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
	features="src/test/resources/Featurefiles/login.feature",
	glue={"stepdefinitions","hooks"},
	plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	monochrome=true
		
		)
	

public class TestRunner {


}
