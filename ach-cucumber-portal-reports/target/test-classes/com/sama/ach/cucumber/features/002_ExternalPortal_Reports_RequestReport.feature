Feature: 02_ExternalPortal_Reports_RequestReport
@02_01_Ext_RequestaReport_RejectReport
Scenario Outline: User views the Reject Request a Report in CSV format and the output field names are as per specification
	Given Open browser "<Browser_Name>" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Request a Report" page 
	#---------------------------------------------------------------
	# | Menu                 		 				 |
	#---------------------------------------------------------------
	  | Reports & Enquiry    		 				 |
	  | Request a Report           		 		     |
	And Select "<Request_a_Report>" from "Request a Report" dropdown list in "Request a Report" page
	And Click the "Select" button on "Reject Report" page
	And The "Reject Report" page contains the following GUI items:
	#----------------------------------------------------------------------
	# | GUI Items |        Name        			|      Value              |
	#----------------------------------------------------------------------
	  |Label      |   Participant ID   			|     %Displayed%         |
	  |Label	  |	  Start Date			 	|	  %Displayed% 	  	  |
	  |Label      |   End Date   				|     %Displayed%         |
	  |Label      |   Local Instrument   		|     %Displayed%         |
	  |Label      |   Content Format  			|     %Displayed%         |
	  |Label      |   Category Purpose Code  	|     %Displayed%         |
	  |Button     |   Submit           			|     %Enabled%           |
      |Button     |   Clear Screen     			|     %Enabled%           |
	And Enter below values in "Reject Report" page
	#-----------------------------------------------------------------
	# | Field                       |       Values                  |
	#-----------------------------------------------------------------
	  | Start Date         			| <Start_Date>		    		|
	  | End Date         			| <End_Date>		    		|
	  | Local Instrument         	| <Local_Instrument>		    |
	  | Content Format         		| <Content_Format>		    	|
	  | Category Purpose Code       | <Category_Purpose_Code>       |
	And Click the "Submit" button on "Reject Report" page
	Then Verify the below mentioned confirmation message is displayed on "Request a Report" page
		"""
		Your request is successfully submitted, Please find the report using the Report Id #### in the Requested Report section.
        """
	And Navigate to below mentioned menu in order to reach "Requested Reports" page 
	#---------------------------------------------------------------
	# | Menu                 		 				 |
	#---------------------------------------------------------------
	  | Requested Reports           		 		 |
	And Select "<Requested_Reports>" from "Requested Reports" dropdown list in "Requested Reports" page
	And Click the "Select" button on "Requested Reports" page
	And The "Requested Reports" table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name    	 |   Values      |
	#-----------------------------------------------------------------
	  |No				     |  %NOTEMPTY%   |
      |Reports    			 |  %NOTEMPTY%   |
   	Then Click the "Download" button on "Requested Reports" page
	And Downloaded CSV file should display below mentioned columns for "Reject Report" under "Requested Reports"
	#---------------------------------------------------------------
	# | Columns                 		 			 				|
	#---------------------------------------------------------------
	  | FI ID    		 				 			 				|
	  | FI Name				           		 		 				|
	  | Participant ID								 				|
	  | Participant Name							 				|
	  | Total Number of Credit Transfer Transactions				|
	  | 		Total												|
	  | 		Outward												|
	  | 		Inward												|
	  | Total Number of Credit Transfers Transactions Accepted		|
	  |			Outward												|
	  |			Inward												|
	  | Total Number of Credit Transfer Transactions Accepted w/o Posting|
	  |			Outward												|
	  |			Inward												|
	  | Total Number of Credit Transfer Transactions Rejected		|
	  |			Outward												|
	  |			Outward Participant Reject							|
	  |			Outward System Reject								|
	  |			Inward												|
	  | Rejected by Reason  								 		|
	  |			Outward												|
	  |			Outward Participant Reject							|
	  |			Outward System Reject								|
	  |			Inward												|
	And Close the browser
    Examples: 
    | Browser_Name  | Portal_Name |      Username             |    Password               | Request_a_Report | Start_Date	| End_Date		 | Local_Instrument	| Content_Format  	|	Requested_Reports |Category_Purpose_Code|
    | Chrome		| External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | Reject Report	 | 09/06/2020	| 15/06/2020	 | Credit Transfer	| CSV				|	Reject Report	  |       All           |
