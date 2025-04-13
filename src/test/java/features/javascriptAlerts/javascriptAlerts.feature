Feature: Handle javascript alerts

  Scenario: Handle JS Alert
    Given I Open HerokuApp javascript_alerts page
    When I click on "JS Alert" option in javascript alerts page
    Then An alert should be displayed with message "I am a JS Alert"
    And I should be able to close it on clicking OK button


  Scenario: Handle JS Alert
    Given I Open HerokuApp javascript_alerts page
    When I click on "JS Confirm" option in javascript alerts page
    Then An alert should be displayed with message "I am a JS Confirm"
    And I should be able to close it on clicking OK button


  Scenario: Handle JS Alert
    Given I Open HerokuApp javascript_alerts page
    When I click on "JS Prompt" option in javascript alerts page
    Then An alert should be displayed with message "I am a JS prompt"
    And I should be able to close it on clicking OK button