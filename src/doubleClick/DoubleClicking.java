package doubleClick;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import widgets.Widget;

public class DoubleClicking extends Widget{

	public void doubleClick(){
		  Widget.OpenLink("file:///G:/Users/Moortala/workspace/SeleniumProject/web/DoubleClickDemo.html");
		  WebElement message = theDriver.findElement(By.id("message"));
		//  G:\Dev\JAVA\Java Files
		  Actions action = new Actions(theDriver);
		  action.doubleClick(message);
		  action.build().perform();
	}
}
