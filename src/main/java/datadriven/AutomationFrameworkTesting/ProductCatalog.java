package datadriven.AutomationFrameworkTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponents.AbstractComponents;

public class ProductCatalog extends AbstractComponents
{
	WebDriver driver;
	CartPage cartpage;
	 
	public ProductCatalog(WebDriver driver)
	{
     super(driver);
     this.driver=driver;
     PageFactory.initElements(driver,this);
	}
	@FindBy(css=".mb-3")
	List<WebElement> products;
	@FindBy(id="login")
	WebElement submit;
	By addToCart=By.cssSelector(".card-body i[class*='fa fa-shopping-cart']");
	@FindBy(css="button[routerlink*='/cart']")
	WebElement Cart;
	public void addToCart(String productName)
	{
		WebElement prod=products.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(addToCart).click();
		waitForInvisibilityOfElement(driver.findElement(By.cssSelector("div[class*='toast-bottom']")));		 
	}
	public CartPage goToOderPage(String productName)
	{
		Cart.click();
		cartpage=new CartPage(driver);
		 cartpage.verifyProducts(productName);
		 return cartpage;
	}
}
