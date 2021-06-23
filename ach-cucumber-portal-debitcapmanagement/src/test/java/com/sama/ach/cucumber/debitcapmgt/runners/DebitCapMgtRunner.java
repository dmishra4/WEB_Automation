package com.sama.ach.cucumber.debitcapmgt.runners;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.sama.ach.cucumber.poc.stepdefs.POC_StepDefinitions;
import com.sama.ach.cucumber.poc.utils.CommonFunctions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/com/sama/ach/cucumber/features", glue =
"com.sama.ach.cucumber.debitcapmgt.stepdefs",dryRun = true, plugin = {"pretty", "html:Reports/Cucumber-StandardReport",
	"json:target/Cucumber-Report/cucumber.json"},
tags = {
	//	"@DebitCap_Valid"
    //	"@DebitCap_Valid or  @DebitCap_Blank or  @DebitCap_Invalid or @DebitCap_Cancel"
	//	"@DebitCap_View"
	//	"@DebitCap or @CreateDispute"
	 //    "@Threshold_Valid"
	//	"@Threshold_Blank"
	//"@Threshold_Invalid"
	//	"@Threshold_Cancel"
	//	"@Threshold_View"
		"@INT_DebitCap_Valid"
         })
public class DebitCapMgtRunner {
	
	@AfterClass
	public static void generateReportCust() throws InterruptedException {
		System.out.println("Start generating HTML report folder");
		File reportOutputDirectory = new File("target");
		List<String> jsonFiles = new ArrayList<>();
		String dir = System.getProperty("user.dir");
		String jsonpath = dir+ "\\target\\Cucumber-Report\\cucumber.json";
		System.out.println("Path of json file is :: "+jsonpath);
		jsonFiles.add(jsonpath);
		//jsonFiles.add(
		//		"C:\\SAMA-ACH\\achworkspace\\sama-ach-portal-tests-automation\\ach-cucumber-portal-debitcapmanagement\\target\\Cucumber-Report\\cucumber.json");
		String buildNumber = "1";
		String projectName = "SAMA ACH PORTAL";
		// boolean runWithJenkins = true;

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		// optional configuration - check javadoc
		// configuration.setRunWithJenkins(runWithJenkins);
		configuration.setBuildNumber(buildNumber);

		// additional metadata presented on main page
		configuration.addClassifications("Operating System", System.getProperty("os.name"));
		configuration.addClassifications("Browser", POC_StepDefinitions.browser);
		configuration.addClassifications("Java", System.getProperty("java.version"));
		configuration.addClassifications("Selenium", "3.141.59");
		configuration.addClassifications("Cucumber", "4.2.0");

		// optionally add metadata presented on main page via properties file
		// List<String> classificationFiles = new ArrayList<>();
		// classificationFiles.add("properties-1.properties");
		// classificationFiles.add("properties-2.properties");
		// configuration.addClassificationFiles(classificationFiles);

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		Thread.sleep(1000);
		try {
			reportBuilder.generateReports();
		} catch (Exception e) {
			Assert.fail("Report generation failed as Json file under target folder is not created successfully");
		}

	}
	
	@BeforeClass
	public static void deleteOldScreenshots() {
		CommonFunctions.cleanup_screenshots();
		
	}

}
