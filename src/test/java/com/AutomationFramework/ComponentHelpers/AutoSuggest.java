package com.AutomationFramework.ComponentHelpers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.AutomationFramework.ComponentHelpers.Interfaces.AutoSuggestHelper;
import com.AutomationFramework.Core.Driver;

public class AutoSuggest implements AutoSuggestHelper {

	/**
	 * Selects an item from a Autosuggest drop down
	 * 
	 * @author Ravi Kota
	 * @category Browser Helper
	 * @param dropDownList                    :dropdown webelement
	 * @param DropDownListEntriesLocator:item listing index in drop down after
	 *                                        entering search char
	 * @param searchChar:search               characters
	 * @param itemToClick                     :item to click
	 */
	public void SelectItemInList(WebElement dropDownList, String DropDownListEntriesLocator, String searchChar,
			String itemToClick) throws InterruptedException {

		// supply initial char
		dropDownList.sendKeys(searchChar);
		Thread.sleep(2000);

		// wait for auto suggest list
		List<WebElement> elements = Driver.Browser.findElements((By.xpath(DropDownListEntriesLocator)));

		for (WebElement ele : elements) {
			if (ele.getText().equalsIgnoreCase(itemToClick)) {
				ele.click();
				break;
			}
		}

	}

}
