package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	
	static WebDriver driver;
	
	public void locate(){
		// driver = new FirefoxDriver();
		 System.setProperty("webdriver.chrome.driver", "G:\\Dev\\JAVA\\Libraries\\chrome-driver\\chromedriver.exe");
		   driver = new ChromeDriver();
		   driver.get("file:///G:/Dev/JAVA/Java%20Files/Jquery%20Selectors.html");   
		 //   driver.get("http://www.codylindley.com/jqueryselectors/"); 
		   
		   //fidn by id
		   driver.findElement(By.id("toggleCustom")).click();
		   //find by xpath
		   driver.findElement(By.xpath("//*[@id='container']/div//form/div/select/option[3]")).click();
		   //by css
		   driver.findElement(By.cssSelector("#container > div > div.domtree > form > div:nth-child(1) > div:nth-child(4) > select > option:nth-child(3)")).click();
		   // by class name
		   driver.findElement(By.className("left")).click();

		   
		   
	}

}
