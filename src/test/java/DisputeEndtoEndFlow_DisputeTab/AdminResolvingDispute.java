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

public class AdminResolvingDispute {
	
	@BeforeClass
	public  void setUp() throws Exception
	{
		SeleniumMethods.initilization("AdminResolvingDispute");
	}



	@Test
	public void AdminResolved(){

	
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
			
			Assert.assertEquals("Pending Approval", MyDisp.Get_ApprovalStatusText());
			
			//Verify Dispute Submitted
			//MyDisputePage MyDisp=new MyDisputePage();
			DisputeDetailPage DisputeDetail=new DisputeDetailPage();
			DisputeDetail.check_DisputeDetail();
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

			//Select the Dispute and Approve
		
			
			DisputeDetail.check_DisputeDetail();
			//Click on Dispute Detail
			DisputeDetail.Click_DisputeDetail();
			Thread.sleep(3000);
			//Click on Approve 
			DisputeDetail.click_Approve();
			
			//EnterComments
			DisputeDetail.typecomments(JsonReader.readJson("Dispute//Disputeinput","ManageApprovalComments"));
			//Click on Ok
			DisputeDetail.click_Okbutton();
			//Click on Cancel
			DisputeDetail.click_Cancelbutton();
			//Verify Dispute After Appproval
			DisputeDetail.check_DisputeDetail();
			Assert.assertEquals("Pending Adjustment", MyDisp.Get_DisputeAdjustmentStatusText());
			//Click on Logout
			salesperformancehome.click_Logout();
			
			//Login in as Admininstrator into SalesPortal
			loginPage.Login(JsonReader.readJson("envconfig","AdminUser"),JsonReader.readJson("envconfig","AdminPassword"));
			//Click on Login
			loginPage.click_login();
			//Verify HomePage
			salesperformancehome.verify_HomePage(); 
			SeleniumMethods.wait_untilPageLoads();
			//Click on Dispute 
			Dispute.click_DisputeTab();

			//Select the Dispute 
			DisputeDetail.check_DisputeDetail();
			//Click on Dispute Detail
			DisputeDetail.Click_DisputeDetail();
			Thread.sleep(3000);
			//Click on Resolve  Button
			DisputeDetail.click_AdminResolvedDispute();
			//Enter Comments
			DisputeDetail.typecomments(JsonReader.readJson("Dispute//Disputeinput","AdminResolvedComments"));
			//Click on Ok 
			DisputeDetail.click_Okbutton();
			//Click on Cancel
			
			DisputeDetail.click_Cancelbutton();
			
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



