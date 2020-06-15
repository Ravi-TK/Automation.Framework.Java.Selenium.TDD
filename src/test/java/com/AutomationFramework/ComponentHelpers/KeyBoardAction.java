package com.AutomationFramework.ComponentHelpers;

import org.openqa.selenium.interactions.Actions;
import com.AutomationFramework.ComponentHelpers.Interfaces.KeyBoardActionHelper;
import com.AutomationFramework.Core.Driver;

public class KeyBoardAction implements KeyBoardActionHelper {

	/**
	 * Automate command and key pressing event
	 * 
	 * @author Ravi Kota
	 * @param cmdKey    : Command Key
	 * @param character : Char
	 * @category KeyBoardAction Helper
	 */
	public void SingleCommandKeyAction(String cmdKey, String character) {
		Actions act = new Actions(Driver.Browser);

		act.keyDown(cmdKey).sendKeys(character).keyUp(cmdKey).build().perform();

	}

	/**
	 * Automate the key pressing combination e.g. Ctrl+Shift+T
	 * 
	 * @author Ravi Kota
	 * @param cmdKey1   : Command Key 1
	 * @param cmdKey2   : Command Key 2
	 * @param character : Char
	 * @category KeyBoardAction Helper
	 */
	public void DoubleCommandKeyAction(String cmdKey1, String cmdKey2, String character) {
		Actions act = new Actions(Driver.Browser);

		act.keyDown(cmdKey1).keyDown(cmdKey2).sendKeys(character).keyUp(cmdKey2).keyUp(cmdKey1).build().perform();

	}

	/**
	 * Automate command and multiple key pressing action
	 * 
	 * @author Ravi Kota
	 * @param cmdKey     : Command Key
	 * @param character1 : Key 1
	 * @param character2 : Key 2
	 * @category KeyBoardAction Helper
	 */
	public void SingleCommandKeyAction(String cmdKey, String character1, String character2) {
		Actions act = new Actions(Driver.Browser);

		act.keyDown(cmdKey).sendKeys(character1).sendKeys(character2).keyUp(cmdKey).build().perform();
	}

}
