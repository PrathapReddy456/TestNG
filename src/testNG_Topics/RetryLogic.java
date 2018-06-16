package testNG_Topics;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer {
	
	// This implemented in Products Class 
	int counter=0;
	int retrylimit=3;

	@Override
public boolean retry(ITestResult result) {
	if(counter<retrylimit) {
		counter++;
		return true;
	}
	
	return false;
}
	
}
