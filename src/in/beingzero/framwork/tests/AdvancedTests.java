package in.beingzero.framwork.tests;

import org.testng.annotations.Test;

import in.beingzero.framework.TestBase;
import in.beingzero.framework.pom.GlobalConstants;

public class AdvancedTests extends TestBase{

	@Test
	public void secondtest() throws InterruptedException
	{
		GlobalConstants.driver.get("http://yahoo.com");
		Thread.sleep(5000);
		System.out.println("SEcond Test");
	}
}
