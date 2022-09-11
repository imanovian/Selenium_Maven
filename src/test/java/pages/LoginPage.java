package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//***********************Objects********************//
	@FindBy(linkText="Log in")
	WebElement LoginLink;
	
	@FindBy(name="user_login")
	WebElement UserName;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(className="rememberMe")
	WebElement Checkbox;
	
	@FindBy(name="btn_login")
	WebElement LoginBtn;
	
	WebDriver driver;
	public LoginPage(WebDriver Basedriver) {
		this.driver = Basedriver;
		PageFactory.initElements(Basedriver, this);
	}
	//******************Methods*****************//
	public void Login(String UserNameVal, String PasswordVal) {
		// Step1. Click  on the Login Link
				LoginLink.click();
				
				//Step2: Enter Username
				UserName.sendKeys(UserNameVal);
				
				
				//Step3: Enter Password
				Password.sendKeys(PasswordVal);
				
				//Step4 Click Remember Me checkbox
		        Checkbox.click();
				
				//Step5: Click pn Login Button
				LoginBtn.click();
	}
}
