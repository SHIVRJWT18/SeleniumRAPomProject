package CommonProjectUtiliites;

import org.testng.ITestResult;

import io.qameta.allure.Allure;

	public class AllureTestListenerUtility {

	    public void onTestStart(ITestResult result) {
	        System.out.println("Test Started: " + result.getName());
	    }

	    public void onTestSuccess(ITestResult result) {
	        System.out.println("Test Passed: " + result.getName());
	    }

	    public void onTestFailure(ITestResult result) {
	        System.out.println("Test Failed: " + result.getName());

	        if (result.getThrowable() != null) {
	            Allure.attachment(
	                "Failure Details",
	                result.getThrowable().toString()
	            );
	        }
	    }

	    public void onTestSkipped(ITestResult result) {
	        System.out.println("Test Skipped: " + result.getName());
	    }
	}

