package Adv1CucumberFramework.StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;

import Resources.Utils.DriverFactory;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactUsSteps extends DriverFactory {
	 
	WebDriverWait wait = new WebDriverWait(driver, 10);
	 
	@Given("^I access webdriveruniversity contact us form$")
	public void i_access_webdriveruniversity_contact_us_form() throws IOException {
		contactUsPage.getContactUsPage();
	}

	@When("^I enter a valid first name$")
	public void i_enter_a_valid_first_name() throws Exception{
		contactUsPage.enterFirstName();
	}

	@When("^I enter a valid last name$")
	public void i_enter_a_valid_last_name(DataTable lnData) throws Throwable {
		contactUsPage.enterLastName(lnData, 0, 1);
	}

	@When("^I enter a valid email address$")
	public void i_enter_a_valid_email_address() throws Throwable {
		contactUsPage.enterEmailAddress("webdriveruniversity@outlook.com");
	}

	@When("^I enter comments$")
	public void i_enter_comments(DataTable comntData) throws Throwable {
		contactUsPage.enterComments(comntData, 0, 1);
	}

	@When("^I click on the submit button$")
	public void i_click_on_the_submit_button() throws Throwable {
		contactUsPage.clickOnSubmiButton();
	}

	@Then("^the information should successfully be submitted via the contact us form$")
	public void the_information_should_successfully_be_submitted_via_the_contact_us_form() throws Throwable {
		contactUsPage.confirmContactUsFormSubmissionWasSuccessful();
	}

}
