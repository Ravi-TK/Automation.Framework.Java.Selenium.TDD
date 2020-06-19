package qa.Tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.AutomationFramework.Core.BrowserTypes;
import com.AutomationFramework.Core.Driver;
import qa.PageObjectsCollections.PageObjects;


public class LoginPageTests extends TestInitaliser {
	
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+
				"\\BrowserDrivers\\chromedriver.exe");
		Driver.StartBrowser(BrowserTypes.Chrome, 30 , null);
	}
	
	@Test(description = "Customer Login Feature")
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
		PageObjects.login.Helper.ButtonHelper.ClickButton(PageObjects.login.signIn_Button_WebElement);
		Thread.sleep(3000);
	}
	
	@Test(description = "KCOM Feature Login")
	public void loginKCOM() throws InterruptedException, IOException
	{		
		PageObjects.login.Helper.BrowserHelper.NavigateToUrl(PageObjects.login.loginKCOMURLString);
		
		Thread.sleep(2000);
		System.out.println(PageObjects.login.Helper.BrowserHelper.GetBrowserTitle());
		PageObjects.login.Helper.BrowserHelper.BrowserMaximise();
		Thread.sleep(1000);
		PageObjects.login.Helper.LinkHelper.ClickOnLink(PageObjects.login.kcomMyAccountLinkElement);
	}
	
	@AfterClass
	public void tearDown()
	{
		System.out.println("After class");
		Driver.StopBrowser();
	}
}
