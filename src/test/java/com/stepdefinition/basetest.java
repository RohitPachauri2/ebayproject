package com.stepdefinition;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basetest {
	protected WebDriver driver;

	@BeforeMethod
	public void setup(Method method, ITestContext context) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		context.setAttribute("driver", driver); // ✅ Makes driver available to listener
		System.out.println("Driver initialized for test: " + method.getName());
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			System.out.println("Driver closed after test.");
		}
	}
}
