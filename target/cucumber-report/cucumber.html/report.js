$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("resources.feature");
formatter.feature({
  "line": 2,
  "name": "Resources Test",
  "description": "As user I want to verify \u0027Connect with the world’s financial markets\u0027 text into lseg website",
  "id": "resources-test",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Regression"
    }
  ]
});
formatter.before({
  "duration": 5366138900,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "User should navigate to resources page successfully",
  "description": "",
  "id": "resources-test;user-should-navigate-to-resources-page-successfully",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "I am on homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I click on accept cookies",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I mouse hover and click in resources tab",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I should able to verify text",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.iAmOnHomepage()"
});
formatter.result({
  "duration": 72227800,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.iClickOnAcceptCookies()"
});
formatter.result({
  "duration": 96997900,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.iMouseHoverAndClickInResourcesTab()"
});
formatter.result({
  "duration": 1217762000,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.iShouldAbleToVerifyText()"
});
formatter.result({
  "duration": 42846600,
  "status": "passed"
});
formatter.after({
  "duration": 775502400,
  "status": "passed"
});
});