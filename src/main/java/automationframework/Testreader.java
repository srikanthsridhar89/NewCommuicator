package automationframework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Testreader {
	private static String configFilePath = new String("testdata.properties");

	public static String propertiesReader(String propertyKey, String filePath)
	{
		Properties properties = new Properties();
		InputStream input = null;
		String propertyValue = new String();

		try
		{
			input = new FileInputStream(filePath);
			properties.load(input);

			propertyValue = properties.getProperty(propertyKey);

		} 
		catch (IOException ex) {
			ex.printStackTrace();
		}
		return propertyValue; 

	}

	public static String geturl(){
		String urlvalue=propertiesReader("url",configFilePath);
		return urlvalue;
	}
	public static String getusername(){
		String username=propertiesReader("payeename",configFilePath);
		return username;
	}
	public static String getpassword(){
		String password=propertiesReader("payeepassword",configFilePath);
		return password;
	}	
}