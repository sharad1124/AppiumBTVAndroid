package com.qa.pages;

import com.qa.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SettingPage extends BaseTest {
	
	
		@AndroidFindBy(id = "com.earningvideo:id/toolbar_title") 
		private MobileElement Setting_toolbar_title;
		
		@AndroidFindBy(id = "com.earningvideo:id/profile_text_view") 
		private MobileElement profile_text_view;
		
		@AndroidFindBy(id = "com.earningvideo:id/green_toolbar_title") 
		private MobileElement green_toolbar_title;

		@AndroidFindBy(id = "com.earningvideo:id/save_btn") 
		private MobileElement save_bt;
		
//		@AndroidFindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[5]") 
//		private MobileElement save_bt;

		@AndroidFindBy(id = "com.earningvideo:id/name_edit_text_view") 
		private MobileElement name_edit_text_view;

		@AndroidFindBy(id = "com.earningvideo:id/last_name_edit_text_view") 
		private MobileElement last_name_edit_text_view;

		@AndroidFindBy(id = "com.earningvideo:id/position_edit_text") 
		private MobileElement position_edit_text;

		@AndroidFindBy(id = "com.earningvideo:id/company_edit_text") 
		private MobileElement company_edit_text;

		@AndroidFindBy(id = "com.earningvideo:id/company_address_edit_text") 
		private MobileElement company_address_edit_text;
		

		//	com.earningvideo:id/change_password_text_view

		public String getSettingHeaderText() {
			return getAttribute(Setting_toolbar_title,"text");
		}
		
	
		
		//profile heading
		public String getProfileHeaderText() {
			return getAttribute(green_toolbar_title,"text");
		}
		
		public String getProfileText() {
			return getAttribute(profile_text_view,"text");
		}
		
		public SettingPage profileClick() {
		    click(profile_text_view, "Press login button");
		    return this;
			
		}
		
		
		
		public boolean saveButtonPresent() {
			return save_bt.isDisplayed();
		}
		
		public boolean saveButtonEnabled() {
			return save_bt.isEnabled();
		}
		
		
        public SettingPage firstName(String firstname) {
        	clear(name_edit_text_view);
    		sendkeys(name_edit_text_view,firstname);
    		return this;	
    	}
		
        public SettingPage secoundName(String secoundName) {
        	clear(last_name_edit_text_view);
    		sendkeys(last_name_edit_text_view,secoundName);
    		return this;	
    	}
        
        public SettingPage positionTextField(String position) {
        	clear(position_edit_text);
    		sendkeys(position_edit_text,position);
    		return this;	
    	}
        
        public SettingPage companyEditText(String company) {
        	clear(company_edit_text);
    		sendkeys(company_edit_text,company);
    		return this;	
    	}
        
        
        public SettingPage companyAddressEditText(String companyAddress) {
        	clear(company_address_edit_text);
    		sendkeys(company_address_edit_text,companyAddress);
    		return this;	
    	}
		

		
		
    	public SettingPage profileSetting(String firstname,String secoundName,String position,String company,String companyAddress) {
    		firstName(firstname);
    		secoundName(secoundName);
    		positionTextField(position);
    		companyEditText(company);
    		companyAddressEditText(companyAddress);
    		return this;
    			
    	}	
		
    	public SettingPage verifySaveButton() {
    	    click(save_bt,"save button click");
    		return new SettingPage();
    }
		
		

}
