package webpages;

import java.util.ArrayList;
import java.util.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.sessionvariables;

public class productlistpage {

	WebDriver driver;
	@FindBy(xpath="//*[@id=\"header_container\"]//span/select[@class=\"product_sort_container\"]")
	WebElement ddSort;

	@FindBy(xpath="//*[@id=\"inventory_container\"]//div[@class=\"inventory_item_name\"]")
	List<WebElement> lproductname;

	@FindBy(xpath="//*[@id=\"inventory_container\"]//div[@class=\"inventory_item_price\"]")
	List<WebElement> lproductprice;
	
	@FindBy(xpath="//button[contains(@id,\"add-to-cart\")]")
	List<WebElement> laddtoCart;
	
	@FindBy(xpath="//*[@id=\"shopping_cart_container\"]/a/span[@class=\"shopping_cart_badge\"]")
	WebElement lblCarticon;
	static int count=0;


	public productlistpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void sort(String sortbytext)
	{
		Select ssortby=new Select(ddSort);
		ssortby.selectByVisibleText(sortbytext);

	}

	public boolean sortvalidation(String sortbytext)
	{
		List<String> product=new ArrayList<>();
		List<Double> lprice=new ArrayList<>();
		boolean isSorted=false;
		if(sortbytext.contains("Name"))
		{
			for(WebElement name:lproductname)
			{
				product.add(name.getText());
			}
			
		}
		else
		{
			for(WebElement price:lproductprice)
			{
				
				double Productprice=Double.parseDouble(price.getText().replace("$",""));
				
				lprice.add(Productprice);
				
			}
		}
		

		if(sortbytext.equals("Name (A to Z)"))
		{
			isSorted=product.stream().sorted().collect(Collectors.toList()).equals(product);
		}
		else if(sortbytext.equals("Name (Z to A)"))
		{
			List<String> reverselist=new ArrayList<>();
			reverselist.addAll(product);
			Collections.sort(reverselist,Collections.reverseOrder());
			isSorted=product.equals(reverselist);


		}
		
		else if(sortbytext.equals("Price (low to high)"))
		{
			isSorted=lprice.stream().sorted().collect(Collectors.toList()).equals(lprice);
		}
		
		else if(sortbytext.equals("Price (high to low)"))
		{
			List<Double> reverselist=new ArrayList<>();
			reverselist.addAll(lprice);
			Collections.sort(reverselist,Collections.reverseOrder());
			isSorted=lprice.equals(reverselist);

		}
		
		return isSorted;
	}
	
	public void AddtoCart(String productname)
	{
		for(int i=0;i<lproductname.size();i++)
		{
			if(lproductname.get(i).getText().equals(productname))
			{
				laddtoCart.get(i).click();
				count++;
				break;
			}
		}
		
		sessionvariables.setname(Integer.toString(count));
	}
	
	public String getCartCount()
	{
		return lblCarticon.getText();
	}

}
