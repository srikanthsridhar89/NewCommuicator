package com.calliduscloud.testing.Communicator;

import org.openqa.selenium.By;

import com.calliduscloud.testing.util.SeleniumMethods;

public class MyDisputePage {

	By DisputeLocator=By.cssSelector("[href='#!/disputes']");
	By SelectDisputeSubmitted=By.xpath("//table/tbody/tr[1]//td[1]/input");
	By ApprovertextLocator=By.xpath("//div[contains(text(),'Pending Approval')]");
	By PendingAdjustmentTextLocator=By.xpath("//div[contains(text(),'Pending Adjustment')]");
	By CancelledStatusTextLocator=By.xpath("//div[contains(text(),'Canceled')]");
	By ManagerDenyStatusTextLocator=By.xpath("//div[@class='ng-binding' and contains(text(),'Denied')]");
	By PendingInquiryStatusTextLocator=By.xpath("//div[contains(text(),'Pending Inquiry') ");
	By AcceptedStatusTextLocator=By.xpath("//div[contains(text(),'Accepted')");
	By DisputeStatusTextLocator=By.xpath("//table[@class='table table table-condensed ng-scope ng-table']/tbody/tr[1]/td[5]/div");
	
	public void click_DisputeTab(){
		
		SeleniumMethods.click(DisputeLocator, "Dispute Tab is Clicked");
		
	}
	
	public void click_Disputesubmitted(){
		SeleniumMethods.click(SelectDisputeSubmitted, "Select DisputeSubmitted");
	}
		
		public String Get_ApprovalStatusText(){
			
		return SeleniumMethods.getText(ApprovertextLocator, "Approve Status in dispute selection");
		
	}
	
	public String Get_DisputeDenyStatusText(){
	
		
	
		return SeleniumMethods.getText(ManagerDenyStatusTextLocator, "Manager Denied Status Text");
		
	}
	
	public String Get_DisputeCancelStatusText(){

		return SeleniumMethods.getText(CancelledStatusTextLocator, "Cancelled Status Text ");
	}
	
	public String Get_DisputeAdjustmentStatusText(){
		

		return SeleniumMethods.getText(PendingAdjustmentTextLocator, "Dispute Approved and Assigned to Admin");
		
	}

	
	
	public String get_InquiryStatusText(){
	
		return SeleniumMethods.getText(PendingInquiryStatusTextLocator, "Pending Inquiry Status Text");
	}
	
	public String Get_AcceptedStatusText(){
		
		return SeleniumMethods.getText(AcceptedStatusTextLocator, "Accepted Status Text");
	}
}
