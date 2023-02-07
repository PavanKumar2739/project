package testing;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WinHan2 {
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
		driver.findElement(By.id("newTabBtn")).click();
		driver.findElement(By.id("newWindowsBtn")).click();
		Set <String> win=driver.getWindowHandles();
		int i=win.size();
		System.out.println(i);
		String []tabs=new String[i];
		int j=0;
		for(String tab : win)
		{
			tabs[j]=tab;
			j++;
		}
		String s=driver.getWindowHandle();
		driver.switchTo().window(tabs[1]);
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.switchTo().window(tabs[2]);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
	}

}
