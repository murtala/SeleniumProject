package cucumber;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.SeleniumWebdriver.Locators;

public class LoginActions {
	//this hashmap will keep our users that are active in the system
	private HashMap<String,String> users = new HashMap();	
	//this is our selenium instance
	private SeleniumWebdriver selenium;
	//this is our selenium webdriver controlling our browsers
	private WebDriver	driver;

	//our constructor getting our selenium instance, and the driver to be used
	public LoginActions( SeleniumWebdriver selenium ) {
		this.selenium = selenium;
		this.driver = selenium.getDriver();

		//add our users that we want initially in the system
		users.put("testuser1","testuser1");
		users.put("testuser2","testuser2");
		users.put("testuser3","testuser3");
	}

	//our basic login function
	public void loginAs(String user) throws Exception {
		enterUsername( user );
		enterPassword( users.get(user) );
		clickLogin();
	}

	//entering in the username
	public void enterUsername(String user) throws Exception {
		//type the username using the selenium functionality
		selenium.type( Locators.id, "username", user );
	}

	//entering in the password
	public void enterPassword(String password) throws Exception {
		//type the password using the selenium functionality
		selenium.type( Locators.id, "password", password );
	}

	//click the login button
	public void clickLogin() throws Exception {
		//click the button using the selenium functionality
		selenium.click( Locators.id, "login" );
		//wait one second using the selenium functionality
		selenium.wait( 1 );
	}

	//check our error messages
	public void checkLoginErrorMessage(String errorMessage) throws Exception {
		WebElement errorElement = null;
		//wait for up to 5 seconds for our error message
		long end = System.currentTimeMillis() + 5000;
		while (System.currentTimeMillis() < end) {
			errorElement = selenium.getWebElement( Locators.id, "overError" );
			// If results have been returned, the results are displayed in a drop down.
			if (!errorElement.getText().equals("")) {
				break;
			}
		}
		assertEquals( errorMessage, errorElement.getText() );	//should we consider capturing this error better?
		if ( errorMessage.contains( "username" ) ) {
			errorElement = selenium.getWebElement( Locators.id, "userError" );
			assertEquals( "*", errorElement.getText() );	//should we consider capturing this error better?
		}
		if ( errorMessage.contains( "password" ) ) {
			errorElement = selenium.getWebElement( Locators.id, "passError" );
			assertEquals(  "*", errorElement.getText() );	//should we consider capturing this error better?
		}
	}

	//an enumeration holding the potential pages we are on
	//this can be moved to another class once we have implemented more generic page functionality
	public enum Pages	{ login, launcher };
	//checking which page we are one
	public void checkPage(Pages page) throws Exception {
		String title;
		String url;
		switch( page ) {
			case login:	{ title = "Login To Cosmic Comics";	url = "index.html";	break;	}
			case launcher:	{ title = "Choose A Comic To View";	url = "launcher.html";	break;	}
			default:	{ throw new Exception(); }
		}
	assertEquals( title, driver.getTitle() );	//should we consider capturing this error better?
	assertTrue( driver.getCurrentUrl().endsWith( url ) );	//should we consider capturing this error better?
	}
}