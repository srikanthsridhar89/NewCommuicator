package automationframework;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentRepo {

	public static WebDriver driver;
	public static WebElement element;
	public static ExtentReports reporter;
	ExtentTest logger; 

	public static ExtentReports Instance()
	{
		try{

		if (reporter == null) {
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			Date date = new Date();
			String Path = System.getProperty("user.dir") + "/Reports/Communicator"+dateFormat.format(date)+".html";
		//	reporter = new ExtentReports(Path, false, DisplayOrder.OLDEST_FIRST);
			reporter = new ExtentReports(Path);
		}
	
		}catch(Exception e){
			
		}
		return reporter;
	}
}
