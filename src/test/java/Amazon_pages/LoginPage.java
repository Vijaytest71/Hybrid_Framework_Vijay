package Amazon_pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver ldriver)
	{
		

		this.driver = ldriver;
	}
	
	@FindBy(xpath="//input[@id='UserName']") WebElement uname;

	@FindBy(id="Password") WebElement pass;

	@FindBy(xpath="//input[@id='body_BtnLogin']") WebElement loginbutton;

	public void loginAmazon(String username, String password )
	{
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(uname));
		
		uname.sendKeys(username);
		pass.sendKeys(password);
		loginbutton.click();
	}

}
