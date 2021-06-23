package com.sama.ach.cucumber.debitcapmgt.page.ref;

import org.openqa.selenium.By;

public interface DebitCapMgtPageRef {
	
	
	/***************** Page_Debit Cap Management*******************/
	
	public static final String strPopUpDebitCap      = "//*[@id='confirmModal']//button[contains(text(),'%s')]";
	public static final String strPopUpThreshold     = "//*[@id='thresholdConfirmModal']//button[contains(text(),'%s')]";
	
	public static final By btn_SubmitDebitCap        = By.xpath("//form[@name='changeDebitCapForm']//button[@value='Submit']");
	public static final By btn_CancelDebitCap        = By.xpath("//form[@name='changeDebitCapForm']//button[@value='Cancel']");
	public static final By btn_SubmitThreshold       = By.xpath("//form[@name='updateThreasholdForm']//button[@value='Submit']");
	public static final By btn_CancelThreshold       = By.xpath("//form[@name='updateThreasholdForm']//button[@value='Cancel']");
	public static final By btn_ChangeDebitCap        = By.xpath("//button[@id='changeDebitCap']");
	public static final By btn_UpdateThreshold       = By.xpath("//button[@id='updateThreashold']");
	public static final By input_UpdatedDebitCap     = By.xpath("//input[@id='debCap']");
	public static final By input_ThresholdValue      = By.xpath("//input[@id='rangeNum']");
	public static final By label_HighThreshold       = By.xpath("//label[@for='high']");
	public static final By label_LowThreshold        = By.xpath("//label[@for='low']");
	public static final By label_ThresholdValue      = By.xpath("//p[contains(text(),'Threshold Value (%)')]");
	public static final By p_DebitCapinSAR           = By.xpath("//p[contains(text(),'Debit Cap in SAR')]");
	public static final By p_DebitCap                = By.xpath("//p[@id='debitCap']");
	public static final By p_HighThreshold           = By.xpath("//p[contains(text(),'High Threshold (%)')]");
	public static final By p_HighThresholdPercentage = By.xpath("//p[@id='highThresholdPercentage']");
	public static final By p_LowThreshold            = By.xpath("//p[contains(text(),'Low Threshold (%)')]");
	public static final By p_LowThresholdPercentage  = By.xpath("//p[@id='lowThresholdPercentage']");
	public static final By textarea_ReasonforDCUpdate= By.xpath("//textarea[@id='reason']");
	
/***************** Page_Dashboard******************************/
	
	public static final String strNavigate          = "%s";

}
