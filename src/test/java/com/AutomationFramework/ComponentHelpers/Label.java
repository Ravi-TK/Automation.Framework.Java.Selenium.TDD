package com.AutomationFramework.ComponentHelpers;

import org.openqa.selenium.WebElement;

import com.AutomationFramework.ComponentHelpers.Interfaces.LabelHelper;

public class Label implements LabelHelper {

	/**
	 * Determines if label is enabled
	 * 
	 * @author Ravi Kota
	 * @param element : WebElement
	 * @category Label Helper
	 * @return Returns True if label is enabled else False
	 */
	public boolean IsLabelEnabled(WebElement element) {
		return element.isEnabled();
	}

	/**
	 * Retrieves text of the Label
	 * 
	 * @author Ravi Kota
	 * @param element : WebElement
	 * @category Label Helper
	 * @return Returns text displayed on label
	 */
	public String GetLabelText(WebElement element) {
		return element.getText();
	}

	/**
	 * Clicks on the Label
	 * 
	 * @author Ravi Kota
	 * @param element : WebElement
	 * @category Label Helper
	 */
	public void ClickOnLabel(WebElement element) {
		element.click();

	}

}
