package testing;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class screenShot {
	ChromeDriver driver;
	String url="https://www.hyrtutorials.com/p/window-handles-practice.html";
	@Before
	public void setup() throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
    @Test
	public void test() throws Exception {
    	//File
    	File sourceFile=driver.getScreenshotAs(OutputType.FILE);
    	File destFile=new File("D:\\selenium\\ScreenShots\\img1.png");
    	FileUtils.copyFile(sourceFile, destFile);
       
    	//Bytes
    	driver.findElement(By.id("newTabBtn")).click();
    	Thread.sleep(1000);
    	byte[] byteArray=driver.getScreenshotAs(OutputType.BYTES);
    	File destFile1=new File("D:\\selenium\\ScreenShots\\img2.png");
    	FileOutputStream fos=new FileOutputStream(destFile1);
    	fos.write(byteArray);
    	//Bytes
    	driver.findElement(By.id("newTabBtn")).click();
    	Thread.sleep(1000);
    	String b64=driver.getScreenshotAs(OutputType.BASE64);
    	byte[] byteArray1=Base64.getDecoder().decode(b64);
    	File destFile2=new File("D:\\selenium\\ScreenShots\\img3.png");
    	FileOutputStream fos1=new FileOutputStream(destFile2);
    	fos1.write(byteArray1);

    }

}
