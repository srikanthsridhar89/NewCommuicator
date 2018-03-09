package com.calliduscloud.testing.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SeleniumMethods
{

	public static final ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	public static ThreadLocal<ExtentTest> logger = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentReports>  report= new ThreadLocal<ExtentReports>();
	private static int time=60;



	public  static RemoteWebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(RemoteWebDriver setdriver) {
		driver.set(setdriver);
	}

	public static ExtentTest getLogger() {
		return logger.get();
	}

	public static void setlogger(ExtentTest setlogger) {
		logger.set(setlogger);
	}

	public static ExtentReports getreport() {
		return report.get();
	}

	public static void setreport(ExtentReports setlogger) {
		report.set(setlogger);
	}

	public static void initilization(String testCaseDescription) throws Exception
	{


		RemoteWebDriver driver=BrowserSetup.createdriverInstance();
		SeleniumMethods.setDriver(driver);
		ExtentReports report=ReportTemplate.instance();
		SeleniumMethods.setreport(report);
		ExtentTest logger=ReportTemplate.loggerinstance(testCaseDescription);
		SeleniumMethods.setlogger(logger);

	}



	public static void type(By by,String value,String fiedlName)
	{	

		waitForElementPresent(by,60);
		SeleniumMethods.getDriver().findElement(by).clear();
		SeleniumMethods.getDriver().findElement(by).sendKeys(value);
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Setting "+fiedlName+" value"+ value);
	}

	public static void clear(By by,String fiedlName)
	{	

		waitForElementPresent(by);
		SeleniumMethods.getDriver().findElement(by).clear();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Clearing "+fiedlName);
	}

	public static void click(By by,String fieldName)
	{
		SeleniumMethods.staticwait(2000);
		WebDriverWait wait=new WebDriverWait(SeleniumMethods.getDriver(),time);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		SeleniumMethods.getDriver().findElement(by).click();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Clicking on" + fieldName);
	}

	public static void execute_javaScript(String code)
	{
		JavascriptExecutor script=(JavascriptExecutor) SeleniumMethods.getDriver();
		script.executeScript(code);
	}

	public static void findElement(By by)
	{
		SeleniumMethods.getDriver().findElement(by);
	}

	public static void selectByVisibleText(By by,String value,String fieldName)
	{

		waitForElementPresent(by);
		Select select=new Select(SeleniumMethods.getDriver().findElement(by));
		select.selectByVisibleText(value);
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Selected "+value+" from Drop Down List of fieldName"+fieldName);
	}


	public static void selectByValue(By by,String value,String fieldName)
	{

		waitForElementPresent(by);
		Select select=new Select(SeleniumMethods.getDriver().findElement(by));
		select.selectByValue(value);
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Selected "+value+" from Drop Down List of fieldName"+fieldName);
	}

	public static void selectDefaultValue(By by,String fieldName)
	{

		waitForElementPresent(by);
		Select select=new Select(SeleniumMethods.getDriver().findElement(by));
		select.selectByIndex(1);
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Selected first value from Drop Down List of fieldName"+fieldName);
	}

	public static String getSelectedOption(By by,String fieldName)
	{

		waitForElementPresent(by);
		Select select=new Select(SeleniumMethods.getDriver().findElement(by));
		String value=select.getFirstSelectedOption().getText();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Value of selected"+fieldName+"is"+value);
		return value;
	}

	public static void alertAccept()
	{
		try{
			WebDriverWait wait=new WebDriverWait(SeleniumMethods.getDriver(),10);
			wait.until(ExpectedConditions.alertIsPresent());
			SeleniumMethods.getDriver().switchTo().alert().accept();
			SeleniumMethods.getLogger().log(LogStatus.INFO, "Alert Accepted");
		}
		catch(Exception e){
			SeleniumMethods.getLogger().log(LogStatus.INFO, "Alert not found");
		}
	}
	
	public static void acceptAlert_ForDelete()
	{
		if(isDeleteVersionChk())
		{
			By deleteversionchk=By.cssSelector("input#isDeleteVersionChk");
			SeleniumMethods.click(deleteversionchk,"deleteversionchk");
		}
		By ok=By.xpath("//span[@label='Delete'] /../following::div//span[@term='Ok']");
		WebDriverWait wait=new WebDriverWait(SeleniumMethods.getDriver(),10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ok));
		SeleniumMethods.click(ok, "OK");
		SeleniumMethods.getLogger().log(LogStatus.INFO, " Ok option clicked");
	}

	public static void acceptAlert_ForDeleteVersion()
	{
		if(isDeleteVersionChk())
		{
			By deleteversionchk=By.cssSelector("input#isDeleteVersionChk");
			SeleniumMethods.click(deleteversionchk,"deleteversionchk");
		}
		By ok=By.xpath("//span[@label='Delete Version'] /../following::div//span[@term='Ok']");
		WebDriverWait wait=new WebDriverWait(SeleniumMethods.getDriver(),10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ok));
		SeleniumMethods.click(ok, "OK");
		SeleniumMethods.getLogger().log(LogStatus.INFO, " Ok option clicked");
	}
	
	public static boolean isDeleteVersionChk()
	{
		By deleteversionchk=By.cssSelector("input#isDeleteVersionChk");
		boolean b=SeleniumMethods.isDisplayed(deleteversionchk, "Is Delete Version CheckBox");
		return b;
	}

	public static Object[] switchToAnotherWindow()
	{
		SeleniumMethods.staticwait(3000);
		Set<String> windows=SeleniumMethods.getDriver().getWindowHandles();
		Object[] window=windows.toArray();	
		SeleniumMethods.getDriver().switchTo().window((String) window[(windows.size()-1)]);
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Switcing to Last Opened/Another window");
		return window;
	}
	public static Object[] getAllWindowObjects()
	{
		Set<String> windows=SeleniumMethods.getDriver().getWindowHandles();
		Object[] window=windows.toArray();
		return window;
	}

	public static void switchtoRequiredWindow(Object[] windows,int window) 
	{
		SeleniumMethods.getDriver().switchTo().window((String) windows[window]);
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Switching to Required window"+window);
	}

	public static void wait_untilPageLoads()
	{
		WebDriverWait wait = new WebDriverWait(SeleniumMethods.getDriver(), time); 
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
	}


	public static void Click_onrequiredElementofList(By by,int index)
	{
		List<WebElement> li = SeleniumMethods.getDriver().findElements(by);
		li.get(index).click();
	}

	public static String getText(By by,String fieldName)
	{
		waitForElementPresent(by);
		String text=SeleniumMethods.getDriver().findElement(by).getText();
		SeleniumMethods.getLogger().log(LogStatus.INFO, fieldName+" is :"+text);
		return text;
	}

	public static String getAttribute(By by,String attributeName,String fieldName)
	{
		waitForElementPresent(by);
		String attributeValue=SeleniumMethods.getDriver().findElement(by).getAttribute(attributeName);
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Getting Text"+attributeValue);
		return attributeValue;
	}

	public static boolean isDisplayed(By by,String fieldName)
	{
		boolean visible=false;
		try
		{
			waitForElementPresent(by);
			System.out.println("in isdisplayed method");
			visible =SeleniumMethods.getDriver().findElement(by).isDisplayed();
			SeleniumMethods.getLogger().log(LogStatus.INFO, "Checking "+fieldName+"is Displayed");
			System.out.println("out isdisplayed method");
		}
		catch(Exception e)
		{
			visible=false;
		}
		return visible;
	}

	public static boolean isEnabled(By by,String fieldName)
	{
		waitForElementPresent(by);
		boolean editable=SeleniumMethods.getDriver().findElement(by).isEnabled();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Checking "+fieldName+"is Enabled");
		return editable;
	}

	public static void closeWindow()
	{
		SeleniumMethods.getDriver().close();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Closing Current Window");
	}

	public static void closeBrowser()
	{
		SeleniumMethods.getDriver().quit();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Closing Browser");
	}

	public static void get(String applicationUrl)
	{
		SeleniumMethods.getDriver().get(applicationUrl);
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Launching "+applicationUrl + "In Browser");
	}

	public static String getTitle()
	{
		String title=SeleniumMethods.getDriver().getTitle();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Getting Title of Window"+title);
		return title;
	}

	public static void getPageSource()
	{
		String pagesource=SeleniumMethods.getDriver().getPageSource();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Getting PageSource"+pagesource);
	}

	public static String getCurrentUrl()
	{
		String url=SeleniumMethods.getDriver().getCurrentUrl();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Getting Current Url :-"+url);
		return url;
	}

	@SuppressWarnings("unused")
	public static List findElements(By by,String fieldName)
	{
		waitForElementPresent(by);
		List<WebElement> elements=SeleniumMethods.getDriver().findElements(by);
		return SeleniumMethods.getDriver().findElements(by);
	}

	public static void windowMaximize()
	{
		SeleniumMethods.getDriver().manage().window().maximize();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Maximizing Window");
	}

	public static void fullscreen()
	{
		SeleniumMethods.getDriver().manage().window().fullscreen();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Viewing in Full Screen");
	}

	public static void waitForElementPresent(By by)
	{
		WebDriverWait wait=new WebDriverWait(SeleniumMethods.getDriver(),time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void waitForElementToBeClickable(By by)
	{
		WebDriverWait wait=new WebDriverWait(SeleniumMethods.getDriver(),time);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public static void waitForElementPresent(By by,int time)
	{
		WebDriverWait wait=new WebDriverWait(SeleniumMethods.getDriver(),time);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public static void doubleclick(By by,String fieldName)
	{

		waitForElementPresent(by);
		Actions actions=new Actions(SeleniumMethods.getDriver());
		actions.moveToElement(SeleniumMethods.getDriver().findElement(by)).doubleClick().build().perform();	
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Double clicking on fieldName"+fieldName);

	}
	public static void movetoElement(By by,String fieldName)
	{
		waitForElementPresent(by);
		Actions actions=new Actions(SeleniumMethods.getDriver());
		actions.moveToElement(SeleniumMethods.getDriver().findElement(by)).build().perform();	
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Moving mouse to FieldName"+fieldName);
	}	
	public static void movetoElement_click(By by,String fieldName)
	{
		waitForElementPresent(by);
		Actions actions=new Actions(SeleniumMethods.getDriver());
		actions.moveToElement(SeleniumMethods.getDriver().findElement(by)).click().build().perform();	
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Moving mouse to fieldname and cliking on"+fieldName);
	}

	public void refreshPage(){
		SeleniumMethods.getDriver().navigate().refresh();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Refreshing Page");
	}


	public void navigate_To(String url){
		SeleniumMethods.getDriver().navigate().to(url);
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Navigating to Url"+url);
	}


	public void navigate_back(){
		SeleniumMethods.getDriver().navigate().back();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Navigating to back");
	}


	public void navigate_forward(){
		SeleniumMethods.getDriver().navigate().forward();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Navigating to forword");
	}

	public WebElement find_activeElement()
	{
		WebElement element=SeleniumMethods.getDriver().switchTo().activeElement();
		SeleniumMethods.getDriver().switchTo().defaultContent();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Finding Active Element");
		return element;
	}



	public void switchToDefaultContent()
	{
		SeleniumMethods.getDriver().switchTo().defaultContent();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "switchToDefaultContent");
	}

	public static void switchToFrame(Object obj)
	{

		if(obj instanceof Integer)
		{
			SeleniumMethods.getDriver().switchTo().frame((int)obj);
		}	
		if(obj instanceof String)
		{
			SeleniumMethods.getDriver().switchTo().frame((String)obj);
		}
		if(obj instanceof By)
		{
			SeleniumMethods.getDriver().switchTo().frame(SeleniumMethods.getDriver().findElement((By) obj));

		}
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Switching To Frame"+obj);
	}

	public static void switchToParentFrame()
	{
		SeleniumMethods.getDriver().switchTo().parentFrame();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "SwitchingToParentFrame");
	}

	public static void dismissAlert()
	{
		WebDriverWait wait=new WebDriverWait(SeleniumMethods.getDriver(),10);
		wait.until(ExpectedConditions.alertIsPresent());
		SeleniumMethods.getDriver().switchTo().alert().dismiss();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Alert Dismissed");
	}

	public static String get_AlertText()
	{
		WebDriverWait wait=new WebDriverWait(SeleniumMethods.getDriver(),10);
		wait.until(ExpectedConditions.alertIsPresent());
		String alertText=SeleniumMethods.getDriver().switchTo().alert().getText();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Getting Alert Text"+alertText);
		return alertText;

	}

	public static void setTextinAlertBox(String alertText)
	{
		WebDriverWait wait=new WebDriverWait(SeleniumMethods.getDriver(),10);
		wait.until(ExpectedConditions.alertIsPresent());
		SeleniumMethods.getDriver().switchTo().alert().sendKeys(alertText);
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Setting text into alert"+alertText);

	}

	public static String getCssValue(By by,String propertyName,String fieldName)
	{
		waitForElementPresent(by);
		String cssValue=SeleniumMethods.getDriver().findElement(by).getCssValue(propertyName);
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Getting Css value of "+fieldName+" "+cssValue);
		return cssValue;

	}

	public static String getTagName(By by,String fieldName)
	{
		String tagName=SeleniumMethods.getDriver().findElement(by).getTagName();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Getting TagName of "+fieldName+" and it is"+tagName);
		return tagName;
	}

	public static boolean isSelected(By by,String fieldName)
	{
		boolean isselect=SeleniumMethods.getDriver().findElement(by).isSelected();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Finding wherther "+fieldName+" is selected or Not"+isselect);
		return isselect;		
	}

	public static void submit(By by)
	{
		SeleniumMethods.getDriver().findElement(by).click();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Submitting the Form");
	}

	public static String captureScreenshot(RemoteWebDriver driver,String ImagesPath)
	{
		TakesScreenshot oScn = (TakesScreenshot) SeleniumMethods.getDriver();
		File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
		File oDest = new File(ImagesPath+".jpg");
		try {
			FileUtils.copyFile(oScnShot, oDest);
		} catch (IOException e) {System.out.println(e.getMessage());}
		return ImagesPath+".jpg";
	}


	public static boolean isElementPresent(By by)
	{
		try{
			waitForElementPresent(by);
			SeleniumMethods.getDriver().findElement(by);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}


	public static boolean isAlertPresent() 
	{ 
		try 
		{ 
			WebDriverWait wait=new WebDriverWait(SeleniumMethods.getDriver(),10);
			wait.until(ExpectedConditions.alertIsPresent());
			SeleniumMethods.getDriver().switchTo().alert(); 
			return true; 
		} 
		catch (Exception e) 
		{ 
			return false; 
		}  
	} 

	public static void  catch_code(Exception e)
	{

		e.printStackTrace();
		ITestResult result = Reporter.getCurrentTestResult();
		String path=System.getProperty("user.dir")+"/Reports/"+UtilityFunctions.generate_fldID(result.getName());
		String screenshot_path=captureScreenshot(SeleniumMethods.getDriver(),path);
		String[] paths=screenshot_path.split("/");
		for(int i=0;i<paths.length;i++)
		{
			System.out.println(paths[paths.length-1]);
		}
		String image= SeleniumMethods.getLogger().addScreenCapture(paths[paths.length-1]);
		SeleniumMethods.getLogger().log(LogStatus.FAIL,e.toString().substring(0,150));
		SeleniumMethods.getLogger().log(LogStatus.FAIL, image);
		Assert.fail("Failed TestCase"+result.getName());	
	}
	public static void  catch_code(String message)
	{

		ITestResult result = Reporter.getCurrentTestResult();
		String path=System.getProperty("user.dir")+"/Reports/"+UtilityFunctions.generate_fldID(result.getName());
		String screenshot_path=captureScreenshot(SeleniumMethods.getDriver(),path);
		String[] paths=screenshot_path.split("/");
		for(int i=0;i<paths.length;i++)
		{
			System.out.println(paths[paths.length-1]);
		}
		String image= SeleniumMethods.getLogger().addScreenCapture(paths[paths.length-1]);
		SeleniumMethods.getLogger().log(LogStatus.FAIL,message);
		SeleniumMethods.getLogger().log(LogStatus.FAIL, image);
		Assert.fail("Failed TestCase"+result.getName());
	}



	public static void javascript_click(By by,String fieldName)
	{
		waitForElementPresent(by);	
		System.out.println("Entered in to this method");
		JavascriptExecutor executor = (JavascriptExecutor)SeleniumMethods.getDriver();
		executor.executeScript("arguments[0].click();",SeleniumMethods.getDriver().findElement(by));
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Clicking on "+fieldName);
	}

	public static void staticwait(int timeinsec)
	{

		try
		{
			Thread.sleep(timeinsec);
		}
		catch(Exception e)
		{

		}

	}

	public static int get_countofchildNodes(By by,String fieldName)
	{

		waitForElementPresent(by);
		int count=SeleniumMethods.getDriver().findElements(by).size();
		//SeleniumMethods.getLogger().log(LogStatus.INFO, "Count of "+fieldName+"childeNodes is :"+ count);
		return count;
	}

	public static String get_SelectedOption(By by)
	{
		Select select=new Select(SeleniumMethods.getDriver().findElement(by));
		String option=select.getFirstSelectedOption().getText();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Current selected option is"+option);
		return option;

	}

	public static void switchTodelfalutContent()
	{
		SeleniumMethods.getDriver().switchTo().defaultContent();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "switched to Default content");
	}

	public static void KeyBoard_Enter(By by)
	{
		SeleniumMethods.getDriver().findElement(by).sendKeys(Keys.ENTER);
		SeleniumMethods.getLogger().log(LogStatus.INFO,"Performing KeyBoard Enter on that Element");
	}

	public static void VerifyAssertion(Object arg0,Object arg1)
	{
		if(arg0.equals(arg1))
		{
			SeleniumMethods.getLogger().log(LogStatus.INFO,"Both are Equal"+arg0);
		}
		else
		{
			ReportTemplate.writeLogsToReport(false,"Expected"+arg0+"But actual is"+arg1);
		}
	}

	public static void Drag_Drop(By source, By target)
	{	
		Actions actions=new Actions(SeleniumMethods.getDriver());
		actions.dragAndDrop(SeleniumMethods.getDriver().findElement(source), SeleniumMethods.getDriver().findElement(target)).build().perform();
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Element is dragged from"+source+" and dropped to"+target);

	}

	public static void click_EnterKey(By by) 
	{
		waitForElementPresent(by);
		SeleniumMethods.getDriver().findElement(by).sendKeys(Keys.ENTER);
	}

	public static void selectByIndex(By by,int index)
	{
		waitForElementPresent(by);
		Select select=new Select(SeleniumMethods.getDriver().findElement(by));
		select.selectByIndex(index);
		SeleniumMethods.getLogger().log(LogStatus.INFO, "Selected "+index+" Index list from Drop Down");
	}

}