package datadriven.AutomationFrameworkTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents
{
   WebDriver driver;
   CheckOut checkout;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	 @FindBy(xpath="//button[text()='Checkout']")
	   WebElement CheckoutButton;
	@FindBy(css=".cartSection h3")
	List<WebElement> myCartItems;
	public Boolean verifyProducts(String productName)
	{
	  Boolean match=myCartItems.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
	  return match;
  	}
    public CheckOut goToCheckOutPage()
    {
    	CheckoutButton.click();
    	checkout=new CheckOut(driver);
    	return checkout;
    }
}
