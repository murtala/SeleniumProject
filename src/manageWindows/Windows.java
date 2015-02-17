package manageWindows;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import widgets.Widget;

public class Windows extends Widget {
	FirefoxDriver driver = firefoxdriver;

	public void switchWindow(){
		driver.navigate().to("http://www.pogo.com/misc/popup-blocker-test.jsp");
		driver.findElement(By.linkText("Test for pop-up blockers.")).click();
		String mainwindow = driver.getWindowHandle();
		
		Set<String> windows = driver.getWindowHandles();
		
		/*System.out.println("Size: "+windows.size());
		for (String window :windows){
			System.out.println("window: "+window);

		}*/
		for (Iterator iterator = windows.iterator(); iterator.hasNext();) {
			String window = (String) iterator.next();
			System.out.println("window1: "+window);
			driver.switchTo().window(window);
			System.out.println(driver.findElement(By.xpath("//*[@id='white']/div[2]/strong")).getText());
		}
		driver.quit();
	}
}
