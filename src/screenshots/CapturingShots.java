package screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;

public class CapturingShots {

	WebDriver driver = new FirefoxDriver();

	public void getScreenShot() throws IOException {
		driver.get("http://www.google.com/");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Now you can do whatever you need to do with it, for example copy
		// somewhere

		FileUtils.copyFile(scrFile, new File("G:\\Users\\Moortala\\workspace\\SeleniumProject\\src\\screenshots\\screenshot.png"));

	}

	public void getScreenShotSelRC() throws IOException {
		driver.get("http://www.google.com/");

		driver = new Augmenter().augment(driver);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("G:\\Users\\Moortala\\workspace\\SeleniumProject\\src\\screenshots\\screenshot.png"));
	}
}
