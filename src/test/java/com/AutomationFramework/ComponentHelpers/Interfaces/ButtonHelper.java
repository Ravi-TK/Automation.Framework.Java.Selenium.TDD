package com.AutomationFramework.ComponentHelpers.Interfaces;

import org.openqa.selenium.WebElement;

public interface ButtonHelper {

	boolean IsButtonEnabled(WebElement element);

    void ClickButton(WebElement element);

    String GetButtonText(WebElement element);
}
