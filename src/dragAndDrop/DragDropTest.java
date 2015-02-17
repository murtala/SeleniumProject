package dragAndDrop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import widgets.Pather;
import widgets.Widget;
import static org.junit.Assert.*;

public class DragDropTest {
	
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp()
	{
		//driver = new FirefoxDriver();
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testDragDrop() {
		
		Widget.OpenLinkInChromeBrowser(Pather.getLoc("DragDropDemo.html"));
		driver = Widget.driver;
		//driver.get(Pather.getLoc("DoubleClickDemo.html"));
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		Actions builder = new Actions(driver);
		builder.dragAndDrop(source, target) .perform();
		try
		{
			assertEquals("Dropped!", target.getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}