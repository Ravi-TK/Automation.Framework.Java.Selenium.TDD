package com.AutomationFramework.ComponentHelpers;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import com.AutomationFramework.ComponentHelpers.Interfaces.BrowserHelper;
import com.AutomationFramework.Core.Driver;

public class Browser implements BrowserHelper {

	/**
	 * Moves forward in the browser
	 * 
	 * @author Ravi Kota
	 * @category Browser Helper
	 */
	public void MoveForward() {
		Driver.Browser.navigate().forward();
	}

	/**
	 * Moves backward in the browser
	 * 
	 * @author Ravi Kota
	 * @category Browser Helper
	 */
	public void MoveBackward() {
		Driver.Browser.navigate().back();
	}

	/**
	 * Maximise the browser
	 * 
	 * @author Ravi Kota
	 * @category Browser Helper
	 */
	public void BrowserMaximise() {
		Driver.Browser.manage().window().maximize();
	}

	/**
	 * Minimise browser
	 * 
	 * @author Ravi Kota
	 * @category Browser Helper
	 */
	public void BrowserMinimise() {
		Driver.Browser.manage().window().setPosition(new Point(0, -1000));
		;
	}

	/**
	 * Refreshes browser
	 * 
	 * @author Ravi Kota
	 * @category Browser Helper
	 */
	public void BrowserRefresh() {
		Driver.Browser.navigate().refresh();
	}

	/**
	 * Navigate to specified URL
	 * 
	 * @author Ravi Kota
	 * @category Browser Helper
	 */
	public void NavigateToUrl(String url) {
		Driver.Browser.navigate().to(url);
	}

	/**
	 * Retrieves browser title
	 * 
	 * @author Ravi Kota
	 * @category Browser Helper
	 * @return Browser Title
	 */
	public String GetBrowserTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Retrieves browser's current URL
	 * 
	 * @author Ravi Kota
	 * @category Browser Helper
	 */
	public String GetBrowserUrl() {
		return Driver.Browser.getCurrentUrl();
	}

	/**
	 * Switches to specified window
	 * 
	 * @author Ravi Kota
	 * @category Browser Helper
	 * @param index : window number to switch
	 */
	public void SwitchToWindow(int index) {
		List<String> windows = (List<String>) Driver.Browser.getWindowHandles();

		if ((windows.size() - 1) < index) {
			throw new NoSuchWindowException("Invalid Browser Window Index" + index);
		}

		Driver.Browser.switchTo().window(windows.get(index));
	}

	/**
	 * Closes all child windows and switches to the parent window
	 * 
	 * @author Ravi Kota
	 * @category Browser Helper
	 */
	public void SwitchToParent() {
		List<String> windowids = (List<String>) Driver.Browser.getWindowHandles();

		for (int i = windowids.size() - 1; i > 0; i--) {
			Driver.Browser.switchTo().window(windowids.get(i));
			Driver.Browser.close();
		}
		Driver.Browser.switchTo().window(windowids.get(0));
	}

	/**
	 * Switches webdriver to specified iframe component
	 * 
	 * @author Ravi Kota
	 * @category Browser Helper
	 * @param frameElement : IFrame WebElement
	 */
	public void SwitchToFrame(WebElement frameElement) {
		Driver.Browser.switchTo().frame(frameElement);
	}

}
