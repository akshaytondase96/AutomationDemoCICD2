package StepDefinarions;

import java.io.IOException;

import org.testng.Assert;

import TestComponents.BaseTest;
import datadriven.AutomationFrameworkTesting.CartPage;
import datadriven.AutomationFrameworkTesting.CheckOut;
import datadriven.AutomationFrameworkTesting.ConfirmPage;
import datadriven.AutomationFrameworkTesting.LandingPage;
import datadriven.AutomationFrameworkTesting.ProductCatalog;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationImpl extends BaseTest
{
	public LandingPage landpage;
    public ProductCatalog productcatalog;
    public CartPage cartpage;
    public ConfirmPage confirmpage;
    public CheckOut checkout;
	@Given("I landed on E-commerce page.")
  public void i_landed_on_Ecommerce_page() throws IOException
  {
	 landpage=launchApplication();
  }
  @Given("^Logged in with Username (.+) and password (.+)$")
  public void logged_with_username_and_password(String username,String password)
  {
	  ProductCatalog productcatalog=landpage.loginApplication(username,password);  
  }
  @When("^add product(.+)to cart$")
  public void add_product_to_cart(String productName)
  {
	  productcatalog.addToCart(productName);
} 
  @And("^checkout <productName> and submit order$")
  public void checkout_and_submit_the_order(String productName)
  {
	   cartpage=productcatalog.goToOderPage(productName);
	    Boolean m=cartpage.verifyProducts(productName);
	    Assert.assertTrue(m);
	     checkout=cartpage.goToCheckOutPage();
	     confirmpage=checkout.selectCountry("India");
  }
  @Then("verify the message {string} is displayed on confirmation page")
  public void verify_the_msg_displayed_on_confirmpage(String string)
  {
	  Assert.assertEquals(confirmpage.confirmationMessage(),string);
}
}