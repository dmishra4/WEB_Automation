$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./src/test/resources/com/sama/ach/cucumber/features/001_ExternalPortal_Dashboard_ViewParticipantUI.feature");
formatter.feature({
  "name": "ExternalPortal_Dashboard_ViewParticipantUI",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "View the Debit Cap and Threshold under Dashboard screen",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Dashboard_DebitCapThreshold"
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
  "name": "Navigate to below mentioned menu in order to reach \"Dashboard\" page",
  "keyword": "Then ",
  "rows": [
    {
      "cells": [
        "Dashboard"
      ]
    }
  ]
});
formatter.step({
  "name": "The \"Debit Cap\" section under \"Dashboard\" page contains the following GUI items:",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "Label",
        "Debit Cap",
        "%NotEmpty%"
      ]
    },
    {
      "cells": [
        "Label",
        "Low Threshold",
        "%NotEmpty%"
      ]
    },
    {
      "cells": [
        "Label",
        "High Threshold",
        "%NotEmpty%"
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
        "Portal_Name",
        "Username",
        "Password"
      ]
    },
    {
      "cells": [
        "External",
        "dev_SAALBI_allAccess_user",
        "dev_SAALBI_allAccess_user"
      ]
    }
  ]
});
formatter.scenario({
  "name": "View the Debit Cap and Threshold under Dashboard screen",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Dashboard_DebitCapThreshold"
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
  "location": "DashboardStepDefinitions.open_browser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Login to \"External\" Portal under \"%ENV%\" environment with username as \"dev_SAALBI_allAccess_user\" and password as \"dev_SAALBI_allAccess_user\"",
  "keyword": "When "
});
formatter.match({
  "location": "DashboardStepDefinitions.login_to_Portal_under_environment_with_username_as_and_password_as(String,String,String,String)"
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
  "name": "Navigate to below mentioned menu in order to reach \"Dashboard\" page",
  "rows": [
    {
      "cells": [
        "Dashboard"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "DashboardStepDefinitions.navigate_to_below_mentioned_menu_in_order_to_reach_page(String,String\u003e)"
});
formatter.embedding("image/png", "embedded3.png");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The \"Debit Cap\" section under \"Dashboard\" page contains the following GUI items:",
  "rows": [
    {
      "cells": [
        "Label",
        "Debit Cap",
        "%NotEmpty%"
      ]
    },
    {
      "cells": [
        "Label",
        "Low Threshold",
        "%NotEmpty%"
      ]
    },
    {
      "cells": [
        "Label",
        "High Threshold",
        "%NotEmpty%"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "DashboardStepDefinitions.the_section_under_page_contains_the_following_GUI_items(String,String,String\u003e\u003e)"
});
formatter.embedding("image/png", "embedded4.png");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "DashboardStepDefinitions.close_the_browser()"
});
formatter.result({
  "status": "passed"
});
});