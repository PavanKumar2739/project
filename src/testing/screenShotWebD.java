package testing;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class screenShotWebD {

	 WebDriver driver;
	    String url="https://demoqa.com/date-picker";
		@Before
		public void setup() throws Exception{
			System.setProperty("webdriver.chrome.driver","D:\\selenium\\softwares\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.navigate().to(url);	
			driver.manage().window().maximize();  
			
		}
		@Test
		public void test() throws Exception {
			//File
			TakesScreenshot sh=((TakesScreenshot) driver);
	    	File sourceFile=sh.getScreenshotAs(OutputType.FILE);
	    	File destFile=new File("D:\\selenium\\ScreenShots\\img1.png");
	    	FileUtils.copyFile(sourceFile, destFile);
	    	
	    	TakesScreenshot sh1=(TakesScreenshot) driver;
	    	File sourceFile1=sh.getScreenshotAs(OutputType.FILE);
	    	File destFile1=new File("D:\\selenium\\ScreenShots\\img2.png");
	    	FileUtils.copyFile(sourceFile1, destFile1);
		}
}
