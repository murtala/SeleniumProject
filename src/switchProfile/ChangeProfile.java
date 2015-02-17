package switchProfile;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import widgets.Widget;

public class ChangeProfile extends Widget {

	File profileDir = new File("C:\\Users\\Mobile\\AppData\\Local\\Mozilla\\Firefox\\Profiles\\76fw85zm.default");
	FirefoxDriver driver;
	public void switchProfile() {
		 profile = new FirefoxProfile(profileDir);
	}
}
