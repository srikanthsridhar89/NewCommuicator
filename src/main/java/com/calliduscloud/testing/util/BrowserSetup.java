package com.calliduscloud.testing.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserSetup 
{



	/**
	 * Gets the browser from the configuration file
	 * 
	 * 
	 * @return
	 */
	private static String getBrowser() 
	{
		return JsonReader.readJson("envconfig","Browser");
	}

	/**
	 * Chrome Driver: Get the chrome driver with desired capabilities.
	 * 
	 * @return
	 * @throws MalformedURLException
	 */
	public static RemoteWebDriver createdriverInstance() throws Exception 
	{	
		RemoteWebDriver driver=null;
		String browserType = BrowserSetup.getBrowser();
		String remoteMachineUrl=JsonReader.readJson("envconfig","remotemachine");
		String url=JsonReader.readJson("envconfig","ApplicationUrl");
		switch(browserType)
		{
		case "CHROME":
			String downloadFolderlocation=System.getProperty("user.dir") + "\\downloads";
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("download.default_directory",downloadFolderlocation);
			chromePrefs.put("profile.default_content_settings.popups", 0);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			DesiredCapabilities capabilities=DesiredCapabilities.chrome();
			capabilities.setBrowserName("chrome");
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);	

			if(remoteMachineUrl.contains("localhost"))
			{

				String chromeDriverLocation=JsonReader.readJson("envconfig","chromedriverLocation");
				System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
				driver=new ChromeDriver(capabilities);

			}
			else
			{
				driver = new RemoteWebDriver(new URL(remoteMachineUrl),capabilities);
				driver.setFileDetector(new LocalFileDetector());
			}
			driver.get(url);
			driver.manage().window().maximize();
			break;
		case "FIREFOX" :
			FirefoxProfile profile = new FirefoxProfile();
			DesiredCapabilities dc=DesiredCapabilities.firefox();
			profile.setAcceptUntrustedCertificates(false);
			profile.setAssumeUntrustedCertificateIssuer(true);
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.helperApps.alwaysAsk.force", false);
			profile.setPreference("browser.download.manager.showWhenStarting",false);
			String downloadFilepath = System.getProperty("user.dir") + "/Downloads";
			profile.setPreference("browser.download.dir", downloadFilepath); 
			profile.setPreference("browser.download.downloadDir",downloadFilepath); 
			profile.setPreference("browser.download.defaultFolder",downloadFilepath); 
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/anytext ,text/plain,text/html,application/plain" );
			dc = DesiredCapabilities.firefox();
			dc.setCapability(FirefoxDriver.PROFILE, profile);
			if(remoteMachineUrl.contains("localhost"))
			{
				String geckodriver=JsonReader.readJson("envconfig","geckodriverLocation");
				System.setProperty("webdriver.gecko.driver", geckodriver);
				driver = new FirefoxDriver(dc);

			}
			else
			{
				driver = new RemoteWebDriver(new URL(remoteMachineUrl),dc);
				driver.setFileDetector(new LocalFileDetector());
			}

			driver.get(url);
			//driver.manage().window().maximize();
			break;
		case "IE" :
			DesiredCapabilities capabilitiesie = DesiredCapabilities.internetExplorer();
			capabilitiesie.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			capabilitiesie.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			capabilitiesie.setCapability("requireWindowFocus", false);
			capabilitiesie.setCapability("enablePersistentHover", false);
			if(remoteMachineUrl.contains("localhost"))
			{

				String ieDriverLocation=JsonReader.readJson("envconfig","iedriverLocation");
				System.setProperty("webdriver.ie.driver", ieDriverLocation);
				driver = new InternetExplorerDriver(capabilitiesie);

			}
			else
			{
				driver = new RemoteWebDriver(new URL(remoteMachineUrl),capabilitiesie);
				driver.setFileDetector(new LocalFileDetector());
			}
			driver.get(url);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();

		}
		return driver;

	}
}
