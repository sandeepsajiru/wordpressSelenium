package in.beingzero.framwork.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class NewUser extends PageBase {

	public NewUser(WebDriver driver) {
		super(driver);
	}
	
	public Users fillform(String username, String email, String pwd, String rpwd, String role)
	{
		driver.findElement(By.name("user_login")).sendKeys(username);
	    driver.findElement(By.name("email")).sendKeys(email);
	    //driver.findElement(By.name("first_name")).sendKeys("abhinay");
	    //driver.findElement(By.name("last_name")).sendKeys("kumar");
	    //driver.findElement(By.name("url")).sendKeys("https://smartbox.unifiedcloudit.com");
	    driver.findElement(By.name("pass1")).sendKeys(pwd);
	    driver.findElement(By.name("pass2")).sendKeys(rpwd); 
	    Select dropdown = new Select(driver.findElement(By.name("role")));
	    dropdown.selectByVisibleText(role);
	    
	    driver.findElement(By.name("createuser")).submit();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new Users(driver);	
	}

}
