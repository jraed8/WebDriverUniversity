package Adv1CucumberFramework.StepDefinitions;

import java.io.IOException;

import Resources.Utils.DriverFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductsSteps extends DriverFactory {

	
	@Given("^User navigates to url$")
	public void user_navigates_to() throws IOException {
		productsPage.getProductsPage();
	}
	
	@When("^User clicks on special offers link$")
	public void user_clicks_on_special_offers_link() throws Throwable {
	    productsPage.clickSpecialOffers();
	}

	@Then("^User should be presented with a promo alert$")
	public void user_should_be_presented_with_a_promo_alert() throws Throwable {
		productsPage.printSpecialOffersVoucherCode();
	}
	
	@When("^User clicks on Proceed button$")
	public void user_clicks_on() throws Throwable {
		productsPage.clickOnProceedButton_Popup();
	}

}
