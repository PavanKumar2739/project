package ExtendRepo;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakingSS {
	static WebDriver driver;
public static void main(String[] args) throws Exception {
	ExtentReports extentReports =new ExtentReports();
	ExtentSparkReporter sp=new ExtentSparkReporter("report4SS.html");
	extentReports.attachReporter(sp);
	
	WebDriverManager.chromedriver().setup();
	driver =new ChromeDriver();
	driver.get("https://www.w3schools.com/java/default.asp");
	String b64=TakingSS.captureSS();
	String path=TakingSS.captureSS("ss1.jpg");
	
	Throwable t= new Throwable("some exception");
	extentReports.createTest("Screen shot1","here we can see screen shots")
	.info("information here")
	.addScreenCaptureFromBase64String(b64)
	.fail("base64 img1",MediaEntityBuilder.createScreenCaptureFromBase64String(b64,"ss1").build());
	
	extentReports.createTest("Screen shot2","here we can see screen shots")
	.info("information here")
	.addScreenCaptureFromBase64String(b64,"ss1")
	.addScreenCaptureFromBase64String(b64,"ss2")
	.addScreenCaptureFromBase64String(b64,"ss3")
	.addScreenCaptureFromBase64String(b64,"ss4");
	
	extentReports.createTest("Screen shot3","here we can see screen shots")
	.info("information here")
	.addScreenCaptureFromPath(path);
	
	extentReports.createTest("Screen shot4","here we can see screen shots")
	.info("information here")
	.addScreenCaptureFromPath(path,"ss1")
	.addScreenCaptureFromPath(path,"ss2")
	.addScreenCaptureFromPath(path,"ss3")
	.addScreenCaptureFromPath(path,"ss4")
	.fail("path image2" ,MediaEntityBuilder.createScreenCaptureFromPath(path,"ss1").build());

	
	extentReports.createTest("Screen shot5","here we can see screen shots")
	.info("information here")
	.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(b64).build())
	.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(b64,"ss1").build());
	
	extentReports.createTest("Screen shot6","here we can see screen shots")
	.info("information here")
	.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build())
	.fail(MediaEntityBuilder.createScreenCaptureFromPath(path,"ss1").build());
	
	extentReports.createTest("Screen shot7","here we can see screen shots")
	.info("information here")
	.fail("base64 img",MediaEntityBuilder.createScreenCaptureFromBase64String(b64).build())
	.fail("base64 img1",MediaEntityBuilder.createScreenCaptureFromBase64String(b64,"ss1").build());
	
	extentReports.createTest("Screen shot8","here we can see screen shots")
	.info("information here")
	.fail("path image1" ,MediaEntityBuilder.createScreenCaptureFromPath(path).build())
	.fail("path image2" ,MediaEntityBuilder.createScreenCaptureFromPath(path,"ss1").build());
	
	extentReports.createTest("Screen shot8","here we can see screen shots")
	.info("information here")
	.fail(t ,MediaEntityBuilder.createScreenCaptureFromPath(path).build())
	.fail(t ,MediaEntityBuilder.createScreenCaptureFromPath(path,"ss1").build());
	extentReports.flush();
	driver.quit();
}
public static String captureSS(String ss) throws Exception {
	TakesScreenshot s=(TakesScreenshot)driver;
	File s1=s.getScreenshotAs(OutputType.FILE);
	File file=new File("./screenShot/" +ss);
	FileUtils.copyFile(s1, file);
	return file.getAbsolutePath();
	
}
public static String captureSS() throws Exception {
	TakesScreenshot s=(TakesScreenshot)driver;
	String s1=s.getScreenshotAs(OutputType.BASE64);
	
	return s1;
	
}
}
