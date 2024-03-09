package datadriven.AutomationFrameworkTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents
{ 
	WebDriver driver;
	public ProductCatalog productcatalog;
	  public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="userEmail")
	WebElement useremail;
	@FindBy(id="userPassword")
	WebElement userpass;
	@FindBy(id="login")
	WebElement submit;
	@FindBy(css="#toast-container")
	WebElement logMsg;
	
	public ProductCatalog loginApplication(String username,String password)
	{
		useremail.sendKeys(username);
		userpass.sendKeys(password);
		submit.click();
		 productcatalog=new ProductCatalog(driver);
		 return productcatalog;
		 
	}
	public String errorMessage()
	{
		waitForVisibilityOfElement(logMsg);
	    return logMsg.getText();	
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
}
