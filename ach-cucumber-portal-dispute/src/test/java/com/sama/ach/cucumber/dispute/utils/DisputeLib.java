package com.sama.ach.cucumber.dispute.utils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sama.ach.cucumber.dispute.page.ref.DisputePageRef;
import com.sama.ach.cucumber.dispute.stepdefs.DisputeStepDefinitions;
import com.sama.ach.cucumber.poc.stepdefs.POC_StepDefinitions;
import com.sama.ach.cucumber.poc.utils.CommonFunctions;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class DisputeLib implements DisputePageRef{

	
	public static String DISPUTE_ID = null;
	
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
	 * Function to select bank from participant drop down list
	 * @param participant
	 */
	public static void selectParticipant(String participantName) {
		WebElement participant = CommonFunctions.driver.findElement(By.xpath("//select[@id='filterText1']"));
		Select selectparticipant = new Select(participant);
		try {
			selectparticipant.selectByVisibleText(participantName);
		} catch (Exception e) {
			e.getMessage();
			Assert.fail(participantName + " is not available in Participant drop down List");
		}
	}
	
	
	public static void enterSingleValue(String label_name, String label_value, String buttonName)
	{
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 50);
		if(label_name.equalsIgnoreCase("Dispute ID"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(input_DisputeID));
			CommonFunctions.driver.findElement(input_DisputeID).clear();
			if(label_value.equalsIgnoreCase("%RUNTIME%")) {
				CommonFunctions.driver.findElement(input_DisputeID).sendKeys(DISPUTE_ID);	
			}
			CommonFunctions.driver.findElement(input_DisputeID).sendKeys(label_value);
			//CommonFunctions.driver.findElement(By.xpath("//input[@value='"+buttonName+"']")).click();
			CommonFunctions.driver.findElement(btn_Search).click();
		}
		else if(label_name.equalsIgnoreCase("Reason of Rejection"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(textarea_RejectionReason));
			CommonFunctions.driver.findElement(textarea_RejectionReason).clear();
			CommonFunctions.driver.findElement(textarea_RejectionReason).sendKeys(label_value);
			//CommonFunctions.driver.findElement(By.xpath("//input[@value='"+buttonName+"']")).click();
			CommonFunctions.driver.findElement(btn_Submit).click();
		}
		else if(label_name.equalsIgnoreCase("Transaction ID"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(input_TransactionID));
			CommonFunctions.driver.findElement(input_TransactionID).clear();
			CommonFunctions.driver.findElement(input_TransactionID).sendKeys(label_value);
			//CommonFunctions.driver.findElement(By.xpath("//input[@value='"+buttonName+"']")).click();
			CommonFunctions.driver.findElement(btn_Submit).click();
		}
		else if(label_name.equalsIgnoreCase("Transaction_ID"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(input_SearchTransID));
			CommonFunctions.driver.findElement(input_SearchTransID).clear();
			CommonFunctions.driver.findElement(input_SearchTransID).sendKeys(label_value);
			//CommonFunctions.driver.findElement(By.xpath("//input[@value='"+buttonName+"']")).click();
			CommonFunctions.driver.findElement(btn_Search).click();
		}

		
		else {
			Assert.fail(" Button " + buttonName + " has not been found");
		}
	}
	
	/**
	 * This function is used to enter values in input fields for any specific page.
	 * @param page
	 * @param field_name
	 * @param field_value
	 * @throws InterruptedException
	 */
	public static void enterValues(String page, String field_name, String field_value) throws InterruptedException

	{
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 50);
		if (page.equalsIgnoreCase("Create Dispute")) {
			switch (field_name) {
			case "Disputer Party": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_DisputerParty));
				WebElement disputerParty = CommonFunctions.driver.findElement(select_DisputerParty);
				Select sdisputerParty = new Select(disputerParty);
				sdisputerParty.selectByVisibleText(field_value);
				break;
			}
			case "Disputed Party": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_DisputedParty));
				WebElement disputedParty = CommonFunctions.driver.findElement(select_DisputedParty);
				Select sdisputedParty = new Select(disputedParty);
				sdisputedParty.selectByVisibleText(field_value);
				break;
			}
			case "Dispute Category": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_DisputeCategory));
				WebElement disputeCategory = CommonFunctions.driver.findElement(select_DisputeCategory);
				Select sdisputeCategory = new Select(disputeCategory);
				sdisputeCategory.selectByVisibleText(field_value);
				break;
			}
			case "Dispute Type": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_DisputeType));
				WebElement disputeType = CommonFunctions.driver.findElement(select_DisputeType);
				Select sdisputeType = new Select(disputeType);
				sdisputeType.selectByVisibleText(field_value);
				break;
			}
			case "Dispute Details": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(textarea_DisputeDetails));
				WebElement disputeDetails = CommonFunctions.driver.findElement(textarea_DisputeDetails);
				disputeDetails.sendKeys(field_value);
				break;
			}
			case "Transaction ID": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_TransactionID));
				WebElement transactionID = CommonFunctions.driver.findElement(input_TransactionID);
				transactionID.sendKeys(field_value);
				int transactionIDlength = CommonFunctions.driver.findElement(input_TransactionID).getAttribute("value")
						.length();
				System.out.println("The Lenth of Transaction ID is :: " + transactionIDlength);
				if (transactionIDlength > 35) {
					Assert.fail("The length of Transaction ID more than 35 characters");
				}
				break;
			}

			default:
				Assert.fail("Required field " + field_name + " is not available in feature file");
			}
		}
		else if (page.equalsIgnoreCase("Search for Dispute")) {
			switch (field_name) {
			case "Disputer Party": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_DisputerPartySearch));
				WebElement disputerParty = CommonFunctions.driver.findElement(select_DisputerPartySearch);
				Select sdisputerParty = new Select(disputerParty);
				sdisputerParty.selectByVisibleText(field_value);
				break;
			}
			case "Disputed Party": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_DisputedPartySearch));
				WebElement disputedParty = CommonFunctions.driver.findElement(select_DisputedPartySearch);
				Select sdisputedParty = new Select(disputedParty);
				sdisputedParty.selectByVisibleText(field_value);
				break;
			}
			case "Dispute Status": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_DisputeStatusSearch));
				WebElement disputeCategory = CommonFunctions.driver.findElement(select_DisputeStatusSearch);
				Select sdisputeCategory = new Select(disputeCategory);
				sdisputeCategory.selectByVisibleText(field_value);
				break;
			}
			case "From": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_FromDate));
				JavascriptExecutor jse =  (JavascriptExecutor)CommonFunctions.driver;
				if(field_value.equalsIgnoreCase("%TodayDate%"))
				{
					String todaydate = CommonFunctions.currentDate("dd/MM/YYYY");
					System.out.println("The Value of todaydate is :: "+todaydate);
					jse.executeScript("document.getElementById('formDate').value='"+todaydate+"'");
				}
				else if(field_value.equalsIgnoreCase("%PreviousDate%"))
				{
					String pastdate = CommonFunctions.pastDate("dd/MM/YYYY",5);
					System.out.println("The Value of todaydate is :: "+pastdate);
					jse.executeScript("document.getElementById('formDate').value='"+pastdate+"'");
				}
				else if(field_value.equalsIgnoreCase("%FutureDate%"))
				{
					String futuredate = CommonFunctions.futureDate("dd/MM/YYYY",5);
					System.out.println("The Value of todaydate is :: "+futuredate);
					jse.executeScript("document.getElementById('formDate').value='"+futuredate+"'");
				}
				else
				{
				jse.executeScript("document.getElementById('formDate').value='"+field_value+"'");
				}
				break;
			
			}
			case "To": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_ToDate));
				JavascriptExecutor jse =  (JavascriptExecutor)CommonFunctions.driver;
				if(field_value.equalsIgnoreCase("%TodayDate%"))
				{
					String todaydate = CommonFunctions.currentDate("dd/MM/YYYY");
					System.out.println("The Value of todaydate is :: "+todaydate);
					jse.executeScript("document.getElementById('settlementCycleDate').value='"+todaydate+"'");
				}
				else if(field_value.equalsIgnoreCase("%PreviousDate%"))
				{
					String pastdate = CommonFunctions.pastDate("dd/MM/YYYY",5);
					System.out.println("The Value of todaydate is :: "+pastdate);
					jse.executeScript("document.getElementById('toDate').value='"+pastdate+"'");
				}
				else if(field_value.equalsIgnoreCase("%FutureDate%"))
				{
					String futuredate = CommonFunctions.futureDate("dd/MM/YYYY",5);
					System.out.println("The Value of todaydate is :: "+futuredate);
					jse.executeScript("document.getElementById('toDate').value='"+futuredate+"'");
				}
				else
				{
				jse.executeScript("document.getElementById('toDate').value='"+field_value+"'");
				}
				break;
			}

			default:
				Assert.fail("Required field " + field_name + " is not available in feature file");
			}
		}		
		else if (page.equalsIgnoreCase("Action Dispute")) {
			switch (field_name) {
			case "Dispute History": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(textarea_DisputeHistory));
				CommonFunctions.driver.findElement(textarea_DisputeHistory).clear();
                CommonFunctions.driver.findElement(textarea_DisputeHistory).sendKeys(field_value);
				break;
			}
			case "Final Dispute Resolution Result": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(textarea_finalResolutionValue));
				CommonFunctions.driver.findElement(textarea_finalResolutionValue).clear();
				CommonFunctions.driver.findElement(textarea_finalResolutionValue).sendKeys(field_value);	
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
 * Function to click the visible button
 * @param buttonname
 * @param pageName
 * @throws Exception
 */
	
	public static void clickButton(String buttonName, String pageName) throws Exception {
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 30);
		if (pageName.equalsIgnoreCase("Create Dispute") || pageName.equalsIgnoreCase("Approve Dispute")) {
			switch (buttonName) {
			case "Submit": {
				// WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Submit));
				CommonFunctions.driver.findElement(btn_Submit).click();
				CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
				break;
			}
			case "Create Dispute": {				
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_CreateDispute));
				CommonFunctions.driver.findElement(btn_CreateDispute).click();
				break;
			}
			case "Cancel": {				
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Cancel));
				CommonFunctions.driver.findElement(btn_Cancel).click();
				break;
			}
			default:
				Assert.fail(" Button " + buttonName + " has not been found");
			}
		} 
		else if (pageName.equalsIgnoreCase("Search for Dispute") || pageName.equalsIgnoreCase("Action Dispute") || pageName.equalsIgnoreCase("Dispute Management")) {
			switch (buttonName) {
			case "View Details": {
				// WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_ViewDetails));
				CommonFunctions.driver.findElement(btn_ViewDetails).click();
				break;
			}
			case "Print": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Print));
				CommonFunctions.driver.findElement(btn_Print).click();
				Thread.sleep(2000);
				Robot r = new Robot();
				r.delay(1000);
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);			 
				break;
			}
			case "Save As Draft": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_SaveasDraft));
				CommonFunctions.driver.findElement(btn_SaveasDraft).click();
				Thread.sleep(2000);
				break;
			}
			case "Search": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Search));
				CommonFunctions.driver.findElement(btn_Search).click();
				Thread.sleep(2000);
				break;
			}
			case "Submit for Approval": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_SubmitForApproval));
				CommonFunctions.driver.findElement(btn_SubmitForApproval).click();
				Thread.sleep(2000);
				break;
			}
			
			case "Search for Dispute": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(String.format(strNavigate,buttonName))));
				CommonFunctions.driver.findElement(By.linkText(String.format(strNavigate,buttonName))).click();
				Thread.sleep(1000);
				break;
			}
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
		
	public static void clickRadioButton(String radiobuttonName, String pagename) throws Exception {
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 3);		
		if (radiobuttonName.equalsIgnoreCase("Dispute ID") && pagename.equalsIgnoreCase("Search for dispute")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, radiobuttonName))));
			CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel, radiobuttonName))).click();
		} 
		else if (radiobuttonName.equalsIgnoreCase("Transaction ID") && pagename.equalsIgnoreCase("Search for dispute")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, radiobuttonName))));
			CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel, radiobuttonName))).click();
		} 
		else if (radiobuttonName.equalsIgnoreCase("Advanced") && pagename.equalsIgnoreCase("Search for dispute")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, radiobuttonName))));
			CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel, radiobuttonName))).click();
		}
		else if (radiobuttonName.equalsIgnoreCase("Reject") && pagename.equalsIgnoreCase("Approve Dispute")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, radiobuttonName))));
			CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel, radiobuttonName))).click();
		}
		else if (radiobuttonName.equalsIgnoreCase("Approve") && pagename.equalsIgnoreCase("Approve Dispute")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, radiobuttonName))));
			CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel, radiobuttonName))).click();
		}
		else if (radiobuttonName.equalsIgnoreCase("Resolved") && pagename.equalsIgnoreCase("Approve Dispute")) {	
			try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(rbtn_Resolved));
			CommonFunctions.driver.findElement(rbtn_Resolved).click();}
			catch(TimeoutException e)
			{
				//@Ext_DS_DisputerPartyReturnedforReviewandResolved
				wait.until(ExpectedConditions.visibilityOfElementLocated(rbtn_ResolvedDisputer));
				CommonFunctions.driver.findElement(rbtn_ResolvedDisputer).click();
			}
		}
		else if (radiobuttonName.equalsIgnoreCase("Escalate") && pagename.equalsIgnoreCase("Approve Dispute")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(rbtn_Escalate));
			CommonFunctions.driver.findElement(rbtn_Escalate).click();
		}
		else if (radiobuttonName.equalsIgnoreCase("Escalate") && pagename.equalsIgnoreCase("SP Approve Dispute")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(rbtn_Escalate_SP));
			CommonFunctions.driver.findElement(rbtn_Escalate_SP).click();
		}
		else if (radiobuttonName.equalsIgnoreCase("Send to Counterparty") && pagename.equalsIgnoreCase("Approve Dispute")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(rbtn_SendToCounterparty));
			CommonFunctions.driver.findElement(rbtn_SendToCounterparty).click();
		}
		else
		{
			CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
		    DisputeStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
			Assert.fail(" Button " + radiobuttonName + " has not been found");
		}
	}
	
	/**
	 * 
	 * @param buttonName
	 * @param popupScreen
	 */
	
	public static void confirmationPopup(String buttonName, String popupScreen, String page) {
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 2);
		if (page.equalsIgnoreCase("Create Dispute") && popupScreen.equalsIgnoreCase("Action Confirmation")) {
			try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(String.format(strPopUpCreateDispute, buttonName))));
			CommonFunctions.driver.findElement(By.xpath(String.format(strPopUpCreateDispute, buttonName))).click();
			}
			catch(Exception e)
			{
				if(buttonName.equalsIgnoreCase("Yes")) {
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(String.format(strPopUpCancelDispute, buttonName))));
				CommonFunctions.driver.findElement(By.xpath(String.format(strPopUpCancelDispute, buttonName))).click();}
				else {
					
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath(String.format(strPopUpCancelDispute, buttonName))));
					CommonFunctions.driver.findElement(By.xpath(String.format(strPopUpCancelDispute, buttonName))).click();
					boolean flag = CommonFunctions.driver.findElement(btn_CreateDispute).isDisplayed();
					Assert.assertEquals("User is able to cancel the dispute creation", true, flag);
					
					
				}
			}
		}

		else if (page.equalsIgnoreCase("Create Dispute")
				&& popupScreen.equalsIgnoreCase("Confirmation of dispute creation")) {
			CommonFunctions.driver.findElement(btn_Close).click();

		} 
		else if (page.equalsIgnoreCase("SP Action Dispute") && popupScreen.equalsIgnoreCase("Action Confirmation")) {
			try {
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(String.format(strPopUpADSaveasDraft_SP, buttonName))));
				CommonFunctions.driver.findElement(By.xpath(String.format(strPopUpADSaveasDraft_SP, buttonName)))
						.click();
			} catch (TimeoutException SubmitForApproval) {

				try {
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath(String.format(strPopUpADSubmit_SP, buttonName))));
					CommonFunctions.driver.findElement(By.xpath(String.format(strPopUpADSubmit_SP, buttonName)))
							.click();
				}
				// "@Int_EscalatedInternal"
				catch (TimeoutException DisputedPartySentforApproval) {
					try {
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath(String.format(strPopUpADSubmit1_SP, buttonName))));
						CommonFunctions.driver.findElement(By.xpath(String.format(strPopUpADSubmit1_SP, buttonName)))
								.click();
					}
					// "@Int_EscalatedInternalUnderReview"
					catch (TimeoutException SaveasDraftEscalation) {
                       try {
						wait.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath(String.format(strPopUpADSaveasDraft_SP_IntEsc, buttonName))));
						CommonFunctions.driver
								.findElement(By.xpath(String.format(strPopUpADSaveasDraft_SP_IntEsc, buttonName)))
								.click();
                       }
                       //"@Int_EscalatedInternalSentforApproval"
                       catch(TimeoutException SubmitforApprovalEscalation) {
                    	   
                    	   wait.until(ExpectedConditions.visibilityOfElementLocated(
   								By.xpath(String.format(strPopUpADSubmit2_SP_IntEsc, buttonName))));
   						CommonFunctions.driver
   								.findElement(By.xpath(String.format(strPopUpADSubmit2_SP_IntEsc, buttonName)))
   								.click();
                    	   
                       }
					}
				}
			}

		}
		else if (page.equalsIgnoreCase("Action Dispute")) {
			try {
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(String.format(strPopUpActionDispute, buttonName))));
				CommonFunctions.driver.findElement(By.xpath(String.format(strPopUpActionDispute, buttonName))).click();
			} catch (TimeoutException e) {
				try {
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(String.format(strPopUpActionDispute1, buttonName))));
				CommonFunctions.driver.findElement(By.xpath(String.format(strPopUpActionDispute1, buttonName))).click();
				}
				catch (TimeoutException SaveasDraft) {
					try {
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath(String.format(strPopUpADSaveasDraft, buttonName))));
					CommonFunctions.driver.findElement(By.xpath(String.format(strPopUpADSaveasDraft, buttonName))).click();}
					catch (TimeoutException SaveasDraft_Disputerlogin)
					{

						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath(String.format(strPopUpADSaveasDraft_Disputer, buttonName))));
						CommonFunctions.driver.findElement(By.xpath(String.format(strPopUpADSaveasDraft_Disputer, buttonName))).click();
					
					}
				}
			}
		} else if (page.equalsIgnoreCase("Approve Dispute")) {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(String.format(strPopUpApproveDispute, buttonName))));
			CommonFunctions.driver.findElement(By.xpath(String.format(strPopUpApproveDispute, buttonName))).click();
		} else {
			Assert.fail(" Button " + buttonName + " has not been found");
		}

	}
	
	/**
	 * 
	 * @param expConfirmationMsg
	 */
	
	
	public static void validateConfirmationMsg(String expConfirmationMsg) {
		String actConfirmationMsg=CommonFunctions.driver.findElement(By.xpath("//*[@id='successMesg']")).getText().substring(0, 112).trim();
		System.out.println("Doc string value is         :: "+expConfirmationMsg);
		System.out.println("The Actual confirmation message is :: "+actConfirmationMsg);
        Assert.assertEquals("Confirmation message did not match", expConfirmationMsg, actConfirmationMsg);
	}
	
	public static void validateConfirmationMsgPopUp(String popupScreenName, String expConfirmationMsg) throws InterruptedException {

		boolean flag = CommonFunctions.driver
				.findElement(label_SuccessMsg).isDisplayed();
		String actConfirmationMsg = CommonFunctions.driver
				.findElement(label_SuccessMsg).getText().trim();
		System.out.println("Doc string value is         :: "+expConfirmationMsg);
		System.out.println("The confirmation message on " + popupScreenName + " is :: "+actConfirmationMsg);
		Thread.sleep(2000);
		Assert.assertTrue("Dispute Creation is failed", flag);
		Assert.assertEquals("Confirmation message did not match", expConfirmationMsg, actConfirmationMsg);
		String ReferenceMsg = CommonFunctions.driver
				.findElement(label_DisputeID).getText().trim();
		String str[] = ReferenceMsg.split(":");
		DISPUTE_ID = str[1].trim();
		System.out.println("Dispute ID " + DISPUTE_ID + " is created successfully.");
		DisputeStepDefinitions.scenario.write("Dispute ID " + DISPUTE_ID + " is created successfully.");
	}
	
	/**
	 * Function to validate error message for dispute
	 * @param label
	 * @param expErrorMsg
	 */
	
	public static void validateErrorMsg(String label, String expErrorMsg) {

		if (label.equalsIgnoreCase("Non existing transaction ID")) {
			String actErrorMsg = CommonFunctions.driver.findElement(label_ErrorBlock).getText().trim();
			System.out.println("Doc string value is         :: " + expErrorMsg.trim());
			System.out.println("The Actual error message is :: " + actErrorMsg);
			Assert.assertEquals("Error message is not displaying as intended", expErrorMsg.trim(), actErrorMsg);
			System.out.println("Error message is displaying as intended");
		}
		else if (label.equalsIgnoreCase("Blank transaction ID") || label.equalsIgnoreCase("Transaction ID less than 35 Characters") ) {
			String actErrorMsg = CommonFunctions.driver.findElement(label_Error_transRefNo).getText().trim();
			System.out.println("Doc string value is         :: " + expErrorMsg.trim());
			System.out.println("The Actual error message is :: " + actErrorMsg);
			Assert.assertEquals("Error message is not displaying as intended", expErrorMsg.trim(), actErrorMsg);
			System.out.println("Error message is displaying as intended");
		}
		else if (label.equalsIgnoreCase("Blank Updated Debit Cap and Reason") || label.equalsIgnoreCase("Invalid Updated Debit Cap")) {
			int errorcount = CommonFunctions.driver.findElements(By.xpath("//form[@name='changeDebitCapForm']//*[@class='error']")).size();
			if(errorcount>0)
			{
			String  actErrorMsg  = CommonFunctions.driver.findElement(By.xpath("(//form[@name='changeDebitCapForm']//*[@class='error'])[1]")).getText().trim();
			System.out.println("Doc string value is         :: " + expErrorMsg.trim());
			System.out.println("The Actual error message is :: " + actErrorMsg);
			Assert.assertEquals("Error message is not displaying as intended", expErrorMsg.trim(), actErrorMsg);
			System.out.println("Error message is displaying as intended");
			}
			else
			{
				Assert.fail("Error message is not displaying as intended");
			}
		}

		else {
			Assert.fail("Required error label " + label + " is not defined in feature file");
		}

	}
	
	/**
	 * Function to validate GUI Items
	 * @param item
	 * @param name
	 * @param value
	 */
	public static void validateGUIItems(String pageName, String item, String name, String value) {
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 30);
		if (pageName.equalsIgnoreCase("Create Dispute")) {
			boolean flag;
			switch (name) {
			case "Transaction Amount:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel, name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				String transamt = CommonFunctions.driver.findElement(input_TransactionAmount).getAttribute("value");
				System.out.println("The value of " + name + " is  :: " + transamt);
				if (transamt.isEmpty()) {
					Assert.fail("There is no value available for label " + name);
				}
				break;
			}
			case "Transaction Status:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel, name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				String transstatus = CommonFunctions.driver.findElement(input_TransactionStatus).getAttribute("value");
				System.out.println("The value of " + name + " is  :: " + transstatus);
				if (transstatus.isEmpty()) {
					Assert.fail("There is no value available for label " + name);
				}
				break;
			}
			case "Debtor Participant:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel, name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				String receiver = CommonFunctions.driver.findElement(input_DebtorParticipant).getAttribute("value");
				System.out.println("The value of " + name + " is  :: " + receiver);
				if (receiver.isEmpty()) {
					Assert.fail("There is no value available for label " + name);
				}
				break;
			}
			case "Creditor Participant:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel, name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				String sender = CommonFunctions.driver.findElement(input_CreditorParticipant).getAttribute("value");
				System.out.println("The value of " + name + " is  :: " + sender);
				if (sender.isEmpty()) {
					Assert.fail("There is no value available for label " + name);
				}
				break;
			}
			case "Beneficiary IBAN No:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel, name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				String beneficiaryIban = CommonFunctions.driver.findElement(input_BeneficiaryIban)
						.getAttribute("value");
				System.out.println("The value of " + name + " is  :: " + beneficiaryIban);
				if (beneficiaryIban.isEmpty()) {
					Assert.fail("There is no value available for label " + name);
				}
				break;
			}
			case "Requester IBAN No:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel, name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				String requesterIban = CommonFunctions.driver.findElement(input_RequesterIban).getAttribute("value");
				System.out.println("The value of " + name + " is  :: " + requesterIban);
				if (requesterIban.isEmpty()) {
					Assert.fail("There is no value available for label " + name);
				}
				break;
			}
			case "Transaction Date & Time:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel, name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				String transactionDateTime = CommonFunctions.driver.findElement(input_TransactionDateTime)
						.getAttribute("value");
				System.out.println("The value of " + name + " is  :: " + transactionDateTime);
				if (transactionDateTime.isEmpty()) {
					Assert.fail("There is no value available for label " + name);
				}
				break;
			}
			case "Disputer Party:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel, name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			}
			case "Disputed Party:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel, name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			}
			case "Dispute Category:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel, name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			}
			case "Dispute Type:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel, name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			}
			case "Dispute Details:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel, name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			}
			case "Create Dispute": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_CreateDispute));
				flag = CommonFunctions.driver.findElement(btn_CreateDispute).isEnabled();
				Assert.assertEquals("Button " + name + " is not enabled", true, flag);
				break;
			}
			case "Cancel": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Cancel));
				flag = CommonFunctions.driver.findElement(btn_Cancel).isEnabled();
				Assert.assertEquals("Button " + name + " is not enabled", true, flag);
				break;
			}

			default:
				Assert.fail("Case " + name + " does not match. Check again");
			}
		}

		else if (pageName.equalsIgnoreCase("Search for Dispute") || pageName.equalsIgnoreCase("View All Disputes")) {
			boolean flag;
			switch (name) {
			case "Search By:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(label_SearchBy));
				flag = CommonFunctions.driver.findElement(label_SearchBy).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			}
			case "Dispute ID": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel, name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			}
			case "Dispute Status": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel, name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			}
			case "Transaction ID": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel, name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			}
			case "Advanced": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel, name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel, name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			}			
			case "Search": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Search));
				flag = CommonFunctions.driver.findElement(btn_Search).isEnabled();
				Assert.assertEquals("Button " + name + " is not enabled", true, flag);
				break;
			}
			default:
				Assert.fail("Case " + name + " does not match. Check again");
			}
		}
		else {
			Assert.fail("Required page " + pageName + " is not defined in library functions");
		}

	}
	/**
	 * Validate Confirmation or Error Message
	 * @param mdgtype
	 * @param pagename
	 * @param expConfirmationMsg
	 */
	public static void validateDisplayedMsg(String mdgtype,String pagename, String expConfirmationMsg) {

       if(pagename.equalsIgnoreCase("Change Debit Cap")) {
		String actConfirmationMsg=CommonFunctions.driver.findElement(By.xpath("//*[@id='successMesg']")).getText().substring(0, 96).trim();
		System.out.println("Doc string value is         :: "+expConfirmationMsg);
		System.out.println("The Actual confirmation message is :: "+actConfirmationMsg);
        Assert.assertEquals("Confirmation message did not match", expConfirmationMsg, actConfirmationMsg);
	}
       else if(pagename.equalsIgnoreCase("Update Threshold")) {
   		String actConfirmationMsg=CommonFunctions.driver.findElement(By.xpath("//*[@id='successMesg']")).getText().substring(0, 96).trim();
   		System.out.println("Doc string value is         :: "+expConfirmationMsg);
   		System.out.println("The Actual confirmation message is :: "+actConfirmationMsg);
           Assert.assertEquals("Confirmation message did not match", expConfirmationMsg, actConfirmationMsg);
   	}
       else 
       {
    	   Assert.fail(" Page "+pagename+" is not available");
       }
       
	}
	
	/**
	 * Function to return the column number for the header in output table
	 * @param HeaderName
	 * @return
	 */
	public static int disputeResultHeaderMapping(String HeaderName, String disputetablename)

	{
		int tableHeaderIndex, HeaderNameIndex = 0;
		boolean flag = false;
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 30);
		List<WebElement> list = new ArrayList<WebElement>();
		List<WebElement> HeaderValues = list;
		if (disputetablename.equalsIgnoreCase("searchTable") || disputetablename.equalsIgnoreCase("searchTableInt") ) {
			// List<WebElement> HeaderValues =
			// CommonFunctions.driver.findElements(tbl_EnquiryResultHeader);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(String.format(strSearchtblResulstHeader, disputetablename))));
			HeaderValues = CommonFunctions.driver
					.findElements(By.xpath(String.format(strSearchtblResulstHeader, disputetablename)));
		} else if (disputetablename.equalsIgnoreCase("viewTable") || disputetablename.equalsIgnoreCase("viewTableInt")) {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(String.format(strSearchtblResulstHeader, disputetablename))));
			HeaderValues = CommonFunctions.driver
					.findElements(By.xpath(String.format(strViewtblResulstHeader, disputetablename)));
		} else {
                 Assert.fail(disputetablename + " table is missing ");
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
			Assert.fail("Column " + HeaderName + " is not present in  " + disputetablename + "");
			return 0;
		} else {
			HeaderNameIndex = tableHeaderIndex + 1;
			System.out.println("The " + HeaderName + " is located at column number " + HeaderNameIndex);
			return HeaderNameIndex;
		}

	}

