package part2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvider1 {
	WebDriver driver;
	String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
  @BeforeTest
  public void Url()
  {
	WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
 	 driver.get(url);
 	 driver.manage().window().maximize();
 	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
 	 
  }
  
  @Test(dataProvider = "Data",dataProviderClass = dataProvideClass.class)
  public void login(String[] u) throws Exception{
	  System.out.println(u);
	  Thread.sleep(1000);
//	  driver.findElement(By.xpath("//input[@name='username']")).clear();
//	  driver.findElement(By.xpath("//input[@name='password']")).clear();
//	  driver.findElement(By.xpath("//input[@name='username']")).sendKeys(u[0]);
//	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(u[1],Keys.ENTER);
	  System.out.println(u[0] + "  "+u[1]);
	  String url2=driver.getCurrentUrl();
	  if(!(url==url2)){
		  driver.navigate().back();
	  }
			  
		  
     
  }
  @DataProvider(name="login")
  public Object[][] loginData()
  {
	  Object[][] data=new Object[2][2];
	  data[0][0]="Admin";
	  data[0][1]="admin123";
	  
	  data[1][0]="Admin";
	  data[1][1]="Admin123";
	  
	  data[1][0]="admin";
	  data[1][1]="Admin123";
	  return data;
  }
//  @DataProvider//(indices = {3,1,2,5})
//	public Iterator<Object[]> Data()
//	{
//		Set<Object[]> data= new HashSet<>();
//		data.add(new Object[] {"Adm2in","admin123"});
//		data.add(new Object[] {"ADMIN","Admin123"});
//		data.add(new Object[] {"admin","admin123"});
//		data.add(new Object[] {"Admin",2423532});
//		data.add(new Object[] {"Admin","admin13"});
//		data.add(new Object[] {423423,"admin123"});
//		data.add(new Object[] {"Admin","dmin123"});
//		
//		return data.iterator();
//	}
	
}