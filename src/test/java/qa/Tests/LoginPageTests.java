package qa.Tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.AutomationFramework.Core.BrowserTypes;
import com.AutomationFramework.Core.Driver;

import qa.PageObjectsCollections.PageObjects;;

public class LoginPageTests {
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+
				"\\BrowserDrivers\\chromedriver.exe");
		Driver.StartBrowser(BrowserTypes.Chrome, 30 , null);
	}
	
	@Test
	public void login() throws InterruptedException, IOException
	{
		PageObjects.login.Helper.BrowserHelper.NavigateToUrl(PageObjects.login.loginPageURLString);
		
		Thread.sleep(2000);
		PageObjects.login.emailTextBoxWebElement.sendKeys("emailtestqaz@gmail.com");
		PageObjects.login.Helper.BrowserHelper.GetBrowserTitle();
		PageObjects.login.Helper.ButtonHelper.GetButtonText(PageObjects.login.signIn_Button_WebElement);
		PageObjects.login.Helper.BrowserHelper.BrowserMinimise();
		Thread.sleep(2000);
		PageObjects.login.Helper.BrowserHelper.BrowserMaximise();
		PageObjects.login.takeScreenshot("test");
		PageObjects.login.Helper.ButtonHelper.ClickButton(PageObjects.login.signIn_Button_WebElement);
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		Driver.StopBrowser();
	}
}
