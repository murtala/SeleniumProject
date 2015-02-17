package javasScript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import widgets.Widget;

public class SelJavaScriptExample extends Widget {
	// WebDriver driver = new FirefoxDriver();

	String script = "document.write(Date());";
	String script1 = "alert(Date());";
	String script2 = "return document.title;";

	FirefoxDriver driver = firefoxdriver;

	WebDriverWait wait = new WebDriverWait(driver, 30);

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public void executingAsyncScripts() {
		driver.navigate().to("http://mistered.us/test/alert.shtml");

		//exceuteasync Script doesnt block excution of next line, it runs and go the next line
		js.executeAsyncScript("setInterval(function(){ alert('Hello');},3000); ");
		
	}

	public void executingScripts() {
		// executeScript will block line execution of code until it is finished
		js.executeScript(script1);
		System.out.println("exceuteScript completed");
	}

	

	public void DisplayDate() {

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		js.executeScript(script);
	}

	public void DisplayDateAlert() {
		js.executeScript(script1);
	}

}
