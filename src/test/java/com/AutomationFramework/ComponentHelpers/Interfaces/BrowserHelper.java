package com.AutomationFramework.ComponentHelpers.Interfaces;

import org.openqa.selenium.WebElement;

public interface BrowserHelper {

	  void MoveForward();

      void MoveBackward();

      void BrowserMaximise();

      void BrowserMinimise();

      void BrowserRefresh();

      void NavigateToUrl(String url);

      String GetBrowserTitle();

      String GetBrowserUrl();

      void SwitchToWindow(int index);

      void SwitchToParent();

      void SwitchToFrame(WebElement frameElement);
	
}
