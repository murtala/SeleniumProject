package compareImages;

import static org.junit.Assert.*;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import widgets.Pather;
import widgets.Widget;


public class BmiCalculatorTestImage {
	
	public WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp() throws Exception { 
		// Create a new instance of the Firefox driver
		//driver = new FirefoxDriver();
		
	}

	@Test
	public void testBmiCalculatorLayout() throws Exception {
	
		
		String scrFile =("G:\\Users\\Moortala\\workspace\\SeleniumProject\\src\\screenshots\\main_page.png\\logo4w.png");
		String baseScrFile =("G:\\Users\\Moortala\\workspace\\SeleniumProject\\src\\screenshots\\logo4wInvert.png");
		
		
		//String scrFile =("/SeleniumProject/src/compareImages/logo4w.png");
		//String baseScrFile =("/SeleniumProject/src/compareImages/logo4wInvert.png");
		
		//Open the BMI Calculator Page and get a Screen Shot of Page into a File
		//driver.get("file:///G:/Dev/JAVA/Java%20Files/BMI%20Calculator.htm");
		Widget.OpenLinkInChromeBrowser(Pather.getLoc("BMI Calculator.htm"));
		driver = Widget.driver;
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
	    String fileName = UUID.randomUUID().toString();

		 File targetFile = new File("G:\\Users\\Moortala\\workspace\\SeleniumProject\\src\\screenshots\\" + fileName
			        + ".jpg");
		 
			    FileUtils.copyFile(screenshotFile, targetFile);//.copyFile(scrFile, targetFile);
			    
	//	FileUtils.copyFile(screenshotFile, new File(scrFile));
		
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