package doubleClick;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoubleClickTest {
	@Test
	public void testDoubleClick() throws Exception
	{
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.get("file:///G:/Users/Moortala/workspace/SeleniumProject/web/DoubleClickDemo.html");
			
		WebElement message = driver.findElement(By.id("message"));
			
		//Verify color is Blue
		assertEquals("rgb(0, 0, 255)",message.getCssValue("background-color").toString());
		
		Actions   builder = new Actions(driver);
		builder.doubleClick(message).build().perform();
		//ok
		//Verify Color is Yellow
		assertEquals("rgb(255, 255, 0)",message.getCssValue("background-color").toString());
		
		driver.close();
	}
}