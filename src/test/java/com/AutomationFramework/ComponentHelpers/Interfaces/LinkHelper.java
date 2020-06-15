package com.AutomationFramework.ComponentHelpers.Interfaces;

import org.openqa.selenium.WebElement;

public interface LinkHelper {

	  boolean IsLinkEnabled(WebElement element);

      String GetLinkText(WebElement element);

      void ClickOnLink(WebElement element);
}
