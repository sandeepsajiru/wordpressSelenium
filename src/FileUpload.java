import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class FileUpload {

	@Test
	public void run() throws InterruptedException {
		System.out.println(System.getProperty("user.dir"));
		WebDriver fd  = new FirefoxDriver();
		fd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		fd.get(GlobalConstants.LOGIN_PAGE_URL);
		
		fd.findElement(By.name("log")).sendKeys(GlobalConstants.USER_NAME);
		fd.findElement(By.name("pwd")).sendKeys(GlobalConstants.PASSWORD);
		
		fd.findElement(By.name("wp-submit")).click();
		
		fd.findElement(By.linkText("Customize Your Site"));
		
		fd.navigate().to(GlobalConstants.THEME_UPLOAD_PAGE_URL);
		
		fd.findElement(By.name("themezip")).sendKeys(GlobalConstants.THEME_ZIP_FILE_PATH);
		
		WebElement installNow =  fd.findElement(By.name("install-theme-submit"));
		System.out.println(installNow.isEnabled());
		if(installNow.isEnabled())
		{
			installNow.submit();
		}
		
		Thread.sleep(2000);
		fd.quit();
		
	}
}
