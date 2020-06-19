package com.AutomationFramework.Core;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.AutomationFramework.Base.BasePage;

public class WebEventsListener extends BasePage implements WebDriverEventListener {

	public void afterAlertAccept(WebDriver driver) {
		System.out.println("After alert accepted");

	}

	public void afterAlertDismiss(WebDriver arg0) {
		System.out.println("After alert dismissed");

	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub

	}

	public void afterClickOn(WebElement element, WebDriver arg1) {
		System.out.println("Clicked on: " + element.toString());

	}

	public void afterFindBy(By by, WebElement webelement1, WebDriver webelement2) {
		System.out.println("Found Element By : " + by.toString() + " Web Element 1 => " + webelement1.toString()
				+ "Web Element 2 => " + webelement2.toString());

	}

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		System.out.println("After screenshots taken ");

	}

	public void afterGetText(WebElement arg0, WebDriver arg1, String text) {
		System.out.println("After getting text => " + text + " WebElement 1 => " + arg0.toString() + " WebElement 2 => "
				+ arg1.toString());

	}

	public void afterNavigateBack(WebDriver arg0) {
		System.out.println("After navigated back ");

	}

	public void afterNavigateForward(WebDriver arg0) {
		System.out.println("After navigated forwared ");

	}

	public void afterNavigateRefresh(WebDriver arg0) {
		System.out.println("After refersh ");

	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to:'" + url + "'");
	}

	public void afterScript(String arg0, WebDriver arg1) {
		System.out.println("After script ");

	}

	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		System.out.println("After switched to " + arg0);

	}

	public void beforeAlertAccept(WebDriver arg0) {
		System.out.println("Before Alert Accepted ");

	}

	public void beforeAlertDismiss(WebDriver arg0) {
		System.out.println("Before Alert Dismissed ");

	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		System.out.println("Before changing value ");

	}

	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		System.out.println("Before clicking WebElement => " + arg0.toString());

	}

	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		System.out.println("Before finding By");

	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		System.out.println("Before getting screenshot ");

	}

	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		System.out.println("Before getting text of element=" + arg0.toString());

	}

	public void beforeNavigateBack(WebDriver arg0) {
		System.out.println("Before navigating back ");

	}

	public void beforeNavigateForward(WebDriver arg0) {
		System.out.println("Before navigating forwarded");

	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		System.out.println("Before refreshing browser");

	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");

	}

	public void beforeScript(String arg0, WebDriver arg1) {
		System.out.println("Before script " + arg0.toString());

	}

	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		System.out.println("Before switching to window " + arg0.toString());

	}

	public void onException(Throwable error, WebDriver arg1) {
		System.out.println("Exception occured: " + error);
//		try {
//			//takeScreenshot("TestFailed");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		//need to put this in the log file 

	}

}
