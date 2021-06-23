 Feature: InternalPortal_DisputeMgt_StatusCheckDispute
 @Int_EscalatedUnderReview
 Scenario Outline: InternalPortal_DisputeMgt_DisputeStatus_Escalated Under Review
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
    Then Navigate to below mentioned menu in order to reach "Create Dispute" page
      #---------------------------------------------------------------
      # | Menu                 |
      #---------------------------------------------------------------
        | Service Request      |
        | Dispute Management   |
        | View All Disputes    |
    And The "View All Disputes" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name                |       Value                   |
	#-----------------------------------------------------------------
	  |Label      |   Dispute Status           |      %Displayed%              |
    And Select "<Dispute Status>" from "Dispute Status" dropdown list in "View All Disputes" page
    And The "viewTableInt" result contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          |   Values      |
	#-----------------------------------------------------------------
	  |   Dispute ID          |  %NOTEMPTY%   |
      |   Disputed Party      |  %NOTEMPTY%   |
      |   Creation Date       |  %NOTEMPTY%   |
      |   Close Date          |  %NOTEMPTY%   |
      |   Dispute Status      |  %NOTEMPTY%   |
    Then The value of "Dispute Status" is displayed as "Escalated" on the "View All Disputes" page under "Internal" Portal
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
    Then The value of "Dispute Status" is displayed as "Escalated - Under Review" on the "Search for Dispute" page under "Internal" Portal
    And Close the browser
    Examples: 
      | Browser_Name| Portal_Name |        user_id          |         password        |   Dispute Status | Dispute_History |Dispute_ID |
      |    Chrome   | Internal    |      SaudiUser1         |SaudiUser1               |   Escalated      | Dispute History |%RUNTIME%  |
#     |    Chrome   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user|      All         |
#     |    Chrome   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user|      Open        |
    # |    Firefox  | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 2019080800000    |
  ##########################################################################
  ##########################################################################
  @Int_EscalatedSentforApprovalandResolved
 Scenario Outline: InternalPortal_DisputeMgt_DisputeStatus_Escalated Sent for Approval and Resolved
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<sp_internal_dispute_action_team1>" and password as "<sp_internal_dispute_action_team_password1>"
    Then Navigate to below mentioned menu in order to reach "Create Dispute" page
      #---------------------------------------------------------------
      # | Menu                 |
      #---------------------------------------------------------------
        | Service Request      |
        | Dispute Management   |
        | View All Disputes    |
    And The "View All Disputes" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name                |       Value                   |
	#-----------------------------------------------------------------
	  |Label      |   Dispute Status           |      %Displayed%              |
    And Select "<Dispute Status>" from "Dispute Status" dropdown list in "View All Disputes" page
    And The "viewTableInt" result contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          |   Values      |
	#-----------------------------------------------------------------
	  |   Dispute ID          |  %NOTEMPTY%   |
      |   Disputed Party      |  %NOTEMPTY%   |
      |   Creation Date       |  %NOTEMPTY%   |
      |   Close Date          |  %NOTEMPTY%   |
      |   Dispute Status      |  %NOTEMPTY%   |
    Then The value of "Dispute Status" is displayed as "Escalated" on the "View All Disputes" page under "Internal" Portal
    And Click the "View Details" button on "Search for Dispute" page
	And Enter below values in "Action Dispute" page
      #-----------------------------------------------------------------
      # | Field                          |          Values             |
      #-----------------------------------------------------------------
        | Dispute History                |     <Dispute_History>       |
        | Final Dispute Resolution Result|   <Final_Resolution_Value>  |
    And Click the "Submit for Approval" button on "Action Dispute" page
    When Click the "Yes" button on "Action Confirmation" pop up screen in "SP Action Dispute" page		
    And Click the "Search for Dispute" button on "Dispute Management" page
    And Select "Dispute ID" radio button in "Search for dispute" page
    And Enter "Dispute ID" as "<Dispute_ID>" then click on "Search" button
    Then The value of "Dispute Status" is displayed as "Escalated - Sent for Approval" on the "Search for Dispute" page under "Internal" Portal
    And Close the browser
