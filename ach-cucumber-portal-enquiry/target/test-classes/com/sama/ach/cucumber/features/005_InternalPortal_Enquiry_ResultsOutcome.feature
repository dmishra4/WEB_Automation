@InternalEnquiry_ResultsOutcome
Feature: InternalPortal_Enquiry
@Int_ParticipantPosition
Scenario Outline: User can inquire the Participant Position Enquiry and view the result on screen
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Participant Position Enquiry" page 
	#---------------------------------------------------------------
	# | Menu                 |
	#---------------------------------------------------------------
	  | Reports & Enquiry    |
	  | Enquiries            |
	  | Participant Position |
	And Select "<Participant_BankName>" from Participant drop down list
	And The "Participant Position" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name        |       Value                   |
	#-----------------------------------------------------------------
	  |Label      |   Participant ID   |      %Displayed%              |
    |Button     |   Submit           |      %Enabled%                |
    |Button     |   Clear Screen     |      %Enabled%                |
	And Click the "Submit" button on "Participant Position" page
  And The "Participant Position" result table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          |   Values      |
	#-----------------------------------------------------------------
	  |Participant ID         |  %NOTEMPTY%   |
    |Participant Name       |  %NOTEMPTY%   |
    |Debit Cap              |  %NOTEMPTY%   | 
    |Net Position           |  %NOTEMPTY%   |
    |Tracking Position      |  %NOTEMPTY%   |
    |Tracking Position Limit|  %NOTEMPTY%   |
    |Available Debit Cap    |  %NOTEMPTY%   |
    |Debit Cap Utilized %   |  %NOTEMPTY%   |
	Then Click the "Export to CSV" button on "Participant Position" page
	And Columns name in the downloaded CSV file is same as "Participant Position" enquiry result screen
	And Close the browser
    Examples: 
    | Portal_Name |      Username             |    Password               | Participant_BankName |
#   | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |  										 |
    | Internal    | dev_allAccess_user1       | dev_allAccess_user1       | AlBilad Bank				 |
############################################################################################################
############################################################################################################
@Int_ParticipantUnabletoTransact 
Scenario Outline: User can inquire the Participant Unable to Transact and view the result on screen
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Participant Unable to Transact" page 
	#---------------------------------------------------------------
	# | Menu                 					 |
	#---------------------------------------------------------------
	  | Reports & Enquiry    					 |
	  | Enquiries            					 |
	  | Participant Unable to Transact |
   And The "Participant Unable to Transact" result table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          	|   Values      |
	#-----------------------------------------------------------------
	  |Participant ID         	|  %NOTEMPTY%   |
    |Participant Name       	|  %NOTEMPTY%   |
    |Default Connection ID  	|  %NOTEMPTY%   | 
    |Default Connection Status|  %NOTEMPTY%   |
    |Sign-on Status      			|  %NOTEMPTY%   |
    |Suspension Status				|  %NOTEMPTY%   |
 #  |Availability Status			|  %NOTEMPTY%   |
	Then Click the "Export to CSV" button on "Participant Unable to Transact" page
	And Columns name in the downloaded CSV file is same as "Participant Unable to Transact" enquiry result screen
	And Close the browser
    Examples: 
    | Portal_Name |      Username             |    Password               | 
#   | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |  
    | Internal    | dev_allAccess_user1       | dev_allAccess_user1       |
############################################################################################################
############################################################################################################
@Int_RetrieveParticipantStatus
Scenario Outline: User can inquire the Retrieve Participant Status (Single Participant) and view the result on screen
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Retrieve Participant Status (Single Participant)" page 
	#---------------------------------------------------------------
	# | Menu                 														 |
	#---------------------------------------------------------------
	  | Reports & Enquiry    														 |
	  | Enquiries            														 |
	  | Retrieve Participant Status (Single Participant) |
	And Select "<Participant_BankName>" from Participant drop down list
	And The "Retrieve Participant Status (Single Participant)" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name        |       Value                   |
	#-----------------------------------------------------------------
	  |Label      |   Participant ID   |      %Displayed%              |
	And Click the "Submit" button on "Retrieve Participant Status (Single Participant)" page
  And The "Retrieve Participant Status (Single Participant)" result table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          			|   Values      |
	#-----------------------------------------------------------------
	  |Participant ID         			|  %NOTEMPTY%   |
    |Participant Name       			|  %NOTEMPTY%   |
    |Sign-on Status              	|  %NOTEMPTY%   | 
    |Last Sign-on Status Change   |  %NOTEMPTY%   |
    |Suspension Status      			|  %NOTEMPTY%   |
    |Last Suspension Status Change|  %NOTEMPTY%   |
  Then Click the "Export to CSV" button on "Retrieve Participant Status (Single Participant)" page
  And Columns name in the downloaded CSV file is same as "Retrieve Participant Status (Single Participant)" enquiry result screen
	And Close the browser
    Examples: 
    | Portal_Name |      Username             |    Password               | Participant_BankName |
#   | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | 										 |  
   	| Internal    | dev_allAccess_user1       | dev_allAccess_user1       | AlBilad Bank				 |
