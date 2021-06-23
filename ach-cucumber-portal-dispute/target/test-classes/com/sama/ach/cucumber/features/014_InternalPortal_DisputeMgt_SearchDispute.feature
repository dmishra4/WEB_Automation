@Internal_SearchDispute
Feature: InternalPortal_DisputeMgt_SearchDispute
  @Int_SearchUsingDisputeID
  Scenario Outline: Search for Dispute using valid Dispute ID
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
    Then Navigate to below mentioned menu in order to reach "Create Dispute" page
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
#    And The "Search for Dispute" result table contains the following columns:
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
    And Close the browser
    Examples: 
      | Browser_Name| Portal_Name |        user_id          |         password        |         Dispute_ID                  |
      |    Chrome   | Internal    |dev_allAccess_user2      |dev_allAccess_user2      |       1000000000000154              |
    # |    Firefox  | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B000000000003010 |
    #######################################################################################
    #######################################################################################
    
  @Int_SearchUsingTransactionID
  Scenario Outline: Search for Dispute using valid Transaction ID
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
    Then Navigate to below mentioned menu in order to reach "Create Dispute" page
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
    And Select "Transaction ID" radio button in "Search for dispute" page
    And Enter "Transaction_ID" as "<Transaction_ID>" then click on "Search" button
#    And The "Search for Dispute" result table contains the following columns:
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
    And Close the browser
    Examples: 
      | Browser_Name| Portal_Name |        user_id          |         password        |         Transaction_ID              |
      |    Chrome   | Internal    |dev_allAccess_user2      |dev_allAccess_user2      | 20190808000000045C1B000000000003010 |
    # |    Firefox  | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B000000000003010 |
    
    #######################################################################################
    #######################################################################################
    
  @Int_AdvDisputeSearch
  Scenario Outline: Search for Dispute using valid Transaction ID
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
    Then Navigate to below mentioned menu in order to reach "Create Dispute" page
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
    And Select "Advanced" radio button in "Search for dispute" page
    And Enter below values in "Search for Dispute" page 
	#-----------------------------------------------------------------
	# |        Field                |       Values                  |
	#-----------------------------------------------------------------
	  |       From                  |      <From_Date>              |
	  |       To                    |      <To_date>                |
	  |       Disputer Party        |      <Disputer_Party>         |
	  |       Disputed Party        |      <Disputed_Party>         |
	  |       Dispute Status        |      <Dispute Status>         |
	Then Click the "Search" button on "Search for Dispute" page
#    And The "Search for Dispute" result table contains the following columns:
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
    And Close the browser
    Examples: 
      | Browser_Name| Portal_Name |        user_id          |         password        |  From_Date   | To_date  | Disputer_Party| Disputed_Party | Dispute Status |
      |    Chrome   | Internal    |dev_allAccess_user2      |dev_allAccess_user2      |  10/06/2020  |10/06/2020|  AlBilad Bank |  All           |   All          |
    # |    Firefox  | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B000000000003010 |
    