package DisputeEndtoEndFlow_MessageTab;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.calliduscloud.testing.Communicator.DisputeDetailPage;
import com.calliduscloud.testing.Communicator.DisputePage;
import com.calliduscloud.testing.Communicator.HomePage;
import com.calliduscloud.testing.Communicator.LoginPage;
import com.calliduscloud.testing.Communicator.MessagesPage;
import com.calliduscloud.testing.Communicator.MyDisputePage;
import com.calliduscloud.testing.Communicator.NewDisputePage;
import com.calliduscloud.testing.util.JsonReader;
import com.calliduscloud.testing.util.ReportTemplate;
import com.calliduscloud.testing.util.SeleniumMethods;

public class ManagerSentInquiry {
	@BeforeClass
	public  void setUp() throws Exception
	{
		SeleniumMethods.initilization("ManagerSentInquiry");
	}
	
	@Test

public void SentInquiry_Manager(){
	
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
		
		SeleniumMethods.staticwait(5000);
		DisputeCreation.DisputeCreation(JsonReader.readJson("Dispute//Disputeinput","DisputeType"));
	
		
	
		DisputeCreation.click_submit();
		
		SeleniumMethods.staticwait(5000);
		
		//Verify Dispute Submitted
		MyDisputePage MyDisp=new MyDisputePage();
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
		//Click on Message Tab
		MessagesPage message=new MessagesPage();
		message.click_MessageTab();
		
		//click on notification message
		message.click_Message();
	
		//Click on Sent Inquiry
		message.click_Inquiry();
		

		//EnterComments
		DisputeDetail.typecomments(JsonReader.readJson("Dispute//Disputeinput","ManageInquiryComments"));
		//Click on Ok
		DisputeDetail.click_Okbutton();
	
		

	}
	catch(Exception e)
	{
		SeleniumMethods.catch_code(e);
	}
	}
	
	
	@AfterClass
	public  void teardown() throws Exception{
		ReportTemplate.close_Initilization();
	}
}
