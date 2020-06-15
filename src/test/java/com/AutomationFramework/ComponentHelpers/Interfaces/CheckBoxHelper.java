package com.AutomationFramework.ComponentHelpers.Interfaces;

import org.openqa.selenium.WebElement;

public interface CheckBoxHelper {
	
	void ClickCheckBox(WebElement element);

    boolean IsCheckboxChecked(WebElement element);

    boolean IsCheckboxEnbaled(WebElement element);
}
