@InternalPortal_DisputeStatus
Feature: 018_InternalPortal_DisputeMgt_DisputeStatus_Escalated - Returned for Review
@018_Int_EscalatedReturnedforReview
Scenario Outline: InternalPortal_Escalated Returned for Review Status Check
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
      |    Chrome   | Internal    |      SaudiUser1                  |              SaudiUser1                   |   Escalated      | Dispute History |Final Resolution Value |%RUNTIME%  |         SaudiUser3              |          SaudiUser3                     |   Rejected     |

#################################################  END   ###########################################################
############################################################################################################