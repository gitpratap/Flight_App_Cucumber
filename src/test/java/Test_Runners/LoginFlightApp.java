package Test_Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "featurefiles/Login.feature", glue = "Test_Definition", dryRun = false, plugin = {"pretty", "html:reports/Login.html"})
public class LoginFlightApp 
{

}
