package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;
	
	
	public WebDriver intialization() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\CodeBase\\WORKSPACE_ECLIPSE\\BhuvanaTest\\E2Eproject\\src\\main\\java\\resources\\Data.properties");
		
		         // use this to remove hard coding for the path
		//FileInputStream fis2 = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.properties");
		
		prop.load(fis);
		
		//mvn test -Dbrowser=chrome and use system.get property in order to get details from maven
		//this will help to run jenkins with different browser during build
		
		//String broswerName= System.getProperty("browser");
		String broswerName = prop.getProperty("browser");
		
		String link = prop.getProperty("url");
		
		System.out.println(broswerName);
		System.out.println(link);
		
		if (broswerName.contains("chrome"))
		{
			   // remove path hard coding using fis2 and place all .exe under resources
			System.setProperty("webdriver.chrome.driver", "D:\\InstalledApps\\chromedriver_win32\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			if(broswerName.contains("headless"))
			{
				options.addArguments("--headless");
			}
			
			driver = new ChromeDriver(options);
			
		}
		else if(broswerName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\InstalledApps\\geckodriver-v0.29.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(broswerName.equals("IE"))
		{
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public String getScreenshot(String testCasename, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCasename+".png";
		FileUtils.copyFile(src,new File(destinationFile));
		return destinationFile;
	}
}
