package com.qa.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.qa.BaseTest;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import com.qa.pages.MarketingPage;
import com.qa.utils.TestUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class MarketingTest extends BaseTest{
	
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
	  }
	  
	  @BeforeMethod
	  public void beforeMethod(Method m) {
		  marketingPage = new MarketingPage();
		  loginPage = new LoginPage();
		  TestUtils.log().info("\n"+ "**********Starting Test******** :" + m.getName() + "*****" + "\n");
		  
	  }

	  @AfterMethod
	  public void afterMethod() {
		  utils.log("login test before metod");
	  }
	  
	  @Test(enabled =true,priority = 1)
	  public void validateMarketingButton() {
		  
		
			  String actualHeadingText = marketingPage.getBUTTONTxt();
			  String expectedHeadingText = getStrings().get("start_recording_text");
			  System.out.println("actual error txt -" + actualHeadingText + "\n" + "expected error txt - " + expectedHeadingText);
			  Assert.assertEquals(actualHeadingText, expectedHeadingText);
		  
		   }

	  @Test(enabled =true,priority = 2,dependsOnMethods = {"validateMarketingButton"})
	  public void validateMarketingText() {
		  
		  //marketingPage.recordingButton();
		  String actualHeadingText = marketingPage.getWelcomeText();
		  String expectedHeadingText = "WELCOMe";
		  System.out.println("actual error txt -" + actualHeadingText + "\n" + "expected error txt - " + expectedHeadingText);
		  Assert.assertEquals(actualHeadingText.equalsIgnoreCase(actualHeadingText), expectedHeadingText.equalsIgnoreCase(expectedHeadingText));
		  
	  }
	  @Test(enabled =true,priority = 3,dependsOnMethods = {"validateMarketingButton"})
	  public void validateMareketingScreen(){
		  
		  Assert.assertTrue(marketingPage.recordingButtonTap());

		  marketingPage.recordingButton();
		  getDriver().rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
		  marketingPage.closeRecordingButton();
		  marketingPage.recordingButton();
		  getDriver().rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);  
		 //THIS WILL CLICK ON THE VIDEO START BUTTON 
		  marketingPage.startVideoButton();
		//AGAIN USING THE SAME ACTION TO STOP THE VIDEO BUTTON
		  marketingPage.stopVideoButton();
		  
		  String actualHeadingText = loginPage.getTitle();
		  String expectedHeadingText = getStrings().get("login_screen_text");
		  System.out.println("actual error txt - " + actualHeadingText + "\n" + "expected error txt - " + expectedHeadingText);
		  Assert.assertEquals(actualHeadingText, expectedHeadingText);		  
		  Assert.assertTrue(loginPage.loginButtonPresent());
          System.out.println("Login Button visible ----" + loginPage.loginButtonPresent());


	  }
	  
	  
	



}
