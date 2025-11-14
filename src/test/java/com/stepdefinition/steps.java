package com.stepdefinition;

import java.util.*;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class steps {
	
    WebDriver driver;  

    // ------------------ LOGIN PAGE -------------------------

    @Given("User is on login page")
    public void user_is_on_login_page() {
        System.out.println("step1:-");

        driver = DriverManager.getDriver();  // <-- SINGLE DRIVER

        LoginPage p = new LoginPage(driver);
        driver.get("https://www.ebay.com/");
        p.Sigin();
    }

    @When("^user enters (.*) and (.*)$")
    public void user_enters_credentials(String val1, String val2) throws InterruptedException {

        System.out.println("step2:-");

        driver = DriverManager.getDriver();

        LoginPage p = new LoginPage(driver);
        Thread.sleep(2000);
        p.Sigin();
        p.unameb(val1);
        p.contb();
        p.passb(val2);
    }

    @Then("user is able to login")
    public void user_is_able_to_login() throws InterruptedException {

        System.out.println("step3-");

        driver = DriverManager.getDriver();

        try {
            LoginPage p = new LoginPage(driver);
            Thread.sleep(2000);
            p.signinpasssms();

        } catch (Exception e) {
            System.out.println(e + " Sign in with text was not available");
            Thread.sleep(2000);
            System.out.println("current url at this point is: " + driver.getCurrentUrl());
        }
    }

    // ------------------ SEARCH PAGE -------------------------

    @Given("user is logged in")
    public void user_is_logged_in() throws InterruptedException {
        System.out.println("step4-");

        driver = DriverManager.getDriver();

        Thread.sleep(10000);
        WebElement name = driver.findElement(By.cssSelector("span.gh-identity__greeting>span"));
        Assert.assertTrue(name.getText().equals("Rohit!"));
    }

    @When("user enters the text and clicks on search button")
    public void user_enters_the_text_and_clicks_on_search_button() throws InterruptedException {

        System.out.println("step5-");

        driver = DriverManager.getDriver();

        Thread.sleep(2000);
        WebElement searchbox = driver.findElement(By.id("gh-ac"));
        searchbox.sendKeys("samsung galaxy m21");

        Thread.sleep(1000);
        WebElement searchbutton = driver.findElement(By.cssSelector("span.gh-search-button__label"));
        searchbutton.click();
    }

    @And("user gets the list of all the mobiles phones")
    public void user_gets_the_list_of_all_the_mobiles_phones() throws InterruptedException {

        System.out.println("step6");

        driver = DriverManager.getDriver();

        Thread.sleep(5000);

        WebElement btn1 = driver.findElement(By.cssSelector(
            "button[class='fake-menu-button__button btn btn--small btn--secondary'][aria-label='Sort. Best Match selected.']"));
        btn1.click();

        Thread.sleep(5000);

        WebElement sortcond1 = driver.findElement(By.cssSelector(
            "a[class='fake-menu-button__item'][href='https://www.ebay.com/sch/i.html?_nkw=samsung+galaxy+m21&_sacat=0&_from=R40&_sop=1']"));
        sortcond1.click();

        Thread.sleep(5000);

        List<WebElement> list = driver.findElements(By.cssSelector("div.s-card__title"));
        System.out.println("Results are :-");
        for (WebElement e : list) {
            System.out.println(e.getText());
        }
    }

    // ------------------ ADD TO CART -------------------------

    @Then("user adds the item to cart")
    public void user_adds_the_item_to_cart() throws InterruptedException {

        System.out.println("step7");

        driver = DriverManager.getDriver();

        List<WebElement> list = driver.findElements(By.cssSelector("div.s-card__title"));

        for (WebElement a : list) {
            if (a.getText().contains("Samsung Galaxy M21 2021 Edition-SM215G-4GB RAM 64GB")) {
                a.click();
                Thread.sleep(1000);
            }
        }

        String curwin = driver.getWindowHandle();
        for (String s : driver.getWindowHandles()) {
            if (!s.equals(curwin)) {
                driver.switchTo().window(s);
                Thread.sleep(1000);
                System.out.println(driver.getTitle());
            }
        }

        WebElement addbtn = driver.findElement(By.cssSelector("a#atcBtn_btn_1"));
        new Actions(driver).scrollToElement(addbtn).perform();
        addbtn.click();

        Thread.sleep(2000);
        driver.switchTo().window(curwin);

        System.out.println(driver.getCurrentUrl());
    }

    // ------------------ CART PAGE -------------------------

    @Given("cart is not empty")
    public void cart_is_not_empty() throws InterruptedException {

        System.out.println("Steps8-");

        driver = DriverManager.getDriver();

        Thread.sleep(10000);
        String cartmessage = driver.findElement(By.cssSelector("span.gh-cart__icon")).getText();

        if (cartmessage.equalsIgnoreCase("Your shopping cart contains 0 items")) {
            System.out.println("Your shopping cart contains 0 items");
        }
    }

    @When("user clicks on show in cart")
    public void user_clicks_on_show_in_cart() throws InterruptedException {

        System.out.println("Steps9-");

        driver = DriverManager.getDriver();

        WebElement cartbutton = driver.findElement(
            By.cssSelector("div[class='gh-flyout is-right-aligned gh-flyout--icon-target']>a"));

        new Actions(driver).moveToElement(cartbutton).perform();

        Thread.sleep(2000);

        List<WebElement> cartele = driver.findElements(
            By.cssSelector("div.gh-minicart-body>div>a>div.gh-info>div>span"));

        System.out.println("elements in cart are:-");
        for (WebElement a : cartele) {
            System.out.println(a.getText());
        }

        cartbutton.click();

        Thread.sleep(2000);

        Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
    }

    @Then("user enters address credentials")
    public void user_enters_address_credentials() throws InterruptedException {

        driver = DriverManager.getDriver();

        Thread.sleep(5000);

        System.out.println("Steps10-");

        driver.findElement(By.id("address1")).sendKeys("addressdemo");
        driver.findElement(By.id("city")).sendKeys("citydemo");

        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByIndex(5);

        driver.findElement(By.id("zip")).sendKeys("201310");
        driver.findElement(By.id("FPA_UPGRADE_FORM_SUBMIT")).click();
    }

    // ------------------ GIFT CARD PAGE -------------------------

    @Given("User is on login page for gift page")
    public void User_is_on_login_page_for_gift_page() {
        System.out.println("driver is on login page for gift page");

        driver = DriverManager.getDriver();
    }

    @When("user clicks on gift card page")
    public void user_clicks_on_gift_card_page() throws InterruptedException {

        driver = DriverManager.getDriver();

        Thread.sleep(2000);
        WebElement giftlink = driver.findElement(By.cssSelector("a[href='https://www.ebay.com/giftcards']"));
        giftlink.click();

        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("giftcards"));
    }

    @Then("user is navigated to gift card page")
    public void user_is_navigated_to_gift_card_page() throws InterruptedException {

        driver = DriverManager.getDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement bda = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("a#birthday")));

        new Actions(driver).scrollToElement(bda).perform();
        bda.click();
    }
}
