@tag
Feature: Login
@tagLogin	
Scenario: User Login with valid crredential
Given i open browser with url "http://flights.qedgetech.com"	
Then i should see the login page
When i entered username "bhanubabul53@gmail.com"
And i entered password "Qedge123#@!"
And i click sign in
Then i should see the flightbookig link
