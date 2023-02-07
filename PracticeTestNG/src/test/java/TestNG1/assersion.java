package TestNG1;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class assersion {
	WebDriver driver;
	String url="https://www.google.com/";
	@Test
	public void finding() throws Exception
	{
		driver.findElement(By.name("q")).sendKeys("Yuvaraj Singh" , Keys.ENTER);
		String tittle=driver.getTitle();
		String Expected ="Yuvaraj Singh - Google Searchh";
		assertNotEquals(tittle, Expected,"it is same");
		assertEquals(tittle, Expected,"not same");
		assertTrue(false);
		
		//Assert.assertEquals(tittle,Expected);
		System.out.println(tittle);
	}
	@BeforeTest
	public void setup( ) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
		
		
	}


}
