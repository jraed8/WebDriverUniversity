package Adv1CucumberFramework.Runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions (
		features = {"src/test/java/Adv1CucumberFramework/FeatureFiles/Products.feature"},
		glue = {"Adv1CucumberFramework.StepDefinitions"},
		monochrome = true,
		dryRun = false,
		tags = {},
		plugin = {"pretty", "html:target/Report001", "json:target/cucumber.json", 
				"com.cucumber.listener.ExtentCucumberFormatter:target/report.html"}
	)

public class Runner2 extends AbstractTestNGCucumberTests {

}
