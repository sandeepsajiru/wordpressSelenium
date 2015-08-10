package in.beingzero.framework.pom;



import org.openqa.selenium.By;

import org.openqa.selenium.interactions.Actions;

public class PageBase {
 
	public void logout()
	{	Actions action = new Actions(GlobalConstants.driver);
		action.moveToElement(GlobalConstants.driver.findElement(By.partialLinkText("Howdy"))).perform();
		action.click(GlobalConstants.driver.findElement(By.linkText("Log Out"))).build().perform();
	}
}
