package com.sama.ach.cucumber.reports.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sama.ach.cucumber.poc.utils.CommonFunctions;
import com.sama.ach.cucumber.reports.page.ref.ReportsPageRef;
import com.sama.ach.cucumber.reports.stepdefs.ReportsStepDefinitions;
import au.com.bytecode.opencsv.CSVReader;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class ReportsLib implements ReportsPageRef {
	

	public static String reportname;
	public static String filename;
	public static String reportgeneratedtime;
	public static int reportID;
	public static String participant = "SAALBI";
	public static String requestedreport_filename;
	public static String requestedreport_startdate;
	public static String requestedreport_enddate;
	public static String requestedreport_LocalInstrument;
	public static String requestedreport_CategoryPurposeCode;
	
	/**
	 * This function has been written to navigate pages inside Portal application
	 * @param pageName
	 * @param navigation
	 * @param row
	 * @throws InterruptedException
	 */
	
	public static void menuNavigation(String pageName, String navigation, int row) throws InterruptedException {
		
		WebDriverWait  wait = new WebDriverWait(CommonFunctions.driver,20);
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
     public static void reportlistvalidation(String reportname) {
    	 switch(reportname) {
    	 
    	 case "Scheduled Reports":{
    		 
    		ArrayList<String> actreportlist = new ArrayList<String>(); 
    		WebElement obj = CommonFunctions.driver.findElement(select_ReportType);
    		Select s = new Select(obj);
    		List<WebElement> list=s.getOptions();
    		CommonFunctions.driver.findElement(select_ReportType).click();
    		for (int i = 0; i < list.size(); i++) {
    			String report = list.get(i).getText().trim();
    			System.out.println("The Value of report is :: "+report.trim());
    			if(!report.equalsIgnoreCase("Select a Report"))
    			{
    			actreportlist.add(report);
    			}
    		}
    		Collections.sort(actreportlist);
    		boolean flag =ReportsStepDefinitions.reportlisttype.equals(actreportlist);
    		System.out.println("    Values in Feature File :: "+ReportsStepDefinitions.reportlisttype);
    		System.out.println("Values in "+reportname+" dropdown list :: " +actreportlist);
    		Assert.assertEquals("Dropdown list values in feature file does not match with actual list", true, flag);
    		 break;
    		 
    	 }
    	 
    	 }
     }
	/**
	 * Function to click the visible button
	 * @param buttonname
	 * @param pageName
	 * @throws Exception
	 */
		
	public static void clickButton(String buttonName, String pageName) throws Exception {
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 30);
		if (pageName.equalsIgnoreCase("Scheduled Reports") || pageName.equalsIgnoreCase("Reject Report")
				|| pageName.equalsIgnoreCase("Requested Reports") || pageName.equalsIgnoreCase("Request a Report")) {
			switch (buttonName) {
			case "Select":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Select));
				CommonFunctions.driver.findElement(btn_Select).click();
				break;
			case "Download":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Download));
				CommonFunctions.driver.findElement(btn_Download).click();
				break;
			case "Submit":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_RR_Submit));
				CommonFunctions.driver.findElement(btn_RR_Submit).click();
				break;
			case "Clear Screen":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_RR_ClearScreen));
				CommonFunctions.driver.findElement(btn_RR_ClearScreen).click();
				break;
			default:
				Assert.fail(" Button " + buttonName + " has not been found");
			}
		}

		else if (pageName.equalsIgnoreCase("Payment Volume Value Report")) {
			switch (buttonName) {
			case "Select":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Select));
				CommonFunctions.driver.findElement(btn_Select).click();
				break;
			case "Download":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Download));
				CommonFunctions.driver.findElement(btn_Download).click();
				break;
			case "Submit":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_PVV_Submit));
				CommonFunctions.driver.findElement(btn_PVV_Submit).click();
				break;
			case "Clear Screen":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_PVV_ClearScreen));
				CommonFunctions.driver.findElement(btn_PVV_ClearScreen).click();
				break;
			default:
				Assert.fail(" Button " + buttonName + " has not been found");
			}
		} else if (pageName.equalsIgnoreCase("Participant Performance Report")) {
			switch (buttonName) {
			case "Select":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Select));
				CommonFunctions.driver.findElement(btn_Select).click();
				break;
			case "Download":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Download));
				CommonFunctions.driver.findElement(btn_Download).click();
				break;
			case "Submit":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_PP_Submit));
				CommonFunctions.driver.findElement(btn_PP_Submit).click();
				break;
			case "Clear Screen":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_PP_ClearScreen));
				CommonFunctions.driver.findElement(btn_PP_ClearScreen).click();
				break;
			default:
				Assert.fail(" Button " + buttonName + " has not been found");
			}
		} else if (pageName.equalsIgnoreCase("Routing File")) {
			switch (buttonName) {
			case "Select":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Select));
				CommonFunctions.driver.findElement(btn_Select).click();
				break;
			case "Download":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Download));
				CommonFunctions.driver.findElement(btn_Download).click();
				break;
			case "Submit":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_RF_Submit));
				CommonFunctions.driver.findElement(btn_RF_Submit).click();
				break;
			case "Clear Screen":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_RF_ClearScreen));
				CommonFunctions.driver.findElement(btn_RF_ClearScreen).click();
				break;
			default:
				Assert.fail(" Button " + buttonName + " has not been found");
			}
		} else if (pageName.equalsIgnoreCase("Participant Settlement Report")) {
			switch (buttonName) {
			case "Select":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Select));
				CommonFunctions.driver.findElement(btn_Select).click();
				break;
			case "Download":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Download));
				CommonFunctions.driver.findElement(btn_Download).click();
				break;
			case "Submit":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_PSR_Submit));
				CommonFunctions.driver.findElement(btn_PSR_Submit).click();
				break;
			case "Clear Screen":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_PSR_ClearScreen));
				CommonFunctions.driver.findElement(btn_PSR_ClearScreen).click();
				break;
			default:
				Assert.fail(" Button " + buttonName + " has not been found");
			}
		}else {
			Assert.fail("Required page " + pageName + " is not defined in library functions");
		}
	}

		
		/**
		 * Function to select value from drop down list	
		 * @param value
		 * @param label
		 * @param page
		 */

			public static void dropdownSelection(String value, String label, String page) {
				WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 10);
				if (label.equalsIgnoreCase("Scheduled Reports") || label.equalsIgnoreCase("Request a Report") || label.equalsIgnoreCase("Requested Reports")) {
					reportname=value;
					System.out.println("");				
					wait.until(ExpectedConditions.visibilityOfElementLocated(select_ReportType));
					WebElement disputeStatus = CommonFunctions.driver.findElement(select_ReportType);
					Select sdisputeStatus = new Select(disputeStatus);
					try {
					sdisputeStatus.selectByVisibleText(value);
					System.out.println("The Selected drop down value is "+reportname);
					}
					catch(Exception e)
					{
						Assert.fail(value+ "is not available under "+label);
					}
				}
				else {
					Assert.fail(label+" is missing");
				}
			}

			/**
			 * Function to validate GUI Items
			 * @param item
			 * @param name
			 * @param value
			 */
			public static void validateGUIItems(String reportpagename, String item, String name, String value) {
				WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 30);
				if (reportpagename.equalsIgnoreCase("Reject Report")) {
					boolean flag;
					switch (name) {
					case "Participant ID":
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(str_RR_GUILable,name))));
						flag = CommonFunctions.driver.findElement(By.xpath(String.format(str_RR_GUILable,name))).isDisplayed();
						Assert.assertEquals("Label " + name + " is not displayed", true, flag);
						break;
					case "Start Date":
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(str_RR_GUILable,name))));
						flag = CommonFunctions.driver.findElement(By.xpath(String.format(str_RR_GUILable,name))).isDisplayed();
						Assert.assertEquals("Label " + name + " is not displayed", true, flag);
						break;
					case "End Date":
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(str_RR_GUILable,name))));
						flag = CommonFunctions.driver.findElement(By.xpath(String.format(str_RR_GUILable,name))).isDisplayed();
						Assert.assertEquals("Label " + name + " is not displayed", true, flag);
						break;
					case "Local Instrument":
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(str_RR_GUILable,name))));
						flag = CommonFunctions.driver.findElement(By.xpath(String.format(str_RR_GUILable,name))).isDisplayed();
						Assert.assertEquals("Label " + name + " is not displayed", true, flag);
						break;
					case "Content Format":
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(str_RR_GUILable,name))));
						flag = CommonFunctions.driver.findElement(By.xpath(String.format(str_RR_GUILable,name))).isDisplayed();
						Assert.assertEquals("Label " + name + " is not displayed", true, flag);
						break;
					case "Category Purpose Code":
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(str_RR_GUILable,name))));
						flag = CommonFunctions.driver.findElement(By.xpath(String.format(str_RR_GUILable,name))).isDisplayed();
						Assert.assertEquals("Label " + name + " is not displayed", true, flag);
						break;
					case "Submit":
						wait.until(ExpectedConditions.visibilityOfElementLocated(btn_RR_ClearScreen));
						flag = CommonFunctions.driver.findElement(btn_RR_ClearScreen).isEnabled();
						Assert.assertEquals("Button " + name + " is not enabled", true, flag);
						break;
					case "Clear Screen":
						wait.until(ExpectedConditions.visibilityOfElementLocated(btn_RR_ClearScreen));
						flag = CommonFunctions.driver.findElement(btn_RR_ClearScreen).isEnabled();
						Assert.assertEquals("Button " + name + " is not enabled", true, flag);
						break;
					default:
						Assert.fail("" + name + " GUI item has not been found");

					}
				} 
				else if (reportpagename.equalsIgnoreCase("Payment Volume Value Report")) {
					boolean flag;
					switch (name) {
					case "Participant ID":
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(str_PVV_GUILable,name))));
						flag = CommonFunctions.driver.findElement(By.xpath(String.format(str_PVV_GUILable,name))).isDisplayed();
						Assert.assertEquals("Label " + name + " is not displayed", true, flag);
						break;
					case "Start Date":
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(str_PVV_GUILable,name))));
						flag = CommonFunctions.driver.findElement(By.xpath(String.format(str_PVV_GUILable,name))).isDisplayed();
						Assert.assertEquals("Label " + name + " is not displayed", true, flag);
						break;
					case "End Date":
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(str_PVV_GUILable,name))));
						flag = CommonFunctions.driver.findElement(By.xpath(String.format(str_PVV_GUILable,name))).isDisplayed();
						Assert.assertEquals("Label " + name + " is not displayed", true, flag);
						break;
					case "Local Instrument":
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(str_PVV_GUILable,name))));
						flag = CommonFunctions.driver.findElement(By.xpath(String.format(str_PVV_GUILable,name))).isDisplayed();
						Assert.assertEquals("Label " + name + " is not displayed", true, flag);
						break;
					case "Content Format":
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(str_PVV_GUILable,name))));
						flag = CommonFunctions.driver.findElement(By.xpath(String.format(str_PVV_GUILable,name))).isDisplayed();
						Assert.assertEquals("Label " + name + " is not displayed", true, flag);
						break;
					case "Category Purpose Code":
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(str_PVV_GUILable,name))));
						flag = CommonFunctions.driver.findElement(By.xpath(String.format(str_PVV_GUILable,name))).isDisplayed();
						Assert.assertEquals("Label " + name + " is not displayed", true, flag);
						break;
					case "Submit":
						wait.until(ExpectedConditions.visibilityOfElementLocated(btn_PVV_ClearScreen));
						flag = CommonFunctions.driver.findElement(btn_PVV_ClearScreen).isEnabled();
						Assert.assertEquals("Button " + name + " is not enabled", true, flag);
						break;
					case "Clear Screen":
						wait.until(ExpectedConditions.visibilityOfElementLocated(btn_PVV_ClearScreen));
						flag = CommonFunctions.driver.findElement(btn_PVV_ClearScreen).isEnabled();
						Assert.assertEquals("Button " + name + " is not enabled", true, flag);
						break;
					default:
						Assert.fail("" + name + " GUI item has not been found");

					}
				}
				else if (reportpagename.equalsIgnoreCase("Participant Performance Report")) {
					boolean flag;
					switch (name) {
					case "Participant ID":
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(str_PP_GUILable,name))));
						flag = CommonFunctions.driver.findElement(By.xpath(String.format(str_PP_GUILable,name))).isDisplayed();
						Assert.assertEquals("Label " + name + " is not displayed", true, flag);
						break;
					case "Report Date":
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(str_PP_GUILable,name))));
						flag = CommonFunctions.driver.findElement(By.xpath(String.format(str_PP_GUILable,name))).isDisplayed();
						Assert.assertEquals("Label " + name + " is not displayed", true, flag);
						break;					
					case "Content Format":
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(str_PP_GUILable,name))));
						flag = CommonFunctions.driver.findElement(By.xpath(String.format(str_PP_GUILable,name))).isDisplayed();
						Assert.assertEquals("Label " + name + " is not displayed", true, flag);
						break;
					case "Submit":
						wait.until(ExpectedConditions.visibilityOfElementLocated(btn_PP_ClearScreen));
						flag = CommonFunctions.driver.findElement(btn_PP_ClearScreen).isEnabled();
						Assert.assertEquals("Button " + name + " is not enabled", true, flag);
						break;
					case "Clear Screen":
						wait.until(ExpectedConditions.visibilityOfElementLocated(btn_PP_ClearScreen));
						flag = CommonFunctions.driver.findElement(btn_PP_ClearScreen).isEnabled();
						Assert.assertEquals("Button " + name + " is not enabled", true, flag);
						break;
					default:
						Assert.fail("" + name + " GUI item has not been found");

					}
				}
				else if (reportpagename.equalsIgnoreCase("Routing File")) {
					boolean flag;
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(str_RF_GUILable,name))));
					flag = CommonFunctions.driver.findElement(By.xpath(String.format(str_RF_GUILable,name))).isDisplayed();
					Assert.assertEquals("GUI item " + name + " is not displayed under Routing File page", true, flag);
					
				}
				else if (reportpagename.equalsIgnoreCase("Participant Settlement Report")) {
					boolean flag;
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(str_PSR_GUILable,name))));
					flag = CommonFunctions.driver.findElement(By.xpath(String.format(str_PSR_GUILable,name))).isDisplayed();
					Assert.assertEquals("GUI item " + name + " is not displayed under "+reportpagename+" page", true, flag);
					
				}
				else {
					Assert.fail("Required page " + reportpagename + " is not defined in library functions");
				}
			

			}
			
			
			/**
			 * This function is used to enter values in input fields for any specific page.
			 * @param page
			 * @param field_name
			 * @param field_value
			 * @throws InterruptedException
			 */
			public static void enterValues(String page, String field_name, String field_value)
					throws InterruptedException

			{
				WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 15);
				// Page Name :: View Settlement Calendar

				if (page.equalsIgnoreCase("Reject Report")) {
					JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
					switch (field_name) {				
					case "Start Date": {
						wait.until(ExpectedConditions.visibilityOfElementLocated(input_RR_startDate));
						//JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
						if (field_value.equalsIgnoreCase("%TodayDate%")) {
							String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
							System.out.println("The Value of todaydate is :: " + todaydate);
							requestedreport_startdate=todaydate;
							jse.executeScript("document.getElementById('rrStartDate')'.value='" + todaydate + "'");
						} else if (field_value.equalsIgnoreCase("%PreviousDate%")) {
							String pastdate = CommonFunctions.pastDate("dd/MM/yyyy", -5);
							System.out.println("The Value of past date is :: " + pastdate);
							requestedreport_startdate=pastdate;
							jse.executeScript("document.getElementById('rrStartDate').value='" + pastdate + "'");
						} else if (field_value.equalsIgnoreCase("%FutureDate%")) {
							String futuredate = CommonFunctions.futureDate("dd/MM/yyyy", 5);
							System.out.println("The Value of future date is :: " + futuredate);
							requestedreport_startdate=futuredate;
							jse.executeScript("document.getElementById('rrStartDate').value='" + futuredate + "'");

						} else {
							jse.executeScript("document.getElementById('rrStartDate').value='" + field_value + "'");
							requestedreport_startdate=field_value;
						}
						System.out.println("The Value of requestedreport_startdate for "+page+" is :: " + requestedreport_startdate);
						break;
					}
					case "End Date": {
						wait.until(ExpectedConditions.visibilityOfElementLocated(input_RR_endDate));
						//JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
						if (field_value.equalsIgnoreCase("%TodayDate%")) {
							String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
							System.out.println("The Value of todaydate is :: " + todaydate);
							requestedreport_enddate=todaydate;
							jse.executeScript("document.getElementById('rrEndDate').value='" + todaydate + "'");
						} else if (field_value.equalsIgnoreCase("%PreviousDate%")) {
							String pastdate = CommonFunctions.pastDate("dd/MM/yyyy", -5);
							System.out.println("The Value of past date is :: " + pastdate);
							requestedreport_enddate=pastdate;
							jse.executeScript("document.getElementById('rrEndDate').value='" + pastdate + "'");
						} else if (field_value.equalsIgnoreCase("%FutureDate%")) {
							String futuredate = CommonFunctions.futureDate("dd/MM/yyyy", 5);
							System.out.println("The Value of  future date is :: " + futuredate);
							requestedreport_enddate=futuredate;
							jse.executeScript("document.getElementById('rrEndDate').value='" + futuredate + "'");
						} else {
							jse.executeScript("document.getElementById('rrEndDate').value='" + field_value + "'");
							requestedreport_enddate=field_value;
						}
						System.out.println("The Value of requestedreport_enddate for "+page+" is :: " + requestedreport_enddate);
						break;
					}
					case "Local Instrument": {
						wait.until(ExpectedConditions.visibilityOfElementLocated(select_RR_LocalInstrument));
						WebElement LocalInstrument = CommonFunctions.driver.findElement(select_RR_LocalInstrument);
						Select SLocalInstrument = new Select(LocalInstrument);
						SLocalInstrument.selectByVisibleText(field_value);
						requestedreport_LocalInstrument=field_value;
						System.out.println("The Value of requestedreport_LocalInstrument for "+page+" is :: " + requestedreport_LocalInstrument);
						break;
						}
					case "Content Format": {
						wait.until(ExpectedConditions.visibilityOfElementLocated(select_RR_ContentFormat));
						WebElement ContentFormat = CommonFunctions.driver.findElement(select_RR_ContentFormat);
						Select SContentFormat = new Select(ContentFormat);
						SContentFormat.selectByVisibleText(field_value);
						break;
						}
					case "Category Purpose Code": {
						wait.until(ExpectedConditions.visibilityOfElementLocated(select_RR_CategoryCode));
						WebElement CategoryPurposeCode = CommonFunctions.driver.findElement(select_RR_CategoryCode);
						Select SCategoryPurposeCode = new Select(CategoryPurposeCode);
						SCategoryPurposeCode.selectByVisibleText(field_value);
						requestedreport_CategoryPurposeCode=field_value;
						System.out.println("The Value of requestedreport_CategoryPurposeCode for "+page+" is :: " + requestedreport_CategoryPurposeCode);
						break;
						}
					default:
						Assert.fail("Required field " + field_name + " is not available in feature file");
					}
				}
				//   Payment Volume Value Report
				else if (page.equalsIgnoreCase("Payment Volume Value Report")) {
					JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
					switch (field_name) {				
					case "Start Date": {
						wait.until(ExpectedConditions.visibilityOfElementLocated(input_PVV_startDate));
						//JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
						if (field_value.equalsIgnoreCase("%TodayDate%")) {
							String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
							System.out.println("The Value of todaydate is :: " + todaydate);
							requestedreport_startdate=todaydate;
							jse.executeScript("document.getElementById('pvvStartDate')'.value='" + todaydate + "'");
						} else if (field_value.equalsIgnoreCase("%PreviousDate%")) {
							String pastdate = CommonFunctions.pastDate("dd/MM/yyyy", -5);
							System.out.println("The Value of past date is :: " + pastdate);
							requestedreport_startdate=pastdate;
							jse.executeScript("document.getElementById('pvvStartDate').value='" + pastdate + "'");
						} else if (field_value.equalsIgnoreCase("%FutureDate%")) {
							String futuredate = CommonFunctions.futureDate("dd/MM/yyyy", 5);
							System.out.println("The Value of future date is :: " + futuredate);
							requestedreport_startdate=futuredate;
							jse.executeScript("document.getElementById('pvvStartDate').value='" + futuredate + "'");

						} else {
							jse.executeScript("document.getElementById('pvvStartDate').value='" + field_value + "'");
							requestedreport_startdate=field_value;
						}
						System.out.println("The Value of requestedreport_startdate for "+page+" is :: " + requestedreport_startdate);
						break;
					}
					case "End Date": {
						wait.until(ExpectedConditions.visibilityOfElementLocated(input_PVV_endDate));
						//JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
						if (field_value.equalsIgnoreCase("%TodayDate%")) {
							String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
							System.out.println("The Value of todaydate is :: " + todaydate);
							requestedreport_enddate=todaydate;
							jse.executeScript("document.getElementById('pvvEndDate').value='" + todaydate + "'");
						} else if (field_value.equalsIgnoreCase("%PreviousDate%")) {
							String pastdate = CommonFunctions.pastDate("dd/MM/yyyy", -5);
							System.out.println("The Value of past date is :: " + pastdate);
							requestedreport_enddate=pastdate;
							jse.executeScript("document.getElementById('pvvEndDate').value='" + pastdate + "'");
						} else if (field_value.equalsIgnoreCase("%FutureDate%")) {
							String futuredate = CommonFunctions.futureDate("dd/MM/yyyy", 5);
							System.out.println("The Value of  future date is :: " + futuredate);
							requestedreport_enddate=futuredate;
							jse.executeScript("document.getElementById('pvvEndDate').value='" + futuredate + "'");
						} else {
							jse.executeScript("document.getElementById('pvvEndDate').value='" + field_value + "'");
							requestedreport_enddate=field_value;
						}
						System.out.println("The Value of requestedreport_enddate for "+page+" is :: " + requestedreport_enddate);
						break;
					}
					case "Local Instrument": {
						wait.until(ExpectedConditions.visibilityOfElementLocated(select_PVV_LocalInstrument));
						WebElement LocalInstrument = CommonFunctions.driver.findElement(select_PVV_LocalInstrument);
						Select SLocalInstrument = new Select(LocalInstrument);
						SLocalInstrument.selectByVisibleText(field_value);
						requestedreport_LocalInstrument=field_value;
						System.out.println("The Value of requestedreport_LocalInstrument for "+page+" is :: " + requestedreport_LocalInstrument);
						break;
						}
					case "Content Format": {
						wait.until(ExpectedConditions.visibilityOfElementLocated(select_PVV_ContentFormat));
						WebElement ContentFormat = CommonFunctions.driver.findElement(select_PVV_ContentFormat);
						Select SContentFormat = new Select(ContentFormat);
						SContentFormat.selectByVisibleText(field_value);
						break;
						}
					case "Category Purpose Code": {
						wait.until(ExpectedConditions.visibilityOfElementLocated(select_PVV_CategoryCode));
						WebElement CategoryPurposeCode = CommonFunctions.driver.findElement(select_PVV_CategoryCode);
						Select SCategoryPurposeCode = new Select(CategoryPurposeCode);
						SCategoryPurposeCode.selectByVisibleText(field_value);
						requestedreport_CategoryPurposeCode=field_value;
						System.out.println("The Value of requestedreport_CategoryPurposeCode for "+page+" is :: " + requestedreport_CategoryPurposeCode);
						break;
						}
					default:
						Assert.fail("Required field " + field_name + " is not available in feature file");
					}
				}
				//  Participant Performance Report
				else if (page.equalsIgnoreCase("Participant Performance Report")) {
					JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
					switch (field_name) {				
					case "Report Date": {
						wait.until(ExpectedConditions.visibilityOfElementLocated(input_PP_reportDate));
						//JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
						if (field_value.equalsIgnoreCase("%TodayDate%")) {
							String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
							System.out.println("The Value of todaydate is :: " + todaydate);
							requestedreport_startdate=todaydate;
							jse.executeScript("document.getElementById('pprReportDate')'.value='" + todaydate + "'");
						} else if (field_value.equalsIgnoreCase("%PreviousDate%")) {
							String pastdate = CommonFunctions.pastDate("dd/MM/yyyy", -5);
							System.out.println("The Value of past date is :: " + pastdate);
							requestedreport_startdate=pastdate;
							jse.executeScript("document.getElementById('pprReportDate').value='" + pastdate + "'");
						} else if (field_value.equalsIgnoreCase("%FutureDate%")) {
							String futuredate = CommonFunctions.futureDate("dd/MM/yyyy", 5);
							System.out.println("The Value of future date is :: " + futuredate);
							requestedreport_startdate=futuredate;
							jse.executeScript("document.getElementById('pprReportDate').value='" + futuredate + "'");

						} else {
							jse.executeScript("document.getElementById('pprReportDate').value='" + field_value + "'");
							requestedreport_startdate=field_value;
						}
						System.out.println("The Value of requestedreport_startdate for "+page+" is :: " + requestedreport_startdate);
						break;
					}					
					case "Content Format": {
						wait.until(ExpectedConditions.visibilityOfElementLocated(select_PP_ContentFormat));
						WebElement ContentFormat = CommonFunctions.driver.findElement(select_PP_ContentFormat);
						Select SContentFormat = new Select(ContentFormat);
						SContentFormat.selectByVisibleText(field_value);
						break;
						}					
					default:
						Assert.fail("Required field " + field_name + " is not available in feature file");
					}
				}
				else if (page.equalsIgnoreCase("Routing File")) {
					JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
					switch (field_name) {				
					case "Date": {
						wait.until(ExpectedConditions.visibilityOfElementLocated(input_RF_Date));
						//JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
						if (field_value.equalsIgnoreCase("%TodayDate%")) {
							String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
							System.out.println("The Value of todaydate is :: " + todaydate);
							requestedreport_startdate=todaydate;
							jse.executeScript("document.getElementById('rfEndDate')'.value='" + todaydate + "'");
						} else if (field_value.equalsIgnoreCase("%PreviousDate%")) {
							String pastdate = CommonFunctions.pastDate("dd/MM/yyyy", -5);
							System.out.println("The Value of past date is :: " + pastdate);
							requestedreport_startdate=pastdate;
							jse.executeScript("document.getElementById('rfEndDate').value='" + pastdate + "'");
						} else if (field_value.equalsIgnoreCase("%FutureDate%")) {
							String futuredate = CommonFunctions.futureDate("dd/MM/yyyy", 5);
							System.out.println("The Value of future date is :: " + futuredate);
							requestedreport_startdate=futuredate;
							jse.executeScript("document.getElementById('rfEndDate').value='" + futuredate + "'");

						} else {
							jse.executeScript("document.getElementById('rfEndDate').value='" + field_value + "'");
							requestedreport_startdate=field_value;
						}
						System.out.println("The Value of requestedreport_startdate for "+page+" is :: " + requestedreport_startdate);
						break;
					}					
					case "Content Format": {
						wait.until(ExpectedConditions.visibilityOfElementLocated(select_RF_ContentFormat));
						WebElement ContentFormat = CommonFunctions.driver.findElement(select_RF_ContentFormat);
						Select SContentFormat = new Select(ContentFormat);
						SContentFormat.selectByVisibleText(field_value);
						break;
						}					
					default:
						Assert.fail("Required field " + field_name + " is not available in feature file");
					}
				}
				//Participant Settlement Report
				else if (page.equalsIgnoreCase("Participant Settlement Report")) {
					JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
					switch (field_name) {				
					case "Settlement Date": {
						wait.until(ExpectedConditions.visibilityOfElementLocated(input_PSR_SettlementDate));
						//JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
						if (field_value.equalsIgnoreCase("%TodayDate%")) {
							String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
							System.out.println("The Value of todaydate is :: " + todaydate);
							requestedreport_startdate=todaydate;
							jse.executeScript("document.getElementById('prrSettlementCycleDate')'.value='" + todaydate + "'");
						} else if (field_value.equalsIgnoreCase("%PreviousDate%")) {
							String pastdate = CommonFunctions.pastDate("dd/MM/yyyy", -5);
							System.out.println("The Value of past date is :: " + pastdate);
							requestedreport_startdate=pastdate;
							jse.executeScript("document.getElementById('prrSettlementCycleDate').value='" + pastdate + "'");
						} else if (field_value.equalsIgnoreCase("%FutureDate%")) {
							String futuredate = CommonFunctions.futureDate("dd/MM/yyyy", 5);
							System.out.println("The Value of future date is :: " + futuredate);
							requestedreport_startdate=futuredate;
							jse.executeScript("document.getElementById('prrSettlementCycleDate').value='" + futuredate + "'");

						} else {
							jse.executeScript("document.getElementById('prrSettlementCycleDate').value='" + field_value + "'");
							requestedreport_startdate=field_value;
						}
						System.out.println("The Value of requestedreport_startdate for "+page+" is :: " + requestedreport_startdate);
						break;
					}					
					case "Settlement Cycle ID": {
						wait.until(ExpectedConditions.visibilityOfElementLocated(select_PSR_SettlementCycleID));
						WebElement ContentFormat = CommonFunctions.driver.findElement(select_PSR_SettlementCycleID);
						Select SContentFormat = new Select(ContentFormat);
						SContentFormat.selectByVisibleText(field_value);
						break;
						}
					case "Currency ISO Code": {
						wait.until(ExpectedConditions.visibilityOfElementLocated(select_PSR_CurrencyCode));
						WebElement ContentCode = CommonFunctions.driver.findElement(select_PSR_CurrencyCode);
						Select SCurrencyCode = new Select(ContentCode);
						SCurrencyCode.selectByVisibleText(field_value);
						break;
						}
					case "Content Format": {
						wait.until(ExpectedConditions.visibilityOfElementLocated(select_PSR_ContentFormat));
						WebElement ContentFormat = CommonFunctions.driver.findElement(select_PSR_ContentFormat);
						Select SContentFormat = new Select(ContentFormat);
						SContentFormat.selectByVisibleText(field_value);
						break;
						}					
					default:
						Assert.fail("Required field " + field_name + " is not available in feature file");
					}
				}
				else {
					Assert.fail("Required page " + page + " is not defined in library functions");
				}
				
			}
			
			/**
			 * Function to Validate the result table availability
			 * @param pagename
			 */
			
	public static void verifyResultTableAvailability(String reportname)

	{
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 5);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(tbl_Results));
		} catch (TimeoutException e) {
			Assert.fail("Result table is not getting displayed for " + reportname + "");
		}
	}
			
			
			/***
			 * Function for pagination 
			 * @return
			 */
			
	public static int paginationInfo(String pagename) {
		String pagination_Info = "";
		try {
			pagination_Info = CommonFunctions.driver.findElement(results_Pagination_info).getAttribute("textContent")
					.trim();
			System.out.println("The value of Pagination info is :: " + pagination_Info);
		} catch (Exception e) {
			Assert.fail("Page " + pagename + " is not found");
		}

		if (!pagination_Info.isEmpty()) {
			System.out.println("The value of pagination info is :: " + pagination_Info);
			String str[] = pagination_Info.split(" ");
			//int pagecount = Integer.parseInt(str[2]);
			int pagecount = Integer.parseInt(str[2]);
			System.out.println("The value of pagecount is :: " + pagecount);
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

			/**
			 * Function to return the column number for the header in output table
			 * @param HeaderName
			 * @return
			 */
	public static int reportResultHeaderMapping(String HeaderName, String reportpagename)

	{
		int tableHeaderIndex, HeaderNameIndex = 0;
		boolean flag = false;
		List<WebElement> HeaderValues;
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(tbl_ReportResultHeader));
		HeaderValues = CommonFunctions.driver.findElements(tbl_ReportResultHeader);

		for (tableHeaderIndex = 0; tableHeaderIndex < HeaderValues.size(); tableHeaderIndex++) {
			String strHeader = HeaderValues.get(tableHeaderIndex).getText();
			// System.out.println("The value of strHeader " + strHeader);
			if (strHeader.equalsIgnoreCase(HeaderName)) {
				flag = true;
				break;
			}
		}
		if (flag == false) {
			Assert.fail("Column " + HeaderName + " is not present in the table under " + reportpagename + " ");
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
	public static void validateResultsTableItems(String reportpagename, String column, String value) {
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 10);
		int columnnumber;
		String ActColumnValue = "";
		wait.until(ExpectedConditions.visibilityOfElementLocated(tbl_ReportResultHeader));
		columnnumber = reportResultHeaderMapping(column, reportpagename);
		ActColumnValue = CommonFunctions.driver.findElement(By.xpath(String.format(strResults, 1, columnnumber)))
				.getText();
		System.out.println(" The runtime value of " + column + " in first row is :  " + ActColumnValue);
		if (column.equalsIgnoreCase("No") && reportpagename.equalsIgnoreCase("Scheduled Reports")) {
			if (ActColumnValue.isEmpty()) {
				Assert.fail(column + " value is empty");
			}
		} 
		else if (column.equalsIgnoreCase("No") && reportpagename.equalsIgnoreCase("Requested Reports")) {
			
			int rowcount =CommonFunctions.driver.findElements(tbl_Results).size();
			int i;
			for(i=1;i<=rowcount;i++)
			{
				String reportId = CommonFunctions.driver.findElement(By.xpath(String.format(strResults, i, columnnumber)))
						.getText();
				if(Integer.parseInt(reportId) == reportID)
				{
					System.out.println("The newly generated report ID "+reportID+" is present at row "+i+" on Requested Reports Page 1 ");
					columnnumber = reportResultHeaderMapping("Reports", reportpagename);
					requestedreport_filename = CommonFunctions.driver.findElement(By.xpath(String.format(strResults, i, columnnumber)))
							.getText();
					break;
				}
			}
			if(i>10)
			{
				CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
				ReportsStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
				Assert.fail("The newly generated report ID "+reportID+" is not present in any row on Requested Reports Page 1");
			}
			
		}
		
		else if (column.equalsIgnoreCase("Reports")) {
			if (reportpagename.equalsIgnoreCase("Requested Reports")) {
				filename = requestedreport_filename;
				System.out.println("The value of Requested Report file name is :: " + filename);
			} else if (reportpagename.equalsIgnoreCase("Scheduled Reports")) {
				if (ActColumnValue.contains(".csv")) {
					filename = ActColumnValue;
					System.out.println("The value of Scheduled Report file name is :: " + filename);
				} else {

					ActColumnValue = CommonFunctions.driver
							.findElement(By.xpath(String.format(strResults, 2, columnnumber))).getText();
					filename = ActColumnValue;
					System.out.println("The value of Scheduled Report file name is :: " + filename);
				}
			} else {
				Assert.fail(reportpagename + " is missing");

			}
			int filenamelength = filename.length();
			// Retrieve file generated time
			String timestring = filename.substring(filenamelength - 12, filenamelength - 4);
			reportgeneratedtime = timestring.replace("_", ":");
			System.out.println("The report generated time for " + filename + " is  :: " + reportgeneratedtime);

			if (reportname.equalsIgnoreCase("Reject Report")) {
				String todaydate = CommonFunctions.currentDate("yyyy_MM_dd");
				System.out.println("The Value of todaydate is :: " + todaydate);
				String actreportname = reportname.replace(" ", "_") + "_" + participant + "_" + todaydate;
				System.out.println("The Value of actreportname is :: " + actreportname);
				if (!(ActColumnValue.startsWith(actreportname) && ActColumnValue.endsWith(".csv"))) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					ReportsStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("The " + reportname + " is not yet generated for " + todaydate + "");
				}
			} else if (reportname.equalsIgnoreCase("Payment Volume Value Report")) {

				String todaydate = CommonFunctions.currentDate("yyyy_MM_dd");
				System.out.println("The Value of todaydate is :: " + todaydate);
				String actreportname = reportname.replace("Payment Volume Value Report",
						"Payment_Volume_and_Value_Report_") + participant + "_" + todaydate;
				System.out.println("The Value of actreportname is :: " + actreportname);
				if (!(ActColumnValue.startsWith(actreportname) && ActColumnValue.endsWith(".csv"))) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					ReportsStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("The " + reportname + " is not yet generated for " + todaydate + "");
				}

			} else if (reportname.equalsIgnoreCase("Routing File")) {

				String todaydate = CommonFunctions.currentDate("yyyy_MM_dd");
				System.out.println("The Value of todaydate is :: " + todaydate);
				String actreportname = reportname.replace(" ", "_") + "_Report_" + todaydate;
				System.out.println("The Value of actreportname is :: " + actreportname);
				if (!(ActColumnValue.startsWith(actreportname) && ActColumnValue.endsWith(".csv"))) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					ReportsStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("The " + reportname + " is not yet generated for " + todaydate + "");
				}

			} else if (reportname.equalsIgnoreCase("Participant Performance Report")) {

				String todaydate = CommonFunctions.currentDate("yyyy_MM_dd");
				System.out.println("The Value of todaydate is :: " + todaydate);
				String actreportname = reportname.replace(" ", "_") + "_" + participant + "_" + todaydate;
				System.out.println("The Value of actreportname is :: " + actreportname);
				// int actreportname_length = actreportname.length();
				// System.out.println("The value of actreportname_length is ::
				// "+actreportname_length);
				// System.out.println("The value of ActColumnValue is :: "+ActColumnValue);
				// String time = ActColumnValue.substring(actreportname_length,
				// actreportname_length+6).trim();
				// System.out.println("The value of time is :: "+time);
				// System.out.println(time.matches("[0-9]{2}[0-9]{2}[0-9]{2}"));
				if (!(ActColumnValue.startsWith(actreportname) && ActColumnValue.endsWith(".csv"))) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					ReportsStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("The " + reportname + " is not yet generated for " + todaydate + "");
				}
			}
			else if (reportname.equalsIgnoreCase("Participant Settlement Report")) {

				String todaydate = CommonFunctions.currentDate("yyyy_MM_dd");
				System.out.println("The Value of todaydate is :: " + todaydate);
				String actreportname = reportname.replace(" ", "_") + "_" + participant + "_" + todaydate;
				System.out.println("The Value of actreportname is :: " + actreportname);
				// int actreportname_length = actreportname.length();
				// System.out.println("The value of actreportname_length is ::
				// "+actreportname_length);
				// System.out.println("The value of ActColumnValue is :: "+ActColumnValue);
				// String time = ActColumnValue.substring(actreportname_length,
				// actreportname_length+6).trim();
				// System.out.println("The value of time is :: "+time);
				// System.out.println(time.matches("[0-9]{2}[0-9]{2}[0-9]{2}"));
				if (!(ActColumnValue.startsWith(actreportname) && ActColumnValue.endsWith(".csv"))) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					ReportsStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("The " + reportname + " is not yet generated for " + todaydate + "");
				}
			}

		} else {
			Assert.fail("The "+reportname+"  is  missing");
		}
	}

