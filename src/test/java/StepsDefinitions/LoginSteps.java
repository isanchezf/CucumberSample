package StepsDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageFactory.HomePageFactory;
import PageFactory.LoginPageFactory;
import io.cucumber.java.en.*;

public class LoginSteps
{
	WebDriver driver;
	LoginPageFactory loginPage;
	HomePageFactory homePage;
	String expectedMessage;
	
	public LoginSteps()
	{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		loginPage = new LoginPageFactory(driver);
		homePage = new HomePageFactory(driver);
	}
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://example.testproject.io/web/");
	}

	@When("user enters {string} and {int}")
	public void user_enters_username_and_password(String name, int pass) {
	    // Write code here that turns the phrase above into concrete actions
		expectedMessage = "Hello " + name + ", let's complete the test form:";
	    loginPage.sendUserName(name);
		loginPage.sendPassword(String.valueOf(pass));
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		loginPage.authenticate();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(expectedMessage, homePage.GetWellcomeMessage());
	}
	
	@And("close browser")
	public void close_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.quit();
	}
}