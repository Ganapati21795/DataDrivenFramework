package com.Besant.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.Besant.Utilities.TestUtil;
import com.Besant.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListeners extends TestBase implements ITestListener{
	/**
	   * Invoked each time before a test will be invoked. The <code>ITestResult</code> is only partially
	   * filled with the references to class, method, start millis and status.
	   *
	   * @param result the partially filled <code>ITestResult</code>
	   * @see ITestResult#STARTED
	   */
	  public  void onTestStart(ITestResult result) {
	    
		  test = rep.startTest(result.getName().toUpperCase());
		  //checking runmodes -Y
		  if(!TestUtil.isTestRunnable(result.getName(), excel)) {
			  throw new SkipException("Skipping the test"+result.getName().toUpperCase()+"as the Run Mode is NO");
		  }
	  }

	  /**
	   * Invoked each time a test succeeds.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS
	   */
	  public  void onTestSuccess(ITestResult result) {
	    
		  TestBase.test.log(LogStatus.PASS, result.getName().toUpperCase()+"PASS");
		  rep.endTest(test);
		  rep.flush();
	  }

	  /**
	   * Invoked each time a test fails.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#FAILURE
	   */
	  public  void onTestFailure(ITestResult result) {
		  TestBase.test.log(LogStatus.FAIL, result.getName().toUpperCase()+"Failed with exception"+result.getThrowable());
		  rep.endTest(test);
		  rep.flush();
	  }

	  /**
	   * Invoked each time a test is skipped.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SKIP
	   */
	  public void onTestSkipped(ITestResult result) {
	    test.log(LogStatus.SKIP, result.getName().toUpperCase()+"Skipped the test as the Run mode is NO");
	    rep.endTest(test);
		rep.flush();  
	  }

	  /**
	   * Invoked each time a method fails but has been annotated with successPercentage and this failure
	   * still keeps it within the success percentage requested.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
	   */
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	  /**
	   * Invoked each time a test fails due to a timeout.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   */
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	  /**
	   * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt;
	   * tag and calling all their Configuration methods.
	   *
	   * @param context The test context
	   */
	  public void onStart(ITestContext context) {
	    // not implemented
	  }

	  /**
	   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have
	   * run and all their Configuration methods have been called.
	   *
	   * @param context The test context
	   */
	  public void onFinish(ITestContext context) {
	    // not implemented
	  }
	

}
