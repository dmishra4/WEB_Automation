package com.sama.ach.cucumber.debitcapmgt.stepdefs;

import java.util.List;

import com.sama.ach.cucumber.debitcapmgt.utils.DebitCapMgtLib;
import com.sama.ach.cucumber.poc.utils.CommonFunctions;
import com.sama.ach.cucumber.poc.utils.SamaAchLib;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DebitCapMgtStepDefinitions {
	
	public static Scenario scenario;
	public static String browser;
	public static String thresholdradiobutton=null;

	@Before
	public void beforeScenario(Scenario scenario) {
		this.scenario = scenario;
		/*
		 * try { recorder = new
		 * ATUTestRecorder("Reports","TestScriptExecutionrecodring",true);
		 * recorder.start(); } catch (ATUTestRecorderException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
	}

	@Given("Open browser {string}")
	public void open_browser(String browserName) {
		// Write code here that turns the phrase above into concrete actions
		// browser = browserName;
		// Below function will open the browser which will be mentioned in Feature File
		// CommonFunctions.openBrowser(browserName);
		browser = browserName;
		CommonFunctions.openBrowser(browserName);
	}

	@When("Login to {string} Portal under {string} environment with username as {string} and password as {string}")
	public void login_to_Portal_under_environment_with_username_as_and_password_as(String portal, String environment,
			String username, String password) throws Exception {
		// Write code here that turns the phrase above into concrete actions

		scenario.write("Open Browser");
		CommonFunctions.openSAMAPortalURL(scenario,"dev",portal);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
		CommonFunctions.portalLogin(scenario,portal,"dev",username, password);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");

	}
	
	@When("Select {string} from Participant drop down list")
	public void select_from_Participant_drop_down_list(String participant) {
	    // Write code here that turns the phrase above into concrete actions
		DebitCapMgtLib.selectParticipant(participant);
	}

	@Then("Navigate to below mentioned menu in order to reach {string} page")
	public void navigate_to_below_mentioned_menu_in_order_to_reach_page(String pageName, List<String> navlist)
			throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		for (int i = 0; i < navlist.size(); i++) {
			DebitCapMgtLib.menuNavigation(pageName, navlist.get(i), i);
		}
		Thread.sleep(2000);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
	}

	@Then("Click the {string} button on {string} page")
	public void click_the_button_on_page(String buttonName, String pageName) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		DebitCapMgtLib.clickButton(buttonName, pageName);
		System.out.println("Clicked " + buttonName + " button successfully");
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");

	}
	
	@Then("Click the {string} radio button on {string} page")
	public void click_the_radio_button_on_page(String radiobuttonName, String pageName) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		thresholdradiobutton=radiobuttonName;
		DebitCapMgtLib.clickRadioButton(radiobuttonName, pageName);
		System.out.println("Clicked " + radiobuttonName + " radio button successfully");
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
	}

	@Then("Enter below values in {string} page")
	public void enter_below_values_in_page(String pageName, List<List<String>> listOflists)
			throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		for (List<String> listString : listOflists) {
			String field = listString.get(0);
			// System.out.println("The value of field is :: "+field);
			String value = listString.get(1);
			// System.out.println("The value of value is :: "+value);
			DebitCapMgtLib.enterValues(pageName, field, value);

		}
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");

	}

	@When("Click the {string} button on {string} pop up screen")
	public void click_the_button_on_pop_up_screen(String buttonName, String popupScreen) {
		// Write code here that turns the phrase above into concrete actions
		DebitCapMgtLib.confirmationPopup(buttonName, popupScreen);
		System.out.println("Clicked " + buttonName + " button displayed at pop up scrren successfully");
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");

	}


	@Then("Verify the below mentioned confirmation message")
	public void verify_the_below_mentioned_confirmation_message(String confirmationMsg) {
		// Write code here that turns the phrase above into concrete actions
		DebitCapMgtLib.validateConfirmationMsg(confirmationMsg);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
	}

	@Then("Enter {string} as {string} then click on {string} button")
	public void enter_as_then_click_on_button(String label_name, String label_value, String buttonName) {
		// Write code here that turns the phrase above into concrete actions
		DebitCapMgtLib.enterSingleValue(label_name, label_value, buttonName);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");

	}

	@Then("Verify the below mentioned confirmation message on {string} pop up screen")
	public void verify_the_below_mentioned_confirmation_message_on_pop_up_screen(String popupScreenName,
			String confirmationMsg) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		SamaAchLib.validateConfirmationMsgPopUp(popupScreenName, confirmationMsg);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");

	}

	@Then("Below error message will be displayed for {string}")
	public void below_error_message_will_be_displayed_for(String lable, String errorMsg) {
		// Write code here that turns the phrase above into concrete actions
		DebitCapMgtLib.validateErrorMsg(lable, errorMsg);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
	}
	
	@Then("The {string} page contains the following GUI items:")
	public void the_page_contains_the_following_GUI_items(String string, List<List<String>> listoflists) {

		for (List<String> listStr : listoflists)
		{
			    
				String item = listStr.get(0);
				String name = listStr.get(1);
				String value = listStr.get(2);
				DebitCapMgtLib.validateGUIItems(item,name,value);			    
		}
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
	    
	}
	
	@Then("Below {string} message will be displayed for {string}")
	public void below_message_will_be_displayed_for(String msgtype, String pagename, String expmsg) {
	    // Write code here that turns the phrase above into concrete actions
		DebitCapMgtLib.validateDisplayedMsg(msgtype,pagename,expmsg);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
	}

	@Then("Close the browser")
	public void close_the_browser() {
		// Write code here that turns the phrase above into concrete actions
		CommonFunctions.teardown();

	}

}
