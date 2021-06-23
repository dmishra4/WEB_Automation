package com.sama.ach.cucumber.dispute.stepdefs;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sama.ach.cucumber.dispute.page.ref.DisputePageRef;
import com.sama.ach.cucumber.dispute.utils.DisputeLib;
import com.sama.ach.cucumber.poc.utils.CommonFunctions;
import com.sama.ach.cucumber.poc.utils.SamaAchLib;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DisputeStepDefinitions implements DisputePageRef{
	
	public static Scenario scenario;
	public static String browser;

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
		DisputeLib.selectParticipant(participant);
	}
	
	@Then("Navigate to below mentioned menu in order to reach {string} page")
	public void navigate_to_below_mentioned_menu_in_order_to_reach_page(String pageName, List<String> navlist)
			throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		for (int i = 0; i < navlist.size(); i++) {
			SamaAchLib.menuNavigation(pageName, navlist.get(i), i);
		}
		Thread.sleep(2000);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
	}

	@Then("Click the {string} button on {string} page")
	public void click_the_button_on_page(String buttonName, String pageName) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		DisputeLib.clickButton(buttonName, pageName);
		System.out.println("Clicked " + buttonName + " button successfully");
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
			DisputeLib.enterValues(pageName, field, value);

		}
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");

	}

	/*
	 * @When("Click the {string} button on {string} pop up screen") public void
	 * click_the_button_on_pop_up_screen(String buttonName, String popupScreen) { //
	 * Write code here that turns the phrase above into concrete actions
	 * DisputeLib.confirmationPopup(buttonName, popupScreen);
	 * System.out.println("Clicked " + buttonName +
	 * " button displayed at pop up scrren successfully"); CommonFunctions.snapshot
	 * = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
	 * scenario.embed(CommonFunctions.snapshot, "image/png");
	 * 
	 * }
	 */

	@Then("Verify the below mentioned confirmation message")
	public void verify_the_below_mentioned_confirmation_message(String confirmationMsg) {
		// Write code here that turns the phrase above into concrete actions
		DisputeLib.validateConfirmationMsg(confirmationMsg);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
	}

	@Then("Enter {string} as {string} then click on {string} button")
	public void enter_as_then_click_on_button(String label_name, String label_value, String buttonName) {
		// Write code here that turns the phrase above into concrete actions
		DisputeLib.enterSingleValue(label_name, label_value, buttonName);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");

	}

	@Then("Verify the below mentioned confirmation message on {string} pop up screen")
	public void verify_the_below_mentioned_confirmation_message_on_pop_up_screen(String popupScreenName,
			String confirmationMsg) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		DisputeLib.validateConfirmationMsgPopUp(popupScreenName, confirmationMsg);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");

	}

	@Then("Below error message will be displayed for {string}")
	public void below_error_message_will_be_displayed_for(String lable, String errorMsg) {
		// Write code here that turns the phrase above into concrete actions
		DisputeLib.validateErrorMsg(lable, errorMsg);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
	}
	
	@Then("The {string} page contains the following GUI items:")
	public void the_page_contains_the_following_GUI_items(String pagename, List<List<String>> listoflists) {

		for (List<String> listStr : listoflists)
		{
			    
				String item = listStr.get(0);
				String name = listStr.get(1);
				String value = listStr.get(2);
				DisputeLib.validateGUIItems(pagename,item,name,value);			    
		}
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
	    
	}
	
	@Then("Below {string} message will be displayed for {string}")
	public void below_message_will_be_displayed_for(String msgtype, String pagename, String expmsg) {
	    // Write code here that turns the phrase above into concrete actions
		DisputeLib.validateDisplayedMsg(msgtype,pagename,expmsg);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
	}
	@Then("The {string} result contains the following columns:")
	public void the_result_table_contains_the_following_columns(String pagename, List<List<String>> listoflists) {
		// Write code here that turns the phrase above into concrete actions

		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 15);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strtblResults, pagename))));
		} catch (TimeoutException e) {
			CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
			scenario.embed(CommonFunctions.snapshot, "image/png");
			Assert.fail("Result table is not getting displayed for " + pagename + "");
		}
		int pagecount = DisputeLib.paginationInfo(pagename);
		System.out.println("Total Page count is :: " + pagecount);
		if (pagecount <= 0) {
			CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
			scenario.embed(CommonFunctions.snapshot, "image/png");
			Assert.fail("No records found for dispute " + pagename + "");
		} else {
			for (int page = 1; page <= pagecount; page++) {
				int rowdata = CommonFunctions.driver.findElements(By.xpath(String.format(strtblResults, pagename)))
						.size();
				System.out.println(pagename + " displays " + rowdata + " row in page "+page+"");
				for (int j = 1; j <= rowdata; j++) {
					List<List<String>> stringlist = listoflists;
					for (List<String> listStr : stringlist) {
						String column = listStr.get(0);
						String value = listStr.get(1);
						DisputeLib.validateResultsTableItems(pagename, column, value, page,j);
					}
				}
				if(page<pagecount)
				{
					DisputeLib.paginationClick(pagename);
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					scenario.embed(CommonFunctions.snapshot, "image/png");
				}
			}
		}
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");

	}
	
	@Then("Select {string} radio button in {string} page")
	public void select_radio_button_in_page(String radiobuttonName, String pagename) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		DisputeLib.clickRadioButton(radiobuttonName,pagename);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
	}
	@Then("Select {string} from {string} dropdown list in {string} page")
	public void select_from_dropdown_list_in_page(String value, String label, String page) {
	    // Write code here that turns the phrase above into concrete actions
		DisputeLib.dropdownSelection(value,label,page);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
	}
	
	@Then("The value of {string} is displayed as {string} on the {string} page under {string} Portal")
	public void the_value_of_is_displayed_as_on_the_page_under_Portal(String label, String value, String page, String portal) {
	    // Write code here that turns the phrase above into concrete actions
		DisputeLib.verifyDisputeStatus(label,value,page,portal);
        CommonFunctions.snapshot=CommonFunctions.getSnapshot(CommonFunctions.driver,"screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
	}

	
	@Then("^The value of \"([^\"]*)\" is displayed as \"([^\"]*)\" under \"([^\"]*)\" page$"
	  ) public void the_value_of_is_displayed_as_under_page(String label, String
	  value, String page) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	  DisputeLib.verifyDisputeStatus(label,value,page,"External");
	  CommonFunctions.snapshot=CommonFunctions.getSnapshot(CommonFunctions.driver,
	  "screenshot"); scenario.embed(CommonFunctions.snapshot, "image/png");
	  
	  }
	 
	@When("Click the {string} button on {string} pop up screen in {string} page")
	public void click_the_button_on_pop_up_screen_in_page(String buttonName, String popupScreen, String page) {
	    // Write code here that turns the phrase above into concrete actions
		DisputeLib.confirmationPopup(buttonName, popupScreen,page);
		System.out.println("Clicked " + buttonName + " button displayed at pop up scrren successfully");
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
	}
	@Then("Close the browser")
	public void close_the_browser() {
		// Write code here that turns the phrase above into concrete actions
		CommonFunctions.teardown();

	}

}
