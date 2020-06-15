package com.AutomationFramework.ComponentHelpers.Interfaces;

import org.openqa.selenium.WebElement;

public interface JavaScriptPopUpHelper {

	 boolean IsPopUpPresent();

     String GetPopUpText();

     void ClickOkOnPopup();

     void ClickCancelOnPopup();

     void ScrollToElement(WebElement ele);

     void TypeTextInPopUp(String inputText);
}
