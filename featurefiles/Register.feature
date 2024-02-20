@tag
Feature: User Registration
@tag1
Scenario: Checking user Registration with valid Inputs
Given i open browser with url "http://flights.qedgetech.com"	
When i click on register link
Then i should see the register module
And i enter valid inputs "Bhanu" and "9556654432" and "abcdas@gmail.com" and "Abcd123#@!"
And i enter the date "14"
And i click on Register button
