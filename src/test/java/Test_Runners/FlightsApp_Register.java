package Test_Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "featurefiles/Register.feature", glue = "Test_Definition", dryRun = false, plugin = {"pretty","html:reports/register.html"})
public class FlightsApp_Register 
{
	

}
