package javasScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.seleniumhq.jetty7.util.log.Log;

import static org.junit.Assert.*;

import org.junit.Test;

import widgets.Pather;
import widgets.Widget;

public class ExecuteJavaScript1 {
	@Test
	public void testJavaScriptCalls() throws Exception
	{
		Widget.OpenLinkInChromeBrowser("http://www.google.com");
		WebDriver driver = Widget.driver;
		driver.get("http://www.google.com");
		
		//get source code of an element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		String elementId = "gsr";
		String html =(String) js.executeScript("return document.getElementById('" + elementId + "').innerHTML;");
		
		System.out.println(html);
			
		driver.close();
			
	}
}