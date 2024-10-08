package com.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;

public class UtilsActions extends BaseClass implements UtilsInterface {

	@Override
	public  void sendKeys(String value, WebElement element) {
		
		element.sendKeys(value);
		
	}

	@Override
	public void click(WebElement ele) {
		try {
			ele.click();
		} catch (Exception e) {
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			
			executor.executeScript("[arguments[0].click()]", ele);
		}
		
		
	}

	
		
		
		
	}


