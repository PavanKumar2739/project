package TestNG_FrameWork;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mouse$Keyboard {
	WebDriver driver;
	String url = "https://demo.automationtesting.in/Register.html";

	@Before
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10, timeout);

	}

	@Test
	public void test() throws Exception {

		Actions act = new Actions(driver);
		WebElement name = driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input"));
		act.keyDown(name, Keys.SHIFT).sendKeys("pavan").build().perform();
		// act.keyDown(name,Keys.SHIFT).build().perform();
		WebElement ac1 = driver
				.findElement(By.xpath("//div[@class='navbar-collapse collapse navbar-right']/ul/li[6]/a"));
		WebElement Child_ac2 = driver
				.findElement(By.xpath("//div[@class='navbar-collapse collapse navbar-right']/ul/li[6]/ul/li[1]/a"));
		WebElement Child_click1 = driver
				.findElement(By.xpath("//div[@class='navbar-collapse collapse navbar-right']/ul/li[6]//li[1]//li[2]"));

//		 act.moveToElement(ac1).build().perform();
//		 act.moveToElement(Child_ac2).build().perform();
//		 Child_click1.click();
		act.moveToElement(ac1).moveToElement(Child_ac2).moveToElement(Child_click1).click().build().perform();

	}

}
