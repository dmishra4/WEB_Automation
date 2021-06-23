package com.sama.ach.cucumber.debitcapmgt.utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sama.ach.cucumber.debitcapmgt.page.ref.DebitCapMgtPageRef;
import com.sama.ach.cucumber.debitcapmgt.stepdefs.DebitCapMgtStepDefinitions;
import com.sama.ach.cucumber.poc.utils.CommonFunctions;

public class DebitCapMgtLib implements DebitCapMgtPageRef {
		
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
	/**
	 * Function to enter Single Value.
	 * @param label_name
	 * @param label_value
	 * @param buttonName
	 */
	
	public static void enterSingleValue(String label_name, String label_value, String buttonName) {
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 50);
		if (label_name.equalsIgnoreCase("Threshold Value")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(input_ThresholdValue));
			CommonFunctions.driver.findElement(input_ThresholdValue).sendKeys(label_value);
			CommonFunctions.driver.findElement(btn_SubmitThreshold).click();
		}
		else if (label_name.equalsIgnoreCase("Valid Threshold Value")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(input_ThresholdValue));
			if (DebitCapMgtStepDefinitions.thresholdradiobutton.equalsIgnoreCase("High")) {
				String actlowthreshold = CommonFunctions.driver.findElement(p_LowThresholdPercentage).getText();
				String str[] = actlowthreshold.split("%");
				int low = Integer.parseInt(str[0]);
				int high = Integer.parseInt(label_value);
				if (high > low) {
					CommonFunctions.driver.findElement(input_ThresholdValue).sendKeys(label_value);
					CommonFunctions.driver.findElement(btn_SubmitThreshold).click();
				} else {
					CommonFunctions.driver.findElement(input_ThresholdValue).sendKeys(label_value);
					CommonFunctions.driver.findElement(btn_SubmitThreshold).click();
					DebitCapMgtStepDefinitions.scenario.write("High Threshold value must be greater than Low Threshold value");
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DebitCapMgtStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("High Threshold value must be greater than Low Threshold value");
					
				}
			}
			else {
				String acthighthreshold = CommonFunctions.driver.findElement(p_HighThresholdPercentage).getText();
				String str[] = acthighthreshold.split("%");
				int high = Integer.parseInt(str[0]);
				int low = Integer.parseInt(label_value);
				if (low < high) {
					CommonFunctions.driver.findElement(input_ThresholdValue).sendKeys(label_value);
					CommonFunctions.driver.findElement(btn_SubmitThreshold).click();
				} else {
					CommonFunctions.driver.findElement(input_ThresholdValue).sendKeys(label_value);
					CommonFunctions.driver.findElement(btn_SubmitThreshold).click();
					DebitCapMgtStepDefinitions.scenario.write("Low Threshold value must be greater than 0 and less than High Threshold");
					CommonFunctions.snapshot = CommonFunctions.getSnapshot(CommonFunctions.driver, "screenshot");
					DebitCapMgtStepDefinitions.scenario.embed(CommonFunctions.snapshot, "image/png");
					Assert.fail("Low Threshold value must be greater than 0 and less than High Threshold");
				}
			}
				
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
			case "Threshold Value": {
				wait.until(ExpectedConditions.visibilityOfElementLocated(input_ThresholdValue));
				CommonFunctions.driver.findElement(input_ThresholdValue).clear();
				CommonFunctions.driver.findElement(input_ThresholdValue).sendKeys(field_value);;
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
			case "Cancel":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_CancelDebitCap));
				CommonFunctions.driver.findElement(btn_CancelDebitCap).click();
				boolean flag = CommonFunctions.driver.findElement(btn_SubmitDebitCap).isDisplayed();
				Assert.assertEquals("Cancle button is not working as intended", false, flag);
				break;
			case "Change Debit Cap":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_ChangeDebitCap));
				CommonFunctions.driver.findElement(btn_ChangeDebitCap).click();
				break;
			case "Submit":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_SubmitDebitCap));
				CommonFunctions.driver.findElement(btn_SubmitDebitCap).click();
				break;
			case "Update Threshold":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_UpdateThreshold));
				CommonFunctions.driver.findElement(btn_UpdateThreshold).click();								
				break;
			default:
				Assert.fail(" Button " + buttonName + " has not been found");

			}
		} 
		
		else if (pageName.equalsIgnoreCase("Request to change Debit Cap & Threshold")) {
			switch (buttonName) {
			case "Cancel":
				wait.until(ExpectedConditions.visibilityOfElementLocated(btn_CancelThreshold));
				CommonFunctions.driver.findElement(btn_CancelThreshold).click();
				boolean flag = CommonFunctions.driver.findElement(btn_SubmitThreshold).isDisplayed();
				Assert.assertEquals("Cancle button is not working as intended", false, flag);
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
	
	
	public static void clickRadioButton(String radiobuttonName, String pageName) throws Exception {
		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 30);
		if (radiobuttonName.equalsIgnoreCase("High")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(label_HighThreshold));
			CommonFunctions.driver.findElement(label_HighThreshold).click();
		} else if (radiobuttonName.equalsIgnoreCase("Low")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(label_LowThreshold));
			CommonFunctions.driver.findElement(label_LowThreshold).click();
		} else
			Assert.fail(" Button " + radiobuttonName + " has not been found");

	}
	public static void confirmationPopup(String buttonName, String popupScreen)
	{
		
		if (popupScreen.equalsIgnoreCase("Debit Cap Management"))
		{
			CommonFunctions.driver.findElement(By.xpath(String.format(strPopUpDebitCap, buttonName))).click();
			if (buttonName.equalsIgnoreCase("No")) {
				boolean flag = CommonFunctions.driver.findElement(btn_SubmitDebitCap).isEnabled();
				Assert.assertEquals("No button is not working as intended", true, flag);
			}
		}
		else if(popupScreen.equalsIgnoreCase("Confirm Threshold Change"))
		{
			CommonFunctions.driver.findElement(By.xpath(String.format(strPopUpThreshold, buttonName))).click();
			if (buttonName.equalsIgnoreCase("No")) {
				boolean flag = CommonFunctions.driver.findElement(btn_SubmitThreshold).isEnabled();
				Assert.assertEquals("No button is not working as intended", true, flag);
			}
		}
		else
		{
			Assert.fail(" Button " + buttonName + " has not been found");
		}
		
	}
	
	public static void validateConfirmationMsg(String expConfirmationMsg) {


		String actConfirmationMsg=CommonFunctions.driver.findElement(By.xpath("//*[@id='successMesg']")).getText().substring(0, 112).trim();
		System.out.println("Doc string value is         :: "+expConfirmationMsg);
		System.out.println("The Actual confirmation message is :: "+actConfirmationMsg);
        Assert.assertEquals("Confirmation message did not match", expConfirmationMsg, actConfirmationMsg);
	}
	
	/**
	 * Validate Confirmation or Error Message
	 * @param mdgtype
	 * @param pagename
	 * @param expConfirmationMsg
	 */
	public static void validateDisplayedMsg(String mdgtype,String pagename, String expConfirmationMsg) {

       if(pagename.equalsIgnoreCase("Change Debit Cap")) {
		String actConfirmationMsg=CommonFunctions.driver.findElement(By.xpath("//*[@id='successMesg']")).getText().substring(0, 112).trim();
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
	
	/*
	 * public static void validateConfirmationMsgPopUp(String popupScreenName,
	 * String expConfirmationMsg) throws InterruptedException {
	 * 
	 * boolean flag = CommonFunctions.driver
	 * .findElement(label_SuccessMsg).isDisplayed(); String actConfirmationMsg =
	 * CommonFunctions.driver .findElement(label_SuccessMsg).getText().trim();
	 * System.out.println("Doc string value is         :: "+expConfirmationMsg);
	 * System.out.println("The confirmation message on " + popupScreenName +
	 * " is :: "+actConfirmationMsg); Thread.sleep(2000);
	 * Assert.assertTrue("Dispute Creation is failed", flag);
	 * Assert.assertEquals("Confirmation message did not match", expConfirmationMsg,
	 * actConfirmationMsg); String ReferenceMsg = CommonFunctions.driver
	 * .findElement(label_DisputeID).getText().trim(); String str[] =
	 * ReferenceMsg.split(":"); DISPUTE_ID = str[1].trim();
	 * System.out.println("Dispute ID " + DISPUTE_ID + " is created successfully.");
	 * POC_StepDefinitions.scenario.write("Dispute ID " + DISPUTE_ID +
	 * " is created successfully."); }
	 */
	
	/**
	 * Function to validate error message for dispute
	 * @param label
	 * @param expErrorMsg
	 */
	
	public static void validateErrorMsg(String label, String expErrorMsg) {

		if (label.equalsIgnoreCase("Blank Updated Debit Cap and Reason")
				|| label.equalsIgnoreCase("Invalid Updated Debit Cap")) {
			int errorcount = CommonFunctions.driver
					.findElements(By.xpath("//form[@name='changeDebitCapForm']//*[@class='error']")).size();
			if (errorcount > 0) {
				String actErrorMsg = CommonFunctions.driver
						.findElement(By.xpath("(//form[@name='changeDebitCapForm']//*[@class='error'])[1]")).getText()
						.trim();
				System.out.println("Doc string value is         :: " + expErrorMsg.trim());
				System.out.println("The Actual error message is :: " + actErrorMsg);
				Assert.assertEquals("Error message is not displaying as intended", expErrorMsg.trim(), actErrorMsg);
				System.out.println("Error message is displaying as intended");
			}
		} else if (label.equalsIgnoreCase("Blank Threshold Value")) {
			int errcount = CommonFunctions.driver
					.findElements(By.xpath("//*[text()='Please complete the Required Fields']")).size();
			if (errcount > 0) {
				String actErrorMsg = CommonFunctions.driver
						.findElement(By.xpath("(//*[text()='Please complete the Required Fields'])[1]")).getText()
						.trim();
				System.out.println("Doc string value is         :: " + expErrorMsg.trim());
				System.out.println("The Actual error message is :: " + actErrorMsg);
				Assert.assertEquals("Error message is not displaying as intended", expErrorMsg.trim(), actErrorMsg);
				System.out.println("Error message is displaying as intended");
			} else {
				Assert.fail("Error message is not displaying as intended");
			}
		}
		else if (label.equalsIgnoreCase("Invalid Threshold Value")) {
			int errcount = CommonFunctions.driver
					.findElements(By.xpath("//*[contains(text(),'Invalid value')]")).size();
			if (errcount > 0) {
				String actErrorMsg = CommonFunctions.driver
						.findElement(By.xpath("(//*[contains(text(),'Invalid value')])[1]")).getText()
						.trim();
				System.out.println("Doc string value is         :: " + expErrorMsg.trim());
				System.out.println("The Actual error message is :: " + actErrorMsg);
				Assert.assertEquals("Error message is not displaying as intended", expErrorMsg.trim(), actErrorMsg);
				System.out.println("Error message is displaying as intended");
			} else {
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
	public static void validateGUIItems(String item, String name, String value) {

		WebDriverWait wait = new WebDriverWait(CommonFunctions.driver, 30);
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
			wait.until(ExpectedConditions.visibilityOfElementLocated(btn_UpdateThreshold));
			boolean flag = CommonFunctions.driver.findElement(btn_UpdateThreshold).isEnabled();
			Assert.assertEquals("Button " + name + " is not enabled", true, flag);
			break;
		}
		case "Threshold Value": {
			wait.until(ExpectedConditions.visibilityOfElementLocated(label_ThresholdValue));
			boolean flag = CommonFunctions.driver.findElement(label_ThresholdValue).isDisplayed();
			Assert.assertEquals("Button " + name + " is not displayed", true, flag);
			break;
		}

		default:
			Assert.fail("Case does not match. Check again");
		}
	}

//End here
   
}
