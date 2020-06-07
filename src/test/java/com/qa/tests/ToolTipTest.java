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
import com.qa.pages.MarketingPage;
import com.qa.pages.ProTipPage;
import com.qa.utils.TestUtils;


public class ToolTipTest extends BaseTest{
	TestUtils utils = new TestUtils();
	MarketingPage marketingPage;
	ProTipPage proTipPage;
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
  public void verifyToolTipText() {
	  
	  marketingPage.recordingButton();
	  Assert.assertTrue(proTipPage.getProText()); 
	  String actualHeadingText = proTipPage.getProTipText();
	  String expectedHeadingText = getStrings().get("pro_tip_message");
	  System.out.println("actual error txt - " + actualHeadingText + "\n" + "expected error txt - " + expectedHeadingText);
	  Assert.assertEquals(actualHeadingText, expectedHeadingText);
	  
	  
  }
  
  @Test(enabled =true,priority = 2,dependsOnMethods = {"verifyToolTipText"})
  public void verifyToolTipHeading() {
	  
	  
	  Assert.assertTrue(proTipPage.getProText());
      System.out.println("Start Recording Button visible ----" + proTipPage.getProText());
      
	  proTipPage.protip();
	  
	  String actualHeadingText3 = proTipPage.getProTipheading();
	  String expectedHeadingText3 = getStrings().get("pro_tip_message");
	  System.out.println("actual error txt - " + actualHeadingText3 + "\n" + "expected error txt - " + expectedHeadingText3);
	  Assert.assertEquals(actualHeadingText3, expectedHeadingText3);
	  
	  String actualHeadingText4 = proTipPage.getTextLighting();
	  String expectedHeadingText4 = getStrings().get("lighting_text");
	  System.out.println("actual error txt -" + actualHeadingText4 + "\n" + "expected error txt - " + expectedHeadingText4);
	  Assert.assertEquals(actualHeadingText4, expectedHeadingText4);
	  
	  String actualHeadingText1 = proTipPage.getTextProfessional();
	  String expectedHeadingText1 = getStrings().get("professional_text");
	  System.out.println("actual error txt -" + actualHeadingText1 + "\n" + "expected error txt - " + expectedHeadingText1);
	  Assert.assertEquals(actualHeadingText1, expectedHeadingText1);
	  
	  proTipPage.backButton();
	  	  
  }
  
  
  @Test(enabled =true,priority = 3,dependsOnMethods = {"verifyToolTipText"})
  public void verifyToolTipScreenText1() {
	  
	  Assert.assertTrue(proTipPage.getProText());
      System.out.println("Start Recording Button visible ----" + proTipPage.getProText());
	  proTipPage.protip();
	  
	  String actualHeadingText = proTipPage.getProTipheading();
	  String expectedHeadingText = "PRO TIP";
	  System.out.println("actual error txt - " + actualHeadingText + "\n" + "expected error txt - " + expectedHeadingText);
	  Assert.assertEquals(actualHeadingText, expectedHeadingText);
	  
	  proTipPage.backButton();
	  
	  String actualHeadingText2 = proTipPage.getProTipText() + "abc";
	  String expectedHeadingText2 = "PRO TIP";
	  System.out.println("actual error txt - " + actualHeadingText2 + "\n" + "expected error txt - " + expectedHeadingText2);
	  Assert.assertEquals(actualHeadingText2, expectedHeadingText2);
	  	  
  }
  
  

}
