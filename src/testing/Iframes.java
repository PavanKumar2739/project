package testing;

import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Iframes<WebElements> {

	WebDriver driver;
    String url="https://www.hyrtutorials.com/p/frames-practice.html";
	@Before
	public void setup() throws Exception{
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\softwares\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to(url);
		
		driver.manage().window().maximize();  
		
	}
	@Test
	public void test() throws Exception {
//		System.out.println(driver.findElement(By.xpath("//*[@id=\"framesWrapper\"]/div[1]")).getText());
//		System.out.println(driver.findElement(By.xpath("/html/body")).getText()); 
//		int frame=driver.findElements(By.tagName("iframe")).size();
//		System.out.println(frame);
		driver.switchTo().frame("frm1");
		System.out.println(driver.findElement(By.xpath("//*[@id=\"Blog1\"]/div[1]/div/div[1]/div[1]/div/h1")).getText());
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame("frm2");
		driver.findElement(By.name("fName")).sendKeys("pavan kumar");
		System.out.println(driver.findElement(By.xpath("//*[@id=\"post-body-7593811851313663875\"]/div/div/h1")).getText());
		driver.switchTo().parentFrame();
		driver.switchTo().frame("frm3");
	    Select ddl=new Select(driver.findElement(By.id("selectnav1")));
	    ddl.selectByIndex(3);
	    List<WebElement> optt=ddl.getOptions();
	    System.out.println(optt.get(3).getText());
	    driver.switchTo().frame("frm2");
	    Thread.sleep(5000);
	    //driver.findElement(By.id("femalerb")).click();
	    System.out.println(driver.findElement(By.xpath("//*[@id=\"Blog1\"]/div[1]/div/div[1]/div[1]/div")).getText());
	    driver.switchTo().parentFrame();
	    driver.switchTo().frame("frm1");
	    System.out.println(driver.findElement(By.xpath("//*[@id=\"Blog1\"]/div[1]/div/div[1]/div[1]/div/h1")).getText());
	    driver.switchTo().defaultContent();
	    System.out.println(driver.findElement(By.xpath("//*[@id=\"post-body-3126553095830633702\"]/div[4]/div[1]/p[2]")).getText());
	    System.out.println("psdfsd");
	    
	    
	    
	    		
	}
		
//	String i=link.getText();
//	WebElement j=links.get(i);
//	String =j.getAttribute("href")
//	System.out.println(j);
//	System.out.println(j);
//	
//	URL url=new URL(j);
}
