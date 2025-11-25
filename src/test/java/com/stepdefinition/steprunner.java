package com.stepdefinition;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/function.feature", glue = "com.stepdefinition", plugin = { "pretty",
		"html:target/cucumber-reports" }, monochrome = true, dryRun = false, tags = "@latest")
public class steprunner extends AbstractTestNGCucumberTests {

	@BeforeSuite
	public void setUp() {

		System.out.println("=== Test Suite Started — Launching Browser ===");
		DriverManager.getDriver();
	}

	@AfterSuite
	public void tearDown() {

		System.out.println("=== Test Suite Finished — Closing Browser ===");
		DriverManager.quitDriver();
	}
}
