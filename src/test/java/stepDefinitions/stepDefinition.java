package stepDefinitions;

import org.junit.runner.RunWith;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.Base;

@RunWith(Cucumber.class)
public class stepDefinition extends Base {
	
	//WebDriver driver;
	
	@Given("^Initialize the chrome browser$")
	public void initialize_the_chrome_browser() throws Throwable {
	   
		driver = intialization();
	}

	@Given("^Navigate to \"([^\"]*)\"$")
	public void navigate_to(String arg1) throws Throwable {
		
		driver.get(arg1);
		driver.manage().window().maximize();
		
	   
	}

	@Given("^click on login in home page$")
	public void click_on_login_in_home_page() throws Throwable {
	   
		landingPage lp = new landingPage(driver);
		if(lp.getPopupsize()>0)
		{
			lp.getPopup().click();
			System.out.println("am in popup");
		}
		lp.getLogin().click();
		
		
	}

	 @When("^user login with (.+) and (.+) and click login$")
	    public void user_login_with_and_and_click_login(String username, String password) throws Throwable {
	   
		loginPage lop = new loginPage(driver);
		lop.getEmail().sendKeys(username);
		lop.getPassword().sendKeys(password);
		lop.doSubmit().click();
	}

	@Then("^user successfull login$")
	public void user_successfull_login() throws Throwable {
		
		loginPage lop = new loginPage(driver);
		System.out.println(lop.alert());
		
	}
	
	 @And("^close all browsers$")
	    public void close_all_browsers() throws Throwable {
		// driver.close();
		 driver.quit();
		    System.out.println("here check for pull");
		    System.out.println("checking for branching and merging");
	    }



}