#########################################
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<sp_internal_dispute_action_team2>" and password as "<sp_internal_dispute_action_team_password2>"
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
	And Click the "Submit" button on "Approve Dispute" page
    When Click the "Yes" button on "Action Confirmation" pop up screen in "Approve Dispute" page		
    And Click the "Search for Dispute" button on "Dispute Management" page
    And Select "Dispute ID" radio button in "Search for dispute" page
    And Enter "Dispute ID" as "<Dispute_ID>" then click on "Search" button
    Then The value of "Dispute Status" is displayed as "Resolved" on the "Search for Dispute" page under "Internal" Portal
    And Close the browser
    Examples: 
      | Browser_Name| Portal_Name | sp_internal_dispute_action_team1 | sp_internal_dispute_action_team_password1 |   Dispute Status | Dispute_History |Final_Resolution_Value |Dispute_ID |sp_internal_dispute_action_team2 |sp_internal_dispute_action_team_password2|
      |    Chrome   | Internal    |      SaudiUser1                  |SaudiUser1                                 |   Escalated      | Dispute History |Final Resolution Value |%RUNTIME%  |         SaudiUser3               |          SaudiUser3                     |
#     |    Chrome   | External    |dev_SAALBI_allAccess_user         |dev_SAALBI_allAccess_user                  |      All         |
#############################################################################################
#############################################################################################
 @Int_EscalatedReturnedforReview
 Scenario Outline: InternalPortal_DisputeMgt_DisputeStatus_Escalated Returned for Review
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<sp_internal_dispute_action_team1>" and password as "<sp_internal_dispute_action_team_password1>"
    Then Navigate to below mentioned menu in order to reach "Create Dispute" page
      #---------------------------------------------------------------
      # | Menu                 |
      #---------------------------------------------------------------
        | Service Request      |
        | Dispute Management   |
        | View All Disputes    |
    And The "View All Disputes" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name                |       Value                   |
	#-----------------------------------------------------------------
	  |Label      |   Dispute Status           |      %Displayed%              |
    And Select "<Dispute Status>" from "Dispute Status" dropdown list in "View All Disputes" page
    And The "viewTableInt" result contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          |   Values      |
	#-----------------------------------------------------------------
	  |   Dispute ID          |  %NOTEMPTY%   |
      |   Disputed Party      |  %NOTEMPTY%   |
      |   Creation Date       |  %NOTEMPTY%   |
      |   Close Date          |  %NOTEMPTY%   |
      |   Dispute Status      |  %NOTEMPTY%   |
    Then The value of "Dispute Status" is displayed as "Escalated" on the "View All Disputes" page under "Internal" Portal
    And Click the "View Details" button on "Search for Dispute" page
	And Enter below values in "Action Dispute" page
      #-----------------------------------------------------------------
      # | Field                          |          Values             |
      #-----------------------------------------------------------------
        | Dispute History                |     <Dispute_History>       |
        | Final Dispute Resolution Result|   <Final_Resolution_Value>  |
    And Click the "Submit for Approval" button on "Action Dispute" page
    When Click the "Yes" button on "Action Confirmation" pop up screen in "SP Action Dispute" page		
    And Click the "Search for Dispute" button on "Dispute Management" page
    And Select "Dispute ID" radio button in "Search for dispute" page
    And Enter "Dispute ID" as "<Dispute_ID>" then click on "Search" button
    Then The value of "Dispute Status" is displayed as "Escalated - Sent for Approval" on the "Search for Dispute" page under "Internal" Portal
    And Close the browser
