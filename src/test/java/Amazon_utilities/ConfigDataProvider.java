package Amazon_utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider()
	{

		File src =  new File("./Config/Config.properties");

		try {
			FileInputStream fis = new FileInputStream(src); 

			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e )
		{
			System.out.println("Not able to load config file " + e.getMessage());
		}
	}
	
	public String getDataFromConfig(String ketToSearch)
	{		
	return pro.getProperty(ketToSearch);	
		
	}
	public String getBrower()
	{
		return pro.getProperty("Browser");
		
		
	}
	public String getStagingURL()
	{
		
		return pro.getProperty("qaURL"); 
		
	}
}
