package com.qa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;
import com.qa.reports.ExtentReport;
import com.qa.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;


public class BaseTest {
	
	protected static ThreadLocal <AppiumDriver> driver = new ThreadLocal <AppiumDriver>();
	protected static ThreadLocal <Properties> props = new ThreadLocal <Properties>();
	protected static ThreadLocal <HashMap<String, String> >strings = new ThreadLocal<HashMap<String, String>>();
	protected static ThreadLocal <String> dateTime = new ThreadLocal <String>();
	protected static ThreadLocal <String> deviceName = new ThreadLocal <String>();
	//protected static ThreadLocal <String> platform = new ThreadLocal <String>();
	private static AppiumDriverLocalService server;

	protected TestUtils utils;

	  public AppiumDriver getDriver() {
		  return driver.get();
	  }
	  
	  public void setDriver(AppiumDriver driver2) {
		  driver.set(driver2);	  
	  }
	  
	  public Properties getProps() {
		  return props.get();
	  }
	  
	  public void setProps(Properties props2) {
		  props.set(props2);
	  }
	  
	  public HashMap<String,String>getStrings() {
		  return strings.get();
	  }
	  
	  public void setStrings(HashMap<String,String> strings2) {
		   strings.set(strings2);
	  }
	  
//	  public String getPlatform(){
//		  return platform.get();
//	  }
//	  
//	  public void setPlatform(String platform2) {
//		  platform.set(platform2);
//	  }
	  	  
	  public String getDateTime() {
		  return dateTime.get();
	  }
	  
	  public void setDateTime(String dateTime2) {
		  dateTime.set(dateTime2);
	  }
	  
	  public String getDeviceName() {
		  return deviceName.get();
	  }
	  
	  public void setDeviceName(String deviceName2) {
		  dateTime.set(deviceName2);
	  }
	  
	public BaseTest() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}
  
	@BeforeMethod
	public void beforeMethod() {
		
		((CanRecordScreen) getDriver()).startRecordingScreen();	
	}
	
	@AfterMethod
	public synchronized void afterMethod(ITestResult result) {
		System.out.println("super after method");

		String media = ((CanRecordScreen) getDriver()).stopRecordingScreen();
		
		if(result.getStatus() == 2) {
			Map <String, String> params = result.getTestContext().getCurrentXmlTest().getAllParameters();
			
			String dir = "videos" + File.separator + params.get("platformName") + "_" + params.get("platformVersion") + "_"
			+ params.get("deviceName") + File.separator + getDateTime() + File.separator + result.getTestClass().getRealClass().getSimpleName();
			
			File videoDir = new File(dir);
			
			synchronized(videoDir) {
				if(!videoDir.exists()) {
					videoDir.mkdirs();
					
				}
			}
			
			
			try {
				FileOutputStream stream = new FileOutputStream(videoDir + File.separator + result.getName() + ".mp4");
			 stream.write(org.apache.commons.codec.binary.Base64.decodeBase64(media));
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
	}
	
	@BeforeSuite
	public void beforeSuite() throws Exception, Exception {
		server = getAppiumService();
		server.start();
		server.clearOutPutStreams();
		TestUtils.log().info("Server Start");
		
	}
	
	@AfterSuite
	public void afterSuite() {
		server.stop();
		TestUtils.log().info("Server Stop"); 
		
	}
	
	public AppiumDriverLocalService getAppiumServerDefault() {
		return AppiumDriverLocalService.buildDefaultService();
	}
	
	public AppiumDriverLocalService getAppiumService() {
		HashMap<String, String> environment = new HashMap<String, String>();
		environment.put("PATH", "/Library/Java/JavaVirtualMachines/jdk-11.0.1.jdk/Contents/Home/bin:/Users/sharadgupta/Library/Android/sdk/tools:/Users/sharadgupta/Library/Android/sdk/platform-tools:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin" + System.getenv("PATH"));
		environment.put("ANDROID_HOME", "/Users/sharadgupta/Library/Android/sdk");
        environment.put("JAVA_HOME", "/Library/Java/JavaVirtualMachines/jdk-11.0.1.jdk/Contents/Home");
		return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("/usr/local/bin/node"))
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.usingPort(4723)
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				.withEnvironment(environment)
				.withLogFile(new File("ServerLogs/server.log")));
	}

  @Parameters({"emulator","platformName","deviceName","udid","systemPort"})
  @BeforeTest
  public void beforeTest(@Optional("androidOnly")String emulator,String platformName,String deviceName,@Optional("androidOnly")String udid,@Optional("androidOnly")String systemPort) throws Exception {

	  TestUtils utils = new TestUtils();
	  setDateTime(TestUtils.dateTime());
		InputStream inputStream = null;
		InputStream stringsis = null;
		setDeviceName(deviceName);
		//setPlatform(platformName);
		Properties props = new Properties();
		AppiumDriver driver;
		
		String strFile = "logs" + File.separator + platformName + "_" + deviceName;
		File logFile = new File(strFile);
		if(!logFile.exists()) {
			logFile.mkdirs();
		}
		ThreadContext.put("ROUTINGKEY", strFile);
		TestUtils.log().info("log path:" + strFile);
	  try {
		  props = new Properties();
		  String propFileName = "config.properties";
		  String xmlFileName = "strings/strings.xml";
		  
		  inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		  props.load(inputStream);
		  setProps(props);
		  
          stringsis = getClass().getClassLoader().getResourceAsStream(xmlFileName);
		  setStrings(TestUtils.parseStringXML(stringsis));
		  
		    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("platformName", platformName);
			System.out.println("Platform Name is >>>>>" + platformName);
			desiredCapabilities.setCapability("deviceName", deviceName);
			System.out.println("Device Name is >>>>>" + deviceName);
			desiredCapabilities.setCapability("udid", udid);
			System.out.println("UDID Name is >>>>>" + udid);
			desiredCapabilities.setCapability("systemPort", systemPort);
			System.out.println("SystemPort Name is >>>>>" + systemPort);
			desiredCapabilities.setCapability("automationName", props.getProperty("androidAutomationName"));
			desiredCapabilities.setCapability("appPackage",props.getProperty("androidAppPackage"));
			desiredCapabilities.setCapability("appActivity", props.getProperty("androidAppActivity"));
			desiredCapabilities.setCapability("unicodeKeyboard", props.getProperty("androidunicodeKeyboard"));
			desiredCapabilities.setCapability("resetKeyboard", props.getProperty("androidresetKeyboard"));
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true");
			desiredCapabilities.setCapability("noRest",true);
			
			if(emulator.equalsIgnoreCase("true")) {
			desiredCapabilities.setCapability("avd", deviceName);
			} 
			//desiredCapabilities.setCapability("systemPort", systemPort); Integer.parseInt(systemPort)
			//desiredCapabilities.setCapability("chromeDriverPort", chromeDriverPort);

		    String appUrl = getClass().getResource(props.getProperty("androidAppLocation")).getFile();
		    //URL appUrl = getClass().getClassLoader().getResource("androidAppLocation");
		    TestUtils.log().info("appUrl is" + appUrl);
			desiredCapabilities.setCapability("app", appUrl);
			URL url = new URL(props.getProperty("appiumURL") + "4723/wd/hub");
			driver = new AndroidDriver(url, desiredCapabilities);
			String sessionId = driver.getSessionId().toString();
			
			setDriver(driver);
	  } catch(Exception e) {
		  e.printStackTrace();
		  throw e;
	  }finally {
		  if(inputStream != null) {
			  inputStream.close();
		  }
		  if(stringsis != null) {
			  stringsis.close();
			  
		  }
	  }
  }
   
 
