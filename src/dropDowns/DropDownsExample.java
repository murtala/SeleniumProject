package dropDowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.Select;

import widgets.Widget;

public class DropDownsExample extends Widget {

	
	WebDriver driver  =theDriver;
	
	public void dropDownMenu() throws Exception {
		
		
		System.out.println("-------------Drop down menus-------------------");
		driver.navigate().to("http://www.w3schools.com/html/tryit.asp?filename=tryhtml_select2");
		WebDriver frame = driver.switchTo().frame("iframeResult");
		Thread.sleep(5000);
		Select select = new Select(frame.findElement(By.name("cars")));
		System.out.println("size " + select.getOptions().size());
		System.out.println("options " + select.getOptions());

		// select visible text
		select.selectByVisibleText("Saab");
		Thread.sleep(5000);
		select.selectByValue("fiat");
		Thread.sleep(5000);
		//slect by index number
		select.selectByIndex(3);
		Thread.sleep(5000);
		//get the first selected value
		System.out.println("val" +select.getFirstSelectedOption());
		
		List<WebElement> collection = select.getOptions();
		
		for (int i=0; i< collection.size(); i++){
			System.out.println(collection.get(i).getText());
		}
		//collection.get(i)
	//	for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
		//	String type = (String) iterator.next();
			//String type = (String) iterator.next();
//System.out.println(iterator.next().);
			
		//}


	}
	
	
	public void testMultipleSelectList() throws InterruptedException
	{
		driver.get("file:///F:/JAVA/QA/Java%20Files/DoubleClickDemo.htm");

		// get the drop down menu
		Select color = new Select(driver.findElement(By.name("color")));
		
		//verify if multi select
		System.out.println(color.isMultiple());
		// get number of options
		color.getOptions().size();
		//Select multiple options in the list using visible text
		color.selectByVisibleText("Black");
		color.selectByVisibleText("Red");
		color.selectByVisibleText("Silver");
		
		//get all selected options
		List<WebElement> options = color.getAllSelectedOptions();
		for( WebElement option: options){
			
			System.out.println("selected: "+ option.getText());
		}
		
		
		//Deselect an option using visible text
		color.deselectByVisibleText("Silver");
		//Deselect an option using value attribute of the option
		color.deselectByValue("rd");
		//Deselect an option using index of the option
		color.deselectByIndex(0);
		Thread.sleep(3000);
		//deselect everything
		color.deselectAll();
		
	}
}
