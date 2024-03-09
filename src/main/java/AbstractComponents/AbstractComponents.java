package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents 
{
  WebDriver driver;
  WebDriverWait wait;
  
  
  @FindBy(css="#toast-container")
	WebElement logMsg;
  @FindBy(css="button[routerlink*='/cart']")
	WebElement Cart;
  public AbstractComponents(WebDriver driver)
  {
	  this.driver=driver;
	// TODO Auto-generated constructor stub
}

public void waitForInvisibilityOfElement(WebElement element)
  {
	  wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	  wait.until(ExpectedConditions.invisibilityOf(logMsg));
  }
public void waitForVisibilityOfElement(WebElement element)
{
	  wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	  wait.until(ExpectedConditions.visibilityOf(logMsg));
}
public void goToCart()
{
	Cart.click();
}
}

