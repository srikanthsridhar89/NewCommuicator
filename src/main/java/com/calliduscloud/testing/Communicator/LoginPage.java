package com.calliduscloud.testing.Communicator;

import org.openqa.selenium.By;
import com.calliduscloud.testing.util.SeleniumMethods;


public class LoginPage {




	public void Login(String username,String passwd) {

		By userName=By.cssSelector("#login_input"); 
		By password=By.xpath("//input[@name='password']");	
		SeleniumMethods.type(userName,username,"UserName");
		SeleniumMethods.type(password,passwd,"Password");
		
	}
	
	
	public void click_login()
	{
		By login=By.xpath("//button[@type='submit']");
		SeleniumMethods.click(login,"Login");
	}

}