/**
 * Download the CSV file
 * @param enquiryPageName
 * @throws IOException
 * @throws InterruptedException
 */
	
	public static void readCSVfile(String reporttitle, String parentreportname, List<String> expCSVcolumnlist) throws IOException, InterruptedException

	{
		String downloadFilepath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\com\\sama\\ach\\cucumber\\downloads\\chrome";

		ArrayList<String> actCSVcolumnlist = new ArrayList<String>();
		Thread.sleep(4000);
		
		//Participant Performance Report
		
		if (reporttitle.equalsIgnoreCase("Participant Performance Report")) {
			CSVReader reader = new CSVReader(new FileReader(downloadFilepath + "\\" + filename));
			String[] reportnamedetails = reader.readNext(); // Read Report name of CSV file
			String reportnamecsv = reportnamedetails[1];
			Assert.assertEquals(reporttitle + " : Report name does not match with downloaded CSV file", reporttitle,
					reportnamecsv);
			String[] reportGeneratedDateTimearr = reader.readNext(); // Read Report Generated Date/Time of CSV file
			String reportGeneratedDateTime = reportGeneratedDateTimearr[1];
			String reportDateTimearr[] = reportGeneratedDateTime.split(" ");
			String reportdatecsv = reportDateTimearr[0].trim();
			String todaydate = CommonFunctions.currentDate("MM-dd-yyyy");
			System.out.println("The Value of todaydate is :: " + todaydate);
			Assert.assertEquals(reporttitle + "  : generated date does not match with downloaded CSV file", todaydate,
					reportdatecsv);

			String[] startDateTimearr = reader.readNext(); // Read Start Date/Time of CSV file
			String startDateTimecsvarr[] = startDateTimearr[1].split(" ");
			String startDateTimecsv = startDateTimecsvarr[0]+" "+startDateTimecsvarr[1];
			System.out.println("value of startDateTimecsv is :: "+startDateTimecsv);
			String previousdate = CommonFunctions.pastDate("yyyy-MM-dd", -1);
			System.out.println("The Value of previous date is :: " + previousdate);
			if (parentreportname.equalsIgnoreCase("Scheduled Reports")) {
				Assert.assertEquals(reporttitle + " Start date name does not match with downloaded CSV file",
						previousdate + " 00:00:00", startDateTimecsv);
			} else if (parentreportname.equalsIgnoreCase("Requested Reports")) {
				Assert.assertEquals(reporttitle + " Start date name does not match with downloaded CSV file",
						requestedreport_startdate + " 00:00:00", startDateTimecsv);
			} else {
				Assert.fail(parentreportname + " is missing.");
			}

			String[] endDateTimearr = reader.readNext(); // Read End Date/Time of CSV file
			String endDateTimecsvarr[] = endDateTimearr[1].split(" ");
			String endDateTimecsv = endDateTimecsvarr[0]+" "+endDateTimecsvarr[1];
			System.out.println("value of endDateTimecsv is :: "+endDateTimecsv);			
			if (parentreportname.equalsIgnoreCase("Scheduled Reports")) {
				Assert.assertEquals(reporttitle + " End date name does not match with downloaded CSV file",
						previousdate + " 23:59:59", endDateTimecsv);
			} else if (parentreportname.equalsIgnoreCase("Requested Reports")) {
				Assert.assertEquals(reporttitle + " End date name does not match with downloaded CSV file",
						requestedreport_startdate+ " 23:59:59", endDateTimecsv);
			} else {
				Assert.fail(parentreportname + " is missing.");
			}
			
			reader.readNext();         //    Blank Line
				
			String[] actCSVcolumnlistarr = reader.readNext();   //   Read Column names
				for(String column : actCSVcolumnlistarr)
				{
					actCSVcolumnlist.add(column);
				}
			//	System.out.println("actCSVcolumnlist is :: "+actCSVcolumnlist);
      
				boolean flag = actCSVcolumnlist.equals(expCSVcolumnlist);
			System.out.println("    Columns in CSV File :: " + actCSVcolumnlist);
			System.out.println("Columns in Feature File :: " + expCSVcolumnlist);
			Assert.assertEquals("Results table columns name does not match with downloaded CSV file", true, flag);
			reader.close();
		}
		
		// Routing File Report
		else if (reporttitle.equalsIgnoreCase("Routing File")) {
			CSVReader reader = new CSVReader(new FileReader(downloadFilepath + "\\" + filename));
			String[] reportnamedetails = reader.readNext(); // Read Report name of CSV file
			String reportnamecsv = reportnamedetails[1];
			Assert.assertEquals(reporttitle + " : Report name does not match with downloaded CSV file", reporttitle+" Report",
					reportnamecsv);
			
			 // Read Report extraction date of CSV file
			String[] reportExtractionDatearr = reader.readNext();
			String reportExtractionDateCSV = reportExtractionDatearr[1].trim();
			String todaydate = CommonFunctions.currentDate("MM-dd-yyyy");
			System.out.println("The Value of todaydate is :: " + todaydate);
			if (parentreportname.equalsIgnoreCase("Scheduled Reports")) {
				Assert.assertEquals(reporttitle + " Report Extraction date does not match with downloaded CSV file",
						todaydate, reportExtractionDateCSV);
				}
				else if (parentreportname.equalsIgnoreCase("Requested Reports")) {
					Assert.assertEquals(reporttitle + " Report Extraction date does not match with downloaded CSV file",
							requestedreport_startdate, reportExtractionDateCSV);
				} else {
					Assert.fail(parentreportname + " is missing.");
				}
			
			// Read Report extraction time of CSV file
			String[] reportExtractionTimearr = reader.readNext(); 
			String report_extraction_time_CSV   = reportExtractionTimearr[1].trim();
			System.out.println("Value of Report Extraction Time in CSV file for "+filename+" is :: " + report_extraction_time_CSV);
			Assert.assertEquals(reporttitle + " Report Extraction Time does not match with downloaded CSV file",reportgeneratedtime,report_extraction_time_CSV);


			reader.readNext();         //    Blank Line
				
			String[] actCSVcolumnlistarr = reader.readNext();   //   Read Column names
				for(String column : actCSVcolumnlistarr)
				{
					actCSVcolumnlist.add(column);
				}
			//	System.out.println("actCSVcolumnlist is :: "+actCSVcolumnlist);
      
				boolean flag = actCSVcolumnlist.equals(expCSVcolumnlist);
			System.out.println("    Columns in CSV File :: " + actCSVcolumnlist);
			System.out.println("Columns in Feature File :: " + expCSVcolumnlist);
			Assert.assertEquals("Results table columns name does not match with downloaded CSV file", true, flag);
			reader.close();
		}
		
		// Participant Settlement Report
				else if (reporttitle.equalsIgnoreCase("Participant Settlement Report")) {
					CSVReader reader = new CSVReader(new FileReader(downloadFilepath + "\\" + filename));
					String[] reportnamedetails = reader.readNext(); // Read Report name of CSV file
					String reportnamecsv = reportnamedetails[1];
					Assert.assertEquals(reporttitle + " : Report name does not match with downloaded CSV file", reporttitle,
							reportnamecsv);
					
					 // Read Report Generated Date of CSV file
					String[] reportGeneratedDatearr = reader.readNext();
					String reportGeneratedDateCSV = reportGeneratedDatearr[1].trim();
					String todaydate = CommonFunctions.currentDate("MM/dd/yyyy");
					System.out.println("The Value of todaydate is :: " + todaydate);
					if (parentreportname.equalsIgnoreCase("Scheduled Reports")) {
						Assert.assertEquals(reporttitle + " Report Generated date does not match with downloaded CSV file",
								todaydate, reportGeneratedDateCSV);
						}
						else if (parentreportname.equalsIgnoreCase("Requested Reports")) {
							Assert.assertEquals(reporttitle + " Report Generated date does not match with downloaded CSV file",
									requestedreport_startdate, reportGeneratedDateCSV);
						} else {
							Assert.fail(parentreportname + " is missing.");
						}
					
					// Read Report Run time of Participant Settlement Report CSV file
					String[] reportRunTimearr = reader.readNext(); 
					String report_extraction_time_CSV   = reportRunTimearr[1].trim();
					System.out.println("Value of Report Run Time in CSV file for "+filename+" is :: " + report_extraction_time_CSV);
					Assert.assertEquals(reporttitle + " Report Run Time does not match with downloaded CSV file",reportgeneratedtime,report_extraction_time_CSV);


					reader.readNext();         //    Blank Line
					
		 // Read Settlement Cycle Date of Participant Settlement Report CSV file
			String[] reportSettlementCycleDatearr = reader.readNext();
			String reportSettlementCycleDateCSV = reportSettlementCycleDatearr[1].trim();
			String previousdate = CommonFunctions.pastDate("MM/dd/yyyy", -3);
			System.out.println("The Value of previousdate is :: " + previousdate);
			if (parentreportname.equalsIgnoreCase("Scheduled Reports")) {
				Assert.assertEquals(reporttitle + " Report Settlement Cycle date does not match with downloaded CSV file",
						previousdate, reportSettlementCycleDateCSV);
			} else if (parentreportname.equalsIgnoreCase("Requested Reports")) {
				Assert.assertEquals(reporttitle + " Report Settlement Cycle date does not match with downloaded CSV file",
						requestedreport_startdate, reportSettlementCycleDateCSV);
			} else {
				Assert.fail(parentreportname + " is missing.");
			}
			
			 // Read Settlement Cycle Date of Participant Settlement Report CSV file
			String[] reportSettlementCycleIDarr = reader.readNext();
			String reportSettlementCycleIDCSV = reportSettlementCycleIDarr[1].trim();
			System.out.println("The Value of reportSettlementCycleIDCSV is :: " + reportSettlementCycleIDCSV);

			if (parentreportname.equalsIgnoreCase("Scheduled Reports")) {
				Assert.assertEquals(reporttitle + " Report Generated date is blank downloaded CSV file",
						false, reportSettlementCycleIDCSV.isEmpty());
			} else if (parentreportname.equalsIgnoreCase("Requested Reports")) {
				Assert.assertEquals(reporttitle + " Report Generated date does not match with downloaded CSV file",
						requestedreport_startdate, reportSettlementCycleIDCSV);
			} else {
				Assert.fail(parentreportname + " is missing.");
			}
				
			reader.readNext();         //    Blank Line
		//   Read Column names for Participant Settlement Report
			
					String[] actCSVcolumnlistarr = reader.readNext();   
						for(String column : actCSVcolumnlistarr)
						{
							actCSVcolumnlist.add(column);
						}
					//	System.out.println("actCSVcolumnlist is :: "+actCSVcolumnlist);
		      
						boolean flag = actCSVcolumnlist.equals(expCSVcolumnlist);
					System.out.println("    Columns in CSV File :: " + actCSVcolumnlist);
					System.out.println("Columns in Feature File :: " + expCSVcolumnlist);
					Assert.assertEquals("Results table columns name does not match with downloaded CSV file", true, flag);
					reader.close();
				}
		
		// Payment Volume and Value Report
		else if (reporttitle.equalsIgnoreCase("Payment Volume and Value Report")) {
			CSVReader reader = new CSVReader(new FileReader(downloadFilepath + "\\" + filename));
			String[] reportnamedetails = reader.readNext(); // Read Report name of CSV file
			String reportnamecsv = reportnamedetails[1];
			Assert.assertEquals(reporttitle + " : Report name does not match with downloaded CSV file", reporttitle,
					reportnamecsv);

			String[] reportGeneratedDatearr = reader.readNext(); // Read Report Generated date of CSV file
			String reportGeneratedDateCSV = reportGeneratedDatearr[1].trim();
			String todaydate = CommonFunctions.currentDate("MM-dd-yyyy");
			System.out.println("The Value of todaydate is :: " + todaydate);
			Assert.assertEquals(reporttitle + "  : Report Extraction date does not match with downloaded CSV file",
					todaydate, reportGeneratedDateCSV);

			String[] reportRunTimearr = reader.readNext(); // Read Report Run Time of CSV file
			String report_run_time_CSV = reportRunTimearr[1].trim();			
			System.out.println("Value of Run Time in CSV file for "+filename+" is :: " + report_run_time_CSV);
			Assert.assertEquals(reporttitle + " Run Time does not match with downloaded CSV file",reportgeneratedtime,report_run_time_CSV);

			reader.readNext(); // Blank Line

			String[] startDateTimearr = reader.readNext(); // Read Start Date/time of reporting period of CSV file
			String startDateTimecsvarr[] = startDateTimearr[1].split(" ");
			String startDateTimecsv = startDateTimecsvarr[0] + " " + startDateTimecsvarr[1];
			System.out.println("value of startDateTimecsv for "+reporttitle+"is :: " + startDateTimecsv);
			String previousdate = CommonFunctions.pastDate("yyyy-MM-dd", -1);
			System.out.println("The Value of previous date is :: " + previousdate);
//			Assert.assertEquals(reporttitle + " Start date name does not match with downloaded CSV file",
//					previousdate + " 00:00:00", startDateTimecsv);
			if (parentreportname.equalsIgnoreCase("Scheduled Reports")) {
				Assert.assertEquals(reporttitle + " Start date name does not match with downloaded CSV file",
						previousdate + " 00:00:00", startDateTimecsv);
				}
				else if (parentreportname.equalsIgnoreCase("Requested Reports")) {
					Assert.assertEquals(reporttitle + " Start date name does not match with downloaded CSV file",
							requestedreport_startdate+ " 00:00:00", startDateTimecsv);
				} else {
					Assert.fail(parentreportname + " is missing.");
				}

			String[] endDateTimearr = reader.readNext(); // Read End Date/time of reporting period of CSV file
			String endDateTimecsvarr[] = endDateTimearr[1].split(" ");
			String endDateTimecsv = endDateTimecsvarr[0] + " " + endDateTimecsvarr[1];
			System.out.println("value of endDateTimecsv for "+reporttitle+" is :: " + endDateTimecsv);
//			Assert.assertEquals(reporttitle + " End date name does not match with downloaded CSV file",
//					previousdate + " 23:59:59", endDateTimecsv);
			if (parentreportname.equalsIgnoreCase("Scheduled Reports")) {
				Assert.assertEquals(reporttitle + " End date name does not match with downloaded CSV file",
						previousdate + " 23:59:59", endDateTimecsv);
			} else if (parentreportname.equalsIgnoreCase("Requested Reports")) {
				Assert.assertEquals(reporttitle + " End date name does not match with downloaded CSV file",
						requestedreport_enddate+ " 23:59:59", endDateTimecsv);
			} else {
				Assert.fail(parentreportname + " is missing.");
			}

			// Read Local Instrument of CSV file
			String[] local_instrument_arr = reader.readNext(); 
			String local_instrument_CSV = local_instrument_arr[1].trim();
			System.out.println("The Value of Local Instrument in CSV file is :: " + local_instrument_CSV);
			if (parentreportname.equalsIgnoreCase("Scheduled Reports")) {
			Assert.assertEquals(reporttitle + "  : Local Instrument does not match with downloaded CSV file", "ALL",
						local_instrument_CSV);
			} else if (parentreportname.equalsIgnoreCase("Requested Reports")) {
				Assert.assertEquals(reporttitle + "  : Local Instrument does not match with downloaded CSV file", requestedreport_LocalInstrument,
						local_instrument_CSV);
			} else {
				Assert.fail(parentreportname + " is missing.");
			}

			String[] category_purpose_code_arr = reader.readNext(); // Read Category Purpose Code of CSV file
			String category_purpose_code_CSV = category_purpose_code_arr[1].trim();
			System.out.println("The Value of Category Purpose Code in CSV file is :: " + category_purpose_code_CSV);
			if (parentreportname.equalsIgnoreCase("Scheduled Reports")) {
				Assert.assertEquals(reporttitle + "  : Category Purpose Code does not match with downloaded CSV file",
						"ALL", category_purpose_code_CSV);
			} else if (parentreportname.equalsIgnoreCase("Requested Reports")) {
				Assert.assertEquals(reporttitle + "  : Category Purpose Code does not match with downloaded CSV file",
						requestedreport_CategoryPurposeCode, category_purpose_code_CSV);
			} else {
				Assert.fail(parentreportname + " is missing.");
			}

			reader.readNext(); // Blank Line

			String[] actCSVcolumnlist1_arr = reader.readNext(); // Read Column names from 10th Row in CSV file
			ArrayList<String> actCSVcolumnlist1 = new ArrayList<String>();
			for (String column_in_row10 : actCSVcolumnlist1_arr) {
				if (!column_in_row10.isEmpty()) {
					actCSVcolumnlist1.add(column_in_row10);
				}
			}
			System.out.println("actCSVcolumnlist1 is :: " + actCSVcolumnlist1);

			String[] actCSVcolumnlist2_arr = reader.readNext(); // Read Column names from 11th Row in CSV file
			ArrayList<String> actCSVcolumnlist2 = new ArrayList<String>();
			for (String column_in_row11 : actCSVcolumnlist2_arr) {
				if (!(column_in_row11.contains("Accepted") || column_in_row11.contains("Rejected")
						|| column_in_row11.isEmpty())) {

					actCSVcolumnlist2.add(column_in_row11);
				}
			}
			System.out.println("actCSVcolumnlist2 is :: " + actCSVcolumnlist2);
			actCSVcolumnlist.addAll(actCSVcolumnlist1);
			actCSVcolumnlist.addAll(actCSVcolumnlist2);
			Collections.sort(actCSVcolumnlist);
			ArrayList<String> expCSVcolumnlist_sorted = new ArrayList<String>(expCSVcolumnlist);
			Collections.sort(expCSVcolumnlist_sorted);    // Sorted Feature File List
			boolean flag = actCSVcolumnlist.equals(expCSVcolumnlist_sorted);
			System.out.println("    Columns in CSV File :: " + actCSVcolumnlist);
			// System.out.println("Columns in Feature File :: " + expCSVcolumnlist);
			System.out.println("Columns in Feature File :: " + expCSVcolumnlist_sorted);
			// Assert.assertEquals("Results table columns name does not match with
			// downloaded CSV file", true, flag);
			Assert.assertEquals("Results table columns name does not match with downloaded CSV file", true,
					flag);
			reader.close();
		}
		
		// Reject Report
		else if (reporttitle.equalsIgnoreCase("Reject Report")) {
			CSVReader reader = new CSVReader(new FileReader(downloadFilepath + "\\" + filename));
			String[] reportnamedetails = reader.readNext(); // Read Report name of CSV file
			String reportnamecsv = reportnamedetails[1];
			Assert.assertEquals(reporttitle + " : Report name does not match with downloaded CSV file", reporttitle,
					reportnamecsv);

			String[] reportGeneratedDatearr = reader.readNext(); // Read Report Generated date of CSV file
			String reportGeneratedDateCSV = reportGeneratedDatearr[1].trim();
			String todaydate = CommonFunctions.currentDate("MM-dd-yyyy");
			System.out.println("The Value of todaydate is :: " + todaydate);
			Assert.assertEquals(reporttitle + "  : Report Extraction date does not match with downloaded CSV file",
					todaydate, reportGeneratedDateCSV);

			String[] reportRunTimearr = reader.readNext(); // Read Report Run Time of CSV file
			String reportRunTimeCSV = reportRunTimearr[1].trim();
			System.out.println("Value of Run Time in CSv file for "+filename+" is :: " + reportRunTimeCSV);
			Assert.assertEquals(reporttitle + " Run Time does not match with downloaded CSV file",reportgeneratedtime,reportRunTimeCSV);
			
			if (parentreportname.equalsIgnoreCase("Scheduled Reports")) {
				String[] local_instrument_arr = reader.readNext(); // Read Local Instrument of CSV file
				String local_instrument_CSV = local_instrument_arr[1].trim();
				System.out.println("The Value of Local Instrument in CSV file is :: " + local_instrument_CSV);
				Assert.assertEquals(reporttitle + "  : Local Instrument does not match with downloaded CSV file", "ALL",
						local_instrument_CSV);
			} else if (parentreportname.equalsIgnoreCase("Requested Reports")) {
				String[] local_instrument_arr = reader.readNext(); // Read Local Instrument of CSV file
				String local_instrument_CSV = local_instrument_arr[1].trim();
				System.out.println("The Value of Local Instrument in CSV file is :: " + local_instrument_CSV);
				Assert.assertEquals(reporttitle + "  : Local Instrument does not match with downloaded CSV file", requestedreport_LocalInstrument,
						local_instrument_CSV);
			} else {
				Assert.fail(parentreportname + " is missing.");
			}
			
			// Read Category Purpose Code of CSV file
			String[] category_purpose_code_arr = reader.readNext(); 
			String category_purpose_code_CSV = category_purpose_code_arr[1].trim();
			System.out.println("The Value of Category Purpose Code in CSV file is :: " + category_purpose_code_CSV);
			if (parentreportname.equalsIgnoreCase("Scheduled Reports")) {
				Assert.assertEquals(reporttitle + "  : Category Purpose Code does not match with downloaded CSV file",
						"ALL", category_purpose_code_CSV);
			} else if (parentreportname.equalsIgnoreCase("Requested Reports")) {
				Assert.assertEquals(reporttitle + "  : Category Purpose Code does not match with downloaded CSV file",
						requestedreport_CategoryPurposeCode, category_purpose_code_CSV);
			} else {
				Assert.fail(parentreportname + " is missing.");
			}
			
			reader.readNext(); // Blank Line
			reader.readNext(); // Blank Line

			String[] startDateTimearr = reader.readNext(); // Read Start Date/time of Reporting Period of CSV file
			String startDateTimecsvarr[] = startDateTimearr[1].split(" ");
			String startDateTimecsv = startDateTimecsvarr[0] + " " + startDateTimecsvarr[1];
			System.out.println("Value of startDateTimecsv is :: " + startDateTimecsv);
			String previousdate = CommonFunctions.pastDate("yyyy-MM-dd", -1);
			System.out.println("The Value of previous date is :: " + previousdate);
			if (parentreportname.equalsIgnoreCase("Scheduled Reports")) {
			Assert.assertEquals(reporttitle + " Start date name does not match with downloaded CSV file",
					previousdate + " 00:00:00", startDateTimecsv);
			}
			else if (parentreportname.equalsIgnoreCase("Requested Reports")) {
				Assert.assertEquals(reporttitle + " Start date name does not match with downloaded CSV file",
						requestedreport_startdate+ " 00:00:00", startDateTimecsv);
			} else {
				Assert.fail(parentreportname + " is missing.");
			}
			// Read End Date/time of Reporting Period of CSV file
			String[] endDateTimearr = reader.readNext(); 
			String endDateTimecsvarr[] = endDateTimearr[1].split(" ");
			String endDateTimecsv = endDateTimecsvarr[0] + " " + endDateTimecsvarr[1];
			System.out.println("Value of endDateTimecsv is :: " + endDateTimecsv);
			if (parentreportname.equalsIgnoreCase("Scheduled Reports")) {
				Assert.assertEquals(reporttitle + " End date name does not match with downloaded CSV file",
						previousdate + " 23:59:59", endDateTimecsv);
			} else if (parentreportname.equalsIgnoreCase("Requested Reports")) {
				Assert.assertEquals(reporttitle + " End date name does not match with downloaded CSV file",
						requestedreport_enddate+ " 23:59:59", endDateTimecsv);
			} else {
				Assert.fail(parentreportname + " is missing.");
			}

			

			String[] actCSVcolumnlist1_arr = reader.readNext(); // Read Column names from 10th Row in CSV file
			ArrayList<String> actCSVcolumnlist1 = new ArrayList<String>();
			for (String column_in_row10 : actCSVcolumnlist1_arr) {
				if (!column_in_row10.isEmpty()) {
					actCSVcolumnlist1.add(column_in_row10);
				}
			}
			System.out.println("actCSVcolumnlist1 is :: " + actCSVcolumnlist1);

			String[] actCSVcolumnlist2_arr = reader.readNext(); // Read Column names from 11th Row in CSV file
			ArrayList<String> actCSVcolumnlist2 = new ArrayList<String>();
			for (String column_in_row11 : actCSVcolumnlist2_arr) {
				if (!column_in_row11.isEmpty()) {					
						if(column_in_row11.equalsIgnoreCase("FI ID") || column_in_row11.equalsIgnoreCase("FI Name") || column_in_row11.equalsIgnoreCase("Participant ID") || column_in_row11.equalsIgnoreCase("Participant Name") || column_in_row11.equalsIgnoreCase("Total Number of Credit Transfer Transactions") || column_in_row11.equalsIgnoreCase("Total Number of Credit Transfers Transactions Accepted") || column_in_row11.equalsIgnoreCase("Total Number of Credit Transfer Transactions Accepted w/o Posting") || column_in_row11.equalsIgnoreCase("Total Number of Credit Transfer Transactions Rejected")) {			
					actCSVcolumnlist2.add(column_in_row11);
					}
				}
			}
			System.out.println("actCSVcolumnlist2 is :: " + actCSVcolumnlist2);

			String[] actCSVcolumnlist3_arr = reader.readNext(); // Read Column names from 12th Row in CSV file
			HashSet<String> actCSVcolumnlist3 = new HashSet<String>();
			for (String column_in_row12 : actCSVcolumnlist3_arr) {
				if (!column_in_row12.isEmpty()) {
				if (column_in_row12.contains("Total") || column_in_row12.contains("Outward")
						|| column_in_row12.contains("Inward") || column_in_row12.contains("Outward Participant Reject") || column_in_row12.contains("Outward System Reject")) {
					actCSVcolumnlist3.add(column_in_row12);
				}
				}
			}
			System.out.println("actCSVcolumnlist3 is :: " + actCSVcolumnlist3);
			actCSVcolumnlist.addAll(actCSVcolumnlist1);
			actCSVcolumnlist.addAll(actCSVcolumnlist2);
			actCSVcolumnlist.addAll(actCSVcolumnlist3);
			Collections.sort(actCSVcolumnlist);
			HashSet<String> expCSVcolumnlist_hashset = new HashSet<String>(expCSVcolumnlist);
			ArrayList<String> expCSVcolumnlist_sorted = new ArrayList<String>(expCSVcolumnlist_hashset);
			System.out.println("Columns in expCSVcolumnlist_sorted :: " + expCSVcolumnlist_sorted);
			Collections.sort(expCSVcolumnlist_sorted);    // Sorted Feature File List
			boolean flag = actCSVcolumnlist.equals(expCSVcolumnlist_sorted);
			System.out.println("    Columns in CSV File :: " + actCSVcolumnlist);
			// System.out.println("Columns in Feature File :: " + expCSVcolumnlist);
			System.out.println("Columns in Feature File :: " + expCSVcolumnlist_sorted);
			// Assert.assertEquals("Results table columns name does not match with
			// downloaded CSV file", true, flag);
			Assert.assertEquals("Results table columns name does not match with downloaded CSV file", true,
					flag);
			reader.close();
		}
	}
	
	
	public static void validateSuccessMessage(String pagename, String success_message) {
		
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(text_SuccessMessage));
		String act_success_message = CommonFunctions.driver.findElement(text_SuccessMessage).getText().trim();
		System.out.println("    Value of act_success_message is  :: " + act_success_message);
		reportID = Integer.parseInt(act_success_message.replaceAll("[\\D]", ""));
		System.out.println("The Value of generated Report ID is  :: "+reportID);
		System.out.println("The Value of doc string is  :: "+success_message);
		String exp_success_message = success_message.replaceAll("####", ""+reportID+"");
		System.out.println("    Value of exp_success_message is  :: " + exp_success_message);
		Assert.assertEquals("Success message did not match", exp_success_message,
				act_success_message);
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
				configuration.addClassifications("Browser", ReportsStepDefinitions.browser);
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


// End Here
}
