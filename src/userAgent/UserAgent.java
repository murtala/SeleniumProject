package userAgent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import widgets.Widget;

public class UserAgent extends Widget {

	public static FirefoxDriver driver;

	public static void switchTo(String userAgentString) {
		System.out.println("http://www.useragentstring.com/index.php");
		profile.setPreference("general.useragent.override", userAgentString);
		driver = firefoxdriver;
		driver = new FirefoxDriver(profile);
	}
}
