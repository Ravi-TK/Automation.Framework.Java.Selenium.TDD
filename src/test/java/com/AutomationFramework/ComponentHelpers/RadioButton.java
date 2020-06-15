package com.AutomationFramework.ComponentHelpers;

import org.openqa.selenium.WebElement;

import com.AutomationFramework.ComponentHelpers.Interfaces.RadioButtonHelper;

public class RadioButton implements RadioButtonHelper {

	/**
	 * Determines if the Radio button is selected
	 * 
	 * @author Ravi Kota
	 * @param element : WebElement
	 * @category RadioButton Helper
	 * @return Returns True if radio button is selected else False
	 */
	public boolean IsRadioButtonSelected(WebElement element) {
		String flag = element.getAttribute("checked");

		if (flag == null)
			return false;
		else
			return true;
	}

	/**
	 * Determines if the radio button is enabled
	 * 
	 * @author Ravi Kota
	 * @param element : WebElement
	 * @category RadioButton Helper
	 * @return Returns True if radio button is enabled else False
	 */
	public boolean IsRadioButtonEnabled(WebElement element) {
		return element.isEnabled();

	}

	/**
	 * Clicks on specified radio button
	 * 
	 * @author Ravi Kota
	 * @param element : WebElement
	 * @category RadioButton Helper
	 */
	public void ClickOnRadioButton(WebElement element) {
		element.click();

	}

}
