package qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import com.AutomationFramework.Base.BasePage;
import com.AutomationFramework.Core.Driver;

public class loginpage extends BasePage {

	public String loginPageURLString = "https://account.bbc.com/signin";

	public String loginKCOMURLString = "https://www.kcomhome.com/";

	@FindBy(how = How.XPATH, using = "/html//input[@id='user-identifier-input']")
	public WebElement emailTextBoxWebElement;

	@FindBy(how = How.XPATH, using = "/html//input[@id='password-input']")
	public WebElement passwordTextBoxWebElement;

	@FindBy(how = How.XPATH, using = "/html//button[@id='submit-button']")
	public WebElement signIn_Button_WebElement;

	@FindBy(how = How.XPATH, using = "//li[@id='nav-two']/a[@href='/umbraco/surface/general/myaccountt']")
	public WebElement kcomMyAccountLinkElement;
	
	// Initialising the Page Objects:
	public loginpage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver.Browser, 15), this);
	}

}
