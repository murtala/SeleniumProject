package checkbox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import widgets.Pather;
import widgets.Widget;
import static org.junit.Assert.*;

public class CheckBoxTest {

    private static WebDriver driver;

    @Before
    public void setUp() {
    	Widget.OpenLinkInChromeBrowser("file:///G:/Users/Moortala/workspace/SeleniumProject/web/Config.html");
		driver = Widget.driver;
      //  driver.get("file:///G:/Users/Moortala/workspace/SeleniumProject/web/Config.html");
    }
    
 	@Test
    public void testCheckBox()
    {
 		//Get the Checkbox as WebElement using it's value attribute
 		WebElement airbags = driver.findElement(By.xpath("//input[@value='Airbags']"));
 		
 		//Check if its already selected? otherwise select the Checkbox
 		//by calling click() method
 		if (!airbags.isSelected())
 			airbags.click();
 		
 		//Verify Checkbox is Selected
 		assertTrue(airbags.isSelected());

 		//Check Checkbox if selected? If yes, deselect it
 		//by calling click() method
 		if (airbags.isSelected())
 			airbags.click();
 		
 		//Verify Checkbox is Deselected
 		assertFalse(airbags.isSelected());
    }
    
 	
    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}