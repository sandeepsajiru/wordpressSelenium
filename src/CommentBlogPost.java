import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CommentBlogPost {

	public static void main(String[] args) 
	{
	FirefoxDriver driver = new FirefoxDriver();
	driver.get("http://127.0.0.1/wordpress/wp-login");
	
	driver.findElement(By.id("user_login")).sendKeys("prakash");
	driver.findElement(By.id("user_pass")).sendKeys("prakash");
	driver.findElement(By.id("wp-submit")).click();
	
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    
       
	}
}
