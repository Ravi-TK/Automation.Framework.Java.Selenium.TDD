package com.AutomationFramework.ComponentHelpers;

import org.openqa.selenium.WebElement;

import com.AutomationFramework.ComponentHelpers.Interfaces.ButtonHelper;

public class Button implements ButtonHelper {

	/**
	 * Determines if the element is enabled or not
	 * 
	 * @author Ravi Kota
	 * @category Button Helper
	 * @param element : WebElement
	 * @return Returns True if button is enabled else False
	 */
	public boolean IsButtonEnabled(WebElement element) {
		return element.isEnabled();
	}

	/**
	 * Clicks on specified button
	 * 
	 * @author Ravi Kota
	 * @category Button Helper
	 * @param element : WebElement
	 */
	public void ClickButton(WebElement element) {
		element.click();
	}

	/**
	 * Retrieve text displayed on specified button
	 * 
	 * @author Ravi Kota
	 * @category Button Helper
	 * @param element : WebElement
	 * @return Returns text displayed on button
	 */
	public String GetButtonText(WebElement element) {
		return element.getText();
	}

}
