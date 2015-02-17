package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import windowsUtils.WindowsRegistry;

public class MyClass {
	
	

	 public static void main(String[] args) {
	        // declaration and instantiation of objects/variables
	        WebDriver driver = new FirefoxDriver();
	    //    WindowsRegistry wr = new WindowsRegistry();
	   //     wr.readRegValue();
	    //    String baseUrl = "http://newtours.demoaut.com";
	        String expectedTitle = "Welcome: Mercury Tours";
	        String actualTitle = "";
	 
	        

	        // launch Firefox and direct it to the Base URL
	        driver.get("https://www.google.com");
	 
	        // get the actual value of the title
	        actualTitle = driver.getTitle();
	 
	        new Actions(driver).sendKeys(driver.findElement(By.tagName("html")), Keys.CONTROL).sendKeys(driver.findElement(By.tagName("html")),Keys.NUMPAD2).build().perform();

	     //    * compare the actual title of the page witht the expected one and print
	      //   * the result as "Passed" or "Failed"
	         
	    /*    if (actualTitle.contentEquals(expectedTitle)){
	            System.out.println("Test Passed!");
	        } else {
	            System.out.println("Test Failed");
	        }
	        */
	        //close Firefox
	      //  driver.close();
	        
	        // exit the program explicitly
	      //  System.exit(0);
	    }
}
