package com.sama.ach.cucumber.poc.utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sama.ach.cucumber.poc.page.ref.POC_PageRef;
import com.sama.ach.cucumber.poc.stepdefs.POC_StepDefinitions;

public class SamaAchLib implements POC_PageRef {
	
	
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
	
	
	public static void enterSingleValue(String label_name, String label_value, String buttonName)
	{
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 50);
		if(label_name.equalsIgnoreCase("Transaction ID"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(input_TransactionID));
			CommonFunctions.driver.findElement(input_TransactionID).clear();
			CommonFunctions.driver.findElement(input_TransactionID).sendKeys(label_value);
			//CommonFunctions.driver.findElement(By.xpath("//input[@value='"+buttonName+"']")).click();
			CommonFunctions.driver.findElement(btn_Submit).click();
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
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 50);
		// Page Name :: Update Debit Cap & Threshold Request
		if (page.equalsIgnoreCase("Debit Cap Management")) {
			switch (field_name) {
			case "Updated Debit Cap": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_UpdatedDebitCap));
				CommonFunctions.driver.findElement(input_UpdatedDebitCap).sendKeys(field_value);
				CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
				//POC_StepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
				break;
			}
			case "Reason for Debit Cap Update": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(textarea_ReasonforDCUpdate));
				CommonFunctions.driver.findElement(textarea_ReasonforDCUpdate).clear();
				CommonFunctions.driver.findElement(textarea_ReasonforDCUpdate).sendKeys(field_value);;
				break;
			}
			default:
				Assert.fail("Required field " + field_name + " is not available in feature file");
			}
		}
		else if (page.equalsIgnoreCase("Create Dispute")) {
			switch (field_name) {
			case "Disputer Party": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_DisputerParty));
				WebElement disputerParty= CommonFunctions.driver.findElement(select_DisputerParty);
				Select sdisputerParty = new Select(disputerParty);
				sdisputerParty.selectByVisibleText(field_value);
				break;
			}
			case "Disputed Party": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_DisputedParty));
				WebElement disputedParty= CommonFunctions.driver.findElement(select_DisputedParty);
				Select sdisputedParty = new Select(disputedParty);
				sdisputedParty.selectByVisibleText(field_value);
				break;
			}
			case "Dispute Category": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_DisputeCategory));
				WebElement disputeCategory= CommonFunctions.driver.findElement(select_DisputeCategory);
				Select sdisputeCategory = new Select(disputeCategory);
				sdisputeCategory.selectByVisibleText(field_value);
				break;
			}
			case "Dispute Type": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(select_DisputeType));
				WebElement disputeType= CommonFunctions.driver.findElement(select_DisputeType);
				Select sdisputeType = new Select(disputeType);
				sdisputeType.selectByVisibleText(field_value);
				break;
			}
			case "Dispute Details": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(textarea_DisputeDetails));
				WebElement disputeDetails= CommonFunctions.driver.findElement(textarea_DisputeDetails);
				disputeDetails.sendKeys(field_value);
				break;
			}
			
			default:
				Assert.fail("Required field " + field_name + " is not available in feature file");
			}
		}
		
		else
		{
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
		if (pageName.equalsIgnoreCase("Debit Cap Management")) {
		switch (buttonName) {
		case "Change Debit Cap":
			wait.until(ExpectedConditions.visibilityOfElementLocated(btn_ChangeDebitCap));
			CommonFunctions.driver.findElement(btn_ChangeDebitCap).click();
			break;
		case "Submit":
			wait.until(ExpectedConditions.visibilityOfElementLocated(btn_SubmitDebitCap));
			CommonFunctions.driver.findElement(btn_SubmitDebitCap).click();
			break;
		case "Cancel":
			wait.until(ExpectedConditions.visibilityOfElementLocated(btn_CancelDebitCap));
			CommonFunctions.driver.findElement(btn_CancelDebitCap).click();
			boolean flag = CommonFunctions.driver.findElement(btn_SubmitDebitCap).isDisplayed();
			Assert.assertEquals("Cancle button is not working as intended", false, flag);
			break;
		default:
			Assert.fail(" Button " + buttonName + " has not been found");

		}
		}
		else if (pageName.equalsIgnoreCase("Create Dispute")) {
			switch (buttonName) {
			case "Submit": {
				//WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Submit));
				CommonFunctions.driver.findElement(btn_Submit).click();
				CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");				
				break;
			}
			case "Create Dispute": {
				//WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_CreateDispute));
				CommonFunctions.driver.findElement(btn_CreateDispute).click();
				//CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");				
				break;
			}
			default:
				Assert.fail(" Button " + buttonName + " has not been found");
			}
		}		
		else
		{
			Assert.fail("Required page " + pageName + " is not defined in library functions");
		}
	}
	
	public static void confirmationPopupBackup(String buttonName, String popupScreen)
	{
		
		if (popupScreen.equalsIgnoreCase("Debit Cap Management"))
		{
			CommonFunctions.driver.findElement(By.xpath(String.format(strPopUpDebitCap, buttonName))).click();
			if (buttonName.equalsIgnoreCase("No")) {
				boolean flag = CommonFunctions.driver.findElement(btn_SubmitDebitCap).isEnabled();
				Assert.assertEquals("No button is not working as intended", true, flag);
			}
		}
		else if (popupScreen.equalsIgnoreCase("Action Confirmation"))
		{
			CommonFunctions.driver.findElement(By.xpath(String.format(strPopUpDispute,buttonName)))
			.click();
		}

		else if (popupScreen.equalsIgnoreCase("Confirmation of dispute creation"))
		{
			CommonFunctions.driver.findElement(btn_Close).click();
		
		}
		else
		{
			Assert.fail(" Button " + buttonName + " has not been found");
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
			} catch (Exception e) {
				if (buttonName.equalsIgnoreCase("Yes")) {
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath(String.format(strPopUpCancelDispute, buttonName))));
					CommonFunctions.driver.findElement(By.xpath(String.format(strPopUpCancelDispute, buttonName)))
							.click();
				} else {

					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath(String.format(strPopUpCancelDispute, buttonName))));
					CommonFunctions.driver.findElement(By.xpath(String.format(strPopUpCancelDispute, buttonName)))
							.click();
					boolean flag = CommonFunctions.driver.findElement(btn_CreateDispute).isDisplayed();
					Assert.assertEquals("User is able to cancel the dispute creation", true, flag);

				}
			}
		}

		else if (page.equalsIgnoreCase("Create Dispute")
				&& popupScreen.equalsIgnoreCase("Confirmation of dispute creation")) {
			CommonFunctions.driver.findElement(btn_Close).click();

		}

		else if (page.equalsIgnoreCase("Debit Cap Management")
				&& popupScreen.equalsIgnoreCase("Confirm Debit Cap Change")) {
			CommonFunctions.driver.findElement(By.xpath(String.format(strPopUpDebitCap, buttonName))).click();
			if (buttonName.equalsIgnoreCase("No")) {
				boolean flag = CommonFunctions.driver.findElement(btn_SubmitDebitCap).isEnabled();
				Assert.assertEquals("No button is not working as intended", true, flag);
			}
		} else {
			Assert.fail(" Button " + buttonName + " has not been found");
		}

	}
	
	
	
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
		POC_StepDefinitions.scenario.write("Dispute ID " + DISPUTE_ID + " is created successfully.");
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
		else if (label.equalsIgnoreCase("Blank transaction ID") || label.equalsIgnoreCase("Transaction ID less than 34 Characters") ) {
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
		if (pageName.equalsIgnoreCase("Debit Cap Management")) {
			switch (name) {
			case "Debit Cap in SAR": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(p_DebitCapinSAR));
				String actdebitcapvalue = CommonFunctions.driver.findElement(p_DebitCap).getText();
				Assert.assertNotNull("Debit Cab value is null", actdebitcapvalue);
				break;
			}
			case "High Threshold": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(p_HighThreshold));
				String acthighthreshold = CommonFunctions.driver.findElement(p_HighThresholdPercentage).getText();
				Assert.assertNotNull("The value of High Threshold is null", acthighthreshold);
				break;
			}
			case "Low Threshold": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(p_LowThreshold));
				String actlowthreshold = CommonFunctions.driver.findElement(p_LowThresholdPercentage).getText();
				Assert.assertNotNull("The value of Low Threshold is null", actlowthreshold);
				break;
			}
			case "Change Debit Cap": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_ChangeDebitCap));
				boolean flag = CommonFunctions.driver.findElement(btn_ChangeDebitCap).isEnabled();
				Assert.assertEquals("Button " + name + " is not enabled", true, flag);
				break;
			}
			case "Update Threshold": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_updateThreashold));
				boolean flag = CommonFunctions.driver.findElement(btn_updateThreashold).isEnabled();
				Assert.assertEquals("Button " + name + " is not enabled", true, flag);
				break;
			}

			default:
				Assert.fail("Case does not match. Check again");
			}
		} else if (pageName.equalsIgnoreCase("Create Dispute")) {
			boolean flag;
			switch (name) {
			case "Transaction Amount:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				String transamt = CommonFunctions.driver.findElement(input_TransactionAmount).getAttribute("value");
				System.out.println("The value of "+name+" is  :: "+transamt);
				if(transamt.isEmpty())
				{
				Assert.fail("There is no value available for label "+name);
				}
				break;
			}
			case "Transaction Status:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				String transstatus = CommonFunctions.driver.findElement(input_TransactionStatus).getAttribute("value");
				System.out.println("The value of "+name+" is  :: "+transstatus);
				if(transstatus.isEmpty())
				{
				Assert.fail("There is no value available for label "+name);
				}
				break;
			}
			case "Debtor Participant:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);				
				String receiver = CommonFunctions.driver.findElement(input_DebtorParticipant).getAttribute("value");
				System.out.println("The value of "+name+" is  :: "+receiver);
				if(receiver.isEmpty())
				{
				Assert.fail("There is no value available for label "+name);
				}
				break;
			}
			case "Creditor Participant:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				String sender = CommonFunctions.driver.findElement(input_CreditorParticipant).getAttribute("value");
				System.out.println("The value of "+name+" is  :: "+sender);
				if(sender.isEmpty())
				{
				Assert.fail("There is no value available for label "+name);
				}
				break;
			}
			case "Beneficiary IBAN No:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				String beneficiaryIban = CommonFunctions.driver.findElement(input_BeneficiaryIban).getAttribute("value");
				System.out.println("The value of "+name+" is  :: "+beneficiaryIban);
				if(beneficiaryIban.isEmpty())
				{
				Assert.fail("There is no value available for label "+name);
				}
				break;
			}
			case "Requester IBAN No:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				String requesterIban = CommonFunctions.driver.findElement(input_RequesterIban).getAttribute("value");
				System.out.println("The value of "+name+" is  :: "+requesterIban);
				if(requesterIban.isEmpty())
				{
				Assert.fail("There is no value available for label "+name);
				}
				break;
			}
			case "Transaction Date & Time:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				String transactionDateTime = CommonFunctions.driver.findElement(input_TransactionDateTime).getAttribute("value");
				System.out.println("The value of "+name+" is  :: "+transactionDateTime);
				if(transactionDateTime.isEmpty())
				{
				Assert.fail("There is no value available for label "+name);
				}
				break;
			}
			case "Disputer Party:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			}
			case "Disputed Party:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			}
			case "Dispute Category:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			}
			case "Dispute Type:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
				Assert.assertEquals("Label " + name + " is not displayed", true, flag);
				break;
			}
			case "Dispute Details:": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(strGUIlabel,name))));
				flag = CommonFunctions.driver.findElement(By.xpath(String.format(strGUIlabel,name))).isDisplayed();
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
				Assert.fail("Case "+name+" does not match. Check again");
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
//End here

}
