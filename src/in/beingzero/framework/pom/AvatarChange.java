package in.beingzero.framework.pom;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AvatarChange extends PageBase {
	public void avatarChange()
	{
		
		
		Actions action = new Actions(GlobalConstants.driver);
		action.moveToElement(GlobalConstants.driver.findElement(By.id("menu-settings"))).perform();
		action.click(GlobalConstants.driver.findElement(By.linkText("Discussion"))).build().perform();
		
		//Change Avatar
		GlobalConstants.driver.findElement(By.id("avatar_wavatar")).click();
		//Save settings
		GlobalConstants.driver.findElement(By.id("submit")).click();
		
		// Save alert
		WebElement text = GlobalConstants.driver.findElement(By.xpath(".//*[@id='setting-error-settings_updated']/p/strong"));
		
		PageBase pb = new PageBase();
		pb.logout();
		GlobalConstants.driver.quit();
	}
}
