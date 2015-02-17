package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import static org.junit.Assert.*;

public class BmiCalcPage extends LoadableComponent<BmiCalcPage> {
	
	private WebElement heightCMS;
	private WebElement weightKg;
	private WebElement Calculate;
	private WebElement bmi;
	private WebElement bmi_category;
	private WebDriver driver;
	private String url = "file:///F:/JAVA/QA/Java%20Files/BMI%20Calculator.htm";
	private String title = "BMI Calculator";
	
	public BmiCalcPage() {
		driver = new FirefoxDriver();
		PageFactory.initElements(driver, this);
	}
	
	@Override
	protected void load() {
		this.driver.get(url);
	}
	
	@Override
	protected void isLoaded()  {
		assertTrue(driver.getTitle().equals(title));
	}
	
	public void calculateBmi(String height, String weight) {
		heightCMS.sendKeys(height);
		weightKg.sendKeys(weight);
		Calculate.click();
	}
	
	public String getBmi() {
		return bmi.getAttribute("value");
	}
	
	public String getBmiCategory() {
		return bmi_category.getAttribute("value");
	}
	
	public void close() {
		this.driver.close();
	}
}
