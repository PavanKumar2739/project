package testing;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
public class AlertBoxes {
    WebDriver driver;
    String url="https://demoqa.com/alerts";
	@Before
	public void setup() throws Exception{
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\softwares\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to(url);
		
		driver.manage().window().maximize();  
		
	}
	@Test
	public void test() throws Exception {

		driver.findElement(By.id("alertButton")).click();
		//storing alert element in Alert datatype
		Alert alert= driver.switchTo().alert();
		Thread.sleep(500);
		alert.accept();
		Thread.sleep(500);
		driver.findElement(By.id("confirmButton")).click();
		//get the text in alert box
		System.out.println(alert.getText());
		
		Thread.sleep(500);
		alert.dismiss();
		System.out.println(driver.findElement(By.id("confirmResult")).getText());
	
		Thread.sleep(500);
		//passing keys in alert
		driver.findElement(By.id("promtButton")).click();
		alert.sendKeys("Pavan");
		alert.accept();
		System.out.println(driver.findElement(By.id("promptResult")).getText());
		
		
		
	}
}
