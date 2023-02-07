package TestNG1;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EnableDisableTestCases {

	WebDriver driver;
     //String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
     @Parameters("browserName")  
     @BeforeTest
	 public void setup(String browserName) {
			switch (browserName.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("Browser name is invalid");
				break;
		}
   	  	 	  	
     }
     @Parameters("url")
     @Test
     public void url(String Url)
     {
    	 driver.get(Url);
    	 driver.manage().window().maximize();
    	 
     }
     @Parameters({"user","pass"})
     @Test
     public void login(String u,String p) throws Exception{
   	  Thread.sleep(1000);
   	  driver.findElement(By.xpath("//input[@name='username']")).sendKeys(u);
   	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(p,Keys.ENTER);
   	  System.out.println("Login");
     }
     @Test
     public void ThreeLInes() throws Exception{
   	  //driver.findElement(By.xpath("//i[@class='oxd-icon bi-list oxd-topbar-header-hamburger']")).click();
   	  driver.findElement(By.linkText("My Info")).click();
   	  System.out.println("ThreeLines");
     }
     @Test
     public void Details() {
   	  boolean b=driver.findElement(By.className("orangehrm-background-container")).isDisplayed();
         assertTrue(b,"It is false"); 
     
     }
     @Test
     public void Leave() throws Exception{
   	//  driver.findElement(By.xpath("//i[@class='oxd-icon bi-list oxd-topbar-header-hamburger']")).click();
   	  driver.findElement(By.linkText("Leave")).click();
   	  System.out.println("leave");
     }
     @Parameters("sleep")
     @Test
     public void quit1(String sleep) throws Exception{
    	 System.out.println(sleep);
    	 Thread.sleep(Long.valueOf(sleep));
    	 driver.quit();
     }
     @Parameters("sleep")
     @Test
     public void quit2(long sleep) throws Exception{
    	 System.out.println(sleep);
    	 Thread.sleep(sleep);
    	 driver.quit();
     }

}
