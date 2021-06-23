@Ext_CreateDispute
Feature: Create Dispute under Dispute Management
@Ext_CreateDispute_Valid
Scenario Outline: Create Dispute using valid IPS transaction ID
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
    Then Navigate to below mentioned menu in order to reach "Create Dispute" page
      #---------------------------------------------------------------
      # | Menu                 |
      #---------------------------------------------------------------
        | Service Requests     |
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
 #   Then Click the "Close" button on "Confirmation of dispute creation" pop up screen
    And Close the browser
    Examples: 
      | Browser_Name| Portal_Name |        user_id          |         password        |         Transaction_ID              |Disputer_Party| Disputed_Party|Dispute_Category  |Dispute_Type     |Dispute_Details  |
      |    Firefox   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B000000000003010 |AlBilad Bank  | Bank AlJazira |Customer complaint|Wrong information|Dispute Occoured |
    # |    Firefox  | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B000000000003010 |AlBilad Bank  | Bank AlJazira |Customer complaint|Wrong information|Dispute Occoured |
###############################################################################################################################################################################################################
#####################################################################################################################################
@Ext_CreateDispute_NonExistTransID
  Scenario Outline: Create Dispute using IPS transaction ID that does not exist 
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
    Then Navigate to below mentioned menu in order to reach "Create Dispute" page
      #---------------------------------------------------------------
      # | Menu                 |
      #---------------------------------------------------------------
        | Service Request      |
        | Dispute Management   |
        | Create Dispute       |
    And Enter "Transaction ID" as "<Non_Existing_Transaction_ID>" then click on "Submit" button
    Then Below error message will be displayed for "Non existing transaction ID"
    """
    Transaction ID doesn't exist, please enter a valid Transaction ID
      """
    And Close the browser
    Examples: 
      | Browser_Name| Portal_Name |        user_id          |         password        | Non_Existing_Transaction_ID         | 
      |    Firefox   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B000000000003015 | 
#############################################################################################################################
#############################################################################################################################
@Ext_CreateDispute_only35NumericdataTransID
Scenario Outline: Create Dispute using only 35 Numeric Transaction ID
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
    Then Navigate to below mentioned menu in order to reach "Create Dispute" page
      #---------------------------------------------------------------
      # | Menu                 |
      #---------------------------------------------------------------
        | Service Request      |
        | Dispute Management   |
        | Create Dispute       |
    And Enter "Transaction ID" as "<Non_Existing_Transaction_ID>" then click on "Submit" button
    Then Below error message will be displayed for "Non existing transaction ID"
    """
    Transaction ID doesn't exist, please enter a valid Transaction ID
      """
    And Close the browser
    Examples: 
      | Browser_Name| Portal_Name |        user_id          |         password        |   Non_Existing_Transaction_ID       | 
      |    Chrome   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045111000000000003010 | 
#############################################################################################################################
#############################################################################################################################
@Ext_CreateDispute_Cancel_Yes
Scenario Outline: Cancel the Creation of Dispute using valid IPS transaction ID
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
    Then Click the "Cancel" button on "Create Dispute" page
    When Click the "Yes" button on "Action Confirmation" pop up screen in "Create Dispute" page
 #   Then Click the "Close" button on "Confirmation of dispute creation" pop up screen
    And Close the browser
    Examples: 
      | Browser_Name| Portal_Name |        user_id          |         password        |         Transaction_ID              |Disputer_Party| Disputed_Party|Dispute_Category  |Dispute_Type     |Dispute_Details  |
      |    Chrome   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B000000000003010 |AlBilad Bank  | Bank AlJazira |Customer complaint|Wrong information|Dispute Occoured |
    # |    Firefox  | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B000000000003010 |AlBilad Bank  | Bank AlJazira |Customer complaint|Wrong information|Dispute Occoured |
