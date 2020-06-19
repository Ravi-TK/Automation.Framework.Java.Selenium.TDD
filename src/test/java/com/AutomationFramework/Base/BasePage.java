package com.AutomationFramework.Base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.AutomationFramework.Core.Driver;


public class BasePage {

	public Helpers Helper =new Helpers(); 
	
	
	public String takeScreenshot(String fileName) throws IOException {
		File scrFile = ((TakesScreenshot) Driver.Browser).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		String screenshotFileNameString=fileName+System.currentTimeMillis() + ".png";
		FileUtils.copyFile(scrFile, new File(currentDir + "/Artifacts/screenshots/" +screenshotFileNameString ));
		return screenshotFileNameString;
	}
}