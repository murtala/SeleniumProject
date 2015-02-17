package mouseOver;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import widgets.Widget;

public class LifeLockPage extends Widget{

	
	WebDriverWait wait = new WebDriverWait(theDriver, 30);

	public void openHome(String url) {
		theDriver.get(url);
	}

	public void hovernMenu() throws InterruptedException {

		Actions action = new Actions(theDriver);

		WebElement toElement = theDriver.findElement(By.xpath("//*[@id='silver-menu']/li[1]/a/span"));
		action.moveToElement(toElement);
		System.out.println("Menu:  " + toElement.getText());
		action.build().perform();

		Thread.sleep(5000);
		toElement = theDriver.findElement(By.xpath("//*[@id='silver-menu']/li[1]/ul/li[1]/a"));
		action.moveToElement(toElement);
		System.out.println("Menu Item:  " + toElement.getText());
		action.build().perform();

		Thread.sleep(2000);
		toElement = theDriver.findElement(By.xpath("//*[@id='silver-menu']/li[1]/ul/li[2]/a"));
		action.moveToElement(toElement);
		System.out.println("Menu Item:  " + toElement.getText());
		action.build().perform();

		Thread.sleep(2000);
		toElement = theDriver.findElement(By.xpath("//*[@id='silver-menu']/li[1]/ul/li[3]/a"));
		action.moveToElement(toElement);
		System.out.println("Menu Item:  " + toElement.getText());
		action.build().perform();

		Thread.sleep(2000);
		toElement = theDriver.findElement(By.xpath("//*[@id='silver-menu']/li[1]/ul/li[4]/a"));
		action.moveToElement(toElement);
		System.out.println("Menu Item:  " + toElement.getText());
		action.build().perform();

		Thread.sleep(2000);
		toElement = theDriver.findElement(By.xpath("//*[@id='silver-menu']/li[1]/ul/li[5]/a"));
		action.moveToElement(toElement);
		System.out.println("Menu Item:  " + toElement.getText());
		action.build().perform();

		Thread.sleep(2000);
		toElement = theDriver.findElement(By.xpath("//*[@id='silver-menu']/li[1]/ul/li[6]/a"));
		action.moveToElement(toElement);
		System.out.println("Menu Item:  " + toElement.getText());
		action.build().perform();

		Thread.sleep(2000);
		toElement = theDriver.findElement(By.xpath("//*[@id='silver-menu']/li[1]/ul/li[7]/a"));
		action.moveToElement(toElement);
		System.out.println("Menu Item: " + toElement.getText());
		action.build().perform();
		Thread.sleep(5000);

	}

	public void getMenusList() {   

		Actions action = new Actions(theDriver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("silver-menu")));
		WebElement toElement = theDriver.findElement(By.xpath("//*[@id='silver-menu']/li[1]/a/span"));
		action.moveToElement(toElement);
		action.build().perform();

		List<WebElement> menuItems = theDriver.findElements(By.xpath(".//*[@id='silver-menu']/li[1]/ul/li"));
		System.out.println("size: " + menuItems.size());

		for (int i = 1; i < menuItems.size() + 1; i++) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("silver-menu")));
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			toElement = theDriver.findElement(By.xpath("//*[@id='silver-menu']/li[1]/a/span"));
			action.moveToElement(toElement);
			action.build().perform();
			theDriver.findElement(By.xpath(".//*[@id='silver-menu']/li[1]/ul/li[" + i + "]/a")).click();
			System.out.println(theDriver.getCurrentUrl());
		}

		// driver.quit();

	}

	public void getMenusLists() {

		// get menus items
		List<WebElement> menus = theDriver.findElements(By.xpath(".//*[@id='silver-menu']/li"));

		for (int i = 1; i < menus.size()+ 1; i++) {
			Actions action = new Actions(theDriver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("silver-menu")));
			WebElement toElement = theDriver.findElement(By.xpath("//*[@id='silver-menu']/li[" + i + "]/a/span"));
			action.moveToElement(toElement);
			action.build().perform();

			// get sub menus items
			List<WebElement> menuItems = theDriver.findElements(By.xpath(".//*[@id='silver-menu']/li[" + i + "]/ul/li"));
			System.out.println("size: " + menuItems.size());
			// goes through submenus
			for (int j = 1; j < menuItems.size() + 1; j++) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("silver-menu")));
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//moves the mouse 
				toElement = theDriver.findElement(By.xpath("//*[@id='silver-menu']/li["+i+"]/a/span"));
				action.moveToElement(toElement);
				action.build().perform();
				theDriver.findElement(By.xpath(".//*[@id='silver-menu']/li["+i+"]/ul/li[" + j + "]/a")).click();
				System.out.println(theDriver.getCurrentUrl());
			}

			// driver.quit();

		}

	}
	public void close()
	{
		theDriver.quit();
	}
	
}
