package com.calliduscloud.testing.communicator;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.calliduscloud.testing.Communicator.DisputeDetailPage;
import com.calliduscloud.testing.Communicator.DisputePage;
import com.calliduscloud.testing.Communicator.HomePage;
import com.calliduscloud.testing.Communicator.LoginPage;
import com.calliduscloud.testing.Communicator.MyDisputePage;
import com.calliduscloud.testing.Communicator.NewDisputePage;
import com.calliduscloud.testing.util.JsonReader;
import com.calliduscloud.testing.util.ReportTemplate;
import com.calliduscloud.testing.util.SeleniumMethods;

public class CancelDispute {

	@BeforeClass
	public  void setUp() throws Exception
	{
		SeleniumMethods.initilization("CancelDispute");
	}

     @Test
		public void CancellingDispute(){

		
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
				DisputeCreation.DisputeCreation(JsonReader.readJson("envconfig","DisputeType"));
				SeleniumMethods.staticwait(2000);
				
				DisputeCreation.click_submit();
				
				//Verify Dispute Submitted
				MyDisputePage MyDisp=new MyDisputePage();
				
				Assert.assertEquals("Pending Approval", MyDisp.Get_ApprovalStatusText());
				
				//Select the Dispute Submitted and Open the dispute detail 
				DisputeDetailPage DisputeDetail=new DisputeDetailPage();
				DisputeDetail.check_DisputeDetail();
				DisputeDetail.Click_DisputeDetail();
				
				//Click on Cancel
				DisputeDetail.click_CancelDispute();
				//EnterComments
				DisputeDetail.typecomments(JsonReader.readJson("envconfig","PayeeCancelledComments"));
				
				//Click on Ok
				DisputeDetail.click_Okbutton();
				
				//Click on Cancel
				DisputeDetail.click_Cancelbutton();
				
				//Verify Cancelled Dispute
				DisputeDetail.check_DisputeDetail();
				Assert.assertEquals("Canceled",MyDisp.Get_DisputeCancelStatusText());
				
				}
			catch(Exception e)
			{
				SeleniumMethods.catch_code(e);
			}

		}

		

		
		//Verify Cancel Button
		
		
@AfterClass
public  void teardown() throws Exception
{
	ReportTemplate.close_Initilization();
}

		
		

	}
	



	
	

