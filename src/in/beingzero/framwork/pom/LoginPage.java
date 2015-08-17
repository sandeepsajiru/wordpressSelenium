package in.beingzero.framwork.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{

	public LoginPage() {
		
	}
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public DashBoard loginPage(String un, String pwd) {
		
		driver.get("http://127.0.0.1/wordpress/wp-login");
		driver.findElement(By.id("user_login")).sendKeys(un);
		driver.findElement(By.id("user_pass")).sendKeys(pwd);
		driver.findElement(By.id("wp-submit")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    return new DashBoard(driver);
	}
	
		
	

}
