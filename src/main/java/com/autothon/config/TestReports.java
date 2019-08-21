package com.autothon.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
/**
 * 
 * @author bgovindaraj
 *
 */

public class TestReports implements ITestListener{

	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	Date dateobj = new Date();
	/**
	 * onTestStart
	 */
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName()+" started at : "+df.format(dateobj));
	}
	/**
	 * onTestSuccess
	 */
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName()+" passed.");
	}
	/**
	 * onTestFailure
	 */
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName()+" failed.");
		try{
			WebDriverConfig.takeSnapShot(result.getName().toString()+".jpeg");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * onTestSkipped
	 */
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName()+" skipped.");
	}

	/**
	 * onTestFailedButWithinSuccessPercentage
	 */
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName()+" failed partially.");
	}

	/**
	 * onStart
	 */
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println(context.getName()+" Tests started at : "+df.format(dateobj));
	}

	/**
	 * onFinish
	 */
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Tests passed are \n"+context.getPassedTests());
		System.out.println("Tests failed are \n"+context.getFailedTests());
	}

}