############################################################################################################
############################################################################################################
@Int_ParticipantSettlementPositions
Scenario Outline: User can inquire the Participant Settlement Positions and view the result on screen
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Participant Settlement Positions" page 
	#---------------------------------------------------------------
	# | Menu                 						 |
	#---------------------------------------------------------------
	  | Reports & Enquiry    						 |
	  | Enquiries            						 |
	  | Participant Settlement Positions |
	And Select "<Participant_BankName>" from Participant drop down list
	And The "Participant Settlement Positions" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name        		 |       Value              |
	#-----------------------------------------------------------------
	  |Label      |   Participant ID   		 |      %Displayed%         |
	  |Label	  |	  Settlement Date	 	 |		%Displayed%		    |
	  |Label   	  |	  Settlement Cycle ID	 |		%Displayed%			|
      |Button     |   Submit           		 |      %Enabled%           |
      |Button     |   Clear Screen     		 |      %Enabled%           |
  And Enter below values in "Participant Settlement Positions" page
	#-----------------------------------------------------------------
	# | Field                       |       Values                  |
	#-----------------------------------------------------------------
	  | Settlement Date             | <Settlement_Date>             |
	  | Settlement Cycle ID         | <Settlement_Cycle_ID>         |  
	And Click the "Submit" button on "Participant Settlement Positions" page
  And The "Participant Settlement Positions" result table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          |   Values      |
	#-----------------------------------------------------------------
	|Participant ID         |  %NOTEMPTY%   |
    |Debit Cap              |  %NOTEMPTY%   | 
    |Net Position           |  %NOTEMPTY%   |
  # |Tracking Position      |  %NOTEMPTY%   |
  # |Tracking Position Limit|  %NOTEMPTY%   |
  # |Available Debit Cap    |  %NOTEMPTY%   |
  # |Debit Cap Utilized %   |  %NOTEMPTY%   |
	Then Click the "Export to CSV" button on "Participant Settlement Positions" page
	And Columns name in the downloaded CSV file is same as "Participant Settlement Positions" enquiry result screen
	And Close the browser
    Examples: 
    | Portal_Name |      Username         |    Password               | Participant_BankName |Settlement_Date    | Settlement_Cycle_ID  |
#   | Internal    | dev_allAccess_user2   | dev_allAccess_user2       | AlBilad Bank		 |%TodayDate%        | 002		            | 
	| Internal    | dev_allAccess_user2   | dev_allAccess_user2       | AlBilad Bank		 |%PreviousDate%     | 002		            | 
############################################################################################################
############################################################################################################
@Int_ValueTransactionEnquiryByTransactionID
Scenario Outline: User can inquire the Value Transaction Enquiry and view the result on screen By Transaction ID
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Value Transaction Enquiry" page 
	#---------------------------------------------------------------
	# | Menu                 			|
	#---------------------------------------------------------------
	  | Reports & Enquiry    			|
	  | Enquiries            			|
	  | Value Transaction Enquiry       |
	And Select "<Participant_BankName>" from Participant drop down list	  
  And Select "By Transaction ID" radio button  
	And The "Value Transaction Enquiry" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name        |       Value                   |
	#-----------------------------------------------------------------
	  |Label	  |   Transaction ID   |      %Displayed%        	   |
	  |Button     |   Submit           |      %Enabled%                |
      |Button     |   Clear Screen     |      %Enabled%                |
  And Enter below values in "Value Transaction Enquiry" page
	#-----------------------------------------------------------------
	# | Field                       |       Values                  |
	#-----------------------------------------------------------------
	  | Transaction ID             | <Transaction_ID>             	|
	And Click the "Submit" button on "Value Transaction Enquiry" page
  And The "Value Transaction Enquiry" result table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          |   Values      |
	#-----------------------------------------------------------------
	|Transaction ID         |  %NOTEMPTY%   |
    |Transaction Date/Time  |  %NOTEMPTY%   |
    |Sending R/T (Bank ID)  |  %NOTEMPTY%   | 
    |Status          		|  %NOTEMPTY%   |
    |Local Instrument      	|  %NOTEMPTY%   |
    |Category Purpose Code  |  %NOTEMPTY%   |
	And Click the "Details" button on "Value Transaction Enquiry" page
	And Click the "Close" button on "Transaction Details" page
	Then Click the "Export to CSV" button on "Value Transaction Enquiry" page
	And Columns name in the downloaded CSV file is same as "Value Transaction Enquiry" enquiry result screen
	And Close the browser
    Examples: 
    | Portal_Name |      Username             |    Password               | Participant_BankName |Transaction_ID    | 
#   | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | 										 |ABCD20200603100   | 
    | Internal    | dev_allAccess_user2       | dev_allAccess_user2       | AlBilad Bank				 |ABCD20200603100		|
