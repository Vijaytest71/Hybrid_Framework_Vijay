package Amazon_utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;

import java.util.Date;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {


	public static String captureScreenshot(WebDriver driver)
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String screenshotpath = System.getProperty("user.dir") + "/Screenshots/Udemy" + getCurrentDateTime() + ".png";
		try {
			//FileHandler.copy(src, new File("./Screenshots/Login.png")) ;
			org.apache.commons.io.FileUtils.copyFile(src, new File(screenshotpath)) ;

			System.out.println("Screenshot Captured");
		}
		catch (Exception e) {
			System.out.println("unable to capture screenshot " + e.getMessage());
		}
		return screenshotpath;
		
		}

	public static String getCurrentDateTime()
	{
		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	
		Date currentdate = new Date();
		
		return customformat.format(currentdate);
	}

}

