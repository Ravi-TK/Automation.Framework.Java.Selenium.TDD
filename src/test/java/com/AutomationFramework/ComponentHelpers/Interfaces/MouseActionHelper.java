package com.AutomationFramework.ComponentHelpers.Interfaces;

import org.openqa.selenium.WebElement;

public interface MouseActionHelper {
	
	void DragNDrop(WebElement src, WebElement trg);

	void ClickNHoldNDrop(WebElement element, WebElement trg, int x, int y);

	void DoubleClickOnElement(WebElement element);
}
