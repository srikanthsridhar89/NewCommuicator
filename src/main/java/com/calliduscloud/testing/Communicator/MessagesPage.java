package com.calliduscloud.testing.Communicator;

import org.openqa.selenium.By;
import com.calliduscloud.testing.util.JsonReader;
import com.calliduscloud.testing.util.SeleniumMethods;

public class MessagesPage {
	By FirstMessageLocator=By.xpath("//th[contains(text(),'Subject')]/../../../tbody/tr[1]");
	By ApproveButton=By.xpath("//button[@class='btn btn-sm detail_view ng-binding btn-default' and text()='Approve']");
	By EnterComments=By.xpath(".//*[@id='comments_area']");
	By OkButton=By.xpath(".//*[@id='ok_comment_btn']");
	By DenyButton=By.xpath("//button[@class='btn btn-sm detail_view ng-binding btn-default' and text()='Deny']");
	By InquiryButton=By.xpath("//button[@class='btn btn-sm detail_view ng-binding btn-default' and text()='Send Inquiry']");
	By CancelButton=By.xpath("//button[contains(text(), 'Cancel Request')]");
	By Message=By.cssSelector("[href='#!/messages']");
	By Resolvedbutton=By.xpath("//button[contains(text(),'Resolve')]");
	By RespondButtonLocator=By.xpath("//button[contains(text(),'Respond')]");
	By AdminSentInquirytoPayeeLocator=By.xpath("//div[contains(text(),'(Submitter)')]/input");
	
	public void MessageDetail(){
	SeleniumMethods.wait_untilPageLoads();
	
	}
	
	public void MessageUnreadCount(){
		
		//List<WebElement> emailList = SeleniumMethods.findElements(by, fieldName)
		//System.out.println(emailList.size());
	}
	
	public void click_MessageTab(){
		
		SeleniumMethods.click(Message, "Click on Message Tab");
		
	}

	public void click_Message(){
		
		SeleniumMethods.javascript_click(FirstMessageLocator, "Click on Message to Open the Message detailPage");
	}
public void click_Approve(){
		
		//Click on Approve button
		SeleniumMethods.click(ApproveButton, "Click on Approve button");
		
        }
	
	public void click_ManagerDeny(){
		//Click on Deny  button 
        SeleniumMethods.click(DenyButton, "Click on Deny button");
        
		}
	public void click_Inquiry(){
		//Clicking on Send Inquiry button
		SeleniumMethods.click(InquiryButton, "Click on Inquiry  button");
		
	}
	
	public void CancelDispute(){
		
	//Click on Cancel Button
		SeleniumMethods.click(CancelButton, "Clicking on Cancel Button");
	    String CancellingComments=JsonReader.readJson("envconfig","PayeeCancelledComments");
         SeleniumMethods.type(EnterComments, CancellingComments, "Cancelling the Dispute");
		
		 //Click on Ok 
        SeleniumMethods.click(OkButton, "Click on OK button");
	}
	
	public void click_Resolved(){
		SeleniumMethods.click(Resolvedbutton, "Click on Resolve button");
		
	}
	
	public void click_PayeeResponded(){
		SeleniumMethods.click(RespondButtonLocator, "click on Respond");
	}
	
	public void select_payeeinquiry(){
	SeleniumMethods.click(AdminSentInquirytoPayeeLocator,"Selecting Payee Inquiry");
}
	
}