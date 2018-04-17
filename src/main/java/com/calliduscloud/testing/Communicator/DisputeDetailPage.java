package com.calliduscloud.testing.Communicator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.calliduscloud.testing.util.JsonReader;
import com.calliduscloud.testing.util.SeleniumMethods;

public class DisputeDetailPage {

	By DisputeSelection=By.xpath("//table/tbody/tr[1]/td[3]/div[2]/a");
	By ApproveButton=By.xpath("//button[@class='btn btn-default cald_3D_button_default ng-binding' and contains(text(),'Approve')]");
	By EnterComments=By.xpath(".//*[@id='comments_area']");
	By OkButton=By.xpath(".//*[@id='ok_comment_btn']");
	By AdminDeny=By.xpath("//button[@class='btn btn-sm detail_view ng-binding btn-default' and text()='Deny']");
	By InquiryButton=By.xpath("//button[@class='btn btn-sm detail_view ng-binding btn-default' and text()='Send Inquiry']");
	By CancelDisputeLocator=By.xpath("//button[contains(text(), 'Cancel Request')]");
	By AdminResolverButton=By.xpath("//button[contains(text(),'Resolve')]");
	By DenyButton=By.xpath("//button[@class='btn btn-default cald_3D_button_default ng-binding' and contains(text(),'Deny')]");
	By DisputeSubmited=By.xpath("//table/tbody/tr[1]/td[1]");
	By DisputeSubmitted1=By.xpath("//table/tbody/tr[2]/td[1]");
	By SentInquiryButton=By.xpath("//button[contains(text(),'Send Inquiry')]");
	By RadioButtonLocator=By.xpath("//input[@type='radio']");
	By CancelButtonLocator=By.id("cancel_btn");

	By RespondButtonLocator=By.xpath("//button[contains(text(),'Respond')]");
	By AdminSentInquirytoPayeeLocator=By.xpath("//div[contains(text(),'(Submitter)')]/input");

	public void verify_DisputeDetailspage()

	{

		By disputePage=By.xpath("//span[contains(text(),'My Disputes')]");
		SeleniumMethods.waitForElementPresent(disputePage);
	}

	public void check_DisputeDetail(){
		SeleniumMethods.click(DisputeSubmited, "Select the Dispute Submitted");


	}

	public void check_MultipleDispute(){
		SeleniumMethods.click(DisputeSubmited, "Select the Dispute Submitted");


		Actions action=new Actions(SeleniumMethods.getDriver());

		action.keyDown(Keys.CONTROL).click(SeleniumMethods.getDriver().findElement(DisputeSubmitted1)).keyUp(Keys.CONTROL).build().perform();


		//SeleniumMethods.click(DisputeSubmitted1, "Select the Dispute");
		//action.keyUp(Keys.CONTROL).build().perform();


	}

	public void Click_SendInquirybutton(){

		SeleniumMethods.click(SentInquiryButton,"");
	}

	public void Click_DisputeDetail(){

		SeleniumMethods.click(DisputeSelection, "Click to Open Dispute Detail Page");
	}




	public void click_Approve() throws InterruptedException{



		//Click on Approve button
		//SeleniumMethods.getAttribute(ApproveButton, attributeName, fieldName)
		SeleniumMethods.javascript_click(ApproveButton, "Click on Approve button");
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
