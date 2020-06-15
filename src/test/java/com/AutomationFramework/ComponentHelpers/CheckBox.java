package com.AutomationFramework.ComponentHelpers;

import org.openqa.selenium.WebElement;

import com.AutomationFramework.ComponentHelpers.Interfaces.CheckBoxHelper;

public class CheckBox implements CheckBoxHelper {

	/**
	 * Clicks on specified CheckBox
	 * 
	 * @author Ravi Kota
	 * @category CheckBox Helper
	 * @param element : Checkbox WebElement
	 */
	public void ClickCheckBox(WebElement element) {
		element.click();
	}

	/**
	 * Determines if CheckBox is Checked
	 * 
	 * @author Ravi Kota
	 * @category CheckBox Helper
	 * @param element : Checkbox WebElement
	 * @return Returns True if checkbox is checked else False
	 */
	public boolean IsCheckboxChecked(WebElement element) {
		String flag = element.getAttribute("checked");
		if (flag == null) {
			return false;
		} else
			return true;
	}

	/**
	 * @author Ravi Kota
	 * @category CheckBox Helper
	 * @param element : Checkbox WebElement
	 * @return Returns True if checkbox is checked else False
	 */
	public boolean IsCheckboxEnbaled(WebElement element) {
		// TODO Auto-generated method stub
		return false;
	}

}
