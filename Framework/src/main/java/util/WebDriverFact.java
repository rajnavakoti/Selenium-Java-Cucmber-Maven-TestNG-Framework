package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class WebDriverFact {
	
	private static Properties properties;
	private static FileInputStream input = null;
	public static Properties load_Properties_File(){
		 properties = new Properties();	
			 try {
				input = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); }
			 try {
				properties.load(input);
			} catch (IOException e)  {
				// TODO Auto-generated catch block
				e.printStackTrace(); }
			 return properties;
	}

	public static RemoteWebDriver get_Driver(String browser) {
		WebDriver driver = null;
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();		
		}
		else if(browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else throw new RuntimeException("browser value must be either chrome/firefox");
		return (RemoteWebDriver)driver;
	}
	}

