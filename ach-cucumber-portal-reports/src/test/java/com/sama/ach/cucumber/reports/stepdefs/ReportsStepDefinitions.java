package com.sama.ach.cucumber.reports.stepdefs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;


import com.sama.ach.cucumber.poc.utils.CommonFunctions;
import com.sama.ach.cucumber.poc.utils.SamaAchLib;
import com.sama.ach.cucumber.reports.page.ref.ReportsPageRef;
import com.sama.ach.cucumber.reports.utils.ReportsLib;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReportsStepDefinitions implements ReportsPageRef{
	
	
	public static Scenario scenario;
	public static String browser;
	public static ArrayList<String> reportlisttype = new ArrayList<String>();


	@Before
	public void beforeScenario(Scenario scenario) {
		ReportsStepDefinitions.scenario = scenario;
		
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
	@Then("The {string} dropdown contains the following types of report:")
	public void the_dropdown_contains_the_following_types_of_report(String reportname, List<String> reportlist) {
	    // Write code here that turns the phrase above into concrete actions
		
		
		for (int i = 0; i < reportlist.size(); i++) {
			String report = reportlist.get(i);
			reportlisttype.add(report);
		}
		Collections.sort(reportlisttype);
		ReportsLib.reportlistvalidation(reportname);
		
		
	}
	@Then("Select {string} from {string} dropdown list in {string} page")
	public void select_from_dropdown_list_in_page(String value, String label, String page) {
	    // Write code here that turns the phrase above into concrete actions
		ReportsLib.dropdownSelection(value,label,page);
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
				ReportsLib.validateGUIItems(pagename,item,name,value);			    
		}
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
			ReportsLib.enterValues(pageName, field, value);

		}
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");

	}
	
	@Then("Click the {string} button on {string} page")
	public void click_the_button_on_page(String buttonName, String pageName) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		ReportsLib.clickButton(buttonName, pageName);
		System.out.println("Clicked " + buttonName + " button successfully");
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");

	}
	
	@Then("Verify the below mentioned confirmation message is displayed on {string} page")
	public void verify_the_below_mentioned_confirmation_message_is_displayed_on_page(String page, String success_message) {
	    // Write code here that turns the phrase above into concrete actions
	    
		ReportsLib.validateSuccessMessage(page,success_message);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
	}
	
	@Then("The {string} table contains the following columns:")
	public void the_table_contains_the_following_columns(String reportname, List<List<String>> listoflists) {

		// Write code here that turns the phrase above into concrete actions

		ReportsLib.verifyResultTableAvailability(reportname);
		int pagecount = ReportsLib.paginationInfo(reportname);
		System.out.println("Total Page count is :: " + pagecount);
		if (pagecount <= 0) {
			Assert.fail("No result data is displayed for " + reportname + "");
		} else {

					List<List<String>> stringlist = listoflists;
					for (List<String> listStr : stringlist) {
						String column = listStr.get(0);
						String value = listStr.get(1);
						ReportsLib.validateResultsTableItems(reportname, column, value);
					}
				}
				
		
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
	}
	
	@Then("Columns name in the downloaded CSV file is same as {string} result screen")
	public void columns_name_in_the_downloaded_CSV_file_is_same_as_enquiry_result_screen(String string) {
	    // Write code here that turns the phrase above into concrete actions

	}
	
	@Then("Downloaded CSV file should display below mentioned columns for {string} under {string}")
	public void downloaded_CSV_file_should_display_below_mentioned_columns_for_under(String reportname, String parentreport, List<String> expCSVcolumnlist) throws IOException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions

		System.out.println("Column list in feature file is :: "+expCSVcolumnlist);
		
		ReportsLib.readCSVfile(reportname,parentreport,expCSVcolumnlist);
		
		
		
	}

	
	@Then("Close the browser")
	public void close_the_browser() {
		// Write code here that turns the phrase above into concrete actions
		CommonFunctions.teardown();

	}

// End Here
}
