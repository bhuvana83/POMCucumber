package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class forgotPassword {
	
    WebDriver driver;
	
	public forgotPassword(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	By email = By.xpath("//input[@id='user_email']");
	
	By sendmeIns = By.xpath("//input[@type='submit']");
	
	
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	
	
	public WebElement sendINS()
	{
		return driver.findElement(sendmeIns);
	}
	
	
}
