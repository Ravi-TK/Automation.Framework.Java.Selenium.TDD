package qa.Listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.logging.Level;

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.ElementScrollBehavior;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.AutomationFramework.Core.BrowserTypes;
import com.AutomationFramework.Core.Driver;
import com.AutomationFramework.Core.Log;
import com.AutomationFramework.Core.WebEventsListener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.RunResult;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import net.bytebuddy.description.modifier.EnumerationState;
import qa.PageObjectsCollections.PageObjects;

public class Listener implements ITestListener {

	private static ExtentReports extent;
	private static ExtentTest test;
	public static Log testLog;

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName(), result.getMethod().getDescription());
	}

	public void onTestSuccess(ITestResult result) {
		try {
			String screenshotnameString = PageObjects.login.takeScreenshot(result.getMethod().getDescription());
			System.out.println(screenshotnameString);
			test.pass(result.getMethod().getDescription(),
					MediaEntityBuilder
							.createScreenCaptureFromPath(
									System.getProperty("user.dir") + "/Artifacts/screenshots/" + screenshotnameString)
							.build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		try {
			String screenshotnameString = PageObjects.login.takeScreenshot(result.getMethod().getDescription());
			System.out.println(screenshotnameString);
			test.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder
							.createScreenCaptureFromPath(
									System.getProperty("user.dir") + "/Artifacts/screenshots/" + screenshotnameString)
							.build());
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public void onTestSkipped(ITestResult result) {
		try {
			String screenshotnameString = PageObjects.login.takeScreenshot(result.getMethod().getDescription());
			test.skip("details",
					MediaEntityBuilder
							.createScreenCaptureFromPath(
									System.getProperty("user.dir") + "/Artifacts/screenshots/" + screenshotnameString)
							.build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy HH_mm_ss");
		LocalDateTime now = LocalDateTime.now();

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/Artifacts/Reports/TestReport" + dtf.format(now) + ".html");

		htmlReporter.config().setDocumentTitle("Test Report");
		htmlReporter.config().setReportName("Automation Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.start();

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Application", "BBC News");

		String browserNameString = null;

		try {

			FileInputStream filein = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/Config.properties");

			Properties config = new Properties();
			config.load(filein);

			browserNameString = config.getProperty("Browser");

			BrowserTypes browser = BrowserTypes.valueOf(config.getProperty("Browser"));

			switch (browser) {
			case Chrome:
				Driver.StartBrowser(BrowserTypes.Chrome, 30, null);
				break;
			case ChromeHeadless:
				Driver.StartBrowser(BrowserTypes.ChromeHeadless, 30, null);
				break;
			case Firefox:
				Driver.StartBrowser(BrowserTypes.Firefox, 30, null);
				break;
			case FirefoxHeadless:
				Driver.StartBrowser(BrowserTypes.FirefoxHeadless, 30, null);
				break;
			case Opera:
				Driver.StartBrowser(BrowserTypes.Opera, 30, null);
				break;
			case InternetExplorer:
				Driver.StartBrowser(BrowserTypes.InternetExplorer, 30, GetIEOptions());
				break;
			case Edge:
				Driver.StartBrowser(BrowserTypes.Edge, 30, null);
				break;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		extent.setSystemInfo("Browser ", browserNameString);
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));

		FileInputStream filein;
		try {
			filein = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/Config.properties");

			Properties config = new Properties();
			config.load(filein);

			String logLevelString = config.getProperty("LogLevel");

			if (logLevelString.equals("ALL"))
				WebEventsListener.testLog.logger.setLevel(Level.ALL);
			else if (logLevelString.equals("FINEST"))
				WebEventsListener.testLog.logger.setLevel(Level.FINEST);
			else if (logLevelString.equals("FINER"))
				WebEventsListener.testLog.logger.setLevel(Level.FINER);
			else if (logLevelString.equals("FINE"))
				WebEventsListener.testLog.logger.setLevel(Level.FINE);
			else if (logLevelString.equals("CONFIG"))
				WebEventsListener.testLog.logger.setLevel(Level.CONFIG);
			else if (logLevelString.equals("INFO"))
				WebEventsListener.testLog.logger.setLevel(Level.INFO);
			else if (logLevelString.equals("WARNING"))
				WebEventsListener.testLog.logger.setLevel(Level.WARNING);
			else if (logLevelString.equals("SEVERE"))
				WebEventsListener.testLog.logger.setLevel(Level.SEVERE);
			else if (logLevelString.equals("OFF"))
				WebEventsListener.testLog.logger.setLevel(Level.OFF);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public InternetExplorerOptions GetIEOptions() {
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.introduceFlakinessByIgnoringSecurityDomains();
		options.takeFullPageScreenshot();
		options.ignoreZoomSettings();
		options.enableNativeEvents();
		options.destructivelyEnsureCleanSession();
		options.elementScrollTo(ElementScrollBehavior.BOTTOM);
		return options;
	}

	public EdgeOptions GetEdgeOptions() {
		EdgeOptions options = new EdgeOptions();
		return options;
	}

	public void onFinish(ITestContext context) {
		Driver.StopBrowser();
		extent.flush();
	}

}
