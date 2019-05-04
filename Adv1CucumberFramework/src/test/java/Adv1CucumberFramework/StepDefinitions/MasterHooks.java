package Adv1CucumberFramework.StepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Resources.Utils.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class MasterHooks extends DriverFactory {

	@Before()
	public void setup() throws Exception {
		driver = getDriver();
	}
	
	@After()
	public void tearDownAndScreenShotOnFailure(Scenario scenario) {
		try {
			if(driver != null && scenario.isFailed()) {
			scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
			driver.manage().deleteAllCookies();
			driver.close();
			driver.quit();
			driver = null;
			}	
				
			if (driver != null) {
			driver.manage().deleteAllCookies();
			driver.close();
			driver.quit();
			driver = null;
			}
		} catch (Exception e) {
			System.out.println("Methods Failed: tearDownAndScreenshotOnFailure, Exeption: " +e.getMessage());
		}
	}
}
