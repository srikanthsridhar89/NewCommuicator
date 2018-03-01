package pageObjects;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Login {

	public WebDriver driver;
	public ExtentTest logger;

	public Login(WebDriver driver, ExtentTest logger){
		this.driver=driver;
		this.logger = logger;
	}


	public void openapp() throws IOException, InterruptedException {

		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#login_input")).sendKeys("sripayee");;
		logger.log(LogStatus.INFO, "Username entered successfully");
		//un.sendKeys(Testreader.getusername());
	//	un.sendKeys("sripayee");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Srikanth123");;
		logger.log(LogStatus.INFO, "Password entered successfully");
	//	pwd.sendKeys("Srikanth123");
		//pwd.sendKeys(Testreader.getpassword());
		driver.findElement(By.xpath("//form/div[3]/button[@type='submit']")).click();
		logger.log(LogStatus.INFO, "Click on Submit  successfully");

	}

}