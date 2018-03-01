package automationframework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class Launch {
	
	public static WebDriver driver;
	public static ExtentTest logger;
	private static String configFilePath = new String("testdata.properties");
	public static WebDriver browsers(String browser) throws IOException {
		
		Properties property = new Properties();
		FileInputStream objFile = new FileInputStream(configFilePath);
		property.load(objFile);

		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ssridhar\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.get(Testreader.geturl());
		
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		
			}
return driver;
		}
	}


