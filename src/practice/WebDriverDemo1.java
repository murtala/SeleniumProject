package practice;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverDemo1 {

	public static void main(String[] args) throws Exception {
		
		double price1;
		double price2;
		
		price1 = FindPrice("DFW");
		System.out.println("Price 1=" + price1);
		price2 = FindPrice("ORD");
		System.out.println("Price 2=" + price2);

		if ( price1>price2){
			System.out.println("ORD");
		}else{
			System.out.println("DFW");

		}

	}

	private static double FindPrice(String prices) throws InterruptedException {
		// 

		// open a firefox browser, need to create a firefox browser instance
		WebDriver wd = new FirefoxDriver();// open FF browser
		WebDriverWait wait = new WebDriverWait(wd,60);

		wd.get("http://www.orbitz.com");
		wd.findElement(By.xpath("//*[@value='air']")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("homeWideCenterSpot")));//check if availabe  and then run next, if not the sleep again for 60

		Thread.sleep(10000);
		wd.findElement(By.name("ar.rt.leaveSlice.orig.key")).clear();
		Thread.sleep(1000);
		wd.findElement(By.name("ar.rt.leaveSlice.orig.key")).sendKeys(prices);
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
		wd.findElement(By.xpath("//*[@data-date='2013-6-19']")).click();
		Thread.sleep(100);
		wd.findElement(By.name("ar.rt.returnSlice.date")).click();
		Thread.sleep(100);
		wd.findElement(By.xpath("//*[@data-date='2013-6-26']")).click();
		Thread.sleep(100);
		wd.findElement(By.name("search")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultsTwoColumn")));//check if availabe  and then run next, if not the sleep again for 60
		// wd.findElement(By.xpath("//*[@class='money-symbol']")).getText();
		//xpath=//span[@class='money small-cents']
		String price = wd.findElement(By.xpath("//span[@class='money small-cents']")).getText().replace("$", "");
		System.out.println("The price is: " + price);
		return Double.parseDouble(price);
	}

}
