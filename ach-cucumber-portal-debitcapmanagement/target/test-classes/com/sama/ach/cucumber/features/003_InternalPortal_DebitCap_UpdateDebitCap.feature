@INT_DebitCap
Feature: ExternalPortal_DebitCap_UpdateDebitCap
@INT_DebitCap_Valid 
Scenario Outline: Update Debit Cap with valid values under Debit Cap Management page 
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	And Select "<Participant_Name>" from Participant drop down list
	Then Navigate to below mentioned menu in order to reach "Debit Cap Management" page 
	#---------------------------------------------------------------
	# | Menu                 |
	#---------------------------------------------------------------
	  | Service Request      |
	  | Debit Cap Management |
	And Click the "Change Debit Cap" button on "Debit Cap Management" page 
	And Enter below values in "Debit Cap Management" page 
	#-----------------------------------------------------------------
	# | Field                       |       Values                  |
	#-----------------------------------------------------------------
	  | Updated Debit Cap           | <Updated Debit Cap>           |
	  | Reason for Debit Cap Update | <Reason for Debit Cap Update> |
	Then Click the "Submit" button on "Debit Cap Management" page 
	When Click the "Yes" button on "Debit Cap Management" pop up screen 
	Then Verify the below mentioned confirmation message 
		"""
		Debit Cap Limit: The request is successfully submitted for approvals. The request will be reviewed and actioned.
        """
	And Close the browser 
    Examples: 
      | Portal_Name |      Username             |    Password               | Updated Debit Cap | Reason for Debit Cap Update  |
      | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |      1010         |    Business Requirements     |
    # | External    | dev_SABJAZ_allAccess_user | dev_SABJAZ_allAccess_user |      1020         |    Business Requirements     |
    # | External    | dev_SASABB_allAccess_user | dev_SASABB_allAccess_user |      1030         |    Business Requirements     |
    # | External    | dev_SANCBK_allAccess_user | dev_SANCBK_allAccess_user |      1040         |    Business Requirements     |
@INT_DebitCap_Blank 
Scenario Outline: Update Debit Cap without entring values under Debit Cap Management page 
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Debit Cap Management" page 
	#---------------------------------------------------------------
	# | Menu                 |
	#---------------------------------------------------------------
		| Service Request      |
		| Debit Cap Management |
	And Click the "Change Debit Cap" button on "Debit Cap Management" page 
	And Enter below values in "Debit Cap Management" page 
	#-----------------------------------------------------------------
	# | Field                       |       Values                        |
	#-----------------------------------------------------------------
		| Updated Debit Cap           | <Blank_Updated_Debit_Cap>           |
		| Reason for Debit Cap Update | <Blank_Reason_for_Debit_Cap_Update> |
	Then Click the "Submit" button on "Debit Cap Management" page 
	Then Below error message will be displayed for "Blank Updated Debit Cap and Reason" 
		"""
		Please complete the Required Fields
    """
	And Close the browser 
    Examples: 
      | Portal_Name |      Username             |    Password               | Blank_Updated_Debit_Cap | Blank_Reason_for_Debit_Cap_Update  |
      | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |                         |                                    |
#     | Internal    | dev_allAccess_user2       | dev_allAccess_user2       |      25000500           |    Business Requirements           |
@INT_DebitCap_Invalid 
Scenario Outline: Update Debit Cap with invalid value under Debit Cap Management page 
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Debit Cap Management" page 
	#---------------------------------------------------------------
	# | Menu                 |
	#---------------------------------------------------------------
		| Service Request      |
		| Debit Cap Management |
	And Click the "Change Debit Cap" button on "Debit Cap Management" page 
	And Enter below values in "Debit Cap Management" page 
	#-----------------------------------------------------------------
	# | Field                       |       Values                  |
	#-----------------------------------------------------------------
		| Updated Debit Cap           | <Invalid_Updated_Debit_Cap>   |
		| Reason for Debit Cap Update | <Reason for Debit Cap Update> |
	Then Click the "Submit" button on "Debit Cap Management" page 
	Then Below error message will be displayed for "Invalid Updated Debit Cap" 
		"""
		Invalid value, expected value is zero and positive integer only
       """
	And Close the browser 
    Examples: 
      | Portal_Name |      Username             |    Password               | Invalid_Updated_Debit_Cap | Reason for Debit Cap Update  |
      | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |      1010.45              |    Business Requirements     |
