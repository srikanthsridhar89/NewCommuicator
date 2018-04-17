package DisputeSubmission_Attachments;

import org.openqa.selenium.JavascriptExecutor;
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

public class DisputeSubmission_XmlFileformat {
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
			DisputeCreation.DisputeCreation(JsonReader.readJson("Dispute//Disputeinput","DisputeType"));
			
			
			JavascriptExecutor jse = (JavascriptExecutor)SeleniumMethods.getDriver();
			jse.executeScript("window.scrollBy(0,250)", "");
			
			//Click on File Upload button
			NewDispute.XmlFileUpload();
			
			
			//Click on Upload
			NewDispute.click_uploadbutton();
			
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

