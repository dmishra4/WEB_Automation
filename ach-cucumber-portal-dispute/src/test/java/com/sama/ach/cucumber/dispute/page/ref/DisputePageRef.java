package com.sama.ach.cucumber.dispute.page.ref;

import org.openqa.selenium.By;

public interface DisputePageRef {


	/***************** Page_Create Dispute******************************/
	
public static final String strPopUpCreateDispute    = "//*[@id='myModal']//button[contains(text(),'%s')]";
public static final String strPopUpCancelDispute    = "//*[@id='cancelModal']//button[contains(text(),'%s')]";
public static final String strGUIlabel              = "//label[contains(text(),'%s')]";
public static final String strTableHeaderValues     = "//table[@id='%s']//tbody/tr[%s]/td[%s]";
public static final String strtblResults            = "//table[@id='%s']//tbody/tr";
public static final String strViewtblResulstHeader  = "//table[@id='%s']//thead/tr[2]/th";
public static final String strSearchtblResulstHeader= "//table[@id='%s']//thead/tr/th";
	
public static final By btn_CreateDispute            = By.xpath("//button[text()='Create Dispute']");
public static final By btn_Cancel                   = By.xpath("//input[@value='Cancel']");
public static final By btn_Close                    = By.xpath("//button[text()='Close']");
public static final By btn_Search                   = By.xpath("//input[@id='search']");
public static final By btn_Submit                   = By.xpath("//input[@value='Submit']");
public static final By btn_ViewDetails              = By.xpath("//button[text()='View Details'][1]");
public static final By input_BeneficiaryIban        = By.xpath("//input[@id='beneficiaryIban']");
public static final By input_CreditorParticipant    = By.xpath("//input[@id='sender']");
public static final By input_DebtorParticipant      = By.xpath("//input[@id='receiver']");
public static final By input_RequesterIban          = By.xpath("//input[@id='requesterIban']");
public static final By input_TransactionID          = By.xpath("//input[@id='transRefNo']");
public static final By input_SearchTransID          = By.xpath("//input[@id='transactionId']");
public static final By input_TransactionAmount      = By.xpath("//input[@id='transAmt']");
public static final By input_TransactionDateTime    = By.xpath("//input[@id='dateTrans']");
public static final By input_TransactionStatus      = By.xpath("//input[@id='transStatus']");
public static final By input_FromDate               = By.xpath("//input[@id='formDate']");
public static final By input_ToDate                 = By.xpath("//input[@id='toDate']");
public static final By input_DisputeID              = By.xpath("//input[@id='disputeId']");
public static final By label_DisputeID              = By.xpath("//*[contains(text(),'Dispute Case Reference')]");
public static final By label_ErrorBlock             = By.xpath("//*[@id='errorBlock']");
public static final By label_Error_transRefNo       = By.xpath("//*[contains(@class,'error error_transRefNo')]");
public static final By label_SearchBy               = By.xpath("//*[text()='Search By:']");
public static final By label_SuccessMsg             = By.xpath("//form[@id='createDispForm']//p[1]");	
public static final By select_DisputerParty         = By.xpath("//select[@id='disputerId']");
public static final By select_DisputerPartySearch   = By.xpath("//select[@id='disputerParty']");
public static final By select_DisputedParty         = By.xpath("//select[@id='disputedId']");
public static final By select_DisputedPartySearch   = By.xpath("//select[@id='disputedParty']");
public static final By select_DisputeCategory       = By.xpath("//select[@id='category']");
public static final By select_DisputeStatusSearch   = By.xpath("//select[@id='statusList']");
public static final By select_DisputeType           = By.xpath("//select[@id='categoryType']");
//	public static final By tbl_EnquiryResultHeader  = By.xpath("//table[@id='searchTable']//thead/tr/th");
//	public static final By tbl_Results              = By.xpath("//table[@id='searchTable']//tbody/tr");
public static final By textarea_DisputeDetails      = By.xpath("//textarea[@id='commentVal']");


/***************** Page_Action Dispute******************************/

public static final String strPopUpActionDispute    = "//*[@id='submtApprDisptdModal']//button[contains(text(),'%s')]";
public static final String strPopUpActionDispute1   = "//*[@id='submtApprDisptrModal']//button[contains(text(),'%s')]";
//Are you sure you want to save dispute history as draft?
public static final String strPopUpADSaveasDraft    = "//*[@id='draftDisptdModal']//button[contains(text(),'%s')]";
public static final String strPopUpADSaveasDraft_Disputer= "//*[@id='draftDisptrModal']//button[contains(text(),'%s')]";
public static final String strPopUpADSaveasDraft_SP = "//*[@id='draftSpModal']//button[contains(text(),'%s')]";
public static final String strPopUpADSubmit_SP      = "//*[@id='submtApprSpModal']//button[contains(text(),'%s')]";
public static final String strPopUpADSubmit1_SP     = "//*[@id='submtApprIntSpModal']//button[contains(text(),'%s')]";
public static final String strPopUpADSubmit2_SP_IntEsc     = "//*[@id='submtApprEscModal']//button[contains(text(),'%s')]";
public static final String strPopUpADSaveasDraft_SP_IntEsc = "//*[@id='draftEscModal']//button[contains(text(),'%s')]";

public static final By btn_Print                    = By.xpath("//input[@value='Print']");
public static final By btn_SaveasDraft              = By.xpath("//input[contains(@id,'Draft')]");
public static final By btn_SubmitForApproval        = By.xpath("//input[@value='Submit for Approval']");
public static final By textarea_DisputeHistory      = By.xpath("//textarea[@id='commentVal']");
public static final By textarea_finalResolutionValue= By.xpath("//textarea[@id='finResolVal']");


/***************** Page_Approve Dispute******************************/

public static final String strPopUpApproveDispute    = "//*[@id='approveModal']//button[contains(text(),'%s')]";


public static final By btn_submitApproval              = By.xpath("//input[@id='submitApproval']");
public static final By rbtn_Escalate                   = By.xpath("//*[@id='agreeDiv']//label[text()='Escalate']");
public static final By rbtn_Escalate_SP                = By.xpath("//label[text()='Escalate']");
public static final By rbtn_SendToCounterparty         = By.xpath("//label[text()='Send to Counterparty']");
//public static final By rbtn_Resolved                   = By.xpath("//*[@id='notagreeDispDiv']//label[text()='Resolved']");
public static final By rbtn_Resolved                   = By.xpath("//*[contains(@id,'not')]//label[text()='Resolved']");
public static final By rbtn_ResolvedDisputer           = By.xpath("//*[@id='agreeDiv']//label[text()='Resolved']");
public static final By textarea_RejectionReason        = By.xpath("//textarea[@id='rejectReason']");


	/***************** Page_Dashboard******************************/
	
public static final String strNavigate                 = "%s";

/***************** Page_Pagination******************************/
public static final By input_disputeList               = By.xpath("//input[@id='disputeList']");    
//public static final By li_viewTable_Next               = By.xpath("//li[@id='viewTable_next']/a");
//public static final By li_searchTable_Next             = By.xpath("//li[@id='searchTable_next']/a");
public static final By a_Pagination_Next               = By.xpath("//ul[@class='pagination']//li[2]/a");
//public static final By li_viewTable_Info               = By.xpath("//*[@id='viewTable_info']");	
//public static final By li_searchTable_info             = By.xpath("//*[@id='searchTable_info']");
public static final By li_Pagination_info              = By.xpath("//*[contains(@id,'_info')]");
	



////*[text()='Dispute Status:']//following::p[1]
}
