package com.qa.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.Status;
import com.qa.BaseTest;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import com.qa.pages.MarketingPage;
import com.qa.reports.ExtentReport;
import com.qa.utils.TestUtils;

import org.testng.annotations.BeforeMethod;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class LoginTest extends BaseTest{
	TestUtils utils = new TestUtils();
	MarketingPage marketingPage;
	LoginPage loginPage;
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
		  utils.log("login test before method");
	  }
	  
	  @BeforeMethod
	  public void beforeMethod(Method m) {
		  marketingPage = new MarketingPage();
		  loginPage = new LoginPage();
		  dashboardPage = new DashboardPage();
		  TestUtils.log().info("\n"+ "**********Starting Test******** :" + m.getName() + "*****" + "\n");
		  loginPage = marketingPage.marketingScreens();
		  dashboardPage = loginPage.login(loginUser.getJSONObject("verifyLogin").getString("username"), loginUser.getJSONObject("verifyLogin").getString("password")); 
		  TestUtils.log().info("LOGIN BUTTON CLICK");
	  }

	  @AfterMethod
	  public void afterMethod() {
	  }

  @AfterTest
  public void afterTest() {
  }
  
  
  @Test( enabled=true)
  public void verifyLogin() {
	  
	  
	  String actualHeadingText = dashboardPage.getHeadingText();
	  String expectedHeadingText = "Earnings Videos";
	  System.out.println("actual error txt - " + actualHeadingText + "\n" + "expected error txt - " + expectedHeadingText);
	  Assert.assertEquals(actualHeadingText, expectedHeadingText);
	  Assert.assertTrue(dashboardPage.dashboardTextVisible());
      System.out.println("Dashboard Text visible ----" + dashboardPage.dashboardTextVisible());	 
      
      //dashboardPage.clickOnProTip();
      //dashboardPage.navigatebackDashboard();
      dashboardPage.settings();
      TestUtils.log().info("DASHBOARD SETTING BUTTON CLICK");
      dashboardPage.logoutButton();
      TestUtils.log().info("DASHBOARD LOGOUT BUTTON CLICK");
      dashboardPage.logoutButtonOK();
      TestUtils.log().info(">>>>>>USER LOGGED OUT<<<<<<");
      
      String actualHeadingText3 = loginPage.getTitle();
	  String expectedHeadingText3 = getStrings().get("login_screen_text");
	  System.out.println("actual error txt - " + actualHeadingText3 + "\n" + "expected error txt - " + expectedHeadingText3);
	  Assert.assertEquals(actualHeadingText3, expectedHeadingText3);		  
	  Assert.assertTrue(loginPage.loginButtonPresent());
      System.out.println("Login Button visible ----" + loginPage.loginButtonPresent());
      
  }

}