/**
 * Function to validate GUI Items
 * @param item
 * @param name
 * @param value
 */
public static void validateResultsTableItems(String tablename, String column, String value, int page, int row) {
	int columnnumber = disputeResultHeaderMapping(column, tablename);
	String ActColumnValue = CommonFunctions.driver
			.findElement(By.xpath(String.format(strTableHeaderValues,tablename, row, columnnumber))).getText();
	System.out.println(" The runtime value of " + column + " in row " + row + " under page "+page+" is :  " + ActColumnValue);
	if (!column.equalsIgnoreCase("Close Date")) {
		if (ActColumnValue.isEmpty()) {
			CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
			DisputeStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
			Assert.fail("The runtime value of " + column + " in row " + row + " is empty");
		}
	}
}
   
/**
 * Function to select value from drop down list	
 * @param value
 * @param label
 * @param page
 */

/**
 * Function to select value from drop down list    
 * @param value
 * @param label
 * @param page
 */

   public static void dropdownSelection(String value, String label, String page) {
        if (label.equalsIgnoreCase("Dispute Status")) {
            WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(select_DisputeStatusSearch));
            WebElement disputeStatus = CommonFunctions.driver.findElement(select_DisputeStatusSearch);
            Select sdisputeStatus = new Select(disputeStatus);
            try {
            sdisputeStatus.selectByVisibleText(value);
            }
            catch(NoSuchElementException e) {
                Assert.fail(value + " value is not available in "+label+" drop down list under "+page+" page");
            }
        }
    }
    
	
	/***
	 * Function for pagination 
	 * @return
	 */
	
	public static int paginationInfo(String pagename) {
		String pagination_Info = "";
		try {
			pagination_Info = CommonFunctions.driver.findElement(li_Pagination_info).getText();
		} catch (Exception e) {
			Assert.fail("Page Info for " + pagename + " is not found");
		}
		if (!pagination_Info.isEmpty()) {
			// System.out.println("The value of view table info is :: " + viewTable_Info);
			String str[] = pagination_Info.split(" ");
			int pagecount = Integer.parseInt(str[2]);
			// System.out.println("The value of pagecount is :: " + pagecount);
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

		try {
			CommonFunctions.driver.findElement(a_Pagination_Next).click();
		} catch (Exception e) {
			Assert.fail("Pagination next button for " + pagename + " is not found");
		}
	}
	
	/**
	 * Function to validate the dispute status
	 * @param column
	 * @param value
	 * @param page
	 */
	
	public static void verifyDisputeStatus(String column, String value, String page, String portal) {
		switch (page) {
		case "Search for Dispute": {
			JavascriptExecutor jse = (JavascriptExecutor) CommonFunctions.driver;
			if (column.equalsIgnoreCase("Dispute Status") && portal.equalsIgnoreCase("External")) {
				int columnnumber = disputeResultHeaderMapping(column, "searchTable");
				WebElement obj = CommonFunctions.driver
						.findElement(By.xpath(String.format(strTableHeaderValues, "searchTable", 1, columnnumber)));
				jse.executeScript("arguments[0].scrollIntoView(true);", obj);
				String ActDisputeStatus = obj.getText();
				System.out.println("The runtime value of " + column + " is :  " + ActDisputeStatus);
				Assert.assertEquals("Disute Status does not display intended value", value, ActDisputeStatus);
				DisputeStepDefinitions.scenario.write("The current value of " + column + " is :  " + ActDisputeStatus);
			} 
			else if (column.equalsIgnoreCase("Dispute Status") && portal.equalsIgnoreCase("Internal")) {
				int columnnumber = disputeResultHeaderMapping(column, "searchTableInt");
				WebElement obj= CommonFunctions.driver
						.findElement(By.xpath(String.format(strTableHeaderValues, "searchTableInt", 1, columnnumber)));
				jse.executeScript("arguments[0].scrollIntoView(true);", obj);
				String ActDisputeStatus =obj.getText();
				System.out.println("The runtime value of " + column + " is :  " + ActDisputeStatus);
				Assert.assertEquals("Disute Status does not display intended value", value, ActDisputeStatus);
				DisputeStepDefinitions.scenario.write("The current value of " + column + " is :  " + ActDisputeStatus);
			}
			else {
				Assert.fail(column + " is missing");
			}
			break;
		}
		case "View All Disputes": {
			if (column.equalsIgnoreCase("Dispute Status") && portal.equalsIgnoreCase("Internal")) {
				int columnnumber = disputeResultHeaderMapping(column, "viewTableInt");
				int columnDisputeID = disputeResultHeaderMapping("Dispute ID", "viewTableInt");
				String ActDisputeStatus = CommonFunctions.driver
						.findElement(By.xpath(String.format(strTableHeaderValues, "viewTableInt", 1, columnnumber)))
						.getText();
				String ActDisputeID = CommonFunctions.driver
						.findElement(By.xpath(String.format(strTableHeaderValues, "viewTableInt", 1, columnDisputeID)))
						.getText();
				DISPUTE_ID=ActDisputeID;
				System.out.println("The runtime value of " + column + " is :  " + ActDisputeStatus);
				Assert.assertEquals("Disute Status does not display intended value", value, ActDisputeStatus);
				DisputeStepDefinitions.scenario.write("The current value of " + column + " of Dispute ID "+DISPUTE_ID+" is :  " + ActDisputeStatus);
			} else {
				Assert.fail(column + " is missing");
			}
			break;
		}
			
		default: {
			Assert.fail(page + " page is not available");
			break;
		}
		}
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
		configuration.addClassifications("Browser", DisputeStepDefinitions.browser);
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

	
  
	// End here	
}
