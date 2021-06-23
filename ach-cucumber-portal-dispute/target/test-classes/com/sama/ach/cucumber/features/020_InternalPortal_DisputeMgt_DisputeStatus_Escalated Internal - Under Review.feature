@InternalPortal_DisputeStatus
Feature: 020_InternalPortal_DisputeMgt_DisputeStatus_Escalated Internal - Under Review
@020_Int_EscalatedInternalUnderReview
Scenario Outline: InternalPortal_Escalated Internal - Under Review Status Check
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<ExternalPortal_UserID>" and password as "<ExternalPortal_Password>"
    Then Navigate to below mentioned menu in order to reach "Create Dispute" page
      #---------------------------------------------------------------
      # | Menu                 |
      #---------------------------------------------------------------
        | Service Request      |
        | Dispute Management   |
        | Create Dispute       |
    And Enter "Transaction ID" as "<Transaction_ID>" then click on "Submit" button
    And The "Create Dispute" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name                |       Value                   |
	#-----------------------------------------------------------------
	  |Label      |   Transaction Amount:      |      %Displayed%              |
      |Label      |   Transaction Status:      |      %Displayed%              |
      |Label      |   Debtor Participant:      |      %Displayed%              |
      |Label      |   Creditor Participant:    |      %Displayed%              |
      |Label      |   Beneficiary IBAN No:     |      %Displayed%              |
      |Label      |   Requester IBAN No:       |      %Displayed%              |
      |Label      |   Transaction Date & Time: |      %Displayed%              |
      |Label      |   Disputer Party:          |      %Displayed%              |
      |Label      |   Disputed Party:          |      %Displayed%              |
      |Label      |   Dispute Category:        |      %Displayed%              |
      |Label      |   Dispute Type:            |      %Displayed%              |
      |Label      |   Dispute Details:         |      %Displayed%              |
      |Button     |   Create Dispute           |      %Enabled%                |
      |Button     |   Cancel                   |      %Enabled%                |
    And Enter below values in "Create Dispute" page
      #-----------------------------------------------------------------
      # | Field                       |       Values                |
      #-----------------------------------------------------------------
        | Disputer Party              | <Disputer_Party>            |
        | Disputed Party              | <Disputed_Party>            |
        | Dispute Category            | <Dispute_Category>          |
        | Dispute Type                | <Dispute_Type>              |
        | Dispute Details             | <Dispute_Details>           |
    Then Click the "Create Dispute" button on "Create Dispute" page
    When Click the "Yes" button on "Action Confirmation" pop up screen in "Create Dispute" page
    Then Verify the below mentioned confirmation message on "Confirmation of dispute creation" pop up screen 
     """
     Dispute Case has been created successfully.
    """
    When Click the "Close" button on "Confirmation of dispute creation" pop up screen in "Create Dispute" page
    And Close the browser
