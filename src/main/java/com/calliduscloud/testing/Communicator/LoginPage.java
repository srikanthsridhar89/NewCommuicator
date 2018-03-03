package com.calliduscloud.testing.Communicator;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.calliduscloud.testing.util.JsonReader;
import com.calliduscloud.testing.util.SeleniumMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class LoginPage {




	public void Login(String username,String passwd) {

		By userName=By.cssSelector("#login_input"); 
		By password=By.xpath("//input[@name='password']");	
		SeleniumMethods.type(userName,username,"UserName");
		SeleniumMethods.type(password,passwd,"Password");
		
	}
	
	
	/*public void ManagerLogin(String username,String passwd){
		By usrname=By.cssSelector("#login_input");
		By password=By.xpath("//input[@name='password']");
		SeleniumMethods.type(usrname, username, "Mgrname");
		SeleniumMethods.type(password, passwd, "Mgrname" );
		
	}
	
	public void AdminLogin(String uname,String pwd){
		
		By uname1=By.cssSelector("#login_input");
		By pwd1=By.xpath("//input[@name='password']");
		SeleniumMethods.type(uname1, uname,"AdminUser");
		SeleniumMethods.type(pwd1, "pwd", "AdminPassword");
		
				
	}
	
	
	public void PortalAdminLogin(String pname,String ppwd){
		By padminuname=By.cssSelector("#login_input");
		By padminpwd=By.xpath("//input[@name='password']");
		SeleniumMethods.type(padminuname, "pname", "PortalAdminUser");
		SeleniumMethods.type(padminpwd, "ppwd", "PortalAdminPassword");
		
		
	}*/
	public void click_login()
	{
		By login=By.xpath("//button[@type='submit']");
		SeleniumMethods.click(login,"Login");
	}

}