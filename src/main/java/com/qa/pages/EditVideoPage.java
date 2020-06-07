package com.qa.pages;

import com.qa.BaseTest;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EditVideoPage extends BaseTest{
	TestUtils utils = new TestUtils();
	@AndroidFindBy(id = "com.earningvideo:id/popup_menu_image_view") 
	private MobileElement popup_menu_image_view;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout") 
	private MobileElement edit_button;
	@AndroidFindBy(id = "com.earningvideo:id/subscribe_text_view") 
	private MobileElement subscribe_text_view;
	@AndroidFindBy(id = "com.earningvideo:id/et_card_number") 
	private MobileElement et_card_number;
	@AndroidFindBy(id = "com.earningvideo:id/et_expiry_date") 
	private MobileElement et_expiry_date;
	@AndroidFindBy(id = "com.earningvideo:id/editText") 
	private MobileElement editText;
	@AndroidFindBy(id = "com.earningvideo:id/buy_text_view") 
	private MobileElement buy_text_view;
	@AndroidFindBy(id = "com.earningvideo:id/et_cvc") 
	private MobileElement et_cvc;
	@AndroidFindBy(id = "com.earningvideo:id/edit_pro_tip_text_view") 
	private MobileElement edit_pro_tip_text_view;
	@AndroidFindBy(accessibility = "Navigate up") 
	private MobileElement navigatevideo;
	@AndroidFindBy(id ="com.earningvideo:id/play_button") 
	private MobileElement videostart;
	@AndroidFindBy(id ="com.earningvideo:id/ok_button_text_view") 
	private MobileElement ok_button_text_view;
	@AndroidFindBy(id ="com.earningvideo:id/save_button_text_view") 
	private MobileElement save_button_text_view;
	@AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout") 
	private MobileElement delete_added_video;
	@AndroidFindBy(id = "com.earningvideo:id/captureVideo") 
	private MobileElement startVideo;
	@AndroidFindBy(id = "com.earningvideo:id/stopVideo") 
	private MobileElement stopVideo;
	@AndroidFindBy(id = "com.earningvideo:id/add_button_image_view") 
	private MobileElement click_on_add_button;
	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"EARNINGS\"])[9]") 
	private MobileElement click_edit_3top;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView") 
	private MobileElement click_rename_button;
	@AndroidFindBy(id = "com.earningvideo:id/rename_file_edit_text") 
	private MobileElement click_rename_text_filed;
	@AndroidFindBy(id = "com.earningvideo:id/save_text_view")
     private MobileElement click_save_rename;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout")
    private MobileElement click_add_company_infor;
	@AndroidFindBy(id = "com.earningvideo:id/company_name_edit_text")
    private MobileElement click_company_name;
	@AndroidFindBy(id = "com.earningvideo:id/interviewee_edit_text")
    private MobileElement click_Interviewee;
	@AndroidFindBy(id = "com.earningvideo:id/position_edit_text")
    private MobileElement click_Position;
	@AndroidFindBy(id = "com.earningvideo:id/first_stock_symbol_edit_text")
    private MobileElement click_First_Stock_Symbol_1;
	@AndroidFindBy(id = "com.earningvideo:id/second_stock_symbol_edit_text")
    private MobileElement click_First_Stock_Symbol_2;
	@AndroidFindBy(id = "com.earningvideo:id/first_stock_exchange_edit_text")
    private MobileElement click_first_stock_exchange_1;
	@AndroidFindBy(id = "com.earningvideo:id/second_stock_exchange_edit_text")
    private MobileElement click_second_stock_exchange_edit_text_2;
	@AndroidFindBy(id = "com.earningvideo:id/save_company_text_view")
    private MobileElement click_Save_Button;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[5]/android.widget.LinearLayout")
    private MobileElement click_Share_for_approval;
	@AndroidFindBy(id = "com.earningvideo:id/reviewer_name_edit_text")
    private MobileElement reviewer_name_edit_text;
	@AndroidFindBy(id = "com.earningvideo:id/reviewer_email_edit_text")
    private MobileElement reviewer_email_edit_text;
	@AndroidFindBy(id = "com.earningvideo:id/add_button_image_view")
    private MobileElement add_button_image_view;
	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"EARNINGS\"])[4]")
    private MobileElement click_on_cross_icon;
	@AndroidFindBy(id = "com.earningvideo:id/invite_reviewer_text_view")
    private MobileElement invite_reviewer_text_view;
	@AndroidFindBy(id = "com.earningvideo:id/no_video_text_view")
    private MobileElement no_video_text_view;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout[1]")
    private MobileElement click_home_button;

	
	
	
	// com.earningvideo:id/popup_menu_image_view

	public EditVideoPage click_home_button() {
		utils.log().info("click_home_button");
		click(click_home_button);
		return this;	
	}
	
	public EditVideoPage clickShareForApproval() {
		utils.log().info("click_Share_for_approval");
		click(click_Share_for_approval);
		return this;	
	}
	public EditVideoPage addReviewerDetails(String name, String email) {
		sendkeys(reviewer_name_edit_text, name, "reviewer_name_edit_text >>>" + name);
		sendkeys(reviewer_email_edit_text, email, "reviewer_email_edit_text >>>" + email);
		return this;	
	}
	public EditVideoPage clickAddNewUser() {
		utils.log().info("click_on_cross_icon");
		click(click_on_cross_icon);
		return this;	
	}
	public EditVideoPage clickInviteReviewButton() {
		utils.log().info("invite_reviewer_text_view");
		click(invite_reviewer_text_view);
		return this;	
	}
	public EditVideoPage clickCrossIcon() {
		utils.log().info("add_button_image_view");
		click(add_button_image_view);
		return this;	
	}
	
	public boolean getEditText() {
		utils.log().info("getEditText enabled----->" + edit_button.isDisplayed());
		return edit_button.isDisplayed();
	}
	
	
	public boolean get_no_video_text_view() {
		utils.log().info("ALL VIDEO DELETED----->" + no_video_text_view.isDisplayed());
		return no_video_text_view.isDisplayed();
	}
	
	public String get_NO_video_text_view() {
		return getAttribute(no_video_text_view,"text");
	}
	
	public EditVideoPage edit() {
		utils.log().info("EDIT Button Clicked");
		click(popup_menu_image_view);
		return this;	
	}
	
	public EditVideoPage editButton() {
		utils.log().info("EDIT Button Clicked");
		click(edit_button);
		return this;	
	}
	
	public EditVideoPage subscribeButton() {
		utils.log().info("Subscribe button clicked");
		click(subscribe_text_view);
		return this;	
	}
	
	public boolean getSubscribeButtonEnabled() {
		utils.log().info("getSubscribeButtonEnabled----->" + subscribe_text_view.isDisplayed());
		return subscribe_text_view.isDisplayed();
	}
	
	public EditVideoPage addCardDetails(String cardnumber, String month , String cardname,String cvv) {
		sendkeys(et_card_number, cardnumber, "enter card number >>>" + cardnumber);
		sendkeys(et_expiry_date, month, "enter month and year >>>" + month);
		sendkeys(editText, cardname, "enter month and year >>>" + cardname);
		sendkeys(et_cvc, cvv, "enter cvv >>>" + cvv);	
		return this;
		
	}
	
	public EditVideoPage cardSaveButton() {
		utils.log().info("buy_text_view");
		click(buy_text_view);
		return this;	
	}
	
	public EditVideoPage clickOnProTip() {
		utils.log().info("edit_pro_tip_text_view");
		click(edit_pro_tip_text_view);
		return this;	
	}
	
	public EditVideoPage clickBackFromProTip() {
		utils.log().info("navigatevideo");
		click(navigatevideo);
		return this;	
	}
	
	
	public EditVideoPage clickPlay() {
		utils.log().info("videostart");
		click(videostart);
		return this;	
	}
	
	public EditVideoPage clickOkButton() {
		utils.log().info("ok_button_text_view");
		click(ok_button_text_view);
		return this;	
	}
	public EditVideoPage clickSaveButton() {
		utils.log().info("save_button_text_view");
		click(save_button_text_view);
		return this;	
	}
	public EditVideoPage clickDeleteButton() {
		utils.log().info("save_button_text_view");
		click(delete_added_video);
		return this;	
	}
	
	public EditVideoPage clickAddButton() {
		utils.log().info("click_on_add_button");
		click(click_on_add_button);
		return this;	
	}
	
	public EditVideoPage clickStartVideo() {
		utils.log().info("click_on_add_button");
		click(startVideo);
		return this;	
	}
	
	public EditVideoPage clickStopVideo() {
		utils.log().info("stopVideo");
		click(stopVideo);
		return this;	
	}
	
	public EditVideoPage click3DotEdit() {
		utils.log().info("click 3 dot");
		click(click_edit_3top);
		return this;	
	}
	
	public EditVideoPage clickRenameButton() {
		utils.log().info("click 3 dot");
		click(click_rename_button);
		return this;	
	}
	
	public EditVideoPage clickRenameTextFile(String rename) {
		utils.log().info("edit name field");
		clear(click_rename_text_filed);
		sendkeys(click_rename_text_filed, rename, "enter card number >>>" + rename);
		return this;	
	}
	
	public EditVideoPage clickSaveRename() {
		utils.log().info("click 3 dot");
		click(click_save_rename);
		return this;	
	}
	public EditVideoPage clickAddCompanyInformation() {
		utils.log().info("click 3 dot");
		click(click_add_company_infor);
		return this;	
	}
	
	public EditVideoPage addCompanyDetails(String companyname, String interviewee, String position,String stock1, String stock2, String exchange1, String exchnage2) {
		sendkeys(click_company_name, companyname, "ADD COMPANY NAME >>>" + companyname);
		sendkeys(click_Interviewee, interviewee, "ADD INTERVIEWEE NAME >>>" + interviewee);
		sendkeys(click_Position, position, "ADD POSITION >>>" + position);
		sendkeys(click_First_Stock_Symbol_1, stock1, "STOCK 1 >>>" + stock1);	
		sendkeys(click_First_Stock_Symbol_2, stock2, "STOCK 2 >>>" + stock2);
		sendkeys(click_first_stock_exchange_1, exchange1, "EXCHANGE 1 >>>" + exchange1);
		sendkeys(click_second_stock_exchange_edit_text_2, exchnage2, "EXCHANGE 2 >>>" + exchnage2);
		return this;
		
	}
	
	public EditVideoPage clickAddCompanySave() {
		utils.log().info("click Add Company Save");
		click(click_Save_Button);
		return this;	
	}
	
}
