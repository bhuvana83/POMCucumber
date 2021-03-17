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

public class validateNavigation extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(validateNavigation.class.getName());
	
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
		driver.switchTo().defaultContent();
		log.info("initalization done for navigation bar");
	}
	
	@Test
	public void navigationBarValidate() throws IOException
	{
			
		landingPage lp = new landingPage(driver);
		Assert.assertTrue(lp.getNavBar().isDisplayed());
		log.info("navigationbar validation is success");

						
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		log.info("closing all drivers for navbar");
	}

}
