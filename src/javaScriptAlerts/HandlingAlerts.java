package javaScriptAlerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import widgets.Widget;

public class HandlingAlerts extends Widget {
	
	FirefoxDriver driver = firefoxdriver;

	WebDriverWait wait = new WebDriverWait(driver, 30);

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public void handleAlert() {
		driver.navigate().to("http://mistered.us/test/alert.shtml");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("form")));
		driver.findElement(By.xpath("html/body/div[1]/form/input")).click();

		Alert myAlert = driver.switchTo().alert();
		
		System.out.println("Alert txt "+myAlert.getText());
		myAlert.accept();
	}
}
