package com.sama.ach.cucumber.dispute.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.sama.ach.cucumber.dispute.utils.DisputeLib;
import com.sama.ach.cucumber.poc.utils.CommonFunctions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/com/sama/ach/cucumber/features", glue =
"com.sama.ach.cucumber.dispute.stepdefs", dryRun =false,plugin = {"pretty", "html:Reports/Cucumber-StandardReport",
	"json:target/Cucumber-Report/cucumber.json"},
tags = {
	//	"@Ext_DebitCap_Valid"
	 "@Ext_CreateDispute_Valid"
	//	"@CreateDispute_NonExistTransID"
	//	"@CreateDispute_BlankTransID",
	//	"@CreateDispute_TransIDlessthan35Characters",
	//	"@CreateDispute_Valid or @DebitCap_Valid"
	//	"@CreateDispute_Valid or @CreateDispute_NonExistTransID or @CreateDispute_BlankTransID or @CreateDispute_TransIDlessthan35Characters"
   //		"@Ext_CreateDispute_Valid"
		//"@Ext_SearchUsingTransactionID"
		//"@Ext_AdvDisputeSearch"
		//"@Ext_SearchUsingTransactionID"
		//"@Ext_ViewDisputes"	
		//"@Ext_CreateDispute_TransIDmorethan35Characters"
		//"@Ext_CreateDispute_only35NumericdataTransID"
		//"@Ext_CreateDispute_only35characteristicsdataTransID"
		//"@Ext_CreateDispute_Cancel_No"
		//"@Ext_DisputeStatusEscalation"
		//"@Ext_DisputedPartyUnderReview"
		//" @Ext_DisputeStatusSentforcounterparty"
		//"@Ext_DS_DisputerPartySentforResolution"
		//"@Ext_DS_DisputerPartyReturnedforReviewandResolved"
		//"@Ext_DS_DisputerPartyUnderReview"
		//"@Ext_DS_DisputerPartySenttoCounterParty"
		//"@Ext_DS_DisputedPartySentforResolution"
	//	"@Ext_DS_DisputedPartyReturnedforReview"
		//"#############################################"
		//"@04_Ext_DS_DisputedPartyUnderReview"
		//"@05_Ext_DS_DisputedPartyReturnedforReview"
		//"@06_Ext_DS_DisputedPartySenttoCounterParty"
		//"@07_Ext_DS_DisputedPartySentforResolution"
		//"@08_Ext_DS_DisputerPartyUnderReview"
		//"@09_Ext_DS_DisputerPartyReturnedforReviewandResolved"
		//" @10_Ext_DS_DisputerPartySenttoCounterParty"
		//" @11_Ext_DS_DisputerPartySentforResolution"
	     // "@12_Ext_DS_Escalated"
//		/********************Internal Portal dispute */
		//"@Int_CreateDispute_Valid"
		//"@Int_CreateDispute_TransIDlessthan35Alphanumeric"
		//"@Int_CreateDispute_TransIDmorethan35Alphanumeric"
		//"@Int_CreateDispute_only35NumericdataTransID"
		//"@Int_CreateDispute_only35characteristicsdataTransID"
		//"@Int_CreateDispute_NonExistTransID"
		//"@Int_CreateDispute_Cancel_Yes"
		//"@Int_CreateDispute_Cancel_No"
		//"@Int_SearchUsingDisputeID"
		//"@Int_SearchUsingTransactionID"
		// "@Int_AdvDisputeSearch"
		//"@Int_ViewDisputes"
		//"@Int_ViewAutoClosedDisputes"
		//"@016_Int_EscalatedUnderReview"
		//"@017_Int_EscalatedSentforApprovalandResolved"
		//"@018_Int_EscalatedReturnedforReview"
		//"@019_Int_EscalatedInternal"
		//"@020_Int_EscalatedInternalUnderReview"
		//"@021_Int_EscalatedInternalSentforApproval"
		//"@022_Int_EscalatedInternalReturnedforReview"
		//"@023_Int_OpenToEscalatedInternal"
		//"@024_Int_OpenToEscalatedInternalSP"
		
         })
public class DisputeRunner {
	
	
	@BeforeClass
	public static void deleteOldScreenshots() {
		CommonFunctions.cleanup_screenshots();
	}

	@AfterClass
	public static void report() throws InterruptedException {
		DisputeLib.generateCustomReport();
	}

}
