package TestNG1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertions {
	WebDriver driver;
	String url = "https://www.facebook.com/";

	@BeforeTest
	public void setup() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();

	}

	@Test
	public void fb() throws Exception{
		driver.findElement(By.name("email")).sendKeys("pa");
		driver.findElement(By.name("pass")).sendKeys("",Keys.ENTER);
		Thread.sleep(2000);
		
		SoftAssert softAss=new SoftAssert();
		
		String actualTittle=driver.getTitle();
		System.out.println(actualTittle);
		String expectedTittle="Log in to Facebook";
		softAss.assertEquals(actualTittle, expectedTittle,"give uername correct");
		//url
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.facebook.com/" ;
		softAss.assertEquals(actualUrl, expectedUrl,"given url correct");
		
		//text Assertion
		String actualText=driver.findElement(By.id("email")).getAttribute("value");
		String expectedText="pavan" ;
		softAss.assertEquals(actualText, expectedText,"given text correct");
		//border
		
		String actualBorder=driver.findElement(By.id("email")).getCssValue("border");
		String expectedBorder="1px solid rgb(240, 40, 73)" ;
		softAss.assertEquals(actualBorder, expectedBorder,"given border correct");
		
		//error message
		String actualError=driver.findElement(By.xpath("//div[starts-with(@class,'_9ay7')]")).getText();
		String expectedError="The email address or mobile number you entered isn't connected to an account. " ;
		softAss.assertEquals(actualError, expectedError,"given error is not correct");
		
		softAss.assertAll();
	}

}
