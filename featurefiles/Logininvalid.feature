
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Login with Invalid Credentials
    Given i open browser with url "http://flights.qedgetech.com"
    When i entered username as "bhaunuba@gmail.com"
    And i entered password as "Demo"
    And i click sign in
    Then i should see the error message "invalid"
   
