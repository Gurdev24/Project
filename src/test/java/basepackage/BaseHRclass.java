package basepackage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class BaseHRclass {

	public static Properties prop = new Properties();
	public static WebDriver driver;
	
	//Step1
	public BaseHRclass()
	{
		try {
			FileInputStream file = new FileInputStream("C:\\Users\\gurde\\eclipse-workspace\\HRmanagment\\src\\test\\java\\envvariables\\config.properties");
			prop.load(file);
		} 
		catch (FileNotFoundException e) {
			//
			e.printStackTrace();
		}
		catch(IOException a) {
			a.printStackTrace();
		}
	}
	
	
	public static void initiation() {
		
		String broswername = prop.getProperty("browser");
		if(broswername.equals("GoogleChrome"))
		{
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		else if(broswername.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver= new FirefoxDriver(); 
		
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
	}
	
	public static void screenshots(String Filename)
	{
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("C:\\Users\\gurde\\eclipse-workspace\\HRmanagment\\src\\test\\java\\screenshot\\screenshots"+Filename+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
