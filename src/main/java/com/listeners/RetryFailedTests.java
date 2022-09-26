package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class RetryFailedTests implements IRetryAnalyzer{
	private int counter = 0;
	private int retryLimint = 1;

	
	@Override
	public boolean retry(ITestResult result) {
		boolean value=false;
			if (PropertyUtlis.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
				value=counter<retryLimint;		
				counter++;
				System.out.println("Retrying " + result.getName() + " again and the count is " + (counter+1));
			}
		return value;		
	}
}
