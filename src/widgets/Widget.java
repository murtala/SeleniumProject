package widgets;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Widget {

	// static WebDriver firefoxdriver;
	public static WebDriver theDriver;
	static WebDriver chromedriver;
	static WebDriver IEdriver;
	public static FirefoxDriver firefoxdriver;
	public static FirefoxProfile profile = new FirefoxProfile();

	static String Browser;

	public static WebDriver driver; 
	
	
	public boolean verifyPageTitle(String exp)
	{
		String acttitle=theDriver.getTitle();
		if (acttitle.equals(exp))
			return true;
		else
			return false;
	}
	
	public void openMenu(String link)
	{
		Actions action = new Actions(theDriver);
		WebElement element= theDriver.findElement(By.linkText(link));
		action.moveToElement(element).build().perform();
	}
	
	
	
	public static void setBrowser(String browser) {
		Browser = browser;
	}

	public static void getBrowser() {

		if (Browser.equalsIgnoreCase("firefox") || Browser.equalsIgnoreCase("ff")) {

			theDriver = new FirefoxDriver();

		} else if (Browser.equalsIgnoreCase("ie") || Browser.equalsIgnoreCase("InternetExplorer")
				|| Browser.equalsIgnoreCase("Internet Explorer")) {
			System.setProperty("webdriver.ie.driver", "F:\\JAVA\\Libraries\\IEDriverServer_Win32_2.33.0\\IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			theDriver = new InternetExplorerDriver();

		} else if (Browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "F:/JAVA/Libraries/chromedriver_win32_2.0/chromedriver.exe");
			theDriver = new ChromeDriver();
		} else

		{

			System.out.println("ERROR - Unknown browser type");

		}

	}

	public static void OpenLink(String url) {

		theDriver.get(url);
	}

	public static void OpenLinkInChrome(String url) {

		setUpChromeDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		setUpChromeDriver().get(url);
		//theDriver.get(url);
	}
	
	public static WebDriver setUpIEdriver() {
		System.setProperty("webdriver.ie.driver", "F:\\JAVA\\Libraries\\IEDriverServer_Win32_2.33.0\\IEDriverServer.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		return IEdriver = new InternetExplorerDriver();
	}

	public static WebDriver setUpFireFoxDriver() {
		return firefoxdriver = new FirefoxDriver();
	}

	public static WebDriver setUpChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "G:/Users/Moortala/workspace/SeleniumProject/web/chromedriver_win32/chromedriver.exe");
		return chromedriver = new ChromeDriver();
	}

	public static void OpenLinkInFirefoxBrowser(String url) {
		// firefoxdriver= new FirefoxDriver();
		firefoxdriver.get(url);

	}

	public static void OpenLinkInChromeBrowser(String url) {

		chromedriver = setUpChromeDriver();
		chromedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	//	chromedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	System.setProperty("webdriver.chrome.driver", "G:/Users/Moortala/workspace/SeleniumProject/web/chromedriver_win32/chromedriver.exe");
		driver = chromedriver;
		chromedriver.get(url);
	}

	public static void OpenLinkISafariBrowser() {
	}
}
