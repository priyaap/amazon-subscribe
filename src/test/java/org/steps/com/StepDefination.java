package org.steps.com;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import projectObjectRepo.AmazonHomePage;
import projectObjectRepo.SignInPage;
import projectObjectRepo.SubscribeAndSavePage;
import projectObjectRepo.commonUtilities;

public class StepDefination {
	public static WebDriver driver;
	
	
	@BeforeAll
    public static void before_all() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\priya\\eclipse-workspace\\JavaForSelenium\\Amazon\\src\\test\\resources\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
    }

	@Given("user visits amazon home page")
	public void user_visits_amazon_home_page()
	{
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);	
	driver.get(commonUtilities.url);	    
	}


	@When("user logs in with valid login and password")
	public void user_logs_in_with_valid_login_and_password() {
				driver.findElement(By.xpath(AmazonHomePage.signInDropDownId)).click();				
				String actualTitle = driver.getTitle();
				System.out.println(actualTitle);
				Assert.assertEquals("FAIL:The actual title does to equal to expected title",actualTitle, SignInPage.expectedTitle);
				driver.findElement(By.id(SignInPage.loginId)).sendKeys(SignInPage.loginIdValue);
				driver.findElement(By.id(SignInPage.continueButtonId)).click();
				driver.findElement(By.xpath(SignInPage.passwordId)).sendKeys(SignInPage.passwordValue);
				driver.findElement(By.id(SignInPage.signInButton)).click();
					}
				
	
	@Then("user logs in sucessfully")
	public void user_logs_in_sucessfully() {

		driver.findElement(By.xpath(SubscribeAndSavePage.hambergerMenu)).click();
		if(driver.findElement(By.linkText(SubscribeAndSavePage.signOut)).isEnabled())
		{
			System.out.println("User logged in");
			driver.findElement(By.xpath("//*[@id=\"hmenu-canvas-background\"]/div")).click();
		}
		
	}


@Given("User clicks on account and lists dropdown")
public void user_visits_amazon_subscribe_and_save_page() {
	driver.findElement(By.xpath(SubscribeAndSavePage.accountListDropdown)).click();
}


@When("user cicks on subscribe and save link")
public void user_cicks_on_subscribe_and_save_link() {
	driver.findElement(By.linkText(AmazonHomePage.subscribeAndSaveLinkTxt)).click();
}

@When("user clicks on subscribe button")
public void user_clicks_on_subscribe_button() {
	driver.findElement(By.partialLinkText("Shop the Subscribe & Save store")).click();
}

@Then("user is on subscribe and save home page")
public void user_is_on_subscribe_and_save_home_page() 
{
	Assert.assertEquals("FAIL:The actual title on subscribe page does to equal to expected title",driver.getTitle(), SubscribeAndSavePage.ExpectedTitleOnSubscribePage);

}

@Given("User search a product on the subscribe and save page")
public void user_search_a_product_on_the_subscribe_and_save_page() {
    // Write code here that turns the phrase above into concrete actions
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Monster Energy Zero Ultra, Sugar Free Energy Drink, 16 Ounce (Pack of 24)");
    driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).submit();
}

@When("when user clicks on the result link for the product")
public void when_user_clicks_on_the_result_link_for_the_product() {
	driver.findElement(By.partialLinkText("Monster Energy Zero Ultra, Sugar Free Energy Drink, 16 Ounce (Pack of 24)")).click();
}

@Then("user subscribes to the product choosing quantiy {string} with frequency {int}")
public void product_details_gets_displayed(String quantityValue,int frequency) {
	Select quantity = new Select(driver.findElement(By.id(SubscribeAndSavePage.quantityDropdown)));
	quantity.selectByValue(quantityValue);	
	Select frequncey = new Select(driver.findElement(By.id(SubscribeAndSavePage.frequencySubscription)));
	frequncey.selectByIndex(frequency);	
	driver.findElement(By.xpath(SubscribeAndSavePage.subscriptionButton)).click();
	driver.findElement(By.id(SubscribeAndSavePage.setupNow)).click();

}

@AfterAll
public static void after_all() {
	driver.quit();
}
	
}
