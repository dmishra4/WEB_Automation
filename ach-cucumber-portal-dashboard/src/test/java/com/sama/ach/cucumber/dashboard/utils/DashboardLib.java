package com.sama.ach.cucumber.dashboard.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sama.ach.cucumber.dashboard.page.ref.DashBoardPageRef;
import com.sama.ach.cucumber.dashboard.stepdefs.DashboardStepDefinitions;
import com.sama.ach.cucumber.poc.stepdefs.POC_StepDefinitions;
import com.sama.ach.cucumber.poc.utils.CommonFunctions;

import cucumber.api.Scenario;

public class DashboardLib implements DashBoardPageRef {

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
		System.out.println("The value of sceanio is :: " + POC_StepDefinitions.scenario);
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
	 * Function to select bank from participant drop down list
	 * @param participant
	 */
	public static void selectParticipant(String participantName)
	{
		WebElement participant = CommonFunctions.driver.findElement(By.xpath("//select[@id='filterText1']"));
		Select selectparticipant = new Select(participant);
		try {selectparticipant.selectByVisibleText(participantName);}
		catch(Exception e)
		{   
			e.getMessage();
			Assert.fail(participantName +" is not available in Participant drop down List");
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
	 * Function to validate GUI Items
	 * @param item
	 * @param name
	 * @param value
	 * @throws InterruptedException 
	 */
	public static void validateGUIItems(String section, String labelname, String count, String amount) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 30);
		if (section.equalsIgnoreCase("Payments Position")) {
			switch (labelname) {
			case "Debits Processed":
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_DebitProcessed));
				WebElement obj = CommonFunctions.driver.findElement(label_DebitProcessed);
				JavascriptExecutor je = (JavascriptExecutor) CommonFunctions.driver;
				je.executeScript("arguments[0].scrollIntoView(true);", obj);
				Thread.sleep(5000);
				String actdebitProcessedCount = CommonFunctions.driver.findElement(text_debitProcessedCount).getText()
						.trim();
				System.out.println("The runtime value of Debit Processed Count is  ::" + actdebitProcessedCount);
				Assert.assertNotNull("Debit Processed count is null", actdebitProcessedCount);
				String actdebitProcessedAmount = CommonFunctions.driver.findElement(text_debitProcessedAmount).getText()
						.trim();
				System.out.println("The runtime value of Debit Processed Amount is  ::" + actdebitProcessedAmount);
				try {
					Assert.assertEquals("Debit Processed Amount is empty", false, actdebitProcessedAmount.isEmpty());
				} catch (AssertionError e) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Debit Processed Amount is empty");
				}
				break;

			case "Credits Processed":
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_CreditsProcessed));
				String actcreditProcessedCount = CommonFunctions.driver.findElement(text_creditProcessedCount).getText()
						.trim();
				System.out.println("The runtime value of Credit Processed Count is  ::" + actcreditProcessedCount);
				Assert.assertNotNull("Debit Processed count is null", actcreditProcessedCount);
				String actcreditProcessedAmount = CommonFunctions.driver.findElement(text_creditProcessedAmount)
						.getText().trim();
				System.out.println("The runtime amount of Credits Processed is  ::" + actcreditProcessedAmount);
				try {
					Assert.assertEquals("Credits Processed Amount is empty", false, actcreditProcessedAmount.isEmpty());
				} catch (AssertionError e) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Credits Processed Amount is empty");
				}
				break;

			case "Debits Failed":
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_DebitsFailed));
				String actdebitsfailedcount = CommonFunctions.driver.findElement(text_debitFailedCount).getText()
						.trim();
				System.out.println("The runtime count of Debits Failed is  ::" + actdebitsfailedcount);
				Assert.assertNotNull("Debit Processed count is null", actdebitsfailedcount);
				String actdebitsfailedamount = CommonFunctions.driver.findElement(text_debitFailedAmount).getText()
						.trim();
				System.out.println("The runtime amount of Debits Failed is  ::" + actdebitsfailedamount);
				try {
					Assert.assertEquals("Debit Failed Amount is empty", false, actdebitsfailedamount.isEmpty());
				} catch (AssertionError e) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Debit Failed Amount is empty");
				}
				break;
			default:
				Assert.fail("Case does not match. Check again");
			}

		} else {
			Assert.fail("section " + section + " is not available under dashboard scrren");
		}
	}
	
	
