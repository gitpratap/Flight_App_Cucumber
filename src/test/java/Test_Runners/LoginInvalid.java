package Test_Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "featurefiles/Logininvalid.feature", glue = "Test_Definition", dryRun = false)
public class LoginInvalid
{

}
