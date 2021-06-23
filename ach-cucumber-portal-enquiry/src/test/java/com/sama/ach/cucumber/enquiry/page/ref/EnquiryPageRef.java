package com.sama.ach.cucumber.enquiry.page.ref;

import org.openqa.selenium.By;

public interface EnquiryPageRef {
	
/***************** Page_Participant Position Enquiry & Retrieve Participant Status (Single Participant)*******************/
	
	public static final By input_ParticipantID      =  By.xpath("//input[@id='participantId']");
		
/***************** Page_Participant Settlement Positions*******************/
	
	public static final By input_SettlementDate     = By.xpath("//input[@id='settlementCycleDate']");
	public static final By label_settlementCycleId  = By.xpath("//label[text()='Settlement Cycle ID']");
	public static final By label_SettlementDate     = By.xpath("//label[contains(text(),'Settlement Date')]");
	public static final By select_settlementCycleId = By.xpath("//select[@id='settlementCycleId']");
	

/***************** Page_Value Transaction Enquiry*******************/
	
	public static final String strTodayResults          = "//*[@id='todayResults']//table//tbody/tr[%s]/td[%s]";
	
	
	public static final By btn_ClearScreenVTE       	= By.xpath("//*[@id='Advance']//button[text()='Clear Screen']");
	public static final By btn_TransactionClearScreen  	= By.xpath("//*[@id='Transaction']//button[text()='Clear Screen']");
	public static final By btn_AdvanceSubmitVTE         = By.xpath("//*[@id='Advance']//button[text()='Submit']");
	public static final By btn_TransactionSubmitVTE		= By.xpath("//*[@id='Transaction']//button[text()='Submit']");
	public static final By input_DateEnd				= By.xpath("//input [@id='dateEnd']");
	public static final By input_DateStart				= By.xpath("//input [@id='dateStart']");
	public static final By input_TransactionAmount 		= By.xpath("//input [@id='transactionAmount']");
	public static final By input_TransactionId      	= By.xpath("//input[@id='transactionId']");
	public static final By input_ReasonCode 			= By.xpath("//input [@id='reasonCode']");
	public static final By input_RoutingNumber 			= By.xpath("//input [@id ='routingNumber']");
	public static final By select_CategoryPurposeCode 	= By.xpath("//select [@id='categoryPurposeCode']");
	public static final By select_LocalInstrument 	   	= By.xpath("//select [@id ='localInstrument']");
	public static final By select_settlementCycleIdVTE 	= By.xpath("//select[@id='settlementCycleID']");
	public static final By select_TransactionStatus 	= By.xpath("//select [@id='transactionStatus']");
	public static final By tbl_TodayResults				= By.xpath("//*[@id='todayResults']//table//tbody/tr");
	public static final By tbl_EnquiryResultHeaderVT  	= By.xpath("//*[@id='todayResults']//table/thead/tr[2]/th");
			
	
	/***************** Page_Retrieve Participant SNM*******************/
	public static final String strSNMResults          = "//table[@id='rpsDataTable']//tbody/tr[%s]/td[%s]";
	
	public static final By input_rpsEndDate				= By.xpath("//input [@id='rpsEndDate']");
	public static final By input_rpsStartDate			= By.xpath("//input [@name='startDate']");
	public static final By select_EventTypes			= By.xpath("//select [@id='eventTypes']");
	public static final By tbl_ParticipantSNM 			= By.xpath("//table [@id='rpsDataTable']//tbody/tr");
	public static final By tbl_ParticipantSNMHeader 	= By.xpath("//table [@id='rpsDataTable']/thead/tr[2]/th");
	
	/***************** Page_View Settlement Calendar*******************/
	
	public static final String strViewSettlementCalendar = "//table[@id='vrwcDataTable']//tbody/tr[%s]/td[%s]";
		
	public static final By input_fromDate				= By.xpath("//input [@id='fromDate']");
	public static final By input_toDate					= By.xpath("//input [@id='toDate']");
	public static final By tbl_ViewSettlementCalendar 	= By.xpath("//table [@id='vrwcDataTable']//tbody/tr");
	public static final By tbl_ViewSettlementCalendarHeader   = By.xpath("//table [@id='vrwcDataTable']/thead/tr[2]/th");
	
	/***************** Page_ Retrieve Settlement Summary *******************/
	
	public static final String strRetrieveSettlementSummary = "//table[@id='rrwsDataTable']//tbody/tr[%s]/td[%s]";
	
