package com.AutomationFramework.ComponentHelpers.Interfaces;

import org.openqa.selenium.WebElement;

public interface ComboBoxHelper {

	  void SelectElementByIndex(WebElement element, int index);

      void SelectElementByValue(WebElement element, String value);

      void SelectElementByVisibleText(WebElement element, String visibleText);

      boolean IsComboBoxEnabled(WebElement element);
}
