package com.qa.pages;

import com.qa.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignUpPage extends BaseTest{
	
	@AndroidFindBy(id = "com.earningvideo:id/register_text_view") private MobileElement register_text_view;
	
	@AndroidFindBy(id = "com.earningvideo:id/register_textView") private MobileElement register_textView;

	@AndroidFindBy(id = "com.earningvideo:id/login_text_view") private MobileElement login_text_view;


	@AndroidFindBy(id = "com.earningvideo:id/first_name_edit_text") private MobileElement first_name_edit_text;

	@AndroidFindBy(id = "com.earningvideo:id/last_name_edit_text") private MobileElement last_name_edit_text;

	@AndroidFindBy(id = "com.earningvideo:id/email_edit_text") private MobileElement email_edit_text;

	@AndroidFindBy(id = "com.earningvideo:id/choose_password_edit_text") private MobileElement choose_password_edit_text;
	
	@AndroidFindBy(id = "com.earningvideo:id/confirm_password_edit_text") private MobileElement confirm_password_edit_text;
	
	//Password must contain at least 8 characters

	@AndroidFindBy(id = "com.earningvideo:id/password_validation_text_view") private MobileElement password_validation_text_view;

	@AndroidFindBy(id = "com.earningvideo:id/register_button") private MobileElement register_button;



	//

	
	public String getSignUptext() {
		return getAttribute(register_text_view,"text");
	}
	
	public SignUpPage clickOnSignUpButton() {
	    click(register_text_view);
		return this;
}
	public String getSignScreenDes() {
		return getAttribute(register_textView,"text");
	}
	
	public String getLoginButtonText() {
		return getAttribute(login_text_view,"text");
	}
	
	public SignUpPage backLoginButton() {
	    click(login_text_view);
		return this;
}
	
	public SignUpPage firstNameTextField(String firstName) {
		clear(first_name_edit_text);
		sendkeys(first_name_edit_text,firstName);
		return this;	
	}
	
	public SignUpPage lastNameTextField(String lastName) {
		clear(last_name_edit_text);
		sendkeys(last_name_edit_text,lastName);
		return this;	
	}
	
	
	public SignUpPage emailId(String emailId) {
		clear(email_edit_text);
		sendkeys(email_edit_text,emailId);
		return this;	
	}
	
	public SignUpPage choosePassword(String choosePassword) {
		clear(choose_password_edit_text);
		sendkeys(choose_password_edit_text,choosePassword);
		return this;	
	}
	
	public SignUpPage confirmPassword(String confirmPassword) {
		clear(confirm_password_edit_text);
		sendkeys(confirm_password_edit_text,confirmPassword);
		return this;	
	}
	public VerifyOTPPage registerButtonClick() {
	    click(register_button);
		return new VerifyOTPPage();
}
}
