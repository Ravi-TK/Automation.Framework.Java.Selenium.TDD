package com.AutomationFramework.ComponentHelpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.AutomationFramework.ComponentHelpers.Interfaces.MouseActionHelper;
import com.AutomationFramework.Core.Driver;

public class MouseAction implements MouseActionHelper {

	/**
	 * Drag an element and drop it in the specified element
	 * 
	 * @author Ravi Kota
	 * @param src : WebElement
	 * @param trg : Target webelement
	 * @category MouseAction Helper
	 */
	public void DragNDrop(WebElement src, WebElement trg) {
		Actions act = new Actions(Driver.Browser);

		act.dragAndDrop(src, trg).build().perform();

	}

	/**
	 * Clicks on a element, hold and drop it on the specified location
	 * 
	 * @author Ravi Kota
	 * @param element : WebElement
	 * @param trg     : Target webelement
	 * @param x       : x-axis coordinate
	 * @param y       : y-axis coordinate
	 * @category MouseAction Helper
	 */
	public void ClickNHoldNDrop(WebElement element, WebElement trg, int x, int y) {

		Actions act = new Actions(Driver.Browser);

		act.clickAndHold(element).moveToElement(trg, x, y).release().build().perform();
	}

	/**
	 * Double clicks on the specified element
	 * 
	 * @author Ravi Kota
	 * @param element : WebElement
	 * @category MouseAction Helper
	 */
	public void DoubleClickOnElement(WebElement element) {
		Actions act = new Actions(Driver.Browser);

		act.doubleClick(element).build().perform();

	}

}
