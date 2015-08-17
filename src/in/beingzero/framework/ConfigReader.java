package in.beingzero.framework;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import in.beingzero.framework.pom.GlobalConstants;

public class ConfigReader {
	Properties props;
	
	public ConfigReader() throws FileNotFoundException, IOException {
		props = new Properties();
		props.load(new FileReader(GlobalConstants.frameworkConfigPath));
	}
	
	public String getStringPropertyValue(String propName)
	{
		return props.getProperty(propName);
	}
	
	public int getIntPropertyValye(String propName)
	{
		return Integer.parseInt(props.getProperty(propName));
	}
}
