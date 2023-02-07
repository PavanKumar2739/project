package TestNG1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Third {
      WebDriver driver;
      String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
      @BeforeTest
      public void setup()
      {
    	  	WebDriverManager.chromedriver().setup();
    	  	driver=new ChromeDriver();
    	  	driver.get(url);
    	  	driver.manage().window().maximize();
      }
      @Test
      public void login() throws Exception{
    	  Thread.sleep(1000);
    	  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
    	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123",Keys.ENTER);
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
    	  System.out.println(driver.findElement(By.className("orangehrm-background-container")).isDisplayed());
           
      
      }
      @Test
      public void Leave() throws Exception{
    	//  driver.findElement(By.xpath("//i[@class='oxd-icon bi-list oxd-topbar-header-hamburger']")).click();
    	  driver.findElement(By.linkText("Leave")).click();
    	  System.out.println("leave");
      }
      
}
