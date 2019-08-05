
Feature: Salesforce Testing
 
  Scenario: TC01: Login Error Message 
    Given Launch the Salesforce login page
    When User enters the valid user name in username field
    And user  keeps the password field empty
    Then click on the login button
     And validate the error message
     And close the browser
    

 Scenario: TC02: Login To Application
    Given Launch the Salesforce login page
    When User enters the valid user name in username field
    And user enters the valid password in password field
    Then click on the login button
    And close the browser

 Scenario: TC03: Login To Application
    Given Launch the Salesforce login page
    When User enters the valid user name in username field
    And user enters the valid password in password field
    Then user selects the remember me check box
    Then click on the login button
    Then user clicks on user menu drop down
    And click on logout button
    Then User check for UserName Field to validate
    And close the browser
        
    
  Scenario: TC04: Forgot Password
    Given Launch the Salesforce login page
    When  user clicks on forgot password
    Then user enters the username in the username field
    Then clicks on continue button
    
    
 Scenario: TC05: ValidateLoginErrorMessage
     Given Launch the Salesforce login page
     When User enters the invalid user name in username field
     And user enters the invalid password in password field 
     Then click on the login button
     And validate the error message after login
     And close the browser
    
    
    
    
    
    
    
    
    