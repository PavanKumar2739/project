package testing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v102.css.model.Value;
import org.openqa.selenium.support.ui.Select;

public class sortingList {
	 WebDriver driver;
	    String url="https://demoqa.com/date-picker";
		@Before
		public void setup() throws Exception{
			System.setProperty("webdriver.chrome.driver","D:\\selenium\\softwares\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.navigate().to(url);	
			driver.manage().window().maximize();  
			
		}
		@Test
		public void test() throws Exception {
			driver.findElement(By.id("datePickerMonthYearInput")).click();
			Select ddl=new Select(driver.findElement(By.xpath("//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select")));
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
				System.out.println(arr[i]);
				
				arr1[i]=l.getText();
				System.out.println(arr1[i]);
				i++;
			}
			List TempVal=new ArrayList(val);
			Collections.sort(TempVal);
			
			System.out.println(arr[1]);
			System.out.println(val);
			
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
