package com.qa.pages;

import com.qa.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class VerifyOTPPage extends BaseTest {
	
	
		@AndroidFindBy(id = "com.earningvideo:id/toolbar_title") private MobileElement toolbar_title;
		@AndroidFindBy(id = "com.earningvideo:id/you_have_recevived_text_view") private MobileElement you_have_recevived_text_view;

		@AndroidFindBy(id = "com.earningvideo:id/first_otp_digit_edit_text") private MobileElement first_otp_digit_edit_text;

		@AndroidFindBy(id = "com.earningvideo:id/second_otp_digit_edit_text") private MobileElement second_otp_digit_edit_text;

		@AndroidFindBy(id = "com.earningvideo:id/third_otp_digit_edit_text") private MobileElement third_otp_digit_edit_text;

		@AndroidFindBy(id = "com.earningvideo:id/fourth_otp_digit_edit_text") private MobileElement fourth_otp_digit_edit_text;

		@AndroidFindBy(id = "com.earningvideo:id/resend_otp_text_view") private MobileElement resend_code_text_view;

		@AndroidFindBy(id = "com.earningvideo:id/verify_account_text_view") private MobileElement verify_account_text_view;
		

		//	
		public String otpScreenToolBar() {
			return getAttribute(toolbar_title,"text");
		}
		
//You have received an email containing Verification Code. Please enter here.
        public String otpScreenDescription() {
			return getAttribute(you_have_recevived_text_view,"text");
		}
		
		
        public VerifyOTPPage firstOtp(String firstOtp) {
        	clear(first_otp_digit_edit_text);
    		sendkeys(first_otp_digit_edit_text,firstOtp);
    		return this;	
    	}
		
        public VerifyOTPPage secoundOtp(String secoundOtp) {
        	clear(second_otp_digit_edit_text);
    		sendkeys(second_otp_digit_edit_text,secoundOtp);
    		return this;	
    	}
        
        public VerifyOTPPage thirdOtp(String thirdOtp) {
        	clear(third_otp_digit_edit_text);
    		sendkeys(third_otp_digit_edit_text,thirdOtp);
    		return this;	
    	}
        
        public VerifyOTPPage fourthOtp(String fourthOtp) {
        	clear(fourth_otp_digit_edit_text);
    		sendkeys(fourth_otp_digit_edit_text,fourthOtp);
    		return this;	
    	}
        //Resend Code
        public String resendCodeButton() {
			return getAttribute(resend_code_text_view,"text");
		}
        
        public VerifyOTPPage resendCodeButtonClicked() {
        	clear(resend_code_text_view);
        	return this;
		}
		
    	public DashboardPage verifyAccountButton() {
    	    click(verify_account_text_view);
    		return new DashboardPage();
    }
		
		
		
		
		
		
		

}
