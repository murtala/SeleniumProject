package keyboardKeys;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import widgets.Widget;

public class TypeKeys extends Widget {
	FirefoxDriver driver = firefoxdriver;
	WebDriverWait wait = new WebDriverWait(driver, 30);

	public void keyTyping() throws InterruptedException {
		//driver.navigate().to("http://www.google.com");
		//driver.findElement(By.id("gbqfq")).sendKeys(Keys.TAB);
		//Thread.sleep(3000);
		//driver.findElement(By.id("gbqfq")).sendKeys(Keys.TAB);
		//driver.findElement(By.id("gbqfq")).sendKeys(Keys.SPACE);
		
		//send multiple keys
		driver.findElement(By.id("gbqfq")).sendKeys(Keys.chord("Dota2",Keys.ENTER));
		Thread.sleep(3000);

		driver.navigate().back();
		driver.findElement(By.id("gbqfq")).sendKeys(Keys.chord(Keys.TAB, Keys.TAB, Keys.SPACE));
	
	}
}
