package com.sama.ach.cucumber.reports.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.sama.ach.cucumber.poc.utils.CommonFunctions;
import com.sama.ach.cucumber.reports.utils.ReportsLib;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/com/sama/ach/cucumber/features", glue =
"com.sama.ach.cucumber.reports.stepdefs", dryRun =false ,plugin = {"pretty", "html:Reports/Cucumber-StandardReport",
	"json:target/Cucumber-Report/cucumber.json"},
tags = {
	
		//"@Ext_ScheduledReports"
		//"@Ext_ScheduledReports_PaymentVolumeReport"
		//"@Ext_ScheduledReports_ParticipantPerformance"   // Done
		//"@Ext_ScheduledReports_RoutingFile"              // Done
		//"@Ext_ScheduledReports_PaymentVolumeReport"        // Done
		//"@Ext_ScheduledReports_RejectReport"  // Done
		//"@01_01_Ext_ScheduledReports_RejectReport"
		//"@01_02_Ext_ScheduledReports_PaymentVolumeReport"
		//"@01_03_Ext_ScheduledReports_RoutingFile"
		//"@01_04_Ext_ScheduledReports_ParticipantPerformance"
		//"@01_05_Ext_ScheduledReports_ParticipantSettlementReport"
		//"@02_01_Ext_RequestaReport_RejectReport"
		//"@02_02_Ext_RequestaReport_PaymentVolumeReport"
		//"@02_03_Ext_RequestaReport_RoutingFile"
		//"@02_04_Ext_RequestaReport_ParticipantPerformance"
		"@02_05_Ext_RequestaReport_ParticipantSettlementReport"
         })
public class ReportsRunner {
	
	@BeforeClass
	public static void deleteOldScreenshots() {
		CommonFunctions.cleanup_screenshots();
	}
	
	@BeforeClass
	public static void cleanup_downloads() {
		//CommonFunctions.cleanup_downloads("chrome");
		//CommonFunctions.cleanup_downloads("firefox");
		//CommonFunctions.cleanup_downloads("IE");
	}
	

	@AfterClass
	public static void report() throws InterruptedException {
		//CommonFunctions.generateCustomReport();
		ReportsLib.generateCustomReport();
	}
	

// End Here

}
