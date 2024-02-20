package Test_Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "featurefiles/flightbook.feature", glue = "Test_Definition", dryRun = false, plugin = {"pretty", "html:reports/flightbook.html"})
public class FlightBook 
 
{
	

}
