package datadriven.AutomationFrameworkTesting;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import TestComponents.Retry;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest extends BaseTest
{
     @Test(dataProvider= "getData",groups= {"Purchase"})
      public void submitOrder(HashMap<String,String> input) throws IOException
      {
    	//LandingPage landpage=launchApplication();
		ProductCatalog productcatalog=landpage.loginApplication(input.get("email"),input.get("password"));
	    productcatalog.addToCart(input.get("productName"));
	    CartPage cartpage=productcatalog.goToOderPage(input.get("productName"));
	    Boolean m=cartpage.verifyProducts(input.get("productName"));
	    Assert.assertTrue(m);
	    CheckOut checkout=cartpage.goToCheckOutPage();
	    ConfirmPage confirmpage=checkout.selectCountry(input.get("countryName"));
	    Assert.assertEquals(confirmpage.confirmationMessage(),"THANKYOU FOR THE ORDER.");
      }
     @Test(dependsOnMethods= {"submitOrder"})
     public void orderHistory()
     {
      ProductCatalog productcatalog=landpage.loginApplication("avs@gmail.com", "Akshay5572");
       CartPage cartpage=productcatalog. goToOderPage("ADIDAS ORIGINAL");
       Assert.assertTrue(cartpage.verifyProducts("ADIDAS ORIGINAL"));
     }
     @DataProvider
     public Object[][] getData() throws IOException
     {
    	 List<HashMap<String,String>> data=getJsonData();
    	return new Object[][] {{data.get(0)}};
     }
}
