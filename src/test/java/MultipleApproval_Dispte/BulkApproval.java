package MultipleApproval_Dispte;

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

public class BulkApproval {

	public class BulkApproval_Dispute {

		@BeforeClass
		public void setUp() throws Exception {
			SeleniumMethods.initilization("DisputeBulkApproval");
		}

		@Test
		public void DisputeBulkApproval() {

			try {
				// Login into SalesPortal
				LoginPage loginPage = new LoginPage();
				// Enter User details
				loginPage.Login(JsonReader.readJson("envconfig", "UserName"),
						JsonReader.readJson("envconfig", "Password"));
				// Click on Login
				loginPage.click_login();
				// Verify HomePage
				HomePage salesperformancehome = new HomePage();

				salesperformancehome.verify_HomePage();
				SeleniumMethods.wait_untilPageLoads();
				// Click on Dispute
				MyDisputePage Dispute = new MyDisputePage();
				Dispute.click_DisputeTab();

				// Click on New Dispute
				NewDisputePage NewDispute = new NewDisputePage();
				NewDispute.click_NewDispute();

				Thread.sleep(4000);
				// Enter the details Dispute
				DisputePage DisputeCreation = new DisputePage();
				DisputeCreation.DisputeCreation(JsonReader.readJson("Dispute//Disputeinput", "DisputeType"));

				DisputeCreation.click_submit();
				SeleniumMethods.staticwait(3000);

				// Verify Dispute Submitted
				MyDisputePage MyDisp = new MyDisputePage();
				DisputeDetailPage DisputeDetail = new DisputeDetailPage();
				DisputeDetail.verify_DisputeDetailspage();
				DisputeDetail.check_DisputeDetail();

				Assert.assertEquals("Pending Approval", MyDisp.Get_ApprovalStatusText());

				// Click on New Dispute to create
				NewDispute.click_NewDispute();

				Thread.sleep(5000);

				DisputeCreation.DisputeCreation(JsonReader.readJson("Dispute//Disputeinput", "DisputeType"));

				DisputeCreation.click_submit();
				SeleniumMethods.staticwait(3000);

				// Verify Dispute Submitted

				DisputeDetail.check_DisputeDetail();

				Assert.assertEquals("Pending Approval", MyDisp.Get_ApprovalStatusText());

				// Logout of SalesPortal

				salesperformancehome.click_Logout();
				loginPage.Login(JsonReader.readJson("envconfig", "Mgrname"),
						JsonReader.readJson("envconfig", "Mgrpassword"));
				// Click on Login
				loginPage.click_login();
				// Verify HomePage
				salesperformancehome.verify_HomePage();
				SeleniumMethods.wait_untilPageLoads();
				// Click on Dispute
				Dispute.click_DisputeTab();
				// Select Multiple Disputes
				DisputeDetail.check_MultipleDispute();

				// Click on Approve
				DisputeDetail.click_Approve();

				// EnterComments
				DisputeDetail.typecomments(JsonReader.readJson("Dispute//Disputeinput", "ManageApprovalComments"));
				// Click on Ok
				DisputeDetail.click_Okbutton();
			
				Assert.assertEquals("Pending Adjustment", MyDisp.Get_DisputeAdjustmentStatusText());
				
				

			} catch (Exception e) {
				SeleniumMethods.catch_code(e);
			}

		}

		@AfterClass
		public void teardown() throws Exception {
			ReportTemplate.close_Initilization();
		}

	}

}
