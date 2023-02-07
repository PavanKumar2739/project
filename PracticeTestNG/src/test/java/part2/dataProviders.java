package part2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dataProviders {
	WebDriver driver;
	String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
  @Test
  public void Url()
  {
	WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
 	 driver.get(url);
 	 driver.manage().window().maximize();
 	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
 	 
  }
  
  @Test(dataProvider = "login")
  public void login(String u,String p) throws Exception{
	  System.out.println(u);
	  Thread.sleep(1000);
	  driver.findElement(By.name("username")).clear();
	  driver.findElement(By.xpath("//input[@name='password']")).clear();
	  driver.findElement(By.xpath("//input[@name='username']")).sendKeys(u);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(p,Keys.ENTER);
	  System.out.println("Login");
	  String url2=driver.getCurrentUrl();
	  if(!(url==url2)){
		  driver.navigate().back();
	  }
			  
		  
     
  }
  @DataProvider(indices = {1,2}, name="login")
  public Object[][] loginData()
  {
	  Object[][] data=new Object[][] {
		  {"Admin",
	  "admin123"},
	  
		  {"Admin",
	 "Admin123"},
	  
	  {"admin",
	  "Admin123"},
			  
	  {"admin",
	  "Admin124"}};
	  return data;
  }
  
}
