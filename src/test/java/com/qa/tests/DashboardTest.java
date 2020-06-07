package com.qa.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
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
import org.testng.asserts.SoftAssert;

import com.qa.BaseTest;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import com.qa.pages.MarketingPage;
import com.qa.pages.ProTipPage;
import com.qa.utils.TestUtils;


public class DashboardTest extends BaseTest{
	TestUtils utils = new TestUtils();
	LoginPage loginPage;
	MarketingPage marketingPage;
	DashboardPage dashboardPage;
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
		TestUtils.log().info("login test before metod");
		dashboardPage = new DashboardPage();
		loginPage = new LoginPage();
		marketingPage = new MarketingPage();
		TestUtils.log().info("\n"+ "**********Starting Test******** :" + m.getName() + "*****" + "\n");	  
	  }

	  @AfterMethod
	  public void afterMethod() {
		  TestUtils.log().info("login test before method");
		
	  }

  @AfterTest
  public void afterTest() {
  }
  
  
  @Test(enabled =true,priority = 1)
  public void verifyDashboardTitle() {
	  
	  loginPage= marketingPage.marketingScreens();
	  TestUtils.log().info(">>>>>Marketing Screen<<<<<<");
	  dashboardPage = loginPage.login(loginUser.getJSONObject("verifyLogin").getString("username"), loginUser.getJSONObject("verifyLogin").getString("password"));
	  TestUtils.log().info(">>>>>Login Screen<<<<<<");
	  
	  String actualHeadingText = dashboardPage.getHeadingText();
	  String expectedHeadingText = getStrings().get("Dashboard_screen_text");
	  System.out.println("actual error txt - " + actualHeadingText + "\n" + "expected error txt - " + expectedHeadingText);
	  Assert.assertEquals(actualHeadingText, expectedHeadingText);
	  Assert.assertTrue(dashboardPage.dashboardTextVisible());
	  TestUtils.log().info("Dashboard Text visible ----" + dashboardPage.dashboardTextVisible());	
      
	  dashboardPage.clickOnProTip();
      dashboardPage.navigatebackDashboard();
      dashboardPage.clickOnEditing();
      
      String actualHeadingText1 = dashboardPage.getHeadingText();
	  Assert.assertEquals(actualHeadingText1, getStrings().get("Dashboard_screen_text"));
	  Assert.assertTrue(dashboardPage.dashboardTextVisible());
	  TestUtils.log().info("Dashboard Text visible ----" + dashboardPage.dashboardTextVisible());	
      String actualHeadingText11 = dashboardPage.getrecordingTabText();
      TestUtils.log().info("Recording Text visible ----" + dashboardPage.getrecordingTabText());
//	  //String expectedHeadingText1 = getStrings().get("Recording_text");
//	  //System.out.println("actual error txt - " + actualHeadingText1 + "\n" + "expected error txt - " + expectedHeadingText1);
	  Assert.assertEquals(actualHeadingText11, getStrings().get("Recording_text"));
     	  
  }
  @Test(enabled =false,priority = 2)
  public void verifyRecordingTitle() {
//	  loginPage.login(loginUser.getJSONObject("verifyLogin").getString("username"), loginUser.getJSONObject("verifyLogin").getString("password"));
//	  TestUtils.log().info(">>>>>Login Screen<<<<<<");
//	  String actualHeadingText1 = dashboardPage.getrecordingTabText();
//	  String expectedHeadingText1 = getStrings().get("Recording_text");
//	  System.out.println("actual error txt - " + actualHeadingText1 + "\n" + "expected error txt - " + expectedHeadingText1);
//	  Assert.assertEquals(actualHeadingText1, expectedHeadingText1);
//	  
//	  Assert.assertTrue(dashboardPage.recordTextVisible());
//	  
//      System.out.println("Dashboard Text visible ----" + dashboardPage.recordTextVisible());	
//      
//      dashboardPage.settings();
//      TestUtils.log().info("DASHBOARD SETTING BUTTON CLICK");
//      dashboardPage.logoutButton();
//      TestUtils.log().info("DASHBOARD LOGOUT BUTTON CLICK");
//      dashboardPage.logoutButtonOK();
//      TestUtils.log().info(">>>>>>USER LOGGED OUT<<<<<<");
//      
//      String actualHeadingText3 = loginPage.getTitle();
//	  String expectedHeadingText3 = getStrings().get("login_screen_text");
//	  System.out.println("actual error txt - " + actualHeadingText3 + "\n" + "expected error txt - " + expectedHeadingText3);
//	  Assert.assertEquals(actualHeadingText3, expectedHeadingText3);		  
//	  Assert.assertTrue(loginPage.loginButtonPresent());
//      System.out.println("Login Button visible ----" + loginPage.loginButtonPresent());
	  
	  
     	  
  }
  
  @Test(enabled =false,priority = 3)
  public void verifyEditTitle() {
	 	  
	  String actualHeadingText = dashboardPage.geteditedTabText();
	  String expectedHeadingText = getStrings().get("Editing_text");
	  System.out.println("actual error txt - " + actualHeadingText + "\n" + "expected error txt - " + expectedHeadingText);
	  Assert.assertEquals(actualHeadingText, expectedHeadingText);
	  
	  Assert.assertTrue(dashboardPage.editTextVisible());
	  
      System.out.println("Dashboard Text visible ----" + dashboardPage.editTextVisible());	 
     	  
  }
  
}
