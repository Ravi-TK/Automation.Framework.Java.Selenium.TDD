package com.AutomationFramework.ComponentHelpers.Interfaces;

import org.openqa.selenium.WebElement;

public interface RadioButtonHelper {

	 boolean IsRadioButtonSelected(WebElement element);

     boolean IsRadioButtonEnabled(WebElement element);

     void ClickOnRadioButton(WebElement element);
}
