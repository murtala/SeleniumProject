
package performanceTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
//import org.apache.commons.lang.time.StopWatch;
import org.junit.*;
import static org.junit.Assert.*;

public class StopWatchDemo {
	
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception { 
		driver = new FirefoxDriver();
	}

	@Test
	public void testBMICalculator_Perf() throws Exception {

		// Get the StopWatch Object and start the StopWatch
		org.apache.commons.lang3.time.StopWatch pageLoad = new org.apache.commons.lang3.time.StopWatch();
		pageLoad.start();
		
		// Open the BMI Calculator Mobile Application
		driver.get("http://dl.dropbox.com/u/55228056/bmicalculator.html");
		
		// Wait for the Calculate Button
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("Calculate")));
		
		// Stop the StopWatch
		pageLoad.stop();
		System.out.println("Total Page Load Time: " + pageLoad.getTime() + " milliseconds");
		
		WebElement height = driver.findElement(By.name("heightCMS"));
		height.sendKeys("181");
		
		WebElement weight = driver.findElement(By.name("weightKg"));
		weight.sendKeys("80");

		WebElement calculateButton = driver.findElement(By.id("Calculate"));
		calculateButton.click();
		
		try {
			
			WebElement bmi = driver.findElement(By.name("bmi"));
			assertEquals("24.4", bmi.getAttribute("value"));
			
			WebElement bmi_category = driver.findElement(By.name("bmi_category"));
			assertEquals("Normal",bmi_category.getAttribute("value"));
			
		} catch (Error e) {
			
			//Capture and append Exceptions/Errors
			verificationErrors.append(e.toString());
		}
	}
	
	@After
	public void tearDown() throws Exception {
		// Close the browser
		driver.quit();
		
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
