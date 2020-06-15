package com.AutomationFramework.ComponentHelpers.Interfaces;

import org.openqa.selenium.WebElement;

public interface LabelHelper {

	   boolean IsLabelEnabled(WebElement element);

       String GetLabelText(WebElement element);

       void ClickOnLabel(WebElement element);
       
}
