package com.stepdefinition;

import java.util.*;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class steps {
	WebDriver driver;

	@Given("User is on login page")
	public void user_is_on_login_page() {
		System.out.println("step1:-");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		WebElement signinbutton = driver.findElement(By.linkText("Sign in"));
		Assert.assertTrue(signinbutton.isDisplayed());
	}

	@When("user enters credentials")
	public void user_enters_credentials() throws InterruptedException {
		System.out.println("step2:-");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(02));
		WebElement signinbutton = driver.findElement(By.linkText("Sign in"));
		signinbutton.click();
		WebElement uname = driver.findElement(By.id("userid"));
		wait.until(ExpectedConditions.visibilityOf(uname));
		uname.sendKeys("rohitpachauri2@gmail.com");
		WebElement cont = driver.findElement(By.id("signin-continue-btn"));
		cont.click();
		WebElement pass = driver.findElement(By.id("pass"));
		wait.until(ExpectedConditions.visibilityOf(pass));
		pass.sendKeys("rmv123*#R");

	}

	@Then("user is able to login")
	public void user_is_able_to_login() throws InterruptedException {
		System.out.println("step3-");
		String cururl = "";

		try {
			WebElement sgn = driver.findElement(By.id("sgnBt"));
			sgn.click();
			WebElement textme = driver.findElement(By.id("smsWithCode-title"));
			textme.click();
			WebElement cnt1 = driver.findElement(By.id("send-button"));
			cnt1.click();
			Thread.sleep(Duration.ofSeconds(10));
			System.out.println("current url at this point is: " + driver.getCurrentUrl());

		} catch (Exception e) {
			System.out.println(e + " " + " Sign in with text was not available");
			Thread.sleep(2000);

			System.out.println("current url at this point is: " + driver.getCurrentUrl());

		}
	}

	@Given("user is logged in")
	public void user_is_logged_in() throws InterruptedException {
		System.out.println("step4-");

		Thread.sleep(Duration.ofSeconds(10));
		WebElement name = driver.findElement(By.cssSelector("span.gh-identity__greeting>span"));
		Assert.assertTrue(name.getText().equals("Rohit!"));

	}

	@When("user enters the text and clicks on search button")
	public void user_enters_the_text_and_clicks_on_search_button() throws InterruptedException {
		System.out.println("step5-");
		Thread.sleep(Duration.ofSeconds(2));
		WebElement searchbox = driver.findElement(By.id("gh-ac"));
		searchbox.sendKeys("samsung galaxy m21");
		Thread.sleep(Duration.ofSeconds(1));
		WebElement searchbutton = driver.findElement(By.cssSelector("span.gh-search-button__label"));
		searchbutton.click();
	}

	@And("user gets the list of all the mobiles phones")
	public void user_gets_the_list_of_all_the_mobiles_phones() throws InterruptedException {
		System.out.println("step6");
		Thread.sleep(Duration.ofSeconds(5));
		// find the sort by button--------------------------------------

		WebElement btn1 = driver.findElement(By.cssSelector(
				"button[class='fake-menu-button__button btn btn--small btn--secondary'][aria-label='Sort selector. Best Match selected.']"));
		btn1.click();
		Thread.sleep(Duration.ofSeconds(5));

		// selecting the condition of sort-------------------------------

		WebElement sortcond1 = driver.findElement(By.cssSelector(
				"a[class='fake-menu-button__item'][href='https://www.ebay.com/sch/i.html?_nkw=samsung+galaxy+m21&_sacat=0&_from=R40&_sop=1']"));
		sortcond1.click();
		Thread.sleep(Duration.ofSeconds(5));

		// getting/printing all the options after sort---------------------

		List<WebElement> list = driver.findElements(By.cssSelector("div.s-card__title"));
		System.out.println("Results are :-");
		for (WebElement e : list) {
			System.out.println(e.getText());
		}

	}

	@Then("user adds the item to cart")
	public void user_adds_the_item_to_cart() throws InterruptedException {

		System.out.println("step7");
		WebElement fav;
		List<WebElement> list = driver.findElements(By.cssSelector("div.s-card__title"));
		// selecting the mobile from list of options----------------------------------

		for (WebElement a : list) {
			if (a.getText().contains("Samsung Galaxy M21 2021 Edition-SM215G-4GB RAM 64GB")) {
				fav = a;
				fav.click();
				Thread.sleep(Duration.ofSeconds(1));

			}
		}
		// Move to new opened window----------------------------------------

		String curwin = driver.getWindowHandle();
		for (String s : driver.getWindowHandles()) {
			if (s != curwin) {
				driver.switchTo().window(s);
				Thread.sleep(Duration.ofSeconds(1));
				System.out.println(driver.getTitle());
			}
		}
		Actions action = new Actions(driver);
		WebElement addbtn = driver.findElement(By.cssSelector("a#atcBtn_btn_1"));
		action.scrollToElement(addbtn);
		addbtn.click();
		Thread.sleep(Duration.ofSeconds(2));
		driver.switchTo().window(curwin);
		System.out.println(driver.getCurrentUrl());
		driver.quit();

	}
	@Given("cart is not empty")
	public void cart_is_not_empty() {
		System.out.println("Steps8-");
	    String cartmessage=driver.findElement(By.cssSelector("span.gh-cart__icon")).getText();
	    Assert.assertTrue(!cartmessage.equalsIgnoreCase("Your shopping cart contains 0 items"));
	}
	@When("user clicks on show in cart")
	public void user_clicks_on_show_in_cart() throws InterruptedException {
		System.out.println("Steps9-");
	    WebElement cartbutton=driver.findElement(By.cssSelector("div[class='gh-flyout is-right-aligned gh-flyout--icon-target']>a"));
	    cartbutton.click();
	    Thread.sleep(Duration.ofSeconds(2));
	    Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
	}
	@Then("user see all the items added")
	public void user_see_all_the_items_added() {
		System.out.println("Steps10-");
	   
	}

	
}
