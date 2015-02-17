package compareImages;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;
import org.junit.*;

import widgets.Pather;
import widgets.Widget;
import static org.junit.Assert.*;

import java.io.File;

public class BmiCalculatorTest {
	
	public WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception { 
		// Create a new instance of the Firefox driver
	//	driver = new FirefoxDriver();
		Widget.OpenLinkInChromeBrowser(Pather.getLoc("BMI Calculator.htm"));
		driver = Widget.driver;
	}

	@Test
	public void testBmiCalculatorLayout() throws Exception {
	
		String scrFile = "G:\\Users\\Moortala\\workspace\\SeleniumProject\\src\\screenshots\\screenshot.png";
		String baseScrFile = "G:\\Users\\Moortala\\workspace\\SeleniumProject\\src\\screenshots\\baseScreenshot.png";
		
		//Open the BMI Calculator Page and get a Screen Shot of Page into a File
		//driver.get("http://dl.dropbox.com/u/55228056/bmicalculator.html");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(scrFile));
		
		try {
			//Verify baseline image with actual image 
			assertEquals(CompareUtil.Result.Matched, CompareUtil.CompareImage(baseScrFile,scrFile));
		} catch (Error e) {
			//Capture and append Exceptions/Errors
			verificationErrors.append(e.toString());
		}
	}
	
	@After
	public void tearDown() throws Exception {
		//Close the browser
		driver.quit();
		
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
