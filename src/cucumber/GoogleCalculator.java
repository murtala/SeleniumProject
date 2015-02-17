package cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleCalculator {
	
	public static  WebDriver driver = new FirefoxDriver();
	
	WebElement textBox;
	static WebElement calcInput;
	public void goToHomePage(String url){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	public void search(String query){
		textBox = driver.findElement(By.id("gbqfq"));
		textBox.sendKeys(query);	
		textBox.sendKeys(Keys.ENTER);
	}
	
	public void operation(String operations){
		//driver.findElement(By.id("cwos")).click();
		 calcInput = driver.findElement(By.id("cwos"));
		 driver.findElement(By.id("cwos")).click();
		calcInput.sendKeys(Keys.chord("5" , Keys.ADD , "7", Keys.ENTER));
		//textBox = driver.findElement(By.id("gbqfq"));
		//textBox.clear();
		//textBox.sendKeys(operations);	
		//textBox.sendKeys(Keys.ENTER);
		
		
	}
	
	public void results(){
		System.out.println("RES " + calcInput.getText());
	}

}
