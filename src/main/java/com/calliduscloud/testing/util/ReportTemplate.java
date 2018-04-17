package com.calliduscloud.testing.util;

import java.io.File;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportTemplate {
	private static ExtentReports report;
	private static ExtentTest logger;
	public synchronized static ExtentReports instance() {

		if (report == null) {
			String Path = System.getProperty("user.dir") + "/Reports/AutomationReports.html";
			report = new ExtentReports(Path, false, DisplayOrder.OLDEST_FIRST);
			report.loadConfig(new File(System.getProperty("user.dir") +"/calliduscloudlogo/extent-config.xml"));

		}
		return report;
	}

	public synchronized static ExtentTest loggerinstance(String testCaseDescription) {
		logger=report.startTest(testCaseDescription);
		return logger;
	}

	
	public static void writeLogsToReport(String status,String message)
	{

		status=status.toUpperCase();
		switch(status)
		{
		case "PASS":
			logger.log(LogStatus.PASS, message);  
			break;
		case "FAIL":
			logger.log(LogStatus.FAIL, message);  
			break;
		case "INFO":
			logger.log(LogStatus.INFO, message);  
			break;
		}
	}

	public static void writeLogsToReport(boolean b,String message)
	{

		if(b)
		{
			logger.log(LogStatus.INFO, message);  
		}
		else
		{

			SeleniumMethods.catch_code("Validation is Failed"+message);
		}
	}

	public  synchronized static void close_Initilization() throws Exception
	{

		System.out.println("Driver Instance is"+SeleniumMethods.getDriver().toString());
		report.endTest(logger);
		report.flush();
		SeleniumMethods.closeBrowser();
		

	}

}







