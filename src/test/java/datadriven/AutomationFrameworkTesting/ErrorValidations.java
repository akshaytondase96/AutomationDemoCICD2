package datadriven.AutomationFrameworkTesting;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import TestComponents.Retry;
//This is second commit
public class ErrorValidations extends BaseTest
{
@Test(groups="ErrorHandling",retryAnalyzer=Retry.class)
public void submitOrder1() throws IOException
{
   //LandingPage landpage=launchApplication();	
   landpage.loginApplication("avs@gmail.com", "Akshay5572");
   Assert.assertEquals(landpage.errorMessage(),"Incorrect email or password.");
}
}
