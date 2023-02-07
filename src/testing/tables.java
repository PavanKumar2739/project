package testing;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.collect.Table;

public class tables {

	 WebDriver driver;
	    String url="http://seleniumpractise.blogspot.com/";
		@Before
		public void setup() throws Exception{
			System.setProperty("webdriver.chrome.driver","D:\\selenium\\softwares\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.navigate().to(url);	
			driver.manage().window().maximize();  
			
		}
		@Test
		public void test() throws Exception {
			WebElement table=driver.findElement(By.id("customers"));
			List<WebElement> TR=table.findElements(By.tagName("tr"));
			int TR_count=TR.size();
			List<WebElement> TH=TR.get(0).findElements(By.tagName("th"));
			for(int k=0;k<TH.size();k++)
			{
				System.out.println(TH.get(k).getText());
			}
			for(int i=1;i<TR_count;i++)
			{
				List<WebElement> TD=TR.get(i).findElements(By.tagName("td"));
				
				for(int j=0;j<TD.size();j++)
				{
					System.out.println(TD.get(j).getText());
				}
			}
			
		}
}