############################################################################################################
############################################################################################################
@Int_ValueTransactionEnquiryforToday
Scenario Outline: User can inquire the Value Transaction Enquiry and view the result on screen for Today  
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Value Transaction Enquiry" page 
	#---------------------------------------------------------------
	# | Menu                 			|
	#---------------------------------------------------------------
	  | Reports & Enquiry    			|
	  | Enquiries            			|
	  | Value Transaction Enquiry |
  And Select "<Participant_BankName>" from Participant drop down list
  And Select "Advance" radio button
  And Select "Today" radio button  
	And The "Value Transaction Enquiry" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name        		 		|       Value             	|
	#-----------------------------------------------------------------
	  |Label			|   Participant ID 	 		 		|      %Displayed%         	|
	  |Label			|   Settlement Cycle ID	 		|      %Displayed%  				|
	  |Label			|   Routing Number (Bank ID)|      %Displayed%   				|
	  |Label			|   Local Instrument 		 		|      %Displayed%         	|
	  |Label			|   Transaction Amount	 		|      %Displayed%  				|
	  |Label			|   Transaction Status	 		|      %Displayed%         	|
	  |Label			|   Reason Code	 						|      %Displayed%         	|
	  |Label			|   Category Purpose Code	 	|      %Displayed%         	|
	  |Button     |   Submit           				|      %Enabled%            |
    |Button     |   Clear Screen     				|      %Enabled%            |
	And Enter below values in "Value Transaction Enquiry" page
	#-----------------------------------------------------------------
	# | Field                       |       Values                  |
	#-----------------------------------------------------------------
	  | Settlement Cycle ID         | <Settlement_Cycle_ID>		      |
	  | Routing Number (Bank ID)    | <Routing_Number>     					|
	  | Local Instrument            | <Local_Instrument>     				|
	  | Transaction Amount          | <Transaction_Amount>     			|
	  | Transaction Status          | <Transaction_Status>     			|
	  | Reason Code             		| <Reason_Code>     						|
	  | Category Purpose Code       | <Category_Purpose_Code>     	|
	And Click the "Submit" button on "Value Transaction Enquiry" page
  And The "Value Transaction Enquiry" result table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          |   Values      |
	#-----------------------------------------------------------------
	  |Transaction ID         |  %NOTEMPTY%   |
    |Transaction Date/Time  |  %NOTEMPTY%   |
    |Sending R/T (Bank ID)  |  %NOTEMPTY%   | 
    |Status          				|  %NOTEMPTY%   |
    |Local Instrument      	|  %NOTEMPTY%   |
	And Click the "Details" button on "Value Transaction Enquiry" page
	And Click the "Close" button on "Transaction Details" page
	Then Click the "Export to CSV" button on "Value Transaction Enquiry" page
	And Columns name in the downloaded CSV file is same as "Value Transaction Enquiry" enquiry result screen
	And Close the browser
    Examples: 
    | Portal_Name |      Username             |    Password               | Participant_BankName |Settlement_Cycle_ID    | Routing_Number	 | Local_Instrument      |Transaction_Amount   | Transaction_Status  | Reason_Code      		| Category_Purpose_Code   |
#   | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | 										 |001    								 | 000000045 			 | Credit Transfer	     |5000	 					     | Accept							 | 0000			      		  | Bonus Payment				    | 
    | Internal    | dev_allAccess_user1       | dev_allAccess_user1       | AlBilad Bank				 |001    								 | 000000045 			 | Credit Transfer	     |5000	 					     | Accept							 | 0000			      		  | Bonus Payment				    |
############################################################################################################
############################################################################################################
@Int_ValueTransactionEnquiryByHistory
Scenario Outline: User can inquire the Value Transaction Enquiry and view the result on screen by History
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Value Transaction Enquiry" page 
	#---------------------------------------------------------------
	# | Menu                 			|
	#---------------------------------------------------------------
	  | Reports & Enquiry    			|
	  | Enquiries            			|
	  | Value Transaction Enquiry |
  And Select "<Participant_BankName>" from Participant drop down list
  And Select "Advance" radio button
  And Select "Historic" radio button  
	And The "Value Transaction Enquiry" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name        		 		 |       Value          	  |
	#-----------------------------------------------------------------
	  |Label			|		Date Start						 	 |			%Displayed%			 		|
	  |Label			|		Date End			  				 |			%Displayed%				 	|
	  |Label			|   Participant ID 	 		 		 |      %Displayed%      		|
	  |Label			|   Settlement Cycle ID	 		 |      %Displayed%   			|
	  |Label			|   Routing Number (Bank ID) |      %Displayed%   			|
	  |Label			|   Local Instrument 		 		 |      %Displayed%         |
	  |Label			|   Transaction Amount	 		 |      %Displayed%  				|
	  |Label			|   Transaction Status	 		 |      %Displayed%         |
	  |Label			|   Reason Code	 						 |      %Displayed%         |
	  |Label			|   Category Purpose Code	 	 |      %Displayed%         |
	  |Button     |   Submit           				 |      %Enabled%           |
    |Button     |   Clear Screen     				 |      %Enabled%           |
  And Enter below values in "Value Transaction Enquiry" page
	#-----------------------------------------------------------------
	# | Field                       |       Values                  |
	#-----------------------------------------------------------------
	  | Date Start         					| <Date_Start>		      				|
	  | Date End         						| <Date_End>		      					|
	  | Settlement Cycle ID         | <Settlement_Cycle_ID>		      |
	  | Routing Number (Bank ID)    | <Routing_Number>     					|
	  | Local Instrument            | <Local_Instrument>     				|
	  | Transaction Amount          | <Transaction_Amount>     			|
	  | Transaction Status          | <Transaction_Status>     			|
	  | Reason Code             		| <Reason_Code>     						|
	  | Category Purpose Code       | <Category_Purpose_Code>     	|  
	And Click the "Submit" button on "Value Transaction Enquiry" page
  And The "Value Transaction Enquiry" result table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          |   Values      |
	#-----------------------------------------------------------------
	  |Transaction ID         |  %NOTEMPTY%   |
    |Transaction Date/Time  |  %NOTEMPTY%   |
    |Sending R/T (Bank ID)  |  %NOTEMPTY%   | 
    |Status          				|  %NOTEMPTY%   |
    |Local Instrument      	|  %NOTEMPTY%   |
	And Click the "Details" button on "Value Transaction Enquiry" page
	And Click the "Close" button on "Transaction Details" page
	Then Click the "Export to CSV" button on "Value Transaction Enquiry" page
	And Columns name in the downloaded CSV file is same as "Value Transaction Enquiry" enquiry result screen
	And Close the browser
    Examples: 
    | Portal_Name |      Username             |    Password               | Participant_BankName |Date_Start        	| Date_End         		| Settlement_Cycle_ID    | Routing_Number | Local_Instrument      |Transaction_Amount   | Transaction_Status  | Reason_Code      		| Category_Purpose_Code   | 
