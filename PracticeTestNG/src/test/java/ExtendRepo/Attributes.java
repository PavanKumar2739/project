package ExtendRepo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Attributes {

	public static void main(String[] args) {
		ExtentReports reports=new ExtentReports();
		ExtentSparkReporter sp =new ExtentSparkReporter("report5Attribues.html");
		
		reports.attachReporter(sp);
		
		reports.createTest("test1 ", "reports has created")
		.assignAuthor("pavan")
		.assignCategory("Smoke Test")
		.assignDevice("Chrome");
		
		reports.createTest("test2 ", "reports has created")
		.assignAuthor("pavan")
		.assignCategory("Sanity")
		.assignDevice("Chrome")
		.assignAuthor("Chanda")
		.assignCategory("Regression")
		.assignDevice("Chrome")
		.fail("test is faild");
		
		reports.createTest("test3 ", "reports has created")
		.assignDevice("Chrome","firefox")
		.assignAuthor("pavan","Chanda","yuvi")
		.assignCategory("Sanity","Regression")
		
		.fail("test is faild");
		
		reports.createTest("test4 ", "reports has created")
		
		.assignCategory("Smoke Test","Regression")
		.assignAuthor("kumar","Chanda","yuvi")
		.assignDevice("Chrome","edge");
		
		reports.flush();

	}

}
