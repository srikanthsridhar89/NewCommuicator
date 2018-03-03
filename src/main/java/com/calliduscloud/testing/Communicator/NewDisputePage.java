package com.calliduscloud.testing.Communicator;

import org.openqa.selenium.By;

import com.calliduscloud.testing.util.SeleniumMethods;

public class NewDisputePage {
	By NewDispute=By.cssSelector("[href='#!/newDispute']");
	
	public void click_NewDispute(){
		SeleniumMethods.click(NewDispute, "New Dispute is Clicked");
		
		
		
	}
	
}
