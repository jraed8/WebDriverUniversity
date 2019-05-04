package Resources.pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products_Page extends BasePage {
	
	public @FindBy(xpath = "//div[@id='container-special-offers']") WebElement button_specialOffers;
	public @FindBy(xpath = "//div[@id='container-product2']") WebElement button_newLaptops;
	public @FindBy(xpath = "//div[@id='myModal']//b[contains(text(),'NEWCUSTOMER')]") WebElement text_couponCode;
	public @FindBy(xpath = "//button[text()='Proceed']") WebElement button_proceed;
	
	public Products_Page() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Products_Page getProductsPage() throws IOException {
		getDriver().get("http://webdriveruniversity.com/Page-Object-Model/products.html");
		return new Products_Page();
	}
	
	public Products_Page clickSpecialOffers() throws InterruptedException, IOException  {
		waitAndClickElement(button_specialOffers);
		return new Products_Page();
	}
	

	public String printSpecialOffersVoucherCode() throws InterruptedException {
		assertTrue(WaitUntilWebElementIsVisible(text_couponCode));
		String voucherCodeValue = text_couponCode.getText().replaceAll("[0-9]", "");
		System.out.println(voucherCodeValue);
		assertEquals(voucherCodeValue, "NEWCUSTOMER1");
		return voucherCodeValue;
	}
	
	public Products_Page clickOnProceedButton_Popup() throws IOException, InterruptedException {
		waitAndClickElement(button_proceed);
		return new Products_Page();
	}

}
