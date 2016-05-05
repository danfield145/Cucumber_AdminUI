Feature: Test that I can log into the demo automatically

  In order understand cucumber
  I want to show that we can auto test
  So that we can get others to want to use it


  Background:
    Given I have navigated to the Demo site

  Scenario: Log in successfully with default credentials
    When I log in with default credentials
    Then I see the Dashboard

  @runme
  Scenario: Log in successfully with these credentials
    When I enter the username "brian@weconvene.com"
    And I enter the password "RobLia2016!"
    And I click the Login button
    Then I see the Dashboard

  @ignoreMe
  Scenario: Log in successfully with these credentials like this
    When I enter the username and password "brian@weconvene.com", "RobLia2016!"
    And I click the Login button
    Then I see the Dashboard

  @runme
  Scenario: Log in successfully with these credentials using a more complex sentence
    When I login as user with username "brian@weconvene.com", and password "RobLia2016!"
    Then I see the Dashboard


  Scenario: Log in successfully with these credentials listed in a table
    When I login with credentials
      | username            | password    |
      | brian@weconvene.com | RobLia2016! |
    Then I see the Dashboard


  Scenario Outline: Log in successfully with credentials repeating until the table runs out
    #this means you could log in with several different users to test the login patterns
    #try replacing some of the rows below with other usernames and password
    When I login as user with username "<username>", and password "<password>"
    Then I see the Dashboard

    Examples:
      | username            | password    |
      | brian@weconvene.com | RobLia2016! |
      | brian@weconvene.com | RobLia2016! |
      | brian@weconvene.com | RobLia2016! |
      | brian@weconvene.com | RobLia2016! |

  Scenario: Try to log in with invalid password
      #note the And I try to login....   follow it and observe the method and return type
    When I enter the username "brian@weconvene.com"
    And I enter the password "apples"
    And I try to log in
    Then I see an error prompt with text "Invalid username or password."

  @runme_IFail
  Scenario: Try to log in with invalid password - this test fails because the expected error is wrong
    When I enter the username "brian@weconvene.com"
    And I enter the password "apples"
    And I try to log in
    Then I see an error prompt with text "These are not the droids you are looking for."