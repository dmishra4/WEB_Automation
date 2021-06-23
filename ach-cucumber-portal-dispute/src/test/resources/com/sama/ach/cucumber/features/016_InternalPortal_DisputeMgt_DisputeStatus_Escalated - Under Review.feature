@InternalPortal_DisputeStatus
Feature: 016_InternalPortal_DisputeMgt_DisputeStatus_Escalated - Under Review
 @016_Int_EscalatedUnderReview
 Scenario Outline: InternalPortal_Escalated - Under Review Status Check
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<sp.internal.dispute_action_team_user_id>" and password as "<sp.internal.dispute_action_team_password>"
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
      | Browser_Name| Portal_Name | sp.internal.dispute_action_team_user_id | sp.internal.dispute_action_team_password  |   Dispute Status | Dispute_History      |Dispute_ID |
      |    Chrome   | Internal    |      SaudiUser1                         |                  SaudiUser1               |   Escalated      | Dispute History Test |%RUNTIME%  |

  ###################################################  END  #########################################