###############################
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Int>" Portal under "%ENV%" environment with username as "<sp_internal_dispute_action_team1>" and password as "<sp_internal_dispute_action_team_password1>"
    Then Navigate to below mentioned menu in order to reach "Search for Dispute" page
      #---------------------------------------------------------------
      # |       Menu           |
      #---------------------------------------------------------------
        | Service Request      |
        | Dispute Management   |
        | Search for Dispute   |
    And Select "Dispute ID" radio button in "Search for dispute" page
    And Enter "Dispute ID" as "<Dispute_ID>" then click on "Search" button
    And The "searchTableInt" result contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          |   Values      |
	#-----------------------------------------------------------------
	  |   Dispute Id          |  %NOTEMPTY%   |
      |   Transaction ID      |  %NOTEMPTY%   |
      |   Disputer Party      |  %NOTEMPTY%   |
      |   Disputed Party      |  %NOTEMPTY%   |
      |   Creation Date       |  %NOTEMPTY%   |
      |   Close Date          |  %NOTEMPTY%   |
      |   Dispute Status      |  %NOTEMPTY%   |
	And Click the "View Details" button on "Search for Dispute" page
	And Enter below values in "Action Dispute" page
      #-----------------------------------------------------------------
      # | Field                          |          Values             |
      #-----------------------------------------------------------------
 #       | Dispute History                |     <Dispute_History>       |
        | Final Dispute Resolution Result|   <Final_Resolution_Value>  |
    And Click the "Submit for Approval" button on "Action Dispute" page
    When Click the "Yes" button on "Action Confirmation" pop up screen in "SP Action Dispute" page		
    And Click the "Search for Dispute" button on "Dispute Management" page
    And Select "Dispute ID" radio button in "Search for dispute" page
    And Enter "Dispute ID" as "<Dispute_ID>" then click on "Search" button
    Then The value of "Dispute Status" is displayed as "Disputed Party - Sent for Approval" on the "Search for Dispute" page under "Internal" Portal
    And Close the browser
  #########################################
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Int>" Portal under "%ENV%" environment with username as "<sp_internal_dispute_action_team2>" and password as "<sp_internal_dispute_action_team_password2>"
    Then Navigate to below mentioned menu in order to reach "Search for Dispute" page
      #---------------------------------------------------------------
      # | Menu                 |
      #---------------------------------------------------------------
        | Service Request      |
        | Dispute Management   |
        | Search for Dispute   |
    And Select "Dispute ID" radio button in "Search for dispute" page
    And Enter "Dispute ID" as "<Dispute_ID>" then click on "Search" button
    And The "searchTableInt" result contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          |   Values      |
	#-----------------------------------------------------------------
	  |   Dispute Id          |  %NOTEMPTY%   |
      |   Transaction ID      |  %NOTEMPTY%   |
      |   Disputer Party      |  %NOTEMPTY%   |
      |   Disputed Party      |  %NOTEMPTY%   |
      |   Creation Date       |  %NOTEMPTY%   |
      |   Close Date          |  %NOTEMPTY%   |
      |   Dispute Status      |  %NOTEMPTY%   |
	And Click the "View Details" button on "Search for Dispute" page
	And Select "Approve" radio button in "Approve Dispute" page
	And Select "Resolved" radio button in "Approve Dispute" page
	And Click the "Submit" button on "Approve Dispute" page
    When Click the "Yes" button on "Action Confirmation" pop up screen in "Approve Dispute" page		
    And Click the "Search for Dispute" button on "Dispute Management" page
    And Select "Dispute ID" radio button in "Search for dispute" page
    And Enter "Dispute ID" as "<Dispute_ID>" then click on "Search" button
    Then The value of "Dispute Status" is displayed as "Disputed Party - Sent for Resolution" on the "Search for Dispute" page under "Internal" Portal
    And Close the browser
  ###############################
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<ExternalPortal_UserID>" and password as "<ExternalPortal_Password>"
    Then Navigate to below mentioned menu in order to reach "Search for Dispute" page
      #---------------------------------------------------------------
      # | Menu                 |
      #---------------------------------------------------------------
        | Service Request      |
        | Dispute Management   |
        | Search for Dispute   |
    And Select "Dispute ID" radio button in "Search for dispute" page
    And Enter "Dispute ID" as "<Dispute_ID>" then click on "Search" button
    And The "searchTable" result contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          |   Values      |
	#-----------------------------------------------------------------
	  |   Dispute Id          |  %NOTEMPTY%   |
      |   Transaction ID      |  %NOTEMPTY%   |
      |   Disputer Party      |  %NOTEMPTY%   |
      |   Disputed Party      |  %NOTEMPTY%   |
      |   Creation Date       |  %NOTEMPTY%   |
      |   Close Date          |  %NOTEMPTY%   |
      |   Dispute Status      |  %NOTEMPTY%   |
	And Click the "View Details" button on "Search for Dispute" page
	And Enter below values in "Action Dispute" page
      #-----------------------------------------------------------------
      # | Field                          |          Values             |
      #-----------------------------------------------------------------
