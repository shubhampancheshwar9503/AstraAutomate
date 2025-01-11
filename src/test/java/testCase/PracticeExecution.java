package testCase;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PracticeExecution 
{
	@Test
	public void main() throws InterruptedException
	{
		Reporter.log("I Am In Practice Execution");
		Thread.sleep(2000);
	}
}
