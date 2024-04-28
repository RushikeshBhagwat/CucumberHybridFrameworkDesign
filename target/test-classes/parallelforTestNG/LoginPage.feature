Feature: Login page feature

Scenario: Login page title
Given user is on the login page
When user get the title of the page
Then page title should be "Account Login"

@skip_scenario
Scenario: Forgot Password link
Given user is on the login page
Then Forgot password link should be displayed

Scenario: Login with correct credentials
Given user is on the login page
When user enters username "test745@gmail.com" 
And user enters password "Test@123"
And user clicks on login button
Then user get the title of the page
And page title should be "My Account" 
