package cookies;

import java.util.Date;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import widgets.PageWidget;
import widgets.Widget;

public class HandlingCookies {

	WebDriver driver = new FirefoxDriver();
	public void  CookiesExamples() {
			
		
		// Go to the correct domain
		driver.get("http://www.yahoo.com");

		// Now set the cookie. This one's valid for the entire domain
		Cookie cookie = new Cookie("CookieName", "value");
		/*Cookie cookie1 = new Cookie(name, value, path);
		Date expiry = new Date("today");
		Cookie cookie2 = new Cookie(name, value, path, expiry );
		Cookie cookie3 = new Cookie(name, value, domain, path, expiry, isSecure);*/
		
		//add a cookie
		driver.manage().addCookie(cookie);

		// get, search a specific cookie
		driver.manage().getCookieNamed("CookieName");
		driver.manage().getCookies().contains(cookie);
		
		

		//count cookies
		driver.manage().getCookies().size();
		
		
		// And now output all the available cookies for the current URL
		Set<Cookie> allCookies = driver.manage().getCookies();
		
		for (Cookie loadedCookie : allCookies) {
		    System.out.println(String.format("%s -> %s", loadedCookie.getName(), loadedCookie.getValue()));
		    System.out.println("getExpiry"+loadedCookie.getExpiry());
		    System.out.println("getDomain"+loadedCookie.getDomain());
		    System.out.println("getPath"+loadedCookie.getPath());
		    System.out.println("isSecure"+loadedCookie.isSecure());
		}
		
		// You can delete cookies in 3 ways
		// By name
		driver.manage().deleteCookieNamed("CookieName");
		// By Cookie
	//	driver.manage().deleteCookie(loadedCookie);
		// Or all of them
		driver.manage().deleteAllCookies();
		driver.quit();
				
	}

}
