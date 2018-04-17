package com.calliduscloud.testing.Communicator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.calliduscloud.testing.util.SeleniumMethods;

public class CommissionHomePage {

	By HomePageValidationLocator=By.xpath("//div[@class='wantToTxt']");
	By manageLink=By.partialLinkText("Organization");
	By movetolandingpageworkspaceLocator=By.cssSelector(".landingMenuIcon .plan-menu .landingPageCaret");



	public void verify_commissionhome(){

		//SeleniumMethods.waitForElementPresent(HomePageValidationLocator);
		SeleniumMethods.waitForElementPresent(manageLink,180);
	}

	public void navigatetoPlan(){

		SeleniumMethods.waitForElementPresent(movetolandingpageworkspaceLocator);
		
		clickOnlandingPagePlanMenu();	
		

		SeleniumMethods.staticwait(5000);
		JavascriptExecutor js = (JavascriptExecutor) SeleniumMethods.getDriver();
		js.executeScript("window.scrollBy(0,3000)");
		
	
		

	}



public void clickOnlandingPagePlanMenu() {

	SeleniumMethods.click(movetolandingpageworkspaceLocator, "Click on Plan Menu");
}
}


