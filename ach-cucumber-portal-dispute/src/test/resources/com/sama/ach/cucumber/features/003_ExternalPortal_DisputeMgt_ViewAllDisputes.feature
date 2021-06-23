@Ext_ViewAllDisputes
Feature: View Dispute under Dispute Management
  @Ext_ViewDisputes
  Scenario Outline: View all Disputes list for any Dispute Status
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
    And The "viewTable" result contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          |   Values      |
	#-----------------------------------------------------------------
	  |   Dispute ID          |  %NOTEMPTY%   |
      |   Disputed Party      |  %NOTEMPTY%   |
      |   Creation Date       |  %NOTEMPTY%   |
      |   Close Date          |  %NOTEMPTY%   |
      |   Dispute Status      |  %NOTEMPTY%   |
    And Close the browser
    Examples: 
      | Browser_Name| Portal_Name |        user_id          |         password        |   Dispute Status |
      |    Chrome   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user|      All         |
#     |    Chrome   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user|   Auto-Closed    |
#     |    Chrome   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user|      Open        |
    # |    Firefox  | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 2019080800000    |
    #######################################################################################
    #######################################################################################
    
 @Ext_ViewAutoClosedDisputes
 Scenario Outline: View all Disputes list having Dispute Status as Auto-Closed
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
    And The "viewTable" result contains the following columns:
	#-----------------------------------------------------------------
	# | Columns Name          |   Values      |
	#-----------------------------------------------------------------
	  |   Dispute ID          |  %NOTEMPTY%   |
      |   Disputed Party      |  %NOTEMPTY%   |
      |   Creation Date       |  %NOTEMPTY%   |
      |   Close Date          |  %NOTEMPTY%   |
      |   Dispute Status      |  %NOTEMPTY%   |
    And Close the browser
    Examples: 
      | Browser_Name| Portal_Name |        user_id          |         password        |   Dispute Status |
      |    Chrome   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user|   Auto-Closed    |
#     |    Chrome   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user|      All         |
#     |    Chrome   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user|      Open        |
    # |    Firefox  | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 2019080800000    |
    #######################################################################################
    #######################################################################################
 
 