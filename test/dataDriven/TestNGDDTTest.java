package dataDriven;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import widgets.Widget;

public class TestNGDDTTest extends Widget {
	public static WebDriver driver = new FirefoxDriver();

	@BeforeTest
	public void setUp() {
		// Create a new instance of the Firefox driver

		driver.get("file:///F:/JAVA/QA/Java%20Files/BMI%20Calculator.htm");
	}

	@DataProvider
	public String[][] testData() {
		return new String[][] { 
				new String[] { "160", "45", "17.6", "Underweight" },
				new String[] { "168", "70", "24.8", "Normal" }, 
				new String[] { "181", "89", "27.2", "Overweight" },
				new String[] { "178", "100", "31.6", "Obesity" }, };
	}
//dataprovide=method name 
	@Test(dataProvider = "testData")
	public void testBMICalculator(String height, String weight, String bmi, String category) {
		try {
			WebElement heightField = driver.findElement(By.name("heightCMS"));
			heightField.clear();
			heightField.sendKeys(height);
			Thread.sleep(2000);
			WebElement weightField = driver.findElement(By.name("weightKg"));
			weightField.clear();
			weightField.sendKeys(weight);
			Thread.sleep(2000);
			WebElement calculateButton = driver.findElement(By.id("Calculate"));
			calculateButton.click();
			WebElement bmiLabel = driver.findElement(By.name("bmi"));
			// assertEquals(bmiLabel.getAttribute("value"),bmi);
			WebElement bmiCategoryLabel = driver.findElement(By.name("bmi_category"));
			// assertEquals(bmiCategoryLabel.getAttribute("value"),category);
		} catch (Error | Exception e) {
			// Capture and append Exceptions/Errors
			// verificationErrors.append(e.toString());
		}
	}

	@AfterTest
	public void tearDown() {
		// Close the browser
		driver.quit();
		// String verificationErrorString = verificationErrors.toString();
		// if (!"".equals(verificationErrorString)) {
		// fail(verificationErrorString);
		// }
	}

}
