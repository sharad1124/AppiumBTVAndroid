package com.qa.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.BaseTest;
import com.qa.pages.ForgotPasswordPage;
import com.qa.pages.LoginPage;
import com.qa.pages.MarketingPage;
import com.qa.pages.ProTipPage;
import com.qa.utils.TestUtils;

import org.testng.annotations.BeforeClass;
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

public class ForgotPasswordTest extends BaseTest{
	ForgotPasswordPage forgotpasswordPage;
	MarketingPage marketingPage;
	LoginPage loginPage;
	InputStream datais;
	JSONObject loginUser;
	
	@BeforeClass
		public void beforeClass() throws Exception {
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
		  forgotpasswordPage = new ForgotPasswordPage();
		  marketingPage = new MarketingPage();
		  loginPage = new LoginPage();
		  
		  TestUtils.log().info("\n"+ "**********Starting Test******** :" + m.getName() + "*****" + "\n");
		  loginPage = marketingPage.marketingScreens();
	  }

	  @AfterMethod
	  public void afterMethod() {
		  utils.log("login test before metod");
	  }

  @AfterTest
  public void afterTest() {
  }
  
 
	 
  @Test(enabled =true,priority = 1)
  public void verifyForgotPasswordToolBar() {
	  
//	  //Assert.assertTrue(marketingPage.recordingButtonTap());
//      //System.out.println("Start Recording Button visible ----" + marketingPage.recordingButtonTap());
//	  marketingPage.recordingButton();
//	  getDriver().rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
//	//THIS WILL CLICK ON THE VIDEO START BUTTON 
//	  marketingPage.startVideoButton();
//	//AGAIN USING THE SAME ACTION TO STOP THE VIDEO BUTTON
//	  marketingPage.stopVideoButton();
	  
	  String actualHeadingText5 = forgotpasswordPage.getButtonText();
	  String expectedHeadingText5 = "Forgot password?";
	  System.out.println("actual error txt - " + actualHeadingText5 + "\n" + "expected error txt - " + expectedHeadingText5);
	  Assert.assertEquals(actualHeadingText5, expectedHeadingText5);
	  
	  Assert.assertTrue(forgotpasswordPage.forgotButtonDisplayed());

	  forgotpasswordPage.forgotButtonLink();
	  
	  String actualHeadingText1 = forgotpasswordPage.getForgotScreenToolBar();
	  String expectedHeadingText1 = "Forgot Password";
	  System.out.println("actual error txt - " + actualHeadingText1 + "\n" + "expected error txt - " + expectedHeadingText1);
	  Assert.assertEquals(actualHeadingText1, expectedHeadingText1);
	  
	  
	  String actualHeadingText4 = forgotpasswordPage.getForgotScreenHeading();
	  String expectedHeadingText4 = "Enter your email and we will send you a link. By tapping on the link you can set your password.";
	  System.out.println("actual error txt - " + actualHeadingText4 + "\n" + "expected error txt - " + expectedHeadingText4);
	  Assert.assertEquals(actualHeadingText4, expectedHeadingText4);
	  
	 	  	  
  }
  
  
  @Test(enabled =true,priority = 2,dependsOnMethods = { "verifyForgotPasswordToolBar" })
  public void verifyEmailResend() {
//	  marketingPage.recordingButton();
//	  driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
//	//THIS WILL CLICK ON THE VIDEO START BUTTON 
//	  marketingPage.startVideoButton();
//	//AGAIN USING THE SAME ACTION TO STOP THE VIDEO BUTTON  getReSendButtonText
//	  marketingPage.stopVideoButton();
//	  
//	  forgotpasswordPage.forgotButtonLink();

	  forgotpasswordPage.currentPassword("tt@tt.com");
	  
	  String actualHeadingText1 = forgotpasswordPage.getReSendButtonText();
	  String expectedHeadingText1 = "Resend Email";
	  System.out.println("actual error txt - " + actualHeadingText1 + "\n" + "expected error txt - " + expectedHeadingText1);
	  Assert.assertEquals(actualHeadingText1, expectedHeadingText1);
	  
	  Assert.assertTrue(forgotpasswordPage.resendButtonDisplayed());

	  //forgotpasswordPage.emailResendButton();
	  
  }
  @Test(enabled =true,priority = 3,dependsOnMethods = {"verifyForgotPasswordToolBar"})
  public void verifyForgotPassword() {
	  
//	  marketingPage.recordingButton();
//	  driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
//	//THIS WILL CLICK ON THE VIDEO START BUTTON 
//	  marketingPage.startVideoButton();
//	//AGAIN USING THE SAME ACTION TO STOP THE VIDEO BUTTON
//	  marketingPage.stopVideoButton();
//	  
//	  forgotpasswordPage.forgotButtonLink();

	  forgotpasswordPage.currentPassword("tt@tt1.com");
	  
	  String actualHeadingText1 = forgotpasswordPage.getSendButtonText();
	  String expectedHeadingText1 = "SEND";
	  System.out.println("actual error txt - " + actualHeadingText1 + "\n" + "expected error txt - " + expectedHeadingText1);
	  Assert.assertEquals(actualHeadingText1, expectedHeadingText1);
	  
	  Assert.assertTrue(forgotpasswordPage.sendButtonDisplayed());

	  forgotpasswordPage.sendButton();
	  
	  
	  forgotpasswordPage.backToLogin();
	  
	  String actualHeadingText = loginPage.getTitle();
	  String expectedHeadingText = getStrings().get("login_screen_text");
	  System.out.println("actual error txt - " + actualHeadingText + "\n" + "expected error txt - " + expectedHeadingText);
	  Assert.assertEquals(actualHeadingText, expectedHeadingText1);
	  
  }
  
  

}
