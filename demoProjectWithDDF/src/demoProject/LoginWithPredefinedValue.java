package demoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginWithPredefinedValue {
	
	
		String[][] data= {{"Admin","admin123"},
							{"Admin","dummy"},
							{"bava","dummy"},
							{"bava","admin123"}};
		
	
	@DataProvider(name="loginData")
	public String[][] LoginDataProvider() {
		return data ;
	}
	
	@Test(dataProvider = "loginData")
	public void LoginWithCorrectCredentials(String uName, String pWord) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\WebDrivers\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		Thread.sleep(2000);
		
		WebElement userName=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		userName.sendKeys(uName);
		
		WebElement passWord=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
		passWord.sendKeys(pWord);
		
		WebElement LoginButton=driver.findElement(By.xpath("//button"));
		LoginButton.click();
		
		driver.close();
	}
}
