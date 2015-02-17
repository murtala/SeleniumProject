package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import widgets.Pather;
import widgets.Widget;
import static org.junit.Assert.*;

public class BmiCalcPage extends LoadableComponent<BmiCalcPage> {
	
	private WebElement heightCMS;
	private WebElement weightKg;
	private WebElement Calculate;
	private WebElement bmi;
	private WebElement bmi_category;
	private WebDriver driver;
	private String url = Pather.getLoc("BMI Calculator.htm");
	private String title = "BMI Calculator";
	
	public BmiCalcPage() {
		Widget.OpenLinkInChromeBrowser(Pather.getLoc(url));
		driver = Widget.driver;
		//driver = new ChromeDriver();
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
