package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverDemo_3 {

	public static void main(String[] args) throws Exception {

		String[][] data;

		HashMap map = new HashMap();
		data = ReadExcel();
		double price;
		int len = data.length;
		for (int i = 1; i < data.length; i++) {
			price = FindPrice(data[i][0], data[i][1]);
			String itin = "Price for flight from " + data[i][0] + " to " + data[i][1] + " is: " + price;

			map.put(price, itin);
		}

		ArrayList al = new ArrayList(map.keySet());
		Collections.sort(al);
		System.out.println("The minimum fare is " + al.get(0) + " , and the dest is " + map.get(al.get(0)) );

	}

	public static String[][] ReadExcel() throws Exception {

		File excel = new File("src\\selenium\\Data.xls");
		FileInputStream fis = new FileInputStream(excel);

		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet ws = wb.getSheet("Sheet1");

		int rowNum = ws.getLastRowNum() + 1;// +1 to start reading from row1,
											// row 0 in the xcel sheet is just
											// the column names
		int colNum = ws.getRow(0).getLastCellNum();// total # of ceels

		String[][] data = new String[rowNum][colNum];

		for (int i = 0; i < rowNum; i++) {
			HSSFRow row = ws.getRow(i);
			for (int j = 0; j < colNum; j++) {
				HSSFCell cell = row.getCell(j);
				String value = cellToString(cell);// convert the cell to String
				data[i][j] = value;
				System.out.println("The value is: " + value);
			}
		}
		// return null;
		return data;

	}

	private static String cellToString(HSSFCell cell) throws Exception {
		int type;
		Object result;
		type = cell.getCellType();

		switch (type) {
		case 0:// numeric value in excel
			result = cell.getNumericCellValue();
			break;
		case 1: // string value in excel
			result = cell.getStringCellValue();
			break;
		case 2: // boolean value in excel
			result = cell.getBooleanCellValue();
			break;
		default:
			throw new Exception("There are not support for this type of   cell");
		}

		return result.toString();
	}

	private static double FindPrice(String dep, String dest) throws InterruptedException {
		// open a firefox browser, need to create a firefox browser instance
		WebDriver wd = new FirefoxDriver();// open FF browser
		WebDriverWait wait = new WebDriverWait(wd, 60);

		wd.get("http://www.orbitz.com");
		wd.findElement(By.xpath("//*[@value='air']")).click();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("homeWideCenterSpot")));//check
		// if availabe and then run next, if not the sleep again for 60

		Thread.sleep(10000);
		wd.findElement(By.name("ar.rt.leaveSlice.orig.key")).clear();
		Thread.sleep(1000);
		wd.findElement(By.name("ar.rt.leaveSlice.orig.key")).sendKeys(dep);
		Thread.sleep(100);
		wd.findElement(By.name("ar.rt.leaveSlice.orig.key")).click();
		Thread.sleep(1000);
		wd.findElement(By.name("ar.rt.leaveSlice.dest.key")).clear();
		Thread.sleep(1000);
		wd.findElement(By.name("ar.rt.leaveSlice.dest.key")).sendKeys(dest);
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

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultsTwoColumn")));// check
																								// if
																								// availabe
																								// and
																								// then
																								// run
																								// next,
																								// if
																								// not
																								// the
																								// sleep
																								// again
																								// for
																								// 60
		// wd.findElement(By.xpath("//*[@class='money-symbol']")).getText();
		// xpath=//span[@class='money small-cents']
		String price = wd.findElement(By.xpath("//span[@class='money small-cents']")).getText().replace("$", "");
		System.out.println("The price is: " + price);
		return Double.parseDouble(price);
	}

}
