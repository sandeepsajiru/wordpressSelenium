package in.beingzero.framework.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ScreenDismiss extends PageBase{

	public AvatarChange screenDismiss()
	{
		
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
		AvatarChange ac = new AvatarChange();
		return ac;
	}
}
