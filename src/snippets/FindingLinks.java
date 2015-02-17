package snippets;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import widgets.Widget;

public class FindingLinks extends Widget {

	FirefoxDriver driver = firefoxdriver;
	public void findAlllinks(){
		
		//Get all the links displayed on Page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		//Verify there are four links displayed on the page
	//	assertEquals(4, links.size());
		//Iterate though the list of links and print
		//target for each link
		for(WebElement link : links)
		System.out.println(link.getAttribute("href"));
	}
}
