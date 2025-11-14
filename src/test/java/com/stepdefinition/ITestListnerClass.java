package com.stepdefinition;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ITestListnerClass implements ITestListener {

	private ExtentSparkReporter htmlReporter;
	private ExtentReports reports;
	private ExtentTest test;

	// ------------------- Report Configuration -------------------

	public void configureReport() {
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/ExtentListenerReportDemo1.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		reports.setSystemInfo("Machine", "PC");
		reports.setSystemInfo("OS", "Windows 10");

		htmlReporter.config().setDocumentTitle("Extent Listener Report");
		htmlReporter.config().setReportName("Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	// ------------------- Listener Events -------------------------

	@Override
	public void onStart(ITestContext context) {
		configureReport();
		System.out.println("=== ITestListener — Test Execution Started ===");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("=== ITestListener — Test Execution Finished ===");
		reports.flush(); // Save report
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getName());
		System.out.println("Starting Test: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, MarkupHelper.createLabel("PASS: " + result.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {

		WebDriver driver = DriverManager.getDriver(); // <-- Correct Driver

		test.log(Status.FAIL, MarkupHelper.createLabel("FAIL: " + result.getName(), ExtentColor.RED));

		// Take Screenshot
		try {
			String screenshotPath = System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator
					+ result.getName() + System.currentTimeMillis() + ".png";

			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(screenshotPath));

			test.fail("Screenshot:"+ test.addScreenCaptureFromPath(screenshotPath));

		} catch (Exception e) {
			test.fail("Screenshot failed: " + e.getMessage());
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, MarkupHelper.createLabel("SKIPPED: " + result.getName(), ExtentColor.YELLOW));
	}
}
