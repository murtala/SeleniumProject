package tables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import widgets.Widget;

public class TableExample extends Widget {

	WebDriver driver;

	public void printAllRows() {
		driver = new FirefoxDriver();
		driver.get("file:///G:/Users/Moortala/workspace/SeleniumProject/web/Locators.html");

		WebElement simpleTable = driver.findElement(By.id("items"));

		// Get all rows
		List<WebElement> rows = simpleTable.findElements(By.tagName("tr"));
		// assertEquals(3, rows.size());

		// Print data from each row
		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for (WebElement col : cols) {
				System.out.print(col.getText() + "\t");
			}
			System.out.println();
		}

		// using css to locate the first cell of the second row in the table:
		WebElement cellcss = driver.findElement(By.cssSelector("table#items tbody tr:nth-child(2) td"));

		// using xpath
		WebElement cellxpath = driver.findElement(By.xpath("//table[@id='items']/tbody/tr[2]/td"));

		//Finding child elements with dynamic ids and CSS
	//	WebElement adminCheckBoxCSS = driver.findElement(By.cssSelector("td:contains('Nash')+td+td>div>label:contains('Admin')+input"));
	//	adminCheckBoxCSS.click();

		//Finding child elements with dynamic id and xpath
		WebElement adminCheckBoxXpath = driver.findElement(By.xpath("//td[contains(text(),'Nash')]/following-sibling::td/descendant::div/label[contains(text(),'Admin')]/following-sibling::input"));
		adminCheckBoxXpath.click();

	}
}
