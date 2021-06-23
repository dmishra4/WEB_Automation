@ThresholdExt
Feature: ExternalPortal_DebitCap_UpdateThreshold
@Threshold_Valid 
Scenario Outline: Update Threshold with valid value under Debit Cap Management page 
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Debit Cap Management" page 
	#---------------------------------------------------------------
	#   | Menu                 |
	#---------------------------------------------------------------
		| Service Request      |
		| Debit Cap Management |
	And Click the "Update Threshold" button on "Debit Cap Management" page 
	Then Click the "<Radio_Button>" radio button on "Debit Cap Management" page 
	And Enter "Valid Threshold Value" as "<Valid_Threshold_Value>" then click on "Submit" button 
	When Click the "Yes" button on "Confirm Threshold Change" pop up screen 
	Then Below "confirmation" message will be displayed for "Update Threshold" 
		"""
		The request is successfully submitted for approvals. The request will be reviewed and actioned.
        """
	And Close the browser 
    Examples: 
      | Portal_Name |      Username             |    Password               |   Radio_Button    |  Valid_Threshold_Value|
      | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |      High         |         85            |
    # | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |      Low          |         90            |
    # | External    | dev_SABJAZ_allAccess_user | dev_SABJAZ_allAccess_user |      1020         |    Business Requirements     |
    # | External    | dev_SASABB_allAccess_user | dev_SASABB_allAccess_user |      1030         |    Business Requirements     |
    # | External    | dev_SANCBK_allAccess_user | dev_SANCBK_allAccess_user |      1040         |    Business Requirements     |
@Threshold_Blank 
Scenario Outline: Update Threshold without entring Threshold Value under Debit Cap Management page 
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Debit Cap Management" page 
	#---------------------------------------------------------------
	# | Menu                 |
	#---------------------------------------------------------------
		| Service Request      |
		| Debit Cap Management |
	And Click the "Update Threshold" button on "Debit Cap Management" page
	Then Click the "<Radio_Button>" radio button on "Debit Cap Management" page 
	And Enter "Threshold Value" as "<Blank_Threshold_Value>" then click on "Submit" button 
	Then Below error message will be displayed for "Blank Threshold Value" 
		"""
		Please complete the Required Fields
    """
	And Close the browser 
    Examples: 
      | Portal_Name |      Username             |    Password               | Radio_Button|Blank_Threshold_Value   | 
      | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |    Yes      |                        |                                   
#     | Internal    | dev_allAccess_user2       | dev_allAccess_user2       |   25000500  |  
@Threshold_Invalid 
Scenario Outline: Update Threshold with invalid Threshold value under Debit Cap Management page 
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Debit Cap Management" page 
	#---------------------------------------------------------------
	# | Menu                 |
	#---------------------------------------------------------------
		| Service Request      |
		| Debit Cap Management |
	And Click the "Change Debit Cap" button on "Debit Cap Management" page 
	And Click the "Update Threshold" button on "Debit Cap Management" page
	Then Click the "<Radio_Button>" radio button on "Debit Cap Management" page 
	And Enter "Threshold Value" as "<Invalid_Threshold_Value>" then click on "Submit" button 
	Then Below error message will be displayed for "Invalid Threshold Value" 
		"""
		Invalid value, expected value is zero and positive integer only
       """
	And Close the browser 
    Examples: 
      | Portal_Name |      Username             |    Password               | Radio_Button |Invalid_Threshold_Value |
      | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |   High       |     ABC                |   
#     | Internal    | dev_allAccess_user2       | dev_allAccess_user2       |      25000500             |   
#########################################################################################################################
@Threshold_Cancel
Scenario Outline: Selection of the Cancel button on Update Threshold screen
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Debit Cap Management" page 
	#---------------------------------------------------------------
	# | Menu                 |
	#---------------------------------------------------------------
	  | Service Request      |
	  | Debit Cap Management |
	And Click the "Update Threshold" button on "Debit Cap Management" page
	Then Click the "<Radio_Button>" radio button on "Debit Cap Management" page  
	And Enter below values in "Debit Cap Management" page 
	#-----------------------------------------------------------------
	# | Field                       |       Values                  |
	#-----------------------------------------------------------------
	  | Threshold Value             | <Threshold_Value>             |
	Then Click the "Cancel" button on "Request to change Debit Cap & Threshold" page 
	And Close the browser 
    Examples: 
		| Portal_Name |      Username             |    Password               | Radio_Button |Threshold_Value | 
		| External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | High         |    85          |    

#####################################################################################################################
@Threshold_NoConfirmation 
Scenario Outline: Selection of the No button on confirm Threshold Change Change dialog box
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Debit Cap Management" page 
	#---------------------------------------------------------------
	# | Menu                 |
	#---------------------------------------------------------------
	  | Service Request      |
	  | Debit Cap Management |
	And Click the "Update Threshold" button on "Debit Cap Management" page
	Then Click the "<Radio_Button>" radio button on "Debit Cap Management" page 
	And Enter "Valid Threshold Value" as "<Valid_Threshold_Value>" then click on "Submit" button
	When Click the "No" button on "Confirm Threshold Change" pop up screen 
	And Close the browser 
    Examples: 
      | Portal_Name |      Username             |    Password               | Radio_Button      |    Valid_Threshold_Value           |            
      | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |      High         |    85                        |
#     | Internal    | dev_allAccess_user2       | dev_allAccess_user2       |      25000500     |    Business Requirements     |	
#######################################################################################################################
@Threshold_View 
Scenario Outline: View existing Threshold Labels and Values under Debit Cap Management page
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Debit Cap Management" page 
	#---------------------------------------------------------------
	# | Menu                 |
	#---------------------------------------------------------------
	  | Service Request      |
	  | Debit Cap Management |
    And Click the "Update Threshold" button on "Debit Cap Management" page
    And The "Debit Cap Management" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name        |       Value                   |
	#-----------------------------------------------------------------
	  |Label      |   Debit Cap in SAR |      %NotNull%                |
      |Label      |   High Threshold   |      %NotNull%                |
      |Label      |   Low Threshold    |      %NotNull%                |
      |Button     |   Change Debit Cap |      %Enabled%                |
      |Button     |   Update Threshold |      %Enabled%                |
      |Label      |   Threshold Value  |      %Displayed%              |
	And Close the browser 
    Examples: 
      | Portal_Name |      Username             |    Password               | Updated Debit Cap | Reason for Debit Cap Update  |
      | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |      1010         |    Business Requirements     |
#     | Internal    | dev_allAccess_user2       | dev_allAccess_user2       |      25000500     |    Business Requirements     |		
	
