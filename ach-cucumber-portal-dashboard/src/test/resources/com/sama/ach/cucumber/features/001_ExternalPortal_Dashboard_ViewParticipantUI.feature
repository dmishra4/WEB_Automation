Feature: ExternalPortal_Dashboard_ViewParticipantUI
@Dashboard_PaymentPositions 
Scenario Outline: View the Payments Position section under Dashboard screen
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Dashboard" page 
	#---------------------------------------------------------------
	# | Menu                 |
	#---------------------------------------------------------------
	  | Dashboard            |
    And The "Payments Position" section under "Dashboard" page contains the following GUI items:
	#-------------------------------------------------------------------------------------------
	# | GUI Items |        Name          |       Count                   |     Amount        |
	#-------------------------------------------------------------------------------------------
	  |   Label   |   Debits Processed   |      %NotEmpty%                |   %NotEmpty%       |
      |   Label   |   Credits Processed  |      %NotEmpty%                |   %NotEmpty%       |
      |   Label   |   Debits Failed      |      %NotEmpty%                |   %NotEmpty%       |
	And Close the browser 
    Examples: 
      | Portal_Name |      Username             |    Password               | 
      | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |    
################################################################################################
################################################################################################
@Dashboard_UnavailableBanks 
Scenario Outline: View the Banks Unavailable section under Dashboard screen
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Dashboard" page 
	#---------------------------------------------------------------
	# | Menu                 |
	#---------------------------------------------------------------
	  | Dashboard            |
    And View the list of unavailable banks in Banks unavailable section under dashboard
	And Close the browser 
    Examples: 
      | Portal_Name |      Username             |    Password               | 
      | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |    
#     | Internal    | dev_allAccess_user2       | dev_allAccess_user2       | 

##################################################################################################
##################################################################################################
@Dashboard_Disputes
Scenario Outline: View the Disputes section under Dashboard screen
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Dashboard" page 
	#---------------------------------------------------------------
	# | Menu                 |
	#---------------------------------------------------------------
	  | Dashboard            |
    And The "Disputes" section under "Dashboard" page contains the following GUI items:
	#-------------------------------------------------------------------------------------------
	# | GUI Items |        Name                       |       Value                   |            
	#-------------------------------------------------------------------------------------------
	  |   Label   |   Open Disputes                   |      %NotEmpty%                |  
      |   Label   |   Disputes in Progress            |      %NotEmpty%                |   
      |   Label   |   Disputes closed in last 30 days |      %NotEmpty%                |  
	And Close the browser 
    Examples: 
      | Portal_Name |      Username             |    Password               | 
      | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |    
#     | Internal    | dev_allAccess_user2       | dev_allAccess_user2       |
##################################################################################################
################################################################################################## 	
@Dashboard_DebitCapThreshold 
Scenario Outline: View the Debit Cap and Threshold under Dashboard screen
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Dashboard" page 
	#---------------------------------------------------------------
	# | Menu                 |
	#---------------------------------------------------------------
	  | Dashboard            |
    And The "Debit Cap" section under "Dashboard" page contains the following GUI items:
	#-------------------------------------------------------------------------------------------
	# | GUI Items |        Name          |        Value                     |   
	#-------------------------------------------------------------------------------------------
	  |   Label   |   Debit Cap          |       %NotEmpty%                 |  
      |   Label   |   Low Threshold      |       %NotEmpty%                 |   
      |   Label   |   High Threshold     |       %NotEmpty%                 |   
	And Close the browser 
    Examples: 
      | Portal_Name |      Username             |    Password               | 
      | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |    

##################################################################################################
##################################################################################################
@Dashboard_NetPosition 
Scenario Outline: View the Net Position and Debit Cap Utilized under Dashboard screen
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Dashboard" page 
	#---------------------------------------------------------------
	# | Menu                 |
	#---------------------------------------------------------------
	  | Dashboard            |
    And The "Net Position" section under "Dashboard" page contains the following GUI items:
	#-------------------------------------------------------------------------------------------
	# | GUI Items |        Name          |        Value                    |   
	#-------------------------------------------------------------------------------------------
	  |   Label   |   Net Position       |       %NotEmpty%                 |  
      |   Label   |   Debit Cap Utilized |       %NotEmpty%                 |    
	And Close the browser 
    Examples: 
      | Portal_Name |      Username             |    Password               | 
      | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |    
#     | Internal    | dev_allAccess_user2       | dev_allAccess_user2       | 	
##################################################################################################
##################################################################################################
@Dashboard_PendingRequest 
Scenario Outline: View the Pending Request details under Dashboard screen
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Dashboard" page 
	#---------------------------------------------------------------
	# | Menu                 |
	#---------------------------------------------------------------
	  | Dashboard            |
    And The "Pending Request" section under "Dashboard" page contains the following GUI items:
	#-------------------------------------------------------------------------------------------
	# | GUI Items |        Name          |        Count                    |   
	#-------------------------------------------------------------------------------------------
	  |   Label   |   Debit Cap Change   |       %NotEmpty%                 |     
	And Close the browser 
    Examples: 
      | Portal_Name |      Username             |    Password               | 
      | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |    
###################################################################################################
###################################################################################################
@Dashboard_BroadCastMsg 
Scenario Outline: View the Broadcast Message for Participant SNMs
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "Dashboard" page 
	#---------------------------------------------------------------
	# | Menu                 |
	#---------------------------------------------------------------
	  | Dashboard      |
    And The "Broadcast" marquee under "Dashboard" page contains the following scrolling texts:
	#-------------------------------------------------------------------------------------------
	# | GUI Items|        Name                                            |       Details      | 
	#-------------------------------------------------------------------------------------------
	  |   Label  |   System Status                                        |      %NotEmpty%    |   
      |   Label  |   Security Transaction Limit (STL) Change              |      %NotEmpty%    |  
      |   Label  |   Settlement Individual Transaction Limit (SITL) Change|      %NotEmpty%    |   
      |   Label  |   Participant Status                                   |      %NotEmpty%    |  
      |   Label  |   Connectivity Status                                  |      %NotEmpty%    |   
      |   Label  |   Participant Suspend Status                           |      %NotEmpty%    |  	

	And Close the browser 
    Examples: 
      | Portal_Name |      Username             |    Password               | 
      | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user | 		
	