package com.AutomationFramework.ComponentHelpers;

import org.openqa.selenium.WebElement;

import com.AutomationFramework.ComponentHelpers.Interfaces.LinkHelper;

public class Link implements LinkHelper {

	/**
	 * Determines if link is enabled
	 * 
	 * @author Ravi Kota
	 * @param element : WebElement
	 * @category Link Helper
	 * @return Returns True if Link is enabled else False
	 */
	public boolean IsLinkEnabled(WebElement element) {
		return element.isEnabled();
	}

	/**
	 * Retrieves Link's text
	 * 
	 * @author Ravi Kota
	 * @param element : WebElement
	 * @category Link Helper
	 * @return Returns link's visible text
	 */
	public String GetLinkText(WebElement element) {
		return element.getText();
	}

	/**
	 * Clicks on Link
	 * 
	 * @author Ravi Kota
	 * @param element : WebElement
	 * @category Link Helper
	 */
	public void ClickOnLink(WebElement element) {
		element.click();

	}

}
