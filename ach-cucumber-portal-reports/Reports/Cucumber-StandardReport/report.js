$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./src/test/resources/com/sama/ach/cucumber/features/002_ExternalPortal_Reports_RequestReport.feature");
formatter.feature({
  "name": "02_ExternalPortal_Reports_RequestReport",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "User views the Participant Settlement Report in CSV format and the output field names are as per specification",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@02_05_Ext_RequestaReport_ParticipantSettlementReport"
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
  "name": "Navigate to below mentioned menu in order to reach \"Request a Report\" page",
  "keyword": "Then ",
  "rows": [
    {
      "cells": [
        "Reports \u0026 Enquiry"
      ]
    },
    {
      "cells": [
        "Request a Report"
      ]
    }
  ]
});
formatter.step({
  "name": "Select \"\u003cRequest_a_Report\u003e\" from \"Request a Report\" dropdown list in \"Request a Report\" page",
  "keyword": "And "
});
formatter.step({
  "name": "Click the \"Select\" button on \"Request a Report\" page",
  "keyword": "And "
});
formatter.step({
  "name": "The \"Participant Settlement Report\" page contains the following GUI items:",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "Label",
        "Participant ID",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Settlement Date",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Settlement Cycle ID",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Currency ISO Code",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Content Format",
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
  "name": "Enter below values in \"Participant Settlement Report\" page",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "Settlement Date",
        "\u003cSettlement_Date\u003e"
      ]
    },
    {
      "cells": [
        "Settlement Cycle ID",
        "\u003cSettlement_Cycle_ID\u003e"
      ]
    },
    {
      "cells": [
        "Currency ISO Code",
        "\u003cCurrency_ISO_Code\u003e"
      ]
    },
    {
      "cells": [
        "Content Format",
        "\u003cContent_Format\u003e"
      ]
    }
  ]
});
formatter.step({
  "name": "Click the \"Submit\" button on \"Participant Settlement Report\" page",
  "keyword": "And "
});
formatter.step({
  "name": "Verify the below mentioned confirmation message is displayed on \"Request a Report\" page",
  "keyword": "Then ",
  "doc_string": {
    "value": "Your request is successfully submitted, Please find the report using the Report Id #### in the Requested Report section."
  }
});
formatter.step({
  "name": "Navigate to below mentioned menu in order to reach \"Requested Reports\" page",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "Requested Reports"
      ]
    }
  ]
});
formatter.step({
  "name": "Select \"\u003cRequested_Reports\u003e\" from \"Requested Reports\" dropdown list in \"Requested Reports\" page",
  "keyword": "And "
});
formatter.step({
  "name": "Click the \"Select\" button on \"Requested Reports\" page",
  "keyword": "And "
});
formatter.step({
  "name": "The \"Requested Reports\" table contains the following columns:",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "No",
        "%NOTEMPTY%"
      ]
    },
    {
      "cells": [
        "Reports",
        "%NOTEMPTY%"
      ]
    }
  ]
});
formatter.step({
  "name": "Click the \"Download\" button on \"Requested Reports\" page",
  "keyword": "Then "
});
formatter.step({
  "name": "Downloaded CSV file should display below mentioned columns for \"Participant Settlement Report\" under \"Requested Reports\"",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "FI ID"
      ]
    },
    {
      "cells": [
        "FI Name"
      ]
    },
    {
      "cells": [
        "Participant ID"
      ]
    },
    {
      "cells": [
        "Participant Name"
      ]
    },
    {
      "cells": [
        "Funding Agent Account ID"
      ]
    },
    {
      "cells": [
        "Funding Agent Name"
      ]
    },
    {
      "cells": [
        "Currency"
      ]
    },
    {
      "cells": [
        "Debit Cap"
      ]
    },
    {
      "cells": [
        "Number of Inward transactions"
      ]
    },
    {
      "cells": [
        "Value of Inward transactions"
      ]
    },
    {
      "cells": [
        "Number of Outward transactions"
      ]
    },
    {
      "cells": [
        "Value of Outward transactions"
      ]
    },
    {
      "cells": [
        "Net Position"
      ]
    }
  ]
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
        "Request_a_Report",
        "Settlement_Date",
        "Settlement_Cycle_ID",
        "Currency_ISO_Code",
        "Content_Format",
        "Requested_Reports"
      ]
    },
    {
      "cells": [
        "Chrome",
        "External",
        "dev_SAALBI_allAccess_user",
        "dev_SAALBI_allAccess_user",
        "Participant Settlement Report",
        "16/07/2020",
        "001",
        "SAR",
        "CSV",
        "Participant Settlement Report"
      ]
    }
  ]
});
formatter.scenario({
  "name": "User views the Participant Settlement Report in CSV format and the output field names are as per specification",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@02_05_Ext_RequestaReport_ParticipantSettlementReport"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Open browser \"Chrome\"",
  "keyword": "Given "
});
formatter.match({
  "location": "ReportsStepDefinitions.open_browser(String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.SessionNotCreatedException: session not created\nfrom chrome not reachable\n  (Session info: chrome\u003d80.0.3987.87)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:25:53\u0027\nSystem info: host: \u0027DESKTOP-8V8E038\u0027, ip: \u0027192.168.1.102\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_211\u0027\nDriver info: driver.version: ChromeDriver\nremote stacktrace: Backtrace:\n\tOrdinal0 [0x00660C83+1707139]\n\tOrdinal0 [0x005C68F1+1075441]\n\tOrdinal0 [0x0053DE72+515698]\n\tOrdinal0 [0x00537CA8+490664]\n\tOrdinal0 [0x0053839B+492443]\n\tOrdinal0 [0x005392F5+496373]\n\tOrdinal0 [0x00534F05+478981]\n\tOrdinal0 [0x0053ECA0+519328]\n\tOrdinal0 [0x004ECA67+182887]\n\tOrdinal0 [0x004EBDDD+179677]\n\tOrdinal0 [0x004E9D4B+171339]\n\tOrdinal0 [0x004D1D4A+73034]\n\tOrdinal0 [0x004D2DC0+77248]\n\tOrdinal0 [0x004D2D59+77145]\n\tOrdinal0 [0x005DBB67+1162087]\n\tGetHandleVerifier [0x006FA966+508998]\n\tGetHandleVerifier [0x006FA6A4+508292]\n\tGetHandleVerifier [0x0070F7B7+594583]\n\tGetHandleVerifier [0x006FB1D6+511158]\n\tOrdinal0 [0x005D402C+1130540]\n\tOrdinal0 [0x005DD4CB+1168587]\n\tOrdinal0 [0x005DD633+1168947]\n\tOrdinal0 [0x005F5B35+1268533]\n\tBaseThreadInitThunk [0x76F06359+25]\n\tRtlGetAppContainerNamedObjectPath [0x774D7C24+228]\n\tRtlGetAppContainerNamedObjectPath [0x774D7BF4+180]\n\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.W3CHandshakeResponse.lambda$errorHandler$0(W3CHandshakeResponse.java:62)\r\n\tat org.openqa.selenium.remote.HandshakeResponse.lambda$getResponseFunction$0(HandshakeResponse.java:30)\r\n\tat org.openqa.selenium.remote.ProtocolHandshake.lambda$createSession$0(ProtocolHandshake.java:126)\r\n\tat java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:193)\r\n\tat java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:958)\r\n\tat java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:126)\r\n\tat java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:498)\r\n\tat java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)\r\n\tat java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:471)\r\n\tat java.util.stream.FindOps$FindOp.evaluateSequential(FindOps.java:152)\r\n\tat java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)\r\n\tat java.util.stream.ReferencePipeline.findFirst(ReferencePipeline.java:464)\r\n\tat org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:128)\r\n\tat org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:74)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:136)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.startSession(RemoteWebDriver.java:213)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.\u003cinit\u003e(RemoteWebDriver.java:131)\r\n\tat org.openqa.selenium.chrome.ChromeDriver.\u003cinit\u003e(ChromeDriver.java:181)\r\n\tat org.openqa.selenium.chrome.ChromeDriver.\u003cinit\u003e(ChromeDriver.java:168)\r\n\tat org.openqa.selenium.chrome.ChromeDriver.\u003cinit\u003e(ChromeDriver.java:157)\r\n\tat com.sama.ach.cucumber.poc.utils.CommonFunctions.openBrowser(CommonFunctions.java:129)\r\n\tat com.sama.ach.cucumber.reports.stepdefs.ReportsStepDefinitions.open_browser(ReportsStepDefinitions.java:48)\r\n\tat ✽.Open browser \"Chrome\"(./src/test/resources/com/sama/ach/cucumber/features/002_ExternalPortal_Reports_RequestReport.feature:310)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Login to \"External\" Portal under \"%ENV%\" environment with username as \"dev_SAALBI_allAccess_user\" and password as \"dev_SAALBI_allAccess_user\"",
  "keyword": "When "
});
formatter.match({
  "location": "ReportsStepDefinitions.login_to_Portal_under_environment_with_username_as_and_password_as(String,String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Navigate to below mentioned menu in order to reach \"Request a Report\" page",
  "rows": [
    {
      "cells": [
        "Reports \u0026 Enquiry"
      ]
    },
    {
      "cells": [
        "Request a Report"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "ReportsStepDefinitions.navigate_to_below_mentioned_menu_in_order_to_reach_page(String,String\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Select \"Participant Settlement Report\" from \"Request a Report\" dropdown list in \"Request a Report\" page",
  "keyword": "And "
});
formatter.match({
  "location": "ReportsStepDefinitions.select_from_dropdown_list_in_page(String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Click the \"Select\" button on \"Request a Report\" page",
  "keyword": "And "
});
formatter.match({
  "location": "ReportsStepDefinitions.click_the_button_on_page(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "The \"Participant Settlement Report\" page contains the following GUI items:",
  "rows": [
    {
      "cells": [
        "Label",
        "Participant ID",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Settlement Date",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Settlement Cycle ID",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Currency ISO Code",
        "%Displayed%"
      ]
    },
    {
      "cells": [
        "Label",
        "Content Format",
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
  "location": "ReportsStepDefinitions.the_page_contains_the_following_GUI_items(String,String\u003e\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Enter below values in \"Participant Settlement Report\" page",
  "rows": [
    {
      "cells": [
        "Settlement Date",
        "16/07/2020"
      ]
    },
    {
      "cells": [
        "Settlement Cycle ID",
        "001"
      ]
    },
    {
      "cells": [
        "Currency ISO Code",
        "SAR"
      ]
    },
    {
      "cells": [
        "Content Format",
        "CSV"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ReportsStepDefinitions.enter_below_values_in_page(String,String\u003e\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Click the \"Submit\" button on \"Participant Settlement Report\" page",
  "keyword": "And "
});
formatter.match({
  "location": "ReportsStepDefinitions.click_the_button_on_page(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Verify the below mentioned confirmation message is displayed on \"Request a Report\" page",
  "keyword": "Then ",
  "doc_string": {
    "value": "Your request is successfully submitted, Please find the report using the Report Id #### in the Requested Report section."
  }
});
formatter.match({
  "location": "ReportsStepDefinitions.verify_the_below_mentioned_confirmation_message_is_displayed_on_page(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Navigate to below mentioned menu in order to reach \"Requested Reports\" page",
  "rows": [
    {
      "cells": [
        "Requested Reports"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ReportsStepDefinitions.navigate_to_below_mentioned_menu_in_order_to_reach_page(String,String\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Select \"Participant Settlement Report\" from \"Requested Reports\" dropdown list in \"Requested Reports\" page",
  "keyword": "And "
});
formatter.match({
  "location": "ReportsStepDefinitions.select_from_dropdown_list_in_page(String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Click the \"Select\" button on \"Requested Reports\" page",
  "keyword": "And "
});
formatter.match({
  "location": "ReportsStepDefinitions.click_the_button_on_page(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "The \"Requested Reports\" table contains the following columns:",
  "rows": [
    {
      "cells": [
        "No",
        "%NOTEMPTY%"
      ]
    },
    {
      "cells": [
        "Reports",
        "%NOTEMPTY%"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ReportsStepDefinitions.the_table_contains_the_following_columns(String,String\u003e\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Click the \"Download\" button on \"Requested Reports\" page",
  "keyword": "Then "
});
formatter.match({
  "location": "ReportsStepDefinitions.click_the_button_on_page(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Downloaded CSV file should display below mentioned columns for \"Participant Settlement Report\" under \"Requested Reports\"",
  "rows": [
    {
      "cells": [
        "FI ID"
      ]
    },
    {
      "cells": [
        "FI Name"
      ]
    },
    {
      "cells": [
        "Participant ID"
      ]
    },
    {
      "cells": [
        "Participant Name"
      ]
    },
    {
      "cells": [
        "Funding Agent Account ID"
      ]
    },
    {
      "cells": [
        "Funding Agent Name"
      ]
    },
    {
      "cells": [
        "Currency"
      ]
    },
    {
      "cells": [
        "Debit Cap"
      ]
    },
    {
      "cells": [
        "Number of Inward transactions"
      ]
    },
    {
      "cells": [
        "Value of Inward transactions"
      ]
    },
    {
      "cells": [
        "Number of Outward transactions"
      ]
    },
    {
      "cells": [
        "Value of Outward transactions"
      ]
    },
    {
      "cells": [
        "Net Position"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ReportsStepDefinitions.downloaded_CSV_file_should_display_below_mentioned_columns_for_under(String,String,String\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "ReportsStepDefinitions.close_the_browser()"
});
formatter.result({
  "status": "skipped"
});
});