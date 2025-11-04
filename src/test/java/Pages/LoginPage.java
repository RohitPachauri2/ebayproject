package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(linkText = "Sign in") WebElement signin ;
	@FindBy(id="userid") WebElement id ;
	@FindBy(id="signin-continue-btn") WebElement cont ;
	@FindBy(id="pass") WebElement pass ;
	@FindBy(id="sgnBt") WebElement sgnbtn;
	@FindBy(id="smsWithCode-title") WebElement textme;
	@FindBy(id="send-button") WebElement cnt1;
	@FindBy(css="span.gh-identity__greeting>span") WebElement name;
	
	
}
