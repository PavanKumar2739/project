package testing;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WinHandile {
WebDriver driver;
String url="https://www.hyrtutorials.com/p/window-handles-practice.html";
@Before
public void setup() throws Exception{
	System.setProperty("webdriver.chrome.driver", "D:\\selenium\\softwares\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(10, tim0Unit);
	
}
@Test
public void test() throws Exception{
	//handling single tab
	driver.findElement(By.id("newWindowBtn")).click();
	Set <String> win=driver.getWindowHandles();
	String s=driver.getWindowHandle();
	driver.switchTo().window(s);
	for(String W:win) {
		if(!(W.equals(s)))
		{
			driver.switchTo().window(W);
			driver.manage().window().maximize();
			driver.findElement(By.id("firstName")).sendKeys("pavan kumar");
			System.out.println(driver.findElement(By.xpath("//*[@id=\"post-body-7593811851313663875\"]/div/div/h1")).getText());
			
		}
		System.out.println(W);
	}
		driver.switchTo().window(s);
		System.out.println(driver.findElement(By.name("name")).getText());
		driver.findElement(By.id("newTabBtn")).click();
		Set <String> win1=driver.getWindowHandles();
		for(String W1:win1) {
			if(!(W1.equals(s)))
			{
				driver.switchTo().window(W1);
				driver.manage().window().maximize();
				driver.findElement(By.id("alertBox")).click();
				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();
				System.out.println(driver.findElement(By.xpath("//*[@id='post-body-2252040019981508971']/div/h1")).getText());
			}
		System.out.println(W1);
		
		}
	}
	
	
	
	
}
