package com.AutomationFramework.ComponentHelpers.Interfaces;

import org.openqa.selenium.WebElement;

public interface AutoSuggestHelper {

	void SelectItemInList(WebElement dropDownList, String DropDownListEntriesLocator, String searchChar, String itemToClick) throws InterruptedException;
}
