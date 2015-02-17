package dataDriven;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

import widgets.Widget;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;

public class ParametrizationTest extends Widget {

	private String height;
	private String weight;
	private String bmi;
	private String bmiCategory;
	public static StringBuffer verificationErrors = new StringBuffer();

	WebDriver driver = theDriver;

	@RunWith(value = Parameterized.class)
	public static class SimpleDDT {
		private static WebDriver driver;

	}

	@Parameters
	public static Collection testData() {
		return Arrays.asList(new Object[][] { { "160", "45", "17.6", "Underweight" }, { "168", "70", "24.8", "Normal" },
				{ "181", "89", "27.2", "Overweight" }, { "178", "100", "31.6", "Obesity" } });
	}

	@Test
	public void testBMICalculator() throws Exception {
		// Get the Height element and set the value using parameterised
		// height variable
		WebElement heightField = driver.findElement(By.name("heightCMS"));
		heightField.clear();
		heightField.sendKeys(height);
		// Get the Weight element and set the value using parameterised
		// Weight variable
		WebElement weightField = driver.findElement(By.name("weightKg"));
		weightField.clear();
		weightField.sendKeys(weight);
		// Click on Calculate Button
		WebElement calculateButton = driver.findElement(By.id("Calculate"));
		calculateButton.click();
		try {
			// Get the Bmi element and verify its value using parameterised
			// bmi variable
			WebElement bmiLabel = driver.findElement(By.name("bmi"));
			assertEquals(bmi, bmiLabel.getAttribute("value"));
			// Get the Bmi Category element and verify its value using
			// parameterised bmiCategory variable
			WebElement bmiCategoryLabel = driver.findElement(By.name("bmi_category"));
			assertEquals(bmiCategory, bmiCategoryLabel.getAttribute("value"));
		} catch (Error e) {
			// Capture and append Exceptions/Errors
			 verificationErrors.append(e.toString());
			System.err.println("Assertion Fail "+
			 verificationErrors.toString());
		}
	}

}
