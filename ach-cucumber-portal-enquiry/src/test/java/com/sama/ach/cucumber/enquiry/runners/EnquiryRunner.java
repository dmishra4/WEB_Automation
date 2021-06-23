package com.sama.ach.cucumber.enquiry.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.sama.ach.cucumber.enquiry.utils.EnquiryLib;
import com.sama.ach.cucumber.poc.utils.CommonFunctions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/com/sama/ach/cucumber/features", glue =
"com.sama.ach.cucumber.enquiry.stepdefs", dryRun =false,plugin = {"pretty", "html:Reports/Cucumber-StandardReport",
	"json:target/Cucumber-Report/cucumber.json"},
tags = {
		//"@Ext_ParticipantPosition"
		//"@Ext_ParticipantUnabletoTransact"
	    //"@Ext_RetrieveParticipantStatus"
		//"@Ext_ParticipantSettlementPositions"
		//"@Ext_ValueTransactionEnquiry"
		//"@Ext_ValueTransactionEnquiry or @Ext_ValueTransactionEnquiryforToday"
		//"@Ext_ValueTransactionEnquiryforToday or @Ext_ValueTransactionEnquiryByHistory"
		//"@Ext_ValueTransactionEnquiryforToday"
		"@Ext_ValueTransactionEnquiryByHistory"
		//"@Ext_RetrieveSettlementCycleDetails"
		//"@Ext_SettlementCycleStatus"
		//"@Ext_ViewSettlementCalendar"		// working now
		//"@Ext_RetrieveSettlementSummary"		
		//"@Ext_RetrieveParticipantSNM"
		//"@Ext_UnbilledActivities"
		//"@Ext_DisputeDetails"
		//"@Ext_BilledAmount"
		//"@Ext_RegistrationEnquiries"
//#################################################
		//"@Int_ParticipantPosition"
		//"@Int_ParticipantUnabletoTransact"
		//"@Int_RetrieveParticipantStatus"
		//"@Int_ParticipantSettlementPositions"
		//"@Int_ValueTransactionEnquiryByTransactionID"
		//"@Int_ValueTransactionEnquiryforToday"
		//"@Int_ValueTransactionEnquiryByHistory"
		//"@Int_RetrieveSettlementCycleDetails"
		//"@Int_SettlementCycleStatus"
		//"@Int_ViewSettlementCalendar"
		//"@Int_RetrieveSettlementSummary"
		//"@Int_RetrieveParticipantSNM"
		//"@Int_UnbilledActivities"
		//"@Int_DisputeDetails"
		//"@Int_BilledAmount"
		//"@Int_MPP-RegistrationEnquiries"
	
	
         })
public class EnquiryRunner {
	
	@BeforeClass
	public static void deleteOldScreenshots() {
		CommonFunctions.cleanup_screenshots();
	}
	
	@BeforeClass
	public static void cleanup_downloads() {
		CommonFunctions.cleanup_downloads("chrome");
		CommonFunctions.cleanup_downloads("firefox");
		//CommonFunctions.cleanup_downloads("IE");
	}
	

	@AfterClass
	public static void report() throws InterruptedException {
		//CommonFunctions.generateCustomReport();
		EnquiryLib.generateCustomReport();
	}

}
