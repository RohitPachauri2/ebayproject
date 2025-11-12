package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Sign in")
	WebElement signin;
	@FindBy(id = "userid")
	WebElement id;
	@FindBy(id = "signin-continue-btn")
	WebElement cont;
	@FindBy(id = "pass")
	WebElement pass;
	@FindBy(id = "sgnBt")
	WebElement sgnbtn;
	@FindBy(id = "smsWithCode-title")
	WebElement textme;
	@FindBy(id = "send-button")
	WebElement cnt1;
	@FindBy(css = "span.gh-identity__greeting>span")
	WebElement name;

	public void Sigin() {
		try {
			signin.click();
		} catch (Exception e) {
			System.out.println("Sign in link not found ");
		}

	}

	public void unameb(String val) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(02));
		wait.until(ExpectedConditions.visibilityOf(id));
		id.sendKeys(val);
	}

	public void contb() {
		cont.click();
	}

	public void passb(String val) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(02));
		wait.until(ExpectedConditions.visibilityOf(pass));
		pass.sendKeys(val);
	}

	public void signinpasssms() throws InterruptedException{
		sgnbtn.click();
		textme.click();
		cnt1.click();
		Thread.sleep(Duration.ofSeconds(10));
		System.out.println("current url at this point is: " + driver.getCurrentUrl());
	}

}
