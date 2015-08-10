package in.beingzero.framwork.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Users extends PageBase {

	public Users(WebDriver driver) {
		super(driver);
	}
	
	public Users changeRole(String username, String role)
	{
		  //Search user
	    driver.findElement(By.name("s")).sendKeys(username);
	    driver.findElement(By.id("search-submit")).click();
	    driver.findElement(By.name("users[]")).click();
	    
	    //role change
	    Select dropdown1 = new Select(driver.findElement(By.id("new_role")));
	    dropdown1.selectByVisibleText(role);
	    driver.findElement(By.name("changeit")).click();
		return new Users(driver);
	}
	public int getUserCount()
	{
		// TODO :  Count users in webtable
		 WebElement tbody = driver.findElement(By.id("the-list"));
			int t1 = tbody.findElements(By.tagName("tr")).size();
			System.out.println("No of Rows :" + t1);
		return t1;
	}
	
	public Users deleteUser(String username)
	{
		
		Actions act1 = new Actions(driver);
	    act1.moveToElement( driver.findElement(By.partialLinkText(username))).perform();
	    //act1.moveToElement(driver.findElement(By.partialLinkText("Delete"))).perform();
	    driver.findElement(By.partialLinkText("Delete")).click();
	    driver.findElement(By.id("delete_option0")).click();
	    driver.findElement(By.id("submit")).click();
		return new Users(driver);
	}

}
