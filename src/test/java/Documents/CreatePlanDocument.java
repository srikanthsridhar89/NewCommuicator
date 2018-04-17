package Documents;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.calliduscloud.testing.Communicator.CommissionHomePage;
import com.calliduscloud.testing.Communicator.HomePage;
import com.calliduscloud.testing.Communicator.LoginPage;
import com.calliduscloud.testing.util.JsonReader;
import com.calliduscloud.testing.util.ReportTemplate;
import com.calliduscloud.testing.util.SeleniumMethods;

public class CreatePlanDocument {

	
	@BeforeClass
	public  void setUp() throws Exception
	{
		SeleniumMethods.initilization("Create Plan Document");
	}
	
	@Test
	public void PlanDocumentCreation(){
	try{
		//Login into SalesPortal
		LoginPage loginPage=new LoginPage();
		//Enter User details 
		loginPage.Login(JsonReader.readJson("envconfig","AdminUser"),JsonReader.readJson("envconfig","AdminPassword"));
		//Click on Login
		loginPage.click_login();
		//Verify HomePage
		HomePage salesperformancehome=new HomePage();

		salesperformancehome.verify_HomePage(); 
		SeleniumMethods.wait_untilPageLoads();
		
		//Select Commission from Home dropdown 
		
		salesperformancehome.select_Commission();
		CommissionHomePage commHome=new CommissionHomePage();
		commHome.verify_commissionhome();
		
		//Navaigate to Plan
		commHome.navigatetoPlan();
		

}
	
	
	
	catch(Exception e)
	{
		SeleniumMethods.catch_code(e);
	}
	}






@AfterClass
public  void teardown() throws Exception
{
	//ReportTemplate.close_Initilization();
}

}




