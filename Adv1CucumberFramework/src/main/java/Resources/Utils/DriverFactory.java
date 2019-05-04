package Resources.Utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import Resources.pageObjects.BasePage;
import Resources.pageObjects.ContactUs_Page;
import Resources.pageObjects.Products_Page;

public class DriverFactory {

	public static WebDriver driver;
	public static ContactUs_Page contactUsPage;
	public static Products_Page productsPage;
	public static BasePage basePage;
	
	public WebDriver getDriver() {
	
	try	{
	FileInputStream input = new FileInputStream(Constant.CONFIG_PROPERTIES_DIRECTORY);
	Properties prop = new Properties();
	prop.load(input);
	String browserName = prop.getProperty("browser");
	
	switch(browserName) {
	case "chrome":
		if (null == driver) {
			System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
			// CHROME OPTIONS
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		break;
	case "headless":
		if (null == driver) {
			System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
			// CHROME OPTIONS
			ChromeOptions headless = new ChromeOptions();
			headless.addArguments("--headless");
			driver = new ChromeDriver(headless);
			driver.manage().window().maximize();
		}
		break;
	case "firefox":
		if (null == driver) {
			System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY);
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver();
		}
		break;
	case "ie":
		if (null == driver) { 
			System.setProperty("webdriver.ie.driver", Constant.IE_DRIVER_DIRECTORY);
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability("ie", true);
			driver = new InternetExplorerDriver(capabilities);
			driver.manage().window().maximize();
		}
		break;
		}
	
	}	catch(Exception e)	{
		System.out.println("Unable to load browser: " + e.getMessage());
		
	}	finally {
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		contactUsPage = PageFactory.initElements(driver, ContactUs_Page.class);
		productsPage = PageFactory.initElements(driver, Products_Page.class);
		basePage = PageFactory.initElements(driver, BasePage.class);
	}
	
	return driver;
}	

}
