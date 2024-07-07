package Amazon_pages;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Amazon_utilities.BrowserFactory;
import Amazon_utilities.ExcelDataProvider;
import Amazon_utilities.Helper;

public class BaseClass {


	public WebDriver driver;
	public ExcelDataProvider excel;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpsuite()
	{
		Reporter.log("Setting up reports and Test is getting Ready", true);
		
		excel = new ExcelDataProvider();
		report = new ExtentReports();
		
		ExtentSparkReporter extent = new ExtentSparkReporter(new File("./Reports/" + Helper.getCurrentDateTime() + "Udemy.html"));
		
		report.attachReporter(extent);

		Reporter.log("Setting Done - Test can be Started", true);
	}

	@BeforeClass
	public void setup()
	{
		Reporter.log("Trying to start Browser", true);
		driver = BrowserFactory.Start_Application(driver);
		
		Reporter.log("Browser and Application is up and running", true);
	}

	@AfterClass
	public void teardown()
	{
		BrowserFactory.quitBrowser(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		Reporter.log("Test is about to end", true);
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//Helper.captureScreenshot(driver);
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
			
		
		report.flush();
		Reporter.log("Test Completed", true);
	}
	
	
}
