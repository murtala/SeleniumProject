package practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;


public class NewTest {

static WebDriver driver;
  @Test
  public void scriptTest() {
	// driver = new FirefoxDriver();
	 System.setProperty("webdriver.chrome.driver", "G:\\Dev\\JAVA\\Libraries\\chrome-driver\\chromedriver.exe");
	   driver = new ChromeDriver();
	   driver.get("http://www.codylindley.com/jqueryselectors/");   
	   driver.findElement(By.id("toggleCustom")).click();
	   
	   takeScreenShot();
	   //selectAll();
	   openDocumentation1();
	   
	   
	
  }
  private void openDocumentation1() {
	  
	
}
private void selectAll() {

		//driver.findElement(By.xpath("//*[@id='toggleCustom']")).click();;;

	driver.findElement(By.xpath("//*[@id=\"customInput\"]")).sendKeys("Incoming keystrokes !");;
	
	Actions  action = new Actions(driver);
	action.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	action.build().perform();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	
	
	
	
}

private void takeScreenShot() {
	  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("G:\\Users\\Moortala\\workspace\\SeleniumProject\\src\\practice\\screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
}
@BeforeMethod
  public void beforeMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
	/*  try {
		driver.wait(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	  driver.quit();
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
