package testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class textBoxes {
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
		WebElement text=driver.findElement(By.id("userNumber"));
		text.sendKeys("Pavan Kumar");
		 System.out.println(driver.findElement(By.xpath("//div[@id='userName-wrapper']/div[1]")).isDisplayed());
		 
		System.out.println(text.getAttribute("value"));
		text.clear();
		System.out.println(text.getAttribute("type"));
		
				 
		  
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
