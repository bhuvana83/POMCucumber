package Mypackage1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.Base;

public class validateTitle extends Base {
	public WebDriver driver;
	landingPage lp;
	public static Logger log = LogManager.getLogger(validateTitle.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		driver = intialization();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String newWindow = driver.getWindowHandle();
		driver.switchTo().window(newWindow);
		driver.findElement(By.xpath(".//button[text()='NO THANKS']")).click();
		
		//driver.findElement(By.xpath("//div[@class='sumome-react-wysiwyg-move-handle']//div//button[text()='NO THANKS']")).click();
		driver.switchTo().defaultContent();
		log.info("initalization done for tilte");
		
	
	}
	
	@Test
	public void titleValidation() throws IOException
	{
		
		lp = new landingPage(driver);
		
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES123");
		log.info("course validation is success");
							
	}
	
	
	@Test
	public void bannerValidation() throws IOException
	{
		lp = new landingPage(driver);
			
		Assert.assertEquals(lp.getBanner().getText(), "Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..");
		log.info("banner validation is success");
							
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		log.info("closing all drivers for title");
	}

}
