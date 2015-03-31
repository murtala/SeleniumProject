package browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class tabsTest {
	 WebDriver driver;
	 Tabs  tabs;
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("http://google.com");
  }

  @AfterClass
  public void afterClass() {
//	  driver.close();
//	  driver.quit();
  }


  @Test (enabled = false)
  public void openNewTab() {
   tabs=  new Tabs(driver);
    tabs.openNewTab();
    try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  
  @Test
  public void openLinkInANewTab() {
	  driver.findElement(By.linkText("Selenium WebDriver"));
	  tabs.openLinkInANewTab( driver.findElement(By.linkText("Selenium WebDriver")));
  }
  
  
  
  
  
  
  
  
}
