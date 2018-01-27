package com.callidussoftware.com.NewCommuicator.dispute;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import automationframework.ExtentRepo;
import automationframework.Launch;
import pageObjects.Login;


public class SubmitDispute {

	public WebDriver driver;
	public static ExtentTest logger;
	public static ExtentReports report;
	@BeforeTest

	public void launchbrowser() throws IOException{
		report = ExtentRepo.Instance();
		driver = Launch.browsers("chrome");
	}

	@Test
	public  void payeedispute() throws InterruptedException, IOException {
		logger = report.startTest("passTest");
		Login l=new Login(driver, logger);
		l.openapp();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='#!/disputes']")));
		driver.findElement(By.cssSelector("[href='#!/disputes']")).click();
		logger.log(LogStatus.INFO, "clicked disputes");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='#!/newDispute']")));
		driver.findElement(By.cssSelector("[href='#!/newDispute']")).click();
		Thread.sleep(2000);
		WebElement dispute = driver.findElement(By.cssSelector("#formly_1_horizontalSelect_template_0"));
		Select select = new Select(dispute);
		select.selectByVisibleText("Incentive Request");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(2000);
		driver.close();
	}
	@AfterTest
	public void TearDown(){
		report.endTest(logger);
		report.flush();
		driver.quit();
	}
}
