package com.calliduscloud.testing.Communicator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.calliduscloud.testing.util.SeleniumMethods;

public class DisputePage {

	By DisputeTypeSelector=By.xpath("//label[contains(text(),'Dispute type')]/../descendant::div/select");
	
	//By DisputetypeSelector=By.cssSelector("#formly_1_horizontalSelect_template_0");
	By SubmitButton=By.xpath("//button[contains(text(),'Submit')]");
	
	public void DisputeCreation(String disputetype) throws InterruptedException{
		
		Thread.sleep(3000);
		SeleniumMethods.selectByVisibleText(DisputeTypeSelector, disputetype, "Incentive Request is Selected");
		
		
	
		
		
		
	}
	
	public void click_submit(){
		//Click on Submit
		
		SeleniumMethods.click(SubmitButton, "Click on Submit Button");
		
	}
}