// End here
	
	/**
	 * Function to validate GUI Items
	 * @param item
	 * @param name
	 * @param value
	 * @throws InterruptedException 
	 */
	public static void validateGUIItems(String section,String labelname,String value) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 30);
		if (section.equalsIgnoreCase("Disputes")) {
			switch (labelname) {
			case "As on":
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_Ason));
				WebElement obj = CommonFunctions.driver.findElement(label_Ason);
				JavascriptExecutor je = (JavascriptExecutor) CommonFunctions.driver;
				je.executeScript("arguments[0].scrollIntoView(true);", obj);
				String asonDate = CommonFunctions.driver.findElement(text_asonDate).getText().trim();
				System.out.println("The runtime value of as on Date is  :: " + asonDate);
				try {
					Assert.assertEquals("As on Date is empty", false, asonDate.isEmpty());
				} catch (AssertionError e) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("As on Date is empty");
				}
				break;
			case "Open Disputes":
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_OpenDisputes));
				WebElement obj1 = CommonFunctions.driver.findElement(label_OpenDisputes);
				JavascriptExecutor je1 = (JavascriptExecutor) CommonFunctions.driver;
				je1.executeScript("arguments[0].scrollIntoView(true);", obj1);
				String actOpenDisputes = CommonFunctions.driver.findElement(text_OpenDisputes).getText().trim();
				System.out.println("The runtime value of Open Disputes is  :: " + actOpenDisputes);
				try {
					Assert.assertEquals("Open Disputes count is empty", false, actOpenDisputes.isEmpty());
				} catch (AssertionError e) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Open Disputes count is empty");
				}
				break;

			case "Disputes in Progress":
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_DisputesinProgress));
				String actDisputesinProgress = CommonFunctions.driver.findElement(text_DisputesinProgress).getText()
						.trim();
				System.out.println("The runtime value of Disputes in Progress is  :: " + actDisputesinProgress);
				try {
					Assert.assertEquals("Disputes in Progress value is empty", false, actDisputesinProgress.isEmpty());
				} catch (AssertionError e) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Disputes in Progress value is empty");
				}
				break;

			case "Disputes closed in last 30 days":
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_Disputesclosed30days));
				String actcloseddisputes = CommonFunctions.driver.findElement(text_Disputesclosed30days).getText()
						.trim();
				System.out.println("The runtime value of Disputes closed in last 30 days is  :: " + actcloseddisputes);
				try {
					Assert.assertEquals("Disputes closed in last 30 days value is empty", false,
							actcloseddisputes.isEmpty());
				} catch (AssertionError e) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Disputes closed in last 30 days value is empty");
				}
				break;
			default:
				Assert.fail("Case does not match. Check again");
			}

		}
		else if (section.equalsIgnoreCase("Debit Cap")) {
			switch (labelname) {
			case "Debit Cap":
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_DebitCap));
				WebElement obj = CommonFunctions.driver.findElement(label_DebitCap);
				JavascriptExecutor je = (JavascriptExecutor) CommonFunctions.driver;
				je.executeScript("arguments[0].scrollIntoView(true);", obj);
				wait.until(ExpectedConditions.visibilityOfElementLocated(text_DebitCap));
				Thread.sleep(5000);
				String actdebitcap = CommonFunctions.driver.findElement(text_DebitCap).getText().trim();
				System.out.println("The runtime value of Debit Cap is  :: " + actdebitcap);
					try {
					Assert.assertEquals("Debit Cap value is empty", false, actdebitcap.isEmpty());
				} catch (AssertionError e) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Debit Cap value is empty");
				}
				break;
			case "Low Threshold":
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_LowThreshold));
				String actlowthreshold = CommonFunctions.driver.findElement(text_LowThreshold).getText().trim();
				System.out.println("The runtime value of Low Threshold is  :: " + actlowthreshold);
				try {
					Assert.assertEquals("Low Threshold value is empty", false, actlowthreshold.isEmpty());
				} catch (AssertionError e) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Low Threshold value is empty");
				}
				break;

			case "High Threshold":
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_LowThreshold));
				String acthighthreshold = CommonFunctions.driver.findElement(text_HighThreshold).getText().trim();
				System.out.println("The runtime value of High Threshold is  :: " + acthighthreshold);
				try {
					Assert.assertEquals("High Threshold value is empty", false, acthighthreshold.isEmpty());
				} catch (AssertionError e) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("High Threshold value is empty");
				}
				break;
			default:
				Assert.fail("Case does not match. Check again");
			}

		}
		else if (section.equalsIgnoreCase("Dashboard Notification Message")) {
			switch (labelname) {
			case "Settlement Cycle Status":
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(text_SettlementCycleStatus));
				WebElement obj = CommonFunctions.driver.findElement(text_SettlementCycleStatus);
				JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
				jse.executeScript("arguments[0].scrollIntoView(true);", obj);
				String actSettlementCycleStatusDetail = CommonFunctions.driver.findElement(text_SettlementCycleStatus)
						.getText().trim();
				if (!actSettlementCycleStatusDetail.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					System.out.println(
							"The runtime details value of " + labelname + " is  ::" + actSettlementCycleStatusDetail);
					String cycledetails[] = actSettlementCycleStatusDetail.split(",");
					String cycleid = cycledetails[0];
					String id[] = cycleid.split(":");
					String scid = id[1];
					if (scid.equalsIgnoreCase("001") || scid.equalsIgnoreCase("002")|| scid.equalsIgnoreCase("003")) {
						System.out.println("The Value of Settlement Cycle ID :" + scid);
					} else {
						Assert.fail("The Value of Settlement Cycle ID is nither 001 or 002 nor 003");
					}
					String cyclestatus = cycledetails[1].trim();

					if (cyclestatus.equalsIgnoreCase("INPROGRESS") || cyclestatus.equalsIgnoreCase("COMPLETE")
							|| cyclestatus.equalsIgnoreCase("DUE")) {
					} else {
						Assert.fail("The Value of Settlement Cycle Status is nither INPROGRESS, DUE or nor COMPLETE");
					}
					String cycledate = cycledetails[2].trim();
					if (!cycledate.isEmpty()) {
						System.out.println("The runtime timestamp value of Settlement Cycle Status is  ::" + cycledate);
						isdatevalid(labelname, cycledate);
					} else {
						System.out.println("The runtime timestamp value of Settlement Cycle Status is empty");
					}
				} else {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Details value of " + labelname + " is empty");
				}
				break;
			case "Debit Cap Threshold Warnings":
				wait.until(ExpectedConditions.visibilityOfElementLocated(text_DebitCapThresholdWarn));
				String actThresholdWarningsDetail = CommonFunctions.driver.findElement(text_DebitCapThresholdWarn)
						.getText().trim();
				if (!actThresholdWarningsDetail.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					System.out.println(
							"The runtime details value of " + labelname + " is  ::" + actThresholdWarningsDetail);
					String ThresholdWarnings[] = actThresholdWarningsDetail.split(",");
					String debitCapstatus = ThresholdWarnings[0].trim();
					if (debitCapstatus.equalsIgnoreCase("NORMAL") || debitCapstatus.equalsIgnoreCase("SUSPENDED")) 
					{
						System.out.println("The runtime Debit Cap Threshold Warnings Status is  ::" + debitCapstatus);
					} else {
						Assert.fail("The Value of Debit Cap Threshold Warnings Status is nither NORMAL nor SUSPENDED");
					}
					String debitCapThresholdWarningsdate = ThresholdWarnings[1].trim();
					if (!debitCapThresholdWarningsdate.isEmpty()) {
						System.out.println("The runtime timestamp value of Debit Cap Threshold Warnings Status is  ::" + debitCapThresholdWarningsdate);
						isdatevalid(labelname, debitCapThresholdWarningsdate);
					} else {
						System.out.println("The runtime timestamp value of Debit Cap Threshold Warnings Status is empty");
					}
				} else {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Details value of " + labelname + " is empty");
				}
				break;
			case "Debit Cap Breach":
				wait.until(ExpectedConditions.visibilityOfElementLocated(text_DebitCapBreach));
				String actDebitCapBreachDetail = CommonFunctions.driver.findElement(text_DebitCapBreach)
						.getText().trim();
				if (!actDebitCapBreachDetail.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					System.out.println(
							"The runtime details value of " + labelname + " is  ::" + actDebitCapBreachDetail);
					String debitCapBreach[] = actDebitCapBreachDetail.split(",");
					String debitCapBreachstatus = debitCapBreach[0].trim();
					if (debitCapBreachstatus.equalsIgnoreCase("EXCEEDED") || debitCapBreachstatus.equalsIgnoreCase("PAYMENTBLOCKED")) 
					{
						System.out.println("The runtime Debit Cap Breach Status is  ::" + debitCapBreachstatus);
					} else {
						Assert.fail("The Value of Debit Cap Breach Status is nither EXCEEDED nor PAYMENTBLOCKED");
					}
					String debitCapBreachdate = debitCapBreach[1].trim();
					if (!debitCapBreachdate.isEmpty()) {
						System.out.println("The runtime timestamp value of Debit Cap Breach Status is  ::" + debitCapBreachdate);
						isdatevalid(labelname, debitCapBreachdate);
					} else {
						System.out.println("The runtime timestamp value of Debit Cap Breach Status is empty");
					}
				} else {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Details value of " + labelname + " is empty");
				}
				break;
			case "Debit Cap Change":
				wait.until(ExpectedConditions.visibilityOfElementLocated(text_DebitCapChange));
				String actDebitCapChangeDetail = CommonFunctions.driver.findElement(text_DebitCapChange)
						.getText().trim();
				if (!actDebitCapChangeDetail.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					System.out.println(
							"The runtime details value of " + labelname + " is  ::" + actDebitCapChangeDetail);
					String debitCapChange[] = actDebitCapChangeDetail.split(",");
					String debitCapChangestatus = debitCapChange[0].trim();
					if (debitCapChangestatus.equalsIgnoreCase("SUCCESS") || debitCapChangestatus.equalsIgnoreCase("PAYMENTBLOCKED")) 
					{
						System.out.println("The runtime Debit Cap Change Status is  ::" + debitCapChangestatus);
					} else {
						Assert.fail("The Value of Debit Cap Change Status is nither SUCCESS nor PAYMENTBLOCKED");
					}
					String debitCapChangedate = debitCapChange[1].trim();
					if (!debitCapChangedate.isEmpty()) {
						System.out.println("The runtime timestamp value of Debit Cap Change Status is  ::" + debitCapChangedate);
						isdatevalid(labelname, debitCapChangedate);
					} else {
						System.out.println("The runtime timestamp value of Debit Cap Change Status is empty");
					}
				} else {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Details value of " + labelname + " is empty");
				}
				break;
			case "SaudiPayments IPS Notification (SNM)":
				wait.until(ExpectedConditions.visibilityOfElementLocated(text_SaudiPaymentsIPSNotification));
				String actSaudiPaymentsIPSDetail = CommonFunctions.driver.findElement(text_SaudiPaymentsIPSNotification)
						.getText().trim();
				if (!actSaudiPaymentsIPSDetail.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					System.out.println(
							"The runtime details value of " + labelname + " is  ::" + actSaudiPaymentsIPSDetail);
					String iPSNotification[] = actSaudiPaymentsIPSDetail.split(",");
					String saudiPaymentsIPSNotificationstatus = iPSNotification[0].trim();
					if (!saudiPaymentsIPSNotificationstatus.isEmpty()) 
					{
						System.out.println("The runtime SaudiPayments IPS Notification (SNM) Status is  ::" + saudiPaymentsIPSNotificationstatus);
					} else {
						Assert.fail("The Value of SaudiPayments IPS Notification (SNM) Status is empty");
					}
					String saudiPaymentsIPSNotificationstatusdate = iPSNotification[1].trim();
					if (!saudiPaymentsIPSNotificationstatusdate.isEmpty()) {
						System.out.println("The runtime timestamp value of SaudiPayments IPS Notification (SNM) Status is  ::" + saudiPaymentsIPSNotificationstatusdate);
						isdatevalid(labelname, saudiPaymentsIPSNotificationstatusdate);
					} else {
						System.out.println("The runtime timestamp value of SaudiPayments IPS Notification (SNM) Status is empty");
					}
				} else {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Details value of " + labelname + " is empty");
				}
				break;
			default:
				Assert.fail("Case does not match. Check again");
			}

		}
		else if(section.equalsIgnoreCase("Net Position")) {
			switch (labelname) {
			case "Net Position": 
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_NetPosition));
				Thread.sleep(5000);
				String actNetPosition = CommonFunctions.driver.findElement(text_NetPosition).getText().trim();
				System.out.println("The runtime value of Net Position is  :: "+actNetPosition);
				try {
					Assert.assertEquals("Net Position value is empty", false, actNetPosition.isEmpty());
				} catch (AssertionError e) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Net Position value is empty");
				}
				break;			
			case "Debit Cap Utilized": 
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_DebitCapUtilized));
			    String actDebitCapUtilized = CommonFunctions.driver.findElement(text_DebitCapUtilized).getText().trim();				
				System.out.println("The runtime value of Debit Cap Utilized is  :: "+actDebitCapUtilized);
				try {
					Assert.assertEquals("Debit Cap Utilized value is empty", false, actDebitCapUtilized.isEmpty());
				} catch (AssertionError e) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Debit Cap Utilized value is empty");
				}
				break;	
			default:
				Assert.fail("Case does not match. Check again");
			}
			
		}
		else if(section.equalsIgnoreCase("Pending Request")) {
			switch (labelname) {
			case "Debit Cap Change": 
				String actpendingRequestDate =null;
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_DebitCapChange));
				WebElement obj = CommonFunctions.driver.findElement(label_DebitCapChange);
				JavascriptExecutor je = (JavascriptExecutor)CommonFunctions.driver;
				je.executeScript("arguments[0].scrollIntoView(true);", obj);
				actpendingRequestDate = CommonFunctions.driver.findElement(text_pendingRequestDate).getText().trim();
				System.out.println("The runtime value of Pending Request Date is  :: "+actpendingRequestDate);
				//Assert.assertNotNull("Pending Request Date value is null", actpendingRequestDate);
				try {
					Assert.assertEquals("Pending Request Date value is empty", false, actpendingRequestDate.isEmpty());
				} catch (AssertionError e) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Pending Request Date value is empty");
				}
				break;			
			default:
				Assert.fail("Case does not match. Check again");
			}
			
		}
		/**
		 * Function to validate Last Cycle.
		 */
		else if(section.equalsIgnoreCase("Last Cycle")) {
			switch (labelname) {
			case "Last Cycle:": 
				String actlastCycleDate =null;
				wait.until(ExpectedConditions.visibilityOfElementLocated(Label_LastCycle));
				WebElement LastCycle = CommonFunctions.driver.findElement(Label_LastCycle);
				JavascriptExecutor je = (JavascriptExecutor)CommonFunctions.driver;
				je.executeScript("arguments[0].scrollIntoView(true);", LastCycle);
				Thread.sleep(5000);
				actlastCycleDate = CommonFunctions.driver.findElement(text_LastCycletDate).getText().trim();
				System.out.println("The runtime value of Last cycle Date is  :: "+actlastCycleDate);
				  try {
					Assert.assertEquals("Last cycle Date value is empty", false, actlastCycleDate.isEmpty());
				} catch (AssertionError e) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Last cycle Date value is empty");
				}
				break;
			case "Cycle No:": 
				String actcycleNo =null;
				wait.until(ExpectedConditions.visibilityOfElementLocated(Label_LCycleNo));
				WebElement cycleNo = CommonFunctions.driver.findElement(Label_LCycleNo);
				JavascriptExecutor je1 = (JavascriptExecutor)CommonFunctions.driver;
				je1.executeScript("arguments[0].scrollIntoView(true);", cycleNo);
				actcycleNo = CommonFunctions.driver.findElement(text_LCycletNo).getText().trim();
				System.out.println("The runtime value of Cycle No is  :: "+actcycleNo);
				  try {
					Assert.assertEquals("Cycle No value is empty", false, actcycleNo.isEmpty());
				} catch (AssertionError e) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Cycle No value is empty");
				}
				break;
			case "Cycle Status:": 
				String actcycleStatus =null;
				wait.until(ExpectedConditions.visibilityOfElementLocated(Label_LCycleStatus));
				WebElement cycleStatus = CommonFunctions.driver.findElement(Label_LCycleStatus);
				JavascriptExecutor je2 = (JavascriptExecutor)CommonFunctions.driver;
				je2.executeScript("arguments[0].scrollIntoView(true);", cycleStatus);
				actcycleStatus = CommonFunctions.driver.findElement(text_LCycletStatus).getText().trim();
				System.out.println("The runtime value of Cycle No is  :: "+actcycleStatus);
				  try {
					Assert.assertEquals("Cycle Status value is empty", false, actcycleStatus.isEmpty());
				} catch (AssertionError e) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Cycle Status value is empty");
				}
				break;
			default:
				Assert.fail("Case does not match. Check again");
			}
			
		}
		else if(section.equalsIgnoreCase("Next Cycle")) {
			switch (labelname) {
			case "Next Cycle:": 
				String actnextCycleDate =null;
				wait.until(ExpectedConditions.visibilityOfElementLocated(Label_NextCycle));
				WebElement NextCycle = CommonFunctions.driver.findElement(Label_NextCycle);
				JavascriptExecutor je = (JavascriptExecutor)CommonFunctions.driver;
				je.executeScript("arguments[0].scrollIntoView(true);", NextCycle);
				Thread.sleep(5000);
				actnextCycleDate = CommonFunctions.driver.findElement(text_NextCycletDate).getText().trim();
				System.out.println("The runtime value of Next cycle Date is  :: "+actnextCycleDate);
				  try {
					Assert.assertEquals("Next cycle Date value is empty", false, actnextCycleDate.isEmpty());
				} catch (AssertionError e) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Next cycle Date value is empty");
				}
				break;
			case "Cycle No:": 
				String actcycleNo =null;
				wait.until(ExpectedConditions.visibilityOfElementLocated(Label_NCycleNo));
				WebElement cycleNo = CommonFunctions.driver.findElement(Label_NCycleNo);
				JavascriptExecutor je1 = (JavascriptExecutor)CommonFunctions.driver;
				je1.executeScript("arguments[0].scrollIntoView(true);", cycleNo);
				actcycleNo = CommonFunctions.driver.findElement(text_NCycletNo).getText().trim();
				System.out.println("The runtime value of Cycle No is  :: "+actcycleNo);
				  try {
					Assert.assertEquals("Cycle No value is empty", false, actcycleNo.isEmpty());
				} catch (AssertionError e) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Cycle No value is empty");
				}
				break;
			case "Cycle Status:": 
				String actcycleStatus =null;
				wait.until(ExpectedConditions.visibilityOfElementLocated(Label_NCycleStatus));
				WebElement cycleStatus = CommonFunctions.driver.findElement(Label_NCycleStatus);
				JavascriptExecutor je2 = (JavascriptExecutor)CommonFunctions.driver;
				je2.executeScript("arguments[0].scrollIntoView(true);", cycleStatus);
				actcycleStatus = CommonFunctions.driver.findElement(text_NCycletStatus).getText().trim();
				System.out.println("The runtime value of Cycle Status is  :: "+actcycleStatus);
				  try {
					Assert.assertEquals("Cycle Status value is empty", false, actcycleStatus.isEmpty());
				} catch (AssertionError e) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Cycle Status value is empty");
				}
				break;
			default:
				Assert.fail("Case does not match. Check again");
			}
			
		}
		else {
			Assert.fail("section " + section + " is not available under dashboard scrren");
		}
	}
	/**
	 * Function to validate bank unavailability.
	 */
	
	public static void validateUnavailablebank() {
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(label_BanksUnavailable));
		WebElement obj = CommonFunctions.driver.findElement(label_BanksUnavailable);
		JavascriptExecutor je = (JavascriptExecutor) CommonFunctions.driver;
		je.executeScript("arguments[0].scrollIntoView(true);", obj);
		List<WebElement> banklist = CommonFunctions.driver.findElements(list_BanksUnavailable);
		if (banklist.size() > 0) {
			System.out.println("Below Banks are unavailable ::");
			DashboardStepDefinitions.scenario.write("Below Banks are unavailable ::");
			for (int i = 1; i <= banklist.size(); i++) {
				String str = CommonFunctions.driver
						.findElement(By.xpath(String.format("//*[@id='banksUnavilableDiv']/div[%s]", i))).getText();
				System.out.print(str + "        ");
				DashboardStepDefinitions.scenario.write(str);
				try {
					Assert.assertEquals("Bank unavailable details are missing under dashboard", false, str.isEmpty());
				} catch (AssertionError e) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Bank unavailable details are missing under dashboard");
				}
				if (i % 2 == 0) {
					System.out.println();
				}
			}
		} else {
			DashboardStepDefinitions.scenario.write("Currently, All Banks are available.");
		}

	}
	
	
	/**
	 * Function to validate GUI Items
	 * @param item
	 * @param name
	 * @param value
	 */
	public static void viewparticipantSNMs(String section, String labelname, String Details, String datetime) {
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 30);
		if (section.equalsIgnoreCase("Broadcast Message")) {
			switch (labelname) {
			case "System Status":
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_SystemStatus));
				String actSystemStatusDetail = CommonFunctions.driver.findElement(text_SystemStatusDetail).getText()
						.trim();
				if (actSystemStatusDetail.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					System.out.println("The runtime details value of " + labelname + " is  ::" + actSystemStatusDetail);
					Assert.fail("Details value of " + labelname + " is empty");
				} else if (actSystemStatusDetail.equalsIgnoreCase("NORMAL")
						|| actSystemStatusDetail.equalsIgnoreCase("SUSPENDED")) {
					System.out.println("The runtime details value  of " + labelname + " is  ::" + actSystemStatusDetail);
				} else {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Details value of " + labelname + " is neither NORMAL nor SUSPENDED");
				}
				String actsystemStatusTimeStamp = CommonFunctions.driver.findElement(text_SystemStatusTime).getText()
						.trim();
				System.out.println("The runtime timestamp value of System Status is  ::" + actsystemStatusTimeStamp);				
				isdatevalid(labelname,actsystemStatusTimeStamp);
				break;

			case "Security Transaction Limit (STL) Change":
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_STL));
				String actSTLChangeDetail = CommonFunctions.driver.findElement(text_STLChangeDetail).getText().trim();				
				if (actSTLChangeDetail.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					System.out.println("The runtime details value of " + labelname + " is  ::" + actSTLChangeDetail);
					Assert.fail("Details value of " + labelname + " is empty");
				} else if (actSTLChangeDetail.equalsIgnoreCase("ACTIVE")
						|| actSTLChangeDetail.equalsIgnoreCase("INACTIVE")) {
					System.out.println("The runtime details value  of " + labelname + " is  ::" + actSTLChangeDetail);
				} else {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Details value of " + labelname + " is neither ACTIVE nor INACTIVE");
				}
				String actSTLChangeTimeStamp = CommonFunctions.driver.findElement(text_STLChangeTime).getText().trim();
				System.out.println("The runtime timestamp value of "+labelname+" is  ::" + actSTLChangeTimeStamp);
				isdatevalid(labelname, actSTLChangeTimeStamp);
				break;
				
			case "Settlement Individual Transaction Limit (SITL) Change":
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_SITL));
				String actSITLChangeDetail = CommonFunctions.driver.findElement(text_SITLChangeDetail).getText().trim();				
				if (actSITLChangeDetail.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					System.out.println("The runtime details value of " + labelname + " is  ::" + actSITLChangeDetail);
					Assert.fail("Details value of " + labelname + " is empty");
				} else if (actSITLChangeDetail.equalsIgnoreCase("ACTIVE")
						|| actSITLChangeDetail.equalsIgnoreCase("INACTIVE")) {
					System.out.println("The runtime details value  of " + labelname + " is  ::" + actSITLChangeDetail);
				} else {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Details value of " + labelname + " is neither ACTIVE nor INACTIVE");
				}
				String actSITLChangeTimeStamp = CommonFunctions.driver.findElement(text_STLChangeTime).getText().trim();
				System.out.println("The runtime timestamp value of "+labelname+" is  ::" + actSITLChangeTimeStamp);
				isdatevalid(labelname, actSITLChangeTimeStamp);
				break;
			case "Participant Status":
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_ParticipantStatus));
				String actParticipantStatusDetail = CommonFunctions.driver.findElement(text_ParticipantStatusDetail).getText().trim();				
				if (actParticipantStatusDetail.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					System.out.println("The runtime details value of " + labelname + " is  ::" + actParticipantStatusDetail);
					Assert.fail("Details value of " + labelname + " is empty");
				} else if (actParticipantStatusDetail.equalsIgnoreCase("SIGNON")
						|| actParticipantStatusDetail.equalsIgnoreCase("SIGNOFF")) {
					System.out.println("The runtime details value  of " + labelname + " is  ::" + actParticipantStatusDetail);
				} else {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Details value of " + labelname + " is neither SIGNON nor SIGNOFF");
				}
				String actParticipantStatusTimeStamp = CommonFunctions.driver.findElement(text_ParticipantStatusTime).getText().trim();
				System.out.println("The runtime timestamp value of "+labelname+" is  ::" + actParticipantStatusTimeStamp);
				isdatevalid(labelname, actParticipantStatusTimeStamp);
				break;
			case "Connectivity Status":
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_ConnectivityStatus));
				String actConnectivityStatusDetail = CommonFunctions.driver.findElement(text_ConnectivityStatusDetail).getText().trim();				
				if (actConnectivityStatusDetail.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					System.out.println("The runtime details value of " + labelname + " is  ::" + actConnectivityStatusDetail);
					Assert.fail("Details value of " + labelname + " is empty");
				} else if (actConnectivityStatusDetail.equalsIgnoreCase("AVAILABLE")
						|| actConnectivityStatusDetail.equalsIgnoreCase("UNAVAILABLE")) {
					System.out.println("The runtime details value  of " + labelname + " is  ::" + actConnectivityStatusDetail);
				} else {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Details value of " + labelname + " is neither AVAILABLE nor UNAVAILABLE");
				}
				String actConnectivityStatusStamp = CommonFunctions.driver.findElement(text_ConnectivityStatusTime).getText().trim();
				System.out.println("The runtime timestamp value of "+labelname+" is  ::" + actConnectivityStatusStamp);
				isdatevalid(labelname, actConnectivityStatusStamp);
				break;
			case "Participant Suspend Status":
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_ParticipantSuspend));
				String actParticipantSuspendDetail = CommonFunctions.driver.findElement(text_ParticipantSuspendDetail).getText().trim();				
				if (actParticipantSuspendDetail.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					System.out.println("The runtime details value of " + labelname + " is  ::" + actParticipantSuspendDetail);
					Assert.fail("Details value of " + labelname + " is empty");
				} else if (actParticipantSuspendDetail.equalsIgnoreCase("DEFAULTBOTH")
						|| actParticipantSuspendDetail.equalsIgnoreCase("NORMAL")) {
					System.out.println("The runtime details value  of " + labelname + " is  ::" + actParticipantSuspendDetail);
				} else {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Details value of " + labelname + " is neither DEFAULTBOTH nor NORMAL");
				}
				String actParticipantSuspendTimeStamp = CommonFunctions.driver.findElement(text_ParticipantSuspendTime).getText().trim();
				System.out.println("The runtime timestamp value of System Status is  ::" + actParticipantSuspendTimeStamp);
				isdatevalid(labelname, actParticipantSuspendTimeStamp);
				break;
			case "SaudiPayments IPS Notification (SNM)":
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_SaudiPaymentsIPSNotificationB));
				String 	actSaudiPaymentsIPSDetail = CommonFunctions.driver.findElement(text_SaudiPaymentsIPSNotificationB).getText().trim();				
				if (!actSaudiPaymentsIPSDetail.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					System.out.println("The runtime details value of " + labelname + " is  ::" + actSaudiPaymentsIPSDetail);
				} else {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Details value of " + labelname + " is empty");
				}
				String actSaudiPaymentsIPSTimeStamp = CommonFunctions.driver.findElement(text_SaudiPaymentsIPSNotificationBTime).getText().trim();
				System.out.println("The runtime timestamp value of SaudiPayments IPS Notification (SNM) is  ::" + actSaudiPaymentsIPSTimeStamp);
				isdatevalid(labelname, actSaudiPaymentsIPSTimeStamp);
				break;
			default:
				Assert.fail("Case does not match. Check again");
			}

		} 
		else if (section.equalsIgnoreCase("Notification Message")) {
			switch (labelname) {
			case "Settlement Cycle Status":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, labelname))));
				WebElement obj = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel, labelname)));
				//List<WebElement> lis= CommonFunctions.driver.findElements(By.xpath(String.format(strGUIlabel, labelname)));
				JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
				jse.executeScript("arguments[0].scrollIntoView(true);", obj);
				int size = CommonFunctions.driver.findElements(By.xpath(String.format(strGUIvalue, labelname))).size();
				System.out.println("The value of Size is  :: "+ size);
				String actSettlementCycleStatusDetail = CommonFunctions.driver.findElements(By.xpath(String.format(strGUIvalue, labelname))).get(0).getText()
						.trim();
				if (!actSettlementCycleStatusDetail.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					System.out.println(
							"The runtime details value of " + labelname + " is  ::" + actSettlementCycleStatusDetail);
					String cycledetails[] = actSettlementCycleStatusDetail.split(",");
					String cycleid = cycledetails[0];
					String id[] = cycleid.split(":");
					String scid = id[1];
					if (scid.equalsIgnoreCase("001") || scid.equalsIgnoreCase("002")) {
						System.out.println("The Value of Settlement Cycle ID :" + scid);
					} else {
						Assert.fail("The Value of Settlement Cycle ID is nither 001 or nor 002");
					}
					String cyclestatus = cycledetails[1].trim();
					if (cyclestatus.equalsIgnoreCase("INPROGRESS") || cyclestatus.equalsIgnoreCase("COMPLETE")
							|| cyclestatus.equalsIgnoreCase("DUE")) {
					} else {
						Assert.fail("The Value of Settlement Cycle Status is nither INPROGRESS, DUE or nor COMPLETE");
					}
				} else {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Details value of " + labelname + " is empty");
				}
				String actSettlementCycleStatusTimeStamp = CommonFunctions.driver.findElement(By.xpath(String.format(strGUItimestamp, labelname))).getText()
						.trim();
				System.out.println("The runtime timestamp value of Settlement Cycle Status is  ::" + actSettlementCycleStatusTimeStamp);				
				isdatevalid(labelname,actSettlementCycleStatusTimeStamp);
				break;
			case "Debit Cap Threshold Warnings":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, labelname))));
				String actThresholdWarningsDetail = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIvalue, labelname))).getText()
						.trim();
				if (!actThresholdWarningsDetail.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					System.out.println("The runtime details value of " + labelname + " is  ::" + actThresholdWarningsDetail);
					} else {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Details value of " + labelname + " is empty");
				}
				String actThresholdWarningsTimeStamp = CommonFunctions.driver.findElement(By.xpath(String.format(strGUItimestamp, labelname))).getText()
						.trim();
				System.out.println("The runtime timestamp value of Debit Cap Threshold Warnings is  ::" + actThresholdWarningsTimeStamp);				
				isdatevalid(labelname,actThresholdWarningsTimeStamp);
				break;	
			case "Debit Cap Breach":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, labelname))));
				String actDebitCapBreachDetail = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIvalue, labelname))).getText()
						.trim();
				if (actDebitCapBreachDetail.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					System.out.println("The runtime details value of " + labelname + " is  ::" + actDebitCapBreachDetail);
					Assert.fail("Details value of " + labelname + " is empty");
				} else if (actDebitCapBreachDetail.equalsIgnoreCase("EXCEEDED")
						|| actDebitCapBreachDetail.equalsIgnoreCase("PAYMENTBLOCKED")) {
					System.out.println("The runtime details value  of " + labelname + " is  ::" + actDebitCapBreachDetail);
				} else {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Details value of " + labelname + " is neither PAYMENTBLOCKED nor EXCEEDED");
				}
				String actDebitCapBreachTimeStamp = CommonFunctions.driver.findElement(By.xpath(String.format(strGUItimestamp, labelname))).getText()
						.trim();
				System.out.println("The runtime timestamp value of Debit Cap Breach is  ::" + actDebitCapBreachTimeStamp);				
				isdatevalid(labelname,actDebitCapBreachTimeStamp);
				break;
			case "Debit Cap Change":
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, labelname))));
				String actDebitCapChangeDetail = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIvalue, labelname))).getText()
						.trim();
				if (!actDebitCapChangeDetail.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					System.out.println("The runtime details value of " + labelname + " is  ::" + actDebitCapChangeDetail);
					} 
				else {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Details value of " + labelname + " is empty");
				}
				String actDebitCapChangeTimeStamp = CommonFunctions.driver.findElement(By.xpath(String.format(strGUItimestamp, labelname))).getText()
						.trim();
				System.out.println("The runtime timestamp value of Debit Cap Change is  ::" + actDebitCapChangeTimeStamp);				
				isdatevalid(labelname,actDebitCapChangeTimeStamp);
				break;
			case "SaudiPayments IPS Notification (SNM)":
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_SaudiPaymentsIPSNotificationN));
				String 	actSaudiPaymentsIPSDetail = CommonFunctions.driver.findElement(text_SaudiPaymentsIPSNotificationN).getText().trim();				
				if (!actSaudiPaymentsIPSDetail.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					System.out.println("The runtime details value of " + labelname + " is  ::" + actSaudiPaymentsIPSDetail);
				} else {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Details value of " + labelname + " is empty");
				}
				String actSaudiPaymentsIPSTimeStamp = CommonFunctions.driver.findElement(text_SaudiPaymentsIPSNotificationNTime).getText().trim();
				System.out.println("The runtime timestamp value of SaudiPayments IPS Notification (SNM) is  ::" + actSaudiPaymentsIPSTimeStamp);
				isdatevalid(labelname, actSaudiPaymentsIPSTimeStamp);
				break;
			default:
				Assert.fail("Case does not match. Check again");
			}

		} else {
			Assert.fail("section " + section + " is not available under dashboard scrren");
		}
	}
	
	public static void isdatevalid(String label, String date)
	{				
		SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	//	if(actsystemStatusDateTime.matches("[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4} [00-23]{2}[:]{1}[00-59]{2}[:]{1}[00-59]{2}")) { 	    
		try {
			//Date datetimestamp = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(actsystemStatusDateTime);
            Date datetimestamp = sdformat.parse(date);
            String dateafterparse = sdformat.format(datetimestamp);
            System.out.println("TimeStamp value of "+label+" after parse is :: "+dateafterparse);
            Assert.assertEquals("Valid is in invalid format for "+label+"", dateafterparse, date);
            			
		} catch (Exception e) {
			CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
			DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
			Assert.fail(label + " time stamp is not in valid date format (dd/MM/yyyy HH:mm:ss) ");
		}
	
	}
	
	public static void validDateTime (String page, String date, String time, String sysdatetime)
	{
		
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(text_systemDateTime));
	    sysdatetime = CommonFunctions.driver.findElement(text_systemDateTime).getText().trim();				
		System.out.println("The date and time is  :: "+sysdatetime);	
		String datetime[]=sysdatetime.split("  ");
		date=datetime[0];
		System.out.println("The Value of time is :: " + date);
		String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
		System.out.println("The Value of todaydate is :: " + todaydate);
		Assert.assertEquals("Date didn't match ",todaydate, date);
		time=datetime[1];
		System.out.println("The Value of time is :: " + time);
		boolean flag=time.matches("[0-9]{2}[:]{1}[0-9]{2}[:]{1}[0-9]{2}");
		System.out.println("The Value of flag is :: " + flag);
		Assert.assertEquals("Time didn't match ",true, flag);
		
		}
	public static void validateMarqueeItems(String broadcast, String pagename, String labelname, String details) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 20);
		switch (labelname) {
		case "System Status":
			wait.until(ExpectedConditions.visibilityOfElementLocated(text_SystemStatusDetail));
			Thread.sleep(5000);
			String marqueevalue = CommonFunctions.driver.findElement(By.xpath("//marquee /p[1]")).getText().trim();
			if (!marqueevalue.isEmpty()) {
				CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
				DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
				System.out.println("The runtime marquee value of " + marqueevalue);
				String SystemStatusl[] = marqueevalue.split(":");
				String label = SystemStatusl[1];
				String value[] = label.split(",");
				String status = value[0].trim();
				if (status.equalsIgnoreCase("NORMAL") || status.equalsIgnoreCase("SUSPENDED")) {
					System.out.println("The Value of System Status:" + status);
				} else {
					Assert.fail("The Value of System Status is neither NORMAL nor SUSPENDED");
				}
				String datetime = value[1].trim();
				if (!datetime.isEmpty()) {
					String datetimearr[]=datetime.split(" ");
					String date = datetimearr[0];
					System.out.println("The System Status date is :" + date);
					String time = datetimearr[1];
					System.out.println("The Value of System Status time is :" + time);
					String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
					Assert.assertEquals("Date didn't match under "+ labelname, todaydate, date);
					boolean flag=time.matches("[0-9]{2}[:]{1}[0-9]{2}[:]{1}[0-9]{2}");
					System.out.println("The Value of flag is :: " + flag);
					Assert.assertEquals("Time didn't match ",true, flag);

				} else {
					Assert.fail("The System Status datetime is empty/incorrect");
				}
				
			} else {
				CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
				DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
				Assert.fail("Details value of " + labelname + " is empty");
			}
			break;
			case "Security Transaction Limit (STL) Change":
				wait.until(ExpectedConditions.visibilityOfElementLocated(text_STLChangeDetail));
				String marqueevalueone = CommonFunctions.driver.findElement(By.xpath("//marquee /p[2]")).getText().trim();
				if (!marqueevalueone.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					System.out.println("The runtime marquee value of " + marqueevalueone);
					String STLStatus[] = marqueevalueone.split(":");
					String label = STLStatus[1];
					String value[] = label.split(",");
					String status = value[0].trim();
					if (status.equalsIgnoreCase("ACTIVE") || status.equalsIgnoreCase("INACTIVE")){
						System.out.println("The Value of Security Transaction Limit (STL) Change Status:" + status);
					} else {
						Assert.fail("The Value of Security Transaction Limit (STL) Change Status is neither ACTIVE nor INACTIVE");
					}
					String datetime = value[1].trim();
					if (!datetime.isEmpty()) {
						String datetimearr[]=datetime.split(" ");
						String date = datetimearr[0];
						System.out.println("The value of Security Transaction Limit (STL) Change Status date is :" + date);
						String time = datetimearr[1];
						System.out.println("The Value of Security Transaction Limit (STL) Change Status time is :" + time);
						String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
						Assert.assertEquals("Date didn't match under "+ labelname, todaydate, date);
						boolean flag=time.matches("[0-9]{2}[:]{1}[0-9]{2}[:]{1}[0-9]{2}");
						System.out.println("The Value of flag is :: " + flag);
						Assert.assertEquals("Time didn't match ",true, flag);

					} else {
						Assert.fail("The datetime value of Security Transaction Limit (STL) Change is empty/incorrect");
					}
					
				} else {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Details value of " + labelname + " is empty");
				}
			break;
			case "Settlement Individual Transaction Limit (SITL) Change":
				wait.until(ExpectedConditions.visibilityOfElementLocated(text_SITLChangeDetail));
				String marqueevaluetwo = CommonFunctions.driver.findElement(By.xpath("//marquee /p[3]")).getText().trim();
				if (!marqueevaluetwo.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					System.out.println("The runtime marquee value of " + marqueevaluetwo);
					String SITLStatus[] = marqueevaluetwo.split(":");
					String label = SITLStatus[1];
					String value[] = label.split(",");
					String status = value[0].trim();
					if (status.equalsIgnoreCase("ACTIVE") || status.equalsIgnoreCase("INACTIVE")){
						System.out.println("The Value of Settlement Individual Transaction Limit (SITL) Change Status:" + status);
					} else {
						Assert.fail("The Value of Settlement Individual Transaction Limit (SITL) Change Status is neither ACTIVE nor INACTIVE");
					}
					String datetime = value[1].trim();
					if (!datetime.isEmpty()) {
						String datetimearr[]=datetime.split(" ");
						String date = datetimearr[0];
						System.out.println("The value of Settlement Individual Transaction Limit (SITL) Change Status date is :" + date);
						String time = datetimearr[1];
						System.out.println("The Value of Settlement Individual Transaction Limit (SITL) Change Status time is :" + time);
						String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
						Assert.assertEquals("Date didn't match under "+ labelname, todaydate, date);
						boolean flag=time.matches("[0-9]{2}[:]{1}[0-9]{2}[:]{1}[0-9]{2}");
						System.out.println("The Value of flag is :: " + flag);
						Assert.assertEquals("Time didn't match ",true, flag);

					} else {
						Assert.fail("The datetime value of Settlement Individual Transaction Limit (SITL) Change is empty/incorrect");
					}
					
				} else {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Details value of " + labelname + " is empty");
				}
				break;
			case "Participant Status":
				wait.until(ExpectedConditions.visibilityOfElementLocated(text_ParticipantStatusDetail));
				String marqueevaluethree = CommonFunctions.driver.findElement(By.xpath("//marquee /p[4]")).getText().trim();
				if (!marqueevaluethree.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					System.out.println("The runtime marquee value of " + marqueevaluethree);
					String ParticipantStatus[] = marqueevaluethree.split(":");
					String label = ParticipantStatus[1];
					String value[] = label.split(",");
					String status = value[0].trim();
					if (status.equalsIgnoreCase("SIGNON") || status.equalsIgnoreCase("SIGNOFF")){
						System.out.println("The Value of Participant Status:" + status);
					} else {
						Assert.fail("The Value of Participant Status is neither SIGNON nor SIGNOFF");
					}
					String datetime = value[1].trim();
					if (!datetime.isEmpty()) {
						String datetimearr[]=datetime.split(" ");
						String date = datetimearr[0];
						System.out.println("The value of Participant Status date is :" + date);
						String time = datetimearr[1];
						System.out.println("The Value of Participant Status time is :" + time);
						String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
						Assert.assertEquals("Date didn't match under "+ labelname, todaydate, date);
						boolean flag=time.matches("[0-9]{2}[:]{1}[0-9]{2}[:]{1}[0-9]{2}");
						System.out.println("The Value of flag is :: " + flag);
						Assert.assertEquals("Time didn't match ",true, flag);
					} else {
						Assert.fail("The datetime value of Participant Status is empty/incorrect");
					}
					
				} else {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Details value of " + labelname + " is empty");
				}
			break;
			case "Connectivity Status":
				wait.until(ExpectedConditions.visibilityOfElementLocated(text_ConnectivityStatusDetail));
				String marqueevaluefour = CommonFunctions.driver.findElement(By.xpath("//marquee /p[5]")).getText().trim();
				if (!marqueevaluefour.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					System.out.println("The runtime marquee value of " + marqueevaluefour);
					String ConnectivityStatus[] = marqueevaluefour.split(":");
					String label = ConnectivityStatus[1];
					String value[] = label.split(",");
					String status = value[0].trim();
					if (status.equalsIgnoreCase("AVAILABLE") ||	status.equalsIgnoreCase("UNAVAILABLE")){
						System.out.println("The Value of Connectivity Status:" + status);
					} else {
						Assert.fail("The Value of Connectivity Status is neither AVAILABLE nor UNAVAILABLE");
					}
					String datetime = value[1].trim();
					if (!datetime.isEmpty()) {
						String datetimearr[]=datetime.split(" ");
						String date = datetimearr[0];
						System.out.println("The value of Connectivity Status date is :" + date);
						String time = datetimearr[1];
						System.out.println("The Value of Connectivity Status time is :" + time);
						String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
						Assert.assertEquals("Date didn't match under "+ labelname, todaydate, date);
						boolean flag=time.matches("[0-9]{2}[:]{1}[0-9]{2}[:]{1}[0-9]{2}");
						System.out.println("The Value of flag is :: " + flag);
						Assert.assertEquals("Time didn't match ",true, flag);
					} else {
						Assert.fail("The datetime value of Connectivity Status is empty/incorrect");
					}
					
				} else {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Details value of " + labelname + " is empty");
				}
				break;
			case "Participant Suspend Status":
				wait.until(ExpectedConditions.visibilityOfElementLocated(text_ParticipantSuspendDetail));
				String marqueevaluefive = CommonFunctions.driver.findElement(By.xpath("//marquee /p[6]")).getText().trim();
				if (!marqueevaluefive.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					System.out.println("The runtime marquee value of " + marqueevaluefive);
					String ParticipantsStatus[] = marqueevaluefive.split(":");
					String label = ParticipantsStatus[1];
					String value[] = label.split(",");
					String status = value[0].trim();
					if (status.equalsIgnoreCase("DEFAULTBOTH") || status.equalsIgnoreCase("NORMAL")) {
						System.out.println("The Value of Participant Suspend Status:" + status);
					} else {
						Assert.fail("The Value of Participant Suspend Status is neither AVAILABLE nor UNAVAILABLE");
					}
					String datetime = value[1].trim();
					if (!datetime.isEmpty()) {
						String datetimearr[]=datetime.split(" ");
						String date = datetimearr[0];
						System.out.println("The value of Participant Suspend Status date is :" + date);
						String time = datetimearr[1];
						System.out.println("The Value of Participant Suspend Status time is :" + time);
						String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
						Assert.assertEquals("Date didn't match under "+ labelname, todaydate, date);
						boolean flag=time.matches("[0-9]{2}[:]{1}[0-9]{2}[:]{1}[0-9]{2}");
						System.out.println("The Value of flag is :: " + flag);
						Assert.assertEquals("Time didn't match ",true, flag);
					} else {
						Assert.fail("The datetime value of Participant Suspend Status is empty/incorrect");
					}
					
				} else {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Details value of " + labelname + " is empty");
				}
			break;
			case "SaudiPayments IPS Notification (SNM):":
				wait.until(ExpectedConditions.visibilityOfElementLocated(text_SaudiPaymentsIPSNotificationDetails));
				String marqueevaluesix = CommonFunctions.driver.findElement(By.xpath("//marquee /p[7]")).getText().trim();
				if (!marqueevaluesix.isEmpty()) {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					System.out.println("The runtime marquee value of " + marqueevaluesix);
					String IPSNotification[] = marqueevaluesix.split(":");
					String label = IPSNotification[1];
					String value[] = label.split(",");
					String status = value[0].trim();
					if (status.equalsIgnoreCase("DEFAULTBOTH") || status.equalsIgnoreCase("NORMAL")) {
						System.out.println("The status Value of SaudiPayments IPS Notification (SNM):" + status);
					} else {
						Assert.fail("The status Value of SaudiPayments IPS Notification (SNM) is neither AVAILABLE nor UNAVAILABLE");
					}
					String datetime = value[1].trim();
					if (!datetime.isEmpty()) {
						String datetimearr[]=datetime.split(" ");
						String date = datetimearr[0];
						System.out.println("The value of SaudiPayments IPS Notification (SNM) Status date is :" + date);
						String time = datetimearr[1];
						System.out.println("The Value of SaudiPayments IPS Notification (SNM) Status time is :" + time);
						String todaydate = CommonFunctions.currentDate("dd/MM/yyyy");
						Assert.assertEquals("Date didn't match under "+ labelname, todaydate, date);
						boolean flag=time.matches("[0-9]{2}[:]{1}[0-9]{2}[:]{1}[0-9]{2}");
						System.out.println("The Value of flag is :: " + flag);
						Assert.assertEquals("Time didn't match ",true, flag);
					} else {
						Assert.fail("The datetime value of SaudiPayments IPS Notification (SNM) Status is empty/incorrect");
					}
					
				} else {
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Details value of " + labelname + " is empty");
				}
				/*
				 * wait.until(ExpectedConditions.visibilityOfElementLocated(
				 * label_SaudiPaymentsIPSNotificationB)); String actSaudiPaymentsIPSDetail =
				 * CommonFunctions.driver.findElement(text_SaudiPaymentsIPSNotificationB).
				 * getText().trim(); if (!actSaudiPaymentsIPSDetail.isEmpty()) {
				 * CommonFunctions.snapshot =
				 * CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
				 * DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot,
				 * "image/png"); System.out.println("The runtime details value of " + labelname
				 * + " is  ::" + actSaudiPaymentsIPSDetail); } else { CommonFunctions.snapshot =
				 * CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
				 * DashboardStepDefinitions.scenario.embed(CommonFunctions.snapshot,
				 * "image/png"); Assert.fail("Details value of " + labelname + " is empty"); }
				 * String actSaudiPaymentsIPSTimeStamp =
				 * CommonFunctions.driver.findElement(text_SaudiPaymentsIPSNotificationBTime).
				 * getText().trim(); System.out.
				 * println("The runtime timestamp value of SaudiPayments IPS Notification (SNM) is  ::"
				 * + actSaudiPaymentsIPSTimeStamp); isdatevalid(labelname,
				 * actSaudiPaymentsIPSTimeStamp);
				 */
				break;
			default:
				Assert.fail("Case does not match. Check again");
			}

		} 
	
	
// End here
	
}


