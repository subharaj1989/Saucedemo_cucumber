package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import DriverFactory.driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class Hooks {

	public static WebDriver driver;
	public static Properties prop;
	@BeforeAll
	public static void driversetup()
	{
		driver=driverfactory.driversetup();
		prop=ConfigReader.getproperties();
	}
	@After
	public static void teardown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot,"image/png", scenario.getName());
		}
	}


}
