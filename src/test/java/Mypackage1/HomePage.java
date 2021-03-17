package Mypackage1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.forgotPassword;
import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.Base;

public class HomePage extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(HomePage.class.getName());
	
	@BeforeMethod
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
		log.info("this is for user login");
	}
	
	@Test(dataProvider="getData")
	public void loginValidation(String username,String password,String text) throws IOException
	{
		
		
		landingPage lp = new landingPage(driver);
		lp.getLogin().click();
		
		loginPage lop = new loginPage(driver);
		lop.getEmail().sendKeys(username);
		lop.getPassword().sendKeys(password);
		lop.doSubmit().click();
		log.info(text);
		
		//System.out.println(lop.alert());
		
		forgotPassword fp = lop.forgotPwd();  // used optimized method of return objects and page navigation 
		fp.getEmail().sendKeys("test");
		fp.sendINS().click();
		System.out.println("am just testing git here");
		
				
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		log.info("closing all user login drivers");
	}
	
		
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3];
		
		data[0][0]= "nonrestricted@qa.com";
		data[0][1]= "12345";
		data[0][2]= "nonrestrictedUser";
		
		
		data[1][0]= "restricted@qa.com";
		data[1][1]= "67899";
		data[1][2]= "restrictedUser";
		
		
		return data;
				
	}

}
