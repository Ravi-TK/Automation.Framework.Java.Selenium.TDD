package qa.Listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.AutomationFramework.Core.BrowserTypes;
import com.AutomationFramework.Core.Driver;
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

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName(), result.getMethod().getDescription());
	}

	public void onTestSuccess(ITestResult result) {
		try {
			String screenshotnameString = PageObjects.login.takeScreenshot(result.getMethod().getDescription());
			System.out.println(screenshotnameString);
			test.pass(result.getMethod().getDescription(), MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir")+"/Artifacts/screenshots/" + screenshotnameString).build());
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public void onTestFailure(ITestResult result) {
		try 
		{
			String screenshotnameString = PageObjects.login.takeScreenshot(result.getMethod().getDescription());
			System.out.println(screenshotnameString);
			test.fail(result.getThrowable().getMessage(), MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir")+"/Artifacts/screenshots/" + screenshotnameString).build());
		} catch (IOException e) {
			e.printStackTrace();
		
		}
	}

	public void onTestSkipped(ITestResult result) {
		try {
			String screenshotnameString = PageObjects.login.takeScreenshot(result.getMethod().getDescription());
			test.skip("details", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir")+"/Artifacts/screenshots/" + screenshotnameString).build());
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context)   {
		
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy HH_mm_ss");  
		   LocalDateTime now = LocalDateTime.now();  
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/TestReport"+dtf.format(now)+".html");
		
		htmlReporter.config().setDocumentTitle("Test Report");
		htmlReporter.config().setReportName("Automation Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.start();
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Application", "BBC News");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
	
		
		try {
			
			FileInputStream filein=new FileInputStream(System.getProperty("user.dir")+"/src/test/java/Config.properties");
			
			Properties config =new Properties();
			config.load(filein);
			
			BrowserTypes browser = BrowserTypes.valueOf(config.getProperty("Browser"));
			
			switch (browser) {
			case Chrome:
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+
						"\\BrowserDrivers\\chromedriver.exe");
				Driver.StartBrowser(BrowserTypes.Chrome, 30 , null);
				break;
			case ChromeHeadless:
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+
						"\\BrowserDrivers\\chromedriver.exe");
				Driver.StartBrowser(BrowserTypes.ChromeHeadless, 30 , null);
				break;
			default:
				break;
			}
			
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}

	public void onFinish(ITestContext context) {
		System.out.println("******After Finish********");
		extent.flush();
	}

}
