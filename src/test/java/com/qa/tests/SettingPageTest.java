package com.qa.tests;

import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.BaseTest;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import com.qa.pages.MarketingPage;
import com.qa.pages.ProTipPage;
import com.qa.pages.SettingPage;
import com.qa.utils.TestUtils;


public class SettingPageTest extends BaseTest{
	TestUtils utils = new TestUtils();
	MarketingPage marketingPage;
	ProTipPage proTipPage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	SettingPage settingpage;
	JSONObject loginUser;	
	
	@BeforeClass
	  public void beforeClass() throws Exception {
		InputStream datais = null;
		try {
			String dataFileName = "data/loginUser.json";
			datais = getClass().getClassLoader().getResourceAsStream(dataFileName);
			JSONTokener tokener = new JSONTokener(datais);
			loginUser = new JSONObject(tokener);
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(datais != null) {
				datais.close();
			}
		}
		closeApp();
		launchApp();
	  }

	  @AfterClass
	  public void afterClass() {
	  }
	  
	  @BeforeMethod
	  public void beforeMethod(Method m) {
		System.out.println("login test before metod");
		  marketingPage = new MarketingPage();
		  proTipPage = new ProTipPage();
		  settingpage = new SettingPage();
		  marketingPage = new MarketingPage();
		  loginPage = new LoginPage();
		  dashboardPage = new DashboardPage(); 
		  TestUtils.log().info("\n"+ "**********Starting Test******** :" + m.getName() + "*****" + "\n");	  
	  }

	  @AfterMethod
	  public void afterMethod() {
		  TestUtils.log().info("login test before metod");
		
	  }

  @AfterTest
  public void afterTest() {
	  
  }
  
  
  @Test(enabled =true,priority = 1)
  public void verifyProfileText() {
	  
	  loginPage = marketingPage.marketingScreens();
	  dashboardPage = loginPage.login(loginUser.getJSONObject("verifyLogin").getString("username"), loginUser.getJSONObject("verifyLogin").getString("password")); 
	  TestUtils.log().info("LOGIN BUTTON CLICK");
	  
	  dashboardPage.settings();
      TestUtils.log().info("DASHBOARD SETTING BUTTON CLICK");
      
      String actualHeadingText5 = settingpage.getSettingHeaderText();
      TestUtils.log().info("verify setting heading>>>>>" + actualHeadingText5);
  	  String expectedHeadingText5 = getStrings().get("Setting_Heading");
  	  TestUtils.log().info("actual error txt - " + actualHeadingText5 + "\n" + "expected error txt - " + expectedHeadingText5);
  	  Assert.assertEquals(actualHeadingText5, expectedHeadingText5);
      
      settingpage.profileClick();
      TestUtils.log().info("Profile BUTTON CLICK");
      
    String actualHeadingText = settingpage.getProfileHeaderText();
    TestUtils.log().info("verify Profile heading>>>>>" + actualHeadingText);
	  String expectedHeadingText = getStrings().get("Profile_Heading");
	  TestUtils.log().info("actual error txt - " + actualHeadingText + "\n" + "expected error txt - " + expectedHeadingText);
	  Assert.assertEquals(actualHeadingText, expectedHeadingText);
      
	  settingpage.profileSetting(loginUser.getJSONObject("profileSetting").getString("firstname"), loginUser.getJSONObject("profileSetting").getString("secoundName"),loginUser.getJSONObject("profileSetting").getString("position"),loginUser.getJSONObject("profileSetting").getString("company"),loginUser.getJSONObject("profileSetting").getString("companyAddress"));
	  TestUtils.log().info("Save BUTTON CLICK");

	  settingpage.verifySaveButton();
	  
    String actualHeadingText1 = settingpage.getSettingHeaderText();
    TestUtils.log().info("verify Profile heading>>>>>" + actualHeadingText1);
	  String expectedHeadingText1 = getStrings().get("Setting_Heading");
	  TestUtils.log().info("actual error txt - " + actualHeadingText1 + "\n" + "expected error txt - " + expectedHeadingText1);
	  Assert.assertEquals(actualHeadingText1, expectedHeadingText1);
	  	  
  }
  

  
  

}
