package qa.Listeners;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.RunResult;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import qa.PageObjectsCollections.PageObjects;

public class Listener implements ITestListener {

	private static ExtentReports extent;
	private static ExtentTest test;

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName(), result.getMethod().getDescription());
	}

	public void onTestSuccess(ITestResult result) {
		try {
			String screenshotnameString = PageObjects.login.takeScreenshot(result.getMethod().getDescription());
			test.pass(result.getMethod().getDescription(), MediaEntityBuilder
					.createScreenCaptureFromPath(".\\Artifacts\\screenshots\\" + screenshotnameString).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		try 
		{
			String screenshotnameString = PageObjects.login.takeScreenshot(result.getMethod().getDescription());
			test.fail(result.getThrowable().getMessage(), MediaEntityBuilder
					.createScreenCaptureFromPath(".\\Artifacts\\screenshots\\" + screenshotnameString).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		try {
			String screenshotnameString = PageObjects.login.takeScreenshot(result.getMethod().getDescription());
			test.skip("details", MediaEntityBuilder
					.createScreenCaptureFromPath(".\\Artifacts\\screenshots\\" + screenshotnameString).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("TestReport.html");
		
		htmlReporter.config().setDocumentTitle("Test Report");
		htmlReporter.config().setReportName("Automation Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.start();
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Application", "BBC News");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
	
	}

	public void onFinish(ITestContext context) {
		System.out.println("******After Finish********");
		extent.flush();
	}

}
