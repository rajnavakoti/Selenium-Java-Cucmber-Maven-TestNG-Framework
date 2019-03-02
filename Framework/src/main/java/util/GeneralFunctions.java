package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.GenericComponents;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



/**
 * General Functions has take screenshots, highlight and take screenshot methods
 *
 */
public class GeneralFunctions {

	GenericComponents object;
	WebDriver driver;
	
	
	public GeneralFunctions(WebDriver driver){
		object = new GenericComponents();
		this.driver = driver;
	}
	
	 public void highlight_Element_And_Take_Screenshot(WebElement ele, String ScreenshotName) {
		 ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", ele);
		    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		    try {
				FileUtils.copyFile(screenshot, new File("./Screenshots/"+ScreenshotName));
			} catch (IOException e) {
				e.printStackTrace();
			}
	 }
			public void take_Page_Screenshot(String ScreenshotName) {
			    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			    try {
					FileUtils.copyFile(screenshot, new File("./Screenshots/"+ScreenshotName));
				} catch (IOException e) {
					e.printStackTrace();
				}	
}

}