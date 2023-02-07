package testing;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class headLess {
	 WebDriver driver;
	    String url="https://demoqa.com/date-picker";
		@Before
		public void setup() throws Exception{
			System.setProperty("webdriver.chrome.driver","D:\\selenium\\softwares\\chromedriver_win32\\chromedriver.exe");
			//driver=new HtmlUnitDriver();
			//for chrome the actions we can see
			ChromeOptions option=new ChromeOptions();
			//FirefoxOptions optios=new FirefoxOptions();//for firefox
			//option.addArguments("headless");
			option.setHeadless(true);//it is not for firefox
			driver=new ChromeDriver(option);
			driver.navigate().to(url);	
			//driver.manage().window().maximize();  
			
		}
		@Test
		public void test() throws Exception {
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
		}

}
