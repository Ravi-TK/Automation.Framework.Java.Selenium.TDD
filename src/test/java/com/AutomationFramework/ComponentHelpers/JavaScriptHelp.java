package com.AutomationFramework.ComponentHelpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;

import com.AutomationFramework.ComponentHelpers.Interfaces.JavaScriptPopUpHelper;
import com.AutomationFramework.Core.Driver;

public class JavaScriptHelp implements JavaScriptPopUpHelper {

	/**
	 * @author Ravi Kota
	 * @category JavaScriptPopUp Helper
	 * @return Returns True if pop up is present else False
	 */
	public boolean IsPopUpPresent() {
		try {
			Driver.Browser.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	/**
	 * Retrieves text displayed in the pop up in the browser
	 * 
	 * @author Ravi Kota
	 * @category JavaScriptPopUp Helper
	 * @return Returns Text displayed in the pop up
	 */
	public String GetPopUpText() {
		if (!IsPopUpPresent())
			return "Warning : No Pop Up Present";
		else
			return Driver.Browser.switchTo().alert().getText();
	}

	/**
	 * Clicks Ok button on the pop up in the browser
	 * 
	 * @author Ravi Kota
	 * @category JavaScriptPopUp Helper
	 */
	public void ClickOkOnPopup() {
		Driver.Browser.switchTo().alert().accept();

	}

	/**
	 * Clicks cancel button on the pop up in the browser
	 * 
	 * @author Ravi Kota
	 * @category JavaScriptPopUp Helper
	 */
	public void ClickCancelOnPopup() {
		Driver.Browser.switchTo().alert().dismiss();

	}

	/**
	 * Scroll to specified WebElement
	 * 
	 * @author Ravi Kota
	 * @category JavaScriptPopUp Helper
	 * @param ele : WebElement
	 */
	public void ScrollToElement(WebElement ele) {
		((JavascriptExecutor) Driver.Browser).executeScript("arguments[0].scrollIntoView(true);", ele);

	}

	/**
	 * Enters specified text in the pop up in the browser
	 * 
	 * @author Ravi Kota
	 * @category JavaScriptPopUp Helper
	 * @param inputText : Text to be entered in the pop up
	 */
	public void TypeTextInPopUp(String inputText) {
		Driver.Browser.switchTo().alert().sendKeys(inputText);

	}

}
