package practice;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class FlightSearchRC {
	private Selenium selenium;
public static SeleneseTestBase sv = new SeleneseTestBase();
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.orbitz.com/");
		selenium.start();
	}

	@Test
	public void testFlightSearchRC() throws Exception {
		selenium.open("/");
		selenium.click("name=search.type");
		selenium.click("css=div.button");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=ar.rt.leaveSlice.orig.key", "sfo");
		selenium.click("name=ar.rt.leaveSlice.orig.key");
		selenium.type("name=ar.rt.leaveSlice.dest.key", "la");
		selenium.click("name=ar.rt.leaveSlice.dest.key");
		selenium.type("name=ar.rt.leaveSlice.date", "07/10/13");
		selenium.click("name=ar.rt.returnSlice.date");
		selenium.type("name=ar.rt.returnSlice.date", "07/19/13");
		selenium.click("css=div.closeBar > span");
		selenium.click("name=search");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("Matching Results")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		sv.verifyTrue(selenium.isTextPresent("Matching Results"));
		String price = selenium.getText("xpath=//*[@class='resultsTotal']");
		System.out.println("The lowest price is " + price);
		selenium.open("http://google.com");
		//  Openning a Link
		selenium.click("link=Business Solutions");
		selenium.waitForPageToLoad("30000");
		selenium.goBack();
		selenium.click("link=News");
		selenium.open("http://www.orbitz.com/");
		// Using XPATH
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