#########################################
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<sp_internal_dispute_action_team2>" and password as "<sp_internal_dispute_action_team_password2>"
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
    And Select "Reject" radio button in "Approve Dispute" page
	And Enter "Reason of Rejection" as "<Rejection_Reason>" then click on "Submit" button
    When Click the "Yes" button on "Action Confirmation" pop up screen in "Approve Dispute" page		
    And Click the "Search for Dispute" button on "Dispute Management" page
    And Select "Dispute ID" radio button in "Search for dispute" page
    And Enter "Dispute ID" as "<Dispute_ID>" then click on "Search" button
    Then The value of "Dispute Status" is displayed as "Escalated - Returned for Review" on the "Search for Dispute" page under "Internal" Portal
    And Close the browser
    Examples: 
      | Browser_Name| Portal_Name | sp_internal_dispute_action_team1 | sp_internal_dispute_action_team_password1 |   Dispute Status | Dispute_History |Final_Resolution_Value |Dispute_ID |sp_internal_dispute_action_team2 |sp_internal_dispute_action_team_password2|Rejection_Reason|
      |    Chrome   | Internal    |      SaudiUser1                  |SaudiUser1                                 |   Escalated      | Dispute History |Final Resolution Value |%RUNTIME%  |         SaudiUser3               |          SaudiUser3                    |   Rejected     |
#     |    Chrome   | External    |dev_SAALBI_allAccess_user         |dev_SAALBI_allAccess_user                  |      All         | Dispute History |Final Resolution Value |%RUNTIME%  |
############################################################################################################
############################################################################################################
@Int_EscalatedInternal
Scenario Outline: Escalated Internal Status Check
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
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
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
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
 ###############################  
    Examples: 
      | Browser_Name| Portal_Name |        user_id          |         password        |         Transaction_ID              |Disputer_Party| Disputed_Party|Dispute_Category  |Dispute_Type     |Dispute_Details  |Dispute_ID |  Portal_Int    |sp_internal_dispute_action_team1 |sp_internal_dispute_action_team_password1|Final_Resolution_Value |sp_internal_dispute_action_team2 |sp_internal_dispute_action_team_password2 |Disputer_Party_User_Id     |Disputer_Party_Password    |
      |    Chrome   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B00000000000301  |AlBilad Bank  | Saudi Payments|Customer complaint|Wrong information|Dispute Occoured | %RUNTIME% |  Internal      |       SaudiUser1                |       SaudiUser1                        | Resolution test       |          SaudiUser3             |              SaudiUser3                  |dev_SAALBI_allAccess_user2 |dev_SAALBI_allAccess_user2 |
    # |    Firefox  | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B000000000003010 |AlBilad Bank  | Bank AlJazira |Customer complaint|Wrong information|Dispute Occoured |
###############################################################################################################################################################################################################
#####################################################################################################################################
@Int_EscalatedInternalUnderReview
Scenario Outline: Escalated Internal - Under Review Status Check
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
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
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
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
      | Browser_Name| Portal_Name |        user_id          |         password        |         Transaction_ID              |Disputer_Party| Disputed_Party|Dispute_Category  |Dispute_Type     |Dispute_Details  |Dispute_ID | Dispute_History | Portal_Int    |sp_internal_dispute_action_team1 |sp_internal_dispute_action_team_password1|Final_Resolution_Value |sp_internal_dispute_action_team2 |sp_internal_dispute_action_team_password2 |Disputer_Party_User_Id     |Disputer_Party_Password    |dispute_internal_action_team_ID | dispute_internal_action_team_Password|
      |    Chrome   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B00000000000301  |AlBilad Bank  | Saudi Payments|Customer complaint|Wrong information|Dispute Occoured | %RUNTIME% | Dispute History |Internal      |       SaudiUser1                |       SaudiUser1                        | Resolution test       |          SaudiUser3             |              SaudiUser3                  |dev_SAALBI_allAccess_user2 |dev_SAALBI_allAccess_user2 |     SaudiIntUser1              |    SaudiIntUser1                     |
    # |    Firefox  | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B000000000003010 |AlBilad Bank  | Bank AlJazira |Customer complaint|Wrong information|Dispute Occoured |
