Feature: 004_ExternalPortal_DisputeMgt_DisputeStatus_Disputed Party - Under Review 
@04_Ext_DS_DisputedPartyUnderReview
  Scenario Outline: Disputed Party - Under Review status check
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
    Then Click the "Close" button on "Confirmation of dispute creation" pop up screen in "Create Dispute" page
    And Close the browser
#########################################
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Disputed_Party_User_Id1>" and password as "<Disputed_Party_Password1>"
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
    And Click the "Save As Draft" button on "Action Dispute" page
    When Click the "Yes" button on "Action Confirmation" pop up screen in "Action Dispute" page		
    And Click the "Search for Dispute" button on "Dispute Management" page
    And Select "Dispute ID" radio button in "Search for dispute" page
    And Enter "Dispute ID" as "<Dispute_ID>" then click on "Search" button
    Then The value of "Dispute Status" is displayed as "Disputed Party - Under Review" under "Search for Dispute" page
    And Close the browser
   Examples: 
      | Browser_Name| Portal_Name |        user_id          |         password        |         Transaction_ID              |Disputer_Party| Disputed_Party|Dispute_Category  |Dispute_Type     |Dispute_Details  |Disputed_Party_User_Id1  |Disputed_Party_Password1 |Dispute_ID|       Dispute_History             |         
      |    Chrome   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B000000000003010 |AlBilad Bank  | Bank AlJazira |Customer complaint|Wrong information|Dispute Occoured |dev_SABJAZ_allAccess_user|dev_SABJAZ_allAccess_user|%RUNTIME% | Initial Dispute Resolution result | 
 ###############################################################################
 ###############################################################################