#   | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | 										 |01/06/2020        	| 04/06/2020         	| 001    								 | 000000045 			| Credit Transfer	      |5000							    | Accept							| 0000			      		| Bonus Payment				    |
    | Internal    | dev_allAccess_user1       | dev_allAccess_user1       | AlBilad Bank				 |01/06/2020        	| 04/06/2020         	| 001    								 | 000000045 			| Credit Transfer	      |5000							    | Accept							| 0000			      		| Bonus Payment				    |
############################################################################################################
############################################################################################################
@Int_RetrieveSettlementCycleDetails
Scenario Outline: User can inquire the Retrieve Settlement Cycle Details - Current & Previous and view the result on screen
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Retrieve Settlement Cycle Details - Current & Previous" page 
	#---------------------------------------------------------------
	# | Menu                 																		|
	#---------------------------------------------------------------
	  | Reports & Enquiry    																		|
	  | Enquiries            																		|
	  | Retrieve Settlement Cycle Details - Current & Previous  |
	And Select "<Participant_BankName>" from Participant drop down list  
	And The "Retrieve Settlement Cycle Details - Current & Previous" result table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          					 |   Values      |
	#-----------------------------------------------------------------
	  |Settlement Cycle ID       				 |  %NOTEMPTY%   |
	  |Expected Cutover Time  					 |  %NOTEMPTY%   |
      |Actual Start Date / Time  				 |  %NOTEMPTY%   |
      |Settlement Cycle Status                   |  %NOTEMPTY%   | 
      |Retry Count           					 |  %NOTEMPTY%   |
      |Blocked Reason      						 |  %NOTEMPTY%   |
  Then Click the "Export to CSV" button on "Retrieve Settlement Cycle Details - Current & Previous" page
	And Columns name in the downloaded CSV file is same as "Retrieve Settlement Cycle Details - Current  Previous" enquiry result screen
	And Close the browser
    Examples: 
    | Portal_Name |      Username             |    Password               | Participant_BankName |
#   | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | 										 | 
    | Internal    | dev_allAccess_user2       | dev_allAccess_user2       | AlBilad Bank				 |
############################################################################################################
############################################################################################################
@Int_SettlementCycleStatus
Scenario Outline: User can inquire the Settlement Cycle Status and view the result on screen
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Settlement Cycle Status" page 
	#---------------------------------------------------------------
	# | Menu                 			|
	#---------------------------------------------------------------
	  | Reports & Enquiry    			|
	  | Enquiries            			|
	  | Settlement Status  				|
	And Select "<Participant_BankName>" from Participant drop down list
	And The "Settlement Cycle Status" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name        		|       Value               |
	#-----------------------------------------------------------------
	  |Label			|		Currency ISO Code		|			%Displayed%						|
	  |Label			|		From Date			 	 		|			%Displayed%						|
	  |Label			|		To Date			 	 			|			%Displayed%						|
    |Button     |   Submit           		|     %Enabled%             |
    |Button     |   Clear Screen     		|     %Enabled%             |
	And Enter below values in "Settlement Cycle Status" page
	#-----------------------------------------------------------------
	# | Field                       |       Values                  |
	#-----------------------------------------------------------------
	  | Currency ISO Code           | <Currency_ISO_Code>		   	    |
	  | From Date         					| <From_Date>		      					|
	  | To Date         						| <To_Date>		      						|
	And Click the "Submit" button on "Settlement Cycle Status" page
  And The "Settlement Cycle Status" result table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          					 |   Values      |
	#-----------------------------------------------------------------
	  |Start Date/Time  								 |  %NOTEMPTY%   |
	  |End Date/Time	  								 |  %NOTEMPTY%   |
    |Settlement Cycle ID       				 |  %NOTEMPTY%   |
    |Status           								 |  %NOTEMPTY%   | 
 #  |Skipped           								 |  %NOTEMPTY%   |
 #  |Inserted      										 |  %NOTEMPTY%   |
 #  |Amended													 |  %NOTEMPTY%   |
 #  |Held    													 |  %NOTEMPTY%   |
  Then Click the "Export to CSV" button on "Settlement Cycle Status" page
	And Columns name in the downloaded CSV file is same as "Settlement Status" enquiry result screen
	And Close the browser
    Examples: 
    | Portal_Name |      Username             |    Password               | Participant_BankName | Currency_ISO_Code |      From_Date     |    To_Date          | 
