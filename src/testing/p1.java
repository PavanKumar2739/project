package testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class p1 {

	public static void main(String[] args) {
		// to set path executable driver
		
        System.setProperty("webdriver.chrome.driver" , "D:\\selenium\\softwares\\chromedriver_win32\\chromedriver.exe");
        
		//webdriver is parrent and chrome is child,(firefox,elplorer)
        WebDriver d1= new ChromeDriver(); 
        
        d1.get("https://www.youtube.com/watch?v=1PtEYqjj-xM");
       System.out.println(d1.getTitle()); 
       d1.quit();//close the browser
	}

}
