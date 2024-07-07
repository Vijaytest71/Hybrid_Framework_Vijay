package Amazon_testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Amazon_pages.BaseClass;
import Amazon_pages.LoginPage;
import Amazon_utilities.Helper;


public class LoginTestAmazon extends BaseClass {


	@Test(priority = 1)
	public void loginApp()
	{

		System.out.println("Page Title is: " + driver.getTitle());

		logger = report.createTest("Login to Udemy");

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);

		logger.info("Starting Application");

		loginpage.loginAmazon(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));

		Helper.captureScreenshot(driver);

		logger.pass("Login Success");
	}

	@Test(priority = 2)
	public void loginApp1()
	{


		logger = report.createTest("Logout");

		logger.fail("Logout Failed");
	}
}