#   | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | 										 | SAR 							 | 01/06/2020        	| 04/06/2020         	|
 	  | Internal    | dev_allAccess_user1       | dev_allAccess_user1       | AlBilad Bank				 | SAR 							 | 01/06/2020        	| 04/06/2020         	|
############################################################################################################
############################################################################################################
@Int_ViewSettlementCalendar
Scenario Outline: User can inquire the View Settlement Calendar and view the result on screen
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "View Settlement Cycle Calendar" page 
	#---------------------------------------------------------------
	# | Menu                 			|
	#---------------------------------------------------------------
	  | Reports & Enquiry    			|
	  | Enquiries            			|
	  | View Settlement Cycle Calendar  |
	And Select "<Participant_BankName>" from Participant drop down list
	And The "View Settlement Cycle Calendar" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name        |       Value                   |
	#-----------------------------------------------------------------
	  |Label			|		From Date				 |			%Displayed%							 |
	  |Label			|		To Date			 	 	 |			%Displayed%						 	 |
    |Button     |   Submit           |      %Enabled%                |
    |Button     |   Clear Screen     |      %Enabled%                |
	And Enter below values in "View Settlement Cycle Calendar" page
	#-----------------------------------------------------------------
	# | Field                       |       Values                  |
	#-----------------------------------------------------------------
	  | From Date         					| <From_Date>		      			|
	  | To Date         						| <To_Date>		      				|
	And Click the "Submit" button on "View Settlement Cycle Calendar" page
  And The "View Settlement Cycle Calendar" result table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          		   |   Values      |
	#-----------------------------------------------------------------
	|Expected Cutover Start Date/Time  |  %NOTEMPTY%   |
    |Settlement Cycle ID       		   |  %NOTEMPTY%   |
    |Settlement Cycle Status           |  %NOTEMPTY%   | 
    |Skipped           				   |  %NOTEMPTY%   |
    |Inserted      					   |  %NOTEMPTY%   |
    |Amended						   |  %NOTEMPTY%   |
    |Held    						   |  %NOTEMPTY%   |
  Then Click the "Export to CSV" button on "View Settlement Cycle Calendar" page
	And Columns name in the downloaded CSV file is same as "View Settlement Cycle Calendar" enquiry result screen
	And Close the browser
    Examples: 
    | Portal_Name |      Username             |    Password               | Participant_BankName |   From_Date      |    To_Date          |
#   | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | 										 |	01/06/2020      | 04/06/2020          | 
    | Internal    | dev_allAccess_user2       | dev_allAccess_user2       | AlBilad Bank				 | 01/06/2020       | 04/06/2020          |
############################################################################################################
############################################################################################################
@Int_RetrieveSettlementSummary
Scenario Outline: User can inquire the Retrieve Settlement Summary and view the result on screen
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Retrieve Settlement Summary" page 
	#---------------------------------------------------------------
	# | Menu                 				|
	#---------------------------------------------------------------
	  | Reports & Enquiry    				|
	  | Enquiries            				|
	  | Retrieve Settlement Summary |
	And Select "<Participant_BankName>" from Participant drop down list
	And The "Retrieve Settlement Summary" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name        		|    Value                   |
	#-----------------------------------------------------------------
	  |Label      |   Participant ID   		|   %Displayed%              |
	  |Label      |   Currency ISO Code 	|   %Displayed%              |
	  |Label			|		Settlement Date			|		%Displayed%				 			 |
	  |Label			|		Settlement Cycle ID	|		%Displayed%						   |
    |Button     |   Submit           		|   %Enabled%                |
    |Button     |   Clear Screen    	  |   %Enabled%                |
	And Enter below values in "Retrieve Settlement Summary" page
	#-----------------------------------------------------------------
	# | Field                       |       Values                  |
	#-----------------------------------------------------------------
	  | Currency ISO Code           | <Currency_ISO_Code>		   	    |
	  | Settlement Date         		| <Settlement_Date>		      		|
	  | Settlement Cycle ID         | <Settlement_Cycle_ID>		    	|
	And Click the "Submit" button on "Retrieve Settlement Summary" page
  And The "Retrieve Settlement Summary" result table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          	|   Values      |
	#-----------------------------------------------------------------
	  |Settlement Date	  			|  %NOTEMPTY%   |
    |Settlement Cycle ID      |  %NOTEMPTY%   |
    |Settlement Cycle Status  |  %NOTEMPTY%   | 
    |Participant ID          	|  %NOTEMPTY%   |
    |Count of Payments      	|  %NOTEMPTY%   |
    |Value of Payments				|  %NOTEMPTY%   |
  Then Click the "Export to CSV" button on "Retrieve Settlement Summary" page
	And Columns name in the downloaded CSV file is same as "Retrieve Settlement Summary" enquiry result screen
	And Close the browser
    Examples: 
    | Portal_Name |      Username             |    Password               | Participant_BankName | Currency_ISO_Code |  Settlement_Date      | Settlement_Cycle_ID   |
