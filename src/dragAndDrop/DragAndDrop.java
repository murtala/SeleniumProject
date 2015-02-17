package dragAndDrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import widgets.Widget;

public class DragAndDrop extends Widget {

	WebDriver driver;

	public void DragAndDropAPIexample() throws InterruptedException {

		// System.setProperty("webdriver.chrome.driver","F:/JAVA/Libraries/chromedriver_win32_2.0/chromedriver.exe");
		// driver= new ChromeDriver();
		driver = theDriver;
		Actions action = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		driver.get("http://www.w3schools.com/html/html5_draganddrop.asp");
		//driver.get("file:///F:/JAVA/QA/Java%20Files/jQuery%20UI%20Droppable%20-%20Default%20functionality.htm");

		Thread.sleep(10000);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//*[@id='main'"))));

		
		
		
		
	
		// define source
		WebElement source = driver.findElement(By.id("drag1"));
		//WebElement source = driver.findElement(By.id("draggable"));

		// define target
		WebElement target = driver.findElement(By.id("div2"));
		//WebElement target = driver.findElement(By.id("droppable"));

		Thread.sleep(1000);
		// drag and drop
		action.dragAndDrop(source, target).perform();

	}

	public void DragAndDropExample() throws InterruptedException {
		// driver= new ChromeDriver();
		driver = new FirefoxDriver();
		driver.get("http://www.w3schools.com/html/html5_draganddrop.asp");


		WebDriverWait wait = new WebDriverWait(driver, 30);
		Actions action = new Actions(driver);

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("main")));

		// define source
		WebElement source = driver.findElement(By.id("drag1"));
		// define target

		WebElement target = driver.findElement(By.id("div2"));
		// drag and drop
		action.clickAndHold(source);
		action.moveToElement(target);
		Thread.sleep(10000);
		action.release(target);
		action.build().perform();

	}

}
