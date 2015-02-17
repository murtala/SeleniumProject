package practice;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchWD {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.orbitz.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testFlightSearchWD() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.name("search.type")).click();
    driver.findElement(By.cssSelector("div.button")).click();
    driver.findElement(By.name("ar.rt.leaveSlice.orig.key")).clear();
    driver.findElement(By.name("ar.rt.leaveSlice.orig.key")).sendKeys("sfo");
    driver.findElement(By.name("ar.rt.leaveSlice.orig.key")).click();
    driver.findElement(By.name("ar.rt.leaveSlice.dest.key")).clear();
    driver.findElement(By.name("ar.rt.leaveSlice.dest.key")).sendKeys("la");
    driver.findElement(By.name("ar.rt.leaveSlice.dest.key")).click();
    driver.findElement(By.name("ar.rt.leaveSlice.date")).clear();
    driver.findElement(By.name("ar.rt.leaveSlice.date")).sendKeys("07/10/13");
    driver.findElement(By.name("ar.rt.returnSlice.date")).click();
    driver.findElement(By.name("ar.rt.returnSlice.date")).clear();
    driver.findElement(By.name("ar.rt.returnSlice.date")).sendKeys("07/19/13");
    driver.findElement(By.cssSelector("div.closeBar > span")).click();
    driver.findElement(By.name("search")).click();
    // Warning: waitForTextPresent may require manual changes
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Matching Results[\\s\\S]*$")) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    // Warning: verifyTextPresent may require manual changes
    try {
      assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Matching Results[\\s\\S]*$"));
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    String price = driver.findElement(By.xpath("//*[@class='resultsTotal']")).getText();
    System.out.println("The lowest price is " + price);
    driver.get("http://google.com");
    //  Openning a Link
    driver.findElement(By.linkText("Business Solutions")).click();
    driver.navigate().back();
    driver.findElement(By.linkText("News")).click();
    driver.get("http://www.orbitz.com/");
    // Using XPATH
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
