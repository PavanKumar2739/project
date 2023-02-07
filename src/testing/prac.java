package testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class prac {
	
	WebDriver driver;
	String url="https://demoqa.com/browser-windows";
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
		driver.findElement(By.id("tabButton")).click();
		Thread.sleep(200);
		driver.navigate().to("http://fb.com");
		driver.findElement(By.name("email")).sendKeys("pavankumar2576525@gmail.com");
		System.out.println("pavan ");
		driver.findElement(By.name("pass")).sendKeys("Pavan@9676");
		Thread.sleep(2000);
		driver.findElement(By.name("pass")).sendKeys(Keys.F5); //not working in refresh
		driver.findElement(By.name("pass")).clear();
		System.out.println(driver.findElement(By.cssSelector("#content > div > div > div > div._8esl > h2")).getText());
		// System.out.println(driver.findElement(By.id));
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
