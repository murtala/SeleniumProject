package practice;

import org.apache.log4j.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty7.util.log.Log;

public class WebDriverDemo {

	public static void main(String[] args) throws Exception {

		// open a firefox browser, need to create a firefox browser instance
		WebDriver wd = new FirefoxDriver();// open FF browser
		wd.get("http://www.orbitz.com");
		wd.findElement(By.xpath("//*[@value='air']")).click();
		Log.info("Clicking on Advanced Search button");
		Thread.sleep(10000);
		wd.findElement(By.name("ar.rt.leaveSlice.orig.key")).clear();
		Thread.sleep(1000);
		wd.findElement(By.name("ar.rt.leaveSlice.orig.key")).sendKeys("sfo");
		Thread.sleep(100);
		wd.findElement(By.name("ar.rt.leaveSlice.orig.key")).click();
		Thread.sleep(1000);
		wd.findElement(By.name("ar.rt.leaveSlice.dest.key")).clear();
		Thread.sleep(1000);
		wd.findElement(By.name("ar.rt.leaveSlice.dest.key")).sendKeys("la");
		Thread.sleep(100);
		wd.findElement(By.name("ar.rt.leaveSlice.dest.key")).click();
		Thread.sleep(100);
		wd.findElement(By.name("ar.rt.leaveSlice.date")).click();
		Thread.sleep(100);
		wd.findElement(By.xpath("//*[@class='today']")).click();
		Thread.sleep(100);
		wd.findElement(By.name("ar.rt.returnSlice.date")).click();
		Thread.sleep(100);
		wd.findElement(By.xpath("//*[@data-date='2013-6-26']")).click();
		Thread.sleep(100);
		Log.info(" THE END");

		wd.findElement(By.name("search")).click();
		
		WebDriverWait wait = new WebDriverWait(wd,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultsTwoColumn")));//check if availabe  and then run next, if not the sleep again for 60
		// wd.findElement(By.xpath("//*[@class='money-symbol']")).getText();
		//xpath=//span[@class='money small-cents']
		String price = wd.findElement(By.xpath("//span[@class='money small-cents']")).getText();
		System.out.println("The price is: " + price);

	}

}
