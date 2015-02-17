package synchronization;

import java.util.concurrent.TimeUnit;

import widgets.Widget;

public class UsingImplicitWait {

	/*
	 * When an implicit wait is implemented in tests, if WebDriver cannot find
	 * an element in the Document Object Model (DOM), it will wait for a defined
	 * amount of time for the element to appear in the DOM.
	 * 
	 * In other terms, an implicit wait polls the DOM for a certain amount of
	 * time when trying to find an element or elements if they are not
	 * immediately available. The default setting is 0.
	 * 
	 * Once set, the implicit wait is set for the life of the WebDriver object's
	 * instance. However, an implicit wait may slow down your tests when an
	 * application responds normally, as it will wait for each element appearing
	 * in the DOM and increase the overall execution time.
	 * 
	 * In this recipe, we will briefly explore the use of an implicit wait;
	 * however, it is recommended to avoid or minimize the use of an implicit
	 * wait.
	 */

	
	
	public void OpenHomePage() {
		Widget.OpenLinkInFirefoxBrowser("http://www.yahoo.com");
	}
	

	/*
	 * Implicit wait tell the web driver to poll the DOM for a certain time when
	 * trying to find an element when they are not immediately available it is
	 * applied to all elements in your script it is set for the life of the
	 * webDriver object instance keep trying until element is found
	 */
	public void ImplicitWaitExample() {
		Widget.firefoxdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Widget.firefoxdriver.navigate().to("http://www.google.com");
	}

}
