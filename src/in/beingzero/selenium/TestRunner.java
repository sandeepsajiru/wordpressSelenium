package in.beingzero.selenium;

import in.beingzero.framework.pom.AvatarChange;
import in.beingzero.framework.pom.GlobalConstants;
import in.beingzero.framework.pom.LoginPage;
import in.beingzero.framework.pom.ScreenDismiss;


import org.openqa.selenium.firefox.FirefoxDriver;

public class TestRunner {

	public static void main(String[] args) {
		
		GlobalConstants.driver = new FirefoxDriver();
		
		for(int i=1;i<=10;i++)
		{
		LoginPage lp = new LoginPage();
		
		
		ScreenDismiss sc = lp.loginUser("seltest", "seltest");
		AvatarChange ac = sc.screenDismiss();
		ac.avatarChange();
		}
		
		
		

	}

}