###############################################################################################################################################################################################################
#####################################################################################################################################
@Ext_CreateDispute_Cancel_No
Scenario Outline: User can not Cancel the Creation of Dispute using valid IPS transaction ID
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
    Then Click the "Cancel" button on "Create Dispute" page
    When Click the "No" button on "Action Confirmation" pop up screen in "Create Dispute" page
 #   Then Click the "Close" button on "Confirmation of dispute creation" pop up screen
    And Close the browser
    Examples: 
      | Browser_Name| Portal_Name |        user_id          |         password        |         Transaction_ID              |Disputer_Party| Disputed_Party|Dispute_Category  |Dispute_Type     |Dispute_Details  |
      |    Chrome   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B000000000003010 |AlBilad Bank  | Bank AlJazira |Customer complaint|Wrong information|Dispute Occoured |
    # |    Firefox  | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B000000000003010 |AlBilad Bank  | Bank AlJazira |Customer complaint|Wrong information|Dispute Occoured |
###############################################################################################################################################################################################################
#####################################################################################################################################
@Ext_CreateDispute_only35characteristicsdataTransID
Scenario Outline: Create Dispute using only 35 characters Transaction ID 
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
    Then Navigate to below mentioned menu in order to reach "Create Dispute" page
      #---------------------------------------------------------------
      # | Menu                 |
      #---------------------------------------------------------------
        | Service Request      |
        | Dispute Management   |
        | Create Dispute       |
    And Enter "Transaction ID" as "<Non_Existing_Transaction_ID>" then click on "Submit" button
    Then Below error message will be displayed for "Non existing transaction ID"
    """
    Transaction ID doesn't exist, please enter a valid Transaction ID
      """
    And Close the browser
    Examples: 
      | Browser_Name| Portal_Name |        user_id          |         password        |   Non_Existing_Transaction_ID       | 
      |    Chrome   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| ABCDDCBADFGTCFDPLKHBMNDGMNOPCBAMNAO | 
###############################################################################################
###############################################################################################
@Ext_CreateDispute_BlankTransID
Scenario Outline: Create Dispute without entring IPS transaction ID
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
    Then Navigate to below mentioned menu in order to reach "Create Dispute" page
      #---------------------------------------------------------------
      # | Menu                 |
      #---------------------------------------------------------------
        | Service Request      | 
        | Dispute Management   |
        | Create Dispute       |
    And Enter "Transaction ID" as "<Blank_Transaction_ID>" then click on "Submit" button
    Then Below error message will be displayed for "Blank transaction ID"
    """
    Please complete the Required Fields
      """
    And Close the browser
    Examples: 
      | Browser_Name| Portal_Name |        user_id          |         password        | Blank_Transaction_ID | 
      |    Chrome   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user|                      | 
###############################################################################################
###############################################################################################
@Ext_CreateDispute_TransIDlessthan35Characters
Scenario Outline: Create Dispute with IPS Transaction ID less than 35 Characters
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
    Then Navigate to below mentioned menu in order to reach "Create Dispute" page
      #---------------------------------------------------------------
      # | Menu                 |
      #---------------------------------------------------------------
        | Service Request      |
        | Dispute Management   |
        | Create Dispute       |
    And Enter "Transaction ID" as "<Transaction_ID_less_than_35_Characters>" then click on "Submit" button
    Then Below error message will be displayed for "Transaction ID less than 35 Characters"
    """
    Please enter a valid Transaction ID, Transaction ID must be 35 Characters
      """
    And Close the browser
    Examples: 
       | Browser_Name| Portal_Name |        user_id          |         password        | Transaction_ID_less_than_35_Characters| 
       |    Chrome   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B00                | 
 ##################################################################################
 ##################################################################################
 @Ext_CreateDispute_TransIDmorethan35Characters
 Scenario Outline: Create Dispute with IPS Transaction ID more than 35 Characters
    Given Open browser "<Browser_Name>"
    When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<user_id>" and password as "<password>"
    Then Navigate to below mentioned menu in order to reach "Create Dispute" page
      #---------------------------------------------------------------
      # | Menu                 |
      #---------------------------------------------------------------
        | Service Request      |
        | Dispute Management   |
        | Create Dispute       |
        And Enter below values in "Create Dispute" page
      #-----------------------------------------------------------------
      # | Field                |       Values                            |
      #-----------------------------------------------------------------
        | Transaction ID       | <Transaction_ID_more_than_35_Characters>|
    And Close the browser
    Examples: 
       | Browser_Name| Portal_Name |        user_id          |         password        | Transaction_ID_more_than_35_Characters| 
       |    Chrome   | External    |dev_SAALBI_allAccess_user|dev_SAALBI_allAccess_user| 20190808000000045C1B00000000000301030 |
######################################################################################