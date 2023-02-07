package testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class msXl {

	 WebDriver driver;
	    String url="https://www.hyrtutorials.com/p/add-padding-to-containers.html";
		@Before
		public void setup() throws Exception{
			System.setProperty("webdriver.chrome.driver","D:\\selenium\\softwares\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.navigate().to(url);	
			driver.manage().window().maximize();  
			
		}
		@Test
		public void test() throws Exception {
			File f=new File("D:\\selenium\\excel\\*");
			//System.out.println(f.);
			FileInputStream xlApp= new FileInputStream("D:\\selenium\\excel\\prac.xlsx");
			System.out.println("sheet available"+xlApp.available());
			XSSFWorkbook xlBook=new XSSFWorkbook(xlApp);
			XSSFSheet xlSheet=xlBook.getSheet("Sheet1");
			int count1=0;
			DataFormatter df = new DataFormatter();
			
			int Sc=xlSheet.getLastRowNum();
			System.out.println(Sc);
			for(int i=1;i<=Sc;i++) {
				count1++;
				System.out.println("Counting : "+count1);
				String country=df.formatCellValue(xlSheet.getRow(i).getCell(0));
				String Sal=df.formatCellValue(xlSheet.getRow(i).getCell(1));
				//String Sal=String.valueOf(xlSheet.getRow(i).getCell(1).getNumericCellValue());
				
				WebElement table=driver.findElement(By.id("contactList"));
				List<WebElement> TR =table.findElements(By.tagName("tr"));
				int count=TR.size();
				System.out.println(count);
				for(int j=1;j<count;j++)
				{
					int p=j+1;
					List<WebElement> TD=TR.get(j).findElements(By.tagName("td"));
					String Country=TD.get(2).getText();
					String Sal1=TD.get(3).getText();
					
					String win=driver.getWindowHandle();
					//System.out.println(win);
					System.out.println(Sal1+ " "+Sal);
					System.out.println(Country+ " "+country);
					if(Country.equals(country)&&Sal.equals(Sal1))
					{
						Thread.sleep(2000);
						table.findElement(By.xpath("//table[@id='contactList']//tr["+p+"]//td/input")).click();
						Thread.sleep(2000);
						table.findElement(By.xpath("//table[@id='contactList']//tr["+p+"]//td/a")).click();
						Thread.sleep(2000);
						
						//String win1=driver.getWindowHandle();
						//System.out.println(win1);
						String url1=driver.getCurrentUrl();
						
					     driver.navigate().back();	
					     
						Row R=xlSheet.getRow(i);
						Cell C=R.createCell(2);
						C.setCellValue("Success");
						FileOutputStream Fileout=new FileOutputStream("D:\\selenium\\excel\\prac.xlsx");
					    xlBook.write(Fileout);
					    break;
					
					}
					
					Row R=xlSheet.getRow(i);
					Cell C=R.createCell(2);
					C.setCellValue("FAIL");
					FileOutputStream Fileout=new FileOutputStream("D:\\selenium\\excel\\prac.xlsx");
				    xlBook.write(Fileout);
				}
				
			
				
				
			}
			xlBook.close();
			
		}
}
