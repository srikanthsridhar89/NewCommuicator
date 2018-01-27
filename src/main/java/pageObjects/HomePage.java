package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {
	
	public WebDriver driver;
	public ExtentTest logger;
	public HomePage(WebDriver driver, ExtentTest logger){
		this.driver=driver;
		this.logger = logger;
	}
	public void homepage() {

		try {

			String pagetitle = driver.getTitle();
			if (pagetitle == "Sales Performance Home") {
				WebElement title = driver.findElement(By.xpath("//span[1][contains(text(),'Sales Performance Home')]"));
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.textToBePresentInElementValue(title, "SalesPerformance Home"));
			}
			logger.log(LogStatus.INFO, "Welcome !!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
