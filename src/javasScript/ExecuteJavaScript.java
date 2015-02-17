package javasScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.seleniumhq.jetty7.util.log.Log;

import static org.junit.Assert.*;

import org.junit.Test;

import widgets.Pather;
import widgets.Widget;

public class ExecuteJavaScript {
	@Test
	public void testJavaScriptCalls() throws Exception
	{
		Widget.OpenLinkInChromeBrowser("http://www.google.com");
		WebDriver driver = Widget.driver;
		driver.get("http://www.google.com");
			
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		String title = (String) js.executeScript("return document.title");
		assertEquals("Google", title);
		
		long links = (Long) js.executeScript("var links = document.getElementsByTagName('A'); return links.length");
		System.out.println(links);
		assertEquals(43, links);
			
		driver.close();
			
	}
}