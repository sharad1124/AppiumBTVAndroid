package com.qa.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Random;

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
import com.qa.pages.EditVideoPage;
import com.qa.pages.LoginPage;
import com.qa.pages.MarketingPage;
import com.qa.pages.ProTipPage;
import com.qa.pages.SettingPage;
import com.qa.utils.TestUtils;


public class EditVideoTest extends BaseTest{
	TestUtils utils = new TestUtils();
	LoginPage loginPage;
	MarketingPage marketingPage;
	DashboardPage dashboardPage;
	JSONObject loginUser;
	SettingPage settingpage;

	EditVideoPage editvideopage;
	
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
		editvideopage = new EditVideoPage();
		dashboardPage = new DashboardPage();
		loginPage = new LoginPage();
		marketingPage = new MarketingPage();
		settingpage = new SettingPage();

		TestUtils.log().info("\n"+ "**********Starting Test******** :" + m.getName() + "*****" + "\n");	  
	  }

	  @AfterMethod
	  public void afterMethod() {
		  TestUtils.log().info("login test before method");
		
	  }

  @AfterTest
  public void afterTest() {
  }
  
  
  //@SuppressWarnings("unlikely-arg-type")
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
      editvideopage.edit();
      editvideopage.editButton();
      
      //EditVideoPage a = editvideopage.subscribeButton();
      
//      if(editvideopage.subscribeButton().equals(true)) {
//    	  TestUtils.log().info(">>>>>Login Screen<<<<<<" + editvideopage.subscribeButton().equals(true));
//          editvideopage.subscribeButton();
//          editvideopage.addCardDetails("4111 1111 1111 1111", "1123", "sharad gupta","123");
//          editvideopage.cardSaveButton(); 
//      } 
//      else {  
//          editvideopage.clickOnProTip();
//          editvideopage.clickBackFromProTip();
//          editvideopage.clickPlay();
//          editvideopage.clickOkButton();
//          editvideopage.clickOnProTip();
//          editvideopage.clickBackFromProTip();
//          editvideopage.clickSaveButton();  
//    	  
//      }    	
      
      //editvideopage.clickOnProTip();
      //editvideopage.clickBackFromProTip();
      //editvideopage.clickPlay();
      editvideopage.clickOkButton();
      //editvideopage.clickOnProTip();
      //editvideopage.clickBackFromProTip();
      editvideopage.clickSaveButton();
      
      // Rename Video Name
      editvideopage.click3DotEdit();
      editvideopage.clickRenameButton();
      editvideopage.clickRenameTextFile("sharad");
      editvideopage.clickSaveRename();
      
      // Add Company Details
      editvideopage.click3DotEdit();
      editvideopage.clickShareForApproval();
      editvideopage.click3DotEdit();
      editvideopage.clickAddCompanyInformation();
	  Random randomGenerator = new Random();  
	  int randomInt = randomGenerator.nextInt(1000);
      editvideopage.addCompanyDetails(randomInt+ "IBM",randomInt + "Macbook",randomInt + "QA Lead",randomInt + "Stock_1",randomInt + "Stock_2",randomInt + "Exchange_1",randomInt + "Exchange_2");
      editvideopage.clickAddCompanySave();
      
      editvideopage.click3DotEdit();
      editvideopage.clickShareForApproval();
      
      // Profile Details
      dashboardPage.settings();
      settingpage.profileClick();
	  Random randomGenerator11 = new Random();  
	  int randomInt11 = randomGenerator.nextInt(1000);
	  settingpage.profileSetting(loginUser.getJSONObject("profileSetting").getString("firstname") + randomInt11, loginUser.getJSONObject("profileSetting").getString("secoundName"),loginUser.getJSONObject("profileSetting").getString("position"),loginUser.getJSONObject("profileSetting").getString("company"),loginUser.getJSONObject("profileSetting").getString("companyAddress"));
	  settingpage.verifySaveButton();
	  
	  //need to add home page link
	  editvideopage.click_home_button();
	  try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  editvideopage.edit();
	  
	  // Share deatils 
	  editvideopage.clickShareForApproval();
	  Random randomGenerator1 = new Random();  
	  int randomInt1 = randomGenerator.nextInt(1000);
	  editvideopage.addReviewerDetails(randomInt1 + "Reviewer's Name","yashimittal09+" + randomInt1 +"@gmail.com");
	  //editvideopage.clickAddNewUser();
	  //editvideopage.clickCrossIcon();
	  try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  editvideopage.clickInviteReviewButton();     
	  try {
		Thread.sleep(20000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

@Test(enabled =false,priority = 1)
public void verifyDeleteAddedVideo() {
	
	loginPage= marketingPage.marketingScreens();
	  TestUtils.log().info(">>>>>Marketing Screen<<<<<<");
	  dashboardPage = loginPage.login(loginUser.getJSONObject("verifyLogin").getString("username"), loginUser.getJSONObject("verifyLogin").getString("password"));
	  TestUtils.log().info(">>>>>Login Screen<<<<<<");
	  editvideopage.edit();
	  editvideopage.clickDeleteButton();
	  
	  Assert.assertTrue(editvideopage.get_no_video_text_view());
	  TestUtils.log().info("No video Text visible ----" + editvideopage.get_no_video_text_view());
	  
	  String actualHeadingText22 = editvideopage.get_NO_video_text_view();
	  String expectedHeadingText22 = "No Videos Available. Please add a recording";
	  System.out.println("actual error txt - " + actualHeadingText22 + "\n" + "expected error txt - " + expectedHeadingText22);
	  Assert.assertEquals(actualHeadingText22, expectedHeadingText22);
	  
	  editvideopage.clickAddButton();
	  editvideopage.clickStartVideo();
	  editvideopage.clickStopVideo();
	  
	  editvideopage.edit();
	  editvideopage.clickDeleteButton();
	  
	  Assert.assertTrue(editvideopage.get_no_video_text_view());
	  TestUtils.log().info("No video Text visible ----" + editvideopage.get_no_video_text_view());
	  
	  String actualHeadingText2 = editvideopage.get_NO_video_text_view();
	  String expectedHeadingText2 = "No Videos Available. Please add a recording";
	  System.out.println("actual error txt - " + actualHeadingText2 + "\n" + "expected error txt - " + expectedHeadingText2);
	  Assert.assertEquals(actualHeadingText2, expectedHeadingText2);
	  
	  
	  
	  //dashboardPage.clickOnEditing();
	  
	  //Assert.assertTrue(dashboardPage.editTextVisible());
	  
	  
	  
}

}
