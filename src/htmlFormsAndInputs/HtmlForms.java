package htmlFormsAndInputs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HtmlForms {
	WebDriver driver = new FirefoxDriver();

	String url = "http://www.w3schools.com/html/html_forms.asp";

	public void openHomePage() {
		driver.get(url);
	}

	public void passwordField() throws Exception {
		System.out.println("------------Password fields--------------------");

		driver.findElement(By.name("pwd")).sendKeys("hello");
		System.out.println("Password is: " + driver.findElement(By.name("pwd")).getText());
		System.out.println("Password 1 is: " + driver.findElement(By.name("pwd")).getAttribute("value"));
		Thread.sleep(5000);
	}

	public void radioButtons() throws Exception {
		System.out.println("-------------Radio buttons-------------------");

		driver.findElement(By.xpath(".//*[@id='main']/form[3]/input[1]")).click();
		System.out.println(driver.findElement(By.xpath(".//*[@id='main']/form[3]/input[2]")).isSelected());
		System.out.println(driver.findElement(By.xpath(".//*[@id='main']/form[3]/input[1]")).getAttribute("value"));
		System.out.println(driver.findElement(By.xpath(".//*[@id='main']/form[3]/input[2]")).getAttribute("value"));
		Thread.sleep(5000);

		driver.findElement(By.xpath(".//*[@id='main']/form[3]/input[2]")).click();
		System.out.println(driver.findElement(By.xpath(".//*[@id='main']/form[3]/input[1]")).isSelected());
		System.out.println(driver.findElement(By.xpath(".//*[@id='main']/form[3]/input[2]")).isSelected());

		// using js
		// WebElement one_way =
		// (WebElement)((JavascriptExecutor)dr).executeScript("return document.getElementById('oneway_r') ;");
		Thread.sleep(5000);
	}

	public void checkBoxes() throws Exception {
		System.out.println("------------check Boxes--------------------");
		driver.findElement(By.xpath("//*[@id='main']/form[4]/input[1]")).click();
		driver.findElement(By.xpath("//*[@id='main']/form[4]/input[2]")).click();

		System.out.println(driver.findElement(By.xpath("//*[@id='main']/form[4]/input[2]")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@id='main']/form[4]/input[2]")).getAttribute("value"));

		Thread.sleep(5000);
	}

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
}
