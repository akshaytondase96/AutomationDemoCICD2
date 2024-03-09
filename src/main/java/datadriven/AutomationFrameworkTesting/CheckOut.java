package datadriven.AutomationFrameworkTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class CheckOut extends AbstractComponents
{
  WebDriver driver;
  ConfirmPage confirmpage;
 	public CheckOut(WebDriver driver) 
	{
		super(driver);
       this.driver=driver;
       PageFactory.initElements(driver, this);
	}
  
   @FindBy(css="input[placeholder='Select Country']")
   WebElement selectCountry;
   @FindBy(css="section[class*=list-group] button")
   List<WebElement> countryresult;
   @FindBy(css="a[class*='ng-star']")
   WebElement placeorder;
   public ConfirmPage selectCountry(String countryName)
   {
	 
	   Actions a=new Actions(driver);
	   selectCountry.sendKeys(countryName);
	   for(WebElement country:countryresult)
	   {
		   if(country.getText().equalsIgnoreCase(countryName))
		   {
			   country.click();
		   }
	   }
	   a.moveToElement(placeorder).click().build().perform();
	   ConfirmPage confirmpage=new ConfirmPage(driver);
	   return confirmpage;
   }
}
/*
 * 
 * selectCountry.sendKeys(countryName);
 * List<WebElement>countryresult=driver.findElements(By.
 * cssSelector("section[class*=list-group] button")); for(WebElement
 * country:countryresult) { if(country.getText().equalsIgnoreCase(countryName))
 * { country.click(); } } Actions a=new Actions(driver); WebElement
 * placeorder=driver.findElement(By.cssSelector("a[class*='ng-star']"));
 */