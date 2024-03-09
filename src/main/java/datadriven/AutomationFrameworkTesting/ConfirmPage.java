package datadriven.AutomationFrameworkTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import AbstractComponents.AbstractComponents;

public class ConfirmPage extends AbstractComponents
{
    WebDriver driver;
	public ConfirmPage(WebDriver driver)
	{
		super(driver);
      this.driver=driver;
      PageFactory.initElements(driver,this);
	}
  @FindBy(css=".hero-primary")
  WebElement successMsg;
  public String confirmationMessage()
  {
	  return successMsg.getText();
  }
}
//Assert.assertEquals(driver.findElement(By.cssSelector(".hero-primary")).getText(), "THANKYOU FOR THE ORDER.");