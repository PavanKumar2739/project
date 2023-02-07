package TestNG1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class first {

	WebDriver driver;
	String url="https://demoqa.com/alerts";
	@Test
	public void test() throws Exception{
		
		driver.findElement(By.id("alertButton")).click();
		
		Alert alt=driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
	}
	@Test
	public void test1() throws Exception{
		
		driver.findElement(By.id("alertButton")).click();
		
		Alert alt=driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
	}

	@BeforeTest
	public void setup() throws Exception{
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\softwares\\chromedriver_win32\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		
	}
}
