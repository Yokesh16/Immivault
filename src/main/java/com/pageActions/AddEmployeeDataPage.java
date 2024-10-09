package com.pageActions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.utility.UtilsActions;

public class AddEmployeeDataPage extends BaseClass {

	UtilsActions actions = new UtilsActions();

	public AddEmployeeDataPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[normalize-space(text())='Add Employee']")
	private WebElement addEmployeeButton;

	@FindBy(xpath = "//h5[contains(text(),'Add Employee Data')]")
	private WebElement addEmployeeDataText;

	public AddEmployeeDataPage addEmplpoyee() {

		try {
			new LogInPage().loginAccount();
			actions.click(addEmployeeButton);
			Thread.sleep(2000);
			String text = addEmployeeDataText.getText();
			System.out.println(text);

			assertEquals(text,"Add Employee Data");
		} catch (Exception e) {

			test.info("This is not an Add Employee Data Form");
		}
		return new AddEmployeeDataPage();

	}
}