#   | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | 										 |										 | SAR 							| 01/06/2020        		| 001         					|
    | Internal    | dev_allAccess_user1       | dev_allAccess_user1       | AlBilad Bank				 | SAR 							| 01/06/2020        		| 001         					|
############################################################################################################
############################################################################################################
@Int_RetrieveParticipantSNM
Scenario Outline: User can inquire the Retrieve Participant SNM and view the result on screen
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Retrieve Participant SNM" page 
	#---------------------------------------------------------------
	# | Menu                 		 |
	#---------------------------------------------------------------
	  | Reports & Enquiry    		 |
	  | Enquiries            		 |
	  | Retrieve Participant SNM |
	And Select "<Participant_BankName>" from Participant drop down list
	And The "Retrieve Participant SNM" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name        |       Value                   |
	#-----------------------------------------------------------------
	  |Label      |   Participant ID   |      %Displayed%              |
	  |Label			|		Start Date			 |			%Displayed%					 		 |
	  |Label			|		End Date			 	 |			%Displayed%						 	 |
	  |Label			|		Event Types		 	 |			%Displayed%						 	 |	
    |Button     |   Submit           |      %Enabled%                |
    |Button     |   Clear Screen     |      %Enabled%                |
	And Enter below values in "Retrieve Participant SNM" page
	#-----------------------------------------------------------------
	# | Field                       |       Values                  |
	#-----------------------------------------------------------------
	  | Start Date         					| <Start_Date>		      				|
	  | End Date         						| <End_Date>		      					|
	  | Event Types           			| <Event_Types>					   	    |
	And Click the "Submit" button on "Retrieve Participant SNM" page
  And The "Retrieve Participant SNM" result table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          |   Values      |
	#-----------------------------------------------------------------
	  |Event ID         			|  %NOTEMPTY%   |
      |Event Type       			|  %NOTEMPTY%   |
      |Event Code       			|  %NOTEMPTY%   | 
      |Event Timestamp  			|  %NOTEMPTY%   |
      |Affected Node    			|  %NOTEMPTY%   |
      |Details								|  %NOTEMPTY%   |
  Then Click the "Export to CSV" button on "Retrieve Participant SNM" page
	And Columns name in the downloaded CSV file is same as "Retrieve Participant SNM" enquiry result screen
	And Close the browser
    Examples: 
    | Portal_Name |      Username             |    Password               | Participant_BankName | Start_Date    | End_Date     |Event_Types        	|
#   | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | 										 | 01/06/2020    | 04/06/2020   |Debit Cap Change 		|
    | Internal    | dev_allAccess_user2       | dev_allAccess_user2       | AlBilad Bank				 | 01/06/2020    | 04/06/2020   |Debit Cap Change 		|
############################################################################################################
############################################################################################################
@Int_UnbilledActivities
Scenario Outline: User can inquire the Unbilled Activities and view the result on screen
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Unbilled Activities" page 
	#---------------------------------------------------------------
	# | Menu                 		 |
	#---------------------------------------------------------------
	  | Reports & Enquiry    		 |
	  | Enquiries            		 |
	  | Unbilled Activities 		 |
	And Select "<Participant_BankName>" from Participant drop down list
	And The "Unbilled Activities" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name        |       Value                   |
	#-----------------------------------------------------------------
	  |Label      |   Participant ID   |      %Displayed%              |
	  |Button     |   Submit           |      %Enabled%                |
    |Button     |   Clear Screen     |      %Enabled%                |
	And Click the "Submit" button on "Unbilled Activities" page
  And The "Unbilled Activities" result table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          |   Values      |
	#-----------------------------------------------------------------
	  |Participant ID         |  %NOTEMPTY%   |
    |Activity Type   		    |  %NOTEMPTY%   |
    |Transaction Volume     |  %NOTEMPTY%   | 
    |Transaction Value  	  |  %NOTEMPTY%   |
    |Transaction Date   		|  %NOTEMPTY%   |
	Then Click the "Export to CSV" button on "Unbilled Activities" page
	And Columns name in the downloaded CSV file is same as "Unbilled Activities" enquiry result screen
	And Close the browser
    Examples: 
    | Portal_Name |      Username             |    Password               | Participant_BankName | 
#   | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | 										 | 
    | Internal    | dev_allAccess_user1       | dev_allAccess_user1       | AlBilad Bank				 |
