package testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class sotList1 {
	WebDriver driver;
	String url="https://demo.automationtesting.in/Register.html";
	//String url="https://demo.anhtester.com/basic-select-dropdown-demo.html";
    //String url="https://www.globalsqa.com/demo-site/select-dropdown-menu/";
	@Before
	public void setup() throws Exception{
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\softwares\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to(url);	
		driver.manage().window().maximize();  
		
	}
	@Test
	public void test() throws Exception {
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[contains(@class,'single')]//select")).click();
		//Select ddl=new Select(driver.findElement(By.xpath("//div[contains(@class,'single')]//select")));
		Select ddl=new Select(driver.findElement(By.id("Skills")));
		List<WebElement> list1= ddl.getOptions();
		int len=list1.size();
		String[]arr=new String[len];
		String[] arr1=new String[len];
         int i=0;
         System.out.println(arr.length);
         List val=new ArrayList();
		for(WebElement l:list1)
		{
			arr[i]=l.getText();
			val.add(l.getText());
			//System.out.println(arr[i]);
			
			arr1[i]=l.getText();
			//System.out.println(arr1[i]);
			i++;
		}
		List TempVal=new ArrayList(val);
		Collections.sort(TempVal);
		System.out.println(TempVal);
		
//		System.out.println(arr[1]);
     	System.out.println(val);
		//bolean
		if (val.equals(TempVal))
		{
			System.out.println("Correct order");
		}
		else
		{
			System.out.println("Not order");
		}
	}

}
//https://www.calculator.net/interest-calculator.html