#        | Dispute History                |     <Dispute_History>       |
        | Final Dispute Resolution Result|   <Final_Resolution_Value>  |
    And Click the "Submit for Approval" button on "Action Dispute" page
    When Click the "Yes" button on "Action Confirmation" pop up screen in "Action Dispute" page		
    And Click the "Search for Dispute" button on "Dispute Management" page
    And Select "Dispute ID" radio button in "Search for dispute" page
    And Enter "Dispute ID" as "<Dispute_ID>" then click on "Search" button
    Then The value of "Dispute Status" is displayed as "Disputer Party - Sent for Approval" under "Search for Dispute" page
    And Close the browser
 #########################################
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Disputer_Party_User_Id>" and password as "<Disputer_Party_Password>"
    Then Navigate to below mentioned menu in order to reach "Search for Dispute" page
      #---------------------------------------------------------------
      # | Menu                 |
      #---------------------------------------------------------------
        | Service Request      |
        | Dispute Management   |
        | Search for Dispute   |
    And Select "Dispute ID" radio button in "Search for dispute" page
    And Enter "Dispute ID" as "<Dispute_ID>" then click on "Search" button
    And The "searchTable" result contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          |   Values      |
	#-----------------------------------------------------------------
	  |   Dispute Id          |  %NOTEMPTY%   |
      |   Transaction ID      |  %NOTEMPTY%   |
      |   Disputer Party      |  %NOTEMPTY%   |
      |   Disputed Party      |  %NOTEMPTY%   |
      |   Creation Date       |  %NOTEMPTY%   |
      |   Close Date          |  %NOTEMPTY%   |
      |   Dispute Status      |  %NOTEMPTY%   |
	And Click the "View Details" button on "Search for Dispute" page
	And Select "Approve" radio button in "Approve Dispute" page
	And Select "Escalate" radio button in "Approve Dispute" page
	And Click the "Submit" button on "Approve Dispute" page
    When Click the "Yes" button on "Action Confirmation" pop up screen in "Approve Dispute" page		
    And Click the "Search for Dispute" button on "Dispute Management" page
    And Select "Dispute ID" radio button in "Search for dispute" page
    And Enter "Dispute ID" as "<Dispute_ID>" then click on "Search" button
    Then The value of "Dispute Status" is displayed as "Escalated Internal" under "Search for Dispute" page
    And Close the browser
 #########################################
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Int>" Portal under "%ENV%" environment with username as "<dispute_internal_action_team_ID>" and password as "<dispute_internal_action_team_Password>"
    Then Navigate to below mentioned menu in order to reach "Search for Dispute" page
      #---------------------------------------------------------------
      # | Menu                 |
      #---------------------------------------------------------------
        | Service Request      |
        | Dispute Management   |
        | Search for Dispute   |
    And Select "Dispute ID" radio button in "Search for dispute" page
    And Enter "Dispute ID" as "<Dispute_ID>" then click on "Search" button
    And The "searchTableInt" result contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          |   Values      |
	#-----------------------------------------------------------------
	  |   Dispute Id          |  %NOTEMPTY%   |
      |   Transaction ID      |  %NOTEMPTY%   |
      |   Disputer Party      |  %NOTEMPTY%   |
      |   Disputed Party      |  %NOTEMPTY%   |
      |   Creation Date       |  %NOTEMPTY%   |
      |   Close Date          |  %NOTEMPTY%   |
      |   Dispute Status      |  %NOTEMPTY%   |  
    And Click the "View Details" button on "Search for Dispute" page
	And Enter below values in "Action Dispute" page
      #-----------------------------------------------------------------
      # | Field                          |          Values             |
      #-----------------------------------------------------------------
        | Dispute History                |     <Dispute_History>       |
    And Click the "Save As Draft" button on "Action Dispute" page
    When Click the "Yes" button on "Action Confirmation" pop up screen in "SP Action Dispute" page		
    And Click the "Search for Dispute" button on "Dispute Management" page
    And Select "Dispute ID" radio button in "Search for dispute" page
    And Enter "Dispute ID" as "<Dispute_ID>" then click on "Search" button
    Then The value of "Dispute Status" is displayed as "Escalated Internal - Under Review" on the "Search for Dispute" page under "Internal" Portal
    And Close the browser
    Examples: 
      | Browser_Name| Portal_Name | ExternalPortal_UserID   |         ExternalPortal_Password        |         Transaction_ID              |Disputer_Party| Disputed_Party|Dispute_Category  |Dispute_Type     |Dispute_Details  |Dispute_ID | Dispute_History | Portal_Int    |sp_internal_dispute_action_team1 |sp_internal_dispute_action_team_password1|Final_Resolution_Value |sp_internal_dispute_action_team2 |sp_internal_dispute_action_team_password2 |Disputer_Party_User_Id     |Disputer_Party_Password    |dispute_internal_action_team_ID | dispute_internal_action_team_Password|
      |    Chrome   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B00000000000301  |AlBilad Bank  | Saudi Payments|Customer complaint|Wrong information|Dispute Occoured | %RUNTIME% | Dispute History |Internal      |       SaudiUser1                |       SaudiUser1                        | Resolution test       |          SaudiUser3             |              SaudiUser3                  |dev_SAALBI_allAccess_user2 |dev_SAALBI_allAccess_user2 |     SaudiIntUser1              |    SaudiIntUser1                     |
    # |    Firefox  | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B000000000003010 |AlBilad Bank  | Bank AlJazira |Customer complaint|Wrong information|Dispute Occoured |

###################################################    END     ############################################################################################################################################################