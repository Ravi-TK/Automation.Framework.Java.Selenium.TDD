package com.AutomationFramework.ComponentHelpers.Interfaces;

public interface KeyBoardActionHelper {

	  void SingleCommandKeyAction(String cmdKey, String character);

      void DoubleCommandKeyAction(String cmdKey1, String cmdKey2, String character);

      void SingleCommandKeyAction(String cmdKey, String character1, String character2);
}
