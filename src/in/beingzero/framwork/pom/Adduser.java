package in.beingzero.framwork.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Adduser {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		LoginPage lp = new LoginPage(driver);
		
		DashBoard dp =lp.loginPage("seltest", "seltest");
		
		String un = "abhinayone";
		Users us =dp.goToUsersPage();
		int preCount = us.getUserCount();
		NewUser nu =dp.users();
		us =nu.fillform(un, "abhinayone@gmail.com", "Abc@1234", "Abc@1234","Author");
		int postCount = us.getUserCount();
		
		if(postCount-preCount!=1)
		{
		  System.out.println("Test Fail");
		}
		else
		{
		System.out.println("New user Added - Test Pass");	
		}
		us = us.changeRole(un, "Editor");
		us =us.deleteUser(un);
		
	
	}
}
