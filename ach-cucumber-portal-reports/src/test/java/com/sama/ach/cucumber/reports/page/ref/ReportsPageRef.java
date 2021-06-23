package com.sama.ach.cucumber.reports.page.ref;

import org.openqa.selenium.By;

public interface ReportsPageRef {


	
	

/***************** Scheduled Reports******************************/
	

	public static final By btn_Select              = By.xpath("//button[contains(text(),'Select')]");
	public static final By select_ReportType       = By.xpath("//Select[@id='rptType']");
	
	/***************** Request a Report   : Reject Report ******************************/
	
	public static final String str_RR_GUILable      = "//form[@id='rptRejectForm']//*[text()='%s']";
	
	public static final By btn_RR_ClearScreen       = By.xpath("//form[@id='rptRejectForm']//button[text()='Clear Screen']");
	public static final By btn_RR_Submit            = By.xpath("//form[@id='rptRejectForm']//button[text()='Submit']");
	public static final By input_RR_startDate		= By.xpath("//input [@id='rrStartDate']");
	public static final By input_RR_endDate			= By.xpath("//input [@id='rrEndDate']");
	public static final By select_RR_LocalInstrument= By.xpath("//select[@id='rrLocalInstrument']");
	public static final By select_RR_ContentFormat 	= By.xpath("//select[@id='rrContentFormat']");
	public static final By select_RR_CategoryCode 	= By.xpath("//select[@id='rrCategoryPurposeCode']");
	
	
/***************** Request a Report   : Payment Volume Value Report ******************************/
	
	public static final String str_PVV_GUILable      = "//form[@id='rptPVVForm']//*[text()='%s']";
	
	public static final By btn_PVV_ClearScreen       = By.xpath("//form[@id='rptPVVForm']//button[text()='Clear Screen']");
	public static final By btn_PVV_Submit            = By.xpath("//form[@id='rptPVVForm']//button[text()='Submit']");
	public static final By input_PVV_startDate		 = By.xpath("//input [@id='pvvStartDate']");
	public static final By input_PVV_endDate		 = By.xpath("//input [@id='pvvEndDate']");
	public static final By select_PVV_LocalInstrument= By.xpath("//select[@id='pvvLocalInstrument']");
	public static final By select_PVV_ContentFormat  = By.xpath("//select[@id='pvvContentFormat']");
	public static final By select_PVV_CategoryCode 	 = By.xpath("//select[@id='pvvCategoryPurposeCode']");
//	public static final By text_SuccessMessage       = By.xpath("//*[@class='successMsg']//p");
	

/***************** Request a Report   : Participant Performance Report ******************************/
	
	public static final String str_PP_GUILable      = "//*[@id='spParticipantPerformanceReport']//*[text()='%s']";
	
	public static final By btn_PP_ClearScreen       = By.xpath("//*[@id='spParticipantPerformanceReport']//button[text()='Clear Screen']");
	public static final By btn_PP_Submit            = By.xpath("//*[@id='spParticipantPerformanceReport']//button[text()='Submit']");
	public static final By input_PP_reportDate		= By.xpath("//input [@id='pprReportDate']");
	public static final By select_PP_ContentFormat  = By.xpath("//select[@id='pprContentFormat']");
	
	
/***************** Request a Report   : Participant Settlement Report******************************/
	
	public static final String str_PSR_GUILable         = "//*[@id='spParticipantSettlementReport']//*[text()='%s']";
	
	public static final By btn_PSR_ClearScreen          = By.xpath("//*[@id='spParticipantSettlementReport']//button[text()='Clear Screen']");
	public static final By btn_PSR_Submit               = By.xpath("//*[@id='spParticipantSettlementReport']//button[text()='Submit']");
	public static final By input_PSR_SettlementDate     = By.xpath("//input [@id='prrSettlementCycleDate']");
	public static final By select_PSR_CurrencyCode      = By.xpath("//select[@id='currIsoCode']");
	public static final By select_PSR_ContentFormat     = By.xpath("//select[@id='prrContentFormat']");
	public static final By select_PSR_SettlementCycleID = By.xpath("//select[@id='prrSettlementCycleID']");
	

/***************** Request a Report   : Routing File Report ******************************/
	
	public static final String str_RF_GUILable      = "//*[@id='spRoutingFileReport']//*[text()='%s']";
	
	public static final By btn_RF_ClearScreen       = By.xpath("//*[@id='spRoutingFileReport']//button[text()='Clear Screen']");
	public static final By btn_RF_Submit            = By.xpath("//*[@id='spRoutingFileReport']//button[text()='Submit']");
	public static final By input_RF_Date		    = By.xpath("//input [@id='rfEndDate']");
	public static final By select_RF_ContentFormat  = By.xpath("//select[@id='rfContentFormat']");
	
/***************** Page_Common******************************/
	
	public static final String strNavigate          = "%s";
	public static final String strResults           = "//*[@id='reportResult']//table//tbody/tr[%s]/td[%s]";
	
	public static final By btn_Download             = By.xpath("(//button[text()='Download'])[1]");
	public static final By tbl_Results              = By.xpath("//*[@id='reportResult']//table//tbody/tr");
	public static final By tbl_ReportResultHeader   = By.xpath("//*[@id='reportResult']//table/thead/tr[2]/th");
	public static final By results_Pagination_info  = By.xpath("//*[@class='dataTables_info']");
	public static final By link_next                = By.xpath("//*[@class='pagination']/li[2]/a");
	public static final By text_SuccessMessage      = By.xpath("//*[@class='successMsg']//p");
	
	//**************************     Internal Portal Login #############################
    
    
    public static final By input_UserName            = By.xpath("//input[@id='username']");
//    public static final By input_Password            = By.xpath("//input[@id='password']");
    public static final By btn_Login         = By.xpath("//input[@id='loginFormSubmit']");
    public static final By text_LoginErrorInternal   = By.xpath("//*[@class='loginError']");
	
}
