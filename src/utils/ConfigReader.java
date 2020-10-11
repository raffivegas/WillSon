package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Raffi
 * Class to obtain config data from config.properties file in resources folder.
 */
public class ConfigReader {

	private static Properties myProperties;

	public static void InitReader() {
		ConfigReader.myProperties = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();       
		// file is in string key = string value format.
		InputStream stream = loader.getResourceAsStream("\\resources\\config.properties");
		try {
			myProperties.load(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Properties getMyProperties() {	
		
		return myProperties;
	}

}
