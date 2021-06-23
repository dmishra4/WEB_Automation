package com.sama.ach.cucumber.dashboard.stepdefs;

import java.util.List;

import com.sama.ach.cucumber.dashboard.utils.DashboardLib;
import com.sama.ach.cucumber.poc.utils.CommonFunctions;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashboardStepDefinitions {
	
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

	@Then("Navigate to below mentioned menu in order to reach {string} page")
	public void navigate_to_below_mentioned_menu_in_order_to_reach_page(String pageName, List<String> navlist)
			throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		for (int i = 0; i < navlist.size(); i++) {
			DashboardLib.menuNavigation(pageName, navlist.get(i), i);
		}
		Thread.sleep(2000);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
	}
	
	@Then("The {string} section under {string} page contains the following GUI items:")
	public void the_section_under_page_contains_the_following_GUI_items(String section, String page,
			List<List<String>> listoflists) throws InterruptedException {
		for (List<String> listStr : listoflists) {
			if (section.equalsIgnoreCase("Payments Position")) {
				String labelname = listStr.get(1);
				String count = listStr.get(2);
				String amount = listStr.get(3);
				DashboardLib.validateGUIItems(section, labelname, count, amount);
			} else if (section.equalsIgnoreCase("Broadcast Message")) {
				String labelname = listStr.get(1);
				String details = listStr.get(2);
				String timestamp = listStr.get(3);
				DashboardLib.viewparticipantSNMs(section, labelname, details, timestamp);
			}
			else if (section.equalsIgnoreCase("Notification Message")) {
				String labelname = listStr.get(1);
				String details = listStr.get(2);
				String timestamp = listStr.get(3);
				DashboardLib.viewparticipantSNMs(section, labelname, details, timestamp);
			}
			else {
				String labelname = listStr.get(1);
				String value = listStr.get(2);
				DashboardLib.validateGUIItems(section, labelname, value);
			}
		}
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");

	}
	
	@Then("View the list of unavailable banks in Banks unavailable section under dashboard")
	public void verify_the_list_of_unavailable_banks_in_Banks_unavailable_section_under_dashboard() {
	    // Write code here that turns the phrase above into concrete actions
	  
		DashboardLib.validateUnavailablebank();
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		scenario.embed(CommonFunctions.snapshot, "image/png");
	    
	}
	@Then("Close the browser")
	public void close_the_browser() {
		// Write code here that turns the phrase above into concrete actions
		CommonFunctions.teardown();

	}


}
