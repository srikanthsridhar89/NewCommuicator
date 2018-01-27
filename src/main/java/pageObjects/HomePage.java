package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	private String browser;
	public WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver=driver;
		
	}
	public void homepage() {

		try {

			String pagetitle = driver.getTitle();
			if (pagetitle == "Sales Performance Home") {
				WebElement title = driver.findElement(By.xpath("//span[1][contains(text(),'Sales Performance Home')]"));
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.textToBePresentInElementValue(title, "SalesPerformance Home"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
