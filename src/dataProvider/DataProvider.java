package dataProvider;
	
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;

	import org.openqa.selenium.WebDriver;

	import org.openqa.selenium.firefox.FirefoxDriver;

	import org.testng.annotations.Test;

public class DataProvider {
	
		private static WebDriver driver;
		@org.testng.annotations.DataProvider (name = "Authentication")
	  public static String[][] credentials() {

	        return new String[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" }};

	  }

	  // Here we are calling the Data Provider object with its Name

	  @Test(dataProvider = "Authentication")

	  public void test(String sUsername, String sPassword) {

		  System.out.println( sUsername  + " -- " +  sPassword );
		/*  driver = new FirefoxDriver();

	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	      driver.get("http://www.store.demoqa.com");

	      driver.findElement(By.xpath(".//*[@id='account']/a")).click();

	      driver.findElement(By.id("log")).sendKeys(sUsername);

	      driver.findElement(By.id("pwd")).sendKeys(sPassword);

	      driver.findElement(By.id("login")).click();

	      driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();

	      driver.quit();*/

	  }

	}
	
	
	


