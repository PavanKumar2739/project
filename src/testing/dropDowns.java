package testing;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropDowns {
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
			ddl.selectByIndex(0);
			System.out.println(driver.findElement(By.xpath("//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]")).getText());
			Thread.sleep(500);
			ddl.selectByValue("3");
			Thread.sleep(500);
			ddl.selectByVisibleText("August");
			List<WebElement> list1= ddl.getOptions();
			System.out.println(list1);
			int size=list1.size();
			System.out.println(size);
			for(int i=0;i<size;i++)
			{
				WebElement w=list1.get(i);
				String s=w.getText();
				if(s.contains("De"))
				{
					w.click();
					System.out.println(driver.findElement(By.xpath("//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]")).getText());
				}
			}
			
		}

}
