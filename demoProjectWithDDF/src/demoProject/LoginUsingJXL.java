package demoProject;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LoginUsingJXL {

	String[][] data=null;

	@DataProvider(name="loginData")
	public String[][] loginDataProvider() throws BiffException, IOException{

		data = getExcelData();
		System.out.println(data);
		return data;
	}

	public String[][] getExcelData() throws BiffException, IOException {
		
		FileInputStream excelFile = new FileInputStream("C:\\selenium\\rough notes\\LoginData.xls");
		Workbook wokbook = Workbook.getWorkbook(excelFile);
		Sheet sheet = wokbook.getSheet(0);

		int rowCount = sheet.getRows();
		int columnCount = sheet.getColumns();

		String testData[][] = new String[rowCount-1][columnCount];

		
		for(int i=1; i<rowCount; i++) {
			for(int j=0; j<columnCount; j++) {
				testData[i-1][j] = sheet.getCell(j, i).getContents();	
			}
		}
		return testData;
	}


	@Test (dataProvider = "loginData")
	public void demoLogin(String uName, String pWord) throws InterruptedException {

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
		
		Thread.sleep(2000);
		driver.close();

	}

}
