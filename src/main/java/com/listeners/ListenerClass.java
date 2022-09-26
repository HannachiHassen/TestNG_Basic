package com.listeners;

import static com.enums.LogType.*;
import static com.reports.FrameworkLogger.log;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public final class ListenerClass implements ITestListener, ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initReports();
		System.out.println("before suite in listener");
	}

	/**
	 * Terminate the reports
	 * @see com.tmb.reports.ExtentReport
	 */
	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.flushReports();
		System.out.println("after suite in listener");
	}

	/**
	 * Starts a test node for each TestNG test
	 * @see com.tmb.reports.ExtentReport
	 * @see com.tmb.annotations.FrameworkAnnotation
	 */
	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
		ExtentReport.addDevices(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).device());
		System.out.println("before method in listener");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log(PASS,result.getMethod().getMethodName()+" is Passed");
		System.out.println("after method in listener : pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//ExtentLogger.fail(result.getMethod().getMethodName() + " is Failed", true);		
		log(FAIL, result.getMethod().getMethodName()+ " is Failed");
		log(FAIL, result.getThrowable().toString());
		log(FAIL, Arrays.toString(result.getThrowable().getStackTrace()));
		System.out.println("after method in listener : fail and I am attaching screenshots here");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log(SKIP, result.getMethod().getMethodName()+ " is Skipped");
		System.out.println("after method in listener : skipped and ignored");
	}
	
    
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		/*
		 * For now, we are not using this.
		 */
	}

	@Override
	public void onStart(ITestContext context) {
		/*
		 * We are having just one test in our suite. So we dont have any special implementation as of now
		 */
	}

	@Override
	public void onFinish(ITestContext context) {
		/*
		 * We are having just one test in our suite. So we dont have any special implementation as of now
		 */
	}
}
