$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./src/test/resources/com/sama/ach/cucumber/features/001_ExternalPortal_Enquiry_ResultsOutcome.feature");
formatter.feature({
  "name": "ExternalPortal_Enquiry_ResultsOutcome",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@ExternalEnquiry_ResultsOutcome"
    }
  ]
});
formatter.scenarioOutline({
  "name": "User can inquire the Value Transaction Enquiry and view the result on screen by History",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Ext_ValueTransactionEnquiryByHistory"
    }
  ]
});
formatter.step({
  "name": "Open browser \"\u003cBrowser_Name\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "Login to \"\u003cPortal_Name\u003e\" Portal under \"%ENV%\" environment with username as \"\u003cUsername\u003e\" and password as \"\u003cPassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "Navigate to below mentioned menu in order to reach \"Value Transaction Enquiry\" page",
  "keyword": "Then ",
  "rows": [
    {
      "cells": [
        "Reports \u0026 Enquiry"
      ]
    },
    {
      "cells": [
        "Enquiries"
      ]
    },
    {
      "cells": [
        "Value Transaction Enquiry"
      ]
    }
  ]
});
formatter.step({
  "name": "Select \"Advance\" radio button",
  "keyword": "And "
});
formatter.step({
  "name": "Select \"Historic\" radio button",
  "keyword": "And "
});
formatter.step({
  "name": "The \"Value Transaction Enquiry\" page contains the following GUI items:",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "Label",
        "Date Start",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Date End",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Routing Number (Bank ID)",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Local Instrument",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Transaction Amount",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Transaction Status",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Reason Code",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Button",
        "Submit",
        "%Enabled%"
      ]
    },
    {
      "cells": [
        "Button",
        "Clear Screen",
        "%Enabled%"
      ]
    }
  ]
});
formatter.step({
  "name": "Enter below values in \"Value Transaction Enquiry\" page",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "Date Start",
        "\u003cDate_Start\u003e"
      ]
    },
    {
      "cells": [
        "Date End",
        "\u003cDate_End\u003e"
      ]
    },
    {
      "cells": [
        "Routing Number (Bank ID)",
        "\u003cRouting_Number\u003e"
      ]
    },
    {
      "cells": [
        "Local Instrument",
        "\u003cLocal_Instrument\u003e"
      ]
    },
    {
      "cells": [
        "Transaction Amount",
        "\u003cTransaction_Amount\u003e"
      ]
    },
    {
      "cells": [
        "Transaction Status",
        "\u003cTransaction_Status\u003e"
      ]
    },
    {
      "cells": [
        "Reason Code",
        "\u003cReason_Code\u003e"
      ]
    }
  ]
});
formatter.step({
  "name": "Click the \"Submit\" button on \"Value Transaction Enquiry\" page",
  "keyword": "And "
});
formatter.step({
  "name": "The \"Value Transaction Enquiry\" result table contains the following columns:",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "Transaction ID",
        "%NOTEMPTY%"
      ]
    },
    {
      "cells": [
        "Transaction Date/Time",
        "%NOTEMPTY%"
      ]
    },
    {
      "cells": [
        "Sending R/T (Bank ID)",
        "%NOTEMPTY%"
      ]
    },
    {
      "cells": [
        "Status",
        "%NOTEMPTY%"
      ]
    },
    {
      "cells": [
        "Local Instrument",
        "%NOTEMPTY%"
      ]
    },
    {
      "cells": [
        "Category Purpose Code",
        "%NOTEMPTY%"
      ]
    }
  ]
});
formatter.step({
  "name": "Click the \"Details\" button on \"Value Transaction Enquiry\" page",
  "keyword": "And "
});
formatter.step({
  "name": "The \"Transaction Details\" page contains the following GUI items:",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "Label",
        "Transaction ID :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Transaction Date/Time :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Sending Participant :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Sending Account :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Sending R/T (Bank ID) :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Receiving Participant :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Receiving Account :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Receiving R/T (Bank ID) :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Status :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Local Instrument :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Category Purpose Code :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Reason Code :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Amount :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Settlement Cycle ID :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Settlement Date :",
        "%Displayed%"
      ]
    }
  ]
});
formatter.step({
  "name": "Click the \"Close\" button on \"Transaction Details\" page",
  "keyword": "And "
});
formatter.step({
  "name": "Click the \"Export to CSV\" button on \"Value Transaction Enquiry\" page",
  "keyword": "Then "
});
formatter.step({
  "name": "Columns name in the downloaded CSV file is same as \"Value Transaction Enquiry\" enquiry result screen",
  "keyword": "And "
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
        "Username",
        "Password",
        "Date_Start",
        "Date_End",
        "Settlement_Cycle_ID",
        "Routing_Number",
        "Local_Instrument",
        "Transaction_Amount",
        "Transaction_Status",
        "Reason_Code",
        "Category_Purpose_Code"
      ]
    },
    {
      "cells": [
        "Firefox",
        "External",
        "dev_SAALBI_allAccess_user",
        "dev_SAALBI_allAccess_user",
        "%PreviousDate%",
        "25/07/2020",
        "001",
        "000000045",
        "Credit Transfer",
        "5000",
        "Accept",
        "0000",
        "Bonus Payment"
      ]
    }
  ]
});
formatter.scenario({
  "name": "User can inquire the Value Transaction Enquiry and view the result on screen by History",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@ExternalEnquiry_ResultsOutcome"
    },
    {
      "name": "@Ext_ValueTransactionEnquiryByHistory"
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
  "location": "EnquiryStepDefinitions.open_browser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Login to \"External\" Portal under \"%ENV%\" environment with username as \"dev_SAALBI_allAccess_user\" and password as \"dev_SAALBI_allAccess_user\"",
  "keyword": "When "
});
formatter.match({
  "location": "EnquiryStepDefinitions.login_to_Portal_under_environment_with_username_as_and_password_as(String,String,String,String)"
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
  "name": "Navigate to below mentioned menu in order to reach \"Value Transaction Enquiry\" page",
  "rows": [
    {
      "cells": [
        "Reports \u0026 Enquiry"
      ]
    },
    {
      "cells": [
        "Enquiries"
      ]
    },
    {
      "cells": [
        "Value Transaction Enquiry"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "EnquiryStepDefinitions.navigate_to_below_mentioned_menu_in_order_to_reach_page(String,String\u003e)"
});
formatter.embedding("image/png", "embedded3.png");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Select \"Advance\" radio button",
  "keyword": "And "
});
formatter.match({
  "location": "EnquiryStepDefinitions.select_radio_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Select \"Historic\" radio button",
  "keyword": "And "
});
formatter.match({
  "location": "EnquiryStepDefinitions.select_radio_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The \"Value Transaction Enquiry\" page contains the following GUI items:",
  "rows": [
    {
      "cells": [
        "Label",
        "Date Start",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Date End",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Routing Number (Bank ID)",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Local Instrument",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Transaction Amount",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Transaction Status",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Reason Code",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Button",
        "Submit",
        "%Enabled%"
      ]
    },
    {
      "cells": [
        "Button",
        "Clear Screen",
        "%Enabled%"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "EnquiryStepDefinitions.the_page_contains_the_following_GUI_items(String,String\u003e\u003e)"
});
formatter.embedding("image/png", "embedded4.png");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter below values in \"Value Transaction Enquiry\" page",
  "rows": [
    {
      "cells": [
        "Date Start",
        "%PreviousDate%"
      ]
    },
    {
      "cells": [
        "Date End",
        "25/07/2020"
      ]
    },
    {
      "cells": [
        "Routing Number (Bank ID)",
        "000000045"
      ]
    },
    {
      "cells": [
        "Local Instrument",
        "Credit Transfer"
      ]
    },
    {
      "cells": [
        "Transaction Amount",
        "5000"
      ]
    },
    {
      "cells": [
        "Transaction Status",
        "Accept"
      ]
    },
    {
      "cells": [
        "Reason Code",
        "0000"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "EnquiryStepDefinitions.enter_below_values_in_page(String,String\u003e\u003e)"
});
formatter.embedding("image/png", "embedded5.png");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click the \"Submit\" button on \"Value Transaction Enquiry\" page",
  "keyword": "And "
});
formatter.match({
  "location": "EnquiryStepDefinitions.click_the_button_on_page(String,String)"
});
formatter.embedding("image/png", "embedded6.png");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The \"Value Transaction Enquiry\" result table contains the following columns:",
  "rows": [
    {
      "cells": [
        "Transaction ID",
        "%NOTEMPTY%"
      ]
    },
    {
      "cells": [
        "Transaction Date/Time",
        "%NOTEMPTY%"
      ]
    },
    {
      "cells": [
        "Sending R/T (Bank ID)",
        "%NOTEMPTY%"
      ]
    },
    {
      "cells": [
        "Status",
        "%NOTEMPTY%"
      ]
    },
    {
      "cells": [
        "Local Instrument",
        "%NOTEMPTY%"
      ]
    },
    {
      "cells": [
        "Category Purpose Code",
        "%NOTEMPTY%"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "EnquiryStepDefinitions.the_result_table_contains_the_following_columns(String,String\u003e\u003e)"
});
formatter.embedding("image/png", "embedded7.png");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click the \"Details\" button on \"Value Transaction Enquiry\" page",
  "keyword": "And "
});
formatter.match({
  "location": "EnquiryStepDefinitions.click_the_button_on_page(String,String)"
});
formatter.embedding("image/png", "embedded8.png");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The \"Transaction Details\" page contains the following GUI items:",
  "rows": [
    {
      "cells": [
        "Label",
        "Transaction ID :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Transaction Date/Time :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Sending Participant :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Sending Account :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Sending R/T (Bank ID) :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Receiving Participant :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Receiving Account :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Receiving R/T (Bank ID) :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Status :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Local Instrument :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Category Purpose Code :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Reason Code :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Amount :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Settlement Cycle ID :",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Settlement Date :",
        "%Displayed%"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "EnquiryStepDefinitions.the_page_contains_the_following_GUI_items(String,String\u003e\u003e)"
});
formatter.embedding("image/png", "embedded9.png");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click the \"Close\" button on \"Transaction Details\" page",
  "keyword": "And "
});
formatter.match({
  "location": "EnquiryStepDefinitions.click_the_button_on_page(String,String)"
});
formatter.embedding("image/png", "embedded10.png");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click the \"Export to CSV\" button on \"Value Transaction Enquiry\" page",
  "keyword": "Then "
});
formatter.match({
  "location": "EnquiryStepDefinitions.click_the_button_on_page(String,String)"
});
formatter.embedding("image/png", "embedded11.png");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Columns name in the downloaded CSV file is same as \"Value Transaction Enquiry\" enquiry result screen",
  "keyword": "And "
});
formatter.match({
  "location": "EnquiryStepDefinitions.columns_name_in_the_downloaded_CSV_file_is_same_as_enquiry_result_screen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "EnquiryStepDefinitions.close_the_browser()"
});
formatter.result({
  "status": "passed"
});
});