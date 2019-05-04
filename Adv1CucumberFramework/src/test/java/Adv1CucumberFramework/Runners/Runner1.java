package Adv1CucumberFramework.Runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions (
		features = {"src/test/java/Adv1CucumberFramework/FeatureFiles/ContactUs.feature"},
		glue = {"Adv1CucumberFramework.StepDefinitions"},
		monochrome = true,
		tags = {},
		plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", 
				"com.cucumber.listener.ExtentCucumberFormatter:target/report.html"}
	)

public class Runner1 extends AbstractTestNGCucumberTests {

}
