package in.beingzero.framework;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import in.beingzero.framework.pom.GlobalConstants;

public class Framework {

	public static void init() throws FileNotFoundException, IOException
	{
		ConfigReader reader  = new ConfigReader();
		
		String browser = reader.getStringPropertyValue("browserToUse");
		if(browser!=null)
			GlobalConstants.browser = browser;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sandy\\Downloads\\chromedriver_win32\\chromedriver.exe");
		GlobalConstants.driver = getBrowser(GlobalConstants.browser);
	}
	
	private static WebDriver getBrowser(String b) {
		if(b.equals("ie"))
			return new InternetExplorerDriver();
		else if(b.equals("ch"))
			return new ChromeDriver();
		return new FirefoxDriver();
		
	}
	
	public static void uninit()
	{
		GlobalConstants.driver.quit();
	}
	
}
