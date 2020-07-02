package qa.Tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.AutomationFramework.Core.BrowserTypes;
import com.AutomationFramework.Core.Driver;
import qa.PageObjectsCollections.PageObjects;
import qa.Pages.loginpage;


public class LoginPageTests extends TestInitaliser {
	
	@BeforeClass
	public void setup()
	{
	}
	
	@Test(description = "Customer Login Feature")
	public void login() throws InterruptedException, IOException
	{ 		
		PageObjects.login.Helper.BrowserHelper.NavigateToUrl(PageObjects.login.loginPageURLString);
		PageObjects.login.emailTextBoxWebElement.sendKeys("emailtestqaz@gmail.com");
		PageObjects.login.Helper.BrowserHelper.GetBrowserTitle();
		PageObjects.login.Helper.ButtonHelper.GetButtonText(PageObjects.login.signIn_Button_WebElement);
		PageObjects.login.Helper.BrowserHelper.BrowserMaximise();
		PageObjects.login.Helper.ButtonHelper.ClickButton(PageObjects.login.signIn_Button_WebElement);
	}
	
	@Test(description = "KCOM Feature Login")
	public void loginKCOM() throws InterruptedException, IOException
	{		
		PageObjects.login.Helper.BrowserHelper.NavigateToUrl(PageObjects.login.loginKCOMURLString);
		System.out.println(PageObjects.login.Helper.BrowserHelper.GetBrowserTitle());
		PageObjects.login.Helper.BrowserHelper.BrowserMaximise();
		PageObjects.login.Helper.LinkHelper.ClickOnLink(PageObjects.login.kcomMyAccountLinkElement);
	}
	
	@AfterClass
	public void tearDown()
	{
	}
}
