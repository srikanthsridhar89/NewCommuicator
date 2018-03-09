package com.calliduscloud.testing.Communicator;

import java.util.List;

import org.openqa.selenium.By;

import com.calliduscloud.testing.util.JsonReader;
import com.calliduscloud.testing.util.SeleniumMethods;

public class DisputeDetailPage {

	By DisputeSelection=By.xpath("//table/tbody/tr[1]/td[3]/div[2]/a");
	By ApproveButton=By.xpath("//button[@class='btn btn-sm detail_view ng-binding btn-default' and text()='Approve']");
	By EnterComments=By.xpath(".//*[@id='comments_area']");
	By OkButton=By.xpath(".//*[@id='ok_comment_btn']");
	By DenyButton=By.xpath("//button[@class='btn btn-sm detail_view ng-binding btn-default' and text()='Deny']");
	By InquiryButton=By.xpath("//button[@class='btn btn-sm detail_view ng-binding btn-default' and text()='Send Inquiry']");
	By CancelDisputeLocator=By.xpath("//button[contains(text(), 'Cancel Request')]");
	By AdminResolverButton=By.xpath("//button[contains(text(),'Resolve')]");
	By AdminDenyButton=By.xpath("//button[contains(text(),'Deny')]");
	By DisputeSubmited=By.xpath("//table/tbody/tr[1]/td[1]");
	By SentInquiryButton=By.xpath("//button[contains(text(),'Send Inquiry')]");
	By RadioButtonLocator=By.xpath("//input[@type='radio']");
	By CancelButtonLocator=By.id("cancel_btn");
	
	By RespondButtonLocator=By.xpath("//button[contains(text(),'Respond')]");
	By AdminSentInquirytoPayeeLocator=By.xpath("//div[contains(text(),'(Submitter)')]/input");
	
	public void check_DisputeDetail(){
		SeleniumMethods.click(DisputeSubmited, "Select the Dispute Submitted");
		
		
}
	
	public void Click_SendInquirybutton(){
		
		SeleniumMethods.click(SentInquiryButton,"");
	}
	
	public void Click_DisputeDetail(){
		
		SeleniumMethods.click(DisputeSelection, "Click to Open Dispute Detail Page");
	}

	
	
	
	public void click_Approve() throws InterruptedException{
		
		
		SeleniumMethods.waitForElementPresent(ApproveButton);
		//Click on Approve button
		SeleniumMethods.click(ApproveButton, "Click on Approve button");
	}
	
	
	public void typecomments(String Comments){
		
		//Enter Comments 
		
        SeleniumMethods.type(EnterComments, Comments, "Entering Comments");

        }
	
	public void click_Deny(){
		//Click on Deny  button 
        SeleniumMethods.click(DenyButton, "Click on Deny button");

		
	
		}
	public void click_SendInquiry(){
		//Clicking on Send Inquiry button
		SeleniumMethods.click(InquiryButton, "Click on SentInquiryButton");

        
	}
	
	public void click_CancelDispute(){
		
	//Click on Cancel Button
		SeleniumMethods.click(CancelDisputeLocator, "Clicking on Cancel Button");
	    
		

	}
	
	
	public void click_Cancelbutton(){
		
		SeleniumMethods.click(CancelButtonLocator, "Click on Cancel button");
		
	}
	
	
	public void click_AdminResolvedDispute(){
		
		//Click on Resolved button
		
		SeleniumMethods.javascript_click(AdminResolverButton, "Click on Resolved Button");
	}
		
	
	public void click_AdminSentInquirytoPayee(){
	  SeleniumMethods.click(AdminSentInquirytoPayeeLocator, "Admin Sending Inquiry to Payee");
	  
		}
	
	
	
	
	
	
	
	public void click_PayeeRespondedDispute(){
		//Click on Respond button
		SeleniumMethods.click(RespondButtonLocator, "Click on Respond Button");
		String PayeeRespondComments=JsonReader.readJson("envconfig", "PayeeRespondComments");
	
		
	}
	
	
	public void click_Okbutton(){
		//Click on Ok 
	       SeleniumMethods.click(OkButton, "OK button");
		
		
	}
	
	
	
	
	
}
