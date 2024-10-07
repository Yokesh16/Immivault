package com.pageActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class AddEmployeeDataPage extends BaseClass {

	
	public AddEmployeeDataPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "")
	private WebElement gfdg;
}
