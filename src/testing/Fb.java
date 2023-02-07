package testing;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fb {
	WebDriver driver;
	String url="https://www.facebook.com/";
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
		Thread.sleep(1000);
		//driver.findElement(By.partialLinkText("Create ")).click();
		
		Thread.sleep(500);
		//driver.findElement(By.cssSelector("#u_c_g_G\\+")).sendKeys("23435345");
		driver.findElement(By.name("email")).sendKeys("pavankumar2576525@gmail.com");
		System.out.println("pavan ");
		driver.findElement(By.name("pass")).sendKeys("Pavan@9676");
		Thread.sleep(500);
		System.out.println(driver.findElement(By.id("email")).getAttribute("value"));
		System.out.println(driver.findElement(By.id("pass")).getAttribute("value"));
       // driver.findElement( By.linkText("Log In")).click();
        
//        driver.findElement(By.name("email")).sendKeys("pavankumar2576525@gmail.com");
//		System.out.println("pavan ");
//		driver.findElement(By.name("pass")).sendKeys("Pavan@9676");
//		Thread.sleep(500);
//        driver.findElement( By.linkText("Log In")).click();
	}

}
