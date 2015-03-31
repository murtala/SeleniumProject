package screenshots;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;

public class CapturingShots {

	WebDriver driver = new FirefoxDriver();

	public void getScreenShot() throws IOException {
		driver.get("http://www.google.com/");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Now you can do whatever you need to do with it, for example copy
		// somewhere

		FileUtils.copyFile(scrFile, new File("G:\\Users\\Moortala\\EclipseProjects\\SeleniumProject\\src\\screenshots\\screenshot.png"));
	//	FileUtils.copyFile(scrFile, new File("SeleniumProject\\src\\screenshots\\screenshot.png"));
	}
	
	public void getScreenShot(WebElement element) throws IOException {
		driver.get("http://www.google.com/");

		element = driver.findElement(By.className("fbar"));
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("G:\\Users\\Moortala\\workspace\\SeleniumProject\\src\\screenshots\\screenshot.png"));

		File screen = scrFile;
		//Create an instance of Buffered Image from captured screenshot
		
		// Get the Width and Height of the WebElement using 
		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight(); 
	
		Point p = element.getLocation();
		
		String CroppedfileLocation = "G:\\Users\\Moortala\\workspace\\SeleniumProject\\src\\screenshots\\croppedScreenshot.png";
		BufferedImage img = ImageIO.read(new File("G:\\Users\\Moortala\\workspace\\SeleniumProject\\src\\screenshots\\screenshot.png")); 
		File outputfile = new File(CroppedfileLocation);
		
		//BufferedImage croppedImg = img.getSubimage(p.getX()-30, p.getY(), width,height);
		System.out.println( "width " + width +  " height " + height  + "p.getX() " + p.getX()  +" p.getY() "+ p.getY()  + " getRaster().getHeight()" + img.getRaster().getHeight() +" - " + img.getRaster().getMinY()+ "getRaster().getWeight()" + img.getRaster().getWidth() +" - "+ img.getRaster().getMinX());
		//img.getRaster().getHeight();
		//img.getRaster().getHeight();
	//	ImageIO.write(croppedImg, "png", outputfile);
		
		
				//Write back the image data for element in File object
			//	ImageIO.write(dest, "png", screen);
				
		// Now you can do whatever you need to do with it, for example copy
		// somewhere


	}
	
	

	public void getScreenShotSelRC() throws IOException {
		driver.get("http://www.google.com/");

		driver = new Augmenter().augment(driver);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("G:\\Users\\Moortala\\workspace\\SeleniumProject\\src\\screenshots\\screenshot.png"));
	}
}
