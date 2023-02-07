package testing;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mouse$KeyBoardEvents {
	WebDriver driver;
	String url="https://demoqa.com/droppable";
	//String url="http://www.dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html";
	@Before
	public void setup() throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, timeout);
		
	}
	@Test
    public void test() throws Exception{
		//driver.switchTo()
		
		WebElement source =driver.findElement(By.id("draggable"));
		WebElement desti =driver.findElement(By.id("droppable"));
		Thread.sleep(1000);
		Actions act=new Actions(driver);
		//act.clickAndHold(source).moveToElement(desti).release(desti).build().perform();
	     act.dragAndDrop(source, desti).build().perform();
		System.out.println(driver.findElement(By.id("droppable")).getText());
		
	}

}
