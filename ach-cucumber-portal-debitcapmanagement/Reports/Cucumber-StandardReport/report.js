$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./src/test/resources/com/sama/ach/cucumber/features/003_InternalPortal_DebitCap_UpdateDebitCap.feature");
formatter.feature({
  "name": "ExternalPortal_DebitCap_UpdateDebitCap",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@INT_DebitCap"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Update Debit Cap with valid values under Debit Cap Management page",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@INT_DebitCap_Valid"
    }
  ]
});
formatter.step({
  "name": "Open browser \"Chrome\"",
  "keyword": "Given "
});
formatter.step({
  "name": "Login to \"\u003cPortal_Name\u003e\" Portal under \"%ENV%\" environment with username as \"\u003cUsername\u003e\" and password as \"\u003cPassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "Select \"\u003cParticipant_Name\u003e\" from Participant drop down list",
  "keyword": "And "
});
formatter.step({
  "name": "Navigate to below mentioned menu in order to reach \"Debit Cap Management\" page",
  "keyword": "Then ",
  "rows": [
    {
      "cells": [
        "Service Request"
      ]
    },
    {
      "cells": [
        "Debit Cap Management"
      ]
    }
  ]
});
formatter.step({
  "name": "Click the \"Change Debit Cap\" button on \"Debit Cap Management\" page",
  "keyword": "And "
});
formatter.step({
  "name": "Enter below values in \"Debit Cap Management\" page",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "Updated Debit Cap",
        "\u003cUpdated Debit Cap\u003e"
      ]
    },
    {
      "cells": [
        "Reason for Debit Cap Update",
        "\u003cReason for Debit Cap Update\u003e"
      ]
    }
  ]
});
formatter.step({
  "name": "Click the \"Submit\" button on \"Debit Cap Management\" page",
  "keyword": "Then "
});
formatter.step({
  "name": "Click the \"Yes\" button on \"Debit Cap Management\" pop up screen",
  "keyword": "When "
});
formatter.step({
  "name": "Verify the below mentioned confirmation message",
  "keyword": "Then ",
  "doc_string": {
    "value": "Debit Cap Limit: The request is successfully submitted for approvals. The request will be reviewed and actioned."
  }
});
formatter.step({
  "name": "Close the browser",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Portal_Name",
        "Username",
        "Password",
        "Updated Debit Cap",
        "Reason for Debit Cap Update"
      ]
    },
    {
      "cells": [
        "External",
        "dev_SAALBI_allAccess_user",
        "dev_SAALBI_allAccess_user",
        "1010",
        "Business Requirements"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Update Debit Cap with valid values under Debit Cap Management page",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@INT_DebitCap"
    },
    {
      "name": "@INT_DebitCap_Valid"
    }
  ]
});
formatter.before({
  "status": "skipped"
});
formatter.step({
  "name": "Open browser \"Chrome\"",
  "keyword": "Given "
});
formatter.match({
  "location": "DebitCapMgtStepDefinitions.open_browser(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Login to \"External\" Portal under \"%ENV%\" environment with username as \"dev_SAALBI_allAccess_user\" and password as \"dev_SAALBI_allAccess_user\"",
  "keyword": "When "
});
formatter.match({
  "location": "DebitCapMgtStepDefinitions.login_to_Portal_under_environment_with_username_as_and_password_as(String,String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Select \"\u003cParticipant_Name\u003e\" from Participant drop down list",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Navigate to below mentioned menu in order to reach \"Debit Cap Management\" page",
  "rows": [
    {
      "cells": [
        "Service Request"
      ]
    },
    {
      "cells": [
        "Debit Cap Management"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "DebitCapMgtStepDefinitions.navigate_to_below_mentioned_menu_in_order_to_reach_page(String,String\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Click the \"Change Debit Cap\" button on \"Debit Cap Management\" page",
  "keyword": "And "
});
formatter.match({
  "location": "DebitCapMgtStepDefinitions.click_the_button_on_page(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Enter below values in \"Debit Cap Management\" page",
  "rows": [
    {
      "cells": [
        "Updated Debit Cap",
        "1010"
      ]
    },
    {
      "cells": [
        "Reason for Debit Cap Update",
        "Business Requirements"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "DebitCapMgtStepDefinitions.enter_below_values_in_page(String,String\u003e\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Click the \"Submit\" button on \"Debit Cap Management\" page",
  "keyword": "Then "
});
formatter.match({
  "location": "DebitCapMgtStepDefinitions.click_the_button_on_page(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Click the \"Yes\" button on \"Debit Cap Management\" pop up screen",
  "keyword": "When "
});
formatter.match({
  "location": "DebitCapMgtStepDefinitions.click_the_button_on_pop_up_screen(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Verify the below mentioned confirmation message",
  "keyword": "Then ",
  "doc_string": {
    "value": "Debit Cap Limit: The request is successfully submitted for approvals. The request will be reviewed and actioned."
  }
});
formatter.match({
  "location": "DebitCapMgtStepDefinitions.verify_the_below_mentioned_confirmation_message(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "DebitCapMgtStepDefinitions.close_the_browser()"
});
formatter.result({
  "status": "skipped"
});
});