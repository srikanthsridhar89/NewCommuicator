package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automationframework.Testreader;

public class Login {

	private String browser;
	public WebDriver driver;

	public Login(WebDriver driver){
		this.driver=driver;

	}


	public void openapp() throws IOException {


		WebElement un = driver.findElement(By.xpath("//input[@name='username']"));
		//un.sendKeys(Testreader.getusername());
		un.sendKeys("sripayee");
		WebElement pwd = driver.findElement(By.xpath("//input[@name='password']"));
		pwd.sendKeys("Srikanth123");
		//pwd.sendKeys(Testreader.getpassword());
		driver.findElement(By.xpath("//form/div[3]/button[@type='submit']")).click();

	}

}