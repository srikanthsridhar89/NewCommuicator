package DisputeEndtoEndFlow_DisputeTab;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.calliduscloud.testing.Communicator.*;
import com.calliduscloud.testing.util.JsonReader;
import com.calliduscloud.testing.util.ReportTemplate;
import com.calliduscloud.testing.util.SeleniumMethods;

/**
 * 
 *@author srikanth
 *
 *
 */
public class SubmitDispute {


@BeforeClass
	public  void setUp() throws Exception
	{
		SeleniumMethods.initilization("SubmitDispute");
	}



	@Test
	public void SubmitDispute_Incentive(){

	
		try{
			//Login into SalesPortal
			LoginPage loginPage=new LoginPage();
			//Enter User details 
			loginPage.Login(JsonReader.readJson("envconfig","UserName"),JsonReader.readJson("envconfig","Password"));
			//Click on Login
			loginPage.click_login();
			//Verify HomePage
			HomePage salesperformancehome=new HomePage();

			salesperformancehome.verify_HomePage(); 
			SeleniumMethods.wait_untilPageLoads();
			//Click on Dispute 
			MyDisputePage Dispute=new MyDisputePage();
			Dispute.click_DisputeTab();
			
			//Click on New Dispute
			NewDisputePage NewDispute=new NewDisputePage();
			NewDispute.click_NewDispute();
			
		
             
			//Enter the details  Dispute
			DisputePage DisputeCreation=new DisputePage();
			
			SeleniumMethods.staticwait(4000);
			DisputeCreation.DisputeCreation(JsonReader.readJson("Dispute//Disputeinput","DisputeType"));
		
			
		
			DisputeCreation.click_submit();
			
			
			//Verify Dispute Submitted
			MyDisputePage MyDisp=new MyDisputePage();
			DisputeDetailPage DisputeDetail=new DisputeDetailPage();
			DisputeDetail.check_DisputeDetail();
			
			Assert.assertEquals("Pending Approval", MyDisp.Get_ApprovalStatusText());
			
			
		
			

			
		
			
		}
		catch(Exception e)
		{
			SeleniumMethods.catch_code(e);
		}

	}

	


	@AfterClass
	public  void teardown() throws Exception
	{
		ReportTemplate.close_Initilization();
	}

}



