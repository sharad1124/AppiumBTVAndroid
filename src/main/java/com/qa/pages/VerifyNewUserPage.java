package com.qa.pages;

import com.qa.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class VerifyNewUserPage extends BaseTest {
	
	
		@AndroidFindBy(id = "com.earningvideo:id/account_verfied_text_view") private MobileElement account_verfied_text_view;

		
		//Account Verified
		public String accountVerifiedScreen() {
			return getAttribute(account_verfied_text_view,"text");
		}
}