############################################################################################################
############################################################################################################
@Int_DisputeDetails
Scenario Outline: User can inquire the Dispute Details and view the result on screen
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Dispute Details" page 
	#---------------------------------------------------------------
	# | Menu                 		 |
	#---------------------------------------------------------------
	  | Reports & Enquiry    		 |
	  | Enquiries            		 |
	  | Dispute Details 				 |
	And Select "<Participant_BankName>" from Participant drop down list
	And The "Dispute Details" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name        |       Value                  |
	#-----------------------------------------------------------------
	  |Label			|		Start Date			 |			%Displayed%					 		|
	  |Label			|		End Date			 	 |			%Displayed%						 	|
	  |Label      |   Disputer Party   |      %Displayed%         		|
	  |Label      |   Disputed Party   |      %Displayed%        			|
	  |Label			|		Dispute Status	 |			%Displayed%							|	
    |Button     |   Submit           |      %Enabled%               |
    |Button     |   Clear Screen     |      %Enabled%               |
	And Enter below values in "Dispute Details" page
	#-----------------------------------------------------------------
	# | Field                       |       Values                  |
	#-----------------------------------------------------------------
	  | Start Date         					| <Start_Date>		      				|
	  | End Date         						| <End_Date>		      					|
	  | Disputer Party           		| <Disputer_Party>					  	|
	  | Disputed Party           		| <Disputed_Party>					  	|
	  | Dispute Status           		| <Dispute_Status>					  	|
	And Click the "Submit" button on "Dispute Details" page
  And The "Dispute Details" result table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          |   Values      |
	#-----------------------------------------------------------------
	  |Dispute ID         		|  %NOTEMPTY%   |
    |IPS Transaction ID     |  %NOTEMPTY%   |
    |Disputer Party         |  %NOTEMPTY%   | 
    |Disputed Party         |  %NOTEMPTY%   |
    |Dispute Category      	|  %NOTEMPTY%   |
    |Dispute Type						|  %NOTEMPTY%   |
    |Creation Date    			|  %NOTEMPTY%   |
    |Last Action Date    		|  %NOTEMPTY%   |
    |Close Date    					|  %NOTEMPTY%   |
    |Dispute Status   			|  %NOTEMPTY%   |
    |Dispute Duration   		|  %NOTEMPTY%   |
	Then Click the "Export to CSV" button on "Dispute Details" page
	And Columns name in the downloaded CSV file is same as "Dispute Details" enquiry result screen
	And Close the browser
    Examples: 
    | Portal_Name |      Username             |    Password               | Participant_BankName | Start_Date         | End_Date         |Disputer_Party          |Disputed_Party         |Dispute_Status        |
#   | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | 										 | 01/06/2020         | 04/06/2020       |AlBilad Bank            |Bank AlJazira         	|Disputed-Under Review |
    | Internal    | dev_allAccess_user1       | dev_allAccess_user1       | AlBilad Bank				 |01/03/2020         | 29/05/2020       |Arab National Bank      |The Saudi British Bank 	|Open									 |
############################################################################################################
############################################################################################################
@Int_BilledAmount
Scenario Outline: User can inquire the Billed Amount and view the result on screen
	Given Open browser "<Browser_Name>" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Billed Amount" page
	#---------------------------------------------------------------
	# | Menu                 		 |
	#---------------------------------------------------------------
	  | Reports & Enquiry    		 |
	  | Enquiries            		 |
	  | Billed Amount 					 |
	And Select "<Participant_BankName>" from Participant drop down list
	And The "Billed Amount" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name        |       Value                   |
	#-----------------------------------------------------------------
	  |Label      |   Participant ID   |      %Displayed%              |
	  |Label	  |	  Start Date	   |	  %Displayed%		       |
	  |Label	  |	  End Date	       |	  %Displayed%		       |
	  |Button     |   Submit           |      %Enabled%                |
      |Button     |   Clear Screen     |      %Enabled%                |
  And Enter below values in "Billed Amount" page
	#-----------------------------------------------------------------
	# | Field                       |       Values                  |
	#-----------------------------------------------------------------
	  | Start Date         					| <Start_Date>		      				|
	  | End Date         						| <End_Date>		      					|  
	And Click the "Submit" button on "Billed Amount" page
  And The "Billed Amount" result table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name    |   Values      |
	#-----------------------------------------------------------------
	  |Participant ID   |  %NOTEMPTY%   |
      |Charging Date    |  %NOTEMPTY%   |
      |Charge Amount    |  %NOTEMPTY%   | 
      |Charge Type      |  %NOTEMPTY%   |
      |Rule ID      	|  %NOTEMPTY%   |
	Then Click the "Export to CSV" button on "Billed Amount" page
	And Columns name in the downloaded CSV file is same as "Billed Amount" enquiry result screen
	And Close the browser
    Examples: 
    | Browser_Name | Portal_Name |      Username             |    Password               | Participant_BankName | Start_Date     |End_Date     |
#   |   Chrome     | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | 						| 01/06/2020     | 04/06/2020  | 
#   |   Chrome     | Internal    | dev_allAccess_user2       | dev_allAccess_user2       | AlBilad Bank		    | 05/02/2020     | 11/02/2020  |
    |  Firefox     | Internal    | dev_allAccess_user2       | dev_allAccess_user2       | AlBilad Bank		    | 05/02/2020     | 11/02/2020  |
