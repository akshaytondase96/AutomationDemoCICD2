package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;

import datadriven.AutomationFrameworkTesting.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest
{
	public LandingPage landpage;
	public WebDriver driver;
 public WebDriver initialize() throws IOException
 {
	 Properties prop=new Properties();
     FileInputStream fis=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\AutomationFrameworkTesting\\src\\main\\java\\Resources\\GlobalData.properties");
	prop.load(fis);
    String browserName=System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
    		if(browserName.equals("chrome"))
    {
    	ChromeOptions options=new ChromeOptions();		
    	//options.addArguments("headless");   
    	WebDriverManager.chromedriver().setup();
   	  WebDriver driver=new ChromeDriver();
   	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	 return driver;
    }
    else
    {
    EdgeOptions options=new EdgeOptions();		
    options.addArguments("headless");
     WebDriverManager.edgedriver().setup();
   	 WebDriver driver=new EdgeDriver(options);
     driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	 return driver;
    }
    
 }
 public List<HashMap<String, String>> getJsonData() throws IOException
 {
  String jsonContent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\data\\PurchaseOrder.json"),StandardCharsets.UTF_8);
  ObjectMapper obj=new ObjectMapper();
  List<HashMap<String,String>> data=obj.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>(){});
  return data;
 }
 public String getScreenShot(String methodname,WebDriver driver) throws IOException
 {
	 TakesScreenshot ts=(TakesScreenshot)driver;
	 File src=ts.getScreenshotAs(OutputType.FILE);
     FileUtils.copyFile(src,new File("D:\\Akshay\\Screenshot\\huy.png"));
     return "D:\\Akshay\\Screenshot\\huy.png";
 }
 @BeforeMethod(alwaysRun=true)
 public LandingPage launchApplication() throws IOException
 {
	 driver=initialize();
	  landpage=new LandingPage(driver);
	 landpage.goTo();
	 return landpage;
 }
}