###############################################################################################################################################################################################################
#####################################################################################################################################
###############################################################################################################################################################################################################
#####################################################################################################################################
@Int_EscalatedInternalSentforApproval
Scenario Outline: Escalated Internal - Sent for Approval Status Check
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
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
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
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
        | Final Dispute Resolution Result|   <Final_Resolution_Value>  |
    And Click the "Submit for Approval" button on "Action Dispute" page
    When Click the "Yes" button on "Action Confirmation" pop up screen in "SP Action Dispute" page		
    And Click the "Search for Dispute" button on "Dispute Management" page
    And Select "Dispute ID" radio button in "Search for dispute" page
    And Enter "Dispute ID" as "<Dispute_ID>" then click on "Search" button
    Then The value of "Dispute Status" is displayed as "Escalated Internal - Sent for Approval" on the "Search for Dispute" page under "Internal" Portal
    And Close the browser
    Examples: 
      | Browser_Name| Portal_Name |        user_id          |         password        |         Transaction_ID              |Disputer_Party| Disputed_Party|Dispute_Category  |Dispute_Type     |Dispute_Details  |Dispute_ID | Dispute_History | Portal_Int    |sp_internal_dispute_action_team1 |sp_internal_dispute_action_team_password1|Final_Resolution_Value |sp_internal_dispute_action_team2 |sp_internal_dispute_action_team_password2 |Disputer_Party_User_Id     |Disputer_Party_Password    |dispute_internal_action_team_ID  | dispute_internal_action_team_Password|
      |    Chrome   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B00000000000301  |AlBilad Bank  | Saudi Payments|Customer complaint|Wrong information|Dispute Occoured | %RUNTIME% | Dispute History |Internal      |       SaudiUser1                |       SaudiUser1                        | Resolution test       |          SaudiUser3             |              SaudiUser3                  |dev_SAALBI_allAccess_user2 |dev_SAALBI_allAccess_user2  |     SaudiIntUser1               |    SaudiIntUser1                      |        
    # |    Firefox  | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B000000000003010 |AlBilad Bank  | Bank AlJazira |Customer complaint|Wrong information|Dispute Occoured |
###############################################################################################################################################################################################################
#####################################################################################################################################
###############################################################################################################################################################################################################
#####################################################################################################################################
###############################################################################################################################################################################################################
#####################################################################################################################################
@Int_EscalatedInternalReturnedforReview
Scenario Outline: Escalated Internal - Returned for Review Status Check
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
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
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
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
    When Login to "<Portal_Int>" Portal under "%ENV%" environment with username as "<dispute_internal_action_team_ID1>" and password as "<dispute_internal_action_team_Password1>"
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
        | Final Dispute Resolution Result|   <Final_Resolution_Value>  |
    And Click the "Submit for Approval" button on "Action Dispute" page
    When Click the "Yes" button on "Action Confirmation" pop up screen in "SP Action Dispute" page		
    And Click the "Search for Dispute" button on "Dispute Management" page
    And Select "Dispute ID" radio button in "Search for dispute" page
    And Enter "Dispute ID" as "<Dispute_ID>" then click on "Search" button
    Then The value of "Dispute Status" is displayed as "Escalated Internal - Sent for Approval" on the "Search for Dispute" page under "Internal" Portal
    And Close the browser
 #########################################
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Int>" Portal under "%ENV%" environment with username as "<dispute_internal_action_team_ID2>" and password as "<dispute_internal_action_team_Password2>"
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
    And Select "Reject" radio button in "Approve Dispute" page
	And Enter "Reason of Rejection" as "<Rejection_Reason>" then click on "Submit" button
    When Click the "Yes" button on "Action Confirmation" pop up screen in "Approve Dispute" page		
    And Click the "Search for Dispute" button on "Dispute Management" page
    And Select "Dispute ID" radio button in "Search for dispute" page
    And Enter "Dispute ID" as "<Dispute_ID>" then click on "Search" button
    Then The value of "Dispute Status" is displayed as "Escalated Internal - Returned for Review" on the "Search for Dispute" page under "Internal" Portal
    And Close the browser
   Examples: 
      | Browser_Name| Portal_Name |        user_id          |         password        |         Transaction_ID              |Disputer_Party| Disputed_Party|Dispute_Category  |Dispute_Type     |Dispute_Details  |Dispute_ID | Dispute_History | Portal_Int    |sp_internal_dispute_action_team1 |sp_internal_dispute_action_team_password1|Final_Resolution_Value |sp_internal_dispute_action_team2 |sp_internal_dispute_action_team_password2 |Disputer_Party_User_Id     |Disputer_Party_Password    |dispute_internal_action_team_ID1 | dispute_internal_action_team_Password1|dispute_internal_action_team_ID2 |dispute_internal_action_team_Password2|Rejection_Reason     | Disputer_Party_User_Id    | Disputer_Party_Password  |
      |    Chrome   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B00000000000301  |AlBilad Bank  | Saudi Payments|Customer complaint|Wrong information|Dispute Occoured | %RUNTIME% | Dispute History |Internal       |       SaudiUser1                |       SaudiUser1                        | Resolution test       |          SaudiUser3             |              SaudiUser3                  |dev_SAALBI_allAccess_user2 |dev_SAALBI_allAccess_user2  |     SaudiIntUser1               |    SaudiIntUser1                     |         SaudiIntUser2            |     SaudiIntUser2                   | Returned for Review |dev_SAALBI_allAccess_user2 |dev_SAALBI_allAccess_user2|
    # |    Firefox  | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B000000000003010 |AlBilad Bank  | Bank AlJazira |Customer complaint|Wrong information|Dispute Occoured |
