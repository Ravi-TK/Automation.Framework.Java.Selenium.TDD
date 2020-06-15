package com.AutomationFramework.ComponentHelpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.AutomationFramework.ComponentHelpers.Interfaces.ComboBoxHelper;

public class ComboBox implements ComboBoxHelper {

	private static Select select;

	/**
	 * Selects an item from combobox available at specified index
	 * 
	 * @author Ravi Kota
	 * @category ComboBox Helper
	 * @param element : ComboBox WebElement
	 * @param index   : item number from top to be selected
	 */
	public void SelectElementByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);

	}

	/**
	 * Selects an item with specified Value from combobox
	 * 
	 * @author Ravi Kota
	 * @category ComboBox Helper
	 * @param element : ComboBox WebElement
	 * @param value   : Value of item to be selected in the combobox
	 */
	public void SelectElementByValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);

	}

	/**
	 * Selects an item from combobox by visible Text
	 * 
	 * @author Ravi Kota
	 * @category ComboBox Helper
	 * @param element : ComboBox WebElement
	 * @param value   : Value of item to be selected in the combobox
	 */
	public void SelectElementByVisibleText(WebElement element, String visibleText) {
		select = new Select(element);
		select.selectByVisibleText(visibleText);

	}

	/**
	 * Verifies if combobox is enabled
	 * 
	 * @author Ravi Kota
	 * @category ComboBox Helper
	 * @param element : ComboBox WebElement
	 * @return Returns True if combobox is enabled, else false
	 */
	public boolean IsComboBoxEnabled(WebElement element) {
		return element.isEnabled();
	}

}
