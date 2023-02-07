package testing;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class hyperLinks {

	WebDriver driver;
    String url="https://demo.guru99.com/test/newtours/";
	@Before
	public void setup() throws Exception{
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\softwares\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to(url);
		
		driver.manage().window().maximize();  
		
	}
	@Test
	public void test() throws Exception {
	List<WebElement> links=	driver.findElements(By.tagName("a"));
	int size=links.size();
	System.out.println(size);
	for(WebElement link:links)
	{
 		String i=link.getText();
		String j=link.getAttribute("href");
		System.out.println(i);
		System.out.println(j);
		
		URL url=new URL(j);
		
		HttpURLConnection http=(HttpURLConnection)url.openConnection();
		http.connect();
		int rescode =http.getResponseCode();
		
		if(rescode>=400)
		{
			System.out.println(url+ " ----> broken");
			
		}
		else
			System.out.println(url+ " ----> valid");
		   
	}
	}

}
