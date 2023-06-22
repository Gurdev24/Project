package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseHRclass;

public class Pomlogin extends BaseHRclass{

	@FindBy(css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(2) > div > div:nth-child(2) > input")
	WebElement Username;
	
	
	@FindBy(css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(3) > div > div:nth-child(2) > input")
	WebElement Password;
	
	
	@FindBy(css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button")
	WebElement Loginbutton;
	
	
	public Pomlogin()
	{
		PageFactory.initElements(driver, this);		
	}
	
	
	public void typeusername(String name)
	{
		Username.sendKeys(name);
	}
	
	public void typepassword(String pass)
	{
		Password.sendKeys(pass);
	}
	
	public void clickb()
	{
		Loginbutton.click();
	}
	
	public String verify()
	{
		return driver.getTitle();
		
	}
	
}
