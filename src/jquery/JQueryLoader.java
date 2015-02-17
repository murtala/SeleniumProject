package jquery;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;

import widgets.Widget;

public class JQueryLoader extends Widget {

	JavascriptExecutor js = (JavascriptExecutor) theDriver;

	private void injectjQueryIfNeeded() {
		if (!jQueryLoaded())
			injectjQuery();
	}

	public Boolean jQueryLoaded() {
		Boolean loaded;
		try {
			loaded = (Boolean) js.executeScript("return	jQuery()!=null");
		} catch (WebDriverException e) {
			loaded = false;
		}
		return loaded;
	}

	public void injectjQuery() {
		js.executeScript(" var headID =  document.getElementsByTagName(\"head\")[0];"
				+ "var newScript = document.createElement('script');" + "newScript.type = 'text/javascript';"
				+ "newScript.src = 'http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js';"
				+ "headID.appendChild(newScript);");
	}

}