#   | Chrome		| Internal    | dev_allAccess_user2       | dev_allAccess_user2       |					 |				|				 |					|					|					  |
############################################################################################################
############################################################################################################
@02_02_Ext_RequestaReport_PaymentVolumeReport
Scenario Outline: User views the Payment Volume value Report in CSV format and the output field names are as per specification
	Given Open browser "<Browser_Name>" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Request a Report" page 
	#---------------------------------------------------------------
	# | Menu                 		 				 |
	#---------------------------------------------------------------
	  | Reports & Enquiry    		 				 |
	  | Request a Report           		 		     |
	And Select "<Request_a_Report>" from "Request a Report" dropdown list in "Request a Report" page
	And Click the "Select" button on "Requested Reports" page
	And The "Payment Volume Value Report" page contains the following GUI items:
	#----------------------------------------------------------------------
	# | GUI Items |        Name        			|      Value              |
	#----------------------------------------------------------------------
	  |Label      |   Participant ID   			|     %Displayed%         |
	  |Label	  |	  Start Date			 	|	  %Displayed% 	  	  |
	  |Label      |   End Date   				|     %Displayed%         |
	  |Label      |   Local Instrument   		|     %Displayed%         |
	  |Label      |   Content Format  			|     %Displayed%         |
	  |Label      |   Category Purpose Code  	|     %Displayed%         |
	  |Button     |   Submit           			|     %Enabled%           |
      |Button     |   Clear Screen     			|     %Enabled%           |
	And Enter below values in "Payment Volume Value Report" page
	#-----------------------------------------------------------------
	# | Field                       |       Values                  |
	#-----------------------------------------------------------------
	  | Start Date         			| <Start_Date>		    		|
	  | End Date         			| <End_Date>		    		|
	  | Local Instrument         	| <Local_Instrument>		    |
	  | Content Format         		| <Content_Format>		    	|
	  | Category Purpose Code       | <Category_Purpose_Code>		|
	And Click the "Submit" button on "Payment Volume Value Report" page
	Then Verify the below mentioned confirmation message is displayed on "Request a Report" page
		"""
		Your request is successfully submitted, Please find the report using the Report Id #### in the Requested Report section.
        """
	And Navigate to below mentioned menu in order to reach "Requested Reports" page 
	#---------------------------------------------------------------
	# | Menu                 		 				 |
	#---------------------------------------------------------------
	  | Requested Reports           		 		 |
	And Select "<Requested_Reports>" from "Requested Reports" dropdown list in "Requested Reports" page
	And Click the "Select" button on "Requested Reports" page
	And The "Requested Reports" table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name    	 |   Values      |
	#-----------------------------------------------------------------
	  |No				     |  %NOTEMPTY%   |
      |Reports    			 |  %NOTEMPTY%   |
   	Then Click the "Download" button on "Requested Reports" page
	And Downloaded CSV file should display below mentioned columns for "Payment Volume and Value Report" under "Requested Reports"
	#---------------------------------------------------------------
	# | Columns                 		 			 				    |
	#---------------------------------------------------------------
	  | FI ID    		 				 			 				    |
	  | FI Name				           		 		 				    |
	  | Participant ID                      						    |
	  | Participant Name							 				    |
	  | Funding Agent Account ID		 							    |
	  | Funding Agent Name		 									    |
	  | Currency												        |
	  | Total Volume of Payment Transactions sent/received			    |
	  | Total Volume of Payment Transactions sent					    |
	  | Total Volume of Payment Transactions received				    |
	  | Total Volume of Payments by Status (of those sent)			    |
	  | Total Volume of Payments by Status (of those received)		    |
	  | Total Value of Payment Transactions Sent/Received			    |
	  | Total Value of Payments sent								    |
	  | Total Value of Payments received							    |
	  | Total Value of Payments by Status (of those sent)			    |
	  | Total Value of Payments received by the Participant (by status)	|
	And Close the browser
    Examples: 
    | Browser_Name  | Portal_Name |      Username             |    Password               | Request_a_Report 			 | Start_Date	| End_Date		 | Local_Instrument	| Content_Format  	| Requested_Reports 		|Category_Purpose_Code|
    | Chrome		| External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | Payment Volume Value Report	 | 09/06/2020	| 15/06/2020	 | Credit Transfer	| CSV				|Payment Volume Value Report|    All              |
