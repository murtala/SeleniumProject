/*package android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;
import static org.junit.Assert.*;

public class AndroidDriverTest {
	
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception { 
		// Create a new instance of the Android driver
		driver = new AndroidDriver();
		//driver = new AndroidDriver("http://192.168.1.100/wd/hub");
		driver.get("file:///F:/JAVA/QA/Java%20Files/Mobile%20BMI%20Calculator.htm");
		
		
		//using remote web driver
		//Create a new instance of DesiredCapabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		// Create a new instance of the RemoteWebDriver using RemoteWebDriver
		// Server URL & Desired Capabilities
		driver = new RemoteWebDriver(new URL("http://192.168.1.100/wd/hub"),caps.android());
	}

	@Test
	public void testBMICalculator() throws Exception {
		try {
			WebElement height = driver.findElement(By.name("heightCMS"));
			height.sendKeys("181");
			
			WebElement weight = driver.findElement(By.name("weightKg"));
			weight.sendKeys("80");
	
			WebElement calculateButton = driver.findElement(By.id("Calculate"));
			calculateButton.click();
			
			WebElement bmi = driver.findElement(By.name("bmi"));
			assertEquals("24.4", bmi.getAttribute("value"));
			
			WebElement bmi_category = driver.findElement(By.name("bmi_category"));
			assertEquals("Normal",bmi_category.getAttribute("value"));
			
			
			
			//we are rotating the screen
			//to the landscape mode then back to the portrait mode by using the following code:
			((Rotatable) driver).rotate(ScreenOrientation.LANDSCAPE);
			 height = driver.findElement(By.name("heightCMS"));
			height.sendKeys("181");
			
			 weight = driver.findElement(By.name("weightKg"));
			weight.sendKeys("80");
			 calculateButton = driver.findElement
			(By.id("Calculate"));
			calculateButton.click();
			((Rotatable) driver).rotate(ScreenOrientation.PORTRAIT);
			
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
*/