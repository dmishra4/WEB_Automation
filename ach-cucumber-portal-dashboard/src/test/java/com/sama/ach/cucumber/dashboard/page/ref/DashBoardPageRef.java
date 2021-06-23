package com.sama.ach.cucumber.dashboard.page.ref;

import org.openqa.selenium.By;

public interface DashBoardPageRef {
	
/***************** Page_Dashboard******************************/
	
	public static final String strNavigate          			= "%s";
	
	public static final By label_BanksUnavailable     			= By.xpath("//*[contains(text(),'Banks Unavailable')]");
	public static final By label_CreditsProcessed     			= By.xpath("//label[text()='Credits Processed']");
	public static final By label_ConnectivityStatus   			= By.xpath("//td[text()='Connectivity Status']");
	public static final By label_DebitCap             			= By.xpath("//*[text()='Debit Cap ']");
	public static final By label_DebitCapUtilized     			= By.xpath("//*[text()='Debit Cap Utilized']");
	public static final By label_DebitCapChange       			= By.xpath("//*[text()='Debit Cap Change']");
	public static final By label_DebitsFailed         			= By.xpath("//label[text()='Debits Failed']");
	public static final By label_DebitProcessed       			= By.xpath("//label[text()='Debits Processed']");
	public static final By label_Disputesclosed30days 			= By.xpath("//*[contains(text(),'Disputes closed in the last 30 days')]");
	public static final By label_DisputesinProgress   			= By.xpath("//*[contains(text(),'Disputes in Progress')]");
	public static final By label_HighThreshold        			= By.xpath("//*[text()='High Threshold']");
	public static final By Label_LastCycle			  			= By.xpath("//*[text()='Last Cycle: ']");
	public static final By Label_LCycleNo			  			= By.xpath("(//*[text()=' | Cycle No:'])[1]");
	public static final By Label_LCycleStatus		  			= By.xpath("(//*[text()=' | Cycle Status: '])[1]");
	public static final By label_LowThreshold         			= By.xpath("//*[text()='Low Threshold']");
	public static final By Label_NextCycle			  			= By.xpath("//*[text()='Next Cycle: ']");
	public static final By Label_NCycleNo			  			= By.xpath("(//*[text()=' | Cycle No:'])[2]");
	public static final By Label_NCycleStatus		  			= By.xpath("(//*[text()=' | Cycle Status: '])[2]");
	public static final By label_NetPosition          			= By.xpath("//*[text()='Net Position']");
	public static final By label_Ason		          			= By.xpath("//*[contains(text(),'As on')]");
	public static final By label_OpenDisputes         			= By.xpath("//*[contains(text(),'Open Disputes')]");			
	public static final By label_ParticipantStatus    			= By.xpath("//td[text()='Participant Status']");
	public static final By label_ParticipantSuspend   			= By.xpath("//td[text()='Participant Suspend Status']");
	public static final By label_SITL                 			= By.xpath("//td[contains(text(),'SITL')]");
	public static final By label_STL                  			= By.xpath("//td[contains(text(),'STL')]");
	public static final By label_SystemStatus         			= By.xpath("//td[text()='System Status']");
	public static final By list_BanksUnavailable      		 	= By.xpath("//*[@id='banksUnavilableDiv']/div");
	public static final By label_SaudiPaymentsIPSNotificationB 	= By.xpath("(//td [text()='SaudiPayments IPS Notification (SNM)'])[1]");
	
