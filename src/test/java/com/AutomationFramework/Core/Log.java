package com.AutomationFramework.Core;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
	public Logger logger; 
	private FileHandler fHandler;
	
	public Log(String filename) 
	{
		File file=new File(filename);
		
		if(!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		try {
			fHandler=new FileHandler(filename,true);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		logger=Logger.getLogger("TestLog");
		logger.addHandler(fHandler);
		SimpleFormatter formatter =new SimpleFormatter();
		fHandler.setFormatter(formatter);
		logger.setUseParentHandlers(false);
	}

}
