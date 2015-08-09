import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class InstallPlugIn {

	public static void main(String[] args) 
	{
	FirefoxDriver driver = new FirefoxDriver();
	driver.get("http://127.0.0.1/wordpress/wp-login");
	
	driver.findElement(By.id("user_login")).sendKeys("prakash");
	driver.findElement(By.id("user_pass")).sendKeys("prakash");
	driver.findElement(By.id("wp-submit")).click();
	
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    
    //mouse over user option and select new user
    Actions act = new Actions(driver);
    act.moveToElement(driver.findElement(By.partialLinkText("Plugins"))).perform();
    act.click(driver.findElement(By.partialLinkText("Add New"))).perform();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    driver.findElement(By.name("s")).sendKeys("Easy Google Fonts");
    driver.findElement(By.name("s")).sendKeys(Keys.ENTER);
    
    driver.findElement(By.partialLinkText("Easy Google Fonts")).click();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.findElement(By.partialLinkText("Install Now")).click();
    
    driver.findElement(By.partialLinkText("Plugins")).click();
    //driver.findElement(By.name("s")).sendKeys("Easy Google Fonts");
    //driver.findElement(By.id("search-submit")).submit();
    
    //WebElement table = driver.findElement(By.id("the-list"));
//    List<WebElement> rows = table.findElements(By.tagName("tr"));
//    int count = rows.size();
//    for (WebElement items : rows)
//    {
//     System.out.println(items.getText());
//     if(items.getText().equals("Easy Google Fonts"))
//    	{
//    		System.out.println("PlugIn is Installed in the Website");
//    		//driver.findElement(By.partialLinkText("Delete")).click();
//    		//driver.findElement(By.id("submit")).submit();
//    		break;
//    	}
//    else
//	    {
//	    	System.out.println("PlugIn not Installed in the Website");
//	    }
   WebElement text = driver.findElement(By.xpath("//input[@value='easy-google-fonts/easy-google-fonts.php']"));
   if(text.isDisplayed())
     {
	   System.out.println("PlugIn is installed");
	   driver.findElement(By.xpath("//*[@id='easy-google-fonts']/td[1]/div/span[3]/a")).click();
	   driver.findElement(By.xpath("//input[@value='Yes, Delete these files and data'][@id='submit']")).click();
    
     }
   else
   {
	   System.out.println("PlugIn not installed");
   }
    
	}
}
