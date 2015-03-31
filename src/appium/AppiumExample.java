package appium;


import java.net.MalformedURLException;
import java.net.URL;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppiumExample {
WebDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Nexus4");
		capabilities.setCapability("androidPackage", "net.murtala.shakeandwave");
		capabilities.setCapability("appActivity", "ShakeAndWave");

		driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub/"), capabilities);
	}
	
	@Test
	public void Cal(){
		//driver.findElement(By.name("Weather")).click();
	}
	
	@AfterClass
	public void tearDown(){
		//driver.quit();
	}
	
	
}
