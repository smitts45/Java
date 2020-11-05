package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAuto 
{
	@FindBy(linkText="Sign in")WebElement signIn;
	@FindBy(id="email")WebElement emailAddress;
	@FindBy(id="passwd")WebElement emailPassword;
	@FindBy(id="SubmitLogin")WebElement submitLogin;
	@FindBy(xpath="//li[contains(text(),'Authentication failed.')]")WebElement loginError;

	public LoginAuto(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public void customerLogin()
	{
		signIn.click();
		emailAddress.sendKeys("qatest87765@gmail.com");
		emailPassword.sendKeys("password");
		submitLogin.click();
	}

	public String getActualError()
	{
		return loginError.getText();
	}

}
	
	


