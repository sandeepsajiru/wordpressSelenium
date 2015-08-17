package in.beingzero.framework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import java.awt.Frame;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterSuite;

public class TestBase {

  @BeforeSuite
  public void beforeSuite() throws FileNotFoundException, IOException {
	  Framework.init();
  }

  @AfterSuite
  public void afterSuite() {
	  Framework.uninit();
  }

}
