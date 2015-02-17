package handlePopUps;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import widgets.Widget;

public class PogoHome extends Widget {

	// http://www.pogo.com/misc/popup-blocker-test.jsp

	WebDriver driver = theDriver;

	public void homePage() {
		driver.get("http://www.popuptest.com/goodpopups.html");
	}

	public void openPopUps() throws InterruptedException {
		Thread.sleep(100);
		driver.findElement(By.linkText("Good PopUp #1")).click();
		driver.findElement(By.linkText("Good PopUp #3")).click();
		driver.findElement(By.linkText("Good PopUp #4")).click();

		
	}

	public void handlePopUp() throws InterruptedException {

		
		//with many pop ups, when close 1, control still stays there, will give  not found error
		//closing a pop up will not automatically switch to another window
		// Save the WindowHandle of Parent Browser Window
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			Thread.sleep(3000);
			WebDriver popup = driver.switchTo().window(window);
			System.out.println("Title: " + popup.getTitle() + " url: " + popup.getCurrentUrl() + " handle :"+ popup.getWindowHandle() + "Current Page"+driver.getCurrentUrl());
			driver.switchTo().window(window).get("http://google.com");
		}

		
		driver.switchTo().window(mainWindowHandle);// return to main window
	}
}
