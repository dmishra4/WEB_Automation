package com.sama.ach.cucumber.enquiry.stepdefs;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import com.sama.ach.cucumber.enquiry.page.ref.EnquiryPageRef;
import com.sama.ach.cucumber.enquiry.utils.EnquiryLib;
import com.sama.ach.cucumber.poc.utils.CommonFunctions;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EnquiryStepDefinitions implements EnquiryPageRef{
	public static Scenario scenario;
	public static String browser;
	public static String radiobutton=""; 
		
	@Before
	public void beforeScenario(Scenario scenario) {
		//this.scenario = scenario;
		EnquiryStepDefinitions.scenario = scenario;

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
		CommonFunctions.portalLogin(scenario,portal,"dev", username, password);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");

	}
	@When("Select {string} from Participant drop down list")
	public void select_from_Participant_drop_down_list(String participant) {
	    // Write code here that turns the phrase above into concrete actions
		EnquiryLib.selectParticipant(participant);
	}
	@Then("Navigate to below mentioned menu in order to reach {string} page")
	public void navigate_to_below_mentioned_menu_in_order_to_reach_page(String pageName, List<String> navlist)
			throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		for (int i = 0; i < navlist.size(); i++) {
			EnquiryLib.menuNavigation(pageName, navlist.get(i), i);
		}
		Thread.sleep(2000);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
	}

	@Then("Click the {string} button on {string} page")
	public void click_the_button_on_page(String buttonName, String pageName) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		EnquiryLib.clickButton(buttonName, pageName);
		Thread.sleep(1000);
		System.out.println("Clicked " + buttonName + " button successfully");
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
				EnquiryLib.validateGUIItems(pagename,item,name,value);			    
		}
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
	    
	}
	

@Then("The {string} result table contains the following columns:")
	public void the_result_table_contains_the_following_columns(String pagename, List<List<String>> listoflists) {
		// Write code here that turns the phrase above into concrete actions
		EnquiryLib.verifyResultTableAvailability(pagename);
		int pagecount = EnquiryLib.paginationInfo(pagename);
		System.out.println("Total Page count is :: " + pagecount);
		if (pagecount <= 0) {
			Assert.fail("No result data is displayed for enquiry " + pagename + "");
		} else {
			for (int page = 1; page <= pagecount; page++) {
				int rowdata;
				if (pagename.equalsIgnoreCase("Value Transaction Enquiry")
						&& EnquiryStepDefinitions.radiobutton.equalsIgnoreCase("Today")) {
					rowdata = CommonFunctions.driver.findElements(tbl_TodayResults).size();
					System.out.println(pagename + " displays " + rowdata + " row in page " + page + "");
				} else if (pagename.equalsIgnoreCase("View Settlement Cycle Calendar")) {
					rowdata = CommonFunctions.driver.findElements(tbl_ViewSettlementCalendar).size();
					System.out.println(pagename + " displays " + rowdata + " row in page " + page + "");
				} else if (pagename.equalsIgnoreCase("Retrieve Settlement Summary")) {
					rowdata = CommonFunctions.driver.findElements(tbl_RetrieveSettlementSummary).size();
					System.out.println(pagename + " displays " + rowdata + " row in page " + page + "");
				} else if (pagename.equalsIgnoreCase("Retrieve Participant SNM")) {
					rowdata = CommonFunctions.driver.findElements(tbl_ParticipantSNM).size();
					System.out.println(pagename + " displays " + rowdata + " row in page " + page + "");
				} else {
					rowdata = CommonFunctions.driver.findElements(tbl_Results).size();
					System.out.println(pagename + " displays " + rowdata + " row in page " + page + "");
				}
				for (int j = 1; j <= rowdata; j++) {
					List<List<String>> stringlist = listoflists;
					for (List<String> listStr : stringlist) {
						String column = listStr.get(0);
						String value = listStr.get(1);
						EnquiryLib.validateResultsTableItems(pagename, column, value, page, j);
					}
				}
				if (page < pagecount) {					
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					scenario.embed(CommonFunctions.snapshot, "image/png");
					EnquiryLib.paginationClick(pagename);
				}
				
			}
		}
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
	}

@Then("Columns name in the downloaded CSV file is same as {string} enquiry result screen")
public void columns_name_in_the_downloaded_CSV_file_is_same_as_enquiry_result_screen(String enquiryname) throws IOException, InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	
	EnquiryLib.readCSVfile(enquiryname);
    
	
}

@Then("Enter below values in {string} page")
public void enter_below_values_in_page(String pageName, List<List<String>> listOflists)
		throws InterruptedException, ParseException {
	// Write code here that turns the phrase above into concrete actions
	for (List<String> listString : listOflists) {
		String field = listString.get(0);
		// System.out.println("The value of field is :: "+field);
		String value = listString.get(1);
		// System.out.println("The value of value is :: "+value);
		EnquiryLib.enterValues(pageName, field, value);

	}
	CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
	scenario.embed(CommonFunctions.snapshot, "image/png");

}

@Then("Select {string} radio button")
public void select_radio_button(String radiobuttonName) throws Exception {
    // Write code here that turns the phrase above into concrete actions
	EnquiryLib.clickRadioButton(radiobuttonName);
}
@Then("Select {string} from {string} dropdown list in {string} page")
public void select_from_dropdown_list_in_page(String value, String label, String page) {
    // Write code here that turns the phrase above into concrete actions
	EnquiryLib.dropdownSelection(value,label,page);
	CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
	scenario.embed(CommonFunctions.snapshot, "image/png");
}
@Then("Close the browser")
public void close_the_browser() {
    // Write code here that turns the phrase above into concrete actions
	CommonFunctions.teardown();
}


// End here
}
