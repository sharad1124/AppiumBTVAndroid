package com.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.qa.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ForgotPasswordPage extends BaseTest{
	
	
	@AndroidFindBy(id = "com.earningvideo:id/toolbar_title") private MobileElement toolbar_title;
	@AndroidFindBy(id = "com.earningvideo:id/forgot_text_view") private MobileElement forgot_text_view;
	@AndroidFindBy(id = "com.earningvideo:id/forget_password_text_view") private MobileElement forget_password_text_view;

	@AndroidFindBy(id = "com.earningvideo:id/current_password_edit_text") private MobileElement current_password_edit_text;
	@AndroidFindBy(id = "com.earningvideo:id/send_text_view") private MobileElement send_text_view;

	@AndroidFindBy(id = "com.earningvideo:id/resend_text_view") private MobileElement resend_text_view;
	@AndroidFindBy(id = "com.earningvideo:id/back_arrow_button") private MobileElement back_arrow_button;


	
	public String getForgotScreenToolBar() {
		return getAttribute(toolbar_title,"text");
	}
	
	public String getForgotScreenHeading() {
		return getAttribute(forget_password_text_view,"text");
	}
	
	public String getButtonText() {
		return getAttribute(forgot_text_view,"text");
	}
	
	public boolean forgotButtonDisplayed() {
	    
		return forgot_text_view.isDisplayed();
}
	
	public ForgotPasswordPage forgotButtonLink() {
	    click(forgot_text_view);
		return this;
}
		
	public ForgotPasswordPage currentPassword(String currentEmailId) {
		clear(current_password_edit_text);
		sendkeys(current_password_edit_text,currentEmailId);
		return this;	
	}
	
	public String getReSendButtonText() {
		return getAttribute(resend_text_view,"text");
	}
	
	public boolean resendButtonDisplayed() {
	    
		return resend_text_view.isDisplayed();
}
	public ForgotPasswordPage emailResendButton() {
	    click(resend_text_view);
		return this;
}
	public String getSendButtonText() {
		return getAttribute(send_text_view,"text");
	}
	
	public boolean sendButtonDisplayed() {
	    
		return send_text_view.isDisplayed();
}
	
	public ForgotPasswordPage sendButton() {
	    click(send_text_view);
		return this;

}
	
	public LoginPage backToLogin() {
	    click(back_arrow_button);
		return new LoginPage();
		
	}
	

}
