package Resources.pageObjects;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cucumber.api.DataTable;


public class ContactUs_Page extends BasePage{

	public @FindBy(xpath = "//input[@name='first_name']") WebElement textfield_FirstName;
	public @FindBy(xpath = "//input[@name='last_name']") WebElement textfield_LastName;
	public @FindBy(xpath = "//input[@name='email']") WebElement textfield_EmailAddress;
	public @FindBy(xpath = "//textarea[@name='message']") WebElement textfield_Message;
	public @FindBy(xpath = "//input[@value='SUBMIT']") WebElement button_Submit;
	public @FindBy(xpath = ".//*[@id='contact_reply']/h1") WebElement text_ThanksMsg;
	
	public ContactUs_Page() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ContactUs_Page getContactUsPage() throws IOException {
		getDriver().get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
		return new ContactUs_Page();
	}
	
	public ContactUs_Page enterFirstName() throws Exception {
		sendKeysToWebElement(textfield_FirstName, "Tom");
		return new ContactUs_Page();
	}
	
	public ContactUs_Page enterLastName(DataTable dataTable, int row, int column) throws Exception {
		List<List<String>> data = dataTable.raw();
		sendKeysToWebElement(textfield_LastName, data.get(row).get(column));
		return new ContactUs_Page();
	}
	
	public ContactUs_Page enterEmailAddress(String emailAddress) throws Exception {
		sendKeysToWebElement(textfield_EmailAddress, emailAddress);
		return new ContactUs_Page();
	}
	
	public ContactUs_Page enterComments(DataTable dataTable, int row, int column) throws Exception {
		List<List<String>> data = dataTable.raw();
		sendKeysToWebElement(textfield_Message, data.get(row).get(column));
		return new ContactUs_Page();
	}
	
	public ContactUs_Page clickOnSubmiButton() throws Exception {
		waitAndClickElement(button_Submit);
		return new ContactUs_Page();
	}
	
	public ContactUs_Page confirmContactUsFormSubmissionWasSuccessful() throws Exception {
		WaitUntilWebElementIsVisible(text_ThanksMsg);
		assertEquals("thankyouforyourmessage!", text_ThanksMsg.getText().toLowerCase().replaceAll("[ ()0-9]", ""));
		return new ContactUs_Page();
	}

}
