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
	
	
	public void takeScreenshot(String fileName) throws IOException {
		File scrFile = ((TakesScreenshot) Driver.Browser).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/Artifacts/screenshots/" + fileName+System.currentTimeMillis() + ".png"));
	}


}