Feature: HerokuApp login Functionality

  Scenario: Login with valid credentials
    Given I Open HerokuApp "login" page
    And I enter valid credentials
    When I click on the login button
    Then I should be able to login to the webapp with success message "You logged into a secure area!"

  Scenario: Login with invalid credentials
    Given I Open HerokuApp "login" page
    And I enter invalid credentials
    When I click on the login button
    Then I should get the error message "Your username is invalid!"