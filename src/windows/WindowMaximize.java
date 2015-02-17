package windows;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import widgets.Widget;

public class WindowMaximize {
	@Test
	public void testRowSelectionUsingControlKey() throws Exception {
		Widget.OpenLinkInChromeBrowser("http://www.google.com");
		WebDriver driver = Widget.driver;
		
		//driver.get("http://www.google.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.manage().window().getPosition();
		driver.quit();
	}
}
