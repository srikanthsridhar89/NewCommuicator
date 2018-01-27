package com.callidussoftware.com.NewCommuicator.dispute;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automationframework.Launch;
import pageObjects.HomePage;

import pageObjects.Login;


public class SubmitDispute {
	
	private String browser;
	public WebDriver driver;
	@BeforeTest
	
	public void launchbrowser() throws IOException{
	
		Launch.browsers("chrome");
	}

	@Test
	

	public  void payeedispute() throws InterruptedException, IOException {

	Login l=new Login(driver);
	l.openapp();
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='#!/disputes']")));
		driver.findElement(By.cssSelector("[href='#!/disputes']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='#!/newDispute']")));
		driver.findElement(By.cssSelector("[href='#!/newDispute']")).click();
		Thread.sleep(5000);
		WebElement dispute = driver.findElement(By.cssSelector("#formly_1_horizontalSelect_template_0"));
		Select select = new Select(dispute);
		select.selectByVisibleText("Incentive Request");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(5000);
		
	}



}
