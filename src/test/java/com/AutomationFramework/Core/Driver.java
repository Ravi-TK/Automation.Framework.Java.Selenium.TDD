package com.AutomationFramework.Core;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
	
	 private static WebDriverWait _browserWait;
     public static WebDriver Browser;
 	 private  static EventFiringWebDriver event_driver;
	 private static WebDriverEventListener eventListener;
	
	public static void StartBrowser(BrowserTypes browserType, int defaultTimeOut, Object browserOptions)
    {
        switch (browserType)
        {
            case Firefox:
                if (browserOptions != null)
                    Browser = new FirefoxDriver((FirefoxOptions)browserOptions);
                else
                    Browser = new FirefoxDriver();
                break;

            case FirefoxHeadless:
                ((FirefoxOptions)browserOptions).addArguments("--headless");
                Browser = new FirefoxDriver((FirefoxOptions)browserOptions);
                break;

            case InternetExplorer:
                if (browserOptions != null)
                    Browser = new InternetExplorerDriver((InternetExplorerOptions)browserOptions);
                else
                    Browser = new InternetExplorerDriver();
                break;

            case Chrome:
                if (browserOptions != null)
                    Browser = new ChromeDriver((ChromeOptions)browserOptions);
                else
                    Browser = new ChromeDriver();
                break;

            case ChromeHeadless:
                if (browserOptions != null)
                {
                    ((ChromeOptions)browserOptions).addArguments("--headless");
                    ((ChromeOptions)browserOptions).addArguments("disable-gpu");
                }
                else
                {
                    browserOptions = new ChromeOptions();
                    ((ChromeOptions)browserOptions).addArguments("--headless");
                    ((ChromeOptions)browserOptions).addArguments("disable-gpu");
                }

                Browser = new ChromeDriver((ChromeOptions)browserOptions);
                break;

            case Edge:
                if (browserOptions != null)
                    Browser = new EdgeDriver((EdgeOptions)browserOptions);
                else
                    Browser = new EdgeDriver();
                break;

            case Safari:
                if (browserOptions != null)
                    Browser = new SafariDriver((SafariOptions)browserOptions);
                else
                    Browser = new SafariDriver();
                break;

            case Opera:
                if (browserOptions != null)
                    Browser = new OperaDriver((OperaOptions)browserOptions);
                else
                    Browser = new OperaDriver();
                break;
        }
        _browserWait = new WebDriverWait(Browser, defaultTimeOut);
        
        if (_browserWait == null || Browser == null)
        {
            throw new NullPointerException("The WebDriver browser wait instance has failed to initialized, ");
        }
        
        event_driver = new EventFiringWebDriver(Browser);
        eventListener = new WebEventsListener();
        event_driver.register(eventListener);
		Browser = event_driver;
    }

	 public static void StopBrowser()
     {
         Browser.quit();
         Browser = null;
         _browserWait = null;
     }
	 	 
}



