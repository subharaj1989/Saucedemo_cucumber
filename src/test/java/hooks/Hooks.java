package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import DriverFactory.driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

	public static WebDriver driver;
	@BeforeAll
	public static void driversetup()
	{
		driver=driverfactory.driversetup();
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
