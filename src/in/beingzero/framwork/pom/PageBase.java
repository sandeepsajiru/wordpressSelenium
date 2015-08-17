package in.beingzero.framwork.pom;

import org.openqa.selenium.WebDriver;

import in.beingzero.framework.pom.GlobalConstants;

public class PageBase {

	public PageBase() {
		this(GlobalConstants.driver);
	}
	WebDriver driver;
	public PageBase (WebDriver driver)
	{
		this.driver = driver;
	}
}
