package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Travelocity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver wd = new FirefoxDriver();
		WebDriverWait wdw = new WebDriverWait(wd, 60);
		wd.get("http://www.travelocity.com/");
		// origin box
		wd.findElement(By.id("fo-from")).clear();
		wd.findElement(By.id("fo-from")).click();
		wd.findElement(By.id("fo-from")).sendKeys("SFO");
		// destination box
		wd.findElement(By.id("fo-to")).clear();
		wd.findElement(By.id("fo-to")).click();
		wd.findElement(By.id("fo-to")).sendKeys("DFW");
		// departure date
		wd.findElement(By.id("fo-fromdate")).clear();
		wd.findElement(By.id("fo-fromdate")).sendKeys("07/15/2013");
		// arrival date
		wd.findElement(By.id("fo-todate")).clear();
		wd.findElement(By.id("fo-todate")).sendKeys("07/20/2013");
		// click search
		wd.findElement(By.xpath("//*[@class='btn_alt']")).click();
		wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='amt']")));
		String price = wd.findElement(By.xpath("//div[@class='amt']")).getText();
		System.out.println(price);
		wd.close();

	}

}
