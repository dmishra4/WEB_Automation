Feature: ExternalPortal_Enquiry_ParticipantPosition
@ParticipantPosition_Output 
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
	And The "Participant Position" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name        |       Value                   |
	#-----------------------------------------------------------------
	  |Label      |   Participant ID   |      %NOTEMPTY%               |
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
      | Portal_Name |      Username             |    Password               | 
      | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |   
#     | Internal    | dev_allAccess_user2       | dev_allAccess_user2       | 	
##################################################################################################
##################################################################################################
@Enq_ParticipantUnabletoTransact
Scenario Outline: User can inquire the Participant Unable to Transact Enquiry and view the result on scrren
	Given Open browser "Chrome"
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>"
	Then Navigate to below mentioned menu in order to reach "Participant Unable to Transact" page
	#---------------------------------------------------------------
	# | Menu                 					 |
	#---------------------------------------------------------------
	  | Reports & Enquiry    					 |
	  | Enquiries            					 |
	  | Participant Unable to Transact           |
  And The "Participant Unable to Transact" result table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          	|   Values      |
	#-----------------------------------------------------------------
	  |Participant ID         	|  %NOTEMPTY%   |
      |Participant Name       	|  %NOTEMPTY%   |
      |Default Connection ID  	|  %NOTEMPTY%   |
      |Default Connection Status|  %NOTEMPTY%   |
      |Sign-on Status      		|  %NOTEMPTY%   |
      |Suspension Status	    |  %NOTEMPTY%   |
      |Availability Status		|  %NOTEMPTY%   |
	Then Click the "Export to CSV" button on "Participant Unable to Transact" page
	And Columns name in the downloaded CSV file is same as "Participant Unable to Transact" enquiry result screen
	And Close the browser
    Examples:
    | Portal_Name |      Username             |    Password               |
    | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |
#   | Internal    | dev_allAccess_user2       | dev_allAccess_user2       |
##################################################################################################
##################################################################################################
@Enq_RetrieveParticipantStatus
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
	And The "Retrieve Participant Status (Single Participant)" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name        |       Value                   |
	#-----------------------------------------------------------------
	  |Label      |   Participant ID   |      %NOTEMPTY%               |
  And Click the "Submit" button on "Retrieve Participant Status (Single Participant)" page
  And The "Retrieve Participant Status (Single Participant)" result table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          			|   Values      |
	#-----------------------------------------------------------------
	  |Participant ID         			|  %NOTEMPTY%   |
      |Participant Name       			|  %NOTEMPTY%   |
      |Sign-on Status                	|  %NOTEMPTY%   |
      |Last Sign-on Status Change       |  %NOTEMPTY%   |
      |Suspension Status      			|  %NOTEMPTY%   |
      |Last Suspension Status Change    |  %NOTEMPTY%   |
  Then Click the "Export to CSV" button on "Retrieve Participant Status (Single Participant)" page
  And Columns name in the downloaded CSV file is same as "Retrieve Participant Status (Single Participant)" enquiry result screen
  And Close the browser
    Examples:
    | Portal_Name |      Username             |    Password               |
    | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |
#   | Internal    | dev_allAccess_user2       | dev_allAccess_user2       |
###############################################################################################
###############################################################################################
@Enq_ParticipantSettlementPositions
Scenario Outline: User can inquire the Participant Settlement Positions and view the result on screen
	Given Open browser "Chrome"
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>"
	Then Navigate to below mentioned menu in order to reach "Participant Settlement Positions" page
	#---------------------------------------------------------------
	# | Menu                 						 |
	#---------------------------------------------------------------
	  | Reports & Enquiry    						 |
	  | Enquiries            						 |
	  | Participant Settlement Positions             |
	And The "Participant Settlement Positions" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name        		 |       Value              |
	#-----------------------------------------------------------------
	  |Label      |   Participant ID   		 |      %NOTEMPTY%          |
	  |Label	  |	  Settlement Date	  	 |		%Date%		        |
	  |Label	  |	  Settlement Cycle ID	 |		%List%				|
      |Button     |   Submit           		 |      %Enabled%           |
      |Button     |   Clear Screen     		 |      %Enabled%           |
	Then Enter below values in "Participant Settlement Positions" page 
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
	Then Click the "Export to CSV" button on "Participant Settlement Positions" page
	And Columns name in the downloaded CSV file is same as "Participant Settlement Positions" enquiry result screen
	And Close the browser
    Examples:
    | Portal_Name |      Username             |    Password               | Settlement_Date  | Settlement_Cycle_ID|
    | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |    %TodayDate%   |      001           |
#   | Internal    | dev_allAccess_user2       | dev_allAccess_user2       |   
##################################################################################################
##################################################################################################
@Enq_ValueTransactionEnquiry
Scenario Outline: User can inquire the Value Transaction Enquiry and view the result on screen By Transaction ID
	Given Open browser "<Browser_Name>"
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>"
	Then Navigate to below mentioned menu in order to reach "Value Transaction Enquiry" page
	#---------------------------------------------------------------
	# | Menu                 			|
	#---------------------------------------------------------------
	  | Reports & Enquiry    			|
	  | Enquiries            			|
	  | Value Transaction Enquiry       |
    And Select "By Transaction ID" radio button
	And The "Value Transaction Enquiry" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name          |       Value                   |
	#-----------------------------------------------------------------
	  |Label	  |   Transaction ID 	 |      %Displayed%              |
	  |Button     |   Submit             |      %Enabled%                |
      |Button     |   Clear Screen       |      %Enabled%                |
  And Enter below values in "Value Transaction Enquiry" page
	#-----------------------------------------------------------------
	# | Field                       |       Values                  |
	#-----------------------------------------------------------------
	  | Transaction ID              | <Transaction ID>             	|
  And Click the "Submit" button on "Value Transaction Enquiry" page
  And The "Value Transaction Enquiry" result table contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          |   Values      |
	#-----------------------------------------------------------------
	  |Transaction ID         |  %NOTEMPTY%   |
      |Transaction Date/Time  |  %NOTEMPTY%   |
      |Sending R/T (Bank ID)  |  %NOTEMPTY%   |
      |Status          		  |  %NOTEMPTY%   |
      |Local Instrument       |  %NOTEMPTY%   |
	And Click the "Details" button on "Value Transaction Enquiry" page
	And Click the "Close" button on "Transaction Details" page
	Then Click the "Export to CSV" button on "Value Transaction Enquiry" page
	And Columns name in the downloaded CSV file is same as "Value Transaction Enquiry" enquiry result screen
	And Close the browser
    Examples:
    | Portal_Name |      Username             |    Password               | Transaction ID    | Browser_Name  |
    | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | ABCD20200603100   |  Firefox      |
#   | Internal    | dev_allAccess_user2       | dev_allAccess_user2       |                   |               |
		
		
             
	