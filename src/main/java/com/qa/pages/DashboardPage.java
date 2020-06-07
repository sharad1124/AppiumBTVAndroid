package com.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.qa.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DashboardPage extends LoginPage{
	// earinings videos text
	@AndroidFindBy(id ="com.earningvideo:id/toolbar_title") 
	private MobileElement hedingText;
	@AndroidFindBy(id ="tab_id_record") 
	private MobileElement recordingTabText;
	
	@AndroidFindBy(id ="tab_id_edit") 
	private MobileElement editedTabText;
	
	@AndroidFindBy(xpath ="(//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Publishing\"])[2]") 
	private MobileElement publishedTabText;
     
	//left side pro tip text
	@AndroidFindBy(id ="com.earningvideo:id/pro_tip_text_view") 
	private MobileElement proTip;
    // Pro tips heading text 
	@AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView") 
	private MobileElement proTipsText;
    
// step 1 text 
	@AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView[1]") 
	private MobileElement step1Heading;
	// step 1 descripton
	@AndroidFindBy(id ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView[2]") 
	private MobileElement step1descption;

	//navigateback dashboard
		@AndroidFindBy(accessibility ="Navigate up") 
		private MobileElement navigatebackdashboard;
		

		@AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout[4]") 
		private MobileElement settingTabBottom;
			
		//logout
		@AndroidFindBy(id ="com.earningvideo:id/log_out_text_view") 
		private MobileElement logout;

		@AndroidFindBy(id ="android:id/button1") 
		private MobileElement logoutOk;


		public String getHeadingText() {
			return getAttribute(hedingText,"text");
		}
		
		public boolean dashboardTextVisible() {
			return hedingText.isDisplayed();
		}
		
		public DashboardPage clickOnProTip(){
			click(proTip);
			return this;	
		}
		public DashboardPage navigatebackDashboard(){
			click(navigatebackdashboard);
			return this;	
		}
		
		public DashboardPage settings(){
			click(settingTabBottom);
			return this;	
		}
		
		public DashboardPage logoutButton(){
			click(logout);
			return this;	
		}
		
		public DashboardPage logoutButtonOK(){
			click(logoutOk);
			return this;	
		}
		
		public String getrecordingTabText() {
			return getAttribute(recordingTabText,"text");
		}
		
		public DashboardPage clickOnRecording(){
			click(recordingTabText);
			return this;	
		}
		
		public boolean recordTextVisible() {
			return recordingTabText.isDisplayed();
		}
		
		public String geteditedTabText() {
			return getAttribute(editedTabText,"text");
		}
		
		public boolean editTextVisible() {
			return editedTabText.isDisplayed();
		}
		
		public DashboardPage clickOnEditing(){
			click(editedTabText);
			return this;	
		}
		
		public String getpublishedTabText() {
			return getAttribute(publishedTabText,"text");
		}
		public String getProTipText() {
			return getAttribute(proTip,"text");
		}
}