#   | Firefox		| Internal    | dev_allAccess_user2       | dev_allAccess_user2       |					 			 |				|				 |					|					|							|
############################################################################################################
############################################################################################################
@02_03_Ext_RequestaReport_RoutingFile
Scenario Outline: User views the Payment Volume value Report in CSV format and the output field names are as per specification
	Given Open browser "<Browser_Name>" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Request a Report" page 
	#---------------------------------------------------------------
	# | Menu                 		 				 |
	#---------------------------------------------------------------
	  | Reports & Enquiry    		 				 |
	  | Request a Report           		 		     |
	And Select "<Request_a_Report>" from "Request a Report" dropdown list in "Request a Report" page
	And Click the "Select" button on "Request a Report" page
	And The "Routing File" page contains the following GUI items:
	#----------------------------------------------------------------------
	# | GUI Items |        Name        			|      Value              |
	#----------------------------------------------------------------------
	  |Label      |   Participant ID   			|     %Displayed%         |
	  |Label	  |	  Date			 			|	  %Displayed% 	  	  |
	  |Label      |   Content Format  			|     %Displayed%         |
	  |Button     |   Submit           			|     %Enabled%           |
      |Button     |   Clear Screen     			|     %Enabled%           |
	And Enter below values in "Routing File" page
	#-----------------------------------------------------------------
	# | Field                       |       Values                  |
	#-----------------------------------------------------------------
	  | Date         				| <Date>		    			|
	  | Content Format         		| <Content_Format>		    	|
	And Click the "Submit" button on "Routing File" page
	Then Verify the below mentioned confirmation message is displayed on "Request a Report" page
		"""
		Your request is successfully submitted, Please find the report using the Report Id #### in the Requested Report section.
        """
	And Navigate to below mentioned menu in order to reach "Requested Reports" page 
	#---------------------------------------------------------------
	# | Menu                 		 				 |
	#---------------------------------------------------------------
	  | Requested Reports           		 		 |
	And Select "<Requested_Reports>" from "Requested Reports" dropdown list in "Requested Reports" page
	And Click the "Select" button on "Requested Reports" page
	And The "Requested Reports" table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name    	 |   Values      |
	#-----------------------------------------------------------------
	  |No				     |  %NOTEMPTY%   |
      |Reports    			 |  %NOTEMPTY%   |
   	Then Click the "Download" button on "Requested Reports" page
	And Downloaded CSV file should display below mentioned columns for "Routing File" under "Requested Reports"
	#---------------------------------------------------------------
	# | Columns                 		 			 				|
	#---------------------------------------------------------------
	  | ID    		 				 		 |
	  | Participant ID						 |
	  | Participant Name					 |
	  | Financial Institution ID		 	 |
	  | Financial Institution Name			 |
	  | Receive services 					 |
	  | Receiving connection                 |
	  | Participant Activation date			 |
	And Close the browser
    Examples: 
    | Browser_Name  | Portal_Name |      Username             |    Password               | Request_a_Report 			 | Date		    | Content_Format  	| Requested_Reports 		|
    | Chrome		| External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | Routing File				 | 15/06/2020	| CSV				| Routing File				|
#   | Chrome		| Internal    | dev_allAccess_user2       | dev_allAccess_user2       |					 			 |				|					|							|
############################################################################################################
############################################################################################################
@02_04_Ext_RequestaReport_ParticipantPerformance
Scenario Outline: User views the Payment Volume value Report in CSV format and the output field names are as per specification
	Given Open browser "<Browser_Name>" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Request a Report" page 
	#---------------------------------------------------------------
	# | Menu                 		 				 |
	#---------------------------------------------------------------
	  | Reports & Enquiry    		 				 |
	  | Request a Report           		 		     |
	And Select "<Request_a_Report>" from "Request a Report" dropdown list in "Request a Report" page
	And Click the "Select" button on "Request a Report" page
	And The "Participant Performance Report" page contains the following GUI items:
	#----------------------------------------------------------------------
	# | GUI Items |        Name        			|      Value              |
	#----------------------------------------------------------------------
	  |Label      |   Participant ID   			|     %Displayed%         |
	  |Label	  |	  Report Date			 	|	  %Displayed% 	  	  |
	  |Label      |   Content Format  			|     %Displayed%         |
	  |Button     |   Submit           			|     %Enabled%           |
      |Button     |   Clear Screen     			|     %Enabled%           |
	And Enter below values in "Participant Performance Report" page
	#-----------------------------------------------------------------
	# | Field                       |       Values                  |
	#-----------------------------------------------------------------
	  | Report Date         		| <Report_Date>		    		|
	  | Content Format         		| <Content_Format>		    	|
	And Click the "Submit" button on "Participant Performance Report" page
	Then Verify the below mentioned confirmation message is displayed on "Request a Report" page
		"""
		Your request is successfully submitted, Please find the report using the Report Id #### in the Requested Report section.
        """
    And Navigate to below mentioned menu in order to reach "Requested Reports" page 
	#---------------------------------------------------------------
	# | Menu                 		 				 |
	#---------------------------------------------------------------
	  | Requested Reports           		 		 |
	And Select "<Requested_Reports>" from "Requested Reports" dropdown list in "Requested Reports" page
	And Click the "Select" button on "Requested Reports" page
	And The "Requested Reports" table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name    	 |   Values      |
	#-----------------------------------------------------------------
	  |No				     |  %NOTEMPTY%   |
      |Reports    			 |  %NOTEMPTY%   |
   	Then Click the "Download" button on "Requested Reports" page
	And Downloaded CSV file should display below mentioned columns for "Participant Performance Report" under "Requested Reports"
	#---------------------------------------------------------------
	# | Columns                 		 			 				|
	#---------------------------------------------------------------
	  | Participant ID								 				|
	  | Participant Name							 				|
	  | Message Type		 										|
	  | Sending Txn Count											|
	  | Sending Avg System Time										|
	  | Sending Max System Time										|
	  | Sending Percentile System Time								|
	  | Sending Avg Leg1 Processing Time							|
	  | Sending Avg Response Time									|
	  | Sending Avg Leg3 Processing Time							|
	  | Receiving Txn Count											|
	  | Receiving Avg Response Time									|
	  | Receiving Max Response Time									|
	  | Receiving Percentile Response Time							|
	And Close the browser
    Examples: 
    | Browser_Name  | Portal_Name |      Username             |    Password               | Request_a_Report 			  | Report_Date | Content_Format  	| Requested_Reports 			|
    | Chrome		| External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | Participant Performance Report| 09/06/2020	| CSV				| Participant Performance Report|
