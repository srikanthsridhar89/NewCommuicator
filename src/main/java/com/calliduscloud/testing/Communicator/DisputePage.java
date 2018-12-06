package com.calliduscloud.testing.Communicator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.calliduscloud.testing.util.JsonReader;
import com.calliduscloud.testing.util.SeleniumMethods;

public class DisputePage {

	By DisputeTypeSelector=By.xpath("//label[contains(text(),'Dispute type')]/../descendant::div/select");
	
	By RequestAmount=By.xpath("//label[text()=' Requested Amount  ']/../descendant::input");
	By RequestAmountSelector=By.xpath("//label[text()=' Requested Amount  ']/../descendant::select");
	
	//By DisputetypeSelector=By.cssSelector("#formly_1_horizontalSelect_template_0");
	By SubmitButton=By.xpath("//button[contains(text(),'Submit')]");
	
	public void DisputeCreation(String disputetype) throws InterruptedException{
		
		
	//	SeleniumMethods.waitForElementPresentToselect(DisputeTypeSelector);
		//SeleniumMethods.staticwait(3000);
		WebDriverWait wait=new WebDriverWait(SeleniumMethods.getDriver(),30);
		wait.until(ExpectedConditions.elementToBeClickable(DisputeTypeSelector));
		SeleniumMethods.selectByVisibleText(DisputeTypeSelector, disputetype.trim(), "Incentive Request is Selected");
		
		}
	
	
	
	public void type_USDRequestAmount(){
	
		SeleniumMethods.type(RequestAmount, JsonReader.readJson("Dispute//Disputeinput","USDUnittype"), "Entering USD Unit type");
		
}
	
	public void type_ThaiRequestAmount(){
		
		SeleniumMethods.type(RequestAmount, JsonReader.readJson("Dispute//Disputeinput","ThaiUnittype"), "Entering Thai Unit type");
		
	}
	
	public void type_PercentRequestAmount(){
		
	SeleniumMethods.type(RequestAmount, JsonReader.readJson("Dispute//Disputeinput","PercentUnittype"), "Entering Percent Unit type");
		
}
	
	public void type_QuantityRequestAmount(){
		
		SeleniumMethods.type(RequestAmount, JsonReader.readJson("Dispute//Disputeinput","QuantityUnittype"), "Entering Quantity Unit type");	
		
	}
	
	public void type_IntegerRequestAmount(){
	
		SeleniumMethods.type(RequestAmount, JsonReader.readJson("Dispute//Disputeinput","IntegerUnittype"), "Entering Integer Unit type");
		
		
	}
	
	public void SelectRequestAmount_USD(){
		
		SeleniumMethods.selectByVisibleText(RequestAmountSelector, "USD", "USD Unit type is selected");
	}
	
	public void SelectRequestAmount_Percent(){
		
		SeleniumMethods.selectByVisibleText(RequestAmountSelector, "percent", "Percent Unit type is selected");
	}
	
	public void SelectRequestAmount_Integer(){
		
		SeleniumMethods.selectByVisibleText(RequestAmountSelector, "integer", "Integer is selected");
	}
	
	public void SelectRequestAmount_Quantity(){
		
		SeleniumMethods.selectByVisibleText(RequestAmountSelector, "quantity", "Quantity is selected");
	}
	
	public void click_submit(){
		//Click on Submit
		SeleniumMethods.staticwait(8000);
		JavascriptExecutor js = (JavascriptExecutor) SeleniumMethods.getDriver();
		js.executeScript("window.scrollBy(0,1000)");
		//SeleniumMethods.submit(SubmitButton);
		//SeleniumMethods.click(SubmitButton, "Click on Submit");
		SeleniumMethods.javascript_click(SubmitButton, "Click on Submit Button");
		
	}
}
