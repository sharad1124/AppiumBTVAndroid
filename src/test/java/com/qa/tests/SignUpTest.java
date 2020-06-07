package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.BaseTest;
import com.qa.pages.DashboardPage;
import com.qa.pages.ForgotPasswordPage;
import com.qa.pages.LoginPage;
import com.qa.pages.MarketingPage;
import com.qa.pages.SignUpPage;
import com.qa.pages.VerifyNewUserPage;
import com.qa.pages.VerifyOTPPage;
import com.qa.utils.TestUtils;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Random;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class SignUpTest extends BaseTest{
	SignUpPage signuppage;
	ForgotPasswordPage forgotpasswordPage;
	MarketingPage marketingPage;
	LoginPage loginPage;
	VerifyOTPPage otppage;
	VerifyNewUserPage verifypage;
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
		  signuppage = new SignUpPage();
		  marketingPage = new MarketingPage();
		  loginPage = new LoginPage();
		  otppage = new VerifyOTPPage();
		  verifypage = new VerifyNewUserPage();
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
  
	 
  @Test(enabled=true,priority = 1)
  public void verifyLoginLink() {
	  
	  loginPage = marketingPage.marketingScreens();
	  
	  String actualHeadingText55 = signuppage.getSignUptext();
	  String expectedHeadingText55 = "Register";
	  System.out.println("actual error txt - " + actualHeadingText55 + "\n" + "expected error txt - " + expectedHeadingText55);
	  Assert.assertEquals(actualHeadingText55, expectedHeadingText55);
	  
	  signuppage.clickOnSignUpButton();
	  
	  String actualHeadingText5 = signuppage.getSignScreenDes();
	  String expectedHeadingText5 = "Please register for free to save your recordings.";
	  System.out.println("actual error txt - " + actualHeadingText5 + "\n" + "expected error txt - " + expectedHeadingText5);
	  Assert.assertEquals(actualHeadingText5, expectedHeadingText5);
	  
	  
	  String actualHeadingText1 = signuppage.getLoginButtonText();
	  String expectedHeadingText1 = "Log In";
	  System.out.println("actual error txt - " + actualHeadingText1 + "\n" + "expected error txt - " + expectedHeadingText1);
	  Assert.assertEquals(actualHeadingText1, expectedHeadingText1);
	  
	  signuppage.backLoginButton();
	  
	  String actualHeadingText4 = loginPage.getTitle();
	  String expectedHeadingText4 = "Please login to save your recordings.";
	  System.out.println("actual error txt - " + actualHeadingText4 + "\n" + "expected error txt - " + expectedHeadingText4);
	  Assert.assertEquals(actualHeadingText4, expectedHeadingText4);
	  
	 
	  	  	  
  }
  @Test(enabled=true,priority = 2,dependsOnMethods = {"verifyLoginLink"})
  public void verifyResendCode() {

	  
	  signuppage.clickOnSignUpButton();
	  
	  signuppage.firstNameTextField("sharad");
	  signuppage.lastNameTextField("Gupta");
	  
	  Random randomGenerator = new Random();  
	  int randomInt = randomGenerator.nextInt(1000);
	  
	  signuppage.emailId("yashimittal09+" + randomInt +"@gmail.com");
	  signuppage.choosePassword("Password1124!");
	  signuppage.confirmPassword("Password1124!");
	  
	  signuppage.registerButtonClick();
	  
	  String actualHeadingText4 = otppage.otpScreenToolBar();
	  String expectedHeadingText4 = "Verify your Email";
	  System.out.println("actual error txt - " + actualHeadingText4 + "\n" + "expected error txt - " + expectedHeadingText4);
	  Assert.assertEquals(actualHeadingText4, expectedHeadingText4);
	  
	  String actualHeadingText = otppage.otpScreenDescription();
	  String expectedHeadingText = "You have received an email containing Verification Code. Please enter here.";
	  System.out.println("actual error txt - " + actualHeadingText + "\n" + "expected error txt - " + expectedHeadingText);
	  Assert.assertEquals(actualHeadingText, expectedHeadingText);
	  
//	  String actualHeadingText6 = otppage.resendCodeButton();
//	  String expectedHeadingText6 = "Resend Code";
//	  System.out.println("actual error txt - " + actualHeadingText6 + "\n" + "expected error txt - " + expectedHeadingText6);
//	  Assert.assertEquals(actualHeadingText6, expectedHeadingText6);
	  
	  //otppage.resendCodeButtonClicked();

	    }
  
  
      @Test(enabled=true,priority = 3,dependsOnMethods = {"verifyLoginLink"})
      public void verifySignUp() {
	  
	  otppage.firstOtp("1");
	  otppage.secoundOtp("2");
	  otppage.thirdOtp("3");
	  otppage.fourthOtp("4");
	  
	  otppage.verifyAccountButton();
	  
      String actualHeadingText1 = dashboardPage.getHeadingText();
	  Assert.assertEquals(actualHeadingText1, getStrings().get("Dashboard_screen_text"));
	  Assert.assertTrue(dashboardPage.dashboardTextVisible());
	  TestUtils.log().info("Dashboard Text visible ----" + dashboardPage.dashboardTextVisible());	
      String actualHeadingText11 = dashboardPage.getrecordingTabText();
      TestUtils.log().info("Recording Text visible ----" + dashboardPage.getrecordingTabText());

	  
	  
	  
	    }

}
