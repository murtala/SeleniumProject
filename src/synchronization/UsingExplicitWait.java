package synchronization;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import widgets.Widget;

public class UsingExplicitWait {

	WebDriverWait wait = new WebDriverWait(Widget.firefoxdriver, 30);

	public void OpenHomepage() {
		Widget.OpenLinkInFirefoxBrowser("http://www.yahoo.com");

	}

	/*
	 * Explicit waits for a specific condition to occur before proceeding into
	 * further code it appllies to one element. it will wait for x seconds for
	 * the element, if element not there, it gives up example)
	 * 
	 * 
	 * 
	 * Predefined condition                   Selenium method 
	 * An element is visible and enabled     * elementToBeClickable(By locator) 
	 * An element is selected           	 * elementToBeSelected(WebElement element) 
	 * Presence of an element 				 * presenceOfElementLocated(By locator)
	 *  Specific text present in an element  * textToBePresentInElement(By locator, java.lang.String text) 
	 * Element value 	                     * textToBePresentInElementValue(By locator, java.lang.String text) 
	 * Title 	 							 * titleContains(java.lang.String title)
	 */
	public void ExplicitWaitExample() {
		String message = " Time expired";

		// Wait<WebDriver> fluentWait = new
		// FluentWait<WebDriver>(driver).withMessage(message).pollingEvery(2,
		// TimeUnit.SECONDS) .ignoring(Exception.class);

		Boolean element = wait.until(ExpectedConditions.titleContains("Yahoo!"));
		System.out.println("The title contains " + element);

	}
}
