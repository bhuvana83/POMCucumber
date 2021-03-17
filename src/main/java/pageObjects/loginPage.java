package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
    WebDriver driver;
	
	public loginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	private By email = By.xpath("//input[@id='user_email']");
	private By password = By.xpath("//input[@id='user_password']");
	private By submit = By.xpath("//input[@type='submit']");
	private By forgotpwd = By.cssSelector("[href*='password/new']");
	private By alert = By.cssSelector("[class*='alert-danger']");
	
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement doSubmit()
	{
		return driver.findElement(submit);
	}
	
	public forgotPassword forgotPwd()
	{
		driver.findElement(forgotpwd).click();
		
		return new forgotPassword(driver);
	}
	
	public String alert()
	{
		String text = driver.findElement(alert).getText();
		
		return text;
	}
}
