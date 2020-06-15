package com.AutomationFramework.ComponentHelpers.Interfaces;

import org.openqa.selenium.WebElement;

public interface TextBoxHelper {

	  boolean IsTextBoxEnabled(WebElement element);

      void TypeInTextBox(WebElement element, String text);

      String GetTextBoxText(WebElement element);

      void ClearTextBoxText(WebElement element);
}
