package in.beingzero.framwork.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DashBoard extends PageBase{

	public DashBoard(WebDriver driver) {
		super(driver);
	
	}
	
	public Users goToUsersPage()
	{
		driver.findElement(By.partialLinkText("Users")).click();
		return new Users(driver);
	}

	public NewUser users() {
		 Actions act = new Actions(driver);
		    act.moveToElement(driver.findElement(By.partialLinkText("Users"))).perform();
		    act.click(driver.findElement(By.partialLinkText("Add New"))).perform();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    return new NewUser(driver);
		
	}
	

}
