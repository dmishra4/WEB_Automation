package com.sama.ach.cucumber.poc.page.ref;

import org.openqa.selenium.By;

public interface POC_PageRef {
	

	/***************** Page_Create Dispute******************************/
	
	public static final String strPopUpDispute      = "//*[@id='myModal']//button[contains(text(),'%s')]";
	public static final String strPopUpCreateDispute    = "//*[@id='myModal']//button[contains(text(),'%s')]";
	public static final String strPopUpCancelDispute    = "//*[@id='cancelModal']//button[contains(text(),'%s')]";
	public static final String strGUIlabel          = "//label[contains(text(),'%s')]";
	
	public static final By btn_CreateDispute        = By.xpath("//button[text()='Create Dispute']");
	public static final By btn_Cancel               = By.xpath("//input[@value='Cancel']");
	public static final By btn_Close                = By.xpath("//button[text()='Close']");
	public static final By btn_Submit               = By.xpath("//input[@value='Submit']");
	public static final By input_BeneficiaryIban    = By.xpath("//input[@id='beneficiaryIban']");
	public static final By input_CreditorParticipant= By.xpath("//input[@id='sender']");
	public static final By input_DebtorParticipant  = By.xpath("//input[@id='receiver']");
	public static final By input_RequesterIban      = By.xpath("//input[@id='requesterIban']");
	public static final By input_TransactionID      = By.xpath("//input[@id='transRefNo']");
	public static final By input_TransactionAmount  = By.xpath("//input[@id='transAmt']");
	public static final By input_TransactionDateTime= By.xpath("//input[@id='dateTrans']");
	public static final By input_TransactionStatus  = By.xpath("//input[@id='transStatus']");
	public static final By label_DisputeID          = By.xpath("//*[contains(text(),'Dispute Case Reference')]");
	public static final By label_SuccessMsg         = By.xpath("//form[@id='createDispForm']//p[1]");
	public static final By label_ErrorBlock         = By.xpath("//*[@id='errorBlock']");
	public static final By label_Error_transRefNo   = By.xpath("//*[@class='error error_transRefNo ']");
	public static final By select_DisputerParty     = By.xpath("//select[@id='disputerId']");
	public static final By select_DisputedParty     = By.xpath("//select[@id='disputedId']");
	public static final By select_DisputeCategory   = By.xpath("//select[@id='category']");
	public static final By select_DisputeType       = By.xpath("//select[@id='categoryType']");
	public static final By textarea_DisputeDetails  = By.xpath("//textarea[@id='commentVal']");
	
	
	/***************** Page_Dashboard******************************/
	
	public static final String strNavigate          = "%s";
	
	public static final By hCtrlCentralTitle        = By.xpath("//*[@id='ptitle']");
	public static final By btnRefresh               = By.xpath("//input[@id='IM_REFRESH']");
	
	
	
	/***************** Page_Debit Cap Management*******************/
	
	public static final String strPopUpDebitCap      = "//*[@id='confirmModal']//button[contains(text(),'%s')]";
	
	public static final By btn_SubmitDebitCap        = By.xpath("//form[@name='changeDebitCapForm']//button[@value='Submit']");
	public static final By btn_CancelDebitCap        = By.xpath("//form[@name='changeDebitCapForm']//button[@value='Cancel']");
	public static final By btn_ChangeDebitCap        = By.xpath("//button[@id='changeDebitCap']");
	public static final By btn_updateThreashold      = By.xpath("//button[@id='updateThreashold']");
	public static final By input_UpdatedDebitCap     = By.xpath("//input[@id='debCap']");
	public static final By p_DebitCapinSAR           = By.xpath("//p[contains(text(),'Debit Cap in SAR')]");
	public static final By p_DebitCap                = By.xpath("//p[@id='debitCap']");
	public static final By p_HighThreshold           = By.xpath("//p[contains(text(),'High Threshold (%)')]");
	public static final By p_HighThresholdPercentage = By.xpath("//p[@id='highThresholdPercentage']");
	public static final By p_LowThreshold            = By.xpath("//p[contains(text(),'Low Threshold (%)')]");
	public static final By p_LowThresholdPercentage  = By.xpath("//p[@id='lowThresholdPercentage']");
	public static final By textarea_ReasonforDCUpdate= By.xpath("//textarea[@id='reason']");
	
	/***************** Page_Welcome******************************/
	
	public static final By a_LogIn                  = By.xpath("//li[@id='wpthemeLogin']/a");
	public static final By a_Portal_Selection       = By.xpath("//a[@id='wpToolbarSitesNavMenu']");
	public static final By SaudiPayments            = By.xpath("//*[text()='Saudi Payments']");
	public static final By span_SaudiPayments_Int   = By.xpath("//*[text()='Saudi Payments']");
	public static final By span_SaudiPayments_Ext   = By.xpath("//*[text()='Saudi Payments Ext']");
	
	/***************** Page_Login ******************************/
	

	public static final By input_UserID = By.xpath("//input[@id='userID']");
	public static final By input_Password = By.xpath("//input[@id='password']");
	public static final By btn_Login = By.xpath("//input[@id='login.button.login']");
	public static final By text_LoginError = By.xpath("//*[@class='wpsFieldSuccessText']");
	
	


	//**************************     Internal Portal Login #############################
	     
	     
	     public static final By input_UserName            = By.xpath("//input[@id='username']");
//	     public static final By input_Password            = By.xpath("//input[@id='password']");
	     public static final By btn_InternalLogin         = By.xpath("//input[@id='loginFormSubmit']");
	     public static final By text_LoginErrorInternal   = By.xpath("//*[@class='loginError']");

	 

	 
	//**************************     External Portal Login #############################
	     
	     
//	     public static final By input_UserName            = By.xpath("//input[@id='username']");
//	     public static final By input_Password            = By.xpath("//input[@id='password']");
	     public static final By btn_ExternalLogin         = By.xpath("//input[@value='Login']");
	     public static final By text_LoginErrorExternal   = By.xpath("//*[@id='errId']");
	     public static final By text_otp_external         = By.xpath("//* [@id='otpHintSpan']");
	     public static final By input_otp_password_ext    = By.xpath("//input [@id = 'otppswd']");
	     public static final By input_otp_submit_ext      = By.xpath("//input [@id = 'SubmitOTP']");
	     
	     
	 

	
	/** Log out */
	   
	     public static final By a_Logout                = By.xpath("//a[@id='logoutlink']");
	     public static final By btn_Logout_Yes          = By.xpath("//a[@class='whiteText']//button[contains(text(),'Yes')]");
	     public static final By btn_Logout_Cancel       = By.xpath("//button[contains(text(),'Cancel')]");

}
