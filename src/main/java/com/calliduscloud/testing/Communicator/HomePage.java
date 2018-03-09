package com.calliduscloud.testing.Communicator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.calliduscloud.testing.util.JsonReader;
import com.calliduscloud.testing.util.ReportTemplate;
import com.calliduscloud.testing.util.SeleniumMethods;
import com.calliduscloud.testing.util.UtilityFunctions;


/**
 * 
 * @author srikanth
 *
 */
public class HomePage {

	By homePageLocator=By.xpath("//span[1][contains(text(),'Sales Performance Home')]");
	By DisputeLocator=By.cssSelector("[href='#!/disputes']");
	By NewDispute=By.cssSelector("[href='#!/newDispute']");
	By DisputetypeSelector=By.cssSelector("#formly_1_horizontalSelect_template_0");
	By ReportLocator=By.xpath("//span[contains(text(),'Reports')]");
	By MessageLocator=By.xpath("//span[contains(text(),'Messages')]");
	By DocumentandApprovalLocator=By.xpath("//span[contains(text(),'Documents & Approvals')]");
	By UserDropDown=By.xpath("//span[@class='cald-ui-header__user']/span[@class='cald-ui-dropdown cald-ui-dropdown--clickable']/span");
	By LogOutLocator =By.xpath("//div[contains(text(),'Logout')]");
	By SalesPerformancehomedropdownLocator=By.xpath("//span[@class='cald-ui-caret']");
	By CommissionUILocator=By.xpath("//a[contains(text(),'Commissions')]");
	
	public void verify_HomePage()
	{
		SeleniumMethods.waitForElementPresent(homePageLocator);
		String homePageText=SeleniumMethods.getText(homePageLocator, "HomePageText");
	
		
		
	}

	
	
	
	
	public void click_Dispute(){
		
		SeleniumMethods.wait_untilPageLoads();
		SeleniumMethods.click(DisputeLocator, "Dispute Tab is Clicked");
		
	}
	
	
	public void click_Report(){
		SeleniumMethods.wait_untilPageLoads();
		SeleniumMethods.click(ReportLocator, "Report Tab is Clicked");
	}
	
	
	public void click_Message(){
		SeleniumMethods.wait_untilPageLoads();
		SeleniumMethods.click(MessageLocator, "Message Tab is Clicked");
	}
 
	public void click_DocumentandApproval(){
		SeleniumMethods.wait_untilPageLoads();
		SeleniumMethods.click(DocumentandApprovalLocator, "Document and Approval Tab is Clicked");
		
	}
	
	public void click_Logout(){
		SeleniumMethods.javascript_click(UserDropDown, "Click on UserDropDown");
		SeleniumMethods.javascript_click(LogOutLocator, "Click on Logout");	
	}
	
	public void select_Commission(){
		
		SeleniumMethods.click(SalesPerformancehomedropdownLocator, "SalesPerformance Home dropdown");
		SeleniumMethods.click(CommissionUILocator, "Select Commission UI");
		
	}


}