############################################################################################################
############################################################################################################
@Int_MPP-RegistrationEnquiries
Scenario Outline: User can inquire the MPP - Registration Enquiries and view the result on screen
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "MPP - Registration Enquiries" page 
	#---------------------------------------------------------------
	# | Menu                 		 				 |
	#---------------------------------------------------------------
	  | Reports & Enquiry    		 				 |
	  | Enquiries            		 				 |
	  | MPP - Registration Enquiries		 |
	And Select "<Participant_BankName>" from Participant drop down list  
	And Select "<Registration_Enquiries>" from "Registration Enquiries" dropdown list in "MPP - Registration Enquiries" page
	And Click the "Select" button on "MPP - Registration Enquiries" page
	And The "MPP - Registration Enquiries" page contains the following GUI items:
	#----------------------------------------------------------------------
	# | GUI Items |        Name        						|      Value              |
	#----------------------------------------------------------------------
	  |Label      |   Participant Code   					|     %Displayed%         |
	# |Label			|		Start Date			 						|			%Displayed%					|
	  |Label			|		Registration ID			 	 			|			%Displayed% 	 		 	|
	  |Button     |   Submit           						|     %Enabled%           |
    |Button     |   Clear Screen     						|     %Enabled%           |
	And Enter below values in "MPP - Registration Enquiries" page
	#-----------------------------------------------------------------
	# | Field                       |       Values                  |
	#-----------------------------------------------------------------
	# | Start Date         					| <Start Date>		      				|
	  | Registration ID         		| <Registration_ID>		      		|
	And Click the "Submit" button on "MPP - Registration Enquiries" page
  And The "MPP - Registration Enquiries" result table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name    	 |   Values      |
	#-----------------------------------------------------------------
	  |Registration Code   |  %NOTEMPTY%   |
    |Proxy Type    			 |  %NOTEMPTY%   |
    |Proxy Value    		 |  %NOTEMPTY%   | 
    |Display Name      	 |  %NOTEMPTY%   |
    |Registered date     |  %NOTEMPTY%   |
    |Status     				 |  %NOTEMPTY%   |
  And Click the "Details" button on "Value Transaction Enquiry" page
	And The "Details" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name          	   |       Value                 |
	#-----------------------------------------------------------------
	  |Label	  	|   Registration Code :  	 |    %Displayed%              |
	  |Label      |   Proxy Type :   				 |    %Displayed%              |
	  |Label	  	|   Proxy Value :	   			 |  	%Displayed%   					 |
	  |Label      |   Account Type : 	   		 |    %Displayed%              |
	  |Label	  	|   Account Value :  			 |  	%Displayed%   			 		 |
	  |Label	  	|   Display Name : 				 |  	%Displayed%   			 		 |
	  |Label	  	|	  Registered date : 		 |  	%Displayed%   			 		 |
	  |Label      |   Status :  	   				 |    %Displayed%              |
	And Click the "Close" button on "Details" page  
	Then Click the "Export to CSV" button on "MPP - Registration Enquiries" page
	And Columns name in the downloaded CSV file is same as "MPP - Registration Enquiries" enquiry result screen
	And Close the browser
    Examples: 
    | Portal_Name |      Username             |    Password               | Participant_BankName  | Registration_Enquiries		    |	Registration_ID  |
#   | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |          							| Enquiry by registration ID		| 12345			       | 
    | Internal    | dev_allAccess_user1       | dev_allAccess_user1       | AlBilad Bank				  | Enquiry by registration ID		| 12345			       |
############################################################################################################
############################################################################################################
@Int_MPP-Non-OwningParticipantEnquiry
Scenario Outline: User can inquire the MPP - Non-Owning Participant Enquiry and view the result on screen
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "MPP - Non-Owning Participant Enquiry" page 
	#---------------------------------------------------------------
	# | Menu                 		 				 				 |
	#---------------------------------------------------------------
	  | Reports & Enquiry    		 				 				 |
	  | Enquiries            		 								 |
	  | MPP - Non-Owning Participant Enquiry		 |
	And Select "<Participant_BankName>" from Participant drop down list  
	And The "MPP - Non-Owning Participant Enquiry" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name        |       Value                   |
	#-----------------------------------------------------------------
	  |Label      |   Participant Code |      %Displayed%              |
	  |Label			|		Proxy Type			 |			%Displayed%					 		 |
	  |Label			|		Proxy Value			 |			%Displayed%						 	 |
	  |Button     |   Submit           |      %Enabled%                |
    |Button     |   Clear Screen     |      %Enabled%                |
  And Enter below values in "MPP - Non-Owning Participant Enquiry" page
	#-----------------------------------------------------------------
	# | Field                       |       Values                  |
	#-----------------------------------------------------------------
	  | Proxy Type         					| <Proxy Type>		      				|
	  | Proxy Value			         		| <Proxy Value>		      				|
	And Click the "Submit" button on "MPP - Non-Owning Participant Enquiry" page
  And The "MPP - Non-Owning Participant Enquiry" result table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name    	 |   Values      |
	#-----------------------------------------------------------------
	  |Proxy Type    			 |  %NOTEMPTY%   |
    |Proxy Value    		 |  %NOTEMPTY%   | 
    |Participant Name    |  %NOTEMPTY%   |
	Then Click the "Export to CSV" button on "MPP - Non-Owning Participant Enquiry" page
	And Columns name in the downloaded CSV file is same as "MPP - Non-Owning Participant Enquiry" enquiry result screen
	And Close the browser 
    Examples: 
    | Portal_Name |      Username             |    Password               | Proxy Type         |  Proxy Value   	|
    | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | 12345			   |  12345				|
#   | Internal    | dev_allAccess_user2       | dev_allAccess_user2       |
############################################################################################################
############################################################################################################