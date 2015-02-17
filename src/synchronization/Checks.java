package synchronization;

import java.util.NoSuchElementException;

import org.openqa.selenium.*;

import widgets.Widget;

public class Checks extends Widget {
	WebDriver driver = theDriver;

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void testIsElementPresent() {
		// Check if element with locator criteria exists on Page
		if (isElementPresent(By.name("airbags"))) {
			// Get the checkbox and select it
			WebElement airbag = driver.findElement(By.name("airbags"));
			if (!airbag.isSelected())
				airbag.click();
		} else {
			System.out.println("Airbag Checkbox doesn't exists!!");
		}
	}

	public void testElementIsEnabled() {
		// Get the Checkbox as WebElement using it's name attribute
		WebElement ledheadlamp = driver.findElement(By.xpath("//input[@name='ledheadlamp']"));
		// Check if its enabled before selecting it
		if (ledheadlamp.isEnabled()) {
			// Check if its already selected? otherwise select the Checkbox
			if (!ledheadlamp.isSelected())
				ledheadlamp.click();
		} else {
			System.out.println("LED Lamp Checkbox is disabled!!");
		}
	}
}
