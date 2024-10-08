package com.testCases;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageActions.LogInPage;

public class AddEmployeeDataPage extends BaseClass {
 
	
	@Test(description = "Account login")
	public void logInApplication() {
		new LogInPage().loginAccount();
	
		
	}
}
