package stepdefinitions;

import org.junit.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webpages.Loginpage;

public class loginsteps {
	
	Loginpage pglogin;

	@Given("The user has launched the application")
	public void the_user_has_launched_the_application() {
	   Hooks.driver.get("https://www.saucedemo.com/");
	}
	@When("the user enters {string} and {string}")
	public void the_user_enters_and(String username, String password) {
	    pglogin=new Loginpage(Hooks.driver);
	    pglogin.enterdata(username, password);
	    
	}
	@Then("user lands on homepage")
	public void user_lands_on_homepage() {
		String pagetitle=pglogin.getTitle();
	    Assert.assertEquals("Swag Labs", pagetitle);
	}
	
	@Then("user shown appropriate {string}")
	public void user_shown_errormessage(String validerror)
	{
		String errormessage=pglogin.geterrormessage();
		Assert.assertTrue(errormessage.contains(validerror));
	}



}
