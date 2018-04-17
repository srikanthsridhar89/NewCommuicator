package com.calliduscloud.testing.Communicator;

import org.openqa.selenium.By;

import com.calliduscloud.testing.util.JsonReader;
import com.calliduscloud.testing.util.SeleniumMethods;

public class NewDisputePage {
	By NewDispute=By.cssSelector("[href='#!/newDispute']");
	By FileUpload=By.xpath("//input[@type='file']");
	By UploadButton=By.xpath("//button[contains(text(),'Upload')]");
	
	public void click_NewDispute(){
		SeleniumMethods.click(NewDispute, "New Dispute is Clicked");
		
		
		
	}
	
	public void TextFileUpload(){
		
		
		
		SeleniumMethods.type(FileUpload, JsonReader.readJson("Dispute//Disputeinput","TextFile"), "Click on File Upload");
	}
	
	
	public void ExcelFileUpload(){
		
		SeleniumMethods.type(FileUpload, JsonReader.readJson("Dispute//Disputeinput","ExcelFile"), "Click on File Upload");
	}
	
	public void DocFileUpload(){
		
		SeleniumMethods.type(FileUpload, JsonReader.readJson("Dispute//Disputeinput","DocFile"), "Click on File Upload");
	}
	
	
	public void XmlFileUpload(){
		
		SeleniumMethods.type(FileUpload, JsonReader.readJson("Dispute//Disputeinput","XmlFile"), "Click on File Upload");
	}
	
	public void ImageFileUpload(){
		
		SeleniumMethods.type(FileUpload, JsonReader.readJson("Dispute//Disputeinput","ImageFile"), "Click on File Upload");	
		
	}
	
	
	public void PdfFileUpload(){
		SeleniumMethods.type(FileUpload, JsonReader.readJson("Dispute//Disputeinput","PdfFile"), "Click on File Upload");	
		
	}
	
	public void click_uploadbutton(){
	SeleniumMethods.click(UploadButton, "Click on Upload button");
	SeleniumMethods.waitForElementPresent(By.xpath("//label[contains(text(),'Attachments')]"));
}
}
