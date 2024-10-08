package com.pageActions;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.utility.UtilsActions;

public class LogInPage extends BaseClass {

	UtilsActions actions = new UtilsActions();

	public LogInPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Enter your username']")
	private WebElement enterYourUsername;

	@FindBy(id = "exampleInputPassword1")
	private WebElement enterYourPassword;

	@FindBy(id = "button_submit")
	private WebElement submitButton;

	@FindBy(xpath = "//span[text()='Companies']")
	private WebElement companies;
	
	@FindBy(xpath="//h5[contains(text(),'VWRS')]")
	private WebElement companyVWRS;
	
	public LogInPage loginAccount() {

		actions.sendKeys(properties.getProperty("username"), enterYourUsername);
		actions.sendKeys(properties.getProperty("password"), enterYourPassword);
		actions.click(submitButton);
		actions.click(companies);
		actions.click(companyVWRS);

		return new LogInPage();

	}
}
