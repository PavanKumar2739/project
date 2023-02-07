package testing;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TablesH {
	 WebDriver driver;
	    String url="http://seleniumpractise.blogspot.com/";
		@Before
		public void setup() throws Exception{
			System.setProperty("webdriver.chrome.driver","D:\\selenium\\softwares\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.navigate().to(url);	
			driver.manage().window().maximize();  
			
		}
		public String space(int len)
		{   String space=" ";
			for(int i=0;i<25-len;i++)
			{
				space=" "+space;
			}
			return space;
		}
		@Test
		public void test() throws Exception {
			
			WebElement table=driver.findElement(By.id("customers"));
			List<WebElement> TR=table.findElements(By.tagName("tr"));
			int TR_count=TR.size();
			List<WebElement> TH=TR.get(0).findElements(By.tagName("th"));
			
			System.out.println( TH.get(1).getText()+space(TH.get(1).getText().length()) +TH.get(2).getText()+space(TH.get(2).getText().length())+TH.get(3).getText()+space(TH.get(3).getText().length())+TH.get(4).getText());
		System.out.println( );
			for(int i=1;i<TR_count;i++)
			{
				List<WebElement> TD=TR.get(i).findElements(By.tagName("td"));
				
				String[] s=TD.get(4).getText().split("");
				String[] s1=TD.get(3).getText().split("");
				String company=TD.get(1).getText();
				String country=TD.get(3).getText();
				String contact=TD.get(2).getText();
				String Action =TD.get(4).getText();
			    System.out.println(company+space(TD.get(1).getText().length())+contact+space(TD.get(2).getText().length())+country+space(TD.get(3).getText().length())+Action+space(TD.get(1).getText().length()));
			    if(country.contains("USA"))
			    {
			    	TD.get(0).findElement(By.tagName("input")).click();
			    }
					
				
			}
			List<WebElement> TD=table.findElements(By.xpath("//*[@id='customers']/tbody/tr[2]/td"));
			List<WebElement> TD1=table.findElements(By.xpath("//*[@id='customers']/tbody//td"));
			
			for(int i=2;i<TR_count;i++)
			{
				

				System.out.println(TD1.size());
				String company=driver.findElement(By.xpath("//*[@id='customers']/tbody/tr["+i+"]/td[2]")).getText();
				System.out.println(company);
				String country=table.findElement(By.xpath("//*[@id='customers']/tbody/tr["+i+"]/td[4]")).getText();
				String contact=driver.findElement(By.xpath("//*[@id='customers']/tbody/tr["+i+"]/td[3]")).getText();
				WebElement Action =driver.findElement(By.xpath("//*[@id='customers']/tbody/tr["+i+"]/td[5]"));
			   
			    if (company.contains("O"))
			    {
			    	Action.findElement(By.tagName("a")).click();		    	
			    	
			    }
			    Thread.sleep(1000);
			   String url1= driver.getCurrentUrl();
			   System.out.println(url1);
			   if(!(url1.contains(url)))
			   {
				   driver.navigate().back();
			   }
			   System.out.println(country);
			   
			   Thread.sleep(1000);
			   if(country.contains("Bangalore"))
			    {
				   System.out.println(country);
				   driver.findElement(By.xpath("//*[@id='customers']/tbody/tr["+i+"]/td[1]/input")).click();
			    }
					
				
			}
			
		}
}



