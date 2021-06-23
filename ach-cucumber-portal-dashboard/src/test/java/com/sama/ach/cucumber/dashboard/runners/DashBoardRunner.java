package com.sama.ach.cucumber.dashboard.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.sama.ach.cucumber.poc.utils.CommonFunctions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/com/sama/ach/cucumber/features", glue =
"com.sama.ach.cucumber.dashboard.stepdefs", dryRun =false,plugin = {"pretty", "html:Reports/Cucumber-StandardReport",
	"json:target/Cucumber-Report/cucumber.json"},
tags = {
	//	"@DebitCap_Valid"
	//	"@Dashboard_PaymentPositions"
	//	"@DebitCap or @CreateDispute"
	// "@Dashboard_Disputes"
	//	"@Dashboard_UnavailableBanks"
		"@Dashboard_DebitCapThreshold"
	//	"@Dashboard_NetPosition or @Dashboard_PendingRequest"
	//"@Dashboard_PendingRequest"
	//"@ParticipantSNMs_BroadCastMsg"
		
	
         })
public class DashBoardRunner {
	
	@BeforeClass
	public static void deleteOldScreenshots() {
		CommonFunctions.cleanup_screenshots();
	}

	@AfterClass
	public static void report() throws InterruptedException {
		CommonFunctions.generateCustomReport();
	}

}
