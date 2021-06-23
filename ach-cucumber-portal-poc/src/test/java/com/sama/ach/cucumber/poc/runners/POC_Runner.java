package com.sama.ach.cucumber.poc.runners;

import org.junit.runner.RunWith;


import com.sama.ach.cucumber.poc.utils.CommonFunctions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//com.sama.spips.cucumber.portal.stepdefs



//Report
import org.junit.AfterClass;
import org.junit.BeforeClass;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/com/sama/ach/cucumber/features", glue =
"com.sama.ach.cucumber.poc.stepdefs", dryRun =false,plugin = {"pretty", "html:Reports/Cucumber-StandardReport",
	"json:target/Cucumber-Report/cucumber.json"},
tags = {
	//	"@Ext_DebitCap_Valid"
	 "@Ext_CreateDispute_Valid"
	//	"@Ext_CreateDispute_NonExistTransID"
	//	"@Ext_CreateDispute_BlankTransID",
	//	"@Ext_CreateDispute_TransIDlessthan34Characters",
	//	"@Ext_CreateDispute_Valid or @Ext_DebitCap_Valid"
	//	"@CreateDispute_Valid or @CreateDispute_NonExistTransID or @CreateDispute_BlankTransID or @CreateDispute_TransIDlessthan35Characters"
	//	"@DebitCap_Valid or  @DebitCap_Blank or  @DebitCap_Invalid or @DebitCap_Cancel"
	//	"@DebitCap_View"
	//	"@Ext_CreateDispute_BlankTransID"
	//	"@Ext_DebitCap or @Ext_CreateDispute"
	//	"@Ext_CreateDispute_Valid"
	//	"@Ext_DebitCap_Valid"
			
         })

public class POC_Runner {

	@BeforeClass
	public static void deleteOldScreenshots() {
		CommonFunctions.cleanup_screenshots();
	}

	@AfterClass
	public static void report() throws InterruptedException {
		CommonFunctions.generateCustomReport();
	}

}
