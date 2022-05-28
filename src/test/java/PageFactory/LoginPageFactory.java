package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	
	@FindBy(id = "name")
	WebElement txtUsername;
	
	@FindBy(id = "password")
	WebElement txtPassword;
	
	@FindBy(id = "login")
	WebElement btnLogin;
	
	WebDriver driver;
	
	public LoginPageFactory(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void sendUserName(String userName)
	{
		txtUsername.sendKeys(userName);
	}
	
	public void sendPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void authenticate()
	{
		btnLogin.click();
	}
}
