@ExternalPortal_ScheduledReports
Feature: 01_ExternalPortal_Reports_ScheduledReports
@01_01_Ext_ScheduledReports_RejectReport
Scenario Outline: User views the Reject Report under Scheduled Report in CSV format and the output field names are as per specification
	Given Open browser "<Browser_Name>" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Scheduled Reports" page 
	#---------------------------------------------------------------
	# | Menu                 		 				 |
	#---------------------------------------------------------------
	  | Reports & Enquiry    		 				 |
	  | Scheduled Reports           		 		 |
	And Select "<Scheduled_Reports>" from "Scheduled Reports" dropdown list in "Scheduled Reports" page
	And Click the "Select" button on "Scheduled Reports" page
	And The "Scheduled Reports" table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name    	 |   Values      |
	#-----------------------------------------------------------------
	  |No				     |  %NOTEMPTY%   |
      |Reports    			 |  %NOTEMPTY%   |
   	Then Click the "Download" button on "Scheduled Reports" page
	And Downloaded CSV file should display below mentioned columns for "Reject Report" under "Scheduled Reports"
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
    | Browser_Name  | Portal_Name |      Username             |    Password               | Scheduled_Reports		    	|
    | Chrome		| External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | Reject Report					| 
#   | Chrome		| Internal    | dev_allAccess_user2       | dev_allAccess_user2       |									|
############################################################################################################
############################################################################################################
@01_02_Ext_ScheduledReports_PaymentVolumeReport
Scenario Outline: User views the Payment Volume value Report under Scheduled Report in CSV format and the output field names are as per specification
	Given Open browser "<Browser_Name>" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Scheduled Reports" page 
	#---------------------------------------------------------------
	# | Menu                 		 				 |
	#---------------------------------------------------------------
	  | Reports & Enquiry    		 				 |
	  | Scheduled Reports           		 		 |
	And Select "<Scheduled_Reports>" from "Scheduled Reports" dropdown list in "Scheduled Reports" page
	And Click the "Select" button on "Scheduled Reports" page
	And The "Scheduled Reports" table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name    	 |   Values      |
	#-----------------------------------------------------------------
	  |No				     |  %NOTEMPTY%   |
      |Reports    			 |  %NOTEMPTY%   |
   	Then Click the "Download" button on "Scheduled Reports" page
	And Downloaded CSV file should display below mentioned columns for "Payment Volume and Value Report" under "Scheduled Reports"
	#----------------------------------------------------------------------
	# | Columns                 		 			 				    |
	#----------------------------------------------------------------------
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
    | Browser_Name  | Portal_Name |      Username             |    Password               | Scheduled_Reports		    	|
    | Chrome	    | External    |dev_SAALBI_allAccess_user  | dev_SAALBI_allAccess_user | Payment Volume Value Report		| 
#   | Chrome	    | dev_allAccess_user2       | dev_allAccess_user2       |									|
############################################################################################################
############################################################################################################
@01_03_Ext_ScheduledReports_RoutingFile
Scenario Outline: User views the Payment Volume value Report under Scheduled Report in CSV format and the output field names are as per specification
	Given Open browser "<Browser_Name>" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Scheduled Reports" page 
	#---------------------------------------------------------------
	# | Menu                 		 				 |
	#---------------------------------------------------------------
	  | Reports & Enquiry    		 				 |
	  | Scheduled Reports           		 		 |
	And Select "<Scheduled_Reports>" from "Scheduled Reports" dropdown list in "Scheduled Reports" page
	And Click the "Select" button on "Scheduled Reports" page
	And The "Scheduled Reports" table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name    	 |   Values      |
	#-----------------------------------------------------------------
	  |No				     |  %NOTEMPTY%   |
      |Reports    			 |  %NOTEMPTY%   |
 #  	Then Click the "Download" button on "Scheduled Reports" page
	And Downloaded CSV file should display below mentioned columns for "Routing File" under "Scheduled Reports"
	#---------------------------------------------------------------
	# | Columns                 		 	 |
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
    | Browser_Name  | Portal_Name |      Username             |    Password               | Scheduled_Reports		    	|
    | Chrome		| External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | Routing File					| 
#   | Chrome		| Internal    | dev_allAccess_user2       | dev_allAccess_user2       |									|
############################################################################################################
############################################################################################################
@01_04_Ext_ScheduledReports_ParticipantPerformance
Scenario Outline: User views the Participant Performance Report under Scheduled Report in CSV format and the output field names are as per specification
	Given Open browser "<Browser_Name>" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Scheduled Reports" page 
	#---------------------------------------------------------------
	# | Menu                 		 				 |
	#---------------------------------------------------------------
	  | Reports & Enquiry    		 				 |
	  | Scheduled Reports           		 		 |
	And Select "<Scheduled_Reports>" from "Scheduled Reports" dropdown list in "Scheduled Reports" page
	And Click the "Select" button on "Scheduled Reports" page
	And The "Scheduled Reports" table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name    	 |   Values      |
	#-----------------------------------------------------------------
	  |No				     |  %NOTEMPTY%   |
      |Reports    			 |  %NOTEMPTY%   |
 #  	Then Click the "Download" button on "Scheduled Reports" page
	And Downloaded CSV file should display below mentioned columns for "Participant Performance Report" under "Scheduled Reports"
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
   | Browser_Name  | Portal_Name |      Username             |    Password               | Scheduled_Reports		    	|
   | Chrome		   | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | Participant Performance Report	| 
#  | Chrome		   | Internal    | dev_allAccess_user2       | dev_allAccess_user2       |									|
############################################################################################################
############################################################################################################
############################################################################################################
############################################################################################################
@01_05_Ext_ScheduledReports_ParticipantSettlementReport 
Scenario Outline: User views the Participant Settlement Report under Scheduled Report in CSV format and the output field names are as per specification
	Given Open browser "<Browser_Name>" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Scheduled Reports" page 
	#---------------------------------------------------------------
	# | Menu                 		 				 |
	#---------------------------------------------------------------
	  | Reports & Enquiry    		 			     |
	  | Scheduled Reports           		         |
	And Select "<Scheduled_Reports>" from "Scheduled Reports" dropdown list in "Scheduled Reports" page
	And Click the "Select" button on "Scheduled Reports" page
	And The "Scheduled Reports" table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name    	 |   Values      |
	#-----------------------------------------------------------------
	  |No				     |  %NOTEMPTY%   |
      |Reports    			 |  %NOTEMPTY%   |
    Then Click the "Download" button on "Scheduled Reports" page
	And Downloaded CSV file should display below mentioned columns for "Participant Settlement Report" under "Scheduled Reports"
	#---------------------------------------------------------------
	# | Columns                 		    |
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
   | Browser_Name	| Portal_Name |      Username             | Password    			   | Scheduled_Reports		    						|
   | Chrome		    | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user  | Detailed Payment Settlement Report	|
#  | Chrome		   	| Internal    | dev_allAccess_user2       | dev_allAccess_user2        |	Detailed Payment Settlement Report	|
############################################################################################################
############################################################################################################