	public static final By select_currencyIsoCode 	= By.xpath("//select[@id='currencyIsoCode']");
	public static final By tbl_RetrieveSettlementSummary= By.xpath("//table [@id='rrwsDataTable']//tbody/tr");
	public static final By tbl_RetrieveSettlementSummaryHeader = By.xpath("//table [@id='rrwsDataTable']/thead/tr[2]/th");
	
	/******************  Page_Unbilled Activities *************/
	
	public static final By select_PartcipantID = By.xpath("//select[@id='participantId']");
	
	/***************** Page_Dispute Details*******************/	
	
	public static final By input_EndDate				= By.xpath("//input [@id='endDate']");
	public static final By input_StartDate				= By.xpath("//input [@id='startDate']");
	public static final By select_DisputerParty			= By.xpath("//select [@id='disputerParty']");
	public static final By select_DisputedParty			= By.xpath("//select [@id='disputedParty']");
	public static final By select_DisputeStatus			= By.xpath("//select [@id='disputeStatus']");	
	
	/***************** Page_Registration Enquiries******************************/
	
	public static final By btn_RegistrationEnqSubmit    = By.xpath("//*[@id='ERI']//button[contains(text(),'Submit')]");
	public static final By btn_RegistrationEnqClrScreen = By.xpath("//*[@id='ERI']//button[contains(text(),'Clear Screen')]");
	public static final By btn_Select               	= By.xpath("//button[contains(text(),'Select')]");
	public static final By input_ParticipantCode      	=  By.xpath("//input[@id='eriParticipantId']");
	public static final By input_RegistrationId			= By.xpath("//input [@id='registrationId']");
	public static final By select_EnquiryMPP			= By.xpath("//select [@id='filterText2']");
			
/***************** Page_Common******************************/
	
	public static final String strNavigate            = "%s";
//	public static final String strGUIlabel			  = "//*[text()='%s']";
	public static final String strGUIlabel			  = "//label[contains(text(),'%s')]";
	public static final String strResults             = "//*[@id='results']//table//tbody/tr[%s]/td[%s]";
	public static final String strGUIDetailslabel     = "//label[contains(text(),'%s')]//following::div[1]";
		
	public static final By btn_ClearScreen            = By.xpath("//button[text()='Clear Screen']");
	public static final By btn_Close                  = By.xpath("//button[text()='Close']");
	public static final By btn_Details                = By.xpath("//button[text()='Details']");
	public static final By btn_ExportToCSV            = By.xpath("//button[@title='Export to CSV']");
	public static final By btn_Submit                 = By.xpath("//button[text()='Submit']");
	public static final By select_PartcipantSelection = By.xpath("//select[@id='filterText1']");
	public static final By tbl_EnquiryResultHeader    = By.xpath("//*[@id='results']//table/thead/tr[2]/th");
	public static final By tbl_Results                = By.xpath("//*[@id='results']//table//tbody/tr");
		
	/***************** Page_Pagination******************************/
	
	public static final By results_Pagination_info  = By.xpath("//*[@id='results']//*[@class='dataTables_info']");
	public static final By pp_Pagination_info       = By.xpath("//*[@id='pfpResultTable_info']");
	public static final By put_Pagination_info      = By.xpath("//*[@id='puttResultTable_info']");
	public static final By rps_Pagination_info      = By.xpath("//*[@id='rpsDataTable_info']");
	public static final By psp_Pagination_info      = By.xpath("//*[@id='rrpDataTable_info']");
	public static final By rss_Pagination_info      = By.xpath("//*[@id='rrwsDataTable_info']");
	public static final By scs_Pagination_info      = By.xpath("//*[@id='rwsResultTable_info']");
	public static final By vte_Pagination_info		= By.xpath("//*[@id='vtResultTable_info']");
	public static final By vte_today_Pagination_info= By.xpath("//*[@id='vtTodayResultTable_info']");
	public static final By rscd_Pagination_info		= By.xpath("//*[@id='rrwdResultTable_info']");
	public static final By vsc_Pagination_info      = By.xpath("//*[@id='vrwcDataTable_info']");
	public static final By dd_Pagination_info      	= By.xpath("//*[@id='ddeResultTable_info']");
	public static final By mre_Pagination_info      = By.xpath("//*[@id='regEnqResultTable_info']");
	
	public static final By link_next                = By.xpath("//*[@class='pagination']/li[2]/a");
	
	
	
	//**************************     Internal Portal Login #############################
	
	public static final By btn_Login                 = By.xpath("//input[@id='loginFormSubmit']");
	public static final By input_UserName            = By.xpath("//input[@id='username']");
	public static final By input_Password            = By.xpath("//input[@id='password']");
	public static final By text_LoginError           = By.xpath("//*[@class='loginError']");
	

	          // End Here	
	
}
