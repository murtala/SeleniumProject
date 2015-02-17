package screenshots;

import html5.WebElementExtender;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import widgets.Widget;

public class ScreenshotTests {
	
	WebDriver driver;
	
	@Before
	public void setUp()
	{
		Widget.OpenLinkInChromeBrowser("http://www.google.com");
		 driver = Widget.driver;
	}
  
	@Test
	public void testTakesScreenshot()
	{
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("G:\\Users\\Moortala\\workspace\\SeleniumProject\\src\\screenshots\\main_page.png"));
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
  
	@Test
	public void testElementScreenshot(){
	    
		WebElement pmoabsdiv = driver.findElement(By.className("ctr-p"));
	    
	    try {
	    	FileUtils.copyFile(WebElementExtender.captureElementBitmap(pmoabsdiv), new File("G:\\Users\\Moortala\\workspace\\SeleniumProject\\src\\screenshots\\div.png"));
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	  }
	
	@After
	public void teadDown()
	{
		driver.close();
		driver.quit();
	}
  
}