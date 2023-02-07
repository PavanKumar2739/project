package testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdeiverCom {

	WebDriver driver;
	String url="https://demoqa.com/automation-practice-form";
	@Before
	public void setup() throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, timeout);
		
	}
	@Test
    public void test() throws Exception{
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//driver.findElement(By.id("tabButton")).click();
		Thread.sleep(200);
		
		 System.out.println(driver.findElement(By.id("userNumber")).isDisplayed());
		 System.out.println(driver.findElement(By.xpath("//div[@id='userName-wrapper']/div[1]")).isDisplayed());
		
		 System.out.println(driver.findElement(By.id("gender-radio-1")).isEnabled());
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//div[@class='custom-control custom-radio custom-control-inline'][1]/label[1]")).click();
		 System.out.println(driver.findElement(By.id("gender-radio-1")).isSelected());
		 System.out.println(driver.findElement(By.id("gender-radio-3")).isSelected());
		 driver.findElement(By.id("uploadPicture")).sendKeys("D:\\Pictures\\CollageMaker_20210218_063123414.jpg");
		 driver.findElement(By.id("uploadPicture")).submit();
		 
		  
		 //driver.navigate().refresh();
//		driver.navigate().back();
//		Thread.sleep(1000);
//		driver.navigate().forward();
		
		
	}
	@After
	 public void Teardown() throws Exception{
		//driver.quit();
		
	}


}
