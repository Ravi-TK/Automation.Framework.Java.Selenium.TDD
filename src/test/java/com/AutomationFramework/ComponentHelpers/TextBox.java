package com.AutomationFramework.ComponentHelpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.AutomationFramework.ComponentHelpers.Interfaces.TextBoxHelper;
import com.AutomationFramework.Core.Driver;

public class TextBox implements TextBoxHelper {

	/**
	 * Determines if TextBox is enabled
	 * 
	 * @author Ravi Kota
	 * @param element : WebElement
	 * @category TextBox Helper
	 * @return Returns True if Text button is enabled else False
	 */
	public boolean IsTextBoxEnabled(WebElement element) {
		((JavascriptExecutor) Driver.Browser).executeScript("arguments[0].scrollIntoView(true);", element);
		return element.isEnabled();
	}

	/**
	 * Enters specified text in the specified Textbox WebElement
	 * 
	 * @author Ravi Kota
	 * @param element   : WebElement
	 * @param text:Text to be enetered in the textbox
	 * @category TextBox Helper
	 */
		public void TypeInTextBox(WebElement element, String text) {
		((JavascriptExecutor) Driver.Browser).executeScript("arguments[0].scrollIntoView(true);", element);
		element.sendKeys(text);

	}

	/**
	 * Retrieves text inside specified TextBox
	 * 
	 * @author Ravi Kota
	 * @param element : WebElement
	 * @category TextBox Helper
	 * @return Text displayed in the text box
	 */
	public String GetTextBoxText(WebElement element) {
		((JavascriptExecutor) Driver.Browser).executeScript("arguments[0].scrollIntoView(true);", element);
		return element.getText();
	}

	/**
	 * Clears text of specified TextBox
	 * 
	 * @author Ravi Kota
	 * @param element : WebElement
	 * @category TextBox Helper
	 */
	public void ClearTextBoxText(WebElement element) {
		element.clear();

	}
}
