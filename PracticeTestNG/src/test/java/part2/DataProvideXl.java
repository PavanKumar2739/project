package part2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvideXl {
	
		WebDriver driver;
		String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	  @Test(priority=1)
	  public void Url()
	  {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	 	 driver.get(url);
	 	 driver.manage().window().maximize();
	 	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 	 
	  }
	@DataProvider(name="dp")
	public  String[][] xlData() throws Exception  {
		
	
	File xlApp= new File("D:\\selenium\\excel\\forData.xlsx");
	System.out.println(xlApp.exists());
	FileInputStream file=new  FileInputStream(xlApp);
	XSSFWorkbook xlBook=new XSSFWorkbook(file);
	XSSFSheet xlSheet=xlBook.getSheet("Sheet1");
	//int count1=0;
	int row=xlSheet.getPhysicalNumberOfRows();
	System.out.println(row);
	int Sc=xlSheet.getLastRowNum();
	int col=xlSheet.getRow(0).getLastCellNum();
	System.out.println(col);
	String[][] data =new String [row-1][col];
	for (int i = 0; i < row-1; i++) {
		for (int j = 0; j < col; j++) {
			DataFormatter df=new DataFormatter();
			//System.out.println(df.formatCellValue(xlSheet.getRow(i).getCell(j)));
			data[i][j]=df.formatCellValue(xlSheet.getRow(i+1).getCell(j));
			 //System.out.println( xlSheet.getRow(i).getCell(j).toString());
			
		}
		
	}
	xlBook.close();
	file.close();
	return data;
//	for(String [] arr:data)
//	{
//		System.out.println(Arrays.toString(arr));
//
//	}
//	System.out.println(Sc);
	
} 
	@Test(dataProvider = "dp",dependsOnMethods="Url")
	public void method(String u ,String p) throws Exception 
	{
		 //System.out.println(u);
		  Thread.sleep(1000);
		  driver.findElement(By.name("username")).clear();
		  driver.findElement(By.xpath("//input[@name='password']")).clear();
		  driver.findElement(By.xpath("//input[@name='username']")).sendKeys(u);
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(p,Keys.ENTER);
		  System.out.println("Login");
		  String url2=driver.getCurrentUrl();
		  if(!(url==url2)){
			  driver.navigate().back();
		  }
	}
}