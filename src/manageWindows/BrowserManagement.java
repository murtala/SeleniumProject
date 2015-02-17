package manageWindows;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.firefox.FirefoxDriver;

import widgets.Widget;

public class BrowserManagement extends Widget {

	FirefoxDriver driver = firefoxdriver;
	
	public void WindowEvents(){
		driver.manage().window().maximize();
		System.out.println("Position of the window  relative to the upper left corner of the screen: "+ driver.manage().window().getPosition());
		System.out.println("size:"+ driver.manage().window().getSize());
		driver.manage().window().maximize();
		Point targetPosition = new Point(10, 8);
		driver.manage().window().setPosition(targetPosition);
		System.out.println("Position of the window  relative to the upper left corner of the screen: "+ driver.manage().window().getPosition());
		Dimension targetSize = new Dimension(600, 600);
		System.out.println("size: "+driver.manage().window().getSize());
		
	}
}
