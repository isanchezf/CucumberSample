package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {
	
	@FindBy(id = "greetings")
	WebElement lblWellcome;
	
	WebDriver driver;
	
	public HomePageFactory(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String GetWellcomeMessage()
	{
		return lblWellcome.getText();
	}
}
