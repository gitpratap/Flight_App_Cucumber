@tag
Feature: Flight Book
@tagLogin	
Scenario: Booking a Flight With valid inputs
Given i open browser with url "http://flights.qedgetech.com"	
Then i should see the login page
When i entered username "bhanubabul53@gmail.com"
And i entered password "Qedge123#@!"
And i click sign in
When i entered th valid date "25-February-2025"
When i click on flightlink "Prasad Airlines"
And i click pn search flight "Bhanupratap"
When i entered name and class detail
And i click on insertorder botton
#Then i should see my details in booking table "prasad Airlines" 