package com.stepdefinition;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class steprunner {
	@CucumberOptions(
		    features = "src/test/resources/function.feature", // Path to your feature file
		    glue = "com.stepdefinition", // Path to your step definitions
		    plugin = {"pretty", "html:target/cucumber-reports"},
		    monochrome = true,
		    dryRun =false
		//    tags = "@smoketest or @regressiontest" // @smoketest and @regressiontest --->This will run scenarios tagged with either of the two tags 
		)
		public class Testrunner extends AbstractTestNGCucumberTests {
		}
}
