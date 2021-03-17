package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {
	
WebDriver driver;
	
	public landingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	private By login = By.xpath("//a[contains(@href,'sign_in')]");
	
	private By title = By.xpath("//div[@class='text-center']/h2");
	
	private By navbar = By.xpath("//ul[@class='nav navbar-nav navbar-right']//li[8]//a");
	
	private By banner = By.cssSelector("div[class*='video-banner'] p");
	
	private By popup = By.xpath(".//button[text()='NO THANKS']");
	
	
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavBar()
	{
		return driver.findElement(navbar);
	}
	
	public WebElement getBanner()
	{
		return driver.findElement(banner);
	}
	
	public int getPopupsize()
	{
		return driver.findElements(popup).size();
	}
	
	public WebElement getPopup()
	{
		return driver.findElement(popup);
	}

}
