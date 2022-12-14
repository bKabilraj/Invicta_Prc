package loginTestCase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Login2 {

	
	//01
	String [][] data=null;
	WebDriver driver;
	

	@DataProvider(name="loginData")
	public String[][] loginDataProvider () throws BiffException, IOException {
		//09.
		data=getExcelData();
		//09..
		return data;
		
	}
	//02
	public String[][] getExcelData() throws BiffException, IOException {
		FileInputStream excel=new FileInputStream
				("C:\\Users\\hp\\Desktop\\Selenium_Learning\\jxl_Pratice\\New Microsoft Excel Worksheet.xls\\");
		Workbook workbook=Workbook.getWorkbook(excel);
		Sheet sheet=workbook.getSheet(0);
		
		//03
		int rowCount=sheet.getRows();
		int columnCount=sheet.getColumns();
		//04
		String testData[][]=new String[rowCount-1][columnCount];
		//05
		for (int i=1; i<rowCount; i++) {
			for (int j=0; j<columnCount; j++) {
				//06,//07
				testData[i-1][j]=sheet.getCell(j,i).getContents();
			}
		}
		//08
		return testData;
	}
	
	//11
	@BeforeTest
	//10
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\hp\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe\\");
		driver= new ChromeDriver();
	}
	
	//13
	@AfterTest
	//12
	public void afterTest() {
		driver.quit();
		
	}
	
	@Test(dataProvider = "loginData") 
	public void login_Scenario(String uName, String pWord) throws InterruptedException  {

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		
		WebElement userName=driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys(uName);
		
		WebElement passWord=driver.findElement(By.xpath("//input[@name='password']"));
		passWord.sendKeys(pWord);
		
		WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
		
		
	}
}
 