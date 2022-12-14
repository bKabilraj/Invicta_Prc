package loginTestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {

	WebDriver driver;
	//03
	String [][] data= {
		{"Admin","admin123"},
		{"Admin","admin124"},
		{"abcdmin","admin123"},
		{"abcdmin","admin124"}
			
	};
	
	
	//02
	@DataProvider(name="loginData")
	public String[][] loginDataProvider () {
		
		return data; //04
	}
	
	
	//01
	@Test(dataProvider = "loginData") //05
	public void login_Scenario(String uName, String pWord) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\hp\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe\\");
		driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		
		WebElement userName=driver.findElement(By.name("username"));
		userName.sendKeys(uName);
		
		WebElement passWord=driver.findElement(By.name("password"));
		passWord.sendKeys(pWord);
		
		WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
		//driver.quit();
		
	}
}
