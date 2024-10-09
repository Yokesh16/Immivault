package com.testCases;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageActions.AddEmployeeDataPage;


public class AddEmployeeDataRunner extends BaseClass {
 
	
	@Test(description = "Account login")
	public void addEmployeeTitle() {
		new AddEmployeeDataPage().addEmplpoyee();
	
		
	}
}
