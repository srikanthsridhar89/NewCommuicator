package DisputeEndtoEndFlow_DisputeTab;

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

public class PayeeRespondedtoManagerInquiry {

	public class ManagerInquirytoPayee {
		@BeforeClass
		public  void setUp() throws Exception
		{
			SeleniumMethods.initilization("PayeeRespondedtoManagerInquiry");
		}



		@Test
		public void ManagerSentInquiry(){

		
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
				DisputeCreation.DisputeCreation(JsonReader.readJson("Dispute//Disputeinput","DisputeType"));
				SeleniumMethods.staticwait(2000);
				
				DisputeCreation.click_submit();
				
				//Verify Dispute Submitted
				MyDisputePage MyDisp=new MyDisputePage();
				
				Assert.assertEquals("Pending Approval", MyDisp.Get_ApprovalStatusText());
				//Click on Logout
				salesperformancehome.click_Logout();
				
			
				//Login into SalesPortal as Payee's Manager
				loginPage.Login(JsonReader.readJson("envconfig","Mgrname"),JsonReader.readJson("envconfig","Mgrpassword"));
				//Click on Login
				loginPage.click_login();
				//Verify HomePage
				salesperformancehome.verify_HomePage(); 
				SeleniumMethods.wait_untilPageLoads();
				//Click on Dispute 
				Dispute.click_DisputeTab();

				//Select the Dispute and Inquiry Button
				DisputeDetailPage DisputeDetail=new DisputeDetailPage();
				
				DisputeDetail.check_DisputeDetail();
				//Click on Dispute Detail
				DisputeDetail.Click_DisputeDetail();
				//Click on Send Inquiry 
				DisputeDetail.click_SendInquiry();
				//EnterComments
				DisputeDetail.typecomments(JsonReader.readJson("Dispute//Disputeinput","ManageInquiryComments"));
				//Click on Ok
				DisputeDetail.click_Okbutton();
				//Click on Cancel
				DisputeDetail.click_Cancelbutton();
				
				//Select the Dispute 
				DisputeDetail.check_DisputeDetail();
				
				//Verify Dispute After Inquiry
				DisputeDetail.check_DisputeDetail();
				
				//Assert.assertEquals("Pending Inquiry", MyDisp.get_InquiryStatusText());
			
				//Click on Logout
				salesperformancehome.click_Logout();
				
				//Login in Portal as Payee
				loginPage.Login(JsonReader.readJson("envconfig","UserName"),JsonReader.readJson("envconfig","Password"));
				//Click on Login
				loginPage.click_login();
				//Verify HomePage
				salesperformancehome.verify_HomePage(); 
				SeleniumMethods.wait_untilPageLoads();
				//Click on Dispute 
				Dispute.click_DisputeTab();

				//Select Dispute and click to Open the Dispute
				DisputeDetail.check_DisputeDetail();
				DisputeDetail.Click_DisputeDetail();
				//Click on Respond
				DisputeDetail.click_PayeeRespondedDispute();
				//Enter Comments
				DisputeDetail.typecomments(JsonReader.readJson("Dispute//Disputeinput","PayeeRespondedComments"));
				//Click on Ok
				DisputeDetail.click_Okbutton();
				//Click on Cancel
				DisputeDetail.click_Cancelbutton();
				//Select the Dispute 
				
				DisputeDetail.check_DisputeDetail();
				
				//Verify Payee Responded Dispute
				DisputeDetail.check_DisputeDetail();
				
				Assert.assertEquals("Pending Approval", MyDisp.Get_ApprovalStatusText());
			}
			catch(Exception e)
			{
				SeleniumMethods.catch_code(e);
			}
		}

				
@AfterClass
	public void teardown() throws Exception {
		ReportTemplate.close_Initilization();
	}
	}
}

