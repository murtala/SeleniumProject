package cucumber;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoogleCalculatorTest {
	static GoogleCalculator gc = new GoogleCalculator();
	//WebDriver driver = new FirefoxDriver();
	
	@Before
	public void setUp() throws Exception {
	
		//GoogleCalculator.driver = driver;
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test01GoToHomePage() {
		gc.goToHomePage("http://www.google.com");
	}

	@Test
	public void test2Search() {
		gc.search("calculator");
	}

	@Test
	public void test3Operation() {
		gc.operation("5+7");
	}

	@Test
	public void test4Results() {
		gc.results();
	}

}
