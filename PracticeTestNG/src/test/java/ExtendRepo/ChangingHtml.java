package ExtendRepo;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChangingHtml {

	public static void main(String[] args) throws Exception {
		ExtentReports reports=new ExtentReports();
		ExtentSparkReporter sp =new ExtentSparkReporter("report7Exe.html");
		ExtentSparkReporterConfig config=sp.config();
//		config.setTheme(Theme.DARK);
//		config.setReportName("reports");
//		sp.config().setDocumentTitle("Doc Tittle");
//		sp.config().setTimeStampFormat("dd-MM-yyyy hh:mm");
//		sp.config().setCss(".badge-primary {background-color:#0cef5e}");
//		sp.config().setJs("document.getElementsByClassName('logo')[0].style.display='None'");
		
		//for finding browser properties
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		Capabilities cap= ((RemoteWebDriver) driver).getCapabilities();
		
		sp.loadJSONConfig(new File("D:\\selenium\\Java1\\PracticeTestNG\\resources\\config_sparkReport.json"));
		//System.getProperties().list(System.out); return all the properties
		reports.setSystemInfo("OS", System.getProperty("os.name"));
		reports.setSystemInfo("Java Version", System.getProperty("java.version"));
		reports.setSystemInfo("Browser", cap.getBrowserName()+" "+cap.getBrowserVersion() );
		reports.setSystemInfo("App URL", "www.google.com");
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
		driver.quit();
		reports.flush();

	}

}
