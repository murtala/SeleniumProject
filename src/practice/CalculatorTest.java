package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalculatorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Calculator c = new Calculator();
		//int result = c.add(1, 1);
		//if (result != 2) {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		//
		driver.findElement(By.id("gbqfq")).sendKeys("12345");
		driver.findElement(By.id("gbqfq")).sendKeys(Keys.ENTER);
		
		//The results page appears
		driver.getTitle().contains("Google");
		//image link in the map
		driver.findElement(By.xpath(".//img[contains(@id,'lu_map')]"));
		//The link's url starts with "http://www.google.com/maps/place"
		driver.findElement(By.linkText("Maps")).getAttribute("href").contains("http://www.google.com/maps/place");
	    //The search box contains the text "12345"
		driver.findElement(By.id("gbqfq")).getText();
		
		}
	}


