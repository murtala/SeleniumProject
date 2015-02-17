package tables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import widgets.Widget;

public class FindingElements extends Widget {

	
	public void findByCssTxt(){
		//theDriver.navigate().to("http://www.w3schools.com/html/html_tables.asp");
		
		//find the column containg specified text
		//System.out.println(theDriver.findElement(By.cssSelector("td[contains('Smith')]")).getTagName());
		//for other non firefox browsers
		//System.out.println(theDriver.findElement(By.cssSelector("td[innerText='Smith']")).getTagName());

		//for firefox browsers
		
		System.out.println(theDriver.findElement(By.cssSelector("td[textContent='Smith']")).getTagName());

	}
	
	public void findUsingJQuery(){
		
		
		//Create an instance of JavaScript Executor from driver
		JavascriptExecutor js = (JavascriptExecutor) theDriver;
		//Locate all the Checkbox which are checked by calling jQuery
		//find() method.
		//find() method returns elements in array
		List<WebElement> elements = (List<WebElement>)
		js.executeScript("return jQuery.find(':checked')");
	}
}
