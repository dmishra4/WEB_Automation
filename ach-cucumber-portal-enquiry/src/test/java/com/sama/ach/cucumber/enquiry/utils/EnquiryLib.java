package com.sama.ach.cucumber.enquiry.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sama.ach.cucumber.enquiry.page.ref.EnquiryPageRef;
import com.sama.ach.cucumber.enquiry.stepdefs.EnquiryStepDefinitions;
import com.sama.ach.cucumber.poc.stepdefs.POC_StepDefinitions;
import com.sama.ach.cucumber.poc.utils.CommonFunctions;

import au.com.bytecode.opencsv.CSVReader;
import cucumber.api.Scenario;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class EnquiryLib implements EnquiryPageRef{
	
	public static ArrayList<String> detailslabellist = new ArrayList<String>();
	public static ArrayList<String> detailsvaluelist = new ArrayList<String>();
	public static ArrayList<String> firstrowdatalist = new ArrayList<String>();
	
	
	/**
	 * Function to login to the Internal Portal
	 * 
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	public static void internalPortalLogin(Scenario scenario, String portal, String environment, String username,
			String password) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(input_UserName));
		Thread.sleep(3000);
		CommonFunctions.driver.findElement(input_UserName).sendKeys(username);
		CommonFunctions.driver.findElement(input_Password).sendKeys(password);
		CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		//System.out.println("The value of sceanio is :: " + POC_StepDefinitions.scenario);
		scenario.embed(CommonFunctions.snapshot, "image/png");
		wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Login));
		CommonFunctions.driver.findElement(btn_Login).click();
		WebDriverWait loginwait = new WebDriverWait(CommonFunctions.driver, 4);
		try {
			loginwait.until(ExpectedConditions.invisibilityOfElementLocated(text_LoginError));
			scenario.write("Successfully Login to " + portal + " Portal in " + environment + " Environment");
			Thread.sleep(2000);

		} catch (TimeoutException e) {
			CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
			scenario.embed(CommonFunctions.snapshot, "image/png");
			scenario.write(portal + " Portal Login has been failed in " + environment
					+ " Environment. Please enter a valid user ID and password.");
			Assert.fail(portal + " Portal Login has been failed in " + environment
					+ " Environment. Please enter a valid user ID and password.");
		}
	}

	
	/**
	 * This function has been written to navigate pages inside Portal application
	 * @param pageName
	 * @param navigation
	 * @param row
	 * @throws InterruptedException
	 */
	
	public static void menuNavigation(String pageName, String navigation, int row) throws InterruptedException {
		
		WebDriverWait  wait = new WebDriverWait(CommonFunctions.driver,30);
		switch (row) {
		case 0:
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(String.format(strNavigate,navigation))));
			CommonFunctions.driver.findElement(By.linkText(String.format(strNavigate,navigation))).click();
			Thread.sleep(1000);
			break;
		case 1:
			//CommonFunctions.driver.findElement(By.xpath("//*[text()='" + navigation + "']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(String.format(strNavigate,navigation))));
			CommonFunctions.driver.findElement(By.linkText(String.format(strNavigate,navigation))).click();
			Thread.sleep(1000);
			break;
		case 2:
			//CommonFunctions.driver.findElement(By.xpath("//*[text()='" + navigation + "']")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(String.format(strNavigate,navigation))));
			CommonFunctions.driver.findElement(By.linkText(String.format(strNavigate,navigation))).click();
			Thread.sleep(1000);
			break;
		default:
			System.out.println("Check feature file. Might be navigation path is not correctly mentioned");
			Assert.fail("Check feature file. "+navigation+" is not available in the application. ");

		}
	}

	/**
	 * Function to click the visible button
	 * @param buttonname
	 * @param pageName
	 * @throws Exception
	 */
		
		public static void clickButton(String buttonName, String pageName) throws Exception {
			WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 10);
			if (pageName.equalsIgnoreCase("Participant Position Enquiry") || pageName.equalsIgnoreCase("Participant Unable to Transact") || pageName.equalsIgnoreCase("Retrieve Participant Status (Single Participant)") || pageName.equalsIgnoreCase("Participant Settlement Positions") || pageName.equalsIgnoreCase("Retrieve Settlement Cycle Details - Current & Previous") || pageName.equalsIgnoreCase("Dispute Details") || pageName.equalsIgnoreCase("Billed Amount") || pageName.equalsIgnoreCase("Settlement Cycle Status") || pageName.equalsIgnoreCase("View Settlement Cycle Calendar") || pageName.equalsIgnoreCase("Retrieve Participant SNM") || pageName.equalsIgnoreCase("Unbilled Activities")|| pageName.equalsIgnoreCase("Retrieve Settlement Cycle Summary")) {
				switch (buttonName) {
				case "Clear Screen":
					wait.until(ExpectedConditions.visibilityOfElementLocated(btn_ClearScreen));
					CommonFunctions.driver.findElement(btn_ClearScreen).click();
					break;
				case "Export to CSV":
					wait.until(ExpectedConditions.visibilityOfElementLocated(btn_ExportToCSV));
					CommonFunctions.driver.findElement(btn_ExportToCSV).click();
					break;
				case "Select":
					wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Select));
					CommonFunctions.driver.findElement(btn_Select).click();
					break;
				case "Submit":
					JavascriptExecutor je = (JavascriptExecutor)CommonFunctions.driver;
					WebElement obj= CommonFunctions.driver.findElement(btn_Submit);
					je.executeScript("arguments[0].scrollIntoView(true);", obj);
					wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Submit));
					CommonFunctions.driver.findElement(btn_Submit).click();
					break;
				default:
					Assert.fail(" Button " + buttonName + " has not been found");					
				}
			} 			
			else if (pageName.equalsIgnoreCase("Value Transaction Enquiry") || pageName.equalsIgnoreCase("Transaction Details")|| pageName.equalsIgnoreCase("Details")) {
				switch (buttonName) {	
				case "Close":
					wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Close));
					CommonFunctions.driver.findElement(btn_Close).click();
					break;
				case "Clear Screen":
					wait.until(ExpectedConditions.visibilityOfElementLocated(btn_ClearScreenVTE));
					CommonFunctions.driver.findElement(btn_ClearScreenVTE).click();
					break;
				case "Details":
					wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Details));
					CommonFunctions.driver.findElement(btn_Details).click();
					//List detailslist = new ArrayList();
					
					break;												
				case "Export to CSV":
					wait.until(ExpectedConditions.visibilityOfElementLocated(btn_ExportToCSV));
					CommonFunctions.driver.findElement(btn_ExportToCSV).click();					
					break;
				case "Submit":
					WebDriverWait waitsubmit = new WebDriverWait(CommonFunctions.driver, 3);
					JavascriptExecutor jse = (JavascriptExecutor)CommonFunctions.driver;
					try{WebElement obj= CommonFunctions.driver.findElement(btn_AdvanceSubmitVTE);
					jse.executeScript("arguments[0].scrollIntoView(true);", obj);
					waitsubmit.until(ExpectedConditions.visibilityOfElementLocated(btn_AdvanceSubmitVTE));
					CommonFunctions.driver.findElement(btn_AdvanceSubmitVTE).click();
					}catch (Exception E)
					{
						WebElement obj= CommonFunctions.driver.findElement(btn_TransactionSubmitVTE);
						jse.executeScript("arguments[0].scrollIntoView(true);", obj);
						waitsubmit.until(ExpectedConditions.visibilityOfElementLocated(btn_TransactionSubmitVTE));
						CommonFunctions.driver.findElement(btn_TransactionSubmitVTE).click();
					}
					break;
				default:
					Assert.fail(" Button " + buttonName + " has not been found");					
				}
			} 
			else if (pageName.equalsIgnoreCase("Registration Enquiries")) {
				switch (buttonName) {
				case "Clear Screen":
					wait.until(ExpectedConditions.visibilityOfElementLocated(btn_RegistrationEnqClrScreen));
					CommonFunctions.driver.findElement(btn_RegistrationEnqClrScreen).click();
					break;
				case "Details":
					wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Details));
					CommonFunctions.driver.findElement(btn_Details).click();
					//List detailslist = new ArrayList();
					
					break;
				case "Export to CSV":
					wait.until(ExpectedConditions.visibilityOfElementLocated(btn_ExportToCSV));
					CommonFunctions.driver.findElement(btn_ExportToCSV).click();
					break;
				case "Select":
					wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Select));
					CommonFunctions.driver.findElement(btn_Select).click();
					break;
				case "Submit":
					JavascriptExecutor je = (JavascriptExecutor)CommonFunctions.driver;
					WebElement obj= CommonFunctions.driver.findElement(btn_RegistrationEnqSubmit);
					je.executeScript("arguments[0].scrollIntoView(true);", obj);
					wait.until(ExpectedConditions.visibilityOfElementLocated(btn_RegistrationEnqSubmit));
					CommonFunctions.driver.findElement(btn_RegistrationEnqSubmit).click();
					break;
				default:
					Assert.fail(" Button " + buttonName + " has not been found");					
				}
			} 
			else {
				Assert.fail("Required page " + pageName + " is not defined in library functions");
			}
		}
	
		/**
		 * Function to select radio button
		 * @param radiobuttonName
		 * @param pageName
		 * @throws Exception
		 */
		
	public static void clickRadioButton(String radiobuttonName) throws Exception {
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 30);
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, radiobuttonName))));
		} catch (TimeoutException e) {
			Assert.fail(" Button " + radiobuttonName + " has not been found");
		}
		if (radiobuttonName.equalsIgnoreCase("Today")) {
			EnquiryStepDefinitions.radiobutton = radiobuttonName;
		}
		CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel, radiobuttonName))).click();
		System.out.println(radiobuttonName + " Radio Button is clicked successfully");

	}
		
		/**
		 * Function to return the column number for the header in output table
		 * @param HeaderName
		 * @return
		 */
	public static int enquiryResultHeaderMapping(String HeaderName, String enqpagename)

	{
		int tableHeaderIndex, HeaderNameIndex = 0;
		boolean flag = false;
		List<WebElement> HeaderValues;
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 10);
		if (enqpagename.equalsIgnoreCase("Value Transaction Enquiry")
				&& EnquiryStepDefinitions.radiobutton.equalsIgnoreCase("Today")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(tbl_EnquiryResultHeaderVT));
			HeaderValues = CommonFunctions.driver.findElements(tbl_EnquiryResultHeaderVT);
		} else if (enqpagename.equalsIgnoreCase("View Settlement Cycle Calendar")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(tbl_ViewSettlementCalendarHeader));
			HeaderValues = CommonFunctions.driver.findElements(tbl_ViewSettlementCalendarHeader);
		} else if (enqpagename.equalsIgnoreCase("Retrieve Settlement Cycle Summary")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(tbl_RetrieveSettlementSummaryHeader));
			HeaderValues = CommonFunctions.driver.findElements(tbl_RetrieveSettlementSummaryHeader);
		} else if (enqpagename.equalsIgnoreCase("Retrieve Participant SNM")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(tbl_ParticipantSNMHeader));
			HeaderValues = CommonFunctions.driver.findElements(tbl_ParticipantSNMHeader);
		} else {
			wait.until(ExpectedConditions.visibilityOfElementLocated(tbl_EnquiryResultHeader));
			HeaderValues = CommonFunctions.driver.findElements(tbl_EnquiryResultHeader);
		}
		for (tableHeaderIndex = 0; tableHeaderIndex < HeaderValues.size(); tableHeaderIndex++) {
			String strHeader = HeaderValues.get(tableHeaderIndex).getText();
			// System.out.println("The value of strHeader " + strHeader);
			if (strHeader.equalsIgnoreCase(HeaderName)) {
				flag = true;
				break;
			}
		}
		if (flag == false) {
			Assert.fail("Column " + HeaderName + " is not present in result table under " + enqpagename + " enquiry");
			return 0;
		} else {
			HeaderNameIndex = tableHeaderIndex + 1;
			System.out.println("The " + HeaderName + " is located at column number " + HeaderNameIndex);
			return HeaderNameIndex;
		}

	}
	
	
	/**
	 * Function to validate GUI Items
	 * 
	 * @param item
	 * @param name
	 * @param value
	 */
	public static void validateResultsTableItems(String enqpagename, String column, String value, int Page, int row) {
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 30);
		int columnnumber;
		String ActColumnValue = "";
		if (enqpagename.equalsIgnoreCase("Value Transaction Enquiry")
				&& EnquiryStepDefinitions.radiobutton.equalsIgnoreCase("Today")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(tbl_EnquiryResultHeaderVT));
			columnnumber = enquiryResultHeaderMapping(column, enqpagename);
			ActColumnValue = CommonFunctions.driver
					.findElement(By.xpath(String.format(strTodayResults, row, columnnumber))).getText();
			System.out.println(" The runtime value of " + column + " in row " + row + " under page "+Page+" is :  " + ActColumnValue);
			if (ActColumnValue.isEmpty()) {
				CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
				EnquiryStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
				Assert.fail("The runtime value of " + column + " in row " + row + " is empty");
			}
		} else if (enqpagename.equalsIgnoreCase("View Settlement Cycle Calendar")) {

			wait.until(ExpectedConditions.visibilityOfElementLocated(tbl_ViewSettlementCalendarHeader));
			columnnumber = enquiryResultHeaderMapping(column, enqpagename);
			ActColumnValue = CommonFunctions.driver
					.findElement(By.xpath(String.format(strViewSettlementCalendar, row, columnnumber))).getText();
			System.out.println(" The runtime value of " + column + " in row " + row + " under page "+Page+" is :  " + ActColumnValue);
			if (ActColumnValue.isEmpty()) {
				CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
				EnquiryStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
				Assert.fail("The runtime value of " + column + " in row " + row + " is empty");

			}
			if(Page == 1 && row==1)
			{
				firstrowdatalist.add(ActColumnValue);
			}

		} else if (enqpagename.equalsIgnoreCase("Retrieve Settlement Cycle Summary")) {

			wait.until(ExpectedConditions.visibilityOfElementLocated(tbl_RetrieveSettlementSummaryHeader));
			columnnumber = enquiryResultHeaderMapping(column, enqpagename);
			ActColumnValue = CommonFunctions.driver
					.findElement(By.xpath(String.format(strRetrieveSettlementSummary, row, columnnumber))).getText();
			System.out.println(" The runtime value of " + column + " in row " + row + " under page "+Page+" is :  " + ActColumnValue);
			if (ActColumnValue.isEmpty()) {
				CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
				EnquiryStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
				Assert.fail("The runtime value of " + column + " in row " + row + " is empty");
			}
			if(Page == 1 && row==1)
			{
				firstrowdatalist.add(ActColumnValue);
			}

		} else if (enqpagename.equalsIgnoreCase("Retrieve Participant SNM")) {

			wait.until(ExpectedConditions.visibilityOfElementLocated(tbl_ParticipantSNMHeader));
			columnnumber = enquiryResultHeaderMapping(column, enqpagename);
			ActColumnValue = CommonFunctions.driver
					.findElement(By.xpath(String.format(strSNMResults, row, columnnumber))).getText();
			System.out.println(" The runtime value of " + column + " in row " + row + " is :  " + ActColumnValue);
			if (ActColumnValue.isEmpty()) {
				CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
				EnquiryStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
				Assert.fail("The runtime value of " + column + " in row " + row + " is empty");
			}
			if(Page == 1 && row==1)
			{
				firstrowdatalist.add(ActColumnValue);
			}

		} else {
			wait.until(ExpectedConditions.visibilityOfElementLocated(tbl_EnquiryResultHeader));
			columnnumber = enquiryResultHeaderMapping(column, enqpagename);
			ActColumnValue = CommonFunctions.driver.findElement(By.xpath(String.format(strResults, row, columnnumber)))
					.getText();
			System.out.println(" The runtime value of " + column + " in row " + row + " under page "+Page+" is :  " + ActColumnValue);
			if (!(column.equalsIgnoreCase("Close Date") || column.equalsIgnoreCase("Transaction Value")
					|| column.equalsIgnoreCase("Blocked Reason") || column.equalsIgnoreCase("Settlement Cycle ID")
					|| column.equalsIgnoreCase("Tracking Position")|| column.equalsIgnoreCase("Last Sign-on Status Change") || column.equalsIgnoreCase("Last Suspension Status Change") || column.equalsIgnoreCase("Tracking Position Limit"))) {
				if (ActColumnValue.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					EnquiryStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("The runtime value of " + column + " in row " + row + " is empty");
				}
			}
			if(Page == 1 && row==1)
			{
				firstrowdatalist.add(ActColumnValue);
			}
		}

	}
	
	
	/**
	 * Function to validate GUI Items
	 * @param item
	 * @param name
	 * @param value
	 */
	public static void validateGUIItems(String enqpagename, String item, String name, String value) {

		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 30);
		if (enqpagename.equalsIgnoreCase("Participant Position Enquiry") || enqpagename.equalsIgnoreCase("Retrieve Participant Status (Single Participant)") || enqpagename.equalsIgnoreCase("Participant Settlement Positions")) {
			switch (name) {
			case "Clear Screen":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_ClearScreen));
				boolean flag = CommonFunctions.driver.findElement(btn_ClearScreen).isEnabled();
				Assert.assertEquals("Button " + name + " is not enabled", true, flag);
				break;
			case "Participant ID":
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_ParticipantID));
				flag = CommonFunctions.driver.findElement(input_ParticipantID).isSelected();
				Assert.assertEquals(" " + name + " input field is enabled", false, flag);
				break;
			case "Settlement Cycle ID":
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_settlementCycleId));
				flag = CommonFunctions.driver.findElement(label_settlementCycleId).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			case "Settlement Date":
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_SettlementDate));
				flag = CommonFunctions.driver.findElement(label_SettlementDate).isEnabled();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			case "Submit":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Submit));
				flag = CommonFunctions.driver.findElement(btn_Submit).isEnabled();
				Assert.assertEquals("Button " + name + " is not enabled", true, flag);
				break;
			default:
				Assert.fail("" + name + " GUI item has not been found");

			}
		}  
		else if (enqpagename.equalsIgnoreCase("Value Transaction Enquiry")) {
			boolean flag; 
			switch (name) {
			case "Category Purpose Code":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			case "Clear Screen":
				WebDriverWait waitclearscreen = new WebDriverWait(CommonFunctions.driver, 3);
				try {
					waitclearscreen.until(ExpectedConditions.visibilityOfElementLocated(btn_ClearScreenVTE));
				flag = CommonFunctions.driver.findElement(btn_ClearScreenVTE).isEnabled();
				}catch (TimeoutException e) {
					waitclearscreen.until(ExpectedConditions.visibilityOfElementLocated(btn_TransactionClearScreen));
					flag = CommonFunctions.driver.findElement(btn_TransactionClearScreen).isEnabled();
				}
				Assert.assertEquals("Button " + name + " is not enabled", true, flag);
				break;
			case "Date Start":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			case "Date End":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			case "Local Instrument":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			case "Participant ID":
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_ParticipantID));
				flag = CommonFunctions.driver.findElement(input_ParticipantID).isSelected();
				Assert.assertEquals(" " + name + " input field is enabled", false, flag);
				break;
			case "Settlement Cycle ID":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			case "Submit":
				WebDriverWait waitsubmit = new WebDriverWait(CommonFunctions.driver, 3);
				try{waitsubmit.until(ExpectedConditions.visibilityOfElementLocated(btn_AdvanceSubmitVTE));
				flag = CommonFunctions.driver.findElement(btn_AdvanceSubmitVTE).isEnabled();
				}catch(TimeoutException e ){
					waitsubmit.until(ExpectedConditions.visibilityOfElementLocated(btn_TransactionSubmitVTE));
					flag = CommonFunctions.driver.findElement(btn_TransactionSubmitVTE).isEnabled();
				}
				Assert.assertEquals("Button " + name + " is not enabled", true, flag);
				break;
			case "Reason Code":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;	
			case "Routing Number (Bank ID)":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			case "Transaction Amount":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			case "Transaction ID":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			case "Transaction Status":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;	
			default:
				Assert.fail("" + name + " GUI item has not been found");
			}
			}
		else if (enqpagename.equalsIgnoreCase("View Settlement Cycle Calendar") || enqpagename.equalsIgnoreCase("Settlement Cycle Status")) {
			switch (name) {
			case "Clear Screen":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_ClearScreen));
				boolean flag = CommonFunctions.driver.findElement(btn_ClearScreen).isEnabled();
				Assert.assertEquals("Button " + name + " is not enabled", true, flag);
				break;
			case "Currency ISO Code":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			case "To Date":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			case "From Date":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			case "Submit":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Submit));
				flag = CommonFunctions.driver.findElement(btn_Submit).isEnabled();
				Assert.assertEquals("Button " + name + " is not enabled", true, flag);
				break;
			default:
				Assert.fail("" + name + " GUI item has not been found");
			}
		}
		else if (enqpagename.equalsIgnoreCase("Retrieve Participant SNM")) {
			switch (name) {
			case "Clear Screen":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_ClearScreen));
				boolean flag = CommonFunctions.driver.findElement(btn_ClearScreen).isEnabled();
				Assert.assertEquals("Button " + name + " is not enabled", true, flag);
				break;
			case "End Date":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			case "Event Types":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			case "Participant ID":
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_ParticipantID));
				flag = CommonFunctions.driver.findElement(input_ParticipantID).isSelected();
				Assert.assertEquals(" " + name + " input field is enabled", false, flag);
				break;
			case "Start Date":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			case "Submit":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Submit));
				flag = CommonFunctions.driver.findElement(btn_Submit).isEnabled();
				Assert.assertEquals("Button " + name + " is not enabled", true, flag);
				break;
			default:
				Assert.fail("" + name + " GUI item has not been found");
			}
		}
		else if (enqpagename.equalsIgnoreCase("Unbilled Activities")) {
			switch (name) {
			case "Clear Screen":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_ClearScreen));
				boolean flag = CommonFunctions.driver.findElement(btn_ClearScreen).isEnabled();
				Assert.assertEquals("Button " + name + " is not enabled", true, flag);
				break;
			case "Participant ID":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals(" " + name + " input field is enabled", true, flag);
				break;
			case "Submit":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Submit));
				flag = CommonFunctions.driver.findElement(btn_Submit).isEnabled();
				Assert.assertEquals("Button " + name + " is not enabled", true, flag);
				break;
			default:
				Assert.fail("" + name + " GUI item has not been found");

			}
		}
			else if (enqpagename.equalsIgnoreCase("Dispute Details")) {
				switch (name) {
				case "Clear Screen":
					wait.until(ExpectedConditions.visibilityOfElementLocated(btn_ClearScreen));
					boolean flag = CommonFunctions.driver.findElement(btn_ClearScreen).isEnabled();
					Assert.assertEquals("Button " + name + " is not enabled", true, flag);
					break;
				case "Disputer Party":
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
					flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
					Assert.assertEquals("Label " + name + " is not displayed", true, flag);
					break;
				case "Disputed Party":
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
					flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
					Assert.assertEquals("Label " + name + " is not displayed", true, flag);
					break;
				case "Dispute Status":
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
					flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
					Assert.assertEquals("Label " + name + " is not displayed", true, flag);
					break;				
				case "End Date":
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
					flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
					Assert.assertEquals("Label " + name + " is not displayed", true, flag);
					break;
				case "Start Date":
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
					flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
					Assert.assertEquals("Label " + name + " is not displayed", true, flag);
					break;
				case "Submit":
					wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Submit));
					flag = CommonFunctions.driver.findElement(btn_Submit).isEnabled();
					Assert.assertEquals("Button " + name + " is not enabled", true, flag);
					break;
				default:
					Assert.fail("" + name + " GUI item has not been found");

				}
			}
			else if (enqpagename.equalsIgnoreCase("Billed Amount")) {
				switch (name) {
				case "Clear Screen":
					wait.until(ExpectedConditions.visibilityOfElementLocated(btn_ClearScreen));
					boolean flag = CommonFunctions.driver.findElement(btn_ClearScreen).isEnabled();
					Assert.assertEquals("Button " + name + " is not enabled", true, flag);
					break;
				case "End Date":
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
					flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
					Assert.assertEquals("Label " + name + " is not displayed", true, flag);
					break;
				case "Participant ID":
					wait.until(ExpectedConditions.visibilityOfElementLocated(input_ParticipantID));
					flag = CommonFunctions.driver.findElement(input_ParticipantID).isSelected();
					Assert.assertEquals(" " + name + " input field is enabled", false, flag);
					break;
				case "Start Date":
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
					flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
					Assert.assertEquals("Label " + name + " is not displayed", true, flag);
					break;
				case "Submit":
					wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Submit));
					flag = CommonFunctions.driver.findElement(btn_Submit).isEnabled();
					Assert.assertEquals("Button " + name + " is not enabled", true, flag);
					break;
				default:
					Assert.fail("" + name + " GUI item has not been found");

				}
			}
			else if (enqpagename.equalsIgnoreCase("Registration Enquiries")) {
				switch (name) {
				case "Clear Screen":
					wait.until(ExpectedConditions.visibilityOfElementLocated(btn_RegistrationEnqClrScreen));
					boolean flag = CommonFunctions.driver.findElement(btn_RegistrationEnqClrScreen).isEnabled();
					Assert.assertEquals("Button " + name + " is not enabled", true, flag);
					break;
				case "Participant Code":
					wait.until(ExpectedConditions.visibilityOfElementLocated(input_ParticipantCode));
					flag = CommonFunctions.driver.findElement(input_ParticipantCode).isSelected();
					Assert.assertEquals(" " + name + " input field is enabled", false, flag);
					break;
				case "Registration ID":
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
					flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
					Assert.assertEquals("Label " + name + " is not displayed", true, flag);
					break;	
				case "Submit":
					wait.until(ExpectedConditions.visibilityOfElementLocated(btn_RegistrationEnqSubmit));
					flag = CommonFunctions.driver.findElement(btn_RegistrationEnqSubmit).isEnabled();
					Assert.assertEquals("Button " + name + " is not enabled", true, flag);
					break;
				default:
					Assert.fail("" + name + " GUI item has not been found");
				}
				}
			else if (enqpagename.equalsIgnoreCase("Retrieve Settlement Cycle Summary")) {
				switch (name) {
				case "Clear Screen":
					wait.until(ExpectedConditions.visibilityOfElementLocated(btn_ClearScreen));
					boolean flag = CommonFunctions.driver.findElement(btn_ClearScreen).isEnabled();
					Assert.assertEquals("Button " + name + " is not enabled", true, flag);
					break;
				case "Currency ISO Code":
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
					flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
					Assert.assertEquals("Label " + name + " is not displayed", true, flag);
					break;
				case "Participant ID":
					wait.until(ExpectedConditions.visibilityOfElementLocated(input_ParticipantID));
					flag = CommonFunctions.driver.findElement(input_ParticipantID).isSelected();
					Assert.assertEquals(" " + name + " input field is enabled", false, flag);
					break;
				case "Settlement Cycle ID":
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
					flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
					Assert.assertEquals("Label " + name + " is not displayed", true, flag);
					break;
				case "Settlement Date":
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
					flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
					Assert.assertEquals("Label " + name + " is not displayed", true, flag);
					break;
				case "Submit":
					wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Submit));
					flag = CommonFunctions.driver.findElement(btn_Submit).isEnabled();
					Assert.assertEquals("Button " + name + " is not enabled", true, flag);
					break;
				default:
					Assert.fail("" + name + " GUI item has not been found");
				}
			}
			else if (enqpagename.equalsIgnoreCase("Transaction Details") || enqpagename.equalsIgnoreCase("Details"))  {
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				boolean flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				String str= CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).getText().trim();
				String arrdetailslabel[] = str.split(":");
				String detailslabel = arrdetailslabel[0].trim();
				String detailsvalue = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIDetailslabel,name))).getText().trim();
				if(detailsvalue.isEmpty()) {
				Assert.fail("The value of Label " + name + " is not displayed");
				}
				
				detailslabellist.add(detailslabel);
				System.out.println("Deails label are ::"+detailslabellist);
				detailsvaluelist.add(detailsvalue);
				System.out.println("Deails label are ::"+detailsvaluelist);
			}
			else {
			Assert.fail("Required page " + enqpagename + " is not defined in library functions");
		}
	

	}
	
	public static void readCSVfile(String enquiryPageName) throws IOException, InterruptedException
	
	{
		//String downloadFilepath = System.getProperty("user.dir") + "\\src\\test\\resources\\com\\sama\\ach\\cucumber\\downloads\\chrome";
		String downloadFilepath = System.getProperty("user.dir") + "\\src\\test\\resources\\com\\sama\\ach\\cucumber\\downloads\\"+EnquiryStepDefinitions.browser.toLowerCase();
		int tableHeaderIndex;
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver,10);
		ArrayList<String> csvcolumn = new ArrayList<String>();
		ArrayList<String> firstrowdatainCSV = new ArrayList<String>();
		ArrayList<String> resultscolumn = new ArrayList<String>();
		Thread.sleep(4000);
		File latestfile = getLatestFile(downloadFilepath+"\\",enquiryPageName);
        CSVReader reader = new CSVReader(new FileReader(latestfile));
		//CSVReader reader = new CSVReader(new FileReader(downloadFilepath+"\\"+enquiryPageName+".csv"));
		String[] columns= reader.readNext();  // Read Column name of CSV file
		for(String str : columns) {
		csvcolumn.add(str);
		}
		String[] firstrowdata= reader.readNext();  // Read first row data of CSV file
		for(String str : firstrowdata) {
		firstrowdatainCSV.add(str.trim());
		}
		//List<WebElement> HeaderValues = CommonFunctions.driver.findElements(tbl_EnquiryResultHeader);
		List<WebElement> HeaderValues;
		/*
		 * if (!EnquiryStepDefinitions.radiobutton.equalsIgnoreCase("Today")) {
		 * HeaderValues = CommonFunctions.driver.findElements(tbl_EnquiryResultHeader);
		 * }else { HeaderValues =
		 * CommonFunctions.driver.findElements(tbl_EnquiryResultHeaderVT); }
		 */
		if (enquiryPageName.equalsIgnoreCase("Value Transaction Enquiry")
				&& EnquiryStepDefinitions.radiobutton.equalsIgnoreCase("Today")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(tbl_EnquiryResultHeaderVT));
			HeaderValues = CommonFunctions.driver.findElements(tbl_EnquiryResultHeaderVT);
		} else if (enquiryPageName.equalsIgnoreCase("View Settlement Cycle Calendar")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(tbl_ViewSettlementCalendarHeader));
			HeaderValues = CommonFunctions.driver.findElements(tbl_ViewSettlementCalendarHeader);
		} else if (enquiryPageName.equalsIgnoreCase("Retrieve Settlement Cycle Summary")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(tbl_RetrieveSettlementSummaryHeader));
			HeaderValues = CommonFunctions.driver.findElements(tbl_RetrieveSettlementSummaryHeader);
		} else if (enquiryPageName.equalsIgnoreCase("Retrieve Participant SNM")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(tbl_ParticipantSNMHeader));
			HeaderValues = CommonFunctions.driver.findElements(tbl_ParticipantSNMHeader);
		} else {
			wait.until(ExpectedConditions.visibilityOfElementLocated(tbl_EnquiryResultHeader));
			HeaderValues = CommonFunctions.driver.findElements(tbl_EnquiryResultHeader);
		}
		for (tableHeaderIndex = 0; tableHeaderIndex < HeaderValues.size(); tableHeaderIndex++) {
			String strHeader = HeaderValues.get(tableHeaderIndex).getText();
			if(!strHeader.equalsIgnoreCase("")) {
			resultscolumn.add(strHeader);
			}
		}
		boolean flag=false ;
		if(enquiryPageName.equalsIgnoreCase("Value Transaction Enquiry")) {
		Collections.sort(csvcolumn);
		Collections.sort(detailslabellist);
		flag=csvcolumn.equals(detailslabellist);
		System.out.println("Columns in CSV File  :: "+csvcolumn);
		System.out.println("labels in Details    :: "+detailslabellist);
		Assert.assertEquals("Results table columns name does not match with Details Label", true, flag);
		// Validate Transaction Details value of the first row of result table and  downloaded CSV
		Collections.sort(firstrowdatainCSV);
		Collections.sort(detailsvaluelist);
		flag=firstrowdatainCSV.equals(detailsvaluelist);
		System.out.println("           First row data in CSV File   :: "+firstrowdatainCSV);
		System.out.println("First row values of Transaction Details :: "+detailsvaluelist);
		try {
		Assert.assertEquals("Results table first row data does not match with Transaction Details Values", true, flag);
		}
		catch(AssertionError e)
		{
			reader.close();
			detailslabellist.clear();
			detailsvaluelist.clear();
		    firstrowdatalist.clear();
			EnquiryStepDefinitions.radiobutton="";
			Assert.fail("Results table first row data does not match with Transaction Details Values");
		}
		}
		else
		{
			flag=csvcolumn.equals(resultscolumn);
			System.out.println("    Columns in CSV File :: "+csvcolumn);
			System.out.println("Columns in Result Table :: "+resultscolumn);
			//Assert.assertEquals("Results table columns name does not match with downloaded CSV file", true, flag);
			// Validate first row data of result table and downloaded CSV
			Collections.sort(firstrowdatainCSV);
			Collections.sort(firstrowdatalist);
			flag=firstrowdatainCSV.equals(firstrowdatalist);
			System.out.println("    First row data in CSV File  :: "+firstrowdatainCSV);
			System.out.println("First row data in Results table :: "+firstrowdatalist);
			Assert.assertEquals("Results table first row data values do not match with First row data in CSV File", true, flag);
		}    
		reader.close();
		detailslabellist.clear();
		detailsvaluelist.clear();
	    firstrowdatalist.clear();
		EnquiryStepDefinitions.radiobutton="";
	}
	
	
	/**
	 * This function is used to enter values in input fields for any specific page.
	 * @param page
	 * @param field_name
	 * @param field_value
	 * @throws InterruptedException
	 * @throws ParseException 
	 */
	public static void enterValues(String page, String field_name, String field_value)
			throws InterruptedException, ParseException

	{
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 15);
		JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
		// Page Name :: Participant Settlement Positions
		if (page.equalsIgnoreCase("Participant Settlement Positions")) {
			switch (field_name) {
			case "Settlement Date": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_SettlementDate));
				//JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
				// jse.executeScript("document.getElementById('settlementCycleDate').value='02/06/2020'");
				if (field_value.equalsIgnoreCase("%TodayDate%")) {
					String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
					System.out.println("The Value of todaydate is :: " + todaydate);
					CommonFunctions.driver.findElement(input_SettlementDate).sendKeys(Keys.ENTER);
					jse.executeScript("document.getElementById('settlementCycleDate').value='" + todaydate + "'");
				} else if (field_value.equalsIgnoreCase("%PreviousDate%")) {
					String pastdate = CommonFunctions.pastDate("dd/MM/yyyy", -5);
					System.out.println("The Value of PreviousDate is :: " + pastdate);
					CommonFunctions.driver.findElement(input_SettlementDate).sendKeys(Keys.ENTER);
					jse.executeScript("document.getElementById('settlementCycleDate').value='" + pastdate + "'");
				} else if (field_value.equalsIgnoreCase("%FutureDate%")) {
					String futuredate = CommonFunctions.futureDate("dd/MM/yyyy", 5);
					System.out.println("The Value of FutureDate is :: " + futuredate);
					CommonFunctions.driver.findElement(input_SettlementDate).sendKeys(Keys.ENTER);
					jse.executeScript("document.getElementById('settlementCycleDate').value='" + futuredate + "'");
				} else {
					CommonFunctions.driver.findElement(input_SettlementDate).sendKeys(Keys.ENTER);
					jse.executeScript("document.getElementById('settlementCycleDate').value='" + field_value + "'");
				}
				break;
			}
			case "Settlement Cycle ID": {
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_settlementCycleId));
				WebElement settlementCycleId = CommonFunctions.driver.findElement(select_settlementCycleId);
				Thread.sleep(3000);
				Select settlementId = new Select(settlementCycleId);
				settlementId.selectByVisibleText(field_value);
				break;
			}
			default:
				Assert.fail("Required field " + field_name + " is not available in feature file");
			}
		}		
		// Page Name :: Value Transaction Enquiry
		else if (page.equalsIgnoreCase("Value Transaction Enquiry")) {
			switch (field_name) {
			case "Date Start": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_DateStart));
				//JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
				if (field_value.equalsIgnoreCase("%TodayDate%")) {
					String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
					System.out.println("The Value of todaydate is :: " + todaydate);
					//CommonFunctions.driver.findElement(input_DateStart).sendKeys(Keys.ENTER);
					//jse.executeScript("document.getElementById('dateStart').value='" + todaydate + "'");
					CommonFunctions.driver.findElement(input_DateStart).click();
					CommonFunctions.datepicker(todaydate);
				} else if (field_value.equalsIgnoreCase("%PreviousDate%")) {
					String pastdate = CommonFunctions.pastDate("dd/MM/yyyy", -5);
					System.out.println("The Value of todaydate is :: " + pastdate);
					//CommonFunctions.driver.findElement(input_DateStart).sendKeys(Keys.ENTER);
					//jse.executeScript("document.getElementById('dateStart').value='" + pastdate + "'");
					CommonFunctions.driver.findElement(input_DateStart).click();
					CommonFunctions.datepicker(pastdate);
				} else if (field_value.equalsIgnoreCase("%FutureDate%")) {
					String futuredate = CommonFunctions.futureDate("dd/MM/yyyy", 5);
					System.out.println("The Value of todaydate is :: " + futuredate);
					//jse.executeScript("document.getElementById('dateStart').value='" + futuredate + "'");
					//CommonFunctions.driver.findElement(input_DateStart).sendKeys(Keys.ENTER);
					CommonFunctions.driver.findElement(input_DateStart).click();
					CommonFunctions.datepicker(futuredate);
				} else {
					//CommonFunctions.driver.findElement(input_DateStart).sendKeys(Keys.ENTER);
					//jse.executeScript("document.getElementById('dateStart').value='" + field_value + "'");
					CommonFunctions.driver.findElement(input_DateStart).click();
					CommonFunctions.datepicker(field_value);
				}
				break;
			}
			case "Date End": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_DateEnd));
				//JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
				if (field_value.equalsIgnoreCase("%TodayDate%")) {
					String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
					System.out.println("The Value of todaydate is :: " + todaydate);
					//CommonFunctions.driver.findElement(input_DateEnd).sendKeys(Keys.ENTER);
					//jse.executeScript("document.getElementById('dateEnd').value='" + todaydate + "'");
					Thread.sleep(2000);
					CommonFunctions.driver.findElement(input_DateEnd).click();
					CommonFunctions.datepicker(todaydate);
				} else if (field_value.equalsIgnoreCase("%PreviousDate%")) {
					String pastdate = CommonFunctions.pastDate("dd/MM/yyyy", -5);
					System.out.println("The Value of todaydate is :: " + pastdate);
					//CommonFunctions.driver.findElement(input_DateEnd).sendKeys(Keys.ENTER);
					//jse.executeScript("document.getElementById('dateEnd').value='" + pastdate + "'");
					Thread.sleep(2000);
					CommonFunctions.driver.findElement(input_DateEnd).click();
					CommonFunctions.datepicker(pastdate);
				} else if (field_value.equalsIgnoreCase("%FutureDate%")) {
					String futuredate = CommonFunctions.futureDate("dd/MM/yyyy", 5);
					System.out.println("The Value of todaydate is :: " + futuredate);
					//CommonFunctions.driver.findElement(input_DateEnd).sendKeys(Keys.ENTER);
					//jse.executeScript("document.getElementById('dateEnd').value='" + futuredate + "'");
					CommonFunctions.driver.findElement(input_DateEnd).click();
					CommonFunctions.datepicker(futuredate);
				} else {
					//CommonFunctions.driver.findElement(input_DateEnd).sendKeys(Keys.ENTER);
					//jse.executeScript("document.getElementById('dateEnd').value='" + field_value + "'");
					Thread.sleep(2000);
					CommonFunctions.driver.findElement(input_DateEnd).click();
					CommonFunctions.datepicker(field_value);
				}
				break;
			}
			case "Transaction ID": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_TransactionId));
				CommonFunctions.driver.findElement(input_TransactionId).sendKeys(field_value);
				break;
			}
			case "Settlement Cycle ID": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_settlementCycleIdVTE));
				WebElement settlementCycle = CommonFunctions.driver.findElement(select_settlementCycleIdVTE);
				Select SsettlementCycle = new Select(settlementCycle);
				SsettlementCycle.selectByVisibleText(field_value);
				break;
			}
			case "Routing Number (Bank ID)": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_RoutingNumber));
				CommonFunctions.driver.findElement(input_RoutingNumber).sendKeys(field_value);
				break;
			}
			case "Local Instrument": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_LocalInstrument));
				WebElement LocalInstrument = CommonFunctions.driver.findElement(select_LocalInstrument);
				Select SLocalInstrument = new Select(LocalInstrument);
				SLocalInstrument.selectByVisibleText(field_value);
				break;
			}
			case "Transaction Amount": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_TransactionAmount));
				CommonFunctions.driver.findElement(input_TransactionAmount).sendKeys(field_value);
				break;
			}
			case "Transaction Status": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_TransactionStatus));
				WebElement TransactionStatus = CommonFunctions.driver.findElement(select_TransactionStatus);
				Select TStatus = new Select(TransactionStatus);
				TStatus.selectByVisibleText(field_value);
				break;
			}
			case "Reason Code": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_ReasonCode));
				CommonFunctions.driver.findElement(input_ReasonCode).sendKeys(field_value);
				break;
			}
			case "Category Purpose Code": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_CategoryPurposeCode));
				WebElement PurposeCode = CommonFunctions.driver.findElement(select_CategoryPurposeCode);
				Select CPurposeCode = new Select(PurposeCode);
				CPurposeCode.selectByVisibleText(field_value);
				break;
			}
			default:
				Assert.fail("Required field " + field_name + " is not available in feature file");
			}
		}

		// Page Name :: View Settlement Calendar

		else if (page.equalsIgnoreCase("View Settlement Cycle Calendar") || page.equalsIgnoreCase("Settlement Cycle Status")) {
			switch (field_name) {
			case "Currency ISO Code": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_currencyIsoCode));
				WebElement currencyIsoCode = CommonFunctions.driver.findElement(select_currencyIsoCode);
				Select ScurrencyIsoCode = new Select(currencyIsoCode);
				ScurrencyIsoCode.selectByVisibleText(field_value);
				break;
				}
			case "From Date": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_fromDate));
				//JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
				if (field_value.equalsIgnoreCase("%TodayDate%")) {
					String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
					System.out.println("The Value of todaydate is :: " + todaydate);
					jse.executeScript("document.getElementById('fromDate')'.value='" + todaydate + "'");
				} else if (field_value.equalsIgnoreCase("%PreviousDate%")) {
					String pastdate = CommonFunctions.pastDate("dd/MM/yyyy", -5);
					System.out.println("The Value of todaydate is :: " + pastdate);
					jse.executeScript("document.getElementById('fromDate').value='" + pastdate + "'");
				} else if (field_value.equalsIgnoreCase("%FutureDate%")) {
					String futuredate = CommonFunctions.futureDate("dd/MM/yyyy", 5);
					System.out.println("The Value of todaydate is :: " + futuredate);
					jse.executeScript("document.getElementById('fromDate').value='" + futuredate + "'");

				} else {
					jse.executeScript("document.getElementById('fromDate').value='" + field_value + "'");
				}
				break;
			}
			case "To Date": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_toDate));
				//JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
				if (field_value.equalsIgnoreCase("%TodayDate%")) {
					String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
					System.out.println("The Value of todaydate is :: " + todaydate);
					jse.executeScript("document.getElementById('toDate').value='" + todaydate + "'");
				} else if (field_value.equalsIgnoreCase("%PreviousDate%")) {
					String pastdate = CommonFunctions.pastDate("dd/MM/yyyy", -5);
					System.out.println("The Value of todaydate is :: " + pastdate);
					jse.executeScript("document.getElementById('toDate').value='" + pastdate + "'");
				} else if (field_value.equalsIgnoreCase("%FutureDate%")) {
					String futuredate = CommonFunctions.futureDate("dd/MM/yyyy", 5);
					System.out.println("The Value of todaydate is :: " + futuredate);
					jse.executeScript("document.getElementById('toDate').value='" + futuredate + "'");
				} else {
					jse.executeScript("document.getElementById('toDate').value='" + field_value + "'");
				}
				break;
			}
			default:
				Assert.fail("Required field " + field_name + " is not available in feature file");
			}
		}
		
		// Page Name :: Retrieve Participant SNM
		
		else if (page.equalsIgnoreCase("Retrieve Participant SNM")) {
			switch (field_name) {
			case "Start Date": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_rpsStartDate));
				//JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
				if (field_value.equalsIgnoreCase("%TodayDate%")) {
					String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
					System.out.println("The Value of todaydate is :: " + todaydate);
					jse.executeScript("document.getElementById('rpsStartDate')'.value='" + todaydate + "'");
				} else if (field_value.equalsIgnoreCase("%PreviousDate%")) {
					String pastdate = CommonFunctions.pastDate("dd/MM/yyyy", -5);
					System.out.println("The Value of todaydate is :: " + pastdate);
					jse.executeScript("document.getElementById('rpsStartDate').value='" + pastdate + "'");
				} else if (field_value.equalsIgnoreCase("%FutureDate%")) {
					String futuredate = CommonFunctions.futureDate("dd/MM/yyyy", 5);
					System.out.println("The Value of todaydate is :: " + futuredate);
					jse.executeScript("document.getElementById('rpsStartDate').value='" + futuredate + "'");

				} else {
					jse.executeScript("document.getElementById('rpsStartDate').value='" + field_value + "'");
				}
				break;
			}
			case "End Date": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_rpsEndDate));
				//JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
				if (field_value.equalsIgnoreCase("%TodayDate%")) {
					String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
					System.out.println("The Value of todaydate is :: " + todaydate);
					jse.executeScript("document.getElementById('rpsEndDate').value='" + todaydate + "'");
				} else if (field_value.equalsIgnoreCase("%PreviousDate%")) {
					String pastdate = CommonFunctions.pastDate("dd/MM/yyyy", -5);
					System.out.println("The Value of todaydate is :: " + pastdate);
					jse.executeScript("document.getElementById('rpsEndDate').value='" + pastdate + "'");
				} else if (field_value.equalsIgnoreCase("%FutureDate%")) {
					String futuredate = CommonFunctions.futureDate("dd/MM/yyyy", 5);
					System.out.println("The Value of todaydate is :: " + futuredate);
					jse.executeScript("document.getElementById('rpsEndDate').value='" + futuredate + "'");
				} else {
					jse.executeScript("document.getElementById('rpsEndDate').value='" + field_value + "'");
				}
				break;
			}
			case "Event Types": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_EventTypes));
				WebElement EventTypes = CommonFunctions.driver.findElement(select_EventTypes);
				Select SEventTypes = new Select(EventTypes);
				SEventTypes.selectByVisibleText(field_value);
				break;
			}
			default:
				Assert.fail("Required field " + field_name + " is not available in feature file");
			}
		}
		// Page Name :: Dispute Details
		
		else if (page.equalsIgnoreCase("Dispute Details")) {
			switch (field_name) {
			case "Start Date": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_StartDate));
				//JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
				if (field_value.equalsIgnoreCase("%TodayDate%")) {
					String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
					System.out.println("The Value of todaydate is :: " + todaydate);
					jse.executeScript("document.getElementById('startDate').value='" + todaydate + "'");
				} else if (field_value.equalsIgnoreCase("%PreviousDate%")) {
					String pastdate = CommonFunctions.pastDate("dd/MM/yyyy", -5);
					System.out.println("The Value of todaydate is :: " + pastdate);
					jse.executeScript("document.getElementById('startDate').value='" + pastdate + "'");
				} else if (field_value.equalsIgnoreCase("%FutureDate%")) {
					String futuredate = CommonFunctions.futureDate("dd/MM/yyyy", 5);
					System.out.println("The Value of todaydate is :: " + futuredate);
					jse.executeScript("document.getElementById('startDate').value='" + futuredate + "'");
				} else {
					jse.executeScript("document.getElementById('startDate').value='" + field_value + "'");
				}
				break;
			}
			case "End Date": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_EndDate));
				//JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
				if (field_value.equalsIgnoreCase("%TodayDate%")) {
					String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
					System.out.println("The Value of todaydate is :: " + todaydate);
					jse.executeScript("document.getElementById('endDate').value='" + todaydate + "'");
				} else if (field_value.equalsIgnoreCase("%PreviousDate%")) {
					String pastdate = CommonFunctions.pastDate("dd/MM/yyyy", -5);
					System.out.println("The Value of todaydate is :: " + pastdate);
					jse.executeScript("document.getElementById('endDate').value='" + pastdate + "'");
				} else if (field_value.equalsIgnoreCase("%FutureDate%")) {
					String futuredate = CommonFunctions.futureDate("dd/MM/yyyy", 5);
					System.out.println("The Value of todaydate is :: " + futuredate);
					jse.executeScript("document.getElementById('endDate').value='" + futuredate + "'");
				} else {
					jse.executeScript("document.getElementById('endDate').value='" + field_value + "'");
				}
				break;
			}
			case "Disputer Party": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_DisputerParty));
				WebElement DisputerParty = CommonFunctions.driver.findElement(select_DisputerParty);
				Select PartyDisputer = new Select(DisputerParty);
				PartyDisputer.selectByVisibleText(field_value);
				break;
			}
			case "Disputed Party": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_DisputedParty));
				WebElement DisputedParty = CommonFunctions.driver.findElement(select_DisputedParty);
				Select DParty = new Select(DisputedParty);
				DParty.selectByVisibleText(field_value);
				break;
			}
			case "Dispute Status": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_DisputeStatus));
				WebElement DisputeStatus = CommonFunctions.driver.findElement(select_DisputeStatus);
				Select DStatus = new Select(DisputeStatus);
				DStatus.selectByVisibleText(field_value);
				break;
			}
			default:
				Assert.fail("Required field " + field_name + " is not available in feature file");
			}
		}

		// Page Name :: Billed Amount
		
		else if (page.equalsIgnoreCase("Billed Amount")) {
			switch (field_name) {
			case "Start Date": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_StartDate));
				//JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
				if (field_value.equalsIgnoreCase("%TodayDate%")) {
					String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
					System.out.println("The Value of todaydate is :: " + todaydate);
					jse.executeScript("document.getElementById('startDate').value='" + todaydate + "'");
				} else if (field_value.equalsIgnoreCase("%PreviousDate%")) {
					String pastdate = CommonFunctions.pastDate("dd/MM/yyyy", -5);
					System.out.println("The Value of todaydate is :: " + pastdate);
					jse.executeScript("document.getElementById('startDate').value='" + pastdate + "'");
				} else if (field_value.equalsIgnoreCase("%FutureDate%")) {
					String futuredate = CommonFunctions.futureDate("dd/MM/yyyy", 5);
					System.out.println("The Value of todaydate is :: " + futuredate);
					jse.executeScript("document.getElementById('startDate').value='" + futuredate + "'");
				} else {
					jse.executeScript("document.getElementById('startDate').value='" + field_value + "'");
				}
				break;
			}
			case "End Date": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_EndDate));
				//JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
				if (field_value.equalsIgnoreCase("%TodayDate%")) {
					String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
					System.out.println("The Value of todaydate is :: " + todaydate);
					jse.executeScript("document.getElementById('endDate').value='" + todaydate + "'");
				} else if (field_value.equalsIgnoreCase("%PreviousDate%")) {
					String pastdate = CommonFunctions.pastDate("dd/MM/yyyy", -5);
					System.out.println("The Value of todaydate is :: " + pastdate);
					jse.executeScript("document.getElementById('endDate').value='" + pastdate + "'");
				} else if (field_value.equalsIgnoreCase("%FutureDate%")) {
					String futuredate = CommonFunctions.futureDate("dd/MM/yyyy", 5);
					System.out.println("The Value of todaydate is :: " + futuredate);
					jse.executeScript("document.getElementById('endDate').value='" + futuredate + "'");
				} else {
					jse.executeScript("document.getElementById('endDate').value='" + field_value + "'");
				}
				break;
			}
			default:
				Assert.fail("Required field " + field_name + " is not available in feature file");
			}
		}
		
		// Page Name :: Retrieve Settlement Summary
		
		else if (page.equalsIgnoreCase("Retrieve Settlement Cycle Summary")) {
			switch (field_name) {
			case "Currency ISO Code": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_currencyIsoCode));
				WebElement currencyIsoCode = CommonFunctions.driver.findElement(select_currencyIsoCode);
				Select ScurrencyIsoCode = new Select(currencyIsoCode);
				ScurrencyIsoCode.selectByVisibleText(field_value);
				break;
				}
			case "Settlement Date": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_SettlementDate));
				//JavascriptExecutor jse =  (JavascriptExecutor)CommonFunctions.driver;
				if(field_value.equalsIgnoreCase("%TodayDate%"))
				{
					String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
					System.out.println("The Value of todaydate is :: "+todaydate);
					//CommonFunctions.driver.findElement(input_SettlementDate).sendKeys(Keys.ENTER);
					//jse.executeScript("document.getElementById('settlementCycleDate').value='"+todaydate+"'");
					CommonFunctions.driver.findElement(input_SettlementDate).click();
					CommonFunctions.datepicker(todaydate);
				}
				else if(field_value.equalsIgnoreCase("%PreviousDate%"))
				{
					String pastdate = CommonFunctions.pastDate("dd/MM/yyyy",-5);
					System.out.println("The Value of PreviousDate is :: "+pastdate);
					//CommonFunctions.driver.findElement(input_SettlementDate).sendKeys(Keys.ENTER);
					//jse.executeScript("document.getElementById('settlementCycleDate').value='"+pastdate+"'");
					CommonFunctions.driver.findElement(input_SettlementDate).click();
					CommonFunctions.datepicker(pastdate);
				}
				else if(field_value.equalsIgnoreCase("%FutureDate%"))
				{
					String futuredate = CommonFunctions.futureDate("dd/MM/yyyy",5);
					System.out.println("The Value of futuredate is :: "+futuredate);
					//CommonFunctions.driver.findElement(input_SettlementDate).sendKeys(Keys.ENTER);
					//jse.executeScript("document.getElementById('settlementCycleDate').value='"+futuredate+"'");
					CommonFunctions.driver.findElement(input_SettlementDate).click();
					CommonFunctions.datepicker(futuredate);
				}
				else
				{
					//CommonFunctions.driver.findElement(input_SettlementDate).sendKeys(Keys.ENTER);
					//jse.executeScript("document.getElementById('settlementCycleDate').value='"+field_value+"'");
					CommonFunctions.driver.findElement(input_SettlementDate).click();
					CommonFunctions.datepicker(field_value);
				}
				break;
				}
			case "Settlement Cycle ID": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_settlementCycleId));
				WebElement settlementCycle = CommonFunctions.driver.findElement(select_settlementCycleId);
				Select SsettlementCycle = new Select(settlementCycle);
				SsettlementCycle.selectByVisibleText(field_value);
				break;
				}
			default:
				Assert.fail("Required field " + field_name + " is not available in feature file");
			}
		}
		
		// Page Name :: Registration Enquiries
		
		else if (page.equalsIgnoreCase("Registration Enquiries")) {
			switch (field_name) {
			case "Registration Enquiries": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_EnquiryMPP));
				WebElement EnquiryMPP = CommonFunctions.driver.findElement(select_EnquiryMPP);
				Select REnquiry = new Select(EnquiryMPP);
				REnquiry.selectByVisibleText(field_value);
				break;
			}
			case "Registration ID": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_RegistrationId));
				CommonFunctions.driver.findElement(input_RegistrationId).sendKeys(field_value);
				break;
			}
			default:
				Assert.fail("Required field " + field_name + " is not available in feature file");
			}
		} 
		
		else {
			Assert.fail("Required page " + page + " is not defined in library functions");
		}
