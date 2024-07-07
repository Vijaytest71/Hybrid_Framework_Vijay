package Amazon_utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BrowserFactory {



	public static WebDriver Start_Application(WebDriver driver) {

		driver= new ChromeDriver();

		//driver.get("https://www.amazon.in/");		
		
		driver.get("https://partnerportal.udemy.com/user/login/");
		driver.manage().window().maximize();

		return driver;
	}

	public static void quitBrowser(WebDriver driver)
	{
		driver.close();		
	}

}
