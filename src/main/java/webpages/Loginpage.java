package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Loginpage {

	WebDriver driver;
	@FindBy(id="user-name")
	private WebElement txtUsername;
	@FindBy(id="password")
	private WebElement txtPassword;
	@FindBy(id="login-button")
	private WebElement btnLoginButton;
	@FindBy(xpath="//*[@id=\"login_button_container\"]//div[@class=\"error-message-container error\"]/h3")
	private WebElement lblErrormessage;
	
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
    	PageFactory.initElements(driver, this);
	}
	
	public void enterdata(String username,String password)
	{
		txtUsername.clear();
		txtUsername.sendKeys(username);
		txtPassword.clear();
		txtPassword.sendKeys(password);
		btnLoginButton.click();
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public String geterrormessage()
	{
		return lblErrormessage.getText();
		
		
	}
}
