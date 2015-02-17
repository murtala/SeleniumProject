package navigation;

import org.openqa.selenium.firefox.FirefoxDriver;

import widgets.Widget;

public class navigating extends Widget {

	FirefoxDriver driver = firefoxdriver;

	public void navigation() throws InterruptedException{
		driver.navigate().to("http://www.yahoo.com");
		driver.navigate().refresh();
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().forward();
	}
}
