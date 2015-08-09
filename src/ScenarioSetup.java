import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class ScenarioSetup {
	
		
		@BeforeMethod
		public void setup(){
			
			if(GlobalConstants.browser.equalsIgnoreCase("ie"))
				 GlobalConstants.driver =  new InternetExplorerDriver();
			else if(GlobalConstants.browser.equals("ch"))
				GlobalConstants.driver =new ChromeDriver();
			else
				GlobalConstants.driver=new FirefoxDriver();
			GlobalConstants.driver.manage().window().maximize();
		}
		
		public void loginAdmin(String name, String pwd) {
			
			GlobalConstants.driver.get(GlobalConstants.loginPageUrl);
			//Login user
			GlobalConstants.driver.findElement(By.name("log")).sendKeys(name);
			GlobalConstants.driver.findElement(By.name("pwd")).sendKeys(pwd);
			
			WebElement display = GlobalConstants.driver.findElement(By.name("rememberme"));
			System.out.println("IsChecked: "+display.isSelected());
			display.click();
			
			//Click Login
			GlobalConstants.driver.findElement(By.id("wp-submit")).click();
			GlobalConstants.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
		}
		
		public void logout()
		{	Actions action = new Actions(GlobalConstants.driver);
			action.moveToElement(GlobalConstants.driver.findElement(By.partialLinkText("Howdy"))).perform();
			action.click(GlobalConstants.driver.findElement(By.linkText("Log Out"))).build().perform();
		}
		
		@Test(enabled=false)
		public void createLoginDeleteUser()
		{
			//Navigate User page
			GlobalConstants.driver.navigate().to("http://localhost/wordpress/wp-admin/users.php");
			//Click Add user link
			GlobalConstants.driver.findElement(By.linkText("Add New")).click();
			//Fill required fields for user creation
			GlobalConstants.driver.findElement(By.id("user_login")).sendKeys("NewUser");
			GlobalConstants.driver.findElement(By.id("email")).sendKeys("monika@cloudit.com");
			GlobalConstants.driver.findElement(By.id("pass1")).sendKeys("newuser");
			GlobalConstants.driver.findElement(By.id("pass2")).sendKeys("newuser");
			GlobalConstants.driver.findElement(By.id("role")).sendKeys("administrator");
			GlobalConstants.driver.findElement(By.id("createusersub")).click();
			
						
			//login new user
			loginAdmin("newuser" , "newuser");
			
			//logout new user
			logout();
			
			//login Admin
			loginAdmin("monika" , "monika");
			//Select and Delete New user
			GlobalConstants.driver.findElement(By.linkText("Users")).click();
			WebElement requireduser = GlobalConstants.driver.findElement(By.linkText("newuser"));
			Actions user = new Actions(GlobalConstants.driver);
			user.moveToElement(requireduser).build().perform();
			GlobalConstants.driver.findElement(By.className("submitdelete")).click();
			GlobalConstants.driver.findElement(By.id("delete_option0")).click();
			GlobalConstants.driver.findElement(By.name("submit")).click();
		}
		
		@Test(enabled=false)
		public void ScreenDismiss()
		{
			loginAdmin("monika","monika");
			//Click Dismiss link to remove welcome
			GlobalConstants.driver.findElement(By.className("welcome-panel-close")).click();
			
			Actions action = new Actions(GlobalConstants.driver);
			//action.click(GlobalConstants.driver.findElement(By.linkText("Screen Options"))).build().perform();
			action.click(GlobalConstants.driver.findElement(By.id("show-settings-link"))).perform();
			GlobalConstants.driver.findElement(By.id("wp_welcome_panel-hide")).click();
			WebElement text = GlobalConstants.driver.findElement(By.tagName("h3"));
			 if(text.getText().equals("Welcome to WordPress!"))
				 System.out.println("Test Pass");
			 else 
				 System.out.println("Test Fail");
			 
			 //GlobalConstants.driver.close();
										
		}
		@Test(enabled=false)
		public void AvatarChanges()
		{
			loginAdmin("monika","monika");
			
			Actions action = new Actions(GlobalConstants.driver);
			action.moveToElement(GlobalConstants.driver.findElement(By.id("menu-settings"))).perform();
			action.click(GlobalConstants.driver.findElement(By.linkText("Discussion"))).build().perform();
			//Change Avatar
			GlobalConstants.driver.findElement(By.id("avatar_wavatar")).click();
			//Save settings
			GlobalConstants.driver.findElement(By.id("submit")).click();
			
			// Save alert
			WebElement text = GlobalConstants.driver.findElement(By.xpath(".//*[@id='setting-error-settings_updated']/p/strong"));
			/*if(text.getText().equalsIgnoreCase("Settings saved."))
					System.out.println("Test Pass");
			else
				System.out.println("Test Fail");*/
			
		}
		
		@Test
		public void backgroundColor()
		{
			loginAdmin(GlobalConstants.USER_NAME, GlobalConstants.PASSWORD);
			//Navigate Appearance Background
			Actions action = new Actions(GlobalConstants.driver);
			action.moveToElement(GlobalConstants.driver.findElement(By.id("menu-appearance"))).perform();
			action.click(GlobalConstants.driver.findElement(By.linkText("Background"))).build().perform();
			
			//Change Background Color
			WebElement element = GlobalConstants.driver.findElement(By.id("customize-theme-controls"));
			// TODO:  Fix the issue here.
			
			//element.findElement(By.id("accordion-section-colors")).click();
			element.findElement(By.className("accordion-section-title")).click();
			
			GlobalConstants.driver.findElement(By.xpath(".//*[@id='customize-control-background_color']/label/div/div/a")).click();
			//GlobalConstants.driver.findElement(By.className("color-picker-hex wp-color-picker")).sendKeys("#9b0000");
			//GlobalConstants.driver.findElement(By.id("save")).click();
			
			
			//Check In source Code
			
			
		}
		
		//Using AutoIt
		@Test(enabled=false)
		public void uploadFile() throws IOException{
			//Navigate to Upload Page
			GlobalConstants.driver.navigate().to("http://localhost/wordpress/wp-admin/upload.php");
			//Click Add button to upload file
			GlobalConstants.driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[3]/h2/a")).click();
			GlobalConstants.driver.findElement(By.xpath(""+ "//*[@id='__wp-uploader-id-1']")).click();
			
			Runtime.getRuntime().exec("G:\\AutoIT\\FileUpload.exe");
			GlobalConstants.driver.close();
		}
		
		@AfterMethod
		public void cleanup()
		{
			GlobalConstants.driver.quit();
		}
}
		
		
		
		
		