// End here 
	}
	
	/**
	 * Function to generate the custom report.
	 * @throws InterruptedException
	 */
	public static void generateCustomReport() throws InterruptedException {
		System.out.println("Start generating HTML report folder");
		File reportOutputDirectory = new File("target");
		String dir = System.getProperty("user.dir");
		List<String> jsonFiles = new ArrayList<>();
		String jsonpath = dir+ "\\target\\Cucumber-Report\\cucumber.json";
		System.out.println("Path of json file is :: "+jsonpath);
		jsonFiles.add(jsonpath);
	//	jsonFiles.add(
	//			"C:\\SAMA-ACH\\achworkspace\\sama-ach-portal-tests-automation\\ach-cucumber-portal-poc\\target\\Cucumber-Report\\cucumber.json");
		
		String buildNumber = "1";
		String projectName = "SAMA ACH PORTAL";
		// boolean runWithJenkins = true;


		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		// optional configuration - check javadoc
		// configuration.setRunWithJenkins(runWithJenkins);
		configuration.setBuildNumber(buildNumber);
		

		// additional metadata presented on main page
		configuration.addClassifications("Operating System", System.getProperty("os.name"));
		configuration.addClassifications("Browser", EnquiryStepDefinitions.browser);
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
	
	/**
	 * Function to select value from drop down list
	 * @param value
	 * @param label
	 * @param page
	 */
	public static void dropdownSelection(String value, String label, String page) {
		if (label.equalsIgnoreCase("Registration Enquiries")) {
			WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(select_EnquiryMPP));
			WebElement enquiryMPP = CommonFunctions.driver.findElement(select_EnquiryMPP);
			Select senquiryMPP = new Select(enquiryMPP);
			senquiryMPP.selectByVisibleText(value);
		}
	}

	/**
	 * Function to Validate the result table availability
	 * @param pagename
	 */
	
	public static void verifyResultTableAvailability(String pagename)

	{
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 15);
		if (pagename.equalsIgnoreCase("Value Transaction Enquiry") && EnquiryStepDefinitions.radiobutton.equalsIgnoreCase("Today")) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(tbl_TodayResults));
			} catch (TimeoutException e) {
				EnquiryStepDefinitions.radiobutton="";
				Assert.fail("Result table is not getting displayed for " + pagename + "");
			}
		}

		else if (pagename.equalsIgnoreCase("View Settlement Cycle Calendar")) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(tbl_ViewSettlementCalendar));
			} catch (TimeoutException e) {
				Assert.fail("Result table is not getting displayed for " + pagename + "");
			}
		} else if (pagename.equalsIgnoreCase("Retrieve Settlement Cycle Summary")) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(tbl_RetrieveSettlementSummary));
			} catch (TimeoutException e) {
				Assert.fail("Result table is not getting displayed for " + pagename + "");
			}
		} else if (pagename.equalsIgnoreCase("Retrieve Participant SNM")) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(tbl_ParticipantSNM));
			} catch (TimeoutException e) {
				Assert.fail("Result table is not getting displayed for " + pagename + "");
			}
		} else {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(tbl_Results));
			} catch (TimeoutException e) {
				Assert.fail("Result table is not getting displayed for " + pagename + "");
			}
		}
	}
	
	/***
	 * Function for pagination 
	 * @return
	 */
	
	public static int paginationInfo(String pagename) {
		String pagination_Info = "";
		if (pagename.equalsIgnoreCase("Participant Position")) {
			pagination_Info = CommonFunctions.driver.findElement(pp_Pagination_info).getAttribute("textContent").trim();
//			String pagination_Info1 = CommonFunctions.driver.findElement(pp_Pagination_info).getAttribute("value");
//			String pagination_Info2 = CommonFunctions.driver.findElement(pp_Pagination_info).getAttribute("textContent");
//			String pagination_Info3 = CommonFunctions.driver.findElement(pp_Pagination_info).getAttribute("innerHTML");
//			String pagination_Info4 = CommonFunctions.driver.findElement(pp_Pagination_info).getAttribute("innerText");
			System.out.println("The value of Pagination info is :: " + pagination_Info);
		} else if (pagename.equalsIgnoreCase("Participant Unable to Transact")) {
			pagination_Info = CommonFunctions.driver.findElement(put_Pagination_info).getAttribute("innerHTML").trim();
			System.out.println("The value of Pagination info is :: " + pagination_Info);
		} else if (pagename.equalsIgnoreCase("Value Transaction Enquiry") && EnquiryStepDefinitions.radiobutton.equalsIgnoreCase("Today")) {
			pagination_Info = CommonFunctions.driver.findElement(vte_today_Pagination_info).getAttribute("innerText").trim();
			System.out.println("The value of Pagination info is :: " + pagination_Info);
		} else if (pagename.equalsIgnoreCase("Value Transaction Enquiry")) {
			pagination_Info = CommonFunctions.driver.findElement(vte_Pagination_info).getAttribute("innerText").trim();
			System.out.println("The value of Pagination info is :: " + pagination_Info);
		} else if (pagename.equalsIgnoreCase("View Settlement Cycle Calendar")) {
			pagination_Info = CommonFunctions.driver.findElement(vsc_Pagination_info).getAttribute("textContent").trim();
			System.out.println("The value of Pagination info is :: " + pagination_Info);
		} else if (pagename.equalsIgnoreCase("Retrieve Settlement Cycle Summary")) {
			pagination_Info = CommonFunctions.driver.findElement(rss_Pagination_info).getAttribute("textContent").trim();
			System.out.println("The value of Pagination info is :: " + pagination_Info);
		} else if (pagename.equalsIgnoreCase("Retrieve Participant SNM")) {
			pagination_Info = CommonFunctions.driver.findElement(rps_Pagination_info).getAttribute("textContent").trim();
		} else if (pagename.equalsIgnoreCase("Settlement Cycle Status")) {
			pagination_Info = CommonFunctions.driver.findElement(scs_Pagination_info).getAttribute("textContent").trim();
		} else if (pagename.equalsIgnoreCase("Retrieve Participant Status (Single Participant)")) {
			pagination_Info = CommonFunctions.driver.findElement(rps_Pagination_info).getAttribute("textContent").trim();
		} else if (pagename.equalsIgnoreCase("Participant Settlement Positions")) {
			pagination_Info = CommonFunctions.driver.findElement(psp_Pagination_info).getAttribute("textContent").trim();
		} else if (pagename.equalsIgnoreCase("Retrieve Settlement Cycle Details - Current & Previous")) {
			pagination_Info = CommonFunctions.driver.findElement(rscd_Pagination_info).getAttribute("textContent").trim();
		}else if (pagename.equalsIgnoreCase("Dispute Details")) {
			pagination_Info = CommonFunctions.driver.findElement(dd_Pagination_info).getAttribute("textContent").trim();
		}else if (pagename.equalsIgnoreCase("Registration Enquiries")) {
			pagination_Info = CommonFunctions.driver.findElement(mre_Pagination_info).getAttribute("textContent").trim();
		}else {
			try {
				pagination_Info = CommonFunctions.driver.findElement(results_Pagination_info).getAttribute("textContent").trim();
				System.out.println("The value of Pagination info is :: " + pagination_Info);
			} catch (Exception e) {
				Assert.fail("Page " + pagename + " is not found");
			}
		}		
		if (!pagination_Info.isEmpty()) {
			//System.out.println("The value of pagination info is :: " + pagination_Info);
			String str[] = pagination_Info.split(" ");
			int pagecount;
			try {pagecount = Integer.parseInt(str[2]);}
			catch(NumberFormatException e) {
			pagecount = Integer.parseInt(str[3]);
			}
			//System.out.println("The value of pagecount is :: " + pagecount);
			return pagecount;
		} else {
			System.out.println("No Records found");
			return 0;
		}
	}
	
	/**
	 * Function to click on Pagination Next Link
	 * @param pagename
	 */
	
	public static void paginationClick(String pagename) {

		CommonFunctions.driver.findElement(link_next).click();
	}
	public static void selectParticipant(String participantName)
	{
		WebElement participant = CommonFunctions.driver.findElement(select_PartcipantSelection);
		Select selectparticipant = new Select(participant);
		try {selectparticipant.selectByVisibleText(participantName);}
		catch(Exception e)
		{
			e.getMessage();
			Assert.fail(participantName +" is not available in Participant drop down List");
		}
	}
	public static void participantSelection(String participantName)
	{
		WebElement participant = CommonFunctions.driver.findElement(select_PartcipantID);
		Select selectparticipant = new Select(participant);
		try {selectparticipant.selectByVisibleText(participantName);}
		catch(Exception e)
		{
			e.getMessage();
			Assert.fail(participantName +" is not available in Participant drop down List");
		}
	}
	/**
     * Returns the latest file
     * @param _filepath_
     * @return File
     */
    public static File getLatestFile(String _filepath_,String filePrefix) {
        /*if(_filepath_.endsWith("\\"))
            _filepath_ = _filepath_.substring(0, _filepath_.length()-1);*/
        File dir = new File(_filepath_);
        File max = null;
        for (File file : dir.listFiles()) {
            if (file.getName().startsWith(filePrefix)&&(max == null || max.lastModified() < file.lastModified())) {
                //System.out.println("Debug");
                max = file;
            }
        }
        System.out.println("The latest file is :: " + max.getPath());
        return max;
    }	
//End here
}
