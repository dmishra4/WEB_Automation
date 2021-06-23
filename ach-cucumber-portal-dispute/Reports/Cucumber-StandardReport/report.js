$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./src/test/resources/com/sama/ach/cucumber/features/001_ExternalPortal_DisputeMgt_CreateDispute.feature");
formatter.feature({
  "name": "Create Dispute under Dispute Management",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Ext_CreateDispute"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Create Dispute using valid IPS transaction ID",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Ext_CreateDispute_Valid"
    }
  ]
});
formatter.step({
  "name": "Open browser \"\u003cBrowser_Name\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "Login to \"\u003cPortal_Name\u003e\" Portal under \"%ENV%\" environment with username as \"\u003cuser_id\u003e\" and password as \"\u003cpassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "Navigate to below mentioned menu in order to reach \"Create Dispute\" page",
  "keyword": "Then ",
  "rows": [
    {
      "cells": [
        "Service Requests"
      ]
    },
    {
      "cells": [
        "Dispute Management"
      ]
    },
    {
      "cells": [
        "Create Dispute"
      ]
    }
  ]
});
formatter.step({
  "name": "Enter \"Transaction ID\" as \"\u003cTransaction_ID\u003e\" then click on \"Submit\" button",
  "keyword": "And "
});
formatter.step({
  "name": "The \"Create Dispute\" page contains the following GUI items:",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "Label",
        "Transaction Amount:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Transaction Status:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Debtor Participant:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Creditor Participant:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Beneficiary IBAN No:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Requester IBAN No:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Transaction Date \u0026 Time:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Disputer Party:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Disputed Party:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Dispute Category:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Dispute Type:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Dispute Details:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Button",
        "Create Dispute",
        "%Enabled%"
      ]
    },
    {
      "cells": [
        "Button",
        "Cancel",
        "%Enabled%"
      ]
    }
  ]
});
formatter.step({
  "name": "Enter below values in \"Create Dispute\" page",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "Disputer Party",
        "\u003cDisputer_Party\u003e"
      ]
    },
    {
      "cells": [
        "Disputed Party",
        "\u003cDisputed_Party\u003e"
      ]
    },
    {
      "cells": [
        "Dispute Category",
        "\u003cDispute_Category\u003e"
      ]
    },
    {
      "cells": [
        "Dispute Type",
        "\u003cDispute_Type\u003e"
      ]
    },
    {
      "cells": [
        "Dispute Details",
        "\u003cDispute_Details\u003e"
      ]
    }
  ]
});
formatter.step({
  "name": "Click the \"Create Dispute\" button on \"Create Dispute\" page",
  "keyword": "Then "
});
formatter.step({
  "name": "Click the \"Yes\" button on \"Action Confirmation\" pop up screen in \"Create Dispute\" page",
  "keyword": "When "
});
formatter.step({
  "name": "Verify the below mentioned confirmation message on \"Confirmation of dispute creation\" pop up screen",
  "keyword": "Then ",
  "doc_string": {
    "value": "Dispute Case has been created successfully."
  }
});
formatter.step({
  "name": "Click the \"Close\" button on \"Confirmation of dispute creation\" pop up screen in \"Create Dispute\" page",
  "keyword": "When "
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
        "Browser_Name",
        "Portal_Name",
        "user_id",
        "password",
        "Transaction_ID",
        "Disputer_Party",
        "Disputed_Party",
        "Dispute_Category",
        "Dispute_Type",
        "Dispute_Details"
      ]
    },
    {
      "cells": [
        "Firefox",
        "External",
        "dev_SAALBI_allAccess_user",
        "dev_SAALBI_allAccess_user",
        "20190808000000045C1B000000000003010",
        "AlBilad Bank",
        "Bank AlJazira",
        "Customer complaint",
        "Wrong information",
        "Dispute Occoured"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Create Dispute using valid IPS transaction ID",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Ext_CreateDispute"
    },
    {
      "name": "@Ext_CreateDispute_Valid"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Open browser \"Firefox\"",
  "keyword": "Given "
});
formatter.match({
  "location": "DisputeStepDefinitions.open_browser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Login to \"External\" Portal under \"%ENV%\" environment with username as \"dev_SAALBI_allAccess_user\" and password as \"dev_SAALBI_allAccess_user\"",
  "keyword": "When "
});
formatter.match({
  "location": "DisputeStepDefinitions.login_to_Portal_under_environment_with_username_as_and_password_as(String,String,String,String)"
});
formatter.write("Open Browser");
formatter.embedding("image/png", "embedded0.png");
formatter.embedding("image/png", "embedded1.png");
formatter.write("Successfully Login to External Portal in dev Environment");
formatter.embedding("image/png", "embedded2.png");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Navigate to below mentioned menu in order to reach \"Create Dispute\" page",
  "rows": [
    {
      "cells": [
        "Service Requests"
      ]
    },
    {
      "cells": [
        "Dispute Management"
      ]
    },
    {
      "cells": [
        "Create Dispute"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "DisputeStepDefinitions.navigate_to_below_mentioned_menu_in_order_to_reach_page(String,String\u003e)"
});
formatter.embedding("image/png", "embedded3.png");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter \"Transaction ID\" as \"20190808000000045C1B000000000003010\" then click on \"Submit\" button",
  "keyword": "And "
});
formatter.match({
  "location": "DisputeStepDefinitions.enter_as_then_click_on_button(String,String,String)"
});
formatter.embedding("image/png", "embedded4.png");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The \"Create Dispute\" page contains the following GUI items:",
  "rows": [
    {
      "cells": [
        "Label",
        "Transaction Amount:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Transaction Status:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Debtor Participant:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Creditor Participant:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Beneficiary IBAN No:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Requester IBAN No:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Transaction Date \u0026 Time:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Disputer Party:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Disputed Party:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Dispute Category:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Dispute Type:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Dispute Details:",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Button",
        "Create Dispute",
        "%Enabled%"
      ]
    },
    {
      "cells": [
        "Button",
        "Cancel",
        "%Enabled%"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "DisputeStepDefinitions.the_page_contains_the_following_GUI_items(String,String\u003e\u003e)"
});
formatter.embedding("image/png", "embedded5.png");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter below values in \"Create Dispute\" page",
  "rows": [
    {
      "cells": [
        "Disputer Party",
        "AlBilad Bank"
      ]
    },
    {
      "cells": [
        "Disputed Party",
        "Bank AlJazira"
      ]
    },
    {
      "cells": [
        "Dispute Category",
        "Customer complaint"
      ]
    },
    {
      "cells": [
        "Dispute Type",
        "Wrong information"
      ]
    },
    {
      "cells": [
        "Dispute Details",
        "Dispute Occoured"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "DisputeStepDefinitions.enter_below_values_in_page(String,String\u003e\u003e)"
});
formatter.embedding("image/png", "embedded6.png");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click the \"Create Dispute\" button on \"Create Dispute\" page",
  "keyword": "Then "
});
formatter.match({
  "location": "DisputeStepDefinitions.click_the_button_on_page(String,String)"
});
formatter.embedding("image/png", "embedded7.png");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click the \"Yes\" button on \"Action Confirmation\" pop up screen in \"Create Dispute\" page",
  "keyword": "When "
});
formatter.match({
  "location": "DisputeStepDefinitions.click_the_button_on_pop_up_screen_in_page(String,String,String)"
});
formatter.embedding("image/png", "embedded8.png");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify the below mentioned confirmation message on \"Confirmation of dispute creation\" pop up screen",
  "keyword": "Then ",
  "doc_string": {
    "value": "Dispute Case has been created successfully."
  }
});
formatter.match({
  "location": "DisputeStepDefinitions.verify_the_below_mentioned_confirmation_message_on_pop_up_screen(String,String)"
});
formatter.write("Dispute ID 1000000000000501 is created successfully.");
formatter.embedding("image/png", "embedded9.png");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click the \"Close\" button on \"Confirmation of dispute creation\" pop up screen in \"Create Dispute\" page",
  "keyword": "When "
});
formatter.match({
  "location": "DisputeStepDefinitions.click_the_button_on_pop_up_screen_in_page(String,String,String)"
});
formatter.embedding("image/png", "embedded10.png");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "DisputeStepDefinitions.close_the_browser()"
});
formatter.result({
  "status": "passed"
});
});