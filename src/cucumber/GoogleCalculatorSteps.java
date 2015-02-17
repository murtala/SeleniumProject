package cucumber;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class GoogleCalculatorSteps {

	protected WebDriver driver;

	
	static GoogleCalculator gc = new GoogleCalculator();
	//WebDriver driver = new FirefoxDriver();
	
	@Given("^I open google$")
	public void test01GoToHomePage() {
		gc.goToHomePage("http://www.google.com");
	}

	@When("^I enter \"([^\"]*)\" in search textbox$")
	public void test2Search() {
		gc.search("calculator");
	}

	@Then("^I should get result as \"([^\"]*)\"$")
	public void test3Operation() {
		gc.operation("5+7");
	}

	/*@Test
	public void test4Results() {
		gc.results();
	}*/
	
	
	

	/*@Test
	public void testResults() {
		fail("Not yet implemented");
	}*/

}
