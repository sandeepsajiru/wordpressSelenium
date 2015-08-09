import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class UserTest {
	
	public static void main(String[] args) 
	{
	FirefoxDriver driver = new FirefoxDriver();
	driver.get("http://127.0.0.1/wordpress/wp-login");
	
	driver.findElement(By.id("user_login")).sendKeys("sandeep");
	driver.findElement(By.id("user_pass")).sendKeys("sandeep");
	driver.findElement(By.id("wp-submit")).click();
	
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    
    //mouse over user option and select new user
    Actions act = new Actions(driver);
    act.moveToElement(driver.findElement(By.partialLinkText("Users"))).perform();
    act.click(driver.findElement(By.partialLinkText("Add New"))).perform();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    String username = "abhinay"+System.currentTimeMillis();
	
    //Fill form details and submit
    driver.findElement(By.name("user_login")).sendKeys(username);
    driver.findElement(By.name("email")).sendKeys("postqanew"+System.currentTimeMillis()+"@gmail.com");
    driver.findElement(By.name("first_name")).sendKeys("abhinay");
    driver.findElement(By.name("last_name")).sendKeys("kumar");
    driver.findElement(By.name("url")).sendKeys("https://smartbox.unifiedcloudit.com");
    driver.findElement(By.name("pass1")).sendKeys("Abc@12345");
    driver.findElement(By.name("pass2")).sendKeys("Abc@12345");
    
    Select dropdown = new Select(driver.findElement(By.name("role")));
    dropdown.selectByVisibleText("Author");
    
    driver.findElement(By.name("createuser")).submit();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //table row count
    WebElement tbody = driver.findElement(By.id("the-list"));
	int t1 = tbody.findElements(By.tagName("tr")).size();
	System.out.println("Before Deleting the User No of Rows :" + t1);
    
    //Search user
    driver.findElement(By.name("s")).sendKeys(username);
    driver.findElement(By.id("search-submit")).click();
    driver.findElement(By.name("users[]")).click();
    
    //role change
    Select dropdown1 = new Select(driver.findElement(By.id("new_role")));
    dropdown1.selectByVisibleText("Editor");
    driver.findElement(By.name("changeit")).click();
    
    //delete the user
//    driver.findElement(By.name("s")).sendKeys("abhinay");
//    driver.findElement(By.id("search-submit")).click();
//    driver.findElement(By.name("users[]")).click();
//    Select dropdown2 = new Select(driver.findElement(By.id("bulk-action-selector-top")));
//    dropdown2.selectByVisibleText("Delete");
//    driver.findElement(By.id("doaction")).click();
    
   ;
    Actions act1 = new Actions(driver);
    act1.moveToElement( driver.findElement(By.partialLinkText(username))).perform();
    //act1.moveToElement(driver.findElement(By.partialLinkText("Delete"))).perform();
    driver.findElement(By.partialLinkText("Delete")).click();
    driver.findElement(By.id("delete_option0")).click();
    driver.findElement(By.id("submit")).click();
    
  //table row count
	WebElement tbody1 = driver.findElement(By.id("the-list"));
	int t2 = tbody1.findElements(By.tagName("tr")).size();
	System.out.println("After Deleting the User No of Rows :" + t2);
		
	}

}
