package com.AutomationFramework.Core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import com.AutomationFramework.Base.BasePage;

public class WebEventsListener extends BasePage implements WebDriverEventListener {

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy");
	static LocalDateTime datewithouttime = LocalDateTime.now();

	public static Log testLog = new Log(
			System.getProperty("user.dir") + "\\Artifacts\\Logs\\log" + dtf.format(datewithouttime) + ".log");

	public void afterAlertAccept(WebDriver driver) {
		System.out.println("After alert accepted");
		testLog.logger.info("After alert accepted\n");
	}

	public void afterAlertDismiss(WebDriver arg0) {
		System.out.println("After alert dismissed");
		testLog.logger.info("After alert dismissed\n");
	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
	}

	public void afterClickOn(WebElement element, WebDriver arg1) {
		System.out.println("Clicked on: " + element.toString());
		testLog.logger.info("Clicked on: " + element.toString()+"\n");
	}

	public void afterFindBy(By by, WebElement webelement1, WebDriver webelement2) {
		System.out.println("Found Element By : " + by.toString() + " Web Element 1 => " + webelement1.toString()
				+ "Web Element 2 => " + webelement2.toString());
		testLog.logger.info("Found Element By : " + by.toString() + " Web Element 1 => " + webelement1.toString()
				+ "Web Element 2 => " + webelement2.toString()+"\n");
	}

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		System.out.println("After screenshots taken ");
		testLog.logger.info("After screenshots taken\n");

	}

	public void afterGetText(WebElement arg0, WebDriver arg1, String text) {
		System.out.println("After getting text => " + text + " WebElement 1 => " + arg0.toString() + " WebElement 2 => "
				+ arg1.toString());
		testLog.logger.info("After getting text => " + text + " WebElement 1 => " + arg0.toString()
				+ " WebElement 2 => " + arg1.toString()+"\n");
	}

	public void afterNavigateBack(WebDriver arg0) {
		System.out.println("After navigated back ");
		testLog.logger.info("After navigated back ");
	}

	public void afterNavigateForward(WebDriver arg0) {
		System.out.println("After navigated forwared ");
		testLog.logger.info("After navigated forwared\n");
	}

	public void afterNavigateRefresh(WebDriver arg0) {
		System.out.println("After refersh ");
		testLog.logger.info("After refersh\n");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to:'" + url + "'");
		testLog.logger.info("Navigated to:'" + url + "'\n");
	}

	public void afterScript(String arg0, WebDriver arg1) {
		System.out.println("After script ");
		testLog.logger.info("After script\n");
	}

	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		System.out.println("After switched to " + arg0);
		testLog.logger.info("After switched to " + arg0+"\n");
	}

	public void beforeAlertAccept(WebDriver arg0) {
		System.out.println("Before Alert Accepted ");
		testLog.logger.info("Before Alert Accepted\n");
	}

	public void beforeAlertDismiss(WebDriver arg0) {
		System.out.println("Before Alert Dismissed ");
		testLog.logger.info("Before Alert Dismissed\n");
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		System.out.println("Before changing value ");
		testLog.logger.info("Before changing value\n");
	}

	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		System.out.println("Before clicking WebElement => " + arg0.toString());
		testLog.logger.info("Before clicking WebElement => " + arg0.toString()+"\n");

	}

	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		System.out.println("Before finding By");
		testLog.logger.info("Before finding By\n");
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		System.out.println("Before getting screenshot ");
		testLog.logger.info("Before getting screenshot\n");
	}

	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		System.out.println("Before getting text of element=" + arg0.toString());
		testLog.logger.info("Before getting text of element=" + arg0.toString()+"\n");

	}

	public void beforeNavigateBack(WebDriver arg0) {
		System.out.println("Before navigating back ");
		testLog.logger.info("Before navigating back\n");
	}

	public void beforeNavigateForward(WebDriver arg0) {
		System.out.println("Before navigating forwarded");
		testLog.logger.info("Before navigating forwarded\n");
	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		System.out.println("Before refreshing browser");
		testLog.logger.info("Before refreshing browser\n");
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
		testLog.logger.info("Before navigating to: '" + url + "'\n");
	}

	public void beforeScript(String arg0, WebDriver arg1) {
		System.out.println("Before script " + arg0.toString());
		testLog.logger.info("Before script " + arg0.toString()+"\n");
	}

	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		System.out.println("Before switching to window " + arg0.toString());
		testLog.logger.info("Before switching to window " + arg0.toString()+"\n");
	}

	public void onException(Throwable error, WebDriver arg1) {
		System.out.println("Exception occured: " + error);
		testLog.logger.severe("Stack Trace : " + error);
		testLog.logger.severe("\n\n");
	}

}
