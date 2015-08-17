package in.beingzero.framwork.tests;

import org.testng.annotations.Test;

import in.beingzero.framework.TestBase;
import in.beingzero.framework.pom.GlobalConstants;

public class BasicTest extends TestBase{
	
	@Test
	public void run() throws InterruptedException
	{
		GlobalConstants.driver.get("http://google.com");
		Thread.sleep(5000);
		System.out.println("Test Running");
	}

}