	public static final By text_asonDate			  			= By.xpath("//*[@id='asonDate']");
	public static final By text_creditProcessedCount  			= By.xpath("//*[@id='creditProcessedCount']");
	public static final By text_creditProcessedAmount 			= By.xpath("//*[@id='creditProcessedAmount']");
	public static final By text_ConnectivityStatusDetail		= By.xpath("//*[@id='connectivityStatusDetail']");
	public static final By text_ConnectivityStatusTime			= By.xpath("//td[@id='connectivityStatusTime']");	
	public static final By text_DebitCap              			= By.xpath("//*[@id='debitCap']");
	public static final By text_DebitCapUtilized      			= By.xpath("//*[@id='debitCapUtilized']");
	public static final By text_debitFailedCount      			= By.xpath("//*[@id='debitFailedCount']");
	public static final By text_debitFailedAmount     			= By.xpath("//*[@id='debitFailedAmount']");
	public static final By text_debitProcessedCount   			= By.xpath("//*[@id='debitProcessedCount']");
	public static final By text_debitProcessedAmount  			= By.xpath("//*[@id='debitProcessedAmount']");
	public static final By text_Disputesclosed30days  			= By.xpath("//*[contains(text(),'Disputes closed in the last 30 days')]//following::div[1]");
	public static final By text_DisputesinProgress    			= By.xpath("//*[contains(text(),'Disputes in Progress')]//following::div[1]");
	public static final By text_HighThreshold         			= By.xpath("//*[@id='highThresholdPercentage']");
	public static final By text_LastCycletDate    	  			= By.xpath("//*[@id='lastCycleDate']");
	public static final By text_LCycletNo    	  	  			= By.xpath("//*[@id='lastCycleId']");
	public static final By text_LCycletStatus    	  			= By.xpath("//*[@id='lastCycleStatus']");
	public static final By text_LowThreshold          			= By.xpath("//*[@id='lowThresholdPercentage']");
	public static final By text_NextCycletDate    	  			= By.xpath("//*[@id='nextCycleDate']");
	public static final By text_NCycletNo    	  	  			= By.xpath("//*[@id='nextCycleId']");
	public static final By text_NCycletStatus    	  			= By.xpath("//*[@id='nextCycleStatus']");
	public static final By text_NetPosition           			= By.xpath("//*[@id='netPosition']");
	public static final By text_OpenDisputes          			= By.xpath("//*[contains(text(),'Open Disputes')]//following::div[1]");
	//public static final By text_pendingRequestDate    		= By.xpath("//*[@id='pendingRequestDate']");
	public static final By text_pendingRequestDate 	  			= By.xpath("//*[@id='pendingRequestsDiv']/div[2]");
	public static final By text_ParticipantStatusDetail			= By.xpath("//*[@id='participantStatusDetail']");
	public static final By text_ParticipantStatusTime 			= By.xpath("//td[@id='participantStatusTime']");
	public static final By text_ParticipantSuspendDetail		= By.xpath("//*[@id='participantSuspendStatusDetail']");
	public static final By text_ParticipantSuspendTime 			= By.xpath("//td[@id='participantSuspendStatusTime']");
	public static final By text_SaudiPaymentsIPSNotificationB	= By.xpath("(//td [text()='SaudiPayments IPS Notification (SNM)'])[1]//following::td[1]");
	public static final By text_SaudiPaymentsIPSNotificationBTime= By.xpath("(//td [text()='SaudiPayments IPS Notification (SNM)'])[1]//following::td[2]");
	public static final By text_systemDateTime         			= By.xpath("//*[@id ='wpthemeLogout'] //preceding::li[1]");
	public static final By text_SystemStatusDetail    			= By.xpath("//*[@id='systemStatusDetail']");
	public static final By text_SystemStatusTime      			= By.xpath("//td[@id='systemStatusTime']");
	
	public static final By text_STLChangeDetail       			= By.xpath("//*[@id='stlChangeDetail']");
	public static final By text_STLChangeTime         			= By.xpath("//td[@id='stlChangeTime']");
	public static final By text_SITLChangeDetail      			= By.xpath("//*[@id='sitlChangeDetail']");
	public static final By text_SITLChangeTime        			= By.xpath("//td[@id='sitlChangeTime']");

	//**************************     DashBoard Broadcast Message *************************************#
	public static final By text_SaudiPaymentsIPSNotificationDetails= By.xpath("//*[@id='freeFormatDetailBroadcast']");
	
	//**************************     DashBoard Notification Message  **********************************#
	public static final By text_DebitCapBreach       		 	= By.xpath("//*[@id='debitCapBreachDetail']");
	public static final By text_DebitCapChange       		 	= By.xpath("//*[@id='debitCapChangeDetail']");
	public static final By text_DebitCapThresholdWarn   	 	= By.xpath("//*[@id='debitCapThresholdWarningDetail']");
	public static final By text_SaudiPaymentsIPSNotification 	= By.xpath("//*[@id='freeFormatDetail']");
	public static final By text_SettlementCycleStatus   	 	= By.xpath("//*[@id='settlementCycleStatusDetail']");
		
	//**************************     View Participant SNM - Notification Message *********************#
	public static final String strGUIlabel						= "//td[contains(text(),'%s')]";
	public static final String strGUIvalue						= "//td[contains(text(),'%s')]//following::td[1]";
	public static final String strGUItimestamp					= "//td[contains(text(),'%s')]//following::td[2]";
	
	public static final By label_SaudiPaymentsIPSNotificationN	= By.xpath("(//td [text()='SaudiPayments IPS Notification (SNM)'])[2]");
	public static final By text_SaudiPaymentsIPSNotificationN	= By.xpath("(//td [text()='SaudiPayments IPS Notification (SNM)'])[2]//following::td[1]//li[1]");
	public static final By text_SaudiPaymentsIPSNotificationNTime	= By.xpath("(//td [text()='SaudiPayments IPS Notification (SNM)'])[2]//following::td[2]//li[1]");

	
	//**************************     Internal Portal Login *******************************************#
	public static final By input_UserName            			= By.xpath("//input[@id='username']");
	public static final By input_Password             			= By.xpath("//input[@id='password']");
	public static final By btn_Login                  			= By.xpath("//input[@id='loginFormSubmit']");
	public static final By text_LoginError            			= By.xpath("//*[@class='loginError']");
	public static final By select_PartcipantSelection 			= By.xpath("//select[@id='filterText1']");
}
