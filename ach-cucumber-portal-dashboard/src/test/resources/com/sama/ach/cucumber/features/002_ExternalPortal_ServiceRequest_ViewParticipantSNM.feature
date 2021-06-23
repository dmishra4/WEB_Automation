Feature: ExternalPortal_ServiceRequest_ViewParticipantSNM
@ParticipantSNMs_BroadCastMsg 
Scenario Outline: View the Broadcast Message for Participant SNMs
	Given Open browser "Chrome" 
	When Login to "<Portal_Name>" Portal under "%ENV%" environment with username as "<Username>" and password as "<Password>" 
	Then Navigate to below mentioned menu in order to reach "View Participant SNM" page 
	#---------------------------------------------------------------
	# | Menu                 |
	#---------------------------------------------------------------
	  | Service Requests     |
	  | View Participant SNM |
    And The "Broadcast Message" section under "View Participant SNM" page contains the following GUI items:
	#-------------------------------------------------------------------------------------------
	# | GUI Items|        Name                                            |       Details                   |     Time Stamp     |
	#-------------------------------------------------------------------------------------------
	  |   Label  |   System Status                                        |      %NotEmpty%                 |   %DateTime%       |
      |   Label  |   Security Transaction Limit (STL) Change              |      %NotEmpty%                 |   %DateTime%       |
      |   Label  |   Settlement Individual Transaction Limit (SITL) Change|      %NotEmpty%                 |   %DateTime%       |
      |   Label  |   Participant Status                                   |      %NotEmpty%                 |   %DateTime%       |
      |   Label  |   Connectivity Status                                  |      %NotEmpty%                 |   %DateTime%       |
      |   Label  |   Participant Suspend Status                           |      %NotEmpty%                 |   %DateTime%       |	

	And Close the browser 
    Examples: 
      | Portal_Name |      Username             |    Password               | 
      | External    | dev_SAALBI_allAccess_user | dev_SAALBI_allAccess_user |    