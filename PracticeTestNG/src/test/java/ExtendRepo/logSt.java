package ExtendRepo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class logSt {
	public static void main(String[] args) {
		ExtentReports exReports=new ExtentReports();
		ExtentSparkReporter sR=new ExtentSparkReporter("report2Logs.html");
		exReports.attachReporter(sR);
		
		exReports.createTest("Test 1")
		.log(Status.PASS, "passed")
		.log(Status.INFO,"info")
		.log(Status.FAIL,"failed")
		.log(Status.SKIP, "Skiped")
		.log(Status.WARNING, "Warning");
		exReports.flush();
		
	}

}
//fail
//skip
//warning
//pass
//info take the preority according to this

