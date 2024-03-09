package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg 
{
	public static ExtentReports getExtentObject()
	{
  String path=System.getProperty("user.dir")+"\\reports\\index.html";
  ExtentSparkReporter report=new ExtentSparkReporter(path);
  report.config().setReportName("Automation results");
  report.config().setDocumentTitle("Test results");
  ExtentReports extent=new ExtentReports();
  extent.attachReporter(report);
  extent.setSystemInfo("Tester", "Akshay");
  return extent;
	}
}