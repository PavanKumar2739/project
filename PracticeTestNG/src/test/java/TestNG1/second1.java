package TestNG1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class second1 {
	WebDriver driver;
	String url="https://www.google.com/";
	@Test
	public void finding() throws Exception
	{
		driver.findElement(By.name("q")).sendKeys("Yuvaraj Singh" , Keys.ENTER);
		System.out.println(driver.getTitle());
	}
	@Test
	public void dohni() throws Exception
	{

		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("Dohni" , Keys.ENTER);
		System.out.println(driver.getTitle());
	}
	@Test
	public void kohli() throws Exception
	{
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("Virat Kohli" , Keys.ENTER);
		System.out.println(driver.getTitle());
	}
	@BeforeTest
	public void setup( ) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
		
		
	}
	@AfterTest
	public void quit()
	{
		//driver.quit();
	}

}
