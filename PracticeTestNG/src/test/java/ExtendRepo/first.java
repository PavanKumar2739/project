package ExtendRepo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class first {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExtentReports reports = new ExtentReports();
		ExtentSparkReporter sp=new ExtentSparkReporter("report1.html");
		reports.attachReporter(sp);
		
		ExtentTest test1=reports.createTest("Test 1");
		test1.pass("test is passed");
		
		ExtentTest test2=reports.createTest("Test 2");
		test1.log(Status.FAIL,"test is Fali");
		
		reports.createTest("Test 3").skip("test was skipped");
		
		reports.flush();
	}

}