#   | Firefox		| Internal    | dev_allAccess_user2       | dev_allAccess_user2       |					 			  |				|				 	|								|
############################################################################################################
############################################################################################################

############################################################################################################
############################################################################################################
@02_05_Ext_RequestaReport_ParticipantSettlementReport
Scenario Outline: User views the Participant Settlement Report in CSV format and the output field names are as per specification
	Given Open browser "<Browser_Name>" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Request a Report" page 
	#---------------------------------------------------------------
	# | Menu                 		 				 |
	#---------------------------------------------------------------
	  | Reports & Enquiry    		 				 |
	  | Request a Report           		 		     |
	And Select "<Request_a_Report>" from "Request a Report" dropdown list in "Request a Report" page
	And Click the "Select" button on "Request a Report" page
	And The "Participant Settlement Report" page contains the following GUI items:
	#----------------------------------------------------------------------
	# | GUI Items |        Name        			|      Value              |
	#----------------------------------------------------------------------
	  |Label      |   Participant ID   			|     %Displayed%         |
	  |Label	  |	  Settlement Date			|	  %Displayed% 	  	  |
	  |Label      |   Settlement Cycle ID  		|     %Displayed%         |
	  |Label	  |	  Currency ISO Code			|	  %Displayed% 	  	  |
	  |Label      |   Content Format  			|     %Displayed%         |
	  |Button     |   Submit           			|     %Enabled%           |
      |Button     |   Clear Screen     			|     %Enabled%           |
	And Enter below values in "Participant Settlement Report" page
	#-----------------------------------------------------------------
	# | Field                       |       Values                  |
	#-----------------------------------------------------------------
	  | Settlement Date         	| <Settlement_Date>		    	|
	  | Settlement Cycle ID         | <Settlement_Cycle_ID>		    |
	  | Currency ISO Code         	| <Currency_ISO_Code>		    |
	  | Content Format         		| <Content_Format>		    	|
	And Click the "Submit" button on "Participant Settlement Report" page
	Then Verify the below mentioned confirmation message is displayed on "Request a Report" page
		"""
		Your request is successfully submitted, Please find the report using the Report Id #### in the Requested Report section.
        """
    And Navigate to below mentioned menu in order to reach "Requested Reports" page 
	#---------------------------------------------------------------
	# | Menu                 		 				 |
	#---------------------------------------------------------------
	  | Requested Reports           		 		 |
	And Select "<Requested_Reports>" from "Requested Reports" dropdown list in "Requested Reports" page
	And Click the "Select" button on "Requested Reports" page
	And The "Requested Reports" table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name    	 |   Values      |
	#-----------------------------------------------------------------
	  |No				     |  %NOTEMPTY%   |
      |Reports    			 |  %NOTEMPTY%   |
   	Then Click the "Download" button on "Requested Reports" page
	And Downloaded CSV file should display below mentioned columns for "Participant Settlement Report" under "Requested Reports"
	#---------------------------------------------------------------
	# | Columns                 		 			 				|
	#---------------------------------------------------------------
	  | FI ID								|
	  | FI Name				                |
	  | Participant ID		 				|
	  | Participant Name					|
	  | Funding Agent Account ID			|
	  | Funding Agent Name 					|
	  | Currency							|
	  | Debit Cap							|
	  | Number of Inward transactions 		|
	  | Value of Inward transactions 		|
	  | Number of Outward transactions 		|
	  | Value of Outward transactions		|
	  | Net Position						|
	And Close the browser
    Examples: 
    | Browser_Name  | Portal_Name |      Username             |    Password               | Request_a_Report 			  | Settlement_Date |Settlement_Cycle_ID | Currency_ISO_Code | Content_Format  	| Requested_Reports 			|
    | Chrome		| External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | Participant Settlement Report |   16/07/2020	|     001            |        SAR        |     CSV			| Participant Settlement Report |
#   | Firefox		| Internal    | dev_allAccess_user2       | dev_allAccess_user2       |					 			  |				    |				 	 |								|
############################################################################################################
############################################################################################################