#     | Internal    | dev_allAccess_user2       | dev_allAccess_user2       |      25000500             |    Business Requirements     |
#########################################################################################################################
@INT_DebitCap_Cancel
Scenario Outline: Selection of the Cancel button under Debit Cap Management page
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Debit Cap Management" page 
	#---------------------------------------------------------------
	# | Menu                 |
	#---------------------------------------------------------------
		| Service Request      |
		| Debit Cap Management |
	And Click the "Change Debit Cap" button on "Debit Cap Management" page 
	And Enter below values in "Debit Cap Management" page 
	#-----------------------------------------------------------------
	# | Field                       |       Values                  |
	#-----------------------------------------------------------------
		| Updated Debit Cap           | <Updated_Debit_Cap>   |
		| Reason for Debit Cap Update | <Reason for Debit Cap Update> |
	Then Click the "Cancel" button on "Debit Cap Management" page 
	And Close the browser 
    Examples: 
		| Portal_Name |      Username             |    Password               | Updated_Debit_Cap | Reason for Debit Cap Update  |
		| External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |      1011         |    Business Requirements     |
	#   | Internal    | dev_allAccess_user2       | dev_allAccess_user2       |      25000500             |    Business Requirements     |
#####################################################################################################################
@INT_DebitCap_NoConfirmation 
Scenario Outline: Selection of the No button on confirm Debit Cap Change dialog box
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Debit Cap Management" page 
	#---------------------------------------------------------------
	# | Menu                 |
	#---------------------------------------------------------------
	  | Service Request      |
	  | Debit Cap Management |
	And Click the "Change Debit Cap" button on "Debit Cap Management" page 
	And Enter below values in "Debit Cap Management" page 
	#-----------------------------------------------------------------
	# | Field                       |       Values                  |
	#-----------------------------------------------------------------
	  | Updated Debit Cap           | <Updated Debit Cap>           |
	  | Reason for Debit Cap Update | <Reason for Debit Cap Update> |
	Then Click the "Submit" button on "Debit Cap Management" page 
	When Click the "No" button on "Debit Cap Management" pop up screen 
	And Close the browser 
    Examples: 
      | Portal_Name |      Username             |    Password               | Updated Debit Cap | Reason for Debit Cap Update  |
      | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |      1010         |    Business Requirements     |
#     | Internal    | dev_allAccess_user2       | dev_allAccess_user2       |      25000500     |    Business Requirements     |	
#######################################################################################################################
@INT_DebitCap_View 
Scenario Outline: View existing Debit Cap and Threshold Values under Debit Cap Management page
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Debit Cap Management" page 
	#---------------------------------------------------------------
	# | Menu                 |
	#---------------------------------------------------------------
	  | Service Request      |
	  | Debit Cap Management |
    And The "Debit Cap Management" page contains the following GUI items:
	#-----------------------------------------------------------------
	# | GUI Items |        Name        |       Value                   |
	#-----------------------------------------------------------------
	  |Label      |   Debit Cap in SAR |      %NotNull%                |
      |Label      |   High Threshold   |      %NotNull%                |
      |Label      |   Low Threshold    |      %NotNull%                |
      |Button     |   Change Debit Cap |      %Enabled%                |
      |Button     |   Update Threshold |      %Enabled%                |
	And Close the browser 
    Examples: 
      | Portal_Name |      Username             |    Password               | Updated Debit Cap | Reason for Debit Cap Update  |
      | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |      1010         |    Business Requirements     |
#     | Internal    | dev_allAccess_user2       | dev_allAccess_user2       |      25000500     |    Business Requirements     |		
	
