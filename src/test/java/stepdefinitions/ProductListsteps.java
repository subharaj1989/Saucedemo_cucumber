package stepdefinitions;



import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigReader;
import utils.sessionvariables;
import webpages.Loginpage;
import webpages.productlistpage;

public class ProductListsteps {
	
	Loginpage pglogin;
	productlistpage pgproductlist;

	@Given("the user is on the product list page")
	public void the_user_is_on_the_product_list_page() {
		pglogin=new Loginpage(Hooks.driver);
		Hooks.driver.get(Hooks.prop.getProperty("url"));
		pglogin.enterdata(Hooks.prop.getProperty("username"), Hooks.prop.getProperty("password"));
	}
	@When("the user selects {string} from the Sort dropdown")
	public void the_user_selects_from_the_sort_dropdown(String sortbytext) {
	   pgproductlist=new productlistpage(Hooks.driver);
	   pgproductlist.sort(sortbytext);
	   sessionvariables.setname(sortbytext);
	   
	}
	@Then("the product list should be sorted according to the selelction made")
	public void the_product_list_should_be_sorted_according_to_the_selelction_made() {
	   boolean isSorted= pgproductlist.sortvalidation(sessionvariables.getname());
	   Assert.assertTrue(isSorted);
	}
	
	@When("the user clicks on the add to cart for {string}")
	public void the_user_clicks_on_the_add_to_cart_for(String productname) {
		 pgproductlist=new productlistpage(Hooks.driver);
		 pgproductlist.AddtoCart(productname);
		 
	}
	@Then("the count displayed in the Cart icon should be equal to the number of products added")
	public void the_count_displayed_in_the_cart_icon() {
	    Assert.assertEquals(pgproductlist.getCartCount(),sessionvariables.getname());
	}
	



	
}