############################################################################################################
############################################################################################################
@Int_OpenToEscalatedInternal
Scenario Outline: Open to Escalated Internal Status Check
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
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
    ###############################
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
	And Enter below values in "Action Dispute" page
      #-----------------------------------------------------------------
      # | Field                          |          Values             |
      #-----------------------------------------------------------------
        | Dispute History                |     <Dispute_History>       |
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
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
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
	And Select "Reject" radio button in "Approve Dispute" page
	And Enter "Reason of Rejection" as "<Rejection_Reason>" then click on "Submit" button
    When Click the "Yes" button on "Action Confirmation" pop up screen in "Approve Dispute" page		
    And Click the "Search for Dispute" button on "Dispute Management" page
    And Select "Dispute ID" radio button in "Search for dispute" page
    And Enter "Dispute ID" as "<Dispute_ID>" then click on "Search" button
    Then The value of "Dispute Status" is displayed as "Disputer Party - Returned for Review" under "Search for Dispute" page
    And Close the browser
 ################################################
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
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
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
 ###############################  
    Examples: 
      | Browser_Name| Portal_Name |        user_id          |         password        |         Transaction_ID              |Disputer_Party| Disputed_Party|Dispute_Category  |Dispute_Type     |Dispute_Details  |Dispute_ID |  Portal_Int    |sp_internal_dispute_action_team1 |sp_internal_dispute_action_team_password1|Final_Resolution_Value |Dispute_History |sp_internal_dispute_action_team2 |sp_internal_dispute_action_team_password2 |Rejection_Reason|Disputer_Party_User_Id     |Disputer_Party_Password   |
      |    Chrome   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B00000000000301  |AlBilad Bank  | Saudi Payments|Customer complaint|Wrong information|Dispute Occoured | %RUNTIME% |  Internal      |       SaudiUser1                |       SaudiUser1                        | Resolution test       |Dispute History |          SaudiUser3             |              SaudiUser3                  | Business Change|dev_SAALBI_allAccess_user2 |dev_SAALBI_allAccess_user2|
    # |    Firefox  | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B000000000003010 |AlBilad Bank  | Bank AlJazira |Customer complaint|Wrong information|Dispute Occoured |
