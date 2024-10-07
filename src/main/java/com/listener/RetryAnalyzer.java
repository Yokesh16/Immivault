package com.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int failureCount = 0;
	int limit = 1;
	
	
	@Override
	public boolean retry(ITestResult result) {
		while(failureCount<limit) {
			
			failureCount++;
			return true;
		}
			
		return false;
	}

}
