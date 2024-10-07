package com.pageActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.utility.UtilsActions;

public class LogInPage extends BaseClass {
	public String username = "dsfdsf";
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

	public LogInPage loginAccount() {
//		

		System.out.println("Hi");
		actions.sendKeys(properties.getProperty("usernamer"), enterYourUsername);
		actions.sendKeys(properties.getProperty("password"), enterYourPassword);
		actions.click(submitButton);
		return new LogInPage();

	}
}