###############################################################################################################################################################################################################
@Int_OpenToEscalatedInternalSP
Scenario Outline: Open to Escalated Internal Status Check
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
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
###############################
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Int>" Portal under "%ENV%" environment with username as "<sp_internal_dispute_action_team1>" and password as "<sp_internal_dispute_action_team_password1>"
    Then Navigate to below mentioned menu in order to reach "Search for Dispute" page
      #---------------------------------------------------------------
      # | Menu                 |
      #---------------------------------------------------------------
        | Service Request      |
        | Dispute Management   |
        | Search for Dispute   |
    And The "Search for Dispute" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name                |       Value                   |
	#-----------------------------------------------------------------
	  |Label      |   Search By:               |      %Displayed%              |
      |Label      |   Dispute ID               |      %Displayed%              |
      |Label      |   Transaction ID           |      %Displayed%              |
      |Label      |   Advanced                 |      %Displayed%              |            
      |Button     |   Search                   |      %Enabled%                |
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
	And Select "Send to Counterparty" radio button in "Approve Dispute" page
	And Click the "Submit" button on "Approve Dispute" page
    When Click the "Yes" button on "Action Confirmation" pop up screen in "Approve Dispute" page		
    And Click the "Search for Dispute" button on "Dispute Management" page
    And Select "Dispute ID" radio button in "Search for dispute" page
    And Enter "Dispute ID" as "<Dispute_ID>" then click on "Search" button
    Then The value of "Dispute Status" is displayed as "Disputed Party - Sent to Counter Party" on the "Search for Dispute" page under "Internal" Portal
    And Close the browser
####################################################################################
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
	And Enter below values in "Action Dispute" page
      #-----------------------------------------------------------------
      # | Field                          |          Values             |
      #-----------------------------------------------------------------
        | Dispute History                |     <Dispute_History>       |
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
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
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
	And Select "Send to Counterparty" radio button in "Approve Dispute" page
	And Click the "Submit" button on "Approve Dispute" page
    When Click the "Yes" button on "Action Confirmation" pop up screen in "Approve Dispute" page		
    And Click the "Search for Dispute" button on "Dispute Management" page
    And Select "Dispute ID" radio button in "Search for dispute" page
    And Enter "Dispute ID" as "<Dispute_ID>" then click on "Search" button
    Then The value of "Dispute Status" is displayed as "Disputer Party - Sent to Counter Party" under "Search for Dispute" page
    And Close the browser 
   ###############################
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Int>" Portal under "%ENV%" environment with username as "<sp_internal_dispute_action_team1>" and password as "<sp_internal_dispute_action_team_password1>"
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
#        | Dispute History                |     <Dispute_History>       |
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
	And Select "Escalate" radio button in "SP Approve Dispute" page
	And Click the "Submit" button on "Approve Dispute" page
    When Click the "Yes" button on "Action Confirmation" pop up screen in "Approve Dispute" page		
    And Click the "Search for Dispute" button on "Dispute Management" page
    And Select "Dispute ID" radio button in "Search for dispute" page
    And Enter "Dispute ID" as "<Dispute_ID>" then click on "Search" button
    Then The value of "Dispute Status" is displayed as "Escalated Internal" on the "Search for Dispute" page under "Internal" Portal
    And Close the browser
    Examples: 
      | Browser_Name| Portal_Name |        user_id          |         password        |         Transaction_ID              |Disputer_Party| Disputed_Party|Dispute_Category  |Dispute_Type     |Dispute_Details  |Dispute_ID |  Portal_Int    |sp_internal_dispute_action_team1 |sp_internal_dispute_action_team_password1|Final_Resolution_Value |Dispute_History |sp_internal_dispute_action_team2 |sp_internal_dispute_action_team_password2 |Disputer_Party_User_Id     |Disputer_Party_Password    |Rejection_Reason|
      |    Chrome   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B00000000000301  |AlBilad Bank  | Saudi Payments|Customer complaint|Wrong information|Dispute Occoured | %RUNTIME% |  Internal      |       SaudiUser1                |       SaudiUser1                        | Resolution test       |Dispute History |          SaudiUser3             |              SaudiUser3                  |dev_SAALBI_allAccess_user2 |dev_SAALBI_allAccess_user2 | Business Change|
    # |    Firefox  | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B000000000003010 |AlBilad Bank  | Bank AlJazira |Customer complaint|Wrong information|Dispute Occoured |
###############################
#####################################################################################################################################