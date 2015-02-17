package cucumber;

import org.openqa.selenium.WebDriver;

import cucumber.LoginActions.Pages;
import cucumber.SeleniumWebdriver.Browsers;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberDefinitions {
	private WebDriver		driver;	//this is our selenium webdriver controlling our browsers
	private SeleniumWebdriver 	selenium;	//this is our selenium instance
	private LoginActions 		login; 	//our login class

	//the url of our application
	private final String 		appURL = "http://cosmiccomix.appspot.com/index.html";

	@After	//performed after all is done
	public void cleanUp() {
		driver.quit();
	}

	//our statement for choosing a browser to test in
	@Given("^I want to use the browser (.*)$")
	public void chooseBrowser(Browsers browser) throws Exception {
		selenium = new SeleniumWebdriver(browser, appURL);	//creates our selenium instance, and starts the driver
		driver = selenium.getDriver();			//get which driver we are using
		login = new LoginActions( selenium );			//instantiates our login class, passing the selenium instance and driver
	}

	//which user have we already logged in as
	@Given("^I have logged in as (.*)$")
	public void loginAs(String user) throws Exception {
		login.loginAs( user );
	}

	//////////////////////////////////
	// Login Definitions
	//////////////////////////////////

	//type in our username
	@When("^I type (.*) in the username input field$")
	public void enterUsername(String user) throws Exception {
		login.enterUsername( user );
	}

	//type in our password
	@When("^I type (.*) in the password input field$")
	public void enterPassword(String password) throws Exception {
		login.enterPassword( password );
	}

	//click the login button
	@When("^I click the login button$")
	public void clickLogin() throws Exception {
		login.clickLogin();
	}

	//check our message
	@Then("^I see the login error message \"(.*)\"$")
	public void checkLoginErrorMessage(String errorMessage) throws Exception {
		login.checkLoginErrorMessage( errorMessage );
	}

	//check our page
	@Then("^I am on the (.*) page$")
	public void checkPage(Pages page) throws Exception {
		login.checkPage( page );
	}
}