package jquery;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JQuerySelector { 

	protected WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("file:///G:/Users/Moortala/workspace/SeleniumProject/web/Locators.html");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testDefaultSelectedCheckbox() { 
        
		//Expected list of selected Checkbox
		List<String> checked =  Arrays.asList(new String[]{"user128_admin", "user220_browser"});
		
		//Create an instance of JavaScript Executor from driver
		JavascriptExecutor js = (JavascriptExecutor) driver;

		//Locate all the Checkbox which are checked by calling jQuery find() method. 
		//find() method returns elements in array
		List<WebElement> elements = (List<WebElement>) js.executeScript("return jQuery.find(':checked')");

		//Verify two Checkbox are selected 
		assertEquals(elements.size(),2);

		//Verify correct Checkbox are selected
		for (WebElement element : elements){
			System.out.println(element.getText().toString());
			assertTrue(checked.contains(element.getAttribute("id")));}
    }
	
	@After
	public void tearDown() {
		driver.close();
	driver.quit();
	}
} 