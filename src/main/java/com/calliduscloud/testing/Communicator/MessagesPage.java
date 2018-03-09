package com.calliduscloud.testing.Communicator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.calliduscloud.testing.util.JsonReader;
import com.calliduscloud.testing.util.SeleniumMethods;

public class MessagesPage {
	By FirstMessageLocator=By.xpath("//table/tbody/tr[1]/td[2]");
	By ApproveButton=By.xpath("//button[@class='btn btn-sm detail_view ng-binding btn-default' and text()='Approve']");
	By EnterComments=By.xpath(".//*[@id='comments_area']");
	By OkButton=By.xpath(".//*[@id='ok_comment_btn']");
	By DenyButton=By.xpath("//button[@class='btn btn-sm detail_view ng-binding btn-default' and text()='Deny']");
	By InquiryButton=By.xpath("//button[@class='btn btn-sm detail_view ng-binding btn-default' and text()='Send Inquiry']");
	By CancelButton=By.xpath("//button[contains(text(), 'Cancel Request')]");
	
	public void MessageDetail(){
	SeleniumMethods.wait_untilPageLoads();
	
	}
	
	public void MessageUnreadCount(){
		
		//List<WebElement> emailList = SeleniumMethods.findElements(by, fieldName)
		//System.out.println(emailList.size());
	}

	public void click_Message(){
		
		SeleniumMethods.click(FirstMessageLocator, "Click on Message to Open the Message detailPage");
	}
public void Approve(){
		
		//Click on Approve button
		SeleniumMethods.click(ApproveButton, "Click on Approve button");
		//Enter Comments 
		String ApproveComments =JsonReader.readJson("envconfig","ManageApprovalComments");
        SeleniumMethods.type(EnterComments, ApproveComments, "Manager Entering Comments");
        //Clicking on Ok 
        SeleniumMethods.click(OkButton, "Click on OK button");
        }
	
	public void ManagerDeny(){
		//Click on Deny  button 
        SeleniumMethods.click(DenyButton, "Click on Deny button");
        //Enter Comments
		String Comment=JsonReader.readJson("envconfig","ManagerDenyComments");
		SeleniumMethods.type(EnterComments, Comment, "Denied the Dispute");
		//Clicking on Ok
		SeleniumMethods.click(OkButton, "Click on OK button");
		}
	public void ManagerSentInquiry(){
		//Clicking on Send Inquiry button
		SeleniumMethods.click(InquiryButton, "Click on Inquiry  button");
		//Enter Comments
		String Comments=JsonReader.readJson("envconfig","ManageInquiryComments");
        SeleniumMethods.type(EnterComments, Comments, "Manager Entered Comments");
        //Click on Ok 
        SeleniumMethods.click(OkButton, "Click on OK button");
	}
	
	public void CancelDispute(){
		
	//Click on Cancel Button
		SeleniumMethods.click(CancelButton, "Clicking on Cancel Button");
	    String CancellingComments=JsonReader.readJson("envconfig","PayeeCancelledComments");
         SeleniumMethods.type(EnterComments, CancellingComments, "Cancelling the Dispute");
		
		 //Click on Ok 
        SeleniumMethods.click(OkButton, "Click on OK button");
	}
	
}