public void waitForVisibility(MobileElement e) {
	  WebDriverWait wait = new WebDriverWait(getDriver(), TestUtils.WAIT);
			  wait.until((ExpectedConditions.visibilityOf((e))));
  }

public void waitForVisibility(WebElement e){
	  Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
	  .withTimeout(Duration.ofSeconds(30))
	  .pollingEvery(Duration.ofSeconds(5))
	  .ignoring(NoSuchElementException.class);
	  
	  wait.until(ExpectedConditions.visibilityOf(e));
	  }
	  public void click(MobileElement e) {
		  waitForVisibility(e);
		  e.click();	  
	  }
	  
	  public void click(MobileElement e, String msg) {
		  waitForVisibility(e);
		  TestUtils.log().info(msg);
		  ExtentReport.getTest().log(Status.INFO, msg);
		  e.click();	  
	  }
	  
		  public void sendkeys(MobileElement e, String text) {
		  waitForVisibility(e);
		  e.sendKeys(text);		  
	  }
		  
		  public void sendkeys(MobileElement e, String text, String msg) {
		  waitForVisibility(e);
		  TestUtils.log().info(msg);
		  ExtentReport.getTest().log(Status.INFO, msg);
		  e.sendKeys(text);		  
	  }

	  public String getAttribute(MobileElement e, String attribute) {
		  waitForVisibility(e);
		  return e.getAttribute(attribute);
		  
	  }
	  
	  public void clear(MobileElement e) {
		  waitForVisibility(e);
		  e.clear();
	  }

		  public String getText(MobileElement e, String msg) {
		  String txt = null;
		  txt = getAttribute(e, "text");
		  TestUtils.log().info(msg + txt);
		  ExtentReport.getTest().log(Status.INFO, msg);
		  return txt;
		  }
		  
		  public void closeApp() {
			  ((InteractsWithApps) getDriver()).closeApp();
		  }
		  
		  public void launchApp() {
			  ((InteractsWithApps) getDriver()).launchApp();
		  }
		  
  @AfterTest
  public void afterTest() {
	  getDriver().quit();
  }

}
