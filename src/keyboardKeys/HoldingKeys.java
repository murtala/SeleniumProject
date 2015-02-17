package keyboardKeys;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import widgets.Widget;

public class HoldingKeys extends Widget {

	public void selectMultipleTableRows() throws InterruptedException{
		
		  Widget.OpenLink("http://www.w3schools.com/html/html_tables.asp");
			WebElement sampleTable = theDriver.findElement(By.xpath("//*[@id='main']/table[1]"));

			//Select second and fourth row from table using Control Key.
			//Row Index start at 0
			Actions action = new Actions(theDriver);
			
			WebElement row1col1 = theDriver.findElement(By.xpath(".//*[@id='main']/table[1]/tbody/tr[1]/th[1]"));
			WebElement row2col2 = theDriver.findElement(By.xpath(".//*[@id='main']/table[1]/tbody/tr[2]/td[2]"));
			WebElement row5col5 = theDriver.findElement(By.xpath(".//*[@id='main']/table[1]/tbody/tr[5]/td[3]"));
			
			action.moveToElement(row1col1);
			action.click(row1col1);
			action.keyDown(Keys.CONTROL);
			action.click(row1col1);
			Thread.sleep(5000);
			action.moveToElement(row5col5);
			action.click(row5col5);
			action.keyUp(Keys.CONTROL);
			action.build().perform();
			Thread.sleep(5000);
			//.click(row2col2).click(row5col5 ).keyUp(Keys.CONTROL).build().perform();
			
			
			
	}
	
	
}
