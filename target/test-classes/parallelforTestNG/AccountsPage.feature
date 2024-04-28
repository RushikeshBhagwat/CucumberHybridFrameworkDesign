Feature: Accounts Page Feature

Background:
Given User has already logged into application
|username     |password  |
|test745@gmail.com|Test@123|

@skip_scenario
Scenario: Accounts Page Title
Given User is on the accounts page
When user get the title of the page
Then page title should be "My Account"

Scenario: Accounts section count
Given User is on the accounts page
Then User gets account section
|Edit your account information|
|Change your password|
|Modify your address book entries|
|Modify your wish list|
And Accounts section count should be 4