package DisputeSubmission_Unittypes;

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

public class SubmitDispute_USDUnittype {

@BeforeClass
	public  void setUp() throws Exception
	{
		SeleniumMethods.initilization("SubmitDispute_USDUnittype");
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
			
		
              Thread.sleep(4000);
			//Enter the details  Dispute
			DisputePage DisputeCreation=new DisputePage();
			DisputeCreation.DisputeCreation(JsonReader.readJson("Dispute//Disputeinput","DisputeType"));
		
			//Select USD Unit type
		
			DisputeCreation.type_USDRequestAmount();
			DisputeCreation.SelectRequestAmount_USD();
			
		
			DisputeCreation.click_submit();
			SeleniumMethods.staticwait(3000);
			
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


