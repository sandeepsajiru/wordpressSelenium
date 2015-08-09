import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class ScenarioSetup {
	
		WebDriver driver;
		
		@BeforeMethod
		public void setup(){
			
			if(GlobalConstants.browser.equalsIgnoreCase("ie"))
				 driver =  new InternetExplorerDriver();
			else if(GlobalConstants.browser.equals("ch"))
				driver =new ChromeDriver();
			else
				driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
		
		public void loginAdmin(String name, String pwd) {
			
			driver.get(GlobalConstants.loginPageUrl);
			//Login user
			driver.findElement(By.name("log")).sendKeys(name);
			driver.findElement(By.name("pwd")).sendKeys(pwd);
			
			WebElement display = driver.findElement(By.name("rememberme"));
			System.out.println("IsChecked: "+display.isSelected());
			display.click();
			
			//Click Login
			driver.findElement(By.id("wp-submit")).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
		}
		
		public void logout()
		{	Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.partialLinkText("Howdy"))).perform();
			action.click(driver.findElement(By.linkText("Log Out"))).build().perform();
		}
		
		@Test
		public void createLoginDeleteUser()
		{
			//Navigate User page
			driver.navigate().to("http://localhost/wordpress/wp-admin/users.php");
			//Click Add user link
			driver.findElement(By.linkText("Add New")).click();
			//Fill required fields for user creation
			driver.findElement(By.id("user_login")).sendKeys("NewUser");
			driver.findElement(By.id("email")).sendKeys("monika@cloudit.com");
			driver.findElement(By.id("pass1")).sendKeys("newuser");
			driver.findElement(By.id("pass2")).sendKeys("newuser");
			driver.findElement(By.id("role")).sendKeys("administrator");
			driver.findElement(By.id("createusersub")).click();
			
						
			//login new user
			loginAdmin("newuser" , "newuser");
			
			//logout new user
			logout();
			
			//login Admin
			loginAdmin("monika" , "monika");
			//Select and Delete New user
			driver.findElement(By.linkText("Users")).click();
			WebElement requireduser = driver.findElement(By.linkText("newuser"));
			Actions user = new Actions(driver);
			user.moveToElement(requireduser).build().perform();
			driver.findElement(By.className("submitdelete")).click();
			driver.findElement(By.id("delete_option0")).click();
			driver.findElement(By.name("submit")).click();
		}
		
		@Test
		public void ScreenDismiss()
		{
			loginAdmin("monika","monika");
			//Click Dismiss link to remove welcome
			driver.findElement(By.className("welcome-panel-close")).click();
			
			Actions action = new Actions(driver);
			//action.click(driver.findElement(By.linkText("Screen Options"))).build().perform();
			action.click(driver.findElement(By.id("show-settings-link"))).perform();
			driver.findElement(By.id("wp_welcome_panel-hide")).click();
			WebElement text = driver.findElement(By.tagName("h3"));
			 if(text.getText().equals("Welcome to WordPress!"))
				 System.out.println("Test Pass");
			 else 
				 System.out.println("Test Fail");
			 
			 //driver.close();
										
		}
		@Test
		public void AvatarChanges()
		{
			loginAdmin("monika","monika");
			
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.id("menu-settings"))).perform();
			action.click(driver.findElement(By.linkText("Discussion"))).build().perform();
			//Change Avatar
			driver.findElement(By.id("avatar_wavatar")).click();
			//Save settings
			driver.findElement(By.id("submit")).click();
			
			// Save alert
			WebElement text = driver.findElement(By.xpath(".//*[@id='setting-error-settings_updated']/p/strong"));
			/*if(text.getText().equalsIgnoreCase("Settings saved."))
					System.out.println("Test Pass");
			else
				System.out.println("Test Fail");*/
			
		}
		
		public void backgroundColor()
		{
			loginAdmin("monika","monika");
			//Navigate Appearance Background
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.id("menu-appearance"))).perform();
			action.click(driver.findElement(By.linkText("Background"))).build().perform();
			
			//Change Background Color
			WebElement element = driver.findElement(By.id("customize-theme-controls"));
			element.findElement(By.id("accordion-section-colors")).click();
			driver.findElement(By.xpath(".//*[@id='customize-control-background_color']/label/div/div/a")).click();
			//driver.findElement(By.className("color-picker-hex wp-color-picker")).sendKeys("#9b0000");
			//driver.findElement(By.id("save")).click();
			
			
			//Check In source Code
			
			
		}
		//Using AutoIt
		public void uploadFile() throws IOException{
			//Navigate to Upload Page
			driver.navigate().to("http://localhost/wordpress/wp-admin/upload.php");
			//Click Add button to upload file
			driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/h2/a")).click();
			driver.findElement(By.xpath(""+ "//*[@id='__wp-uploader-id-1']")).click();
			
			Runtime.getRuntime().exec("G:\\AutoIT\\FileUpload.exe");
			driver.close();
		}
		
		@AfterMethod
		public void cleanup()
		{
			driver.quit();
		}
}
		
		
		
		
		
