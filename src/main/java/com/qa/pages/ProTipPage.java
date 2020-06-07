package com.qa.pages;

import com.qa.BaseTest;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProTipPage extends BaseTest{
	TestUtils utils = new TestUtils();
	@AndroidFindBy(id = "com.earningvideo:id/rotate_pro_tip_text_view") private MobileElement rotate_pro_tip_text_view;
	@AndroidFindBy(id = "com.earningvideo:id/back_arrow_button") private MobileElement back_arrow_button;
	@AndroidFindBy(id = "com.earningvideo:id/toolbar_title") private MobileElement toolbar_title;
	@AndroidFindBy(id = "com.earningvideo:id/lighting_text_view") private MobileElement lighting_text_view;
	@AndroidFindBy(id = "com.earningvideo:id/professional_text_view") private MobileElement professional_text_view;

	
	
	public boolean getProText() {
		utils.log().info("Pro Tip button is enabled----->" + rotate_pro_tip_text_view.isDisplayed());
		return rotate_pro_tip_text_view.isDisplayed();
	}
	
	public ProTipPage protip() {
		utils.log().info("Pro Tip Button Clicked");
		click(rotate_pro_tip_text_view);
		return this;	
	}
	
	public ProTipPage backButton() {
		utils.log().info("Pro Tip back button clicked");
		click(back_arrow_button);
		return this;	
	}
	
	public String getProTipText() {
		return getAttribute(rotate_pro_tip_text_view,"text");
	}
	
	public String getProTipheading() {
		return getAttribute(toolbar_title,"text");
	}
	
	public String getTextLighting() {
		return getAttribute(lighting_text_view,"text");
	}
	
	public String getTextProfessional() {
		return getAttribute(professional_text_view,"text");
	}
	
	
}
