package com.utility;


import org.openqa.selenium.WebElement;

public interface UtilsInterface {

	
	public  void sendKeys(String value, WebElement element);
	public void click(WebElement ele);
	public void getText(WebElement ele);
	public void getAttribute(WebElement ele, String value);
}
