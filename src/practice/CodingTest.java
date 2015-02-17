package practice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CodingTest {
	
	public static void main(String[] args) {
		
		WebDriver driver= new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		//search Google for "12345"
		driver.get("http://www.google.com");
		driver.findElement(By.id("gbqfq")).sendKeys("12345");
		driver.findElement(By.id("gbqfq")).sendKeys(Keys.ENTER);
		
		//verify result page
		assertEquals( "Google", driver.getTitle());
		
		//verify image (map) link
		assertTrue(driver.findElement(By.xpath("//a//img[contains(@id,'lu_map')]")).isDisplayed());
		
		//verify link starts with "http://www.google.com/maps/place"
		assertTrue(driver.findElement(By.xpath("//div[@id='rhs_block']//a")).getAttribute("href").toString().startsWith("https://www.google.com/maps/place"));

		//verify The search box contains the text "12345"
		assertEquals("12345",driver.findElement(By.id("gbqfq")).getAttribute("value"));

	}

}
