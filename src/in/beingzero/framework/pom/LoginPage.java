package in.beingzero.framework.pom;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase{
    //WebDriver driver;
    
	public LoginPage()
	{	GlobalConstants.driver.manage().window().maximize();
		GlobalConstants.driver.get(GlobalConstants.loginPageUrl);
	}
	public ScreenDismiss loginUser(String username, String pwd)
	{
		
		//Login user
		GlobalConstants.driver.findElement(By.name("log")).sendKeys(username);
		GlobalConstants.driver.findElement(By.name("pwd")).sendKeys(pwd);
		
		WebElement display = GlobalConstants.driver.findElement(By.name("rememberme"));
		//System.out.println("IsChecked: "+display.isSelected());
		display.click();
		
		//Click Login
		GlobalConstants.driver.findElement(By.id("wp-submit")).click();
		GlobalConstants.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return new ScreenDismiss();